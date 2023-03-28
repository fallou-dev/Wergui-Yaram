package servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.service.*;

/**
 * Servlet implementation class InsertService
 */
@WebServlet("/InsertService")
public class InsertService extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/service/insert.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddServiceForm form = new AddServiceForm(request);
		
		if(form.ajouter() ) {
			response.sendRedirect("listeservice");
		}else {
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("service", form.getService());
			request.setAttribute("erreurs", form.getErreurs());
			

			getServletContext().getRequestDispatcher("/WEB-INF/service/insert.jsp").forward(request,response);

		}

	}

}
