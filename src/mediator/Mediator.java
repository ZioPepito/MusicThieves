package mediator;

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
		//AZLyrics
		List<Song> results=az.searchByKey(key);
		if(results!=null)
			return results.get(0);

		//lyrics
		String[] lyricsResults=ly.search(key);
		if(lyricsResults!=null) {
			Song song=new Song(lyricsResults[0], lyricsResults[1], lyricsResults[4]);
			song.setAlbum(lyricsResults[2]);
			song.setAlbumYear(lyricsResults[3]);
			return song;
		}
		
		results=lfm.getSong(key);
		if(results!=null) {
			return results.get(0);
		}
			
		return null;
	}
	
	public static String findOnYoutube(String keyword) {
		SearchResult result=you.searchSong(keyword);
		return result.getId().getVideoId();
	}

}