package models;

public class Aeroport {
	private String idAeroport;
	private String nomAeroport;
	private String nomVille;
	
	public Aeroport() {
	}
	public Aeroport(String idAeroport, String nomAeroport, String nomVille) {
		this.setIdAeroport(idAeroport);
		this.setNomAeroport(nomAeroport);
		this.setNomVille(nomVille);
	}
	public String getIdAeroport() {
		return idAeroport;
	}
	public void setIdAeroport(String idAeroport) {
		this.idAeroport = idAeroport;
	}
	public String getNomAeroport() {
		return nomAeroport;
	}
	public void setNomAeroport(String nomAeroport) {
		this.nomAeroport = nomAeroport;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	

}
