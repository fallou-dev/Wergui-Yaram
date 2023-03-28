package Model;

import java.util.Date;

public class RendezVous {

	private int idRendezvous;
	
	private Date date_rv;
	
	private int patient_idpatient;
	
	private String service_nom_service;

	public RendezVous() {

	}

	public RendezVous(Date date_rv, int patient_idpatient, String service_nom_service) {
		super();
		this.date_rv = date_rv;
		this.patient_idpatient = patient_idpatient;
		this.service_nom_service = service_nom_service;
	}

	public int getIdRendezvous() {
		return idRendezvous;
	}

	public void setIdRendezvous(int idRendezvous) {
		this.idRendezvous = idRendezvous;
	}

	public Date getDate_rv() {
		return date_rv;
	}

	public void setDate_rv(Date date_rv) {
		this.date_rv = date_rv;
	}

	public int getPatient_idpatient() {
		return patient_idpatient;
	}

	public void setPatient_idpatient(int patient_idpatient) {
		this.patient_idpatient = patient_idpatient;
	}

	public String getService_nom_service() {
		return service_nom_service;
	}

	public void setService_nom_service(String service_nom_service) {
		this.service_nom_service = service_nom_service;
	}

	
	
	
	
}
