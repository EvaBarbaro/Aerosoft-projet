package vues.affectation;

import java.util.ArrayList;

import javax.swing.JFrame;

import dao.AeroportDao;
import dao.AffectationDao;
import dao.PiloteDao;
import models.Aeroport;
import models.Affectation;
import models.Pilote;
import vues.Fiche;
import vues.FicheAffectation;


public class FicheModifAffectation extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AffectationDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheModifAffectation(Affectation a) {

		String[] listLabels = { "Id de l'affectation", "Numéro du vol", "Dat du vol", "Code de l'affectation","Numéro de l'avion","Pilote"};

		String[] listTextFields = { 
				a.getId(), 
				a.getNumVol(), 
				a.getDateVol().toString(),
				a.getAffectationCode().toString(), 
				"" + a.getNumAvion(), 
				a.getPilote().getNomPilote() 
		};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "update","" };
		bdao = new AffectationDao();

		ArrayList<Pilote> listePilotes = new PiloteDao().getAll();

		String [] jComboBoxTitles =(String []) listePilotes.toArray();

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
