package vues.utilisateur;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import dao.RoleDao;
import models.Role;
 
public class TableRole extends JFrame
{

	private static final long serialVersionUID = 1L;
	List<TableCellEditor> editors = new ArrayList<TableCellEditor>(3);
 
    public TableRole(){
        // Create the editors to be used for each row
 
        String[] items1 = { "1", "2", "3","4","5" };
        JComboBox comboBox1 = new JComboBox( items1 );
        DefaultCellEditor dce1 = new DefaultCellEditor( comboBox1 );
     
        /*String[] items2 = { "Circle", "Square", "Triangle" };
        JComboBox comboBox2 = new JComboBox( items2 );
        DefaultCellEditor dce2 = new DefaultCellEditor( comboBox2 );
        editors.add( dce2 );
 
        String[] items3 = { "Apple", "Orange", "Banana" };
        JComboBox comboBox3 = new JComboBox( items3 );
        DefaultCellEditor dce3 = new DefaultCellEditor( comboBox3 );
        editors.add( dce3 );*/
 
        //  Create the table with default data
        
        ArrayList<Role> listeRoles = new RoleDao().getAll();

        int i = 0;
        Object[][] data = new Object[listeRoles.size()][6];
        for (Role r : listeRoles) {
            editors.add(dce1);
            data[i][0] = r.getRoleNom();
            for(int j=0; j <5 ; j++)        {
            //La méthode charAt trouve la position et convert en char.
            char charVar = r.getIdRole().charAt(j);
            data[i][j + 1] = charVar;

            }
            i++;                 
        }
        /*{
            {"Color", "Red"},
            {"Shape", "Square"},
            {"Fruit", "Banana"},
            {"Plain", "Text"}
        };*/
        String[] columnNames = {"Role","read","update","Create","Delete","all"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model){

			private static final long serialVersionUID = 1L;

			//  Determine editor to be used by row
            public TableCellEditor getCellEditor(int row, int column) {
                
                int modelColumn = convertColumnIndexToModel( column );
 
                if (modelColumn == 1 && row < listeRoles.size())
                    return editors.get(row);
                else
                    return super.getCellEditor(row, column);
            }
        };

        for(int j=1; j <=5 ; j++)        {
                       
            TableColumn sportColumn = table.getColumnModel().getColumn(j);
            sportColumn.setCellEditor(new DefaultCellEditor(comboBox1));

        }

        JScrollPane scrollPane = new JScrollPane(table);
        
        getContentPane().add( scrollPane );
//      table.getColumnModel().getColumn(1).setCellRenderer(new ComboBoxRenderer() );
    }
 
 
 
    class ComboBoxRenderer extends JComboBox implements TableCellRenderer{
		private static final long serialVersionUID = 1L;

		public ComboBoxRenderer()
        {
            setBorder(new EmptyBorder(0, 0, 0, 0));
        }
 
        public Component getTableCellRendererComponent(
                JTable table, 
                Object value, 
                boolean isSelected, 
                boolean hasFocus, 
                int row, 
                int column){
//          setFocusable(false);
            removeAllItems();
            addItem( value );
            return this;
        }
    }
}