package mediator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


import musicthieves.wrapper.Song;

public class Cache {

	private final long deleteTime = 1800000;
	private HashMap<String, Song> searchedSong;
	private HashMap<String, List<String>> searchedArtistsSongs;
	
	public Cache() {
		searchedSong = new HashMap<String, Song>();
		searchedArtistsSongs = new HashMap<String, List<String>>();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new Task(), deleteTime, deleteTime);
	}
	
	public void storeSong(String input, Song song) {
		song.setTimestamp(System.currentTimeMillis());
		searchedSong.put(input.toLowerCase(), song);
	}

	public void storeArtistsSong(String input, List<String> artistsSongs) {
		artistsSongs.add(Long.toString(System.currentTimeMillis()));
		searchedArtistsSongs.put(input.toLowerCase(), artistsSongs);
	}
	
	public Song findSong(String input) {
		return searchedSong.get(input.toLowerCase());
	}
	
	public List<String> findArtistsSongs(String input) {
		return searchedArtistsSongs.get(input.toLowerCase());
	}
	
	class Task  extends TimerTask {
		
		@Override
		public void run() {
			for (Map.Entry<String,Song> element : searchedSong.entrySet()) {
				if(System.currentTimeMillis() - element.getValue().getTimestamp() < deleteTime) {
					searchedSong.remove(element.getKey());
				}
			}
			for (Map.Entry<String,List<String>> element : searchedArtistsSongs.entrySet()) {
				if(System.currentTimeMillis() - Long.parseLong(element.getValue().get(5)) < deleteTime) {
					searchedArtistsSongs.remove(element.getKey());
				}
			}
		}
	}
}
