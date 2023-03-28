package forms.Medecin;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Model.Medecin;
import dao.MedecinDao;

public class InsertMedecinForm {

	private static final String CHAMP_NOM = "nom_medecin";
	
	private static final String CHAMP_PRENOM = "prenom_medecin";
	
	private static final String CHAMP_email="email";
	
	private static final String CHAMP_telephone="telephone";
	
	private static final String CHAMP_motdepasse="motdepasse";
	
	private static final String CHAMP_valide_compte="valide_compte";
	
	private static final String CHAMP_specialite="specialite";
	
	private static final String CHAMP_role="role";
	
	private static final String CHAMP_service_nom_service="service_nom_service";
	
	private static final String CHAMP_PASSWORD = "motdepasse";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	private static final String ECHEC_AJOUT_MESSAGE = "Echec de l'ajout";
	private static final String SUCCES_AJOUT_MESSAGE = "Ajout effectué";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseignez ce champ";
	private static final String DIFFERENT_PASSWORD_ERROR_MESSAGE = "Les mots de passes ne sont pas conformes";
	
	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private Medecin medecin;
	private boolean status;
	private String statusMessage;
	
	public InsertMedecinForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	

	public boolean ajouter() 
	{
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String email = this.getParameter(CHAMP_email);
		String password = this.getParameter(CHAMP_PASSWORD);
		String telephone = this.getParameter(CHAMP_telephone);
		String specialite = this.getParameter(CHAMP_specialite);
		String service_nom_service = this.getParameter(CHAMP_service_nom_service);
		
		this.hashmotdepasse();
		this.medecin = new Medecin(nom, prenom,email,password,telephone,specialite,service_nom_service);
		
		this.valider(CHAMP_NOM,CHAMP_PRENOM,CHAMP_email,CHAMP_PASSWORD,CHAMP_telephone,CHAMP_PASSWORD,CHAMP_telephone,CHAMP_specialite,CHAMP_service_nom_service);
		this.validerPassword();
		
		if(this.erreurs.isEmpty()) {
			//MedecinDao.insertMedecin(medecin);
			this.status = true;
			this.statusMessage = SUCCES_AJOUT_MESSAGE;
		}
		return this.status;
	}
	
	public String getParameter(String parametre) 
	{
		String valeur = this.request.getParameter(parametre);
		return (valeur == null  || valeur.trim().isEmpty()) ? null : valeur.trim(); 
	}
	
	public void valider(String...champs ) {
		for(String champ:champs) {
			if(this.getParameter(champ) == null) {
				erreurs.put(champ,EMPTY_FIELD_ERROR_MESSAGE);
			}
		}
		
	}
	
	public void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if(password != null && !password.equals(passwordBis)) {
			erreurs.put(CHAMP_PASSWORD, DIFFERENT_PASSWORD_ERROR_MESSAGE);
			erreurs.put(CHAMP_PASSWORD_BIS, DIFFERENT_PASSWORD_ERROR_MESSAGE);
		}
	}

	public void validerString() {
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String specialite = this.getParameter(CHAMP_specialite);
		
		if((nom.length()<3 && nom.length()>15) || (prenom.length()<3 && prenom.length()>40) || (specialite.length()<3 && specialite.length()>20) ) {
			erreurs.put(CHAMP_NOM, EMPTY_FIELD_ERROR_MESSAGE);
			erreurs.put(CHAMP_PRENOM, EMPTY_FIELD_ERROR_MESSAGE);
			erreurs.put(CHAMP_specialite, EMPTY_FIELD_ERROR_MESSAGE);
		}
	}
	
	public void validerTelephone() {
		String tel = this.getParameter(CHAMP_telephone);
		String regex = "^[0-9]*$";
		if(tel.matches(regex) == false) {
			erreurs.put(CHAMP_telephone, EMPTY_FIELD_ERROR_MESSAGE);
		}
        
	}

	public void validerRole() {
		String role = this.getParameter(CHAMP_role);
		if(role == null || role.equals("USER") == false || role.equals("ADMIN") == false || role.equals("CS")) {
			erreurs.put(CHAMP_role, EMPTY_FIELD_ERROR_MESSAGE);
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

    
    public void hashmotdepasse() {
    	String motdepasse = this.getParameter(CHAMP_PASSWORD);
    	try {
			toHexString(getSHA(motdepasse));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}


	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getStatusMessage() {
		return statusMessage;
	}


	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}


	public static String getChampNom() {
		return CHAMP_NOM;
	}


	public static String getChampPrenom() {
		return CHAMP_PRENOM;
	}


	public static String getChampEmail() {
		return CHAMP_email;
	}


	public static String getChampTelephone() {
		return CHAMP_telephone;
	}


	public static String getChampMotdepasse() {
		return CHAMP_motdepasse;
	}


	public static String getChampValideCompte() {
		return CHAMP_valide_compte;
	}


	public static String getChampSpecialite() {
		return CHAMP_specialite;
	}


	public static String getChampRole() {
		return CHAMP_role;
	}



	public static String getChampServiceNomService() {
		return CHAMP_service_nom_service;
	}


	public static String getChampPassword() {
		return CHAMP_PASSWORD;
	}


	public static String getChampPasswordBis() {
		return CHAMP_PASSWORD_BIS;
	}


	public static String getEchecAjoutMessage() {
		return ECHEC_AJOUT_MESSAGE;
	}


	public static String getSuccesAjoutMessage() {
		return SUCCES_AJOUT_MESSAGE;
	}


	public static String getEmptyFieldErrorMessage() {
		return EMPTY_FIELD_ERROR_MESSAGE;
	}


	public static String getDifferentPasswordErrorMessage() {
		return DIFFERENT_PASSWORD_ERROR_MESSAGE;
	}


}
