package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


import models.Pilote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.pilote.*;

public class MenuPilote extends JMenu{
    
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    private JMenuItem itemReadPilote, itemAddPilote, itemListPilote, itemDeletePilote;

    private JMenu menuPilote;

    public JMenu getMenu() {
        return this.menuPilote;
    }

    public MenuPilote() {

        menuPilote=new JMenu("Pilote"); 

    itemReadPilote=new JMenuItem("Trouver un pilote");
    itemReadPilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		
            new FicheReadPilote();
    	}
    });

    itemAddPilote=new JMenuItem("Ajouter un pilote");
    itemAddPilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		  
			Pilote pilote = new Pilote();
			new FicheAjoutPilote(pilote);
    	}
    });

    itemListPilote=new JMenuItem("Modifier les pilotes");
    itemListPilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		new FicheListPilote();
    	}
    });

    itemDeletePilote=new JMenuItem("Supprimer un pilote");
    itemDeletePilote.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		
			new FicheListDeletePilot();
    	}
    });

    menuPilote.add(itemReadPilote); menuPilote.add(itemAddPilote); menuPilote.add(itemListPilote); menuPilote.add(itemDeletePilote);
    }     
}
