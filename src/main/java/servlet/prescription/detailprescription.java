package servlet.prescription;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Consultation;
import Model.Patient;
import dao.PrescriptionDao;
import dao.ConsultationDao;
import dao.PatientDao;

/**
 * Servlet implementation class detailprescription
 */
@WebServlet("/detailprescription")
public class detailprescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
				String sid = request.getParameter("id");
				
				if(sid!= null && sid.matches("[0-9]+")) {
					int id = Integer.parseInt(sid);
					Consultation consultation = ConsultationDao.getConsultationById(id);
					if(consultation != null) {
						 Patient patient = PatientDao.getPatientById(consultation.getPatient_idpatient());
						 request.setAttribute("consultation", consultation);
						 request.setAttribute("patient",patient);
						 getServletContext().getRequestDispatcher("/WEB-INF/prescription/detail.jsp").forward(request,response);
						return;
					}
				}
				response.sendRedirect("listeprescription");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
