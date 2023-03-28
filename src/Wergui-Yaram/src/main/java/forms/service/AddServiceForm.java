package forms.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.Service_dao;
import Model.Service;

public class AddServiceForm {

	private static final String CHAMP_NOM_SERVICE = "nom_service";
	private static final String ECHEC_AJOUT_MESSAGE = "Echec de l'ajout";
	private static final String SUCCES_AJOUT_MESSAGE = "Ajout effectué";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseignez ce champ";
	
	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private Service service;
	private boolean status;
	private String statusMessage;
	
	public AddServiceForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	

	public boolean ajouter() 
	{
		String nom_service = this.getParameter(CHAMP_NOM_SERVICE);
		
		this.service = new Service(nom_service);
		
		this.valider(CHAMP_NOM_SERVICE);
		
		if(this.erreurs.isEmpty()) {
			Service_dao.insertUser(service);
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


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
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


	public static String getChampNomService() {
		return CHAMP_NOM_SERVICE;
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
