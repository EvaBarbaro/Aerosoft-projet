package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;

public class AvionDao {

	public AvionDao() {
	};
	
	public ArrayList<Avion> listeAvions() {
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
				Avion avion = new Avion(
						res.getInt("numAvion"), 
						res.getString("typeAvion"), 
						res.getString("idAeroport")
					);

				listeAvions.add(avion);
			}
			  
		      res.close();
			  conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Impossible d'afficher les vols");
			}
		return listeAvions;
	}
}
