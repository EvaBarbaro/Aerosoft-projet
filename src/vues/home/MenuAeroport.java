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

    private int droit = 0;
    
    private JMenuItem i1, i2, i3, i4, i5;

    private JMenu menu;

    public JMenu getMenu() {
        return this.menu;
    }

    public MenuAeroport(int droitInt) {

        this.droit = droitInt;

        menu = new JMenu("Aeroport");

        System.out.println(droitInt);
        System.out.println(droit);
        
        if(droit >=1){

            i1 = new JMenuItem("Lister les aeroport");
            i1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //frame.setVisible(true);
                    new ListeAeroports();
                }
            });
            menu.add(i1);

            i2 = new JMenuItem("Trouver un aeroport");
            i2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //frame.setVisible(true);
                    //new searchLivre();
                    new RechercherAeroport();
                }
            });
            menu.add(i2);
  
        }

        if(droit >=2){

            i3 = new JMenuItem("Modifier un aeroport");
            i3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //frame.setVisible(true);
                    new ListeAeroports();
                }
            });
            menu.add(i3);

        }

        if(droit >=3){

            i4 = new JMenuItem("Ajouter un aeroport");
            i4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //frame.setVisible(true);

                    /*AeroportDao aeDao = new AeroportDao();
                    String idAe = "CDG"; */
                    Aeroport ae = new Aeroport();
                    new FicheAjoutAeroport(ae);
                }
            });
            menu.add(i4);
           
        }
        
        if(droit >=4){
            
            i5 = new JMenuItem("Suprimer un aeroport");
            i5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //frame.setVisible(true);
                    //Aeroport ae = new Aeroport();
                    
                    new ListeDeleteAeroports();
                }
            });
            menu.add(i5);
        }
               
    }     
}