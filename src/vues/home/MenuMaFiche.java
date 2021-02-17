package vues.home;

import dao.PiloteDao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import models.Pilote;
import vues.Login;

public class MenuMaFiche extends JMenu {
  private static final long serialVersionUID = 1L;

  private JMenuItem itemMe, itemMePilote, itemLogOut;

  private JMenu menuMaFiche;

  PiloteDao piloteDao = new PiloteDao();

  Pilote pilote;

  public JMenu getMenu() {
    return this.menuMaFiche;
  }

  public MenuMaFiche(int idUser, JFrame frame) {
      
    menuMaFiche = new JMenu("Ma Fiche");
    Font font = new Font("Serial", Font.BOLD, 16);
    menuMaFiche.setFont(font);

    itemMe = new JMenuItem("Mon Compte");
    itemMe.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
          new Login();
        }
            });

    pilote = (Pilote) piloteDao.get(idUser);

    itemMePilote = new JMenuItem("Mes informations pilote");
    itemMePilote.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
          new InfosPilote(pilote);
        }
            });

    itemLogOut = new JMenuItem("Déconnexion");
    itemLogOut.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
          frame.dispose();
          new Login();
        }
            });

    menuMaFiche.add(itemMe);
    if (pilote != null) {
      menuMaFiche.add(itemMePilote);
    }
    menuMaFiche.add(itemLogOut);
  }
}
