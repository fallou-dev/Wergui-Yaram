package servlet.pagepatient;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Patient;
import dao.PatientDao;

@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Recupere la session
		HttpSession session = request.getSession();	
			
		String numero = (String) session.getAttribute("patient");
		Patient patient = PatientDao.getPatientByTelephone(numero);
		
		//System.out.println(numero);
		request.setAttribute("patient",patient);
		getServletContext().getRequestDispatcher("/WEB-INF/PagePatient/Acceuil.jsp").forward(request,response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Recupere la session
		HttpSession session = request.getSession(true);	
		
		// Recupere l'age de l'utilisateur 
		int id = (int)session.getAttribute("idpatient");
		PatientDao.getPatientById(id);
		
			Patient patient = PatientDao.getPatientById(id);
			if(patient != null) {
				 request.setAttribute("patient", patient);
				 getServletContext().getRequestDispatcher("/WEB-INF/patient/update.jsp").forward(request,response);
				return;
			}

			response.sendRedirect("listepatient");
		}
		
}
