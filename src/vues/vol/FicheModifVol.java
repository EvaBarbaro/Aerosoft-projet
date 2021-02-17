package vues.vol;

import javax.swing.JFrame;

// import de VolDao
import dao.VolDao;

// import du model Vol
import models.Vol;

// Import de Fiche générique avec le premier textField disabled
import vues.FicheFirstFieldFalse;


public class FicheModifVol extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	VolDao bdao;

	/**
	 * Creation de la frame de modification d'un vol.
	 */
	public FicheModifVol(Vol v) {

		// Tableau des labels
		String[] listLabels = { "Id du vol", "Aeroport de depart", "Heure de depart", "Aeroport d'arrivé'", "Heure d'arrivé'"};

		// tableau des textFields
		String[] listTextFields = {v.getNumVol(),v.getAeroportDepart(),v.getHeureDepart(),v.getAeroportArrive(), v.getHeureArrive()};

		// Tableau des boutons
		String[] listTextBtns = { "Valider","Annuler" };

		// Tableau des méthodes
		String[] listMethodeDoa = { "update","" };
		bdao = new VolDao();

		new FicheFirstFieldFalse(
				"Modification d'un vol", 
				bdao, 
				(Object)v, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
