package models;

public class Caracteristique {
	// Creation des variables
	private String typeAvion;
	private int capaciteAvion;
	private int idContructeur;
	
	// Creation des constructeur
	public Caracteristique() {
	}
	public Caracteristique(String typeAvion, int capaciteAvion, int idConstructeur) {
			this.setTypeAvion(typeAvion);
			this.setCapaciteAvion(capaciteAvion);
			this.setIdContructeur(idConstructeur);
	}
	//Creation des getter et setter
	public int getIdContructeur() {
		return idContructeur;
	}
	public void setIdContructeur(int idContructeur) {
		this.idContructeur = idContructeur;
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
