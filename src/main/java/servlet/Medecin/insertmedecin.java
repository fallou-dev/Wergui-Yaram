package servlet.Medecin;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Medecin;
import dao.MedecinDao;
import forms.Medecin.*;

/**
 * Servlet implementation class insertmedecin
 */
@WebServlet("/insertmedecin")
public class insertmedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/medecin/insert.jsp");
		dispatcher.forward(request, response);
	}

	public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InsertMedecinForm form = new InsertMedecinForm(request);
		
		if(form.ajouter() ) {
			String prenom = request.getParameter("prenom_medecin");
			String nom = request.getParameter("nom_medecin");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			
			String special = request.getParameter("specialite");
			String service = request.getParameter("service_nom_service");
			String mdp = request.getParameter("motdepasse");
			try {
				mdp = toHexString(getSHA(mdp));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Medecin rv = new Medecin(nom,prenom,email,telephone,mdp,special,service);
			
			MedecinDao.insertMedecin(rv);
			
			response.sendRedirect("listemedecin");
		}else {
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("medecin", form.getMedecin());
			request.setAttribute("erreurs", form.getErreurs());
			

			getServletContext().getRequestDispatcher("/WEB-INF/medecin/insert.jsp").forward(request,response);

		}
	}

}
