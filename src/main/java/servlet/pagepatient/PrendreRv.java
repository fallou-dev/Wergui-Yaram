package servlet.pagepatient;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Patient;
import Model.RendezVous;
import dao.PatientDao;
import dao.RendezVousDao;

/**
 * Servlet implementation class PrendreRv
 */
@WebServlet("/PrendreRv")
public class PrendreRv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/PagePatient/insert.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
		
		String numero = (String) session.getAttribute("patient");
		Patient patient = PatientDao.getPatientByTelephone(numero);
		
		
		String date = request.getParameter("date");
		
		Date datecons =Date.valueOf(date);
		
		int idpat = patient.getIdpatient();
		String nomservice = request.getParameter("service");
		
		RendezVous rv = new RendezVous(datecons,idpat,nomservice);
		
		RendezVousDao.insertRv(rv);
		response.sendRedirect("Acceuil");
	}

}
