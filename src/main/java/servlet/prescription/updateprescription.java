package servlet.prescription;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Prescription;

import dao.PrescriptionDao;

/**
 * Servlet implementation class updateprescription
 */
@WebServlet("/updateprescription")
public class updateprescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
	
	if(sid!= null && sid.matches("[0-9]+")) {
		int id = Integer.parseInt(sid);
		Prescription prescription = PrescriptionDao.getPrescriptionById(id);
		if(prescription != null) {
			 request.setAttribute("prescription", prescription);
			 getServletContext().getRequestDispatcher("/WEB-INF/prescription/update.jsp").forward(request,response);
			return;
		}
	}
	
	response.sendRedirect("listeprescription");

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		   int id = Integer.parseInt(sid);
		  
		   String idconsultation=request.getParameter("idconsultation");
		   int idcons= Integer.parseInt(idconsultation);
		   String note=request.getParameter("note");
		   String date_prescription =request.getParameter("date_prescription");
		   Date datepre =Date.valueOf(date_prescription);
		   
		   Prescription prescription = new Prescription();
		   prescription.setDate_prescription(datepre);
		   prescription.setNote(note);
		   prescription.setConsultation_idconsultation(idcons);
		   prescription.setIdprescription(id);
		   
		  
		  
		   
		   
		   PrescriptionDao.updatePrescription(prescription);
		   response.sendRedirect("listeprescription");
	}

}
