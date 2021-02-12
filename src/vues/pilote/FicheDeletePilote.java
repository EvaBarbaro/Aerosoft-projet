package vues.pilote;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;


public class FicheDeletePilote extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	PiloteDao piloteDao;

	UtilisateurDao utilisateurDao;

    Utilisateur utilisateur = new Utilisateur();

	/**
	 * Create the frame.
	 */
	public FicheDeletePilote(Pilote pilote) {

		String[] listLabels = { "Id de l'aeroport à supprimer"};
		
		String[] listTextFields = {String.valueOf(pilote.getIdPilote())};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "delete","" };
		piloteDao = new PiloteDao();

		new Fiche(
				"Suppression d'un Pilote", 
				piloteDao, 
				(Object)pilote, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
		
		String[] listLabelUser = { "Id de l'utilisateur à supprimer"};

		String[] listTextFieldUser = {String.valueOf(pilote.getIdPilote())};
			
		String[] listTextBtnUser = { "Valider","Annuler" };
		String[] listMethodeDoaUser = { "delete","" };
		utilisateurDao = new UtilisateurDao();

		new Fiche(
				"Supression d'un utilisateur pilote", 
				utilisateurDao, 
				(Object)utilisateur, 
				listLabelUser, 
				listTextFieldUser,
				listTextBtnUser,
				listMethodeDoaUser
				);
	}
}