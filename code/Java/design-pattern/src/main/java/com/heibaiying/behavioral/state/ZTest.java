package com.heibaiying.behavioral.state;

public class ZTest {
	public static void main(String[] args) {
		Player player = new Player();
		player.speed();
		player.paly();
		player.speed();
		player.pause();
		player.close();
		player.speed();
	}
}
