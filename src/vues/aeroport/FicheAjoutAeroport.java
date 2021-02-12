package vues.aeroport;

import javax.swing.JFrame;

import dao.AeroportDao;
import models.Aeroport;
import vues.Fiche;


public class FicheAjoutAeroport extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AeroportDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheAjoutAeroport(Aeroport a) {

		String[] listLabels = { "Id de l'aeroport", "Nom de l'aeroport", "Ville de l'aeroport"};
		
		String[] listTextFields = {"","",""};
			
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "save","" };
		bdao = new AeroportDao();

		new Fiche(
				"Ajout d'un aeroport", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
