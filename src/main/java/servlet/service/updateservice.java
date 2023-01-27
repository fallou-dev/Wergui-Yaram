package servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service;
import dao.ServiceDao;

/**
 * Servlet implementation class updateservice
 */
@WebServlet("/updateservice")
public class updateservice extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
				String sid = request.getParameter("id");
				
				if(sid!= null ) {
					
					Service service = ServiceDao.getServiceByName(sid);
					if(service != null) {
						 request.setAttribute("service", service);
						 getServletContext().getRequestDispatcher("/WEB-INF/service/update.jsp").forward(request,response);
						return;
					}
				}
				response.sendRedirect("allservice");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String sid = request.getParameter("nom_service");
		   
		   Service service = new Service();
		   service.setNom_service(sid);
		   
		   ServiceDao.updateService(service);
		   response.sendRedirect("allservice");
	}

}
