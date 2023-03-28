package servlet.RendezVous;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RendezVous;

import dao.RendezVousDao;



/**
 * Servlet implementation class updaterv
 */
@WebServlet("/updaterv")
public class updaterv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		
		if(sid!= null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			RendezVous rv = RendezVousDao.getRvById(id);
			
			if(rv!=null) {
				 request.setAttribute("rendezvous", rv);
				 getServletContext().getRequestDispatcher("/WEB-INF/rv/update.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("listeRendezVous");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		
		   int id = Integer.parseInt(sid);
		  
		  
		 
		   String date=request.getParameter("date");
		   Date daterv =Date.valueOf(date);
		   String idpatient=request.getParameter("idpatient");
		   int idpat= Integer.parseInt(idpatient);
		   
		   RendezVous rv = new RendezVous();
		   rv.setDate_rv(daterv);
		   rv.setPatient_idpatient(idpat);
		   rv.setIdRendezvous(id);
		  
		   
		  
		  
		   
		   
		   RendezVousDao.updateRv(rv);
		   response.sendRedirect("listeRendezVous");
	}

}
