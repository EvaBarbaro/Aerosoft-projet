package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import interfaces.Dao;
import models.*;
import vues.SDialog;

public class AvionDao implements Dao{

	public AvionDao() {
	}

	@Override
	public ArrayList<Avion> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM avion";

		ArrayList<Avion> listeAvions = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				//Retrieve by column name
				Avion avion = new Avion(res.getInt("NumAvion"), res.getString("TypeAvion"),
						res.getString("BaseAeroport"));

				listeAvions.add(avion);
			}

			res.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'afficher les vols");
			throw new RuntimeException(e);
		}
		return listeAvions;
	}
	@Override
	public Object get(Object id) {
		Avion avion = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM `AVION` WHERE NumAvion=" + id;

		System.out.println(sql);

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {

				avion = new Avion(
					res.getInt("NumAvion"), 
					res.getString("typeAvion"),
					res.getString("baseAeroport")
					);
			}

			res.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'afficher les vols");
			throw new RuntimeException(e);
		}

		return avion;
	}

	@Override
	public void save(Object t, String[] params) {
		Avion avion = (Avion) t;

		Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO `AVION` (NumAvion,TypeAvion,BaseAeroport) VALUES (LAST_INSERT_ID(),?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Les points d'interogation vont prendre les info de stmt.setString() dans l'ordre par rapport � la requete
			stmt.setString(1,params[0]);
			stmt.setString(2,params[1]);
			stmt.execute();
			
			System.out.println(avion.getTypeAvion() + " a bien été ajouté");
			new SDialog("Ajout", "Ajouter reussie", "Valider", "").setVisible(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
			new SDialog("Echec", "L'ajout n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Object t, String[] params) {
		
		Avion avion = (Avion) t;

		Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "UPDATE `AVION` SET TypeAvion=?,BaseAeroport=? WHERE NumAvion=?";
			System.out.println(sql);

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Les points d'interogation vont prendre les info de stmt.setString() dans l'ordre par rapport � la requete
			
			stmt.setString(1,params[0]);
			stmt.setString(2, params[1]);
			stmt.setInt(3, avion.getNumAvion());
			
			System.out.println(stmt.toString());

			stmt.execute();
			
			System.out.println(avion.getTypeAvion() + " a bien été Modifier");
			new SDialog("Modification", "Modification reussie", "Valider", "").setVisible(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
			new SDialog("Echec", "La modification n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(Object t) {
		Avion avion = (Avion) t;

		Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "DELETE FROM `AVION` WHERE NumAvion=?";
			System.out.println(sql);

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//Les points d'interogation vont prendre les info de stmt.setString() dans l'ordre par rapport � la requete
			
			stmt.setInt(1,avion.getNumAvion());
			
			System.out.println(stmt.toString());
			
			stmt.execute();
			
			System.out.println(avion.getTypeAvion() + " a bien été Supprimé");
			new SDialog("Suppresssion", "Suppresssion reussie", "Valider", "").setVisible(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
			new SDialog("Echec", "La suppresssion n'a pas reussie car " + e, "ok", "").setVisible(true);
			throw new RuntimeException(e);
		}
	}
}
