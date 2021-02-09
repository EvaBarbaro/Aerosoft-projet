package models;

public class Role {
    // Creation des variables
    private String idRole;
    private String roleNom;

    // Creation des constructeur
	public Role() {
	}

	public Role(String idRole, String roleNom) {
        this.setIdRole(idRole);
        this.setRoleNom(roleNom);
	}
	//Creation des getter et setter
    public String getIdRole() {
        return this.idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getRoleNom() {
        return this.roleNom;
    }

    public void setRoleNom(String roleNom) {
        this.roleNom = roleNom;
    }
}
