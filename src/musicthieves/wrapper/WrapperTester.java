package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.nodes.Element;

public class WrapperTester {

public static void main(String[] args) throws IOException {
		
	/* Begin Test LyricsWrapper */
		String terms = "partono plotoni di uomini";
		LyricsWrapper lWrapper = new LyricsWrapper();
		String[] data = lWrapper.search(terms);
		
		for(int i = 0; i < 4; i++) {
			System.out.println(data[i]+"");
		}
		
		String lyric = lWrapper.getLyric(data[4]);		
		
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
		
		System.out.println("Hai cercato "+terms2+". Potrebbero piacerti:");
		for(int i = 0; i < 5; i++) {
			System.out.println(relatedArtist[i]);
		}
	
	/* End Test LastFMWrapper */
	}

}
