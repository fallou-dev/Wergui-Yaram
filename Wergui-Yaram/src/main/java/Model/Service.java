package Model;

public class Service {

	private int idservice;
	
	private String nom_service;
	
	

	public Service() {
		
	}



	public Service(String nom_service) {
		super();
		this.nom_service = nom_service;
	}

	

	public int getIdservice() {
		return idservice;
	}

	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}

	public String getNom_service() {
		return nom_service;
	}

	public void setNom_service(String nom_service) {
		this.nom_service = nom_service;
	}
	
	
}
