package vues.avion;

import dao.AvionDao;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.Avion;

public class ListeSupprAvion extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;

  JLabel l1;

  DefaultTableModel tableModel;
  JTable data;

  Avion av1;
  AvionDao dao = new AvionDao();

  List<Avion> list = new ArrayList<Avion>();

  String[] tblHead = {"Numéro avion", "Type avion", "Base aeroport"};

  public ListeSupprAvion() {

    /* Label */
    l1 = new JLabel("LISTE DES Avions");
    l1.setForeground(Color.blue);
    l1.setFont(new Font("Serif", Font.BOLD, 20));
    l1.setBounds(100, 30, 400, 30);

    getContentPane().add(l1);

    tableModel = new DefaultTableModel(tblHead, 0);

    data = new JTable(tableModel);
    data.setFont(new Font("Chandas", Font.BOLD, 15));
    data.setRowHeight(25);
    data.setBounds(100, 100, 450, 450);

    chargeData(dao);

    data.setDefaultEditor(Object.class, null);

    data.addMouseListener(new MouseAdapter() {

      public void mousePressed(MouseEvent mouseEvent) {

        JTable table = (JTable) mouseEvent.getSource();

        Point point = mouseEvent.getPoint();

        int row = table.rowAtPoint(point);

        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

          int column = 0;

          Object id = (Object) table.getModel().getValueAt(row, column).toString();

          av1 = (Avion) dao.get(id);

          if (av1 != null) {

            FicheModifAvion fm = new FicheModifAvion(av1);

            fm.addWindowListener(new WindowListener() {

              @Override
              public void windowOpened(WindowEvent e) {                
              }

              @Override
              public void windowClosing(WindowEvent e) {
              }

              @Override
              public void windowClosed(WindowEvent e) {
                chargeData(dao);
              }

              @Override
              public void windowIconified(WindowEvent e) {             

              }

              @Override
              public void windowDeiconified(WindowEvent e) {                

              }

              @Override
              public void windowActivated(WindowEvent e) {                

              }

              @Override
              public void windowDeactivated(WindowEvent e) {                

              }
            });
          }
        }
      }
    });

    JScrollPane scrollPane = new JScrollPane(data);
    scrollPane.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

    scrollPane.setSize(550, 300);
    scrollPane.setLocation(50, 100);
    getContentPane().add(scrollPane);

    setTitle("LISTE DES Avions");

    setSize(639, 540);
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
  public void chargeData(AvionDao dao) {

    list = (List<Avion>) dao.getAll();

    ListIterator<Avion> listIterator = ((java.util.List<Avion>) list).listIterator();

    tableModel.setRowCount(0);

    if (list != null) {

      while (listIterator.hasNext()) {

        av1 = listIterator.next();

        Object[] donnees = {av1.getNumAvion(), av1.getTypeAvion(), av1.getBaseAeroport(),};

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

  }
}
