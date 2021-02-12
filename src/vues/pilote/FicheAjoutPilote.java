package vues.pilote;

import java.util.UUID;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;


public class FicheAjoutPilote extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	PiloteDao piloteDao;

    UtilisateurDao utilisateurDao;

    Utilisateur utilisateur = new Utilisateur();

    int uniqueID = UUID.randomUUID().hashCode();

	/**
	 * Create the frame.
	 */
	public FicheAjoutPilote(Pilote pilote) {

		String[] listLabels = { "Id du pilote", "Nom du pilote", "Prénom du pilote", "Matricule"};
		
		String[] listTextFields = {String.valueOf(uniqueID),"","",""};
			
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "save","" };
		piloteDao = new PiloteDao();

		new Fiche(
				"Ajout d'un pilote", 
				piloteDao, 
				(Object)pilote, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);

        String[] listLabelUser = { "Id de l'utilisateur", "Mail", "Mot de passe", "satut", "role"};
		
		String[] listTextFieldUser = {String.valueOf(uniqueID),"","", "false", String.valueOf(11111)};
			
		String[] listTextBtnUser = { "Valider","Annuler" };
		String[] listMethodeDoaUser = { "save","" };
		utilisateurDao = new UtilisateurDao();

		new Fiche(
				"Ajout d'un utilisateur pilote", 
				utilisateurDao, 
				(Object)utilisateur, 
				listLabelUser, 
				listTextFieldUser,
				listTextBtnUser,
				listMethodeDoaUser
				);
	}

}
