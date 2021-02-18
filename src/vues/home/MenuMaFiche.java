package vues.home;

import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import java.util.*;
import dao.PiloteDao;
import dao.UtilisateurDao;
import models.Pilote;
import models.Utilisateur;
import vues.Fiche;
import vues.Login;
import vues.compte.MaFiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MenuMaFiche extends JMenu{

    private static final long serialVersionUID = 1L;
    
    private JMenuItem itemMe, itemMePilote, itemLogOut;

    private JMenu menuMaFiche;

    PiloteDao piloteDao = new PiloteDao();

    Pilote pilote;

    public JMenu getMenu() {
        return this.menuMaFiche;
    }

    public MenuMaFiche(int idUser, JFrame frame) {

    menuMaFiche = new JMenu("Ma Fiche");
    Font font = new Font("Serial", Font.BOLD, 16);
    menuMaFiche.setFont(font);

    itemMe=new JMenuItem("Mon Compte");
    itemMe.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt){
            
            new MaFiche(idUser);
    	}
    });

    pilote = (Pilote) piloteDao.get(idUser);

    itemMePilote=new JMenuItem("Mes informations pilotes");
    itemMePilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
            JFrame meFramePilote = new JFrame();
            JLabel labelNom, labelPrenom, labelMatricule;
            JTextField textFieldId, textFieldNom, textFieldPrenom, textFieldMatricule;
            JButton btnModifierPilote;

            PiloteDao piloteDao = new PiloteDao();
            Pilote pilote;
            pilote = (Pilote) piloteDao.get(idUser);

            JLabel labelimage = new JLabel();
            ImageIcon img = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(
                        Fiche.class.getResource("/images/Aerosoft-logo.PNG"))
                        .getScaledInstance(160, 50, Image.SCALE_DEFAULT)
                    );
            labelimage.setBounds(80, 10, 400, 70); 
            labelimage.setIcon(img);
            meFramePilote.add(labelimage);

            labelNom = new JLabel("Votre Nom:");
            labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
            labelNom.setBounds(80, 90, 200, 30);

            labelPrenom = new JLabel("Votre Prenom:");
            labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
            labelPrenom.setBounds(80, 130, 200, 30);

            labelMatricule = new JLabel("Votre Matricule:");
            labelMatricule.setFont(new Font("Tahoma", Font.PLAIN, 15));
            labelMatricule.setBounds(80, 170, 200, 30);

            textFieldId = new JTextField("" + pilote.getIdPilote());
            textFieldId.setVisible(false);

            textFieldNom = new JTextField(pilote.getNomPilote());
            textFieldNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
            textFieldNom.setBounds(300, 90, 200, 30);

            /* Mot de passe*/
            textFieldPrenom = new JTextField(pilote.getPrenomPilote());
            textFieldPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
            textFieldPrenom.setBounds(300, 130, 200, 30);

            textFieldMatricule = new JTextField("" + pilote.getMatricule());
            textFieldMatricule.setFont(new Font("Tahoma", Font.PLAIN, 15));
            textFieldMatricule.setBounds(300, 170, 200, 30);

            btnModifierPilote = new JButton("Modifier");
            btnModifierPilote.setBounds(300, 210, 100, 30);
            btnModifierPilote.setFont(new Font("Tahoma", Font.BOLD, 15));
            btnModifierPilote.setBackground(new Color(1, 175, 228));
            btnModifierPilote.setForeground(Color.WHITE);
            btnModifierPilote.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent eventUpdateUser) 
                {
                    String userPilotString[] = new String[5];
                    userPilotString[0] = textFieldNom.getText();
                    userPilotString[1] = textFieldPrenom.getText();
                    userPilotString[2] = textFieldMatricule.getText();

                    piloteDao.update(pilote, userPilotString);

                    meFramePilote.dispose();
                }
            });
            
            meFramePilote.add(labelNom);meFramePilote.add(textFieldNom);meFramePilote.add(labelPrenom);meFramePilote.add(textFieldPrenom);meFramePilote.add(labelMatricule); meFramePilote.add(textFieldMatricule); meFramePilote.add(btnModifierPilote);

            meFramePilote.setTitle("Aerosoft");

            meFramePilote.setSize(650, 350);
            meFramePilote.setLayout(null);
            meFramePilote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            meFramePilote.setVisible(true);
    	}
    });
        //Deconexion 
        itemLogOut=new JMenuItem("Déconnexion");
        itemLogOut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                frame.dispose();
                new Login();
            }
        });

        menuMaFiche.add(itemMe);  
        if (pilote != null) {
            menuMaFiche.add(itemMePilote);   
        }
        menuMaFiche.add(itemLogOut);
    }     
}
