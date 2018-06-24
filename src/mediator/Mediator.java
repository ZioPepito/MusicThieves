package mediator;

import java.util.List;

import com.google.api.services.youtube.model.SearchResult;

import musicthieves.wrapper.*;

public class Mediator {

	public static final int AZ_WEIGHT=3, AZ_WEIGHT_TITLE=2, LASTFM_WEIGHT=2, LYRICS_WEIGHT=2; 

	private static AZlyricsWrapper az= new AZlyricsWrapper();;
	private static LastFMWrapper lfm=new LastFMWrapper();
	private static LyricsWrapper ly=new LyricsWrapper();
	private static MusicMapWrapper mMap=new MusicMapWrapper();
	private static YoutubeWrapper you=new YoutubeWrapper();
	//private static SpotifyWrapper sp=new SpotifyWrapper();
	
	
	public static void main(String[] args) {
		Song result=searchByLyric("aaaaaaa");
		System.out.println(result);
		System.out.println(result.getLyric());
	}


	public static Song searchByLyric(String key) {
		//AZLyrics
		List<Song> azResults=az.searchByKey(key);
		//lyrics
		Song lyricsResult=ly.search(key);
		//lastfm
		List<Song> lfmResults=lfm.getSong(key);


		Song azBest=null;
		float azWeight=0;

		for (int i=0;i<azResults.size();i++) {
			float tmpWeight;
			tmpWeight=AZ_WEIGHT*(1/(i+1));
			int lfmPos=lfmResults.indexOf(azResults.get(i));
			tmpWeight=lfmPos<0?tmpWeight:tmpWeight+(LASTFM_WEIGHT*(1f/(lfmPos+1)));
			if(azResults.get(i).equals(lyricsResult))
				tmpWeight+=LYRICS_WEIGHT;
			if(azBest==null || tmpWeight>azWeight) {
				azBest=azResults.get(i);
				azWeight=tmpWeight;
			}

		}


		Song lfmBest=null;
		float lfmWeight=0;

		for (int i=0;i<lfmResults.size();i++) {
			float tmpWeight;
			tmpWeight=LASTFM_WEIGHT*(1/(i+1));
			int azPos=azResults.indexOf(lfmResults.get(i));
			tmpWeight=azPos<0?tmpWeight:tmpWeight+(AZ_WEIGHT*(1f/(azPos+1)));
			if(lfmResults.get(i).equals(lyricsResult))
				tmpWeight+=LYRICS_WEIGHT;
			if(lfmBest==null || tmpWeight>lfmWeight) {
				lfmBest=lfmResults.get(i);
				lfmWeight=tmpWeight;
			}

		}

		Song lyricsBest=null;
		float lyricsWeight=0;
		if(lyricsResult!=null) {
			lyricsBest=lyricsResult;
			lyricsWeight=LYRICS_WEIGHT;
			int azPos=azResults.indexOf(lyricsBest);
			lyricsWeight=azPos<0?lyricsWeight:lyricsWeight+(AZ_WEIGHT*(1f/(azPos+1)));
			int lfmPos=lfmResults.indexOf(lyricsBest);
			lyricsWeight=lfmPos<0?lyricsWeight:lyricsWeight+(LASTFM_WEIGHT*(1f/(lfmPos+1)));
		}
		
		
		if(azWeight==0 && lfmWeight==0 && lyricsWeight==0)
			return null;
		
		if(azWeight>=lfmWeight && azWeight>=lyricsWeight)
			return azBest;
		else if(lfmWeight>=azWeight && lfmWeight>=lyricsWeight)
			return lfmBest;
		else
			return lyricsBest;

	}
	
	public static Song searchByTitle(String key) {
		//AZLyrics
		List<Song> azResults=az.searchByKey(key);
		//lastfm
		List<Song> lfmResults=lfm.getSong(key);
		//lyrics
		Song lyricsResult=ly.search(key);


		Song azBest=null;
		float azWeight=0;

		for (int i=0;i<azResults.size();i++) {
			float tmpWeight;
			tmpWeight=AZ_WEIGHT_TITLE*(1/(i+1));
			int lfmPos=lfmResults.indexOf(azResults.get(i));
			tmpWeight=lfmPos<0?tmpWeight:tmpWeight+(LASTFM_WEIGHT*(1f/(lfmPos+1)));
			if(azBest==null || tmpWeight>azWeight) {
				azBest=azResults.get(i);
				azWeight=tmpWeight;
			}

		}


		Song lfmBest=null;
		float lfmWeight=0;

		for (int i=0;i<lfmResults.size();i++) {
			float tmpWeight;
			tmpWeight=LASTFM_WEIGHT*(1/(i+1));
			int azPos=azResults.indexOf(lfmResults.get(i));
			tmpWeight=azPos<0?tmpWeight:tmpWeight+(AZ_WEIGHT_TITLE*(1f/(azPos+1)));
			if(lfmBest==null || tmpWeight>lfmWeight) {
				lfmBest=lfmResults.get(i);
				lfmWeight=tmpWeight;
			}

		}
		
		Song lyricsBest=null;
		float lyricsWeight=0;
		if(lyricsResult!=null) {
			lyricsBest=lyricsResult;
			lyricsWeight=LYRICS_WEIGHT;
			int azPos=azResults.indexOf(lyricsBest);
			lyricsWeight=azPos<0?lyricsWeight:lyricsWeight+(AZ_WEIGHT_TITLE*(1f/(azPos+1)));
			int lfmPos=lfmResults.indexOf(lyricsBest);
			lyricsWeight=(lfmPos<0)?lyricsWeight:(lyricsWeight+(LASTFM_WEIGHT*(1f/(lfmPos+1))));
		}

		if(azWeight==0 && lfmWeight==0)
			return lyricsBest;
		
		if(lfmWeight>=azWeight && lfmWeight>=lyricsWeight)
			return lfmBest;
		else if(lyricsWeight>=azWeight && lyricsWeight>=lfmWeight)
			return lyricsBest;
		else {
			return azBest;
		}
	}

	public static String findOnYoutube(String keyword) {
		SearchResult result=you.searchSong(keyword);
		return result.getId().getVideoId();
	}
	
	public static List<String> searchByArtist(String key) {
		List<String> songs = ly.searchArtist(key);
		return songs;
	}
	
	public static List<String> searchRelateArtist(String key) {
		List<String> results = mMap.relatedArtists(key);
		return results;
	}

}