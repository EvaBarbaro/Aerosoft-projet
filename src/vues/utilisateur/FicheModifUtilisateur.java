package vues.utilisateur;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;


public class FicheModifUtilisateur extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDao utilisateurDao;

	RoleDao roleDao;

	Role role = new Role();

	/**
	 * Create the frame.
	 */
	public FicheModifUtilisateur(Utilisateur utilisateur) {

		String[] listLabels = { "IdUtilisateur", "Mail", "MotDePasse", "Statut", "IdRole" };
		
		String[] listTextFields = {String.valueOf(utilisateur.getIdUtilisateur()), utilisateur.getMail(), utilisateur.getMotDePasse(), String.valueOf(utilisateur.getStatut()), utilisateur.getIdRole()};
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "update","" };
		utilisateurDao = new UtilisateurDao();

		new Fiche(
				"Modification d'un utilisateur", 
				utilisateurDao, 
				(Object)utilisateur, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);

		String[] listLabelsRole = { "IdRole", "RoleNom" };

		String[] listTextFieldsRole = {"", ""};
				
		String[] listTextBtnsRole = { "Valider","Annuler" };
		String[] listMethodeDoaRole = { "save","" };
		roleDao = new RoleDao();

		new Fiche(
				"Modification d'un role", 
				roleDao, 
				(Object)role, 
				listLabelsRole, 
				listTextFieldsRole,
				listTextBtnsRole,
				listMethodeDoaRole
				);
	}
}
