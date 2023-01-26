package forms.consultation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Model.Consultation;
import dao.ConsultationDao;


public class AddFormConsultation {
private static final String CHAMP_Date_Consultation = "Date_consultation";
	
	private static final String CHAMP_Synthese = "Synthese";
	
	private static final String CHAMP_medecin_idmedecin="medecin_idmedecin";
	
	private static final String CHAMP_patient_idpatient="patient_idpatient";
	
	private static final String CHAMP_service_nom_service="service_nom_service";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Ne doit pas etre vide";
	
	private static final String ECHEC_AJOUT_MESSAGE = "Echec de l'ajout";
	private static final String SUCCES_AJOUT_MESSAGE = "Ajout effectué";
	private static final String VerifNumber = "Vous devez renseigner un nombre";
	private static final String DIFFERENT_PASSWORD_ERROR_MESSAGE = "Les mots de passes ne sont pas conformes";
	
	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private Consultation consultation;
	private boolean status;
	private String statusMessage;
	
	public AddFormConsultation(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	

	public boolean ajouter() 
	{
		String date_consultation = this.getParameter(CHAMP_Date_Consultation);
		String synthese = this.getParameter(CHAMP_Synthese);
		int medecin = Integer.parseInt(this.getParameter(CHAMP_medecin_idmedecin));
		int patient = Integer.parseInt(this.getParameter(CHAMP_patient_idpatient));
		String nomservice = this.getParameter(CHAMP_service_nom_service);
		
		
		//this.consultation = new Consultation(date_consultation, synthese,medecin,patient,nomservice);
		
		this.valider(CHAMP_Date_Consultation,CHAMP_Synthese,CHAMP_service_nom_service);
		
		if(this.erreurs.isEmpty()) {
			ConsultationDao.insertConsultation(consultation);
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


	public Consultation getConsultation() {
		return consultation;
	}


	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
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


	public static String getChampDateConsultation() {
		return CHAMP_Date_Consultation;
	}


	public static String getChampSynthese() {
		return CHAMP_Synthese;
	}


	public static String getChampMedecinIdmedecin() {
		return CHAMP_medecin_idmedecin;
	}


	public static String getChampPatientIdpatient() {
		return CHAMP_patient_idpatient;
	}


	public static String getChampServiceNomService() {
		return CHAMP_service_nom_service;
	}


	public static String getEmptyFieldErrorMessage() {
		return EMPTY_FIELD_ERROR_MESSAGE;
	}


	public static String getEchecAjoutMessage() {
		return ECHEC_AJOUT_MESSAGE;
	}


	public static String getSuccesAjoutMessage() {
		return SUCCES_AJOUT_MESSAGE;
	}


	public static String getVerifnumber() {
		return VerifNumber;
	}


	public static String getDifferentPasswordErrorMessage() {
		return DIFFERENT_PASSWORD_ERROR_MESSAGE;
	}
	
	

}
