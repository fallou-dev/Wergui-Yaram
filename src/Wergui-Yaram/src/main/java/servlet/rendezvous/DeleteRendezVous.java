package servlet.rendezvous;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RendezVous_dao;

/**
 * Servlet implementation class DeleteRendezVous
 */
@WebServlet("/DeleteRendezVous")
public class DeleteRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id = request.getParameter("id");
		 	if(id!= null && id.matches("[0-9]+")) {
		 		RendezVous_dao.deleteRv(Integer.parseInt(id));
			}
			
		 	response.sendRedirect("AllRendezVous");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
