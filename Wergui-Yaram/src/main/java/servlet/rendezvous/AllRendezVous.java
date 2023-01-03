package servlet.rendezvous;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RendezVous_dao;

/**
 * Servlet implementation class AllRendezVous
 */
@WebServlet("/AllRendezVous")
public class AllRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LIST_RENDEZVOUS="/WEB-INF/rv/liste.jsp";
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("rv", RendezVous_dao.getAllUser());	
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
