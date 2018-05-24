package musicthieves.wrapper;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LyricsWrapper {
	
	public LyricsWrapper() {
		
	}
	
	public Element search(String terms) throws IOException {
		
		Document doc = Jsoup.connect("https://www.lyrics.com/lyrics/"+URLEncoder.encode(terms, "UTF-8")).get();
		Element firstResult = doc.getElementsByClass("sec-lyric clearfix").first();
		
		return firstResult;
	}
	
	public String getLyric(String lyricLink) throws IOException {
		
		Document doc = Jsoup.connect(lyricLink).get();
		String lyric = doc.getElementById("lyric-body-text").text();
		
		return lyric;
	}

}
