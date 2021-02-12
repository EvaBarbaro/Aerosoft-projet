package vues.vol;

import javax.swing.JFrame;

import dao.VolDao;
import models.Vol;
import vues.Fiche;


public class FicheAjoutVol extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	VolDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheAjoutVol(Vol a) {

		String[] listLabels = { "Id du vol", "Aeroport de depart", "Heure de depart", "Aeroport d'arrivé", "Heure d'arrivé" };
		
		String[] listTextFields = {"","","","",""};
			
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "save","" };
		bdao = new VolDao();

		new Fiche(
				"Ajout d'un vol", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
