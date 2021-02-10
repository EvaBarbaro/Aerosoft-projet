package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;
import interfaces.*;

public class PiloteDao implements Dao {

	public PiloteDao() {
	};

	@Override
	public Object get(Object id) {
		Pilote pilote = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM Pilote WHERE IdPilote=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setObject(1, id);
			System.out.println("Voici les informations du vol " + id);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {

				pilote = new Pilote(
					res.getInt("IdPilote"), 
					res.getString("NomPilote"),
					res.getString("PrenomPilote"),
					res.getString("Matricule")
					);
			}
			res.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pilote;
	}

	@Override
	public ArrayList<Pilote> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM pilote";

		ArrayList<Pilote> listePilotes = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				Pilote pilote = new Pilote(res.getInt("IdPilote"),res.getString("NomPilote"), res.getString("PrenomPilote"), res.getString("Matricule"));

				listePilotes.add(pilote);
			}
			  
		    res.close();
			conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible d'afficher les vols");
			}
		return listePilotes;
	}

	@Override
	public void save(Object t) {
			Pilote pilote = (Pilote) t;

			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO pilote (NomPilote,PrenomPilote) VALUES (?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,pilote.getNomPilote());
			stmt.setString(2,pilote.getPrenomPilote());
			stmt.execute();
			
			System.out.println(pilote.getNomPilote()+ " a bien été ajouté");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
		}

	}

	@Override
	public void update(Object t, String[] params) {
		Pilote pilote = (Pilote) t;

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("UPDATE pilote SET NomPilote=?,PrenomPilote=? WHERE IdPilote=?");
			stmt.setString(1, params[0]);
			stmt.setString(2, params[1]);
			stmt.setInt(3, pilote.getIdPilote());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void delete(Object t) {
		Pilote pilote = (Pilote) t;

		Connection conn = null;
		Statement stmt = null;
		String sql = "DELETE FROM `AVION` WHERE IdPilote=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("DELETE FROM `AVION` WHERE IdPilote=?", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,pilote.getIdPilote());
			
			System.out.println(stmt.toString());
			
			stmt.execute();
			
			System.out.println(pilote.getMatricule()+ " a bien été Supprimé");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
