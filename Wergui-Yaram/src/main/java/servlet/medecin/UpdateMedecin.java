package servlet.medecin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Medecin;
import dao.Medecin_dao;

/**
 * Servlet implementation class UpdateMedecin
 */
@WebServlet("/UpdateMedecin")
public class UpdateMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMedecin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String sid = request.getParameter("idmedecin");
				
				if(sid!= null && sid.matches("[0-9]+")) {
					int id = Integer.parseInt(sid);
					Medecin medecin = Medecin_dao.getUserById(id);
					if(medecin!=null) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
