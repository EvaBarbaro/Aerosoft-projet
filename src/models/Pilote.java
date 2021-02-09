package models;

public class Pilote {
	private int idPilote;
	private String nomPilote;
	private String prenomPilote;
	private String matricule;
	
	public Pilote() {
	}
	
	public Pilote(int idPilote, String nomPilote, String prenomPilote, String matricule) {
		this.setIdPilote(idPilote);
		this.setNomPilote(nomPilote);
		this.setPrenomPilote(prenomPilote);
		this.setMatricule(matricule);
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

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
}
