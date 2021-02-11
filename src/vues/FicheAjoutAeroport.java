package vues;

import javax.swing.JFrame;

import dao.AeroportDao;
import dao.UtilisateurDao;
import models.Aeroport;
import models.Utilisateur;

public class FicheAjoutAeroport extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	AeroportDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheAjoutAeroport(Aeroport a) {

		String[] listLabels = { "Id de l'aeroport", "Nom de l'aeroport", "Ville de l'aeroport"};
		
		String[] listTextFields = {"","",""};

		//("Supprimer","Voulez-vous vraiment supprimer", "Oui", "Non")
		//String[][] listSuperDialog = { { "Ajout", "Ajouter Reussi", "Valider", "" } };
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "save","" };
		bdao = new AeroportDao();

		new Fiche(
				"Ajout Aeroport", 
				bdao, 
				(Object)a, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}
