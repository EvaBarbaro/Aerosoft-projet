package vues.vol;

import javax.swing.JFrame;

import dao.VolDao;
import models.Vol;
import vues.Fiche;


public class FicheModifVol extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	VolDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheModifVol(Vol v) {

		String[] listLabels = { "Id du vol", "Aeroport de depart", "Heure de depart", "Aeroport d'arrivé'", "Heure d'arrivé'"};
		
		String[] listTextFields = {v.getNumVol(),v.getAeroportDepart(),v.getHeureDepart(),v.getAeroportArrive(), v.getHeureArrive()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "update","" };
		bdao = new VolDao();

		new Fiche(
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
