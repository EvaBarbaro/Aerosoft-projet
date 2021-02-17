package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

import dao.PiloteDao;
import dao.UtilisateurDao;
import models.Pilote;
import models.Utilisateur;
import vues.Fiche;
import vues.Login;

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
            
            JFrame meFrame = new JFrame();
            JLabel labelEmail, labelPassword;
            JTextField textFieldId, textFieldLogin, textFieldStatut, textFieldRole;
            JButton btnModifier;
            JPasswordField passwordField;

            Utilisateur utilisateur;
            UtilisateurDao utilisateurDao = new UtilisateurDao();
            utilisateur = (Utilisateur) utilisateurDao.get(idUser);
            System.out.println(utilisateur.getMail());
            System.out.println(utilisateur.getMotDePasse());

            JLabel labelimage = new JLabel();
            ImageIcon img = new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(
                        Fiche.class.getResource("/images/Aerosoft-logo.PNG"))
                        .getScaledInstance(160, 50, Image.SCALE_DEFAULT)
                    );
            labelimage.setBounds(80, 10, 400, 70); 
            labelimage.setIcon(img);
            meFrame.add(labelimage);

            labelEmail = new JLabel("Votre Email:");
            labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
            labelEmail.setBounds(80, 90, 200, 30);

            labelPassword = new JLabel("Votre Mot de passe:");
            labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
            labelPassword.setBounds(80, 130, 200, 30);

            textFieldId = new JTextField("" + utilisateur.getIdUtilisateur());
            textFieldId.setVisible(false);

            textFieldLogin = new JTextField(utilisateur.getMail());
            textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
            textFieldLogin.setBounds(300, 90, 200, 30);

            /* Mot de passe*/
            passwordField = new JPasswordField(utilisateur.getMotDePasse());
            passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
            passwordField.setBounds(300, 130, 200, 30);

            textFieldStatut = new JTextField("" + utilisateur.getStatut());
            textFieldStatut.setVisible(false);

            textFieldRole = new JTextField(utilisateur.getIdRole());
            textFieldRole.setVisible(false);

            btnModifier = new JButton("Modifier");
            btnModifier.setBounds(300, 170, 100, 30);
            btnModifier.setFont(new Font("Tahoma", Font.BOLD, 15));
            btnModifier.setBackground(new Color(1, 175, 228));
            btnModifier.setForeground(Color.WHITE);
            btnModifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent eventUpdateUser) 
                {
                    String userString[] = new String[5];
                    userString[0] = textFieldId.getText();
                    userString[1] = textFieldLogin.getText();
                    userString[2] = String.valueOf(passwordField.getPassword());
                    userString[3] = textFieldStatut.getText();
                    userString[4] = textFieldRole.getText();

                    utilisateurDao.update(utilisateur, userString);

                    meFrame.dispose();
                }
            });

            meFrame.add(labelEmail);meFrame.add(textFieldLogin);meFrame.add(labelPassword);meFrame.add(passwordField);meFrame.add(btnModifier);

            meFrame.setTitle("Aerosoft");

            meFrame.setSize(650, 350);
            meFrame.setLayout(null);
            meFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            meFrame.setVisible(true);
    	}
    });

    pilote = (Pilote) piloteDao.get(idUser);

        itemMePilote=new JMenuItem("Mes informations pilote");
        itemMePilote.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                new InfosPilote(pilote);
            }
        });

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
