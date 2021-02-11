package vues;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 
public class Login extends JFrame implements ActionListener {

JLabel labelTitle, labelEmail, labelPassword;
JTextField textFieldLogin;
JButton btnValider,btnInscription;
JPasswordField passwordField;

public Login() {
	
	
/*Label */
labelTitle = new JLabel("AUTHENTIFIEZ-VOUS");
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
labelTitle.setBounds(100, 30, 400, 30);
labelEmail.setBounds(80, 70, 200, 30);
labelPassword.setBounds(80, 110, 200, 30);
textFieldLogin.setBounds(300, 70, 200, 30);
passwordField.setBounds(300, 110, 200, 30);
btnValider.setBounds(300, 150, 100, 30);
btnInscription.setBounds(410, 150, 100, 30);
btnValider.addActionListener(this);
btnInscription.addActionListener(this);
add(labelTitle);add(labelEmail);add(textFieldLogin); add(labelPassword);add(passwordField);add(btnValider);add(btnInscription);

setTitle("Authentification ");

setSize(650, 350);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public void actionPerformed(ActionEvent btnEvent) {
  
    if(btnEvent.getSource()==btnValider){  
    	  getLogged();
    }
    
    if(btnEvent.getSource()==btnInscription){ 

  }
}
	

public void getLogged() {


String loginString = textFieldLogin.getText();
char[] pass = passwordField.getPassword();
String passwordString = new String(pass);

        try {

        	Class.forName("com.mysql.jdbc.Driver");

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/aerosoft","root",""); 
            
        	PreparedStatement ps = con.prepareStatement("select IdUtilisateur from utilisateur where Mail=? and MotDePasse=?");
            ps.setString(1, loginString);
            ps.setString(2, passwordString);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	this.setVisible(false);
                System.out.println("Bienvenue");
            } 
            else {
            	JOptionPane.showMessageDialog(null,"Email ou Mot de passe incorrect, Veuillez réessayer");
            }

        }

        catch (Exception ex) {

            System.out.println(ex);
        }

    }

}
