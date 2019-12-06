package com.heibaiying.behavioral.command;

public class PauseCommand implements Command {

	private Player player;

	public PauseCommand(Player player) {
		this.player = player;
	}


	@Override
	public void execute() {
		player.pause();
	}
}
