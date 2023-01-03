package servlet.rendezvous;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.rendezvous.*;
/**
 * Servlet implementation class InsertRendezVous
 */
@WebServlet("/InsertRendezVous")
public class InsertRendezVous extends HttpServlet {
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
		
		AddRendezVousForm form = new AddRendezVousForm(request);
		
		try {
			if(form.ajouter() ) {
				response.sendRedirect("AllRendezVous");
			}else {
				request.setAttribute("status", form.isStatus());
				request.setAttribute("statusMessage", form.getStatusMessage());
				request.setAttribute("user", form.getRv());
				request.setAttribute("erreurs", form.getErreurs());
				

				getServletContext().getRequestDispatcher("/WEB-INF/rv/insert.jsp").forward(request,response);

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

