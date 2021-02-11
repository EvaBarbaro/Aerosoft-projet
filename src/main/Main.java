package main;

import models.*;
import vues.FicheAjoutAeroport;
import vues.FicheExample;
import dao.*;

public class Main {

	public static void main(String[] args) {
		
		AeroportDao uda = new AeroportDao();
		//String id = "4";

		Aeroport a = new Aeroport();
		new FicheAjoutAeroport(a);
	}
}