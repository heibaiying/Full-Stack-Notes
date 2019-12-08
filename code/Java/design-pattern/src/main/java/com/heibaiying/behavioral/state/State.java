package com.heibaiying.behavioral.state;

public class State {

	private Player player;

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void paly() {
		player.setState(Player.PLAY_STATE);
	}

	public void pause() {
		player.setState(Player.PAUSE_STATE);
	}

	public void close() {
		player.setState(Player.CLOSE_STATE);
	}

	public void speed() {
		player.setState(Player.SPEED_STATE);
	}
}
