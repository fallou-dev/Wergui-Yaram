package servlet.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import dao.PatientDao;
import Model.Patient;
import dto.ErrorLoginPatient;
/**
 * Servlet implementation class loginpatient
 */
@WebServlet("/loginpatient")
public class loginpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	boolean check = true;
	ErrorLoginPatient error = new ErrorLoginPatient();
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		 try {

				String login = request.getParameter("login");
				String motdepasse = request.getParameter("password");
				
				if(login.length() != 9) {
					error.setTelephone("Entrez un bon numero de telephone");
					check = false;
				}
				
				if( isValidPhone(login) == false ) {
					error.setTelephone("Entrez un bon numero de telephone");
					check = false;
				}
				
				if( isValidPhone(login) == true && login.length() != 9 ) {
					error.setTelephone("Entrez un bon numero de telephone");
					check = false;
				}
				if(motdepasse.length()<8) {
					error.setMotdepasse("Entrez un mot de passe correct");
					check = false;
				}
				if(check == false) {
					String statusMessage ="echec";
					request.setAttribute("statusMessage", statusMessage);
					request.setAttribute("login", login);
					request.setAttribute("ConnexionFailed", true);
					request.setAttribute("error", error);
					getServletContext().getRequestDispatcher("/WEB-INF/patient/loginpatient.jsp").forward(request,response);
				} else {

					HttpSession session = request.getSession();
					motdepasse = toHexString(getSHA(motdepasse));
					Patient patient = PatientDao.getUserBylogin(login, motdepasse);
					
					if(patient != null ) {
						session.setMaxInactiveInterval(3000);
		                session.setAttribute("patient", login);
		                
						//getServletContext().getRequestDispatcher("/WEB-INF/PagePatient/Acceuil.jsp").forward(request,response);
						response.sendRedirect("Acceuil");
					}
					
				}	
				
		 }catch(Exception e) {
			 
		 }
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
	    
	    private boolean isValidPhone(String tel) {
	        String regex = "^[0-9]*$";
	        return tel.matches(regex);
	    }
	    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/patient/loginpatient.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
