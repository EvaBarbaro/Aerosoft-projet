package vues.home;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import dao.UtilisateurDao;
import models.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMaFiche extends JMenu{
    
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    private JMenuItem itemMe;

    private JMenu menuMaFiche;

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
            Utilisateur utilisateur;
            UtilisateurDao utilisateurDao = new UtilisateurDao();
            utilisateur = (Utilisateur) utilisateurDao.get(idUser);
            System.out.println(utilisateur.getMail());
            System.out.println(utilisateur.getMotDePasse());
    	}
    });

    menuMaFiche.add(itemMe);
    }     
}
