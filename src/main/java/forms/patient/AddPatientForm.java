package forms.patient;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Model.Patient;
import dao.PatientDao;

public class AddPatientForm {
	private static final String CHAMP_NOM = "nom_patient";
	private static final String CHAMP_PRENOM = "prenom_patient";
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_TEL = "telephone";
	private static final String CHAMP_PASSWORD = "motdepasse";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	private static final String CHAMP_Date_de_naissance="date_de_naissance";
	
	private static final String CHAMP_Sexe = "sexe";
	
	private static final String CHAMP_Adresse = "adresse";
	
	private static final String CHAMP_Situation_familliale ="situation_familliale";
	
	private static final String CHAMP_Personne_a_prevenir = "personne_a_prevenir";
	
	private static final String CHAMP_tel_Personne_a_prevenir="tel_Personne_a_prevenir";
	
	
	private static final String ECHEC_AJOUT_MESSAGE = "Echec de l'ajout";
	private static final String SUCCES_AJOUT_MESSAGE = "Ajout effectué";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseignez ce champ";
	private static final String DIFFERENT_PASSWORD_ERROR_MESSAGE = "Les mots de passes ne sont pas conformes";
	
	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private Patient patient;
	private boolean status;
	private String statusMessage;
	
	public AddPatientForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	

	public boolean ajouter() 
	{
		String nom_patient = this.getParameter(CHAMP_NOM);
		String prenom_patient = this.getParameter(CHAMP_PRENOM);
		String email = this.getParameter(CHAMP_EMAIL);
		String motdepasse = this.getParameter(CHAMP_PASSWORD);
		String telephone = this.getParameter(CHAMP_TEL);
		String date_de_naissance = this.getParameter(CHAMP_Date_de_naissance);
		String sexe = this.getParameter(CHAMP_Sexe);
		String adresse = this.getParameter(CHAMP_Adresse);
		String situation_familliale = this.getParameter(CHAMP_Situation_familliale);
		String personne_a_prevenir = this.getParameter(CHAMP_Personne_a_prevenir);
		String tel_personne_a_prevenir = this.getParameter(CHAMP_tel_Personne_a_prevenir);
	
		
		this.patient = new Patient(nom_patient,prenom_patient,email,motdepasse,telephone,date_de_naissance,sexe,adresse,situation_familliale,personne_a_prevenir,tel_personne_a_prevenir);
		this.valider(CHAMP_NOM,CHAMP_PRENOM,CHAMP_EMAIL,CHAMP_PASSWORD,CHAMP_TEL,CHAMP_Date_de_naissance,CHAMP_Sexe,CHAMP_Adresse,CHAMP_Situation_familliale,CHAMP_Personne_a_prevenir,CHAMP_tel_Personne_a_prevenir);
		
		this.validerPassword();
		
		if(this.erreurs.isEmpty()) {
			PatientDao.insertUser(patient);
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


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
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
		return CHAMP_EMAIL;
	}


	public static String getChampTel() {
		return CHAMP_TEL;
	}


	public static String getChampPassword() {
		return CHAMP_PASSWORD;
	}


	public static String getChampPasswordBis() {
		return CHAMP_PASSWORD_BIS;
	}


	public static String getChampDateDeNaissance() {
		return CHAMP_Date_de_naissance;
	}


	public static String getChampSexe() {
		return CHAMP_Sexe;
	}


	public static String getChampAdresse() {
		return CHAMP_Adresse;
	}


	public static String getChampSituationFamilliale() {
		return CHAMP_Situation_familliale;
	}


	public static String getChampPersonneAPrevenir() {
		return CHAMP_Personne_a_prevenir;
	}


	public static String getChampTelPersonneAPrevenir() {
		return CHAMP_tel_Personne_a_prevenir;
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
