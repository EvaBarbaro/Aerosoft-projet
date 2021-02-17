package vues.home;

import javax.swing.*;

import dao.PiloteDao;
import models.Pilote;
import vues.Fiche;

public class InfosPilote extends JFrame{

    private static final long serialVersionUID = 1L;

    PiloteDao piloteDao; 
     

    public InfosPilote(Pilote pilote) {
        piloteDao = new PiloteDao();

        String[] listLabels = { " ",
                                "Votre Nom:", 
                                "Votre Prenom:",
                                "Votre Matricule:"
                            };
		
        String[] listTextFields = { "" + pilote.getIdPilote(),
                                    pilote.getNomPilote(),
                                    pilote.getPrenomPilote(),
                                    "" + pilote.getMatricule()
                                };
                
        String[] listTextBtns = { "Modifier","Annuler" };
        String[] listMethodeDoa = { "update", "" };
        
        new Fiche(
				"Mes informations Pilote", 
				piloteDao, 
				(Object)pilote, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa,
                false
				);        
    }
    
}
