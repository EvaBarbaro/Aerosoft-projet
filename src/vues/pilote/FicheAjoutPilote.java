package vues.pilote;

import java.util.*;

import javax.swing.JFrame;

import dao.*;
import models.*;
import vues.Fiche;
import vues.FicheUtilisateur;


public class FicheAjoutPilote extends JFrame {

	private static final long serialVersionUID = 1L;
	
	PiloteDao piloteDao;

    UtilisateurDao utilisateurDao;

    Utilisateur utilisateur = new Utilisateur();

	// Créer un ID unique
    int uniqueID = UUID.randomUUID().hashCode();

	/**
	 * Crée une frame d'ajout pilote.
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

		/**
		 * Crée une frame d'ajout utilisateur pilote.
		 */
        String[] listLabelUser = { "Id de l'utilisateur", "Mail", "Mot de passe", "satut", "role"};
		
		String[] listTextFieldUser = {String.valueOf(uniqueID),"","", "false", String.valueOf(11111)};
			
		ArrayList<Role> listeRoles = new RoleDao().getAll();

		Map<String, String> jComboBoxTitles = new HashMap<>();

		for (Role r : listeRoles) {
			jComboBoxTitles.put(r.getRoleNom(), r.getIdRole());
		}
				
		String[] listTextBtnsUser = { "Valider","Annuler" };
		String[] listMethodeDoaUser = { "save","" };
		utilisateurDao = new UtilisateurDao();

		new FicheUtilisateur(
				"Ajout d'un utilisateur pilote", 
				utilisateurDao, 
				(Object)utilisateur, 
				listLabelUser, 
				listTextFieldUser,
				listTextBtnsUser,
				listMethodeDoaUser,
				jComboBoxTitles
				);
	}

}
