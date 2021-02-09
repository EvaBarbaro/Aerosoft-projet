package models;
import java.util.Date;

public class Affectation {
	private int id;
	private String numVol;
	private Date dateVol;
	private Boolean affectationCode;
	private int numAvion;
	private Pilote pilote;
	
	public Affectation() {
	}

	public Affectation(int id, String numVol, Boolean affectationCode, Date dateVol, int numAvion, Pilote pilote) {
		this.setNumVol(numVol);
		this.setDateVol(dateVol);
		this.setAffectationCode(affectationCode);
		this.setNumAvion(numAvion);
		this.setPilote(pilote);
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean isAffectationCode() {
		return this.affectationCode;
	}

	public Boolean getAffectationCode() {
		return this.affectationCode;
	}
	
	public String getNumVol() {
		return numVol;
	}
	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}
	public Date getDateVol() {
		return dateVol;
	}
	public void setDateVol(Date dateVol) {
		this.dateVol = dateVol;
	}
	public int getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(int numAvion) {
		this.numAvion = numAvion;
	}
	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}



	public void setAffectationCode(Boolean affectationCode) {
		this.affectationCode = affectationCode;
	}
	
}
