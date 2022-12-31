package servlet.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Patient_dao;

/**
 * Servlet implementation class AllPatient
 */
@WebServlet("/AllPatient")
public class AllPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 private static final String VUE_LIST_PATIENT="/WEB-INF/patient/liste.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setAttribute("patients", Patient_dao.getAllUser());	
				getServletContext().getRequestDispatcher(VUE_LIST_PATIENT).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
