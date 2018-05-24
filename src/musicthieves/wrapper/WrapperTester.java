package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.nodes.Element;

public class WrapperTester {

public static void main(String[] args) throws IOException {
		
	/* Begin Test LyricsWrapper */
		String terms = "partono plotoni di uomini";
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
		
	/* Begin Test LastFMWrapper */
		String terms1 = "follie preferenziali";
		LastFMWrapper LFMWrapper = new LastFMWrapper();
		String[] songInfo = LFMWrapper.getSong(terms1);
		
		System.out.println(songInfo[0]+"\n"+songInfo[1]+"\n");
	/* End Test LastFMWrapper */
		
	/* Begin Test LastFMWrapper */
		String terms2 = "Dream Theater";
		MusicMapWrapper mapWrapper = new MusicMapWrapper();
		String[] relatedArtist = mapWrapper.relatedArtists(terms2);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(relatedArtist[i]);
		}
	
	/* End Test LastFMWrapper */
	}

}
