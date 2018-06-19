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
		String[] results = new String[5];

		Document doc = Jsoup.connect("https://ws.audioscrobbler.com/2.0/?method=track.search&track="+
				URLEncoder.encode(input, "UTF-8")+"&api_key="	+ API_KEY).get();
		for(int i = 0; i < 5; i++) {
			results[i] = doc.getElementsByTag("track").get(i).getElementsByTag("name").first().text() +", "+ doc.getElementsByTag("track").get(i).getElementsByTag("artist").first().text();
		}
		return results;
	}

}
