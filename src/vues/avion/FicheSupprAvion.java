package vues.avion;

import javax.swing.JFrame;

import dao.AvionDao;
import models.Avion;
import vues.Fiche;


public class FicheSupprAvion extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AvionDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheSupprAvion(Avion av) {

		String[] listLabels = { "Id de l'avion à supprimer"};
		
		String[] listTextFields = {"" + av.getNumAvion()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "delete","" };
		bdao = new AvionDao();

		new Fiche(
				"Suppression d'un Vol", 
				bdao, 
				(Object)av, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
