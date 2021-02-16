package main;

import vues.*;
import vues.home.*;
import vues.utilisateur.TableRole;
import dao.*;
import models.*;
import java.util.*;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// AvionDao ad = new AvionDao();

		// PiloteDao pdao = new PiloteDao();
		// AffectationDao afd = new AffectationDao();

		//int NumAvion = 109;
		//Avion a = (Avion) ad.get(NumAvion);

		//System.out.println("Avion : " + a.getTypeAvion());

		//Avion a2 = new Avion();
		//a2.setTypeAvion("ATR42");
		//a2.setBaseAeroport("ORL");
		//ad.save(a2);

		//String[] params = {"B747","GRE"};

		//ad.update(a, params);

		//ad.delete(a);

		new Login();
		        TableRole frame = new TableRole();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}