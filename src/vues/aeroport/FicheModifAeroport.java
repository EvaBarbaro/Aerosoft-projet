package vues.aeroport;

import dao.AeroportDao;
import javax.swing.JFrame;
import models.Aeroport;
import vues.Fiche;
import vues.FicheFirstFieldFalse;

public class FicheModifAeroport extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  AeroportDao bdao;

  /**
   * Create the frame.
   */
	public FicheModifAeroport(Aeroport a) {
	  
		String[] listLabels = { "Id de l'aeroport", "Nom de l'aeroport", "Ville de l'aeroport", };

		String[] listTextFields = { a.getIdAeroport(), a.getNomAeroport(), a.getNomVille(), };

		String[] listTextBtns = { "Valider", "Annuler" };
		String[] listMethodeDoa = { "update", "" };

    	bdao = new AeroportDao();

    	new FicheFirstFieldFalse(
      		"Modification d'un aeroport",
      		bdao,
			(Object) a,
      		listLabels,
      		listTextFields,
      		listTextBtns,
      		listMethodeDoa
    );
  }
}
