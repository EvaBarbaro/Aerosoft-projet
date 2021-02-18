package vues.pilote;

import javax.swing.JFrame;

// import des daos
import dao.*;

// import des models
import models.*;

// import de la fiche générique
import vues.Fiche;
import vues.FicheFirstFieldFalse;


public class FicheModifPilote extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	PiloteDao piloteDao;

	/**
	 * Crée la frame d'affichage des pilotes.
	 */
	public FicheModifPilote(Pilote pilote) {

		// Tableau des labels
		String[] listLabels = {"IdPilote", "Nom du pilote", "Prenom du Pilote", "Matricule"};
		
		// Tableau des champs de textes
		String[] listTextFields = {"" + pilote.getIdPilote(), pilote.getNomPilote(),pilote.getPrenomPilote(),pilote.getMatricule()};
				
		// Tableau des boutons
		String[] listTextBtns = { "Valider","Annuler" };

		// Tableau des méthodes
		String[] listMethodeDoa = { "update","" };
		piloteDao = new PiloteDao();

		new FicheFirstFieldFalse(
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
