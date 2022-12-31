package servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service;
import dao.Service_dao;

/**
 * Servlet implementation class UpdateService
 */
@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String sid = request.getParameter("id");
				
				if(sid!= null && sid.matches("[0-9]+")) {
					int id = Integer.parseInt(sid);
					Service service = Service_dao.getServiceById(id);
					if(service!=null) {
						 request.setAttribute("service", service);
						 getServletContext().getRequestDispatcher("/WEB-INF/service/update.jsp").forward(request,response);
						return;
					}
				}
				response.sendRedirect("listservice");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String sid = request.getParameter("id");
		   int id = Integer.parseInt(sid);
		   String nom_service = request.getParameter("nom_service");
		   
		   Service service = new Service();
		   service.setIdservice(id);
		   service.setNom_service(nom_service);
		   
		   Service_dao.updateUser(service);
		   response.sendRedirect("listeservice");
	}

}
