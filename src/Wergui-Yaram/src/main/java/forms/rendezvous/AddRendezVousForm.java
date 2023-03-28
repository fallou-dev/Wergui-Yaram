package forms.rendezvous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.RendezVous_dao;
import Model.RendezVous;

public class AddRendezVousForm {

	private static final String CHAMP_DateRv = "date";
	private static final String CHAMP_idMedecin = "idmedecin";
	private static final String CHAMP_idPatient = "idpatient";
	private static final String ECHEC_AJOUT_MESSAGE = "Echec de l'ajout";
	private static final String SUCCES_AJOUT_MESSAGE = "Ajout effectué";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseignez ce champ";
	
	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private RendezVous rv;
	private boolean status;
	private String statusMessage;
	
	public AddRendezVousForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	

	public boolean ajouter() throws ParseException 
	{

		String date = this.getParameterString(CHAMP_DateRv);
		int idmedecin = this.getParameterInt(CHAMP_idMedecin);
		int idpatient = this.getParameterInt(CHAMP_idPatient);
		
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		
		this.rv = new RendezVous(date1,idmedecin,idpatient);
		
		this.valider(CHAMP_DateRv,CHAMP_idMedecin,CHAMP_idPatient);
		
		if(this.erreurs.isEmpty()) {
			RendezVous_dao.insertRv(rv);
			this.status = true;
			this.statusMessage = SUCCES_AJOUT_MESSAGE;
		}
		return this.status;
	}
	
	public String getParameterString(String parametre) 
	{
		String valeur = this.request.getParameter(parametre);
		return (valeur == null  || valeur.trim().isEmpty()) ? null : valeur.trim(); 
	}
	
	public int getParameterInt(String parametre) 
	{
		String valeur = this.request.getParameter(parametre);
		int parametre2 = Integer.parseInt(valeur);
		return (parametre2 == 0 ) ? 0 : parametre2; 
	}
	
	public void valider(String...champs ) {
		for(String champ:champs) {
			if(this.getParameterString(champ) == null) {
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


	public RendezVous getRv() {
		return rv;
	}


	public void setRv(RendezVous rv) {
		this.rv = rv;
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


	public static String getChampDaterv() {
		return CHAMP_DateRv;
	}


	public static String getChampIdmedecin() {
		return CHAMP_idMedecin;
	}


	public static String getChampIdpatient() {
		return CHAMP_idPatient;
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
	
	
}
