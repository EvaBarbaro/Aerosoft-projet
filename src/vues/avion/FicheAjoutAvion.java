package vues.avion;

import dao.AvionDao;
import javax.swing.JFrame;
import models.Avion;
import vues.Fiche;

public class FicheAjoutAvion extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  AvionDao bdao;

  /**
   * Create the frame.
   */
  public FicheAjoutAvion(Avion av) {
    String[] listLabels = { "Numéro avion", "Type avion", "Base aeroport" };

    String[] listTextFields = { "", "", "" };

    String[] listTextBtns = { "Valider", "Annuler" };
    String[] listMethodeDoa = { "save", "" };

    bdao = new AvionDao();

    new Fiche(
      "Ajout d'un vol",
      bdao,
      (Object) av,
      listLabels,
      listTextFields,
      listTextBtns,
      listMethodeDoa
    );
  }
}
