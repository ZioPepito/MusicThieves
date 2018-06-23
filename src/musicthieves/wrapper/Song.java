package musicthieves.wrapper;

public class Song {

	private String title, artist, album, albumYear, lyric;
	
	public Song() {
	}


	public Song(String title, String artist, String lyric) {
		this.title = title.trim();
		this.artist = artist;
		this.lyric = lyric;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.trim();
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
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

	public String getLyric() {
		if(lyric == null) return "Lyric not found";
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equalsIgnoreCase(other.title))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Title: "+title+"\nArtist: "+artist+"\nAlbum: "+album;
	}
	

}
