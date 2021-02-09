package models;

public class Vol {
	private String numVol;
	private String aeroprtDepart;
	private String heureDepart;
	private String aeroportArrive;
	private String heureArrive;
	
	public Vol() {
	}
	public Vol(String numVol, String aeroportDepart, String heureDepart, String aeroportArrive, String heureArrive) {
		this.setNumVol(numVol);
		this.setAeroprtDepart(aeroportDepart);
		this.setHeureDepart(heureDepart);
		this.setAeroportArrive(aeroportArrive);
		this.setHeureArrive(heureArrive);
	}
	public String getNumVol() {
		return numVol;
	}
	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}
	public String getAeroprtDepart() {
		return aeroprtDepart;
	}
	public void setAeroprtDepart(String aeroprtDepart) {
		this.aeroprtDepart = aeroprtDepart;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getAeroportArrive() {
		return aeroportArrive;
	}
	public void setAeroportArrive(String aeroportArrive) {
		this.aeroportArrive = aeroportArrive;
	}
	public String getHeureArrive() {
		return heureArrive;
	}
	public void setHeureArrive(String heureArrive) {
		this.heureArrive = heureArrive;
	}
	
}
