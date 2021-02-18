package vues.vol;

import javax.swing.JFrame;

// import de volDao
import dao.VolDao;

// import de model Vol
import models.Vol;

// import de la fiche générique
import vues.Fiche;


public class FicheAjoutVol extends JFrame {

	private static final long serialVersionUID = 1L;

	VolDao bdao;

	/**
	 * Creation de la frame d'ajout d'un vol.
	 */
	public FicheAjoutVol(Vol a) {

		// Tableau de la liste des vols
		String[] listLabels = {"Id du vol", "Aeroport de depart", "Heure de depart",
				"Aeroport d'arrivé", "Heure d'arrivé"};

		// Tableau des TextFields
		String[] listTextFields = {"", "", "", "", ""};

		// Tableau des boutons
		String[] listTextBtns = {"Valider", "Annuler"};

		// Tableau des méthodes
		String[] listMethodeDoa = {"save", ""};
		bdao = new VolDao();

		new Fiche("Ajout d'un vol", bdao, (Object) a, listLabels, listTextFields, listTextBtns,
				listMethodeDoa);
	}
}
