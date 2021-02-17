package vues.aeroport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.AeroportDao;
import models.Aeroport;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

 
public class ListeModifAeroports extends JFrame implements ActionListener{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JLabel l1;
	
	DefaultTableModel tableModel;
	JTable data;
	
	Aeroport b1;
	AeroportDao dao = new AeroportDao();
	
	List<Aeroport> list = new ArrayList<Aeroport>();
	 
	String[] tblHead = { "IdAeroport", "NomAeroport", "NomVilleDesservie" };
	 

	public ListeModifAeroports() {
		
		/* Label */
		l1 = new JLabel("LISTE DES AEROPORTS");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		l1.setBounds(100, 30, 400, 30);

		getContentPane().add(l1);

		tableModel = new DefaultTableModel(tblHead, 0);
		
		data = new JTable(tableModel);
		
		//javax.swing.JTable.setInner(5); 
		
		data.setFont(new Font("Chandas", Font.BOLD, 15));
		data.setRowHeight(25);
		
		data.setBounds(100, 100, 450, 450);
		
		chargeData(dao);
		
		data.setDefaultEditor(Object.class, null);
		
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
								chargeData(dao);
							}

							@Override
							public void windowClosed(WindowEvent e) {								
								chargeData(dao);
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
		
		JScrollPane scrollPane = new JScrollPane(data);
		scrollPane.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 15));
		
		scrollPane.setSize(550, 300);
		scrollPane.setLocation(50, 100);
		getContentPane().add(scrollPane);

		setTitle("LISTE DES AEROPORT");

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
	public void chargeData(AeroportDao dao) {
			
			
			list = (List<Aeroport>) dao.getAll();
							
			ListIterator<Aeroport> listIterator = ((java.util.List<Aeroport>) list).listIterator();
			
			tableModel.setRowCount(0);
						
			if (list != null) {

				while(listIterator.hasNext()) {
					b1 = listIterator.next();

					Object[] donnees = { 
						b1.getIdAeroport(), 
						b1.getNomAeroport(), 
						b1.getNomVille() 
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