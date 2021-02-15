package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import models.Vol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.aeroport.FicheAjoutAeroport;
import vues.vol.*;

public class MenuVol extends JMenu {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JMenuItem i1, i2, i3, i4;

    private JMenu menu;

    public JMenu getMenu() {
        return this.menu;
    }

    public MenuVol() {

        menu = new JMenu("Vols");

        i1 = new JMenuItem("Lister les vols");
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                new ListeVol();
            }
        });

        i2 = new JMenuItem("Ajouter un vol");
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);

                /*AeroportDao aeDao = new AeroportDao();
                String idAe = "CDG"; */
                Vol v = new Vol();
                new FicheAjoutVol(v);
            }
        });

        i3 = new JMenuItem("Suprimer un vol");
        i3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                Vol v = new Vol();
                new FicheSupprVol(v);
            }
        });

        i4 = new JMenuItem("Trouver un vol");
        i4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                //new searchLivre();
                new RechercherVol();
            }
        });

        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
    }     
}
