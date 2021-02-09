package models;
import java.util.Date;

public class Affectation {
	private String numVol;
	private Date dateVol;
	private int numAvion;
	private int idPilote;
	
	public Affectation() {
	}
	public Affectation(String numVol, Date dateVol, int numAvion, int idPilote) {
		this.setNumVol(numVol);
		this.setDateVol(dateVol);
		this.setNumAvion(numAvion);
		this.setIdPilote(idPilote);
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
	public int getIdPilote() {
		return idPilote;
	}
	public void setIdPilote(int idPilote) {
		this.idPilote = idPilote;
	}
	
}
