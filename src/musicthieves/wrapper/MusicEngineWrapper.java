package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MusicEngineWrapper {
	
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://musicengine.radio-internet.com/").get();
		String title = doc.title();
		
		System.out.println(title);
		
		int lyricsUid = 6291;
		String lyricsToken = "Df5Z10GPxLyV7FfA";
		doc = Jsoup.connect("http://www.stands4.com/services/v2/lyrics.php?uid="+lyricsUid+
				"&tokenid="+lyricsToken+"&term=forever%20young").get();
		String text = doc.toString();
		
		System.out.println(text);
	}

	public MusicEngineWrapper() {
		
	}

}
