import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
/**
 * @version 1.0 11/09/98
 */
public class CS_JTableHelferButtonRenderer extends JButton implements TableCellRenderer {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CS_JTableHelferButtonRenderer() {
    setOpaque(true);
  }
  
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(new Color(230, 230, 250));
    } else{
      setForeground(table.getForeground());
      setBackground(new Color(230, 230, 250));
    }
    setIcon(new ImageIcon("Images\\helfer.jpg"));
    return this;
  }
}