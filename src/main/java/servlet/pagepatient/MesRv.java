package servlet.pagepatient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Patient;
import Model.RendezVous;
import dao.PatientDao;
import dao.RendezVousDao;


/**
 * Servlet implementation class MesRv
 */
@WebServlet("/MesRv")
public class MesRv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		
		String numero = (String) session.getAttribute("patient");
		Patient patient = PatientDao.getPatientByTelephone(numero);
		//System.out.println(patient.getIdpatient());
		List<RendezVous> rvs = RendezVousDao.getAllRendezVousById(patient.getIdpatient());
		//System.out.println(rvs);
		request.setAttribute("rv",rvs);
		getServletContext().getRequestDispatcher("/WEB-INF/PagePatient/MesRv.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
