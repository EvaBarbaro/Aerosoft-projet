package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import models.Aeroport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.aeroport.*;

public class MenuAeroport extends JMenu{
    
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    private JMenuItem i1, i2, i3, i4;

    private JMenu menu;

    public JMenu getMenu() {
        return this.menu;
    }

    public MenuAeroport() {

        menu = new JMenu("Aeroport");

        i1 = new JMenuItem("Lister les aeroport");
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                new ListeAeroports();
            }
        });

        i2 = new JMenuItem("Ajouter un aeroport");
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);

                /*AeroportDao aeDao = new AeroportDao();
                String idAe = "CDG"; */
                Aeroport ae = new Aeroport();
                new FicheAjoutAeroport(ae);
            }
        });

        i3 = new JMenuItem("Suprimer un aeroport");
        i3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                Aeroport ae = new Aeroport();
                new FicheSupprAeroport(ae);
            }
        });

        i4 = new JMenuItem("Trouver un aeroport");
        i4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //frame.setVisible(true);
                //new searchLivre();
                new RechercherAeroport();
            }
        });

        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
    }     
}
