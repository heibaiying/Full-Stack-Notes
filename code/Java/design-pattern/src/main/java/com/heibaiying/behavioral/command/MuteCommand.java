package com.heibaiying.behavioral.command;

public class MuteCommand implements Command {

	private Player player;

	public MuteCommand(Player player) {
		this.player = player;
	}


	@Override
	public void execute() {
		player.mute();
	}
}
