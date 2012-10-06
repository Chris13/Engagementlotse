import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/**
 * @version 1.0 11/09/98
 */
public class CS_JTableNotizButtonEditor extends DefaultCellEditor {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected JButton button;
  private boolean   isPushed;
  private JDialog parent;
  Dialog_EinsatzBeschreibung beschreibung = new Dialog_EinsatzBeschreibung(parent);
 

 
  public CS_JTableNotizButtonEditor(JCheckBox checkBox) {
    super(checkBox);
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
    button.setIcon(new ImageIcon("Images\\Notiz.jpg"));   
    ((Dialog_AufgabefuerHelfer) parent).getmglEinsatzzeit().get(row);
    isPushed = true;
    return button;
  }
 
  public Object getCellEditorValue() {
    if (isPushed)  {
    	beschreibung.setVisible(true);
    }
    isPushed = false;
    return button;
  }

  
  public void setDialog(JDialog dParent)
  {
	  parent = dParent;
  }
  
}
