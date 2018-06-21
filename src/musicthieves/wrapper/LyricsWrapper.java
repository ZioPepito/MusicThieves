package musicthieves.wrapper;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LyricsWrapper {
	
	public LyricsWrapper() {
		
	}
	
	public Song search(String input) {
		Song s=new Song();
		
		try {
		Document doc = Jsoup.connect("https://www.lyrics.com/lyrics/"+URLEncoder.encode(input, "UTF-8")).get();
		Element firstResult = doc.getElementsByClass("sec-lyric clearfix").first();
		
		s.setTitle(firstResult.getElementsByClass("lyric-meta-title").first().text());
		s.setArtist(firstResult.getElementsByClass("lyric-meta-artists").first().text());
		s.setAlbum(firstResult.getElementsByClass("lyric-meta-album").first().text());
		s.setAlbumYear(firstResult.getElementsByClass("lyric-meta-album-year").first().text());
		s.setText("https://www.lyrics.com"+firstResult.getElementsByClass("lyric-meta-title").first().
				getElementsByTag("a").first().attr("href").toString());
		}
		catch(NullPointerException e) {
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return s;
	}
	
	public String getLyric(String lyricLink) throws IOException {
		
		Document doc = Jsoup.connect(lyricLink).get();
		String lyric = doc.getElementById("lyric-body-text").text();
		
		return lyric;
	}

	public String searchAlbum(String input) throws IOException {
		
		Document doc = Jsoup.connect("https://www.lyrics.com/serp.php?st="+
				URLEncoder.encode(input, "UTF-8")+"&qtype=3").get();
		Element firstResult = doc.getElementsByClass("tal qx").first().getElementsByTag("a").first();
		
		Document doc1 = Jsoup.connect("https://www.lyrics.com"+firstResult.attr("href").toString()).get();
		String artist = doc1.getElementsByClass("hg1p23").first().getElementsByTag("h2").first().text();
		
		return artist;
	}
}
