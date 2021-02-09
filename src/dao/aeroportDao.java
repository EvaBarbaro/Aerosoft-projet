package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import interfaces.Dao;
import models.*;

public class AeroportDao implements Dao{

	public AeroportDao() {
	}

	@Override
	public ArrayList<Aeroport> getAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM aeroport ORDER BY NomVilleDesservie";

		ArrayList<Aeroport> listeAeroports = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {

				//Retrieve by column name
				Aeroport aeroport = new Aeroport(res.getString("idAeroport"), res.getString("NomAeroport"),
						res.getString("NomVilleDesservie"));

				listeAeroports.add(aeroport);
			}

			res.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'afficher les vols");
		}
		return listeAeroports;
	}

	@Override
	public Object get(Object id) {
		// TODO Auto-generated method stub
		return null;
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
