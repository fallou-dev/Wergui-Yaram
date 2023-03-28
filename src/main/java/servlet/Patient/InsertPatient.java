package servlet.Patient;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import Model.Patient;
import dto.ErrorAddPatient;


/**
 * Servlet implementation class InsertPatient
 */
@WebServlet("/insertpatient")
public class InsertPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/patient/insert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom_patient");
		String prenom = request.getParameter("prenom_patient");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String date_de_naissance = request.getParameter("date_de_naissance");
		String sexe = request.getParameter("sexe");
		String adresse = request.getParameter("adresse");
		String situation_familliale = request.getParameter("situation_familliale");
		String personne_a_prevenir = request.getParameter("personne_a_prevenir");
		String tel_personne_a_prevenir = request.getParameter("tel_personne_a_prevenir");
		String motdepasse = request.getParameter("motdepasse");
		String passwordBis = request.getParameter("passwordBis");
		
		
		nom.trim();
		prenom.trim();
		email.trim();
		telephone.trim();
		date_de_naissance.trim();
		sexe.trim();
		situation_familliale.trim();
		motdepasse.trim();
		passwordBis.trim();
		
		ErrorAddPatient error = new ErrorAddPatient();
		boolean check = true;
		if(nom.length()<3 || nom.length()>20) {
			error.setNom("Entrez un nom correct");
			check = false;
		}
		if(prenom.length() < 3 || prenom.length() > 40 || prenom.matches("[0-9]+") == true ) {
			error.setPrenom("Entrez un nom valable");
			check = false;
		}
		if(email.length()<5 || email.length()>30 || isValidEmail(email) == false) {
			error.setEmail("Entrez un email valide");
			check = false;
		}
		if(telephone.length() != 9){
			error.setTelephone("Entrez un numero de telephone");
			check = false;
		}if( date_de_naissance.length()<10 || date_de_naissance.length()>10) {
			error.setDate_de_naissance("Entrez une date valide");
			check = false;
		}
		if(sexe.length()<3) {
			error.setSexe("Entrez une valeur valide");
			check = false;
		}
		if(adresse.length()<4) {
			error.setAdresse("Entrez une valeur valide");
			check = false;
		}
		if(situation_familliale.length()<3 || situation_familliale.length() >100 ) {
			error.setSituation_familliale("Entrez une valeur valide");
			check = false;
		}
		if(personne_a_prevenir.length()<5 || personne_a_prevenir.length() > 50 || personne_a_prevenir.matches("[0-9]+") == true) {
			error.setPersonne_a_prevenir("Entrez un nom valide");
			check = false;
		}
		if(tel_personne_a_prevenir.length() < 5 || tel_personne_a_prevenir.length() > 12 || isValidPhone(tel_personne_a_prevenir) == false) {
			error.setPersonne_a_prevenir("Entrez un numero valide valide");
			check = false;
		}
		
		if(motdepasse.length()<8) {
			error.setMotdepasse("longeur inférieur à 8");
		}
		if(motdepasse.equals(passwordBis) == false ) {
			error.setPasswordBis("les mots de passe ne sont pas identiques");
			check = false;
		}
		if(check == false) {
			String statusMessage ="echec";
			request.setAttribute("statusMessage", statusMessage);
			request.setAttribute("error", error);
			getServletContext().getRequestDispatcher("/WEB-INF/patient/insert.jsp").forward(request,response);
		}
		else {
			Patient patient = null;
			try {
				patient = new Patient(nom,prenom,email,telephone,toHexString(getSHA(motdepasse)),date_de_naissance,sexe,adresse,situation_familliale,personne_a_prevenir,tel_personne_a_prevenir);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				System.out.print("erreur");
				e.printStackTrace();
			}
			PatientDao.insertUser(patient);
			String statusMessage ="OK";
			request.setAttribute("statusMessage", statusMessage);
			getServletContext().getRequestDispatcher("/WEB-INF/patient/insert.jsp").forward(request,response);

		}
		
		
	}
	
	//no 
	public static boolean isValidEmail(String email) {
        String check = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "("
                + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
	
	private boolean isValidPhone(String tel) {
        String regex = "^[0-9]*$";
        return tel.matches(regex);
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


}
