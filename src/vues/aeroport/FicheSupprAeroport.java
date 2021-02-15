package vues.aeroport;

import javax.swing.JFrame;

import dao.AeroportDao;
import models.Aeroport;
import vues.Fiche;


public class FicheSupprAeroport extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AeroportDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheSupprAeroport(Aeroport a) {

		String[] listLabels = { "Id de l'aeroport à supprimer"};
		
		String[] listTextFields = {"" + a.getIdAeroport()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "delete","" };
		bdao = new AeroportDao();

		new Fiche(
				"Suppression d'un Aeroport", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
