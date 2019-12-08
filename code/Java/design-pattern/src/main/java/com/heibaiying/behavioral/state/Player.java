package com.heibaiying.behavioral.state;

public class Player {

	private State state;

	public final static PlayState PLAY_STATE = new PlayState();
	public final static PauseState PAUSE_STATE = new PauseState();
	public final static CloseState CLOSE_STATE = new CloseState();
	public final static SpeedState SPEED_STATE = new SpeedState();

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		this.state.setPlayer(this);
	}

	Player() {
		// 假设播放器初始状态为关闭
		this.state = new CloseState();
		this.state.setPlayer(this);
	}

	public void paly() {
		System.out.println("播放视频");
		state.paly();
	}

	public void pause() {
		System.out.println("暂停视频");
		state.pause();
	}

	public void close() {
		System.out.println("关闭视频");
		state.close();
	}

	public void speed() {
		System.out.println("视频加速");
		state.speed();
	}

}
