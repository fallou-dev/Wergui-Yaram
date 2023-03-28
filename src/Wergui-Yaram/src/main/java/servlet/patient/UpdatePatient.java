package servlet.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Patient;
import dao.Patient_dao;

/**
 * Servlet implementation class UpdatePatient
 */
@WebServlet("/UpdatePatient")
public class UpdatePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("idpatient");
		
		if(sid!= null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			Patient patient = Patient_dao.getPatientById(id);
			if(patient!=null) {
				 request.setAttribute("patient", patient);
				 getServletContext().getRequestDispatcher("/WEB-INF/patient/update.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("listepatient");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
