package vues.affectation;

import javax.swing.JFrame;

import dao.AeroportDao;
import dao.AffectationDao;
import models.Aeroport;
import models.Affectation;
import vues.Fiche;


public class FicheAjoutAffectation extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AffectationDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheAjoutAffectation(Affectation a) {

		String[] listLabels = { "Id de l'affectation", "Numéro du vol", "Dat du vol", "Code de l'affectation","Numéro de l'avion","Pilote"};
		
		String[] listTextFields = {"","","","","",""};
			
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "save","" };
		bdao = new AffectationDao();

		new Fiche(
				"Ajout d'une affectation", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
