package vues.utilisateur;

import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.util.*;

import vues.Fiche;

import models.*;
import dao.*;

public class FicheAjoutUtilisateur extends JFrame implements ActionListener, KeyListener{

    private static final long serialVersionUID = 1618223497137316296L;
    JLabel labelTitle, labelEmail, labelPassword;
    JTextField textFieldLogin, roleField;
    JButton btnInscription;
    JPasswordField passwordField;

    public FicheAjoutUtilisateur() {

    JLabel labelimage = new JLabel();
        ImageIcon img = new ImageIcon(
            Toolkit.getDefaultToolkit().getImage(
                    Fiche.class.getResource("/images/Aerosoft-logo.PNG"))
                    .getScaledInstance(160, 50, Image.SCALE_DEFAULT)
                );
        labelimage.setBounds(80, 10, 400, 70); 
        labelimage.setIcon(img);
        add(labelimage);

    labelEmail = new JLabel("Votre Email:");
    labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelPassword = new JLabel("Votre Mot de passe:");
    labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
    textFieldLogin = new JTextField("");
    textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
    /* Mot de passe*/
    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    /*Bouton */
    btnInscription = new JButton("Inscrivez-vous");
    /*Placement */
    // labelTitle.setBounds(80, 10, 400, 30);
    labelEmail.setBounds(80, 90, 200, 30);
    labelPassword.setBounds(80, 130, 200, 30);     

    textFieldLogin.setBounds(300, 90, 200, 30);

    passwordField.setBounds(300, 130, 200, 30);
    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnInscription.setBounds(300, 170, 150, 30);
    btnInscription.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnInscription.setBackground(new Color(22, 219, 170));
    btnInscription.setForeground(Color.WHITE);
    btnInscription.addActionListener(this);
    // add(labelTitle);
    add(labelEmail);add(textFieldLogin); add(labelPassword);add(passwordField);add(btnInscription);

    setTitle("Aerosoft");

    setSize(650, 350);
    setLayout(null);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setVisible(true);
    }

    public void register() {
        RoleDao roleDao = new RoleDao();
        ArrayList<Role> roles = roleDao.getAll();
        String roleTab[] = new String[roles.size()+1];
        roleTab[0] = "Selectionner votre rôle";
        int i = 1;

        for (Role role : roles) {
            roleTab[i] = role.getRoleNom();
            i++;
        }

        JComboBox<String> comboBoxRole = new JComboBox<String>(roleTab);
        comboBoxRole.setBounds(310, 170, 180, 20);

        JButton btnValidateReg;

        btnValidateReg = new JButton("Valider votre inscription");
        btnValidateReg.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnValidateReg.setBackground(new Color(22, 219, 170));
        btnValidateReg.setBounds(290, 200, 220, 30);
        btnValidateReg.setForeground(Color.WHITE);

        btnInscription.setVisible(false);

        add(comboBoxRole);
        add(btnValidateReg);

        this.invalidate();
        this.validate();
        this.repaint();

        comboBoxRole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventComboBox) {
                String stringBox = (String) comboBoxRole.getSelectedItem();

                Role roleAtt = (Role) roleDao.get(stringBox);

                switch (stringBox) {
                    case "Chargé Clientèle":
                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);
                        revalidate();
                        repaint();
                        break;
                    case "Pilote":
                        JFrame framePilote = new JFrame("Informations pilote");
                        JLabel nomPiloteLabel, prenomPiloteLabel, matriculeLabel;
                        JTextField nomPiloteField, prenomPiloteField, matriculeField;
                        JButton btnValidatePilote;
                        UtilisateurDao utilisateurDao = new UtilisateurDao();

                        roleDao.get(stringBox);

                        JLabel labelimage = new JLabel();
                        ImageIcon img = new ImageIcon(
                            Toolkit.getDefaultToolkit().getImage(
                                    Fiche.class.getResource("/images/Aerosoft-logo.PNG"))
                                    .getScaledInstance(160, 50, Image.SCALE_DEFAULT)
                                );
                        labelimage.setBounds(80, 10, 400, 70); 
                        labelimage.setIcon(img);
                        framePilote.add(labelimage);

                        nomPiloteLabel = new JLabel("Votre nom");
                        nomPiloteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

                        nomPiloteField = new JTextField("");
                        nomPiloteField.setFont(new Font("Tahoma", Font.PLAIN, 15));

                        prenomPiloteLabel = new JLabel("Votre prénom");
                        prenomPiloteField = new JTextField("");

                        matriculeLabel = new JLabel("Votre matricule");
                        matriculeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        matriculeField = new JTextField("");
                        matriculeField.setFont(new Font("Tahoma", Font.PLAIN, 15));

                        btnValidatePilote = new JButton("Valider votre inscription");
                        btnValidatePilote.setFont(new Font("Tahoma", Font.BOLD, 15));
                        btnValidatePilote.setBackground(new Color(22, 219, 170));
                        btnValidatePilote.setBounds(290, 230, 220, 30);
                        btnValidatePilote.setForeground(Color.WHITE);

                        nomPiloteLabel.setBounds(80, 100, 200, 30);
                        nomPiloteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        nomPiloteField.setBounds(300, 100, 200, 30);
                        nomPiloteField.setFont(new Font("Tahoma", Font.PLAIN, 15));

                        prenomPiloteLabel.setBounds(80, 140, 200, 30);
                        prenomPiloteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        prenomPiloteField.setBounds(300, 140, 200, 30);
                        prenomPiloteField.setFont(new Font("Tahoma", Font.PLAIN, 15));

                        matriculeLabel.setBounds(80, 180, 200, 30);
                        matriculeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        matriculeField.setBounds(300, 180, 200, 30);
                        matriculeField.setFont(new Font("Tahoma", Font.PLAIN, 15));

                        ArrayList<Utilisateur> userAll = utilisateurDao.getAll();

                        Boolean duplicate[] = new Boolean[userAll.size()];
        
                        int i = 0;
                
                        for (Utilisateur user : userAll) {
                            if (user.getMail().equals(textFieldLogin.getText())) {
                                duplicate[i] = true;
                            }
                            else {
                                duplicate[i] = false;
                            }
                            i++;
                        }
        
                        if (Arrays.asList(duplicate).contains(true)) {
                            JLabel labelError = new JLabel("Cette adresse mail existe déjà.");
                            labelError.setBounds(300, 230, 250, 30);
                            labelError.setFont(new Font("Tahoma", Font.PLAIN, 15));
                            labelError.setForeground(Color.RED);
                            add(labelError);
                            revalidate();
                            repaint();
                        } else {
                            btnInscription.setVisible(false);
    
                            framePilote.add(nomPiloteLabel);
                            framePilote.add(nomPiloteField);
                            framePilote.add(prenomPiloteLabel);
                            framePilote.add(prenomPiloteField);
                            framePilote.add(matriculeLabel);
                            framePilote.add(matriculeField);
                            framePilote.add(btnValidatePilote);
    
                            framePilote.setTitle("Aerosoft");
                            framePilote.setSize(650, 350);
                            framePilote.setLayout(null);
                            framePilote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            framePilote.setVisible(true);
                        }

                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);

                        btnValidatePilote.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent eventValidatePilote) {
                                UtilisateurDao utilisateurDao = new UtilisateurDao();
                                Utilisateur utilisateur = new Utilisateur();
                                int uniqueID = UUID.randomUUID().hashCode();

                                String userString[] = new String[5];
                                userString[0] = String.valueOf(uniqueID);
                                userString[1] = textFieldLogin.getText();
                                userString[2] = String.valueOf(passwordField.getPassword());
                                userString[3] = "false";
                                userString[4] = roleField.getText();

                                utilisateurDao.save(utilisateur, userString);

                                PiloteDao piloteDao = new PiloteDao();
                                Pilote pilote = new Pilote();
                                String piloteString[] = new String[4];
                                piloteString[0] = String.valueOf(uniqueID);
                                piloteString[1] = nomPiloteField.getText();
                                piloteString[2] = prenomPiloteField.getText();
                                piloteString[3] = matriculeField.getText();

                                piloteDao.save(pilote, piloteString);

                                framePilote.setVisible(false);

                                dispose();
                            }
                        });
                        revalidate();
                        repaint();
                        break;
                    case "Technicien d'exploitation":
                        roleDao.get(stringBox);
                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);
                        break;
                    case "Administrateur":
                        UtilisateurDao utilisateurDaoAdmin = new UtilisateurDao();
                        ArrayList<Utilisateur> userAdmin = utilisateurDaoAdmin.getAll();
        
                        int adminCount = 0;
                
                        for (Utilisateur users : userAdmin) {
                            System.out.println(users.getIdRole());
                            if (users.getIdRole().equals("55555")){
                                adminCount++;
                            }
                        }
        
                        if (adminCount == 2) {
                            JLabel labelErrorAdmin = new JLabel("Le nombre maximal de compte admin a été atteint.");
                            labelErrorAdmin.setBounds(270, 230, 340, 30);
                            labelErrorAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
                            labelErrorAdmin.setForeground(Color.RED);
                            add(labelErrorAdmin);
                            revalidate();
                            repaint();
                        } else {
                            roleDao.get(stringBox);
                            roleField = new JTextField(roleAtt.getIdRole());
                            roleField.setVisible(false);
                            add(roleField);
                        }
                        break;
                }
            }
        });

        btnValidateReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventValidateReg) {

                testUtilisateur();
            }
        });
    }
    
    private void testUtilisateur() {
                UtilisateurDao utilisateurDao = new UtilisateurDao();
                Utilisateur utilisateur = new Utilisateur();
                int uniqueID = UUID.randomUUID().hashCode();

                String userPiloteString[] = new String[5];
                userPiloteString[0] = String.valueOf(uniqueID);
                userPiloteString[1] = textFieldLogin.getText();
                userPiloteString[2] = String.valueOf(passwordField.getPassword());
                userPiloteString[3] = "false";
                userPiloteString[4] = roleField.getText();

                ArrayList<Utilisateur> userAll = utilisateurDao.getAll();

                Boolean duplicate[] = new Boolean[userAll.size()];

                int i = 0;
        
                for (Utilisateur user : userAll) {
                    if (user.getMail().equals(userPiloteString[1])) {
                        duplicate[i] = true;
                    }
                    else {
                        duplicate[i] = false;
                    }
                    i++;
                }

                if (Arrays.asList(duplicate).contains(true)) {
                    JLabel labelError = new JLabel("Cette adresse mail existe déjà.");
                    labelError.setBounds(300, 230, 250, 30);
                    labelError.setFont(new Font("Tahoma", Font.PLAIN, 15));
                    labelError.setForeground(Color.RED);
                    add(labelError);
                    revalidate();
                    repaint();
                } else {
                    utilisateurDao.save(utilisateur, userPiloteString);

                    dispose();
                }

    }

    public void actionPerformed(ActionEvent btnEvent) {

        if (btnEvent.getSource() == btnInscription) {
            register();
        }
    }
    
    public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			testUtilisateur();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}