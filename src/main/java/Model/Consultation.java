package Model;

import java.util.Date;

public class Consultation {
	private int idconsultation;

	private Date Date_consultation;
	
	private String synthese;
	
	private  int medecin_idmedecin;
	
	private  int patient_idpatient;
	
	private String service_nomservice;
	
	

	public Consultation() {
	
	}



	public Consultation(Date date_consultation, String synthese, int medecin_idmedecin, int patient_idpatient,
			String service_nomservice) {
		super();
		Date_consultation = date_consultation;
		this.synthese = synthese;
		this.medecin_idmedecin = medecin_idmedecin;
		this.patient_idpatient = patient_idpatient;
		this.service_nomservice = service_nomservice;
	}



	public int getIdconsultation() {
		return idconsultation;
	}



	public void setIdconsultation(int idconsultation) {
		this.idconsultation = idconsultation;
	}



	public Date getDate_consultation() {
		return Date_consultation;
	}



	public void setDate_consultation(Date date_consultation) {
		Date_consultation = date_consultation;
	}



	public String getSynthese() {
		return synthese;
	}



	public void setSynthese(String synthese) {
		this.synthese = synthese;
	}



	public int getMedecin_idmedecin() {
		return medecin_idmedecin;
	}



	public void setMedecin_idmedecin(int medecin_idmedecin) {
		this.medecin_idmedecin = medecin_idmedecin;
	}



	public int getPatient_idpatient() {
		return patient_idpatient;
	}



	public void setPatient_idpatient(int patient_idpatient) {
		this.patient_idpatient = patient_idpatient;
	}



	public String getService_nomservice() {
		return service_nomservice;
	}



	public void setService_nomservice(String service_nomservice) {
		this.service_nomservice = service_nomservice;
	}



	
}

