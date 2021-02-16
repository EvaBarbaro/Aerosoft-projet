package vues.home;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMaFiche extends JMenu{
    
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    private JMenuItem itemMe, itemMePilote;

    private JMenu menuMaFiche;

    PiloteDao piloteDao = new PiloteDao();

    Pilote pilote;

    public JMenu getMenu() {
        return this.menuMaFiche;
    }

    public MenuMaFiche(int idUser) {

    menuMaFiche=new JMenu("Ma Fiche"); 

    itemMe=new JMenuItem("Mon Compte");
    itemMe.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
            JFrame meFrame = new JFrame();
            JLabel labelEmail, labelPassword;
            JTextField textFieldId, textFieldLogin, textFieldStatut, textFieldRole;
            JButton btnModifier;
            JPasswordField passwordField;

            Utilisateur utilisateur;
            UtilisateurDao utilisateurDao = new UtilisateurDao();
            utilisateur = (Utilisateur) utilisateurDao.get(idUser);

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

        itemMePilote=new JMenuItem("Mes informations pilotes");
        itemMePilote.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                JFrame meFramePilote = new JFrame();
                JLabel labelNom, labelPrenom, labelMatricule;
                JTextField textFieldId, textFieldNom, textFieldPrenom, textFieldMatricule;
                JButton btnModifierPilote;
    
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

    menuMaFiche.add(itemMe);
    
        if (pilote != null) {
            menuMaFiche.add(itemMePilote);   
        }
    }     
}
