package main;

import models.*;
import dao.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tapez 1 : Test");
		// System.out.println("Tapez 2 : Afficher la liste des vols");
		// System.out.println("Tapez 3 : Rechercher un vol demandé par l'utilisateur");
		// System.out.println("Tapez 4 : Afficher la liste des aéroports par ville");
		// System.out.println("Tapez 5 : Modifier la date d'un vol");
		// System.out.println("Tapez 6 : Supprimer un vol");
		// System.out.println("Tapez 7 : Modifier un pilote");
		// System.out.print("Veuillez entrer votre choix :");
		int choix = scanner.nextInt();

		// VolDao volDao = new VolDao();
		
		Scanner sc = new Scanner(System.in);
		
		switch (choix) {
		// // 1 - Add a pilot
		case 1:
		PiloteDao piloteDao = new PiloteDao();
		// Pilote p1 = new Pilote();
		System.out.println("Entrez l'id pilote");
		String idPilote = sc.nextLine();
		piloteDao.get(Integer.parseInt(idPilote));
		// 	System.out.println("Entrer le nom : "); 
		// 	p1.setNomPilote(lastName);
		// 	System.out.println("Entrer le prenom : "); 
		// 	String firstName = sc.nextLine(); 
		// 	p1.setPrenomPilote(firstName);
		// 	PiloteDao.insertPilote(p1);
		break;

		// case 2:			
		// 	volDao.listeVols();
		// 	break;

		// case 3:
		// 	System.out.println("Entrer votre numéro de vol: "); 
		// 	String numVolUser = sc.nextLine();
		// 	VolDao.rechercheVol(numVolUser);
		// 	break;

		// case 4:
		// 	AeroportDao aeroportDao = new AeroportDao();
		// 	aeroportDao.getAll();
		// 	break;

		// case 5:
		// 	System.out.println("Entrer le numéro du vol à modifier"); 
		// 	String numVol = sc.nextLine(); 
		// 	System.out.println("Entrer votre nouvelle date :"); 
		// 	String newDateVol = sc.nextLine(); 
		// 	AffectationDao.modifVol(numVol, newDateVol);
		// 	break;

		// case 6:
		// 	System.out.println("Entrer le numero de vol à supprimer"); 
		// 	String numVolDel = sc.nextLine();
		// 	AffectationDao.delVol(numVolDel);
		// 	break;

		// case 7:
		// 	System.out.println("Entrer l'id du pilote à modifier");
		// 	int idPilote = sc.nextInt();
		// 	sc.nextLine();
		// 	System.out.println("Entrer le new nom :"); 
		// 	String newNom = sc.nextLine();
		// 	System.out.println("Entrer le new prenom"); 
		// 	String newPrenom = sc.nextLine(); 
		// 	PiloteDao.modifPilote(idPilote, newNom, newPrenom);
		// 	break;
		}
	}
	
}
