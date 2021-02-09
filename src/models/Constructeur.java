package models;

public class Constructeur {
	//variables
	private int idConstructeur;
	private String nomConstructeur;
	
	//constructeur
	public Constructeur() {
	}
	public Constructeur(int idConstructeur, String nomConstructeur) {
		this.setIdConstructeur(idConstructeur);
		this.setNomConstructeur(nomConstructeur);
	}
	//getter et setter
	public int getIdConstructeur() {
		return idConstructeur;
	}
	public void setIdConstructeur(int idConstructeur) {
		this.idConstructeur = idConstructeur;
	}
	public String getNomConstructeur() {
		return nomConstructeur;
	}
	public void setNomConstructeur(String nomConstructeur) {
		this.nomConstructeur = nomConstructeur;
	}
	
}
