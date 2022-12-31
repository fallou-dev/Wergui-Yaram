package servlet.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.patient.*;

/**
 * Servlet implementation class InsertPatient
 */
@WebServlet("/InsertPatient")
public class InsertPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddPatientForm form = new AddPatientForm(request);
		
		if(form.ajouter() ) {
			response.sendRedirect("listepatient");
		}else {
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("user", form.getPatient());
			request.setAttribute("erreurs", form.getErreurs());
			

			getServletContext().getRequestDispatcher("/WEB-INF/patient/insert.jsp").forward(request,response);

		}
	}

}
