package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import interfaces.Dao;
import models.*;

public class VolDao implements Dao{

	public VolDao() {
	};

	@Override
	public Object get(Object id) {
		Vol vol = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM vol WHERE NumVol=?";

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setObject(1, id);

			System.out.println("Voici les informations du vol " + id);
			ResultSet res = stmt.executeQuery();

			while(res.next()){
				vol = new Vol(
					res.getString("NumVol"), 
					res.getString("AeroportDept"),
					res.getString("HDepart"),
					res.getString("AeroportArr"),
					res.getString("HArrivee")
					);

					System.out.println("ID: " + vol.getNumVol());
					System.out.println("Aeroport de départ: " + vol.getAeroportDepart());
					System.out.println("Heure de départ: " + vol.getHeureDepart());
					System.out.println("Aeroport d'arrivée: " + vol.getAeroportArrive());
					System.out.println("Heure d'arrivée': " + vol.getHeureArrive());
		      }
			res.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vol;
	}

	@Override
	public ArrayList<Vol> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM vol";

		ArrayList<Vol> listeVols = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while(res.next()){	
				 Vol vol = new  Vol(
					 res.getString("NumVol"), 
					 res.getString("AeroportDept"), 
					 res.getString("HDepart"), 
					 res.getString("AeroportArr"), 
					 res.getString("HArrivee")
					 );
						listeVols.add(vol);
		      }
		    res.close();
			conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listeVols;
	}

	@Override
	public void save(Object t) {
			Vol vol = (Vol) t;

			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "INSERT INTO vol (NumVol, AeroportDept, HDepart, AeroportArr, HArrivee) VALUES (?,?,?,?,?)";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, vol.getNumVol());
			stmt.setString(2, vol.getAeroportDepart());
			stmt.setString(3, vol.getHeureDepart());
			stmt.setString(4, vol.getAeroportArrive());
			stmt.setString(5, vol.getHeureArrive());
			stmt.execute();
			
			System.out.println(vol.getNumVol()+ " a bien été ajouté");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ajouter un pilote");
		}
		
	}

	@Override
	public void update(Object t, ArrayList paramsA) {
		String[] params = (String[])  paramsA.toArray();
		Vol vol = (Vol) t;

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("UPDATE vol SET AeroportDept=?,HDepart=?,AeroportArr=?,HArrivee=? WHERE NumVol=?");
			stmt.setString(1, params[0]);
			stmt.setString(2, params[1]);
			stmt.setString(3, params[2]);
			stmt.setString(4, params[3]);
			stmt.setString(5, vol.getNumVol());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(Object t) {
		Vol vol = (Vol) t;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement("DELETE FROM `vol` WHERE `NumVol`=?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, vol.getNumVol());
			stmt.execute();
			
			System.out.println(vol.getNumVol()+ " a bien été Supprimé");
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

