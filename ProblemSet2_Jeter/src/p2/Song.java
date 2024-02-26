package p2;

public class Song extends PlayableItem {
	private String artistName;
	private String songTitle;

	public Song(String artistName, String songTitle, int duration) {
		super(duration);
		this.artistName = artistName;
		this.songTitle = songTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	@Override
	void play() {
		System.out.println("Artist: " + artistName + " Song: " + songTitle + " Duration: " + duration);
	}
	
	

}