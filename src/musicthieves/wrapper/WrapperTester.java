package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WrapperTester {

public static void main(String[] args) throws IOException {
		
	/* Begin Test LyricsWrapper */
		String[] terms = {"partono","plotoni","di","uomini"};
		LyricsWrapper lWrapper = new LyricsWrapper();
		Element firstResult = lWrapper.search(terms);
		
		String title = firstResult.getElementsByClass("lyric-meta-title").first().text();
		String artist = firstResult.getElementsByClass("lyric-meta-artists").first().text();
		String album = firstResult.getElementsByClass("lyric-meta-album").first().text();
		int albumYear = Integer.parseInt(firstResult.getElementsByClass("lyric-meta-album-year").first().text());
		
		String lyricLink = "https://www.lyrics.com"+firstResult.getElementsByClass("lyric-meta-title").first().
				getElementsByTag("a").first().attr("href").toString();	
		
		String lyric = lWrapper.getLyric(lyricLink);
		
		System.out.println(title+"\n"+artist+"\n"+album+"\n"+albumYear+"\n");
		System.out.println(lyricLink+"\n");
		System.out.println(lyric+"\n");
	/* End Test LyricsWrapper */	
	}

}
