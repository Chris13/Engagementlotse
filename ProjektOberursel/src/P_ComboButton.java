import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalComboBoxButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.util.ArrayList;


public class P_ComboButton extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox comboBox;
    
    JComboBox getComboBox(){
    	return comboBox;
    }
    
	public P_ComboButton(final JDialog parent, final CS_JComboButtonCellEditor cellparent) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JButton btnX = new JButton();
        btnX.setPreferredSize(new Dimension(15,15));
    	btnX.setIcon(new ImageIcon("Images\\muelleimer.jpg"));
    	btnX.setRolloverIcon(new ImageIcon("Images\\muelleimer_scrollover.jpg"));
		btnX.setHorizontalTextPosition(JButton.CENTER);
		btnX.setContentAreaFilled( false );  
		btnX.setBorderPainted( false );
		btnX.setFocusPainted( false );
		btnX.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnX.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(comboBox.getSelectedIndex()!=0){        			
        			ArrayList<String> tmp1 = ((Dialog_AufgabefuerHelfer) parent).getmglEinsatzzeit().get(((Dialog_AufgabefuerHelfer) parent).getmglEinsatz().getSelectedRow());        		   			
        			tmp1.remove(comboBox.getSelectedIndex()-1);	      
        			comboBox.removeItem(comboBox.getSelectedItem());
        		}
        		
        	}
        });
        panel.add(btnX, BorderLayout.EAST);
        comboBox = new JComboBox();
        comboBox.addItem("Einsatzzeit hinzufügen");
        panel.add(comboBox, BorderLayout.CENTER);
        comboBox.setPreferredSize(new Dimension(161, 20));
        MetalComboBoxButton metalComboBoxButton = null;
        for (Component comp : comboBox.getComponents()){
            if (comp instanceof MetalComboBoxButton) {
            	metalComboBoxButton = (MetalComboBoxButton) comp;
            }
        }
        metalComboBoxButton.setComboIcon(new ImageIcon("Images\\Clock.jpg"));
        metalComboBoxButton.setHorizontalTextPosition(JButton.CENTER);
        metalComboBoxButton.setContentAreaFilled( false );  
        metalComboBoxButton.setFocusPainted( false );
        metalComboBoxButton.setBackground(new Color(255, 215, 0));
        metalComboBoxButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        metalComboBoxButton.removeMouseListener(metalComboBoxButton.getMouseListeners()[1]);
        metalComboBoxButton.addActionListener(new ActionListener() {                  
            public void actionPerformed(ActionEvent e) {            	
       		Dialog_Einsatzzeit einsatzzeit = new Dialog_Einsatzzeit(parent, cellparent);
	        einsatzzeit.setVisible(true);         
            }
        }); 
    }
	
}
