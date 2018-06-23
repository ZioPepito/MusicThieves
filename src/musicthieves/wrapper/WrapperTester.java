package musicthieves.wrapper;

import java.io.IOException;
import java.util.List;

public class WrapperTester {

	public static void main(String[] args) throws IOException {

		/* Begin Test LyricsWrapper */
		System.out.println("TEST LYRICS\n");
		//search in lyric
		String input = "non mi riconosco più prosopagnosia";
		LyricsWrapper lWrapper = new LyricsWrapper();
		Song song = lWrapper.search(input);

		System.out.println(song.getTitle()+"");

		String lyric = lWrapper.getLyric(song.getLyric());		

		System.out.println(lyric+"\n");

		//search album
		List<String> songs = lWrapper.searchArtist("Caparezza");
		System.out.println("Alcune canzoni dell'artista cercato: "+songs.get(0)+", " +songs.get(1)+", " +
				songs.get(2)+", " +songs.get(3)+", " +songs.get(4)+", " +"\n");
		/* End Test LyricsWrapper */

		System.out.println("TEST LASTFM\n");
		/* Begin Test LastFMWrapper */
		String input1 = "follie";
		LastFMWrapper LFMWrapper = new LastFMWrapper();
		List<Song> songInfo = LFMWrapper.getSong(input1);
		System.out.println("Risultati per '"+input1+"': ");
		for(int i = 0; i < 5; i++) {
			System.out.println(songInfo.get(i).getTitle()+"");
		}
		/* End Test LastFMWrapper */
		
		/* Begin Test MusicMap */
		System.out.println("\nTEST MUSICMAP\n");
		String input2 = "Dream Theater";
		MusicMapWrapper mapWrapper = new MusicMapWrapper();
		List<String> relatedArtist = mapWrapper.relatedArtists(input2);

		System.out.println("Hai cercato "+input2+". Potrebbero piacerti:");
		for(int i = 0; i < 5; i++) {
			System.out.println(relatedArtist.get(i));
		}
		/* End Test MusicMap */
	}

}
