package Model;

public class Patient {

	private int idpatient;
	
	private String nom_patient;
	
	private String prenom_patient;
	
	private String email;
	
	private String telephone;
	
	private String motdepasse;
	
	private String Date_de_naissance;
	
	private String Sexe;
	
	private String Adresse;
	
	private String Situation_familliale;
	
	private String Personne_a_prevenir;
	
	private String tel_Personne_a_prevenir;
	
	private int valide_compte;

	
	
	public Patient() {
	
	}

	public Patient(String nom_patient, String prenom_patient, String email, String telephone, String motdepasse,
			String date_de_naissance, String sexe, String adresse, String situation_familliale,
			String personne_a_prevenir, String tel_Personne_a_prevenir, int valide_compte) {
		super();
		this.nom_patient = nom_patient;
		this.prenom_patient = prenom_patient;
		this.email = email;
		this.telephone = telephone;
		this.motdepasse = motdepasse;
		Date_de_naissance = date_de_naissance;
		Sexe = sexe;
		Adresse = adresse;
		Situation_familliale = situation_familliale;
		Personne_a_prevenir = personne_a_prevenir;
		this.tel_Personne_a_prevenir = tel_Personne_a_prevenir;
		this.valide_compte = valide_compte;
	}

	public String getTel_Personne_a_prevenir() {
		return tel_Personne_a_prevenir;
	}

	public void setTel_Personne_a_prevenir(String tel_Personne_a_prevenir) {
		this.tel_Personne_a_prevenir = tel_Personne_a_prevenir;
	}

	public int getIdpatient() {
		return idpatient;
	}

	public void setIdpatient(int idpatient) {
		this.idpatient = idpatient;
	}

	public String getNom_patient() {
		return nom_patient;
	}

	public void setNom_patient(String nom_patient) {
		this.nom_patient = nom_patient;
	}

	public String getPrenom_patient() {
		return prenom_patient;
	}

	public void setPrenom_patient(String prenom_patient) {
		this.prenom_patient = prenom_patient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getDate_de_naissance() {
		return Date_de_naissance;
	}

	public void setDate_de_naissance(String date_de_naissance) {
		Date_de_naissance = date_de_naissance;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getSituation_familliale() {
		return Situation_familliale;
	}

	public void setSituation_familliale(String situation_familliale) {
		Situation_familliale = situation_familliale;
	}

	public String getPersonne_a_prevenir() {
		return Personne_a_prevenir;
	}

	public void setPersonne_a_prevenir(String personne_a_prevenir) {
		Personne_a_prevenir = personne_a_prevenir;
	}

	public int getValide_compte() {
		return valide_compte;
	}

	public void setValide_compte(int valide_compte) {
		this.valide_compte = valide_compte;
	}
	
	
}
