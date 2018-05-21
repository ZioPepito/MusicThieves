package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LastFMWrapper {

	private static final String API_KEY = "963f68cad2c206d11fbdf91543417a09"; 
	public LastFMWrapper() {
		
	}
	
	public String[] getSong(String[] terms) throws IOException {
		StringBuilder searchParam = new StringBuilder();
		for(int i=0;i<terms.length;i++) {
			if(i == terms.length-1) {
				searchParam.append(terms[i]);
				break;
			}
			searchParam.append(terms[i]+"%20");
		}
		
		Document doc = Jsoup.connect("https://ws.audioscrobbler.com/2.0/?method=track.search&track="+searchParam+"&api_key="
				+ API_KEY).get();
		
		String title = doc.getElementsByTag("track").first().getElementsByTag("name").first().toString();
		String artist = doc.getElementsByTag("track").first().getElementsByTag("artist").first().toString();
		
		String[] result = {title,artist}; 
		return result;
	}

}
