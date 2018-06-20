package musicthieves.wrapper;

public class Song {
	
	private String title, artist, album, albumYear, text;

	public Song(String title, String artist, String text) {
		this.title = title;
		this.artist = artist;
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

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getAlbumYear() {
		return albumYear;
	}

	public void setAlbumYear(String albumYear) {
		this.albumYear = albumYear;
	}

	public String getText() {
		return text;
	}

	public void setLinkToText(String linkToText) {
		this.text = linkToText;
	};
	
	

}
