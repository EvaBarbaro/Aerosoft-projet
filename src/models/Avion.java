package models;


public class Avion {
	// Creation des variables
	private int numAvion;
	private String typeAvion;
	private String baseAeroport;
	
	// Creation des constructeur
	public Avion() {	
	}
	
	public Avion(int numAvion, String typeAvion, String baseAeroport) {
		this.setNumAvion(numAvion);
		this.setTypeAvion(typeAvion);
		this.setBaseAeroport(baseAeroport);
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

	public String getBaseAeroport() {
		return baseAeroport;
	}

	public void setBaseAeroport(String baseAeroport) {
		this.baseAeroport = baseAeroport;
	}
	
	
}


