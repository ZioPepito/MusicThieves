package musicthieves.wrapper;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LastFMWrapper {

	private static final String API_KEY = "963f68cad2c206d11fbdf91543417a09"; 
	public LastFMWrapper() {
		
	}
	
	public String[] getSong(String input) throws IOException {
		
		Document doc = Jsoup.connect("https://ws.audioscrobbler.com/2.0/?method=track.search&track="+
		URLEncoder.encode(input, "UTF-8")+"&api_key="	+ API_KEY).get();
		
		String title = doc.getElementsByTag("track").first().getElementsByTag("name").first().text();
		String artist = doc.getElementsByTag("track").first().getElementsByTag("artist").first().text();
		
		String[] result = {title,artist}; 
		return result;
	}

}
