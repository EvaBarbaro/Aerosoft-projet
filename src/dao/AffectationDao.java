package dao;

import java.sql.*;
import java.util.ArrayList;

import models.*;
import vues.SDialog;
import connexion.ConnectionBdd;
import interfaces.Dao;

public class AffectationDao implements Dao {

	public AffectationDao() {
	};

	@Override
	public Object get(Object id) {
		Affectation affectation = new Affectation();
		//Transformer l'object 'id' en String pour l'envoyer dans la requete 
		String idSearch = String.valueOf(id);
		Connection conn = null;
		PreparedStatement stmt = null;

		//String sql = "SELECT * FROM affectation WHERE IdAffectation=?";
		
		String sql = "SELECT "
		+ "affectation.IdAffectation,"
		+ "affectation.NumVol,"
		+ "affectation.DateVol,"
		+ "affectation.affectationCode,"
		+ "affectation.NumAvion, "
		+ "affectation.idPilote, "
		+ "(Select PrenomPilote FROM `PILOTE` as pilote WHERE pilote.idPilote = affectation.idPilote) as PrenomPilote,"
		+ "(Select NomPilote FROM `PILOTE` as pilote WHERE  pilote.idPilote = affectation.idPilote) as NomPilote "
		+ " FROM `AFFECTATION` as affectation WHERE affectation.IdAffectation=?";
		
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			System.out.println("get stmt " + stmt);

			stmt.setString(1, idSearch);
			System.out.println("Voici les informations de l'affectation " + id);
				
			ResultSet res = stmt.executeQuery();
			
			while (res.next()) {
				affectation.setId(res.getString(1));
				affectation.setNumVol(res.getString(2));
				affectation.setDateVol(res.getDate(3));
				affectation.setAffectationCode(res.getBoolean(4));
				affectation.setNumAvion(res.getInt(5));

				Pilote pilote = new Pilote();

				pilote.setIdPilote(res.getInt(6));
				pilote.setPrenomPilote(res.getString(7));
				pilote.setNomPilote(res.getString(8));
			

				affectation.setPilote(pilote);
			}
			
			res.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return affectation;
	}

	@Override
	public ArrayList<Affectation> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT "
				+ "affectation.IdAffectation,"
				+ "affectation.NumVol,"
				+ "affectation.affectationCode,"
				+ "affectation.DateVol,"
				+ "affectation.NumAvion, "
				+ "affectation.idPilote, "
				+ "(Select PrenomPilote FROM `PILOTE` as pilote WHERE  pilote.idPilote = affectation.idPilote) as PrenomPilote,"
				+ "(Select NomPilote FROM `PILOTE` as pilote WHERE  pilote.idPilote = affectation.idPilote) as NomPilote "
				+ "FROM `AFFECTATION` as affectation";

		ArrayList<Affectation> listeAffectations = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			System.out.println("getAll stmt " + stmt);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Affectation affectation = new Affectation();

				affectation.setId(rs.getString(1));
				affectation.setNumVol(rs.getString(2));
				affectation.setAffectationCode(rs.getBoolean(3));
				affectation.setDateVol(rs.getDate(4));
				affectation.setNumAvion(rs.getInt(5));

				Pilote p = new Pilote();

				p.setIdPilote(rs.getInt(6));
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
				throw new RuntimeException(e);
			}
			return listeAffectations;
	}

	@Override
	public void save(Object t, String[] params) {
			Affectation affectation = (Affectation) t;

			//Pilote pilote = new Pilote();

			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			String sql = "INSERT INTO `AFFECTATION` (NumVol,DateVol,AffectationCode,NumAvion,IdPilote) VALUES (?,?,?,?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,params[0]);
			stmt.setDate(2,Date.valueOf(params[2]));
			stmt.setBoolean(3, Boolean.parseBoolean(params[3]));
			stmt.setInt(4, Integer.parseInt(params[4]));
			stmt.setInt(5, Integer.parseInt(params[5]));
			stmt.execute();

			stmt1 = conn.prepareStatement("UPDATE `AFFECTATION` SET IdAffectation=CONCAT(NumVol, DateVol)");
			stmt1.executeUpdate();
			
			System.out.println(affectation.getNumVol()+ " a bien été ajouté");
			new SDialog("Ajout", "Ajouter reussie", "Valider", "").setVisible(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter une affectation");
			new SDialog("Echec", "L'ajout n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Object t, String[] params) {
		
		Affectation affectation = (Affectation) t;

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE `AFFECTATION` SET NumVol=?, DateVol=?, NumAvion=?, IdPilote=? WHERE IdAffectation=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, params[0]);
			stmt.setString(2, params[1]);
			stmt.setString(3, params[2]);
			stmt.setString(4, params[3]);
			stmt.setString(5, affectation.getId());
			stmt.executeUpdate();

			new SDialog("Modification", "Modification reussie", "Valider", "").setVisible(true);

		} catch (SQLException e) {
			e.printStackTrace();
			new SDialog("Echec", "La modification n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Object t) {
		Affectation affectation = (Affectation) t;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionBdd.getConnection();

			stmt = conn.prepareStatement("UPDATE `AFFECTATION` SET AffectationCode=false WHERE IdAffectation=?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, affectation.getId());
			stmt.execute();

			new SDialog("Suppresssion", "Suppresssion reussie", "Valider", "").setVisible(true);

		} catch (SQLException e) {
			e.printStackTrace();
			new SDialog("Echec", "La suppresssion n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
