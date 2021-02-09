package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;

public class AeroportDao {

	public AeroportDao() {
	};
	
	public ArrayList<Aeroport> listeAeroports() {
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
}
