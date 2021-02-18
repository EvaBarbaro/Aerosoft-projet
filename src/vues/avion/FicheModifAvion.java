package vues.avion;

import javax.swing.JFrame;

import dao.AvionDao;
import models.Avion;
import vues.Fiche;


public class FicheModifAvion extends JFrame {

	private static final long serialVersionUID = 1L;
	
	AvionDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheModifAvion(Avion av) {
		//Ajout des labels
		String[] listLabels = { "Numéro avion", "Type avion", "Base aeroport"};
		
		//Ajout des text fields remplis avec les infos demandé
		String[] listTextFields = { ""+av.getNumAvion(),av.getTypeAvion(),av.getBaseAeroport()};
		
		//Ajout des boutons
		String[] listTextBtns = { "Valider","Annuler" };

		//Ajout de la methode
		String[] listMethodeDoa = { "update","" };

		//Ajout de la dao
		bdao = new AvionDao();

		//Creation de la fiche avec les elements ajouté au dessuss
		new Fiche(
				"Modification d'un vol", 
				bdao, 
				(Object)av, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
