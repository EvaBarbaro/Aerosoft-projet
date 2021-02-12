package vues.pilote;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;


public class FicheModifPilote extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	PiloteDao piloteDao;

	/**
	 * Create the frame.
	 */
	public FicheModifPilote(Pilote pilote) {

		String[] listLabels = { "Nom du pilote", "Prenom du Pilote", "Matricule"};
		
		String[] listTextFields = {pilote.getNomPilote(),pilote.getPrenomPilote(),pilote.getMatricule()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "update","" };
		piloteDao = new PiloteDao();

		new Fiche(
				"Modification d'un pilote", 
				piloteDao, 
				(Object)pilote, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
