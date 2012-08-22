import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;

//Quelle:http://blog.it-anf.de/allgemein/jtable-spaltenbreite-automatisch-optimal-anpassen/
public class CS_SpaltenBreite {
		 
	    private static final int DEFAULT_COLUMN_PADDING = 5;
	    
	    public static int autoResizeTable(JTable aTable, boolean includeColumnHeaderWidth) {
	        return (autoResizeTable(aTable, includeColumnHeaderWidth, DEFAULT_COLUMN_PADDING));
	    }
	 
	    public static int autoResizeTable(JTable aTable, boolean includeColumnHeaderWidth, int columnPadding) {
	        return (autoResizeTable(aTable, includeColumnHeaderWidth, columnPadding, false));
	    }

	    private static int autoResizeTable(JTable aTable, boolean includeColumnHeaderWidth, int columnPadding, boolean fit) {
	        int columnCount = aTable.getColumnCount();
	        int currentTableWidth = aTable.getWidth();
	        int tableWidth = 0;
	        aTable.setRowHeight(30);
	        Dimension cellSpacing = aTable.getIntercellSpacing();
	        if (columnCount > 0) // must have columns !
	        {
	            // STEP ONE : Work out the column widths
	            int columnWidth[] = new int[columnCount];
	            for (int i = 0; i < columnCount; i++) {
	                columnWidth[i] = getMaxColumnWidth(aTable, i, true, columnPadding);
	                tableWidth += columnWidth[i];
	            }
	            // account for cell spacing too
	            tableWidth += ((columnCount - 1) * cellSpacing.width);
	            JTableHeader tableHeader = aTable.getTableHeader();
	            tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
	            Dimension headerDim = tableHeader.getPreferredSize();
	            headerDim.width = tableWidth;
	            Dimension interCellSpacing = aTable.getIntercellSpacing();
	            Dimension dim = new Dimension();
	            dim.width = tableWidth;
	            int viewWidth = currentTableWidth;         
	            Component parent = aTable.getParent();     
	            if (parent instanceof JViewport) {           
	                JViewport port = (JViewport) parent;     
	                viewWidth = port.getExtentSize().width; 
	            }                                           
	            if (fit & tableWidth != viewWidth) {        
	                int corr = (viewWidth - 
	                        tableWidth) / columnCount;      
	                tableWidth = 0;                        
	                for (int i = 0; i < columnCount; i++) { 
	                    columnWidth[i] += corr;             
	                    tableWidth += columnWidth[i];       
	                }                                       
	                if (tableWidth != viewWidth) {           
	                    columnWidth[columnCount - 1] += 
	                            (viewWidth - tableWidth);   
	                    tableWidth = viewWidth;             
	                }                                       
	            }                                          
	            TableColumnModel tableColumnModel = aTable.getColumnModel();
	            TableColumn tableColumn;
	            //DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
		        //defaultRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		 
	            for (int i = 0; i < columnCount; i++) {
	                tableColumn = tableColumnModel.getColumn(i);
	                tableColumn.setPreferredWidth(columnWidth[i]);
	               // aTable.setDefaultRenderer(aTable.getColumnClass(i),defaultRenderer);
	            }
	            
	            
	            aTable.invalidate();
	            aTable.doLayout();
	            aTable.repaint();
	        }
	        return (tableWidth);
	    }
	    /*
	     * @param JTable aTable, the JTable to autoresize the columns on
	     * @param int columnNo, the column number, starting at zero, to calculate the maximum width on
	     * @param boolean includeColumnHeaderWidth, use the Column Header width as a minimum width
	     * @param int columnPadding, how many extra pixels do you want on the end of each column
	     * @returns The maximum Column Width
	     */
	 
	    private static int getMaxColumnWidth(JTable aTable, int columnNo,
	            boolean includeColumnHeaderWidth,
	            int columnPadding) {
	        TableColumn column = aTable.getColumnModel().getColumn(columnNo);
	        Component comp = null;
	        int maxWidth = 0;
	        if (includeColumnHeaderWidth) {
	            TableCellRenderer headerRenderer = column.getHeaderRenderer();
	            if (headerRenderer != null) {
	                comp = headerRenderer.getTableCellRendererComponent(aTable, column.getHeaderValue(), false, false, 0, columnNo);
	                if (comp instanceof JTextComponent) {
	                    JTextComponent jtextComp = (JTextComponent) comp;
	                    String text = jtextComp.getText();
	                    Font font = jtextComp.getFont();
	                    FontMetrics fontMetrics = jtextComp.getFontMetrics(font);
	                    maxWidth = SwingUtilities.computeStringWidth(fontMetrics, text);
	                } else {
	                    maxWidth = comp.getPreferredSize().width;
	                }
	            } else {
	                try {
	                    String headerText = (String) column.getHeaderValue();
	                    JLabel defaultLabel = new JLabel(headerText);
	                    Font font = new Font("Tahoma", Font.PLAIN, 16);
	                    FontMetrics fontMetrics = defaultLabel.getFontMetrics(font);
	                    maxWidth = SwingUtilities.computeStringWidth(fontMetrics, headerText);
	                } catch (final ClassCastException ce) {
	                    // Can’t work out the header column width..
	                    maxWidth = 0;
	                }
	            }
	        }
	     
	        TableCellRenderer tableCellRenderer;
	        int cellWidth = 0;
	        for (int i = 0; i < aTable.getRowCount(); i++) {
	            tableCellRenderer = aTable.getCellRenderer(i, columnNo);
	            comp = tableCellRenderer.getTableCellRendererComponent(aTable, aTable.getValueAt(i, columnNo), false, false, i, columnNo);
	            if (comp instanceof JTextComponent) {
	                JTextComponent jtextComp = (JTextComponent) comp;
	                String text = jtextComp.getText();
	                Font font = jtextComp.getFont();
	                FontMetrics fontMetrics = jtextComp.getFontMetrics(font);
	                int textWidth = SwingUtilities.computeStringWidth(fontMetrics, text);
	                maxWidth = Math.max(maxWidth, textWidth);
	            } else {
	                cellWidth = comp.getPreferredSize().width;
	                // maxWidth = Math.max ( headerWidth, cellWidth );
	                maxWidth = Math.max(maxWidth, cellWidth);
	            }
	        }
	        return (maxWidth + columnPadding);
	    }
	 	

}
