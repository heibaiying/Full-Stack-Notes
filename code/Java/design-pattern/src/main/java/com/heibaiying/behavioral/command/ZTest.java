package com.heibaiying.behavioral.command;

public class ZTest {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Player player01 = new Player("播放器一");
		Player player02 = new Player("播放器二");
		manager.addCommand(new PlayCommand(player01));
		manager.addCommand(new PauseCommand(player01));
		manager.addCommand(new PlayCommand(player02));
		manager.addCommand(new MuteCommand(player02));
		manager.executeCommands();
	}
}
