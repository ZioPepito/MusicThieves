package musicthieves.wrapper;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LyricsWrapper {
	
	public LyricsWrapper() {
		
	}
	
	public String[] search(String input) throws IOException {
		
		Document doc = Jsoup.connect("https://www.lyrics.com/lyrics/"+URLEncoder.encode(input, "UTF-8")).get();
		Element firstResult = doc.getElementsByClass("sec-lyric clearfix").first();
		
		String[] results = new String[5];
		results[0] = firstResult.getElementsByClass("lyric-meta-title").first().text();
		results[1] = firstResult.getElementsByClass("lyric-meta-artists").first().text();
		results[2] = firstResult.getElementsByClass("lyric-meta-album").first().text();
		results[3] = firstResult.getElementsByClass("lyric-meta-album-year").first().text();
		results[4] = "https://www.lyrics.com"+firstResult.getElementsByClass("lyric-meta-title").first().
				getElementsByTag("a").first().attr("href").toString();
		
		return results;
	}
	
	public String getLyric(String lyricLink) throws IOException {
		
		Document doc = Jsoup.connect(lyricLink).get();
		String lyric = doc.getElementById("lyric-body-text").text();
		
		return lyric;
	}

	public String searchAlbum(String input) {
		
		return "";
	}
}
