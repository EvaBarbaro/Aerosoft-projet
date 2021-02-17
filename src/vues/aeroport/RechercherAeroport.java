package vues.aeroport;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.*;
import java.awt.event.*;

import dao.*;
import models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RechercherAeroport extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JLabel l1, l2, l3;
	JTextField tf1, tf2;

	DefaultTableModel tableModel;
	JTable data;

	JButton btn1;
	Aeroport b1;
	AeroportDao dao = new AeroportDao();

	String[] tblHead = { "IdAeroport", "NomAeroport", "NomVilleDesservie" };

	public RechercherAeroport() {
		/* Label */
		l1 = new JLabel("RECHERCHER UN AEROPORT");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		l1.setBounds(100, 30, 400, 30);

		/* label 1*/  
		l2 = new JLabel("ID");
		l2.setBounds(100, 70, 200, 30);
		
		/* Texfield Recherche*/  
		tf1 = new JTextField();
		tf1.setBounds(149, 70, 200, 30);
		tf1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					rechercherAeroport();
				}
			}
		});

		/* Bouton */
		btn1 = new JButton("Rechercher");
		btn1.setBounds(361, 69, 176, 30);
		btn1.addActionListener(this);

		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(tf1);
		getContentPane().add(btn1);

		tableModel = new DefaultTableModel(tblHead, 0);

		data = new JTable(tableModel);

		//javax.swing.JTable.setInner(5); 

		data.setFont(new Font("Chandas", Font.BOLD, 15));
		data.setRowHeight(25);

		data.setBounds(100, 100, 400, 200);

		data.setDefaultEditor(Object.class, null);

		JScrollPane scrollPane = new JScrollPane(data);
		scrollPane.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));

		scrollPane.setSize(700, 200);
		scrollPane.setLocation(149, 143);
		getContentPane().add(scrollPane);

		setTitle("Rechercher un Livre");

		setSize(900, 540);
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
	
	public void chargeData(){
		Object[] donnees = { 
			b1.getIdAeroport(), 
			b1.getNomAeroport(), 
			b1.getNomVille() 
		};

		tableModel.setRowCount(0);
		tableModel.addRow(donnees);
		
		data.setModel(tableModel);
	}

	
	/** 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			rechercherAeroport(); 
		}
	}

	private void rechercherAeroport() {
		Object id = (Object) tf1.getText();
								
		b1 = (Aeroport) dao.get(id);

		if (b1 != null) {
			
			chargeData();	

			data.addMouseListener(new MouseAdapter() {
		
				public void mousePressed(MouseEvent mouseEvent) {
					
					JTable table =(JTable) mouseEvent.getSource();
					
					Point point = mouseEvent.getPoint();
					
					int row = table.rowAtPoint(point);
					
					if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
						
						int column = 0;
						
						//int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
						Object id = (Object) table.getModel().getValueAt(row, column).toString();
											
						b1 = (Aeroport) dao.get(id);
	
						if (b1 != null) {
							
							FicheModifAeroport fm = new FicheModifAeroport(b1);
							
							fm.addWindowListener(new WindowListener() {
	
								@Override
								public void windowOpened(WindowEvent e) {
									// TODO Auto-generated method stub								
								}
	
								@Override
								public void windowClosing(WindowEvent e) {
										
								}
	
								@Override
								public void windowClosed(WindowEvent e) {								
									chargeData();
								}
	
								@Override
								public void windowIconified(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
	
								@Override
								public void windowDeiconified(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
	
								@Override
								public void windowActivated(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
	
								@Override
								public void windowDeactivated(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
							});
	
						}				
						
					}
				}
			});

			repaint();

			tf1.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "Aeroport non Trouvé");
		}
	}

}
