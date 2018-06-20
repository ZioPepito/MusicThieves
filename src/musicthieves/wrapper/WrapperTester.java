package musicthieves.wrapper;

import java.io.IOException;

public class WrapperTester {

	public static void main(String[] args) throws IOException {

		/* Begin Test LyricsWrapper */
		System.out.println("TEST LYRICS\n");
		//search in lyric
		String input = "aDSASDASDSAF";
		LyricsWrapper lWrapper = new LyricsWrapper();
		String[] data = lWrapper.search(input);

		for(int i = 0; i < 4; i++) {
			System.out.println(data[i]+"");
		}

		String lyric = lWrapper.getLyric(data[4]);		

		System.out.println(lyric+"\n");

		//search album
		String artist = lWrapper.searchAlbum("Master of puppets");
		System.out.println("L'artista dell'album cercato �: "+artist+"\n");
		/* End Test LyricsWrapper */

		System.out.println("TEST LASTFM\n");
		/* Begin Test LastFMWrapper */
		String input1 = "follie";
		LastFMWrapper LFMWrapper = new LastFMWrapper();
		/*String[] songInfo = LFMWrapper.getSong(input1);
		System.out.println("Risultati per '"+input1+"': ");
		for(int i = 0; i < 5; i++) {
			System.out.println(songInfo[i]+"");
		}*/
		/* End Test LastFMWrapper */
		
		/* Begin Test MusicMap */
		System.out.println("\nTEST MUSICMAP\n");
		String input2 = "Dream Theater";
		MusicMapWrapper mapWrapper = new MusicMapWrapper();
		String[] relatedArtist = mapWrapper.relatedArtists(input2);

		System.out.println("Hai cercato "+input2+". Potrebbero piacerti:");
		for(int i = 0; i < 5; i++) {
			System.out.println(relatedArtist[i]);
		}
		/* End Test MusicMap */
	}

}
