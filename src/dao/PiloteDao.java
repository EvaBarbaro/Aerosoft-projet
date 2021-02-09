package dao;

import java.sql.*;

import connexion.ConnectionBdd;
import models.*;

public class PiloteDao {
	public static void insertPilote(Pilote pilote) {
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO pilote (nom_pilote,prenom_pilote) VALUES (?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Les points d'interogation vont prendre les info de stmt.setString() dans l'ordre par rapport à la requete
			stmt.setString(1,pilote.getNomPilote());
			stmt.setString(2,pilote.getPrenomPilote());
			stmt.execute();
			
			System.out.println(pilote.getNomPilote()+ " à bien été ajouté");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
		}
	}
	public static int modifPilote(int id,String newNom, String newPrenom) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionBdd.getConnection();
			stmt=conn.prepareStatement("UPDATE pilote SET nom_pilote=?,prenom_pilote=? WHERE id_pilote=?");
			stmt.setString(1, newNom);
			stmt.setString(2, newPrenom);
			stmt.setInt(3, id);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
