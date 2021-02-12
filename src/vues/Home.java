package vues;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Toolkit;

import dao.*;
import models.*;
import vues.aeroport.*;
import vues.affectation.FicheAjoutAffectation;
import vues.affectation.FicheSupprAffectation;
import vues.affectation.RechercherAffectation;
import vues.pilote.*;

import javax.swing.*;


public class Home {

    public Home(int idUser) {
		initialize();
        System.out.println(idUser);
	}
	
    public void initialize() {

        /*Fenetre principal*/
        JFrame frame = new JFrame("Tableau de bord");
        /*Jpanel*/
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        /* Mise en place du menu  */
        JMenu menu, menu1, menuPilote, menu3;
        //submenu;  
        JMenuItem i1, i2, i3, i4;
        JMenuItem af1, af2, af3, af4;
        JMenuItem itemAddPilote, itemListPilote, itemReadPilote, itemDeletePilote;
        JMenuBar mb = new JMenuBar();
        /* Menu 1*/
        menu = new JMenu("Accueil");

        mb.add(menu);
        /*Menu 2*/
        menu1 = new JMenu("Aeroport");

        i1 = new JMenuItem("Lister les aeroport");
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);
                new ListeAeroports();
            }
        });

        i2 = new JMenuItem("Ajouter un aeroport");
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);

                /*AeroportDao aeDao = new AeroportDao();
                String idAe = "CDG"; */
                Aeroport ae = new Aeroport();
                new FicheAjoutAeroport(ae);
            }
        });

        i3 = new JMenuItem("Suprimer un aeroport");
        i3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);
                Aeroport ae = new Aeroport();
                new FicheSupprAeroport(ae);
            }
        });

        i4 = new JMenuItem("Trouver un aeroport");
        i4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);
                //new searchLivre();
                new RechercherAeroport();
            }
        });

        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
        menu1.add(i4);
        mb.add(menu1);

        /*Menu 3*/
        menu3 = new JMenu("Affectation");

        af1 = new JMenuItem("Lister les affectations");
        af1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);
                new ListeAeroports();
            }
        });

        af2 = new JMenuItem("Ajouter une affectation");
        af2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);

                /*AffectationDao afDao = new AffectationDao();
                String idAe = "IT1002001-04-06"; */
                Affectation ae = new Affectation();
                new FicheAjoutAffectation(ae);
            }
        });

        af3 = new JMenuItem("Supprimer une affectation");
        af3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);
                Affectation ae = new Affectation();
                new FicheSupprAffectation(ae);
            }
        });

        af4 = new JMenuItem("Trouver une affectation");
        af4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(true);
                //new searchLivre();
                new RechercherAffectation();
            }
        });

        menu3.add(af1);
        menu3.add(af2);
        menu3.add(af3);
        menu3.add(af4);
        mb.add(menu3);

        menuPilote=new JMenu("Pilote"); 

    itemReadPilote=new JMenuItem("Trouver un pilote");
    itemReadPilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);
            new FicheReadPilote();
    	}
    });

    itemAddPilote=new JMenuItem("Ajouter un pilote");
    itemAddPilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);
  
			Pilote pilote = new Pilote();
			new FicheAjoutPilote(pilote);
    	}
    });

    itemListPilote=new JMenuItem("Modifier les pilotes");
    itemListPilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);
			new FicheListPilote();
    	}
    });

    itemDeletePilote=new JMenuItem("Supprimer un pilote");
    itemDeletePilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);
			new FicheListDeletePilot();
    	}
    });

    mb.add(menuPilote); menuPilote.add(itemReadPilote); menuPilote.add(itemAddPilote); menuPilote.add(itemListPilote); menuPilote.add(itemDeletePilote);

        frame.setJMenuBar(mb);
        /*Ajout d'une image*/
        ImageIcon icon = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(Fiche.class.getResource("/images/Banniere_aerosoft.jpg"))
        /*.getScaledInstance(160, 50, Image.SCALE_DEFAULT)*/
        );

        /*label pour afficher l'image*/
        JLabel labelimage = new JLabel();
        labelimage.setIcon(icon);
        panel.add(labelimage);

        frame.add(panel);
        frame.setSize(1280, 780);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    

}


