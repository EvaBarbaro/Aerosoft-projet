package dao;

import java.sql.*;
import java.util.ArrayList;

import connexion.ConnectionBdd;
import models.*;

public class VolDao {

	public VolDao() {
	};

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
					 res.getString("num_vol"), 
					 res.getString("aeroport_depart_fk"), 
					 res.getString("heure_depart"), 
					 res.getString("aeroport_arrive_fk"), 
					 res.getString("heure_arrive")
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
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------

}
