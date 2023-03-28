package servlet.pagemedecin;

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

@WebServlet("/AcceuilMedecin")
public class AcceuilMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Recupere la session
		HttpSession session = request.getSession();	
			
		String email = (String) session.getAttribute("medecin");
		Patient medecin = PatientDao.getPatientByTelephone(email);
		
		//System.out.println(numero);
		request.setAttribute("medecin",medecin);
		getServletContext().getRequestDispatcher("/WEB-INF/PageMedecin/Acceuil.jsp").forward(request,response);
			
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
