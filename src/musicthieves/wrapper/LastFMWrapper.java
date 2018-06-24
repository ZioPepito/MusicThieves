package musicthieves.wrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LastFMWrapper {

	private static final String API_KEY = "963f68cad2c206d11fbdf91543417a09"; 
	public LastFMWrapper() {

	}

	public List<Song>getSong(String input) {
		List<Song> results=new ArrayList<Song>();
		Document doc;
		try {
			doc = Jsoup.connect("https://ws.audioscrobbler.com/2.0/?method=track.search&track="+
					URLEncoder.encode(input, "UTF-8")+"&api_key="	+ API_KEY).get();
			for(int i = 0; i < 5 && i < doc.getElementsByTag("track").size(); i++) {
				results.add(new Song(doc.getElementsByTag("track").get(i).getElementsByTag("name").first().text() , doc.getElementsByTag("track").get(i).getElementsByTag("artist").first().text(),null));
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}

}
