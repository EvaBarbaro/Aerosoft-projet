package main;

import models.*;
import dao.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		AvionDao ad = new AvionDao();

		PiloteDao pdao = new PiloteDao();

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

		Scanner scanner = new Scanner(System.in);
		System.out.println("Tapez 1 : Ajouter un nouveau pilote");
		System.out.println("Tapez 2 : Afficher la liste des vols");
		System.out.println("Tapez 3 : Rechercher un vol demandé par l'utilisateur");
		System.out.println("Tapez 4 : Afficher la liste des aéroports par ville");
		System.out.println("Tapez 5 : Modifier la date d'un vol");
		System.out.println("Tapez 6 : Supprimer un vol");
		System.out.println("Tapez 7 : Modifier un pilote");
		System.out.print("Veuillez entrer votre choix :");
		int choix = scanner.nextInt();

		VolDao volDao = new VolDao();
		
		Scanner sc = new Scanner(System.in);
		
		switch (choix) {
		// 1 - Add a pilot
		case 1:
			Pilote p1 = new Pilote();
			System.out.println("Ajouter un nouveau Pilote");
			System.out.println("Entrer le nom : "); 
			String lastName = sc.nextLine(); 
			p1.setNomPilote(lastName);
			System.out.println("Entrer le prenom : "); 
			String firstName = sc.nextLine(); 
			p1.setPrenomPilote(firstName);
			
			pdao.save(p1);
			break;

		case 2:			
			volDao.listeVols();
			break;

		case 3:
			System.out.println("Entrer votre numéro de vol: "); 
			String numVolUser = sc.nextLine();
			VolDao.rechercheVol(numVolUser);
			break;

		case 4:
			AeroportDao aeroportDao = new AeroportDao();
			aeroportDao.getAll();
			break;

		case 5:
			System.out.println("Entrer le numéro du vol à modifier"); 
			String numVol = sc.nextLine(); 
			System.out.println("Entrer votre nouvelle date :"); 
			String newDateVol = sc.nextLine(); 
			AffectationDao.modifVol(numVol, newDateVol);
			break;

		case 6:
			System.out.println("Entrer le numero de vol à supprimer"); 
			String numVolDel = sc.nextLine();
			AffectationDao.delVol(numVolDel);
			break;

		case 7:
			System.out.println("Entrer l'id du pilote à modifier");
			int idPilote = sc.nextInt();
			sc.nextLine();
			System.out.println("Entrer le new nom :"); 
			String newNom = sc.nextLine();
			System.out.println("Entrer le new prenom"); 
			String newPrenom = sc.nextLine();
			
			String[] params2 = {newNom, newPrenom};
				
			Pilote p = new Pilote();
			p.setIdPilote(idPilote);

			pdao.update(p, params2);
			break;
		}
	}
	
}