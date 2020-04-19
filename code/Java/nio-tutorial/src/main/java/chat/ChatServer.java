package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class ChatServer {

	private String hostname;
	private int port;
	private Selector selector;
	private final ByteBuffer rBuffer = ByteBuffer.allocate(1024);
	private final ByteBuffer wBuffer = ByteBuffer.allocate(1024);

	ChatServer(int port) {
		this("127.0.0.1", port);
	}

	ChatServer(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void start() {
		try {
			// 创建ServerSocketChannel
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			// 设置为非阻塞模式
			serverChannel.configureBlocking(false);
			serverChannel.bind(new InetSocketAddress(hostname, port));

			// 创建selector
			selector = Selector.open();
			// 注册监听CONNECT事件
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);

			// 持续调用select()
			while (true) {
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				for (SelectionKey selectionKey : selectionKeys) {
					// 处理Accept事件
					if (selectionKey.isAcceptable()) {
						// 获取ServerSocketChannel
						ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
						// 通过ServerSocketChannel获取SocketChannel
						SocketChannel clientChannel = server.accept();
						clientChannel.configureBlocking(false);
						// 注册Read事件
						clientChannel.register(selector, SelectionKey.OP_READ);
						System.out.println("欢迎" + clientChannel.socket().getPort() + "加入聊天室！");
						// 处理Readable事件
					} else if (selectionKey.isReadable()) {
						handleMessage(selectionKey);
					}
				}
				selectionKeys.clear();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭selector后，与之相关的所有资源都会被释放
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 处理客户端消息
	 *
	 * @param selectionKey 处于Read状态的SelectionKey
	 */
	private void handleMessage(SelectionKey selectionKey) {
		SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
		try {
			// 获取来自客户端的消息
			StringBuilder buffer = new StringBuilder();
			while (clientChannel.read(rBuffer) > 0) {
				rBuffer.flip();
				buffer.append(StandardCharsets.UTF_8.decode(rBuffer));
				rBuffer.clear();
			}
			String msg = buffer.toString();
			// 将消息发送给其他客户端
			broadcastMessage(clientChannel, msg);
		} catch (IOException e) {
			// 该异常由clientChannel.read(rBuffer)方法抛出，如果出现该异常，则说明clientChannel已经关闭
			// 此时需要调用cancel()取消注册在selector上的事件
			selectionKey.cancel();
			// 在多线程环境下，如果另一个线程正在阻塞地调用select()，因为事件集已经改变，因此需要通过wakeup()让其立刻返回并重新select()
			selector.wakeup();
			System.out.println("用户" + clientChannel.socket().getPort() + "退出聊天室！");
		}
	}

	/**
	 * 将客户端发来的消息广播给其他客户端
	 *
	 * @param clientChannel 消息源
	 * @param msg           消息
	 */
	private void broadcastMessage(SocketChannel clientChannel, String msg) {
		try {
			// 遍历当前selector上所有channel
			for (SelectionKey selectionKey : selector.keys()) {
				SelectableChannel channel = selectionKey.channel();
				// 消息不需要转发给ServerSocketChannel和当前客户端自己
				if (selectionKey.isValid() && !(channel instanceof ServerSocketChannel) && !channel.equals(clientChannel)) {
					SocketChannel otherClient = (SocketChannel) channel;
					wBuffer.put(("用户" + clientChannel.socket().getPort() + ": " + msg).getBytes());
					while (wBuffer.hasRemaining()) {
						wBuffer.flip();
						otherClient.write(wBuffer);
					}
					wBuffer.clear();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatServer(8888).start();
	}
}
