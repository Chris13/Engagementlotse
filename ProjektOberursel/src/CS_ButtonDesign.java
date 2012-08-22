import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CS_ButtonDesign {
	public CS_ButtonDesign(){}
	
	static JButton buttonLarge()
	{
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("Images\\test_yellow.jpg"));
		btn.setDisabledIcon(new ImageIcon("Images\\test_yellow_back.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_scrollover.jpg"));
		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;		
	}
	
	static JButton buttonExtraLarge()
	{
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("Images\\test_yellow_big.jpg"));
		btn.setDisabledIcon(new ImageIcon("Images\\test_yellow_scrollover_big.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_scrollover_big.jpg"));
		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;		
	}
	
	static JButton buttonMedium()
	{
		JButton btn = new JButton();		
		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn.setIcon(new ImageIcon("Images\\test_yellow_small.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_scrollover_small.jpg"));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;		
	}
	
	static JButton buttonHelferAnz()
	{
		JButton btn = new JButton();
		btn.setToolTipText("Helfer anzeigen");
		btn.setIcon(new ImageIcon("Images\\test_yellow_Helfer_Anz.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_Helfer_Anz_scrollover.jpg"));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;
	}
	
	static JButton buttonAufgabenAnz()
	{
		JButton btn = new JButton();
		btn.setToolTipText("Aufgaben anzeigen");
		btn.setIcon(new ImageIcon("Images\\test_yellow_Aufgaben_Anz.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_Aufgaben_Anz_scrollover.jpg"));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;
	}
	
	static JButton buttonAnlegen()
	{
		JButton btn = new JButton();
		btn.setToolTipText("Neu hinzufügen");
		btn.setIcon(new ImageIcon("Images\\test_yellow_Add.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_Add_scrollover.jpg"));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;
	}
	
	static JButton buttonBearbeiten()
	{
		JButton btn = new JButton();
		btn.setToolTipText("Bearbeiten");
		btn.setIcon(new ImageIcon("Images\\test_yellow_Bearbeiten.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_Bearbeiten_scrollover.jpg"));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;
	}
	
	static JButton buttonLoeschen()
	{
		JButton btn = new JButton();
		btn.setToolTipText("Löschen");
		btn.setIcon(new ImageIcon("Images\\test_yellow_Delete.jpg"));
		btn.setRolloverIcon(new ImageIcon("Images\\test_yellow_Delete_scrollover.jpg"));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setContentAreaFilled( false );  
		btn.setBorderPainted( false );
		btn.setFocusPainted( false );
		btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		return btn;
	}

}
