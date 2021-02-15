package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import models.Avion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.avion.FicheAjoutAvion;
import vues.avion.*;

public class MenuAvion extends JMenu {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JMenuItem i1, i2, i3, i4;

    private JMenu menu;

    public JMenu getMenu() {
        return this.menu;
    }

    public MenuAvion() {

        menu = new JMenu("Avion");

        i1 = new JMenuItem("Lister les Avions");
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                new ListeAvion();
            }
        });

        i2 = new JMenuItem("Ajouter un avion");
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);

                /*AeroportDao aeDao = new AeroportDao();
                String idAe = "CDG"; */
                Avion av = new Avion();
                new FicheAjoutAvion(av);
            }
        });

        i3 = new JMenuItem("Suprimer un avion");
        i3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                Avion av = new Avion();
                new FicheSupprAvion(av);
            }
        });

        i4 = new JMenuItem("Trouver un avion");
        i4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                //new searchLivre();
                new RechercherAvion();
            }
        });

        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
    }     
}
