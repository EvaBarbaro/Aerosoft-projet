package models;

public class Utilisateur {
    // Creation des variables
	private int idUtilisateur;
    private String mail;
    private String motDePasse;
    private boolean statut = false;
    private String idRole;
	
	// Creation des constructeur
	public Utilisateur() {
	}

	public Utilisateur(int idUtilisateur, String mail, String motDePasse, boolean statut, String idRole) {
        this.setIdUtilisateur(idUtilisateur);
        this.setMail(mail);
        this.setMotDePasse(motDePasse);
        this.setStatut(statut);
        this.setIdRole(idRole);
	}
	//Creation des getter et setter
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean getStatut() {
        return this.statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getIdRole() {
        return this.idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }
}
