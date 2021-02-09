package dao;

import java.sql.*;

import connexion.ConnectionBdd;
import models.*;

public class aeroportDao {
	
	public static void listeAeroport() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT nom_aeroport,nom_ville FROM aeroport ORDER BY nom_ville";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);
			System.out.println("Voici la liste des aeroports par ville ");
			while(res.next()){
		         //Retrieve by column name
				String nomAeroport  = res.getString("nom_aeroport");
				String villeAeroport = res.getString("nom_ville");
		         //Display values
		         System.out.print("Nom de l'aeroport: " + nomAeroport);
		         System.out.println(", Ville : " + villeAeroport);
		      }
		      res.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible d'afficher les vols");
		}
	}
}
