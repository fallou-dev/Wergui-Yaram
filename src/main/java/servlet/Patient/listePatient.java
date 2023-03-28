package servlet.Patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;

/**
 * Servlet implementation class listePatient
 */
@WebServlet("/listepatient")
public class listePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_LIST_UTILISATEUR="/WEB-INF/patient/liste.jsp";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("patients", PatientDao.getAllPatient());	
		response.encodeRedirectURL(VUE_LIST_UTILISATEUR);
		getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
