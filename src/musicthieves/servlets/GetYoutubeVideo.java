package musicthieves.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.services.youtube.model.SearchResult;

import musicthieves.wrapper.YoutubeWrapper;


/**
 * Servlet implementation class GetYoutubeVideo
 */

@WebServlet("/GetYoutubeVideo")
public class GetYoutubeVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetYoutubeVideo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YoutubeWrapper yw = new YoutubeWrapper();
		String keyword=request.getParameter("key");
		SearchResult res =yw.SearchSong(keyword);
		request.setAttribute("videoID", res.getId().getVideoId());
		request.setAttribute("SongTitle", res.getSnippet().getTitle());
		String nextJSP = "/youtubevideo.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
