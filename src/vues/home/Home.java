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

    private int[] droitInt = new int [5];
    private String getDroit;

    public int[] getDroitInt() {
        return this.droitInt;
    }

    public void setDroitInt(int[] droitInt) {
        this.droitInt = droitInt;
    }

    public Home(int idUser) {
        System.out.println(idUser);
        Utilisateur u;
        UtilisateurDao daoU = new UtilisateurDao();
        u = (Utilisateur) daoU.get(idUser);
        
        //Droit normal
        getDroit = u.getIdRole();
        //System.out.println(getDroit);

        // droit en tableau
        String[] droitArray = getDroit.split("");
        //for(String droit : droitArray){
            //System.out.println(droit);
        //}

        //convertion en int
        this.droitInt = new int[droitArray.length];
        for (int i = 0; i < droitInt.length; i++){ 
            this.droitInt[i] = Integer.parseInt(droitArray[i]);
            //System.out.println(i + " : " + droitInt[0]); 
        }
        initialize();
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
        //int droit = this.droitInt[0];
       // System.out.println(droit);
        /*
        for(int droitListe : droitInt){
            System.out.println(droitListe);
        }
        */
        if(this.droitInt[0] != 0){
            mb.add(new MenuAeroport(this.droitInt[0]).getMenu());
        }

        /*Menu vol*/
        if(this.droitInt[1] != 0){
            mb.add(new MenuVol(this.droitInt[1]).getMenu());
        }

        /*Menu pilote*/
        if(this.droitInt[2] != 0){
            mb.add(new MenuPilote(this.droitInt[2]).getMenu());
        }
        
        /*MenuAffectation*/
        if(this.droitInt[3] != 0){
            mb.add(new MenuAffectation(this.droitInt[3]).getMenu());
        }

        /*Menu avion*/
        if(this.droitInt[4] != 0){
            mb.add(new MenuAvion(this.droitInt[4]).getMenu());
        }

        //MenuUtilisateur
        if(this.getDroit.equals("55555")){
            mb.add(new MenuUtilisateur().getMenu());
        }

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
