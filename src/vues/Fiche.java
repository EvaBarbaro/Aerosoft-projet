package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.Dao;
import vues.SuperDialog;

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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class Fiche extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	Boolean touch = false;

	/**
	 * Create the frame.
	 */
	public Fiche(
			String titre, 
			Dao dao, 
			Object transport, 
			int id, 
			String [] listLabels, 
			String [] listTextFields,
			String [][] listSuperDialog
			) {

		setTitle(titre);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(""+id);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1 = new JLabel(listLabels[0]);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_1 = new JTextField();
		textField_1.addFocusListener((FocusListener) new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				touch = true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				touch = true;
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setText(listTextFields[0]);
		
		String oldValue_0 = listTextFields[0];
		

		JLabel lblNewLabel_2 = new JLabel(listLabels[1]);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_2 = new JTextField();
		textField_2.addFocusListener((FocusListener) new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				touch = true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				touch = true;
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setText(listTextFields[1]);
		
		String oldValue_1 = listTextFields[1];

		JButton btn_Supprimer = new JButton("Supprimer");
		btn_Supprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (new SuperDialog(listSuperDialog[0][0],listSuperDialog[0][1], listSuperDialog[0][2], listSuperDialog[0][3]).getValidation() == true) {
					
					//dao = new Dao();					
					dao.delete(id);
					dispose();

				} else {
					dispose();
				}
			}
		});
		btn_Supprimer.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (!(oldValue_0.equals(textField_1.getText()))
						|| (!(oldValue_1.equals(textField_2.getText())))) {

					if (new SuperDialog(listSuperDialog[1][0],listSuperDialog[1][1], listSuperDialog[1][2], listSuperDialog[1][3])
							.getValidation() == true) {
						
						//dao = new Dao();
						
						//((Object) transport).setIsbn(textField_Isbn.getText());
						//((Object) transport).setNom(textField_Nom.getText());
						
						
						
						String[]params = {textField_1.getText(),textField_2.getText()};
						
						dao.update(transport,params);

					} else {
						dispose();
					}
				}
				dispose();
			}
		});
		btn_Valider.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_3 = new JLabel(titre);
		lblNewLabel_3.setFont(new Font("Nirmala UI", Font.PLAIN, 22));
		lblNewLabel_3.setForeground(Color.BLUE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(22)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_2))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_1,
												GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 183,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(220)
								.addComponent(btn_Valider).addGap(18).addComponent(btn_Supprimer))));
		
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(lblNewLabel_3).addGap(62)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)))
						.addComponent(lblNewLabel))
				.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btn_Supprimer)
						.addComponent(btn_Valider))));
		contentPane.setLayout(gl_contentPane);

		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		setLocation(x, y);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
