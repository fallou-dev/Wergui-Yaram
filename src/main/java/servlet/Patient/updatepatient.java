package servlet.Patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Patient;

import dao.PatientDao;



/**
 * Servlet implementation class updatepatient
 */
@WebServlet("/updatepatient")
public class updatepatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String sid = request.getParameter("id");
		
		if(sid!= null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			Patient patient = PatientDao.getPatientById(id);
			if(patient != null) {
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
		String sid = request.getParameter("id");
		   int id = Integer.parseInt(sid);
		   String nom=request.getParameter("nom");
		   
		   String prenom=request.getParameter("prenom");
		   String email=request.getParameter("email");
		   String telephone =request.getParameter("telephone");
		  
		   
		   Patient patient = new Patient();


		   patient.setNom_patient(nom);
		   patient.setPrenom_patient(prenom);
		   patient.setEmail(email);
		   patient.setTelephone(telephone);
		   patient.setIdpatient(id);
		   
		   PatientDao.updateUser(patient);
		   response.sendRedirect("listepatient");
	}
	

}
