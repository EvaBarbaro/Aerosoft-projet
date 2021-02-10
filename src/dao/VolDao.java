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
		      }
			res.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		
	}

}
