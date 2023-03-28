package dto;

public class ErrorLoginPatient {

	String telephone;
	String motdepasse;
	
	public ErrorLoginPatient() {
	
	}

	public ErrorLoginPatient(String telephone, String motdepasse) {
		super();
		this.telephone = telephone;
		this.motdepasse = motdepasse;
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
	
	
	
}
