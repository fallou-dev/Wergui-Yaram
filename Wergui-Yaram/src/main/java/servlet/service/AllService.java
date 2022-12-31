package servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Service_dao;

/**
 * Servlet implementation class AllService
 */
@WebServlet("/AllService")
public class AllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final String VUE_LIST_SERVICE="/WEB-INF/service/liste.jsp";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("services", Service_dao.getAllService());	
		getServletContext().getRequestDispatcher(VUE_LIST_SERVICE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
