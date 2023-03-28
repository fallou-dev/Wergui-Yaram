package servlet.consultation;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Consultation;
import dao.ConsultationDao;

/**
 * Servlet implementation class UpdateConsultation
 */
@WebServlet("/updateconsultation")
public class UpdateConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String sid = request.getParameter("id");
				
				if(sid!= null && sid.matches("[0-9]+")) {
					int id = Integer.parseInt(sid);
					Consultation cons = ConsultationDao.getConsultationById(id);
					
					if(cons!=null) {
						 request.setAttribute("consultation", cons);
						 getServletContext().getRequestDispatcher("/WEB-INF/consultation/update.jsp").forward(request,response);
						return;
					}
				}
				response.sendRedirect("listeconsultation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String date = request.getParameter("date_consultation");
		
		Date datecons =Date.valueOf(date);
		
		String synthese = request.getParameter("synthese");
		String medecin = request.getParameter("medecin_idmedecin");
		int idmedecin = Integer.parseInt(medecin);
		String patient = request.getParameter("patient_idpatient");
		int idpatient = Integer.parseInt(patient);
		String service = request.getParameter("service_nom_service");
		
		Consultation cons = new Consultation();
		cons.setDate_consultation(datecons);
		cons.setSynthese(synthese);
		cons.setMedecin_idmedecin(idmedecin);
		cons.setPatient_idpatient(idpatient);
		cons.setService_nomservice(service);
		
		ConsultationDao.updateConsultation(cons);
		response.sendRedirect("listeconsultation");
		}

}
