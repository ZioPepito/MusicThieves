package musicthieves.wrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LyricsWrapper {
	
	public LyricsWrapper() {
		
	}
	
	public Song search(String input) {
		Song s=new Song();
		
		try {
		Document doc = Jsoup.connect("https://www.lyrics.com/lyrics/"+URLEncoder.encode(input, "UTF-8")).get();
		Element firstResult = doc.getElementsByClass("sec-lyric clearfix").first();
		
		s.setTitle(firstResult.getElementsByClass("lyric-meta-title").first().text());
		s.setArtist(firstResult.getElementsByClass("lyric-meta-artists").first().text());
		s.setAlbum(firstResult.getElementsByClass("lyric-meta-album").first().text());
		s.setAlbumYear(firstResult.getElementsByClass("lyric-meta-album-year").first().text());
		s.setLyric("https://www.lyrics.com"+firstResult.getElementsByClass("lyric-meta-title").first().
				getElementsByTag("a").first().attr("href").toString());
		}
		catch(NullPointerException e) {
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return s;
	}
	
	public String getLyric(String lyricLink) throws IOException {
		
		Document doc = Jsoup.connect(lyricLink).get();
		String lyric = doc.getElementById("lyric-body-text").text();
		
		return lyric;
	}

	public List<String> searchArtist(String input){
		Elements results;
		
		try {
			Document doc = Jsoup.connect("https://www.lyrics.com/serp.php?st="+
					URLEncoder.encode(input, "UTF-8")+"&qtype=2").get();
		Element firstResult = doc.getElementsByClass("tal qx").first().getElementsByTag("a").first();
		
		Document doc1 = Jsoup.connect("https://www.lyrics.com/"+firstResult.attr("href").toString()).get();
		Elements links = doc1.getElementsByClass("rc3");
		
		String linkToArtist = links.get(2).attr("href").toString();
		Document doc2 = Jsoup.connect("https://www.lyrics.com/"+linkToArtist).get();
		
		results = doc2.getElementsByTag("tr");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		int offset = results.size()/2 - 2;
		List<String> songs = new ArrayList<>();
		for(int i = offset; i <= offset+5; i++) {
			songs.add(results.get(i).getElementsByTag("strong").first().text());
		}
		
		return songs;
	}
}
