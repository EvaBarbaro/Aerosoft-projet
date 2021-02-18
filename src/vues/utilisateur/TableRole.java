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
 
public class TableRole extends JFrame{

	private static final long serialVersionUID = 1L;
    List<TableCellEditor> editors = new ArrayList<TableCellEditor>(3);

    ArrayList<Role> listeRoles;

    JButton btn_1 ;
    JButton btn_2 ;
    JButton btn_3 ;

    private JTable table;

    private JComboBox<String> comboBox1;
    private int row;

    private String[] params;

    private Role roleEnCours;
    String newIdRole;

    public TableRole() {
        RoleDao rd = new RoleDao();

        listeRoles = new RoleDao().getAll();

        // Create the editors to be used for each row 
        String[] items1 = { "0", "1", "2", "3", "4", "5" };
        
        comboBox1 = new JComboBox<String>(items1);
        comboBox1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
 
                newIdRole =  table.getModel().getValueAt(row, 1).toString() +
                                    table.getModel().getValueAt(row, 2).toString() +
                                    table.getModel().getValueAt(row, 3).toString() +
                                    table.getModel().getValueAt(row, 4).toString() +
                                    table.getModel().getValueAt(row, 5).toString(); 

                if (roleEnCours != null) {
                                        
                    System.out.println("l'IdRole actuel est : " + roleEnCours.getIdRole());
                    System.out.println("le nouvel IdRole sera : " + newIdRole);
                    System.out.println(roleEnCours.getRoleNom() + " est en cours");
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
        
        table.setSize(800, 200);
        table.addMouseListener(new MouseAdapter() {
		    
			public void mousePressed(MouseEvent mouseEvent) {
		        
				JTable table =(JTable) mouseEvent.getSource();
				
		        Point point = mouseEvent.getPoint();
		        
                row = table.rowAtPoint(point);
                
                roleEnCours = listeRoles.get(row);
                System.out.println(roleEnCours.getRoleNom() + " est en cours");
		    }
        });
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(300);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(700, 200);
        scrollPane.setLocation(50, 50);
        getContentPane().add(scrollPane);

        btn_1 = new JButton("Ajouter");
        btn_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_1.setBackground(new Color(1, 175, 228));
        btn_1.setForeground(Color.WHITE);
        btn_1.setBounds(50, 270, 150, 30);
        btn_1.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent e) {

                params = new String[2];

                params[0] = newIdRole;

                String newRoleNom = "";

                for (Role r : listeRoles) {

                    if (r.getRoleNom().equals(roleEnCours.getRoleNom() + "+")) {

                        newRoleNom = roleEnCours.getRoleNom() + "+";
                        break;
                    } 
                    else {

                        newRoleNom = roleEnCours.getRoleNom();
                    }
                }

                params[1] = newRoleNom + "+";                

                rd.save(roleEnCours, params);
			}
        });
                
        btn_2 = new JButton("Modifier");
        btn_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_2.setBackground(new Color(22, 219, 170));
        btn_2.setForeground(Color.WHITE);
        btn_2.setBounds(250, 270, 150, 30);
        btn_2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                params = new String[3];

                params[0] = newIdRole;
                params[1] = roleEnCours.getRoleNom(); 
                params[2] = roleEnCours.getIdRole(); 

                rd.update(roleEnCours, params);
            }

        });

        btn_3 = new JButton("Suprimer");
        btn_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_3.setBackground(new Color(200, 0, 70));
        btn_3.setForeground(Color.WHITE);
        btn_3.setBounds(450, 270, 150, 30);
        btn_3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                rd.delete(roleEnCours);
            }
        });
        
        getContentPane().add(btn_1);
        getContentPane().add(btn_2);
        getContentPane().add(btn_3);
        
        setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
        //setLayout(new FlowLayout());
        setLayout(null);
        
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        
		setLocation(x, y);
		setLocationRelativeTo(null);
        setVisible(true);

        
    }
  
    class ComboBoxRenderer extends JComboBox<String> implements TableCellRenderer {
        private static final long serialVersionUID = 1L;

        public ComboBoxRenderer() {
            setBorder(new EmptyBorder(0, 0, 0, 0));
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {

            removeAllItems();
            addItem((String) value);
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
    
}