package servlet.RendezVous;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RendezVousDao;

/**
 * Servlet implementation class listeRendezVous
 */
@WebServlet("/listeRendezVous")
public class listeRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LIST_RENDEZVOUS="/WEB-INF/rv/liste.jsp";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("rv", RendezVousDao.getAllRendezVous());	
		getServletContext().getRequestDispatcher(VUE_LIST_RENDEZVOUS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
