package servlet.prescription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PrescriptionDao;
import dao.ConsultationDao;
import dao.PatientDao;

import Model.Consultation;
import Model.Patient;
import Model.Prescription;
/**
 * 
 * Servlet implementation class listeprescription
 */
@WebServlet("/listeprescription")
public class listeprescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final String VUE_LIST_UTILISATEUR="/WEB-INF/prescription/liste.jsp";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		List<Patient> patients = new ArrayList<Patient>();
		List<Consultation> consultations = new ArrayList<Consultation>();
		
		prescriptions = PrescriptionDao.getAllPrescription();
		
		for(int i = 0; i < prescriptions.size(); i++) {
			consultations.add(ConsultationDao.getConsultationById(prescriptions.get(i).getConsultation_idconsultation()) );
		}
		
		for(int j = 0 ; j < consultations.size();j++) {
			patients.add(PatientDao.getPatientById(consultations.get(j).getPatient_idpatient()));
		}
		
		request.setAttribute("prescriptions", prescriptions);	
		request.setAttribute("patients",patients);	
		getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
