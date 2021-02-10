
package vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;  
import java.awt.event.*;  
public class SuperDialog {
	
    private static JDialog d;
    
    private Boolean validation; 
    
    private JPanel contentPane;
        
    public Boolean getValidation() {
		return validation;
	}

	SuperDialog(String titre, String textDuDialogue, String textDuBoutonOUI, String textDuBoutonNon) {  
        JFrame f= new JFrame();  
        d = new JDialog(f , titre, true);  
        
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        
        d.setLayout( new GroupLayout(contentPane) );  
        
        d.add( new JLabel(textDuDialogue, SwingConstants.CENTER));  
        
        JButton b = new JButton (textDuBoutonOUI); 
           
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                SuperDialog.d.setVisible(false);
                validation = true;
            }  
        });
        
        d.add(b); 
        
        if(textDuBoutonNon != null) {
        	JButton b2 = new JButton (textDuBoutonNon);
        	b2.addActionListener ( new ActionListener()  
            {  
                public void actionPerformed( ActionEvent e )  
                {  
                    SuperDialog.d.setVisible(false); 
                    validation = false;
                }  
            });  
        	d.add(b2);
        }
        
        
  
        d.setSize(350,200);   
        
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - d.getWidth()) / 2;
		final int y = (screenSize.height - d.getHeight()) / 2;
		
		d.setLocation(x, y);
		d.setLocationRelativeTo(null);
        d.setVisible(true);  
    }      
}  