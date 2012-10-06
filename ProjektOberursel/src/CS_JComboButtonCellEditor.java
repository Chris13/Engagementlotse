import java.awt.Component;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CS_JComboButtonCellEditor extends AbstractCellEditor implements
TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private P_ComboButton comboBtn;
	private JDialog parent;
	
	public P_ComboButton getComboButton(){
		return comboBtn;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		comboBtn.getComboBox().removeAllItems();
		comboBtn.getComboBox().addItem("Einsatzzeit hinzufügen");    				
		ArrayList<String> tmp1 = ((Dialog_AufgabefuerHelfer) parent).getmglEinsatzzeit().get(row);	    		
		
		for(int i=0;i<tmp1.size();i++){
			comboBtn.getComboBox().addItem(tmp1.get(i));
		}
		return comboBtn;
	}
	
	public Object getCellEditorValue() {
		if(comboBtn.getComboBox().getItemAt(1) != null)
			return comboBtn.getComboBox().getItemAt(1);
		else
			return comboBtn.getComboBox().getItemAt(0);         
	}
	
	public CS_JComboButtonCellEditor(Dialog_AufgabefuerHelfer dialogparent)
	{
		parent = dialogparent;
		comboBtn = new P_ComboButton(dialogparent,CS_JComboButtonCellEditor.this);        	        	
	}     
}

