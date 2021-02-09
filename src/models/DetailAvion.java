package models;

public class Caracteristique {
	// Creation des variables
	private String typeAvion;
	private int capaciteAvion;
	private int idConstructeur;
	
	// Creation des constructeur
	public Caracteristique() {
	}
	public Caracteristique(String typeAvion, int capaciteAvion, int idConstructeur) {
			this.setTypeAvion(typeAvion);
			this.setCapaciteAvion(capaciteAvion);
			this.setIdConstructeur(idConstructeur);
	}
	//Creation des getter et setter
	public int getIdConstructeur() {
		return idConstructeur;
	}
	public void setIdConstructeur(int idConstructeur) {
		this.idConstructeur = idConstructeur;
	}
	public int getCapaciteAvion() {
		return capaciteAvion;
	}
	public void setCapaciteAvion(int capaciteAvion) {
		this.capaciteAvion = capaciteAvion;
	}
	public String getTypeAvion() {
		return typeAvion;
	}
	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}
}
