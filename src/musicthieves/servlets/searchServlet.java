package musicthieves.servlets;

import java.io.IOException;
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
		String input = request.getParameter("searchInput");
		int option = Integer.parseInt(request.getParameter("option"));
		if(input!=null && input.trim()!="") {
			if(option == 0) {
				Song song = Mediator.searchByTitle(input);
				String videoID=Mediator.findOnYoutube(song.getTitle());
				response.getWriter().append("<div class=\"row\">\r\n" + 
						"<div class=\"col-md-6\">"+
							"<h2>Song info</h2></br>" +
							song.getTitle() +"</br>" +
							song.getArtist() +"</br>");
				if (song.getAlbum()!=null) {
					response.getWriter().append(song.getAlbum() +"</br>");
				}
				if (song.getAlbumYear()!=null) {
					response.getWriter().append(song.getAlbumYear() +"</br>");
				}		
				response.getWriter().append(		
						" </div>\r\n" + 
						"<div class=\"col-md-6\">"+
							"<h2>Lyric</h2></br>" +
							"<div class=\"pre-scrollable\">"+
								song.getLyric() +"</br>" +
							"</div>"+
						"</div>\r\n" + 
						"</div>\r\n" + 
						"<div class=\"row\">\r\n" + 
						"<div class=\"col-md-6\"> "+
							"<h2>Audio</h2></br>" +
						" </div>\r\n" + 
						"<div class=\"col-md-6\">" +
							"<h2>Video</h2></br>" +
						"<div class=\"resp-container\">\n" + 
						"    <iframe class=\"resp-iframe\" src=\"https://www.youtube.com/embed/"+videoID+"\" gesture=\"media\"  allow=\"encrypted-media\" allowfullscreen></iframe>\n" + 
						"</div>"+
						"</div>\r\n" + 
						"</div>");

			}else if (option == 1) {
				List<String> songs = Mediator.searchByArtist(input);
				response.getWriter().append(
						"<div class=\"row\">\r\n" + 
							"<div class=\"col-sm-6 col-sm-offset-3\"> " +
								"<h2>Some songs of the searched artist</h2></br>");
				for(int i = 0; i < 5; i++) {
					response.getWriter().append(
							"<a style=\"cursor: pointer\" onClick=\"autoSearch('"+songs.get(i).replace("'", " ")+"')\">"+
									songs.get(i) +
							"</a></br>"
							);
				}
				response.getWriter().append(			
							" </div>\r\n" + 
						"</div>\r\n"); 
			}else if (option == 2) {
				Song song = Mediator.searchByLyric(input);
				String videoID=Mediator.findOnYoutube(song.getTitle());
				response.getWriter().append("<div class=\"row\">\r\n" + 
						"<div class=\"col-md-6\">"+
							"<h2>Song info</h2></br>" +
							song.getTitle() +"</br>" +
							song.getArtist() +"</br>");
				if (song.getAlbum()!=null) {
					response.getWriter().append(song.getAlbum() +"</br>");
				}
				if (song.getAlbumYear()!=null) {
					response.getWriter().append(song.getAlbumYear() +"</br>");
				}		
				response.getWriter().append(		
						" </div>\r\n" + 
						"<div class=\"col-md-6\">"+
							"<h2>Lyric</h2></br>" +
							"<div class=\"pre-scrollable\">"+
								song.getLyric() +"</br>" +
							"</div>"+
						"</div>\r\n" + 
						"</div>\r\n" + 
						"<div class=\"row\">\r\n" + 
						"<div class=\"col-md-6\"> "+
							"<h2>Audio</h2></br>" +
						" </div>\r\n" + 
						"<div class=\"col-md-6\">" +
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
//		response.getWriter().append("<div class=\"row\">\r\n" + 
//				"<div class=\"col-md-6\"> </div>\r\n" + 
//				"<div class=\"col-md-6\"> </div>\r\n" + 
//				"</div>\r\n" + 
//				"<div class=\"row\">\r\n" + 
//				"<div class=\"col-md-6\"> </div>\r\n" + 
//				"<div class=\"col-md-6\"> </div>\r\n" + 
//				"</div>"); 
		System.out.println(input+" "+option);
	}
}
