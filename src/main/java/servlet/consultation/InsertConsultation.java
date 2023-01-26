package servlet.consultation;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Consultation;
import dao.ConsultationDao;

/**
 * Servlet implementation class InsertConsultation
 */
@WebServlet("/insertconsultation")
public class InsertConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/consultation/insert.jsp");
		dispatcher.forward(request, response);
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
		
		Consultation cons = new Consultation(datecons,synthese,idmedecin,idpatient,service);
		
		ConsultationDao.insertConsultation(cons);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/consultation/insert.jsp");
		dispatcher.forward(request, response);
	}

}
