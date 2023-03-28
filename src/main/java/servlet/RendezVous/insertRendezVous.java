package servlet.RendezVous;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RendezVous;
import dao.RendezVousDao;
import forms.rendezvous.AddRendezVousForm;

/**
 * Servlet implementation class insertRendezVous
 */
@WebServlet("/insertRendezVous")
public class insertRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/rv/insert.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				String date = request.getParameter("date");
				
				Date datecons =Date.valueOf(date);
				
				String idpatient = request.getParameter("idpatient");
				int idpat = Integer.parseInt(idpatient);
				String nomservice = request.getParameter("service");
				
				RendezVous rv = new RendezVous(datecons,idpat,nomservice);
				
				RendezVousDao.insertRv(rv);
				response.sendRedirect("listeRendezVous");
			
	}
	 

}

