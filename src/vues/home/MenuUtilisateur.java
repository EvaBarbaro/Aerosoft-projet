package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


import models.Utilisateur;
import vues.utilisateur.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import vues.utilisateur.*;

public class MenuUtilisateur extends JMenu{
    
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    private JMenuItem itemReadUtilisateur, itemAddUtilisateur, itemListUtilisateur, itemDeleteUtilisateur, itemSearchUtilisateur;

    private JMenu menuUtilisateur;

    public JMenu getMenu() {
        return this.menuUtilisateur;
    }

    public MenuUtilisateur() {

        menuUtilisateur=new JMenu("Utilisateur"); 

    itemReadUtilisateur=new JMenuItem("Lister les utilisateurs");
    itemReadUtilisateur.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		
            new FicheReadUtilisateur();
    	}
    });

    itemAddUtilisateur=new JMenuItem("Ajouter un utilisateur");
    itemAddUtilisateur.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
			new FicheAjoutUtilisateur();
    	}
    });

    itemListUtilisateur=new JMenuItem("Modifier les utilisateurs");
    itemListUtilisateur.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
    		new FicheListUtilisateur();
    	}
    });

    itemDeleteUtilisateur=new JMenuItem("Supprimer un utilisateur");
    itemDeleteUtilisateur.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
            new FicheListDeleteUtilisateur();
    	}
    });

    itemSearchUtilisateur=new JMenuItem("Rechercher un utilisateur");
    itemSearchUtilisateur.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent evt)
    	{
            new FicheSearchUtilisateur();
    	}
    });

    menuUtilisateur.add(itemReadUtilisateur); menuUtilisateur.add(itemAddUtilisateur); menuUtilisateur.add(itemListUtilisateur); menuUtilisateur.add(itemDeleteUtilisateur); menuUtilisateur.add(itemSearchUtilisateur);
    }
  
}
