package vues;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JFrame;


import dao.UtilisateurDao;

import models.Utilisateur;

public class FicheExample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheExample(Utilisateur u) {

		String [] listLabels= {"IdUtilisateur","Mail","MotDePasse","Statut","IdRole"};
		String[] listTextFields = { u.getIdUtilisateur(), u.getMail(),u.getMotDePasse(), "" + u.getStatut(), u.getIdRole()  };

		//reste a implémenter 2 autres champs facultatif 
		
		String [][] listSuperDialog={ 
				{"Supprimer","Voulez-vous vraiment supprimer", "Oui", "Non"},
				{"Enregistrer", "Il y a eu des modifications. Voulez-vous enregistrer", "Oui", "Non"} 
		};
				
		String[] listTextBtns = { "Supprimer", "Valider" };
		String[] listMethodeDoa = { "delete", "update" };
		bdao = new UtilisateurDao();

		/*Method fonctionBtn2=null ;
		Method fonctionBtn1=null ;
		
		try {
			Class parameterTypes[] = {Object.class, ArrayList.class };
			
			fonctionBtn2 = UtilisateurDao.class.getMethod("update", parameterTypes);
			System.out.println("fonctionBtn2: " + fonctionBtn2);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class[] parameterTypes = new Class[1];
			parameterTypes[0] = Object.class;
			fonctionBtn1 = UtilisateurDao.class.getMethod("delete", parameterTypes);
			System.out.println("fonctionBtn1: " + fonctionBtn1);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*
		 * Fiche.Fiche(
		 * String titre, 
		 * BookDaoInterface dao, 
		 * Object transport, 
		 * int id, 
		 * String[] listLabels, 
		 * String[] listTextFields, 
		 * String[][] listSuperDialog
		 * String [] listTextBtns
		 * ) 
		 */
		new Fiche(
				"Fiche Utilisateur", 
				bdao, 
				(Object)u, 
				u.getIdUtilisateur(), 
				listLabels, 
				listTextFields,
				listSuperDialog,
				listTextBtns,
				listMethodeDoa
				/*,
				fonctionBtn2,
				fonctionBtn1*/
				);
	}
}
