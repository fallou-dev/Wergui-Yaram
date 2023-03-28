package Model;

import java.util.Date;

public class Consultation {

	private int idconsultation;
	
	private Date date_consultation;
	
	private String Synthese;
	
	private int medecin_idmedecin;
	
	private int patient_idpatient;

	public int getIdconsultation() {
		return idconsultation;
	}

	public void setIdconsultation(int idconsultation) {
		this.idconsultation = idconsultation;
	}

	public Date getDate_consultation() {
		return date_consultation;
	}

	public void setDate_consultation(Date date_consultation) {
		this.date_consultation = date_consultation;
	}

	public String getSynthese() {
		return Synthese;
	}

	public void setSynthese(String synthese) {
		Synthese = synthese;
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
	
	
}
