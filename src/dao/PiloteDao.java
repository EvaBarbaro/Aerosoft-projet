package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;

public class PiloteDao {

	public ArrayList<Pilote> listePilotes() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM pilote";

		ArrayList<Pilote> listePilotes = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				//Retrieve by column name
				Pilote pilote = new Pilote(res.getInt("IdPilote"),res.getString("NomPilote"), res.getString("PrenomPilote"), res.getString("Matricule"));

				listePilotes.add(pilote);
			}
			  
		    res.close();
			conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Impossible d'afficher les vols");
			}
		return listePilotes;
	}

	public static void insertPilote(Pilote pilote) {
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO pilote (NomPilote,PrenomPilote) VALUES (?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Les points d'interogation vont prendre les info de stmt.setString() dans l'ordre par rapport � la requete
			stmt.setString(1,pilote.getNomPilote());
			stmt.setString(2,pilote.getPrenomPilote());
			stmt.execute();
			
			System.out.println(pilote.getNomPilote()+ " a bien été ajouté");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
		}
	}

	public static int modifPilote(int id, String newNom, String newPrenom) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("UPDATE pilote SET NomPilote=?,PrenomPilote=? WHERE IdPilote=?");
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
