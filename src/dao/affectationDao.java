package dao;

import java.sql.*;
import models.*;
import connexion.ConnectionBdd;

public class affectationDao {
	
	// -------------------FONCTION MODIF VOL------------------------
	public static void modifVol(String numVol, String newDateVol) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE affectation SET date_vol= ? WHERE num_vol_fk=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,newDateVol);
			stmt.setString(2,numVol);
			stmt.executeUpdate();
			System.out.println("Votre date de vol a bien été modifiée au : " + newDateVol);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -------------------FONCTION DELETE VOL------------------------
	public static void delVol(String numVolDel) {
		Connection conn = null;
		Statement stmt = null;
		String sqlDelete = "DELETE FROM affectation" + " WHERE num_vol_fk ='"+numVolDel+"'";
		String sqlDelete2 = "DELETE FROM vol" + " WHERE num_vol='"+numVolDel+"'";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlDelete);
			stmt.executeUpdate(sqlDelete2);
			System.out.println("Le vol numéro " + numVolDel + " est bien supprimé.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
