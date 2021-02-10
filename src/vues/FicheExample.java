package vues;

import javax.swing.JFrame;

import dao.PiloteDao;
import models.Pilote;

public class FicheExample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	PiloteDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheExample(Pilote pilote) {

		String [] listLabels= {"NomPilote","PrenomPilote"};
		String[] listTextFields = { pilote.getNomPilote(), pilote.getPrenomPilote() };

		//reste a implémenter 2 autres champs facultatif 
		
		String [][] listSuperDialog={ 
				{"Supprimer","Voulez-vous vraiment supprimer", "Oui", "Non"},
				{"Enregistrer", "Il y a eu des modifications. Voulez-vous enregistrer", "Oui", "Non"} 
				};
		bdao = new PiloteDao();
		
		/*
		 * Fiche.Fiche(
		 * String titre, 
		 * BookDaoInterface dao, 
		 * Object transport, 
		 * int id, 
		 * String[] listLabels, 
		 * String[] listTextFields, 
		 * String[][] listSuperDialog
		 * ) 
		 */
		
		new Fiche(
				"Fiche Book", 
				bdao, 
				(Object)pilote, 
				pilote.getIdPilote(), 
				listLabels, 
				listTextFields,
				listSuperDialog
				);
	}
}
