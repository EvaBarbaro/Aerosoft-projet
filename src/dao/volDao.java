package dao;

import java.sql.*;

import connexion.ConnectionBdd;
import models.*;

public class volDao {

	// -------------------FONCTION AFFICHE VOL-------------
	public static void afficheVol() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM vol";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()){
		         //Retrieve by column name
		         String numVol  = res.getString("num_vol");
		         String aDepart = res.getString("aeroport_depart_fk");
		         String hDepart = res.getString("heure_depart");
		         String aArrive = res.getString("aeroport_arrive_fk");
		         String hArrive = res.getString("heure_arrive");

		         //Display values
		         System.out.print("Numero de vol: " + numVol);
		         System.out.print(", From : " + aDepart);
		         System.out.print(", Heure de depart : " + hDepart);
		         System.out.print(", To : " + aArrive);
		         System.out.println(", Heure d'arrive: " + hArrive);
		      }
		      res.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------
	// -------------------FONCTION RECHERCHE VOL------------------------
	public static void rechercheVol(String numVolUser) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM vol WHERE num_vol=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, numVolUser);
			System.out.println("Voici les informations du vol " + numVolUser);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
		         //Retrieve by column name
		         String numVol  = res.getString("num_vol");
		         String aDepart = res.getString("aeroport_depart_fk");
		         String hDepart = res.getString("heure_depart");
		         String aArrive = res.getString("aeroport_arrive_fk");
		         String hArrive = res.getString("heure_arrive");

		         //Display values
		         System.out.print("Numero de vol: " + numVol);
		         System.out.print(", From : " + aDepart);
		         System.out.print(", Heure de depart : " + hDepart);
		         System.out.print(", To : " + aArrive);
		         System.out.println(", Heure d'arrive: " + hArrive);
		      }
		      res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------

}
