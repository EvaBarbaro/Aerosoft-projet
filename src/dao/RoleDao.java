package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;

public class RoleDao {
    public Object get(Object id) {
		Role role = null;
        String idSearch = String.valueOf(id);

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM roles WHERE RoleNom=?";

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
		String sql = "SELECT * FROM roles";

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
}
