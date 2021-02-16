package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import interfaces.Dao;
import models.*;
import vues.SDialog;

public class RoleDao implements Dao {
    public Object get(Object id) {
		Role role = null;
        String idSearch = String.valueOf(id);

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM `ROLES` WHERE RoleNom=?";

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idSearch);

			System.out.println("Voici les informations du role " + idSearch);
			ResultSet res = stmt.executeQuery();

			while(res.next()){
				role = new Role(
					res.getString("IdRole"),
                    res.getString("RoleNom")
					);

                System.out.println("ID: " + role.getIdRole());
                System.out.println("Nom: " + role.getRoleNom());
		      }
			res.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

    public ArrayList<Role> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM `ROLES`";

		ArrayList<Role> listeRole = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				Role role = new Role(
					res.getString("IdRole"), 
					res.getString("RoleNom")
				);

				listeRole.add(role);
			}
			  
		    res.close();
			conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible d'afficher les roles");
			}
		return listeRole;
	}

	@Override
	public void save(Object t, String[] params) {
		Role role =(Role) t;

		Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO `ROLES` (IdRole,RoleNom) VALUES (?,?)";

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,params[0]);
			stmt.setString(2,params[1]);
			
			stmt.execute();
			
			System.out.println(role.getIdRole() + " a bien été ajouté");
			new SDialog("Ajout", "Ajouter reussie", "Valider", "").setVisible(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
			new SDialog("Echec", "L'ajout n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}

	}

	@Override
	public void update(Object t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub

	}

	public String getRoleNomByIdRole(String idSearch) {
		
		String nom = ""
		;		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT RoleNom FROM `ROLES` WHERE IdRole=?";

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idSearch);

			System.out.println("Voici les informations du role " + idSearch);
			ResultSet res = stmt.executeQuery();

			while(res.next()){
				nom = res.getString("RoleNom");
		      }
			res.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nom;
	}
}
