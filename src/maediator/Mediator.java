package maediator;

import java.util.List;

import com.google.api.services.youtube.model.SearchResult;

import musicthieves.wrapper.*;

public class Mediator {
	
	private static AZlyricsWrapper az= new AZlyricsWrapper();;
	private static LastFMWrapper lfm=new LastFMWrapper();
	private static LyricsWrapper ly=new LyricsWrapper();
	private static MusicMapWrapper mMap=new MusicMapWrapper();
	private static YoutubeWrapper you=new YoutubeWrapper();
	//private static SpotifyWrapper sp=new SpotifyWrapper();
	
	
	public static Song searchByKey(String key) {
		List<Song> azResults=az.searchByKey(key);
		//other sources		
		
		return null;
	}
	
	public static String findOnYoutube(String keyword) {
		SearchResult result=you.searchSong(keyword);
		return result.getId().getVideoId();
	}

}