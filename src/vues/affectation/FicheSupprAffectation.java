package vues.affectation;

import javax.swing.JFrame;

import dao.AeroportDao;
import dao.AffectationDao;
import models.Aeroport;
import models.Affectation;
import vues.Fiche;


public class FicheSupprAffectation extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AffectationDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheSupprAffectation(Affectation a) {

		String[] listLabels = { "Id de l'affectation à supprimer"};
		
		String[] listTextFields = {a.getId()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "delete","" };
		bdao = new AffectationDao();

		new Fiche(
				"Suppression d'une affectation", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
