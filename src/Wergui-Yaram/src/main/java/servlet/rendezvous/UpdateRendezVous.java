package servlet.rendezvous;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RendezVous;
import dao.RendezVous_dao;


/**
 * Servlet implementation class UpdateRendezVous
 */
@WebServlet("/UpdateRendezVous")
public class UpdateRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String sid = request.getParameter("idRendez_vous");
				
				if(sid!= null && sid.matches("[0-9]+")) {
					int id = Integer.parseInt(sid);
					RendezVous rv = RendezVous_dao.getRvById(id);
					if(rv!=null) {
						 request.setAttribute("rv", rv);
						 getServletContext().getRequestDispatcher("/WEB-INF/rv/update.jsp").forward(request,response);
						return;
					}
				}
				response.sendRedirect("AllRendezVous");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   String date_rv =request.getParameter("date_rv");
		   Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(date_rv);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
		   String medecin_idmedecin = request.getParameter("medecin_idmedecin");
		   int idmedecin = Integer.parseInt(medecin_idmedecin);
		   String patient_idpatient = request.getParameter("patient_idpatient");
		   int idpatient = Integer.parseInt(patient_idpatient);
		   
		   RendezVous rv = new RendezVous();
		   rv.setDate_rv(date);
		   rv.setMedecin_idmedecin(idmedecin);
		   rv.setPatient_idpatient(idpatient);
		   
		   RendezVous_dao.updateRv(rv);
		   response.sendRedirect("AllRendezVous");
		}

}


