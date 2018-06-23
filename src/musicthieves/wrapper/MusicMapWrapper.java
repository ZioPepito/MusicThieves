package musicthieves.wrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MusicMapWrapper {

	public MusicMapWrapper() {
		
	}

	public List<String> relatedArtists(String artist) {
		List<String> results = new ArrayList<>();
		List<Element> elements = null;
		
		try {
			Document doc = Jsoup.connect("https://www.music-map.com/"+URLEncoder.encode(artist, "UTF-8")+".html").get();
			elements = doc.getElementsByClass("S");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 5; i++) {
			results.add(elements.get(i+1).text());
		}
		
		return results;
	}
}
