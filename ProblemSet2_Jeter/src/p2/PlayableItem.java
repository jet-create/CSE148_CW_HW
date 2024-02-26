package p2;

public abstract class PlayableItem {
	protected int duration;

	public PlayableItem(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	abstract void play();
}
