package vues;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import interfaces.Dao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
//import java.util.concurrent.Callable;
import java.awt.event.ActionEvent;

public class Fiche extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JLabel lblNewTitre;
	
	private JLabel lblNewID;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3 = new JLabel("");
	private JLabel lblNewLabel_4 = new JLabel("");
	private JLabel lblNewLabel_5 = new JLabel("");
	private JLabel lblNewLabel_6 = new JLabel("");
	
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3 = new JTextField();
	private JTextField textField_4 = new JTextField();
	private JTextField textField_5 = new JTextField();
	private JTextField textField_6 = new JTextField();

	private String oldValue_1;
	private String oldValue_2;
	private String oldValue_3;
	private String oldValue_4;
	private String oldValue_5;
	private String oldValue_6;

	/**
	 * Create the frame.
	 */
	public Fiche(
			String titre, 
			Dao dao, 
			Object transport, 
			String id, 
			String [] listLabels, 
			String [] listTextFields,
			String[][] listSuperDialog,
			String [] listTextBtns,
			String[] listMethodeDoa
			/*,
			Method  fonctionBtn1,
			Method  fonctionBtn2*/
	) {

		setTitle(titre);

		lblNewTitre = new JLabel(titre);
		lblNewTitre.setForeground(Color.blue);
		lblNewTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));

		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblNewID = new JLabel(id);

		lblNewLabel_1 = new JLabel(listLabels[0]);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setText(listTextFields[0]);

		oldValue_1 = listTextFields[0];

		lblNewLabel_2 = new JLabel(listLabels[1]);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setText(listTextFields[1]);

		oldValue_2 = listTextFields[1];

		if (listLabels.length >= 3) {

			lblNewLabel_3 = new JLabel(listLabels[2]);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

			textField_3 = new JTextField();
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_3.setColumns(10);
			textField_3.setText(listTextFields[2]);

			oldValue_3 = listTextFields[2];
		}

		if (listLabels.length >= 4) {

			lblNewLabel_4 = new JLabel(listLabels[3]);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

			textField_4 = new JTextField();
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_4.setColumns(10);
			textField_4.setText(listTextFields[3]);

			oldValue_4 = listTextFields[3];
		}

		if (listLabels.length >= 5) {

			lblNewLabel_5 = new JLabel(listLabels[4]);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

			textField_5 = new JTextField();
			textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_5.setColumns(10);
			textField_5.setText(listTextFields[4]);

			oldValue_5 = listTextFields[4];
		}

		if (listLabels.length >= 6) {

			lblNewLabel_6 = new JLabel(listLabels[5]);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));

			textField_6 = new JTextField();
			textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_6.setColumns(10);
			textField_6.setText(listTextFields[5]);

			oldValue_6 = listTextFields[5];
		}

		JButton btn_Supprimer = new JButton(listTextBtns[0]);
		btn_Supprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				executeDoa(listMethodeDoa[0], dao, transport, null);
				dispose();
			}

		});

		btn_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btn_Valider = new JButton(listTextBtns[1]);
		btn_Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(oldValue_1.equals(textField_1.getText())) || (!(oldValue_2.equals(textField_2.getText())))
						|| (oldValue_3 != null && !(oldValue_3.equals(textField_3.getText())))
						|| (oldValue_4 != null && !(oldValue_4.equals(textField_4.getText())))
						|| (oldValue_5 != null && !(oldValue_5.equals(textField_5.getText())))) {
			
					String[] params = new String[listTextFields.length];
					System.out.println("listTextFields.length : "  + listTextFields.length);				

					params[0] = textField_1.getText();
					params[1] = textField_2.getText();
					
					if (listTextFields.length >= 3) {
						params[2] = textField_3.getText();						
					} 
			
					if (listLabels.length >= 4) {
						params[3] = textField_4.getText();						
					} 
			
					if (listLabels.length >= 5) {
						params[4] = textField_5.getText();
					}
					
					if (listLabels.length >= 6) {
						params[5] = textField_6.getText();						
					}
					
					System.out.println("params.length : "  + params.length);				
		
					executeDoa(listMethodeDoa[1], dao, transport, params);
				}
				dispose();
			}
		});
		btn_Valider.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewTitre, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
							.addComponent(lblNewID, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_Valider)
							.addGap(18)
							.addComponent(btn_Supprimer))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6))
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_5, Alignment.TRAILING)
								.addComponent(textField_4, Alignment.TRAILING)
								.addComponent(textField_3)
								.addComponent(textField_2)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
								.addComponent(textField_6))))
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewTitre)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(lblNewLabel_2)
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewID))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Supprimer)
						.addComponent(btn_Valider))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);

		if (listTextFields.length >= 3) {
			textField_3.setVisible(true);
		} else {
			textField_3.setVisible(false);
		}

		if (listTextFields.length >= 4) {
			textField_4.setVisible(true);
		} else {
			textField_4.setVisible(false);
		}

		if (listTextFields.length >= 5) {
			textField_5.setVisible(true);
		} else {
			textField_5.setVisible(false);
		}

		if (listTextFields.length >= 6) {
			textField_6.setVisible(true);
		} else {
			textField_6.setVisible(false);
		}

		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		setLocation(x, y);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void executeDoa(String methodeDao,Dao dao, Object transport, String[] params) {
		switch (methodeDao) {
			case "get":			
				dao.get(transport);
			break;

			case "save":
    			dao.save(transport);
			break;
    
			case "update":
    			dao.update(transport, params);
			break;

			case "delete":    
				dao.delete(transport);
			break;
		}
	}
}
