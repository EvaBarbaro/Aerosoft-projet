package vues;

import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import connexion.ConnectionBdd;

import models.*;
import dao.*;

public class Login extends JFrame implements ActionListener, KeyListener{

    private static final long serialVersionUID = 1618223497137316296L;
    JLabel labelTitle, labelEmail, labelPassword;
    JTextField textFieldLogin, roleField;
    JButton btnValider, btnInscription;
    JPasswordField passwordField;

    public Login() {

        String url = "./Conception/Aerosoft-logo.PNG";
        BufferedImage img;
        try {
            img = ImageIO.read(new File(url));
            ImageIcon icon = new ImageIcon(img);
            JLabel labelimage = new JLabel();
            labelimage.setBounds(80, 10, 400, 70); 
            labelimage.setIcon(icon);
            add(labelimage);
        } catch (IOException e) {
            e.printStackTrace();
    }


    labelEmail = new JLabel("Votre Email:");
    labelPassword = new JLabel("Votre Mot de passe:");
    textFieldLogin = new JTextField();
    /* Mot de passe*/
    passwordField = new JPasswordField();
    /*Bouton */
    btnValider = new JButton("Valider");
    btnInscription = new JButton("Inscrivez-vous");
    /*Placement */
    // labelTitle.setBounds(80, 10, 400, 30);
    labelEmail.setBounds(80, 90, 200, 30);
    labelPassword.setBounds(80, 130, 200, 30);    

    textFieldLogin.setBounds(300, 90, 200, 30);

    //a retirer apres
    textFieldLogin.setText("clientele@aerosoft.com");

    passwordField.setBounds(300, 130, 200, 30);
    btnValider.setBounds(270, 170, 100, 30);
    btnInscription.setBounds(380, 170, 140, 30);
    btnValider.addActionListener(this);
    btnInscription.addActionListener(this);
    // add(labelTitle);
    add(labelEmail);add(textFieldLogin); add(labelPassword);add(passwordField);add(btnValider);add(btnInscription);

    setTitle("Aerosoft");

    setSize(650, 350);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }

public void getLogged() {

String loginString = textFieldLogin.getText();
char[] pass = passwordField.getPassword();
String passwordString = new String(pass);



        try {

        	/*Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/aerosoft","root",""); */

            String sql = "select IdUtilisateur from `UTILISATEUR` where Mail=? and MotDePasse=? and Statut=true";

            Connection conn = ConnectionBdd.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
            
        	
            ps.setString(1, loginString);
            ps.setString(2, passwordString);
            System.out.println("sql : " + ps);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.setVisible(false);
                new Home();
            } 
            else {
            	JOptionPane.showMessageDialog(null,"Email ou Mot de passe incorrect, Veuillez réessayer");
            }

        }

        catch (Exception ex) {

            System.out.println(ex);
        }

    }

    public void register() {
        RoleDao roleDao = new RoleDao();
        ArrayList<Role> roles = roleDao.getAll();
        String roleTab[] = new String[5];
        roleTab[0] = "Selectionner votre rôle";
        int i = 1;

        for (Role role : roles) {
            roleTab[i] = role.getRoleNom();
            i++;
        }

        JComboBox<String> comboBoxRole = new JComboBox<String>(roleTab);
        comboBoxRole.setBounds(310, 170, 180, 20);

        JButton btnValidateReg;

        btnValidateReg = new JButton("Valider votre inscirption");
        btnValidateReg.setBounds(305, 200, 190, 30);

        btnValider.setVisible(false);
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

                        roleDao.get(stringBox);

                        String url = "./Conception/Aerosoft-logo.PNG";
                        BufferedImage img;
                        try {
                            img = ImageIO.read(new File(url));
                            ImageIcon icon = new ImageIcon(img);
                            JLabel labelimage = new JLabel();
                            labelimage.setBounds(80, 10, 400, 70);
                            labelimage.setIcon(icon);
                            framePilote.add(labelimage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        nomPiloteLabel = new JLabel("Votre nom");
                        nomPiloteField = new JTextField("");
                        prenomPiloteLabel = new JLabel("Votre prénom");
                        prenomPiloteField = new JTextField("");
                        matriculeLabel = new JLabel("Votre matricule");
                        matriculeField = new JTextField("");

                        btnValidatePilote = new JButton("Valider votre inscirption");
                        btnValidatePilote.setBounds(305, 230, 190, 30);

                        nomPiloteLabel.setBounds(80, 100, 200, 30);
                        nomPiloteField.setBounds(300, 100, 200, 30);
                        prenomPiloteLabel.setBounds(80, 140, 200, 30);
                        prenomPiloteField.setBounds(300, 140, 200, 30);
                        matriculeLabel.setBounds(80, 180, 200, 30);
                        matriculeField.setBounds(300, 180, 200, 30);
                        btnValider.setVisible(false);
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

                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);

                        btnValidatePilote.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent eventValidatePilote) {
                                UtilisateurDao utilisateurDao = new UtilisateurDao();
                                Utilisateur utilisateur = new Utilisateur();
                                String superUseless[] = null;
                                int uniqueID = UUID.randomUUID().hashCode();

                                utilisateur.setIdUtilisateur(uniqueID);
                                utilisateur.setMail(textFieldLogin.getText());
                                utilisateur.setMotDePasse(String.valueOf(passwordField.getPassword()));
                                utilisateur.setStatut(false);
                                utilisateur.setIdRole(roleField.getText());

                                utilisateurDao.save(utilisateur, superUseless);

                                PiloteDao piloteDao = new PiloteDao();
                                Pilote pilote = new Pilote();
                                String useless[] = null;

                                pilote.setIdPilote(uniqueID);
                                pilote.setNomPilote(nomPiloteField.getText());
                                pilote.setPrenomPilote(prenomPiloteField.getText());
                                pilote.setMatricule(matriculeField.getText());

                                piloteDao.save(pilote, useless);

                                dispose();

                                new Login();
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
                        roleDao.get(stringBox);
                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);
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
                String[] megaUseless = null;

                utilisateur.setIdUtilisateur(uniqueID);
                utilisateur.setMail(textFieldLogin.getText());
                utilisateur.setMotDePasse(String.valueOf(passwordField.getPassword()));
                utilisateur.setStatut(false);
                utilisateur.setIdRole(roleField.getText());

                utilisateurDao.save(utilisateur, megaUseless);

                dispose();

                new Login();
    }

    public void actionPerformed(ActionEvent btnEvent) {

        if (btnEvent.getSource() == btnValider) {
            getLogged();
        }

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
