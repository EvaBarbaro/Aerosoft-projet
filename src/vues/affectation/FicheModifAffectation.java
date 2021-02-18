package vues.affectation;

import dao.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import models.Affectation;
import models.*;
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
  public FicheModifAffectation(Affectation af) {
    String[] listLabels = {
      "Id de l'affectation",
      "Numéro du vol",
      "Dat du vol",
      "Code de l'affectation",
      "Numéro de l'avion",
      "Pilote",
    };

    String[] listTextFields = {
      af.getId(),
      af.getNumVol(),
      af.getDateVol().toString(),
      af.getAffectationCode().toString(),
      "" + af.getNumAvion(),
      af.getPilote().getNomPilote(),
    };

    String[] listTextBtns = { "Valider", "Annuler" };
	String[] listMethodeDoa = { "update", "" };
	
    bdao = new AffectationDao();

    ArrayList<Pilote> 	listePilotes 	= new PiloteDao().getAll();
		ArrayList<Vol> 		listeVols 		= new VolDao().getAll();
		ArrayList<Avion> 	listeAvions 	= new AvionDao().getAll();

		String[] jComboBoxPiloteTitles 		= new String[listePilotes.size()];
		String[] jComboBoxNumVolTitles 		= new String[listeVols.size()];
		String[] jComboBoxNumAvionTitles 	= new String[listeAvions.size()];

		int i = 0;
		for (Pilote p : listePilotes) {
			jComboBoxPiloteTitles[i] = p.getNomPilote();
			i++;
		}

		i = 0;
		for (Vol v : listeVols) {
			jComboBoxNumVolTitles[i] = v.getNumVol();
			i++;
		}

		i = 0;
		for (Avion av : listeAvions) {
			jComboBoxNumAvionTitles[i] = "" + av.getNumAvion();
			i++;
		}

        new FicheAffectation(
            "Ajout d'une affectation",
            bdao,
            (Object) af,
            listLabels,
            listTextFields,
            listTextBtns,
            listMethodeDoa, 
            jComboBoxPiloteTitles, 
            jComboBoxNumVolTitles, 
            jComboBoxNumAvionTitles
            );
  }
}
