import java.awt.Component;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.*;
 
/**
 * @version 1.0 11/09/98
 */
public class CS_JTableTextfieldRenderer extends AbstractCellEditor implements TableCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// This is the component that will handle the editing of the cell value
    JComponent component = new JTextField();

    // This method is called when a cell value is edited by the user.
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)
    	
        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }

        // Configure the component with the specified value
        ((JTextField)component).setText((String)value);

        // Return the configured component
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }
}
