package vues.home;

import javax.swing.*;

import dao.PiloteDao;
import models.Pilote;
import vues.Fiche;
import vues.FichePilote;

public class InfosPilote extends JFrame{

    private static final long serialVersionUID = 1L;

    PiloteDao piloteDao; 
     
    //Constructeur
    public InfosPilote(Pilote pilote) {
        piloteDao = new PiloteDao();
        
        String[] listLabels = { "Votre Nom:", 
                                "Votre Prenom:",
                                "Votre Matricule:"
                            };
		
        String[] listTextFields = { pilote.getNomPilote(),
                                    pilote.getPrenomPilote(),
                                    "" + pilote.getMatricule()
                                };
                
        String[] listTextBtns = { "Modifier","Annuler" };
        String[] listMethodeDoa = { "update", "" };
        
        
        new FichePilote(
				"Mes informations Pilote", 
				piloteDao, 
				(Object)pilote, 
				listLabels, 
				listTextFields,
				listTextBtns,
				listMethodeDoa
				);
        

        /*  labelimage.setBounds(80, 10, 400, 70); 
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
        
            @Override
            public void actionPerformed(ActionEvent eventUpdateUser) {
                String userPilotString[] = new String[5];
                userPilotString[0] = textFieldNom.getText();
                userPilotString[1] = textFieldPrenom.getText();
                userPilotString[2] = textFieldMatricule.getText();
        
                piloteDao.update(pilote, userPilotString);
        
                meFramePilote.dispose();
                
            }
        });
        
        meFramePilote.add(labelNom);meFramePilote.add(textFieldNom);meFramePilote.add(labelPrenom);meFramePilote.add(textFieldPrenom);meFramePilote.add(labelMatricule); meFramePilote.add(textFieldMatricule); meFramePilote.add(btnModifierPilote);
        
        meFramePilote.setTitle("Mes informations pilotes");
        
        meFramePilote.setSize(650, 350);
        
        JScrollPane scrollPane = new JScrollPane(meFramePilote);        
        getContentPane().add(scrollPane);
        
        setFont(new Font("Dialog", Font.PLAIN, 15));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 200);
        
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        setLocation(x, y);
        setLocationRelativeTo(null);
        setVisible(true);*/
    }
    
}
