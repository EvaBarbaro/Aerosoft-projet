package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;

public class VolDao {

	// -------------------FONCTION AFFICHE VOL-------------
	public ArrayList<Vol> listeVols() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM vol";

		ArrayList<Vol> listeVols = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery(sql);

			while(res.next()){
		         //Retrieve by column name		
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listeVols;
	}
	// -----------------------------------------------------------------
	// -------------------FONCTION RECHERCHE VOL------------------------
	public static void rechercheVol(String numVolUser) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM vol WHERE NumVol=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, numVolUser);
			System.out.println("Voici les informations du vol " + numVolUser);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
		         //Retrieve by column name
		         String numVol  = res.getString("NumVol");
		         String aDepart = res.getString("AeroportDept");
		         String hDepart = res.getString("HDepart");
		         String aArrive = res.getString("AeroportArr");
		         String hArrive = res.getString("HArrivee");

		         //Display values
		         System.out.print("Numero de vol: " + numVol);
		         System.out.print(", From : " + aDepart);
		         System.out.print(", Heure de depart : " + hDepart);
		         System.out.print(", To : " + aArrive);
		         System.out.println(", Heure d'arrive: " + hArrive);
		      }
			res.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------

}
