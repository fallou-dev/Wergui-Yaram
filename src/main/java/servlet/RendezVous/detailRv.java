package servlet.RendezVous;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import Model.Patient;

/**
 * Servlet implementation class detailRv
 */
@WebServlet("/detailRv")
public class detailRv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id!= null && id.matches("[0-9]+")) {
			Patient patient = PatientDao.getPatientById(Integer.parseInt(id));
			
			if(patient != null) {
				 request.setAttribute("patient", patient);
				 getServletContext().getRequestDispatcher("/WEB-INF/rv/detail.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("listeRendezVous");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
