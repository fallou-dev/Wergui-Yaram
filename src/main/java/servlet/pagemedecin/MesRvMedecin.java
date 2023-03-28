package servlet.pagemedecin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Medecin;
import Model.RendezVous;
import dao.MedecinDao;
import dao.RendezVousDao;

/**
 * Servlet implementation class MesRvMedecin
 */
@WebServlet("/MesRvMedecin")
public class MesRvMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
		
		String email = (String) session.getAttribute("medecin");
		Medecin medecin = MedecinDao.getUserByLogin(email);
		//System.out.println(patient.getIdpatient());
		List<RendezVous> rvs = RendezVousDao.getAllRendezVousByNomService(medecin.getService_nom_service());
		//System.out.println(rvs);
		
		request.setAttribute("rv",rvs);
		getServletContext().getRequestDispatcher("/WEB-INF/PageMedecin/MesRv.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
