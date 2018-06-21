package musicthieves.servlets;

import java.io.IOException;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("searchInput");
		int option = Integer.parseInt(request.getParameter("option"));
		if(input!=null && input!="") {
			if(option == 0) {
				Song song = Mediator.searchByKey(input);
				response.getWriter().append("Search in songs <br/>"+song.toString()+"<br/>"); 
			}else if (option == 1) {
				response.getWriter().append("Search in artists<br/>"); 
			}else if (option == 2) {
				response.getWriter().append("Search in lyrics<br/>"); 
			}else {
				response.getWriter().append("You shouldn't be here!<br/>"); 
			}
		}
		response.getWriter().append("Search: "+input+" with option: "+option); 
	}

}
