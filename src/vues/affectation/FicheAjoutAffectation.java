package vues.affectation;

import java.util.ArrayList;

import javax.swing.JFrame;

import dao.AffectationDao;
import dao.PiloteDao;

import models.Affectation;
import models.Pilote;

import vues.FicheAffectation;


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
		
		String[] listTextFields = {"","IT111","2001-05-08","1","109",""};
			
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "save", "" };
		
		bdao = new AffectationDao();
		
		ArrayList<Pilote> listePilotes = new PiloteDao().getAll();

		String[] jComboBoxTitles = new String[listePilotes.size()];

		int i = 0;
		for (Pilote p : listePilotes) {
			jComboBoxTitles[i] = p.getNomPilote();
			i++;
		}

		

		new FicheAffectation(
				"Ajout d'une affectation", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa,
				jComboBoxTitles
				);
	}
}
