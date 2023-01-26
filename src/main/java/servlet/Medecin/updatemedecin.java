package servlet.Medecin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Medecin;
import dao.MedecinDao;


/**
 * Servlet implementation class updatemedecin
 */
@WebServlet("/updatemedecin")
public class updatemedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		
		if(sid!= null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			Medecin medecin = MedecinDao.getUserById(id);
			if(medecin != null) {
				 request.setAttribute("medecin", medecin);
				 getServletContext().getRequestDispatcher("/WEB-INF/medecin/update.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("listemedecin");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated me
			String sid = request.getParameter("id");
		   int id = Integer.parseInt(sid);
		   String nom=request.getParameter("nom");
		   String prenom=request.getParameter("prenom");
		   String email=request.getParameter("email");
		   String telephone =request.getParameter("telephone");
		   String specialite = request.getParameter("specialite");
		   String service = request.getParameter("service_nom_service");
		   String password=request.getParameter("motdepasse");
		   
		   Medecin medecin = new Medecin();
		   medecin.setIdmedecin(id);
		   medecin.setNom_medecin(nom);
		   medecin.setPrenom_medecin(prenom);
		   medecin.setEmail(email);
		   medecin.setMotdepasse(password);
		   medecin.setTelephone(telephone);
		   medecin.setSpecialite(specialite);
		   medecin.setService_nom_service(service);
		   
		   MedecinDao.updateUser(medecin);
		   response.sendRedirect("listemedecin");
	}

}
