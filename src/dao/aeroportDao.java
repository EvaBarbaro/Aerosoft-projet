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
<<<<<<< HEAD
				Aeroport aeroport = new Aeroport(
						res.getString("idAeroport"), 
						res.getString("nom_aeroport"),
						res.getString("NomVilleDesservie")
						);
=======
				Aeroport aeroport = new Aeroport(res.getString("idAeroport"), res.getString("NomAeroport"),
						res.getString("NomVilleDesservie"));
>>>>>>> 596b3d347553d912fa728ba3ab0b0ba80296cf43

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
