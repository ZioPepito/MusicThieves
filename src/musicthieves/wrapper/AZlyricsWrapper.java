package musicthieves.wrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;




public class AZlyricsWrapper {

	public static final int MAX_RESULTS = 5;

	private static String url = "https://search.azlyrics.com/search.php?q=";

	public static void main(String[] args) {
		AZlyricsWrapper az=new AZlyricsWrapper();
		List<Song> res=az.searchByKey("");
		for (Song song : res) {
			System.out.println(song.getLyric());
		}
	}

	public List<Song> searchByKey(String key) {
		List<Song> results=new ArrayList<Song>();
		try {
			Document doc = Jsoup.connect(url+URLEncoder.encode(key, "UTF-8")).get();
			Elements songs = doc.getElementsByTag("table").last().getElementsByTag("tr");
			int counter=0;
			for (Element element : songs) {
				if(counter>=MAX_RESULTS)
					break; 
				if(element.getElementsByClass("glyphicon-chevron-right").size()==0) {
					doc=Jsoup.connect(element.getElementsByTag("a").first().attr("href")).get();
					String text=doc.getElementsByClass("ringtone").first().parent().children().get(7).wholeText();
					Song song=new Song(element.getElementsByTag("b").first().html(), element.getElementsByTag("b").get(1).html(), text);
					String album=(doc.getElementsByClass("songlist-panel").first().getElementsByTag("b").first().text().replace("\"", ""));
					song.setAlbum(album);
					results.add(song);
					counter++;
				}
			}

		} catch(NullPointerException e) {
			e.printStackTrace();
		}		
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			return null;
		}
		return results;
	}
}
