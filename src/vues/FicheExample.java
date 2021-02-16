package vues;

import javax.swing.JFrame;


import dao.UtilisateurDao;

import models.Utilisateur;

public class FicheExample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDao bdao;

	/**
	 * Create the frame.
	 */
	public FicheExample(Utilisateur u) {

		String [] listLabels= {"IdUtilisateur","Mail","MotDePasse","Statut","IdRole","IdRole"};
		String[] listTextFields = { "" + u.getIdUtilisateur(), u.getMail(),u.getMotDePasse(), "" + u.getStatut(), u.getIdRole(), u.getIdRole()  };


		/*listSuperDialog Transferer dans la DOA*/
		/*String [][] listSuperDialog={ 
				{"Supprimer","Voulez-vous vraiment supprimer", "Oui", "Non"},
				{"Enregistrer", "Il y a eu des modifications. Voulez-vous enregistrer", "Oui", "Non"} 
		};*/
				
		String[] listTextBtns = { "Supprimer", "Valider" };
		String[] listMethodeDoa = { "delete", "update" };

		bdao = new UtilisateurDao();

		/*
		 * Fiche.Fiche(
		 * String titre, 
		 * BookDaoInterface dao, 
		 * Object transport, 
		 * int id, 
		 * String[] listLabels, 
		 * String[] listTextFields, 
		 * String[][] listSuperDialog
		 * String [] listTextBtns
		 * ) 
		 */
		new Fiche(
				"Fiche Utilisateur", 
				bdao, 
				(Object)u, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa

				);
	}
}
