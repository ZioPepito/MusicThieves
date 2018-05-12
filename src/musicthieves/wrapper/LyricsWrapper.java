package musicthieves.wrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LyricsWrapper {
	
	public LyricsWrapper() {
		
	}
	
	public Element search(String[] terms) throws IOException {
		StringBuilder searchParam = new StringBuilder();
		for(int i=0;i<terms.length;i++) {
			if(i == terms.length-1) {
				searchParam.append(terms[i]);
				break;
			}
			searchParam.append(terms[i]+"%20");
		}
		
		//System.out.println(searchParam);
		
		Document doc = Jsoup.connect("https://www.lyrics.com/lyrics/"+searchParam).get();
		Element firstResult = doc.getElementsByClass("sec-lyric clearfix").first();
		
		return firstResult;
	}

}
