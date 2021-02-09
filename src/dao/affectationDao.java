package dao;

import java.sql.*;
import java.util.ArrayList;

import models.*;
import connexion.ConnectionBdd;

public class AffectationDao {

	public AffectationDao() {
	};

		public ArrayList<Affectation> listeAffectations() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT "
				+ "Affectation.NumVol,"
				+ "Affectation.affectationCode,"
				+ "Affectation.DateVol,"
				+  "Affectation.NumAvion, "
				+ "Affectation.idPilote, "
				+ "(Select PrenomPilote FROM Pilote WHERE  Pilote.idPilote = Affectation.idPilote) as PrenomPilote,"
				+ "(Select NomPilote FROM Pilote WHERE  Pilote.idPilote = Affectation.idPilote) as NomPilote "
				+ "FROM Affectation";

		ArrayList<Affectation> listeAffectations = new ArrayList<>();

		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Affectation affectation = new Affectation();

				affectation.setNumVol(rs.getString(1));
				affectation.setDateVol(rs.getDate(2));
				affectation.setAffectationCode(rs.getBoolean(3));
				affectation.setNumAvion(rs.getInt(4));

				Pilote p = new Pilote();

				p.setIdPilote(rs.getInt(5));
				p.setPrenomPilote(rs.getString(7));
				p.setNomPilote(rs.getString(8));

				affectation.setPilote(p);

				listeAffectations.add(affectation);
			}
			
		    rs.close();
			conn.close();
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Impossible d'afficher les vols");
			}
			return listeAffectations;
	}
	
	// -------------------FONCTION MODIF VOL------------------------
	public static void modifVol(String numVol, String newDateVol) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE affectation SET DateVol= ? WHERE NumVol=?";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,newDateVol);
			stmt.setString(2,numVol);
			stmt.executeUpdate();
			//System.out.println("Votre date de vol a bien �t� modifi�e au : " + newDateVol);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -------------------FONCTION DELETE VOL------------------------
	public static void delVol(String numVolDel){
		Connection conn = null;
		Statement stmt = null;
		String sqlDelete = "DELETE FROM affectation" + " WHERE NumVol ='"+numVolDel+"'";
		String sqlDelete2 = "DELETE FROM vol" + " WHERE NumVol='"+numVolDel+"'";
		try {
			conn = ConnectionBdd.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlDelete);
			stmt.executeUpdate(sqlDelete2);
			//System.out.println("Le vol num�ro " + numVolDel + " est bien supprim�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
