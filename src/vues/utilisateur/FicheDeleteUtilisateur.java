package vues.utilisateur;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;


public class FicheDeleteUtilisateur extends JFrame {

	private static final long serialVersionUID = 1L;

	UtilisateurDao utilisateurDao = new UtilisateurDao();

	/**
	 * Create the frame.
	 */
	public FicheDeleteUtilisateur(Utilisateur utilisateur) {

		String[] listLabels = { "Id de l'aeroport à supprimer"};
		
		String[] listTextFields = {"" + utilisateur.getIdUtilisateur()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "delete","" };

		new Fiche(
				"Suppression d'un Utilisateur", 
				utilisateurDao, 
				(Object)utilisateur, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
	}
}