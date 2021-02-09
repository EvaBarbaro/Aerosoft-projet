package models;

public class Pilote {
	private int idPilote;
	private String nomPilote;
	private String prenomPilote;
	
	public Pilote() {
	}
	
	public Pilote(int idPilote, String nomPilote, String prenomPilote) {
		this.setIdPilote(idPilote);
		this.setNomPilote(nomPilote);
		this.setPrenomPilote(prenomPilote);
	}

	public int getIdPilote() {
		return idPilote;
	}

	public void setIdPilote(int idPilote) {
		this.idPilote = idPilote;
	}

	public String getNomPilote() {
		return nomPilote;
	}

	public void setNomPilote(String nomPilote) {
		this.nomPilote = nomPilote;
	}

	public String getPrenomPilote() {
		return prenomPilote;
	}

	public void setPrenomPilote(String prenomPilote) {
		this.prenomPilote = prenomPilote;
	}
	
}
