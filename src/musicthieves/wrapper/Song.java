package musicthieves.wrapper;

public class Song {
	
	private String title, artist, text;

	public Song(String title, String author, String text) {
		super();
		this.title = title;
		this.artist = author;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return artist;
	}

	public void setAuthor(String author) {
		this.artist = author;
	}

	public String getText() {
		return text;
	}

	public void setLinkToText(String linkToText) {
		this.text = linkToText;
	};
	
	

}
