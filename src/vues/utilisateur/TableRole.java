package vues.utilisateur;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import dao.RoleDao;
import models.Role;
 
public class TableRole extends JFrame implements TableModelListener{

	private static final long serialVersionUID = 1L;
    List<TableCellEditor> editors = new ArrayList<TableCellEditor>(3);

    ArrayList<Role> listeRoles;

    private JTable table;

    private JComboBox comboBox1;
    private int row;

    /**
    * 
    */    
    public TableRole() {
        RoleDao rd = new RoleDao();

        listeRoles = new RoleDao().getAll();
        // Create the editors to be used for each row
 
        String[] items1 = {"0", "1", "2", "3","4","5" };
        comboBox1 = new JComboBox(items1);
        comboBox1.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                //Object id = (Object) table.getModel().getValueAt(row, .toString();
                //System.out.println("id :" + id);

                String idRole = (String) comboBox1.getSelectedItem();
                System.out.println("idRole :" + idRole);
                
                Role r = listeRoles.get(row);
                System.out.println("Role r :" + r.getRoleNom());

                //String newIdRole = (String) getCellEditorValue(row) +
                String newIdRole = table.getModel().getValueAt(row, 1).toString() +
                                    table.getModel().getValueAt(row, 2).toString() +
                                    table.getModel().getValueAt(row, 3).toString() +
                                    table.getModel().getValueAt(row, 4).toString() +
                                    table.getModel().getValueAt(row, 5).toString(); 
                System.out.println("newIdRole :" + newIdRole);
                if (r != null) {
                    String[] params = new String[2];
                    params[0] = newIdRole;
                    params[1] = r.getRoleNom() + "+";
                    rd.save(r,params);
                }	
            }
        });
                
        DefaultCellEditor dce1 = new DefaultCellEditor(comboBox1);
          
        int i = 0;
        Object[][] data = new Object[listeRoles.size()][6];
        for (Role r : listeRoles) {
            editors.add(dce1);
            data[i][0] = r.getRoleNom();
            for (int j = 0; j < 5; j++) {
                //La méthode charAt trouve la position et convert en char.
                char charVar = r.getIdRole().charAt(j);
                data[i][j + 1] = charVar;

            }
            i++;
        }
        
        String[] columnNames = {"Role","Aeroport","Vols","Pilotes","Affectation","Avion"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        table = new JTable(model){

			private static final long serialVersionUID = 1L;

			//  Determine editor to be used by row
            public TableCellEditor getCellEditor(int row, int column) {
                
                int modelColumn = convertColumnIndexToModel(column);
                
 
                if (modelColumn == 1 && row < listeRoles.size())
                    return editors.get(row);
                else
                    return super.getCellEditor(row, column);
            }
        };

        TableColumn column ;
        for (int j = 1; j <= 5; j++) {

            column = table.getColumnModel().getColumn(j);
            column.setCellEditor(new DefaultCellEditor(comboBox1));

        }
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(300);
        
        table.addMouseListener(new MouseAdapter() {
		    
			public void mousePressed(MouseEvent mouseEvent) {
		        
				JTable table =(JTable) mouseEvent.getSource();
				
		        Point point = mouseEvent.getPoint();
		        
		        row = table.rowAtPoint(point);                
		        
		        if (table.getSelectedRow() != -1) {
		        	
					int column = 0;
		        }
		    }
		});

        JScrollPane scrollPane = new JScrollPane(table);        
        getContentPane().add(scrollPane);

        setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 200);
        
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		setLocation(x, y);
		setLocationRelativeTo(null);
		setVisible(true);

    }
  
    class ComboBoxRenderer extends JComboBox implements TableCellRenderer {
        private static final long serialVersionUID = 1L;

        public ComboBoxRenderer() {
            setBorder(new EmptyBorder(0, 0, 0, 0));
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {

            removeAllItems();
            addItem(value);
            return this;
        }
    }

    
    /** 
     * @param row
     * @return Object
     */
    public Object getCellEditorValue(int row) {
        return comboBox1.getSelectedItem();
    }

	
    /** 
     * @param e
     */
    @Override
    public void tableChanged(TableModelEvent e) {

		Object id = (Object) table.getModel().getValueAt(row, e.getColumn()).toString();
        System.out.println("id :" + id);
        
        Role r = listeRoles.get(row);
        System.out.println("Role r :" + r.getRoleNom());
        System.out.println("Role r :" + r.getRoleNom());

        String newIdRole =  table.getModel().getValueAt(row, 1).toString()+
                            table.getModel().getValueAt(row, 2).toString() +
                            table.getModel().getValueAt(row, 3).toString() +
                            table.getModel().getValueAt(row, 4).toString() +
                            table.getModel().getValueAt(row, 5).toString(); 
        System.out.println("newIdRole :" + newIdRole);
        if (r != null) {
    
        }	
		
	}  
    
}