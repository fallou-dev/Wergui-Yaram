package servlet.pagepatient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Consultation;
import Model.Patient;
import dao.PatientDao;
import dao.ConsultationDao;

/**
 * Servlet implementation class MesConsultation
 */
@WebServlet("/MesConsultation")
public class MesConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		
		String numero = (String) session.getAttribute("patient");
		Patient patient = PatientDao.getPatientByTelephone(numero);
		//System.out.println(patient.getIdpatient());
		List<Consultation> consultation = ConsultationDao.getAllConsultationPatient(patient.getIdpatient());
		//System.out.println(rvs);
		request.setAttribute("consultations",consultation);
		getServletContext().getRequestDispatcher("/WEB-INF/PagePatient/Mesconsultation.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
