package Model;

public class Medecin {

    private int idmedecin;
	
	private String nom_medecin;
	
	private String prenom_medecin;
	
	private String email;
	
	private String telephone;
	
	private String motdepasse;
	
	private int valide_compte;
	
	private String specialite;
	
	private String role;
	
	private String service_nom_service;

	

	public Medecin() {
	
	}

	public Medecin( String nom_medecin, String prenom_medecin, String email, String telephone,
			String motdepasse, String specialite, String service_nom_service) {
		this.nom_medecin = nom_medecin;
		this.prenom_medecin = prenom_medecin;
		this.email = email;
		this.telephone = telephone;
		this.motdepasse = motdepasse;
		this.specialite = specialite;
		this.service_nom_service = service_nom_service;
	}

	public Medecin(String nom_medecin, String prenom_medecin, String email, String telephone, String motdepasse,
			int valide_compte, String specialite, String role, String service_nom_service) {
		super();
		this.nom_medecin = nom_medecin;
		this.prenom_medecin = prenom_medecin;
		this.email = email;
		this.telephone = telephone;
		this.motdepasse = motdepasse;
		this.valide_compte = valide_compte;
		this.specialite = specialite;
		this.role = role;
		this.service_nom_service = service_nom_service;
	}

	

	public int getIdmedecin() {
		return idmedecin;
	}

	public void setIdmedecin(int idmedecin) {
		this.idmedecin = idmedecin;
	}

	public String getNom_medecin() {
		return nom_medecin;
	}

	public void setNom_medecin(String nom_medecin) {
		this.nom_medecin = nom_medecin;
	}

	public String getPrenom_medecin() {
		return prenom_medecin;
	}

	public void setPrenom_medecin(String prenom_medecin) {
		this.prenom_medecin = prenom_medecin;
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

	public int getValide_compte() {
		return valide_compte;
	}

	public void setValide_compte(int valide_compte) {
		this.valide_compte = valide_compte;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getService_nom_service() {
		return service_nom_service;
	}

	public void setService_nom_service(String service_nom_service) {
		this.service_nom_service = service_nom_service;
	}

	
	
	
	
}
