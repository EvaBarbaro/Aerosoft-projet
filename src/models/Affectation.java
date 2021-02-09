package models;
import java.util.Date;

public class Affectation {
	private String numVol;
	private Date dateVol;
	private Boolean affectationCode;
	private int numAvion;
	private Pilote pilote;
	
	public Affectation() {
	}

	public Affectation(String numVol,Boolean affectationCode, Date dateVol, int numAvion, Pilote pilote) {
		this.setNumVol(numVol);
		this.setDateVol(dateVol);
		this.setAffectationCode(affectationCode);
		this.setNumAvion(numAvion);
		this.setPilote(pilote);
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

	public Boolean getAffectationCode() {
		return this.affectationCode;
	}

	public void setAffectationCode(Boolean affectationCode) {
		this.affectationCode = affectationCode;
	}
	
}
