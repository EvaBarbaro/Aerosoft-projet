package vues.home;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Toolkit;

import dao.*;
import models.*;
import vues.Fiche;
import vues.aeroport.*;
import vues.affectation.*;
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
        JMenu menu;
        //submenu;  

        JMenuBar mb = new JMenuBar();
        /* Menu 1*/
        menu = new JMenu("Accueil");

        mb.add(menu);

        /*MenuAeroport*/                  
        mb.add(new MenuAeroport().getMenu());

        /*MenuAffectation*/
        mb.add(new MenuAffectation().getMenu());

        /*MenuAffectation*/
        mb.add(new MenuPilote().getMenu()); 

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


