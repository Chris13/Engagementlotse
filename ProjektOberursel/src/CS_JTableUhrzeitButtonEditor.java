import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
 
/**
 * @version 1.0 11/09/98
 */
public class CS_JTableUhrzeitButtonEditor extends DefaultCellEditor {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected JButton button;
  private boolean isPushed;
  private JDialog parent;
  Dialog_UhrzeitAnzeige zeit = new Dialog_UhrzeitAnzeige(parent);
  private Dialog_AufgabefuerHelfer dialogparent;
  private P_Einsatz einsatzPanelParent;
 

 
  public CS_JTableUhrzeitButtonEditor(JCheckBox checkBox, Dialog_AufgabefuerHelfer mydialogparent) {
    super(checkBox);
    dialogparent = mydialogparent;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }
  
  public CS_JTableUhrzeitButtonEditor(JCheckBox checkBox, P_Einsatz myEinsatzPanel) {
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
    button.setIcon(new ImageIcon("Images\\Clock2.jpg"));   
    
    isPushed = true;
    return button;
  }
 
  public Object getCellEditorValue() {
    if (isPushed)  {
    	if(dialogparent != null)
    		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.einsatzterminesql(dialogparent.getErstEinsatzRow()),false);
    	if(einsatzPanelParent != null)
    		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.einsatzterminesql(einsatzPanelParent.getErstEinsatzRow()),false);
    	DefaultTableModel uhrzeit = CS_DataBaseConnect.getModel();
    	if(uhrzeit.getRowCount() != 0)
    	{
    		String zeitausgabe = "";
    		for(int i = 0; i < uhrzeit.getRowCount(); i++)
    		{
		    	zeitausgabe = zeitausgabe + uhrzeit.getValueAt(i, 0).toString()+","+uhrzeit.getValueAt(i, 1).toString()+" - "+uhrzeit.getValueAt(i, 2).toString()+"\n";
    		}
    		zeit.setAreaText(zeitausgabe);
	    	zeit.setVisible(true);
    	}
    	else
    		JOptionPane.showMessageDialog(null,"Es wurde keine Uhrzeit angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
    }
    isPushed = false;
    return button;
  }

  
  public void setDialog(JDialog dParent)
  {
	  parent = dParent;
  }
  
}
