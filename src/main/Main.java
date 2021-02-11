package main;

import vues.*;
import dao.*;
import models.*;
import java.util.*;

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

		// ArrayList<Vol> vols = volDao.getAll();
		// for (Vol vol : vols) {
		// 	System.out.println(vol.getNumVol());
		// 	System.out.println(vol.getAeroportArrive());
		// 	System.out.println(vol.getHeureArrive());
		// 	System.out.println(vol.getAeroportDepart());
		// 	System.out.println(vol.getHeureDepart());
		// }
		new Login();
	}
	
}