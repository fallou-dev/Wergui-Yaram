package servlet.medecin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.medecin.*;
/**
 * Servlet implementation class InsertMedecin
 */
@WebServlet("/InsertMedecin")
public class InsertMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMedecin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/medecin/insert.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddMedecinForm form = new AddMedecinForm(request);
		
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
