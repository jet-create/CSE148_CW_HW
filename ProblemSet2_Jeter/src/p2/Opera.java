package p2;

public class Opera extends PlayableItem {
	private String singerName;
	private String operaTitle;

	public Opera(String singerName, String operaTitle, int duration) {
		super(duration);
		this.singerName = singerName;
		this.operaTitle = operaTitle;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getOperaTitle() {
		return operaTitle;
	}

	public void setOperaTitle(String operaTitle) {
		this.operaTitle = operaTitle;
	}

	@Override
	void play() {
		System.out.println("Singer: " + singerName + " Opera: " + operaTitle + " Duration: " + duration);
	}

}
