package dao;

import java.sql.*;
import java.util.ArrayList;

import models.*;
import connexion.ConnectionBdd;
import interfaces.Dao;

public class AffectationDao implements Dao {

	public AffectationDao() {
	};

	@Override
	public Object get(Object id) {
		Affectation affectation = new Affectation();

		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "SELECT "
		+ "affectation.NumVol,"
		+ "affectation.affectationCode,"
		+ "affectation.DateVol,"
		+ "affectation.NumAvion, "
		+ "affectation.idPilote, "
		+ "(Select PrenomPilote FROM pilote WHERE pilote.idPilote = affectation.idPilote) as PrenomPilote,"
		+ "(Select NomPilote FROM pilote WHERE  pilote.idPilote = Affectation.idPilote) as NomPilote "+ " FROM affectation WHERE IdAffectation=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, affectation.getId());

			System.out.println("Voici les informations de l'affectation " + id);
			ResultSet res = stmt.executeQuery();

			while (res.next()) {
				affectation.setNumVol(res.getString(1));
				affectation.setDateVol(res.getDate(2));
				affectation.setAffectationCode(res.getBoolean(3));
				affectation.setNumAvion(res.getInt(4));

				Pilote pilote = new Pilote();

				pilote.setIdPilote(res.getInt(5));
				pilote.setPrenomPilote(res.getString(7));
				pilote.setNomPilote(res.getString(8));

				affectation.setPilote(pilote);
			}
			res.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return affectation;
	}

	@Override
	public ArrayList<Affectation> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT "
				+ "affectation.NumVol,"
				+ "affectation.affectationCode,"
				+ "affectation.DateVol,"
				+ "affectation.NumAvion, "
				+ "affectation.idPilote, "
				+ "(Select PrenomPilote FROM pilote WHERE  pilote.idPilote = affectation.idPilote) as PrenomPilote,"
				+ "(Select NomPilote FROM pilote WHERE  pilote.idPilote = affectation.idPilote) as NomPilote "
				+ "FROM affectation";

		ArrayList<Affectation> listeAffectations = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Affectation affectation = new Affectation();

				affectation.setNumVol(rs.getString(1));
				affectation.setDateVol(rs.getDate(2));
				affectation.setAffectationCode(rs.getBoolean(3));
				affectation.setNumAvion(rs.getInt(4));

				Pilote p = new Pilote();

				p.setIdPilote(rs.getInt(5));
				p.setPrenomPilote(rs.getString(7));
				p.setNomPilote(rs.getString(8));

				affectation.setPilote(p);

				listeAffectations.add(affectation);
			}
			
		    rs.close();
			conn.close();
			  
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible d'afficher les affectations");
			}
			return listeAffectations;
	}

	@Override
	public void save(Object t) {
			Affectation affectation = (Affectation) t;

			Pilote pilote = new Pilote();

			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			String sql = "INSERT INTO affectation (NumVol,DateVol,AffectationCode,NumAvion,IdPilote) VALUES (?,?,?,?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,affectation.getNumVol());
			stmt.setDate(2,affectation.getDateVol());
			stmt.setBoolean(3, affectation.getAffectationCode());
			stmt.setInt(4, affectation.getNumAvion());
			stmt.setInt(5, pilote.getIdPilote());
			stmt.execute();

			stmt1 = conn.prepareStatement("UPDATE AFFECTATION SET IdAffectation=CONCAT(NumVol, DateVol)");
			stmt1.executeUpdate();
			
			System.out.println(affectation.getNumVol()+ " a bien été ajouté");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter une affectation");
		}
	}

	@Override
	public void update(Object t, String[] params) {
		Affectation affectation = (Affectation) t;

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE affectation SET NumVol=?, DateVol=?, NumAvion=?, IdPilote=? WHERE IdAffectation=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, params[0]);
			stmt.setString(2, params[1]);
			stmt.setString(3, params[2]);
			stmt.setString(4, params[3]);
			stmt.setString(5, affectation.getId());
			stmt.executeUpdate();
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

	@Override
	public void delete(Object t) {
		Affectation affectation = (Affectation) t;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionBdd.getConnection();

			stmt = conn.prepareStatement("UPDATE affectation SET AffectationCode=false WHERE IdAffectation=?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, affectation.getId());
			stmt.execute();

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
