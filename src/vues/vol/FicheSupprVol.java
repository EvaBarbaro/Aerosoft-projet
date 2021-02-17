package vues.vol;

import javax.swing.JFrame;

import dao.VolDao;
import models.Vol;
import vues.FicheFirstFieldFalse;


public class FicheSupprVol extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	VolDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheSupprVol(Vol v) {

		String[] listLabels = { "Id du Vol à supprimer"};
		
		String[] listTextFields = {"" + v.getNumVol()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "delete","" };
		bdao = new VolDao();

		new FicheFirstFieldFalse(
				"Suppression d'un Vol", 
				bdao, 
				(Object)v, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
