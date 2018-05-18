package musicthieves.wrapper;

public class Song {
	
	private String title, author, linkToText;

	public Song(String title, String author, String linkToText) {
		super();
		this.title = title;
		this.author = author;
		this.linkToText = linkToText;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLinkToText() {
		return linkToText;
	}

	public void setLinkToText(String linkToText) {
		this.linkToText = linkToText;
	};
	
	

}
