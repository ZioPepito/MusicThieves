package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MusicEngineWrapper {
	
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://musicengine.radio-internet.com/").get();
		String title = doc.title();
		
		System.out.println(title);
	}

	public MusicEngineWrapper() {
		
	}

}
