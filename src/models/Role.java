package models;

public class Role {
    // Creation des variables
    private String idRole;
    private String RoleNom;

    // Creation des constructeur
	public Role() {
	}

	public Role(String idRole, String RoleNom) {
        this.setIdRole(idRole);
        this.setRoleNom(RoleNom);
	}
	//Creation des getter et setter
    public String getIdRole() {
        return this.idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getRoleNom() {
        return this.RoleNom;
    }

    public void setRoleNom(String RoleNom) {
        this.RoleNom = RoleNom;
    }
}
