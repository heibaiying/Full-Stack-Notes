package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class ChatClient {

	private String hostname;
	private int port;
	private Selector selector;
	private final ByteBuffer rBuffer = ByteBuffer.allocate(1024);
	private final ByteBuffer wBuffer = ByteBuffer.allocate(1024);

	ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void start() {
		try {
			// 创建SocketChannel
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress(hostname, port));

			// 创建selector
			selector = Selector.open();
			// 注册监听CONNECT事件
			socketChannel.register(selector, SelectionKey.OP_CONNECT);

			// 持续调用select
			while (true) {
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				for (SelectionKey selectionKey : selectionKeys) {
					// 处理Connect事件
					if (selectionKey.isConnectable()) {
						SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
						// 有可能正处于连接中的状态
						if (clientChannel.isConnectionPending()) {
							// 等待连接完成
							clientChannel.finishConnect();
							// 开始监听用户输入
							inputListening(clientChannel);
							// 为clientChannel注册上Read
							clientChannel.register(selector, SelectionKey.OP_READ);
							System.out.println("尊敬的用户" + clientChannel.socket().getLocalPort() + ", 你已成功加入群聊！");
						}
						// 处理Read事件
					} else if (selectionKey.isReadable()) {
						handleMessage(selectionKey);
					}
				}
			}
		} catch (ClosedSelectorException e) {
			// 主动关闭客户端，不做任何处理
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 监听用户来自控制台的输入
	 *
	 * @param clientChannel 客户端Channel
	 */
	private void inputListening(SocketChannel clientChannel) {
		// 要持续监听用户输入，但又不能阻塞主线程，所以需要一个单独的线程来完成
		new Thread(() -> {
			Scanner scanner = new Scanner(System.in);
			try {
				while (scanner.hasNextLine()) {
					String input = scanner.nextLine();
					if (!input.isEmpty()) {
						if ("exit".equals(input)) {
							selector.close();
							return;
						}
						wBuffer.put(input.getBytes());
						wBuffer.flip();
						while (wBuffer.hasRemaining()) {
							clientChannel.write(wBuffer);
						}
						wBuffer.clear();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	/**
	 * 处理来自其他客户端的消息
	 *
	 * @param selectionKey 处于Read状态的selectionKey
	 */
	private void handleMessage(SelectionKey selectionKey) {
		try {
			SocketChannel channel = (SocketChannel) selectionKey.channel();
			StringBuilder buffer = new StringBuilder();
			while (channel.read(rBuffer) > 0) {
				rBuffer.flip();
				buffer.append(StandardCharsets.UTF_8.decode(rBuffer));
				rBuffer.clear();
			}
			System.out.println(buffer.toString());
		} catch (IOException e) {
			selectionKey.cancel();
			selector.wakeup();
			System.out.println("聊天室服务器已关闭！");
		}
	}


	public static void main(String[] args) {
		new ChatClient("127.0.0.1", 8888).start();
	}
}
