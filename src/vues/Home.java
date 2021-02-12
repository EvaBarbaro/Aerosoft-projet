package vues;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.Image;

import dao.*;
import models.*;
import vues.aeroport.FicheAjoutAeroport;

import javax.swing.*;


public class Home {

    public Home() {
		initialize();
	}
	
    public void initialize(){
        
	/*Fenetre principal*/
	JFrame frame = new JFrame("Tableau de bord");
	/*Jpanel*/
    JPanel panel = new JPanel();  
    panel.setLayout(new FlowLayout());  
    /* Mise en place du menu  */
    JMenu menu,menu1,menu2; 
    //submenu;  
    JMenuItem i1, i2, i3, i4, i5;
    JMenuBar mb=new JMenuBar();  
    /* Menu 1*/
    menu=new JMenu("Accueil"); 
    
    mb.add(menu);  
    /*Menu 2*/
    menu1=new JMenu("Aeroport"); 
    i1=new JMenuItem("Ajouter un aeroport");
    i1.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);
  
            AeroportDao aeDao = new AeroportDao();
            String idAe = "CDG"; 
			Aeroport ae = (Aeroport) aeDao.get(idAe);
			new FicheAjoutAeroport(ae);
    	}
    });
    i2=new JMenuItem("Lister les aeroport");
    i2.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);    		
    	}
    });

    i3=new JMenuItem("Trouver un aeroport");
    i3.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		frame.setVisible(true);
    		//new searchLivre();
           
    	}
    });
    menu1.add(i1); menu1.add(i2); menu1.add(i3);mb.add(menu1); 
    
    /*Menu 2*/
    menu2=new JMenu("Pilote"); 
    mb.add(menu2);


    frame.setJMenuBar(mb);
    /*Ajout d'une image*/
    ImageIcon icon = new ImageIcon(
            Toolkit.getDefaultToolkit().getImage(
                    Fiche.class.getResource("/images/Banniere_aerosoft.jpg"))
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


