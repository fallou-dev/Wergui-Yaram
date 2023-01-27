package forms.Medecin;

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
		
		
		this.medecin = new Medecin(nom, prenom,email,password,telephone,specialite,service_nom_service);
		
		this.valider(CHAMP_NOM,CHAMP_PRENOM,CHAMP_email,CHAMP_PASSWORD,CHAMP_telephone,CHAMP_PASSWORD,CHAMP_telephone,CHAMP_specialite,CHAMP_service_nom_service);
		this.validerPassword();
		
		if(this.erreurs.isEmpty()) {
			MedecinDao.insertMedecin(medecin);
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
