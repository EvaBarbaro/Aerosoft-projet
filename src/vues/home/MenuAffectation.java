package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


import models.Affectation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.affectation.*;

public class MenuAffectation extends JMenu{
    
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    private JMenuItem i1, i2, i3, i4, i5;

    private JMenu menu;

    public JMenu getMenu() {
        return this.menu;
    }

    public MenuAffectation() {

        menu = new JMenu("Affectation");

        i1 = new JMenuItem("Lister les affectations");
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
         
                new ListeAffectations();
            }
        });

        i2 = new JMenuItem("Ajouter une affectation");
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
         

                /*AffectationDao afDao = new AffectationDao();
                String idAe = "IT1002001-04-06"; */
                Affectation ae = new Affectation();
                new FicheAjoutAffectation(ae);
            }
        });

        i5 = new JMenuItem("Modifier les affectations");
        i5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
         
                new ListeModifAffectations();
            }
        });

        i3 = new JMenuItem("Supprimer une affectation");
        i3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ListeDeleteAffectations();
            }
        });

        i4 = new JMenuItem("Rechercher une affectation");
        i4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
         
                //new searchLivre();
                new RechercherAffectation();
            }
        });

        menu.add(i1);
        menu.add(i2);
        menu.add(i5);
        menu.add(i3);
        menu.add(i4);
    }     
}
