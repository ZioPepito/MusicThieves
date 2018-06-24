package musicthieves.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mediator.Mediator;
import musicthieves.wrapper.Song;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String input = URLDecoder.decode(request.getParameter("searchInput"),"UTF-8");
		int option = Integer.parseInt(request.getParameter("option"));
		if(input!=null && input.trim()!="") {
			if(option == 0) {
				Song song = Mediator.searchByTitle(input);
				if(song==null) {
					response.getWriter().append("<h2 class=\"animated fadeInUp\">No match found</h2>");
					return;
				}
				String videoID=Mediator.findOnYoutube(song.getTitle());
				List<String> relatedArtists = Mediator.searchRelateArtist(song.getArtist());
				response.getWriter().append(
						"<div class=\"row col-lg-12 col-lg-offset-1\">\r\n" + 
						"<div class=\"col-md-5 resultDiv\">"+
							"<h2>Song info</h2></br>" +
							song.getTitle() +"</br>" +
							song.getArtist() +"</br>");
				if (song.getAlbum()!=null) {
					response.getWriter().append(song.getAlbum() +"</br>");
				}
				if (song.getAlbumYear()!=null) {
					response.getWriter().append(song.getAlbumYear() +"</br>");
				}	
				response.getWriter().append("</br><h2>You might also like</h2></br>");
				for(int i = 0; i < 5; i++) {
					response.getWriter().append(
							"<span style=\"cursor: pointer\" onClick=\"autoSearchArtist('"+relatedArtists.get(i).replace("'", " ")+"')\">"+
									relatedArtists.get(i) + "</br>"+
							"</span>"
							);
				}
				response.getWriter().append(
						" </div>\r\n" + 
						"<div class=\"col-md-5 resultDiv\">"+
							"<h2>Lyric</h2></br>" +
							"<div class=\"pre-scrollable\">"+
								song.getLyric() +"</br>" +
							"</div>"+
						"</div>\r\n" + 
						"</div>\r\n" + 
						"<div class=\"row col-lg-12 col-lg-offset-1\">\r\n" + 
						"<div class=\"col-md-5 resultDiv\"> "+
							"<h2>Audio</h2></br>" +
						" </div>\r\n" + 
						"<div class=\"col-md-5 resultDiv\">" +
							"<h2>Video</h2></br>" +
						"<div class=\"resp-container\">\n" + 
						"    <iframe class=\"resp-iframe\" src=\"https://www.youtube.com/embed/"+videoID+"\" gesture=\"media\"  allow=\"encrypted-media\" allowfullscreen></iframe>\n" + 
						"</div>"+
						"</div>\r\n" + 
						"</div>");

			}else if (option == 1) {
				List<String> songs = Mediator.searchByArtist(input);
				if(songs.size()==0) {
					response.getWriter().append("<h2 class=\"animated fadeInUp\">No match found</h2>");
					return;
				}
				response.getWriter().append(
						"<div class=\"row\">\r\n" + 
							"<div class=\"col-sm-6 col-sm-offset-3\"> " +
								"<h2 style=\"color: #DAA520;\">Some songs of the searched artist</h2></br>");
				for(int i = 0; i < 5 && i<songs.size(); i++) {
					response.getWriter().append(
							"<span style=\"cursor: pointer\" onClick=\"autoSearch('"+songs.get(i).replace("'", " ")+"')\">"+
									songs.get(i) +
							"</span></br>"
							);
				}
				response.getWriter().append(			
							" </div>\r\n" + 
						"</div>\r\n"); 
			}else if (option == 2) {
				Song song = Mediator.searchByLyric(input);
				if(song==null) {
					response.getWriter().append("<h2 class=\"animated fadeInUp\">No match found</h2>");
					return;
				}
				String videoID=Mediator.findOnYoutube(song.getTitle());
				List<String> relatedArtists = Mediator.searchRelateArtist(song.getArtist());
				response.getWriter().append("<div class=\"row col-lg-12 col-lg-offset-1\">\r\n" + 
						"<div class=\"col-md-5 resultDiv\">"+
							"<h2>Song info</h2></br>" +
							song.getTitle() +"</br>" +
							song.getArtist() +"</br>");
				if (song.getAlbum()!=null) {
					response.getWriter().append(song.getAlbum() +"</br>");
				}
				if (song.getAlbumYear()!=null) {
					response.getWriter().append(song.getAlbumYear() +"</br>");
				}	
				response.getWriter().append("</br><h2>You might also like</h2></br>");
				for(int i = 0; i < 5; i++) {
					response.getWriter().append(
							"<span style=\"cursor: pointer\" onClick=\"autoSearchArtist('"+relatedArtists.get(i).replace("'", " ")+"')\">"+
									relatedArtists.get(i) + "</br>"+
							"</span>"
							);
				}
				response.getWriter().append(		
						" </div>\r\n" + 
						"<div class=\"col-md-5 resultDiv\">"+
							"<h2>Lyric</h2></br>" +
							"<div class=\"pre-scrollable\">"+
								song.getLyric() +"</br>" +
							"</div>"+
						"</div>\r\n" + 
						"</div>\r\n" + 
						"<div class=\"row col-lg-12 col-lg-offset-1\">\r\n" + 
						"<div class=\"col-md-5 resultDiv\"> "+
							"<h2>Audio</h2></br>" +
						" </div>\r\n" + 
						"<div class=\"col-md-5 resultDiv\">" +
							"<h2>Video</h2></br>" +
						"<div class=\"resp-container\">\n" + 
						"    <iframe class=\"resp-iframe\" src=\"https://www.youtube.com/embed/"+videoID+"\" gesture=\"media\"  allow=\"encrypted-media\" allowfullscreen></iframe>\n" + 
						"</div>"+
						"</div>\r\n" + 
						"</div>");

			}else {
				response.getWriter().append("You shouldn't be here!<br/>"); 
			}
		}
		System.out.println(input+" "+option);
	}
}
