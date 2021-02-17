package vues.avion;

import dao.AvionDao;
import javax.swing.JFrame;
import models.Avion;
import vues.Fiche;

public class FicheModifAvion extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  AvionDao bdao;

  /**
   * Create the frame.
   */
  public FicheModifAvion(Avion av) {
    String[] listLabels = { "Numéro avion", "Type avion", "Base aeroport" };

    String[] listTextFields = {
      "" + av.getNumAvion(),
      av.getTypeAvion(),
      av.getBaseAeroport(),
    };

    String[] listTextBtns = { "Valider", "Annuler" };
    String[] listMethodeDoa = { "update", "" };

    bdao = new AvionDao();

    new Fiche(
      "Modification d'un vol",
      bdao,
      (Object) av,
      listLabels,
      listTextFields,
      listTextBtns,
      listMethodeDoa
    );
  }
}
