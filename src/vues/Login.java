package vues;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import models.*;
import dao.*;
 
public class Login extends JFrame implements ActionListener {

private static final long serialVersionUID = 1618223497137316296L;
JLabel labelTitle, labelEmail, labelPassword;
JTextField textFieldLogin, roleField;
JButton btnValider, btnInscription;
JPasswordField passwordField;

public Login() {
	
	
/*Label */
labelTitle = new JLabel("Authentification");
labelTitle.setForeground(Color.blue);
labelTitle.setFont(new Font("Serif", Font.BOLD, 20));

labelEmail = new JLabel("Votre Email:");
labelPassword = new JLabel("Votre Mot de passe:");
textFieldLogin = new JTextField();
/* Mot de passe*/
passwordField = new JPasswordField();
/*Bouton */
btnValider = new JButton("Valider");
btnInscription = new JButton("Inscrivez-vous");
/*Placement */
labelTitle.setBounds(80, 10, 400, 30);
labelEmail.setBounds(80, 70, 200, 30);
labelPassword.setBounds(80, 110, 200, 30);
textFieldLogin.setBounds(300, 70, 200, 30);
passwordField.setBounds(300, 110, 200, 30);
btnValider.setBounds(270, 150, 100, 30);
btnInscription.setBounds(380, 150, 140, 30);
btnValider.addActionListener(this);
btnInscription.addActionListener(this);
add(labelTitle);add(labelEmail);add(textFieldLogin); add(labelPassword);add(passwordField);add(btnValider);add(btnInscription);

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

        	Class.forName("com.mysql.jdbc.Driver");

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/aerosoft","root",""); 
            
        	PreparedStatement ps = con.prepareStatement("select IdUtilisateur from utilisateur where Mail=? and MotDePasse=? and Statut=false");
            ps.setString(1, loginString);
            ps.setString(2, passwordString);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	this.setVisible(false);
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
        String roleTab[] = new String[roles.size()];
        int i = 0;

        for (Role role : roles) {
            roleTab[i] = role.getRoleNom();
            i++;
		}

        JComboBox<String> comboBoxRole = new JComboBox<String>(roleTab);
        comboBoxRole.setBounds(310, 150, 180, 20);

        JButton btnValidateReg;

        btnValidateReg = new JButton("Valider votre inscirption");
        btnValidateReg.setBounds(305, 180, 190, 30);

        btnValider.setVisible(false);
        btnInscription.setVisible(false);

        add(comboBoxRole);add(btnValidateReg);

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
                        invalidate();
                        validate();
                        repaint();
                        break;
                    case "Pilote":
                        JLabel nomPiloteLabel, prenomPiloteLabel, matriculeLabel;
                        JTextField nomPiloteField, prenomPiloteField, matriculeField;
                        JButton btnValidatePilote;

                        roleDao.get(stringBox);

                        nomPiloteLabel = new JLabel("Votre nom");
                        nomPiloteField = new JTextField("");
                        prenomPiloteLabel = new JLabel("Votre prénom");
                        prenomPiloteField= new JTextField("");
                        matriculeLabel = new JLabel("Votre matricule");
                        matriculeField = new JTextField("");

                        btnValidatePilote = new JButton("Valider votre inscirption");
                        btnValidatePilote.setBounds(305, 270, 190, 30);

                        nomPiloteLabel.setBounds(80, 180, 200, 30);
                        nomPiloteField.setBounds(300, 180, 200, 30);
                        prenomPiloteLabel.setBounds(80, 210, 200, 30);
                        prenomPiloteField.setBounds(300, 210, 200, 30);
                        matriculeLabel.setBounds(80, 240, 200, 30);
                        matriculeField.setBounds(300, 240, 200, 30);
                        btnValider.setVisible(false);
                        btnInscription.setVisible(false);
                        btnValidateReg.setVisible(false);

                        add(nomPiloteLabel); add(nomPiloteField); add(prenomPiloteLabel); add(prenomPiloteField); add(matriculeLabel); add(matriculeField);add(btnValidatePilote);
                        invalidate();
                        validate();
                        repaint();

                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);
                        
                        btnValidatePilote.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent eventValidatePilote) {
                                UtilisateurDao utilisateurDao = new UtilisateurDao();
                                Utilisateur utilisateur = new Utilisateur();
                                int uniqueID = UUID.randomUUID().hashCode();

                                utilisateur.setIdUtilisateur(uniqueID);
                                utilisateur.setMail(textFieldLogin.getText());
                                utilisateur.setMotDePasse(passwordField.getText().toString());
                                utilisateur.setStatut(false);
                                utilisateur.setIdRole(roleField.getText());

                                utilisateurDao.save(utilisateur);

                                PiloteDao piloteDao = new PiloteDao();
                                Pilote pilote = new Pilote();

                                pilote.setIdPilote(uniqueID);
                                pilote.setNomPilote(nomPiloteField.getText());
                                pilote.setPrenomPilote(prenomPiloteField.getText());
                                pilote.setMatricule(matriculeField.getText());

                                piloteDao.save(pilote);
                            }
                        });
                        break;
                    case "Technicien d'exploitation":
                        roleDao.get(stringBox);
                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);
                        invalidate();
                        validate();
                        repaint();
                        break;
                    case "Administrateur":
                        roleDao.get(stringBox);
                        roleField = new JTextField(roleAtt.getIdRole());
                        roleField.setVisible(false);
                        add(roleField);
                        invalidate();
                        validate();
                        repaint();
                        break;
                }
            }
        });

        btnValidateReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventValidateReg) {
                UtilisateurDao utilisateurDao = new UtilisateurDao();
                Utilisateur utilisateur = new Utilisateur();
                int uniqueID = UUID.randomUUID().hashCode();

                utilisateur.setIdUtilisateur(uniqueID);
                utilisateur.setMail(textFieldLogin.getText());
                utilisateur.setMotDePasse(passwordField.getText().toString());
                utilisateur.setStatut(false);
                utilisateur.setIdRole(roleField.getText());

                utilisateurDao.save(utilisateur);
            }
        });
    }

    public void actionPerformed(ActionEvent btnEvent) {
  
        if(btnEvent.getSource()==btnValider){  
            getLogged();
        }
        
        if(btnEvent.getSource()==btnInscription){ 
            register();
      }
    }

}
