package musicthieves.wrapper;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MusicMapWrapper {

	public MusicMapWrapper() {
		
	}

	public String[] relatedArtists(String artist) throws IOException {
		String[] results = new String[5];
		
		Document doc = Jsoup.connect("https://www.music-map.com/"+URLEncoder.encode(artist, "UTF-8")+".html").get();
		List<Element> elements = doc.getElementsByClass("S");
		for(int i = 0; i < 5; i++) {
			results[i] = elements.get(i+1).text();
		}
		
		return results;
	}
}
