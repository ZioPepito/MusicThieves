package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.nodes.Element;

public class WrapperTester {

public static void main(String[] args) throws IOException {
		
	/* Begin Test LyricsWrapper */
		String[] terms = {"sono","malato","ma","da","un"};
		LyricsWrapper lWrapper = new LyricsWrapper();
		Element firstResult = lWrapper.search(terms);
		
		String title = firstResult.getElementsByClass("lyric-meta-title").first().text();
		String artist = firstResult.getElementsByClass("lyric-meta-artists").first().text();
		String album = firstResult.getElementsByClass("lyric-meta-album").first().text();
		int albumYear = Integer.parseInt(firstResult.getElementsByClass("lyric-meta-album-year").first().text());
		
		System.out.println(title+"\n"+artist+"\n"+album+"\n"+albumYear);
	/* End Test LyricsWrapper */	
	}

}
