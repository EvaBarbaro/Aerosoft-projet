
package vues.utilisateur;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import dao.RoleDao;
import models.Role;

public class ComboRole {

    private List<Role> countries;
    private JComboBox cBox;

    RoleDao roleDao;

    public ComboRole() {

        roleDao = new RoleDao();

        countries = new RoleDao().getAll();
        cBox = createComboBox(countries);

        JFrame frame = new JFrame();
        frame.add(cBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JComboBox createComboBox(List<Role> roles) {
        final JComboBox comboBox = new JComboBox(roles.toArray());
        comboBox.setRenderer(new ComboBoxRenderer());
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Role role = (Role) comboBox.getSelectedItem();                    
                }
            }
        });
        return comboBox;
    }

    private class ComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list,
                    value, index, isSelected, cellHasFocus);
            Role role = (Role) value;
            label.setText(role.getRoleNom());
            return label;
        }
    }

}