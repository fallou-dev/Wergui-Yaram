package servlet.login;

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
import javax.servlet.http.HttpSession;

import dao.MedecinDao;
import Model.Medecin;

/**
 * Servlet implementation class loginmedecin
 */
@WebServlet("/loginmedecin")
public class loginmedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean check = true;
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		 try {

				String login = request.getParameter("login");
				String motdepasse = request.getParameter("password");
				
				if(login.length()< 8) {
					check = false;
				}
				if( isValidEmail(login) == false   ) {
					check = false;
				}
				if(motdepasse.length()<8) {
					check = false;
				}
				if(check == false) {
					String statusMessage ="echec";
					request.setAttribute("statusMessage", statusMessage);
					request.setAttribute("login", login);
					request.setAttribute("ConnexionFailed", true);

					getServletContext().getRequestDispatcher("/WEB-INF/medecin/loginmedecin.jsp").forward(request,response);
				} else {

					HttpSession session = request.getSession();
					motdepasse = toHexString(getSHA(motdepasse));
					Medecin medecin = MedecinDao.getMedecinBylogin(login, motdepasse);
					
					if(medecin != null ) {
						session.setMaxInactiveInterval(3000);
		                session.setAttribute("medecin", login);
		                
		                if(medecin.getRole().equals("ADMIN")) {
		                	response.sendRedirect("AcceuilAdmin");
		                }else {
							response.sendRedirect("AcceuilMedecin");
		                }
		                
					}
					
				}	
				
		 }catch(Exception e) {
			 
		 }
	 }
	 
	public static boolean isValidEmail(String email) {
	        String check = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "("
	                + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";
	        Pattern pattern = Pattern.compile(check);
	        Matcher matcher = pattern.matcher(email);

	        return matcher.matches();
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/medecin/loginmedecin.jsp");
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
