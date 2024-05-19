package p1;

public class MusicCD extends Item {
	private String artist;
	private String genre;
	
	public MusicCD() {
		super();
	}
	
	public MusicCD(String title, String publisher, String category, String callNumber, String artist, String genre) {
		super(title, publisher, category, callNumber);
		this.artist = artist;
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MusicCD [Artist: " + artist + ", Genre: " + genre + "]";
	}
	
	

	
	
	
	
	
}
