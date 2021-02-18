package vues.avion;

import javax.swing.JFrame;

import dao.AvionDao;
import models.Avion;
import vues.Fiche;


public class FicheAjoutAvion extends JFrame {
	
	private static final long serialVersionUID = 1L;

	AvionDao bdao;

	/**
	 * Create the frame.
	 */
		//Constructeur
	public FicheAjoutAvion(Avion av) {

		//Ajout des labels
		String[] listLabels = { "Numéro avion", "Type avion", "Base aeroport" };
		
		//Ajout des text fields
		String[] listTextFields = {"","",""};
		
		//Ajout des boutons
		String[] listTextBtns = { "Valider","Annuler" };

		//Ajout de la methode
		String[] listMethodeDoa = { "save","" };

		//Ajout de la dao
		bdao = new AvionDao();

		//Creation de la fiche avec les elements ajouté au dessus
		new Fiche(
				"Ajout d'un vol", 
				bdao, 
				(Object)av, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
