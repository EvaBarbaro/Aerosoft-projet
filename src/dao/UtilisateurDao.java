package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import interfaces.Dao;
import models.Utilisateur;

public class UtilisateurDao implements Dao {
    
	public UtilisateurDao() {
	}

	@Override
	public Object get(Object idOjb) {

		String id = (String) idOjb;
		Utilisateur utilisateur = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM `UTILISATEUR` WHERE IdUtilisateur =" + id;

		System.out.println(sql);

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {

				utilisateur = new Utilisateur(
					res.getString("IdUtilisateur"), 
					res.getString("Mail"),
					res.getString("MotDePasse"),
					res.getBoolean("Statut"),
					res.getString("IdRole")
				);					
			}

			res.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'afficher les Utilisateurs");
		}

		return utilisateur;
	}

	@Override
	public ArrayList<Utilisateur> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM `UTILISATEUR`";

		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				Utilisateur utilisateur = new Utilisateur(
					res.getString("IdUtilisateur"), 
					res.getString("Mail"),
					res.getString("MotDePasse"),
					res.getBoolean("Statut"),
					res.getString("IdRole")
				);

				listeUtilisateurs.add(utilisateur);
			}
			  
		    res.close();
			conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible d'afficher les pilotes");
			}
		return listeUtilisateurs;
	}

	@Override
	public void save(Object t) {
		Utilisateur utilisateur =(Utilisateur) t;

		Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO `UTILISATEUR` (IdUtilisateur,Mail,MotDePasse,Statut,IdRole) VALUES (?,?,?,?,?)";

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,utilisateur.getIdUtilisateur());
			stmt.setString(2, utilisateur.getMail());
			stmt.setString(3, utilisateur.getMotDePasse());
			stmt.setBoolean(4, utilisateur.getStatut());
			stmt.setString(5, utilisateur.getIdRole());
			
			stmt.execute();
			
			System.out.println(utilisateur.getIdUtilisateur()+ " a bien été ajouté");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
		}
	}

	@Override
	public void update(Object t, ArrayList paramsA) {
		String[] params = (String[])  paramsA.toArray();
		Utilisateur utilisateur = (Utilisateur) t;
		
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("UPDATE `UTILISATEUR` SET IdUtilisateur=?,Mail=?,MotDePasse=?,Statut=?,IdRole=? WHERE IdUtilisateur=?");
			stmt.setString(1, params[0]);
			stmt.setString(2, params[1]);
			stmt.setString(3, params[2]);
			stmt.setBoolean(4,Boolean.parseBoolean(params[3]));
			stmt.setString(5, params[4]);
			stmt.setString(6, utilisateur.getIdUtilisateur());
			System.out.println(stmt.toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Object t) {
		Utilisateur utilisateur = (Utilisateur) t;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("DELETE FROM `UTILISATEUR` WHERE `IdUtilisateur`=?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getIdUtilisateur());
			stmt.execute();
			
			System.out.println(utilisateur.getIdUtilisateur()+ " a bien été Supprimé");
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
