package vues.affectation;

import dao.AffectationDao;
import dao.PiloteDao;
import java.util.ArrayList;
import javax.swing.JFrame;
import models.Affectation;
import models.Pilote;
import vues.FicheAffectation;

public class FicheModifAffectation extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  AffectationDao bdao;

  /**
   * Create the frame.
   */
  public FicheModifAffectation(Affectation a) {
    String[] listLabels = {
      "Id de l'affectation",
      "Numéro du vol",
      "Dat du vol",
      "Code de l'affectation",
      "Numéro de l'avion",
      "Pilote",
    };

    String[] listTextFields = {
      a.getId(),
      a.getNumVol(),
      a.getDateVol().toString(),
      a.getAffectationCode().toString(),
      "" + a.getNumAvion(),
      a.getPilote().getNomPilote(),
    };

    String[] listTextBtns = { "Valider", "Annuler" };
	String[] listMethodeDoa = { "update", "" };
	
    bdao = new AffectationDao();

    ArrayList<Pilote> listePilotes = new PiloteDao().getAll();

    String[] jComboBoxTitles = new String[listePilotes.size()];

    int i = 0;
    for (Pilote p : listePilotes) {
      jComboBoxTitles[i] = p.getNomPilote();
      i++;
    }

    new FicheAffectation(
      "Modification d'une affectation",
      bdao,
      (Object) a,
      listLabels,
      listTextFields,
      listTextBtns,
      listMethodeDoa,
      jComboBoxTitles
    );
  }
}
