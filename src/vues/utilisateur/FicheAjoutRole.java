package vues.utilisateur;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;


public class FicheAjoutRole extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	RoleDao roleDao;

	/**
	 * Create the frame.
	 */
	public FicheAjoutRole(Role role) {

		String[] listLabelsRole = { "IdRole", "RoleNom" };

		String[] listTextFieldsRole = {"", ""};
				
		String[] listTextBtnsRole = { "Valider","Annuler" };
		String[] listMethodeDoaRole = { "save","" };
		roleDao = new RoleDao();

		new Fiche(
				"Création d'un role", 
				roleDao, 
				(Object)role, 
				listLabelsRole, 
				listTextFieldsRole,
				listTextBtnsRole,
				listMethodeDoaRole
				);
	}
}
