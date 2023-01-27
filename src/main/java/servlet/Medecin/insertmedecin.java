package servlet.Medecin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.Medecin.*;

/**
 * Servlet implementation class insertmedecin
 */
@WebServlet("/insertmedecin")
public class insertmedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/medecin/insert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InsertMedecinForm form = new InsertMedecinForm(request);
		
		if(form.ajouter() ) {
			response.sendRedirect("listemedecin");
		}else {
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("medecin", form.getMedecin());
			request.setAttribute("erreurs", form.getErreurs());
			

			getServletContext().getRequestDispatcher("/WEB-INF/medecin/insert.jsp").forward(request,response);

		}
	}

}
