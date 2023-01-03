package Model;

import java.util.Date;

public class RendezVous {

	private int idRendez_vous;
	
	private Date date_rv;
	
	private int medecin_idmedecin;
	
	private int patient_idpatient;
	
	

	public RendezVous() {
		
	}

	public RendezVous(Date date_rv, int medecin_idmedecin, int patient_idpatient) {
		this.date_rv = date_rv;
		this.medecin_idmedecin = medecin_idmedecin;
		this.patient_idpatient = patient_idpatient;
	}

	public int getIdRendez_vous() {
		return idRendez_vous;
	}

	public void setIdRendez_vous(int idRendez_vous) {
		this.idRendez_vous = idRendez_vous;
	}

	public Date getDate_rv() {
		return date_rv;
	}

	public void setDate_rv(Date date_rv) {
		this.date_rv = date_rv;
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
