package models;


public class Avion {
	// Creation des variables
	private int numAvion;
	private String typeAvion;
	private String idAeroport;
	
	// Creation des constructeur
	public Avion() {	
	}
	
	public Avion(int numAvion, String typeAvion, String idAeroport) {
		this.setNumAvion(numAvion);
		this.setTypeAvion(typeAvion);
		this.setIdAeroport(idAeroport);
	}

	// Creation des getter et setter
	public int getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(int numAvion) {
		this.numAvion = numAvion;
	}

	public String getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public String getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(String idAeroport) {
		this.idAeroport = idAeroport;
	}
	
	
}


