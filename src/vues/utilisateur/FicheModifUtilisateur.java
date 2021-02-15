package vues.utilisateur;

import java.util.ArrayList;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;
import vues.FicheUtilisateur;


public class FicheModifUtilisateur extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDao utilisateurDao;

	/**
	 * Create the frame.
	 */
	public FicheModifUtilisateur(Utilisateur utilisateur) {

		String[] listLabels = { "IdUtilisateur", "Mail", "MotDePasse", "Statut", "IdRole" };
		
		String[] listTextFields = {String.valueOf(utilisateur.getIdUtilisateur()), utilisateur.getMail(), utilisateur.getMotDePasse(), String.valueOf(utilisateur.getStatut()), utilisateur.getIdRole()};
		
		ArrayList<Role> listeRoles = new RoleDao().getAll();

		String[] jComboBoxTitles = new String[listeRoles.size()];

		int i = 0;
		for (Role r : listeRoles) {
			jComboBoxTitles[i] = r.getRoleNom();
			i++;
		}
				
		String[] listTextBtns = { "Valider","Annuler" };
		String[] listMethodeDoa = { "update","" };
		utilisateurDao = new UtilisateurDao();

		new FicheUtilisateur(
				"Modification d'un utilisateur", 
				utilisateurDao, 
				(Object)utilisateur, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa,
				jComboBoxTitles
				);
	}
}
