import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
 
/**
 * @version 1.0 11/09/98
 */
public class CS_JTableHelferButtonEditor extends DefaultCellEditor {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected JButton button;
  private boolean isPushed;
  private JDialog parent;
  Dialog_UhrzeitAnzeige zeit = new Dialog_UhrzeitAnzeige(parent);
  private Dialog_ProjektAufgabeHelfer dialogparent;
  private P_Einsatz einsatzPanelParent;
 

 
  public CS_JTableHelferButtonEditor(JCheckBox checkBox, Dialog_ProjektAufgabeHelfer mydialogparent) {
    super(checkBox);

    dialogparent = mydialogparent;
    button = CS_ButtonDesign.buttonHelferAnz();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }
  
  public CS_JTableHelferButtonEditor(JCheckBox checkBox, P_Einsatz myEinsatzPanel) {
	    super(checkBox);
	    einsatzPanelParent = myEinsatzPanel;
	    button = new JButton();
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });
	  }
 
  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(new Color(230, 230, 250));
    } else{
      button.setForeground(table.getForeground());
      button.setBackground(new Color(230, 230, 250));
    }
    button.setIcon(new ImageIcon("Images\\Helfer.jpg"));   
    
    isPushed = true;
    return button;
  }
 
  public Object getCellEditorValue() {
    if (isPushed)  {
    	Dialog_HelferfuerAufgabe helferfueraufgabe = new Dialog_HelferfuerAufgabe(dialogparent,dialogparent.getAufgabeId(),dialogparent.getAufgabeName(), dialogparent.getProjektId());
    	helferfueraufgabe.setVisible(true);  
    }
    isPushed = false;
    return button;
  }

  
  public void setDialog(JDialog dParent)
  {
	  parent = dParent;
  }
  
}
