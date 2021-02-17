package vues.avion;

import dao.AeroportDao;
import dao.AvionDao;
import dao.DetailAvionDao;

import java.util.ArrayList;

import javax.swing.JFrame;

import models.Aeroport;
import models.Avion;
import models.DetailAvion;
import vues.Fiche;
import vues.FicheAvion;

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
    String[] listLabels = { "Num Avion", "Type avion", "Base aeroport" };

    String[] listTextFields = { "", "", "" };

    String[] listTextBtns = { "Valider", "Annuler" };
    String[] listMethodeDoa = { "save", "" };

    bdao = new AvionDao();

    ArrayList<DetailAvion> listeType = new DetailAvionDao().getAll();
		ArrayList<Aeroport> listeBase = new AeroportDao().getAll();

		String[] jComboBoxTypeTitles = new String[listeType.size()];
		String[] jComboBoxBaseTitles = new String[listeBase.size()];

    int i = 0;
    for (DetailAvion detailAvion : listeType) {
      jComboBoxTypeTitles[i] = detailAvion.getTypeAvion();
      i++;
    }

		i = 0;
		for (Aeroport aeroport : listeBase) {
			jComboBoxBaseTitles[i] = aeroport.getIdAeroport();
			i++;
		}

    new FicheAvion(
      "Ajout d'un vol",
      bdao,
      (Object) av,
      listLabels,
      listTextFields,
      listTextBtns,
      listMethodeDoa,
      jComboBoxTypeTitles,
      jComboBoxBaseTitles
    );
  }
}
