package vues.vol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.VolDao;
import models.Vol;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

 
public class ListeVol extends JFrame implements ActionListener{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JLabel l1;
	
	DefaultTableModel tableModel;
	JTable data;
	
	Vol v1;
	VolDao dao = new VolDao();
	
	List<Vol> list = new ArrayList<Vol>();
	 
	String[] tblHead = { "Id du vol", "Aeroport de depart", "Heure de depart", "Aeroport d'arrivé'", "Heure d'arrivé'" };
	 

	public ListeVol() {
		
		/* Label */
		l1 = new JLabel("LISTE DES VOLS");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 20));

		/* Placement */
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
										
					v1 = (Vol) dao.get(id);

					if (v1 != null) {
						
						FicheModifVol fm = new FicheModifVol(v1);
						
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

	public void chargeData(VolDao dao) {
			
			
			list = (List<Vol>) dao.getAll();
							
			ListIterator<Vol> listIterator = ((java.util.List<Vol>) list).listIterator();
			
			tableModel.setRowCount(0);
						
			if (list != null) {

				while(listIterator.hasNext()) {
					v1 = listIterator.next();

					Object[] donnees = { 
						v1.getNumVol(), 
						v1.getAeroportDepart(), 
						v1.getHeureDepart(),
						v1.getAeroportArrive(),
						v1.getHeureArrive() 
					};

					tableModel.addRow(donnees);	
					
				}
				tableModel.fireTableDataChanged();			
				data.setModel(tableModel);
				data.repaint();
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}