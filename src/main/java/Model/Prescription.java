package Model;

import java.util.Date;

public class Prescription {

	private int idprescription;
	
	private Date date_prescription;
	
	private String Note;
	
	private int consultation_idconsultation;

	public Prescription(Date date_prescription, String note, int consultation_idconsultation) {
		super();
		this.date_prescription = date_prescription;
		Note = note;
		this.consultation_idconsultation = consultation_idconsultation;
	}

	public Prescription() {
		
	}

	public int getIdprescription() {
		return idprescription;
	}

	public void setIdprescription(int idprescription) {
		this.idprescription = idprescription;
	}

	public Date getDate_prescription() {
		return date_prescription;
	}

	public void setDate_prescription(Date date_prescription) {
		this.date_prescription = date_prescription;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public int getConsultation_idconsultation() {
		return consultation_idconsultation;
	}

	public void setConsultation_idconsultation(int consultation_idconsultation) {
		this.consultation_idconsultation = consultation_idconsultation;
	}
	
}
