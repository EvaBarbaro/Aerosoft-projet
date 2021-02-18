package vues.affectation;

import dao.AffectationDao;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.Affectation;

public class ListeAffectations extends JFrame implements ActionListener {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  JLabel l1;

  DefaultTableModel tableModel;
  JTable data;

  Affectation b1;
  AffectationDao dao = new AffectationDao();

  List<Affectation> list = new ArrayList<Affectation>();

  String[] tblHead = {
    "IdAffectation",
    "NumVol",
    "DateVol",
    "AffectationCode",
    "NumAvion",
    "IdPilote",
  };

  public ListeAffectations() {
    /* Label */
    l1 = new JLabel("LISTE DES AFFECTATIONS");
    l1.setForeground(Color.blue);
    l1.setFont(new Font("Serif", Font.BOLD, 20));

    /* Placement */
    l1.setBounds(100, 30, 400, 30);

    getContentPane().add(l1);

    tableModel = new DefaultTableModel(tblHead, 0);

    data = new JTable(tableModel);
    data.setEnabled(false);
    data.setFont(new Font("Chandas", Font.BOLD, 15));
    data.setRowHeight(25);
    data.setBounds(100, 100, 450, 450);

    chargeData(dao);

    JScrollPane scrollPane = new JScrollPane(data);
    scrollPane.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

    scrollPane.setSize(900, 300);
    scrollPane.setLocation(50, 100);
    getContentPane().add(scrollPane);

    setTitle("LISTE DES AFFECTATIONS");

    setSize(1000, 540);
    getContentPane().setLayout(null);

    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Dimension screenSize = toolkit.getScreenSize();
    final int x = (screenSize.width - this.getWidth()) / 2;
	  final int y = (screenSize.height - this.getHeight()) / 2;
	
    setLocation(x, y);
    setLocationRelativeTo(null);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }

  /**
   * @param dao
   */
  public void chargeData(AffectationDao dao) {

    list = (List<Affectation>) dao.getAll();

    ListIterator<Affectation> listIterator =
      ((java.util.List<Affectation>) list).listIterator();

    tableModel.setRowCount(0);

    if (list != null) {

      while (listIterator.hasNext()) {

        b1 = listIterator.next();

        Object[] donnees = {
            b1.getId(),
            b1.getNumVol(),
            b1.getDateVol(),
            b1.getAffectationCode(),
            b1.getNumAvion(), 
            b1.getPilote().getNomPilote()
          };

        tableModel.addRow(donnees);
      }
      
      tableModel.fireTableDataChanged();

      data.setModel(tableModel);
      data.repaint();
      
    }
  }

  /**
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }
}
