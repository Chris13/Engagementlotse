import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;



public class P_Traeger extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Traeger;
	private JTable table;
	private JTextField textField;
	private JFrame parentFrame;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	/**
	 * Create the panel.
	 */
	public P_Traeger() {
		setLayout(new BorderLayout(0, 0));
		
		Traeger = new JPanel();
		add(Traeger, BorderLayout.CENTER);
		Traeger.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		Traeger.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(3);
		panel_1.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images\\Traeger.jpg"));
		panel_1.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_1.add(horizontalStrut);
		
		JLabel lblHelfer = new JLabel("<html><u>Tr‰ger</u></html>");
		lblHelfer.setHorizontalTextPosition(JLabel.CENTER);
		lblHelfer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblHelfer);
		
		JPanel panel_2 = new JPanel();
		Traeger.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		JLabel lblSuche = new JLabel("  Suche");
		lblSuche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblSuche);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(textField);
		textField.setColumns(10);
			
		Component verticalStrut = Box.createVerticalStrut(50);
		panel_3.add(verticalStrut);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(245, 245, 245));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
	    tableBuild();
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new MigLayout("", "[grow]", "[][][][][][][][grow][][][]"));		
		
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model){
			  @Override
			  public void toggleSortOrder(int column) {}};
		table.setRowSorter(sorter);
		
		JButton btnStart = CS_ButtonDesign.buttonMedium();
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String text = textField.getText();
                if (text.length() == 0) {
                  sorter.setRowFilter(null);
                } else {
                  sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }				
			}
		});
		
	  	textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
			        
			        if (key == KeyEvent.VK_ENTER)
			        {
		        	 String text = textField.getText();
		        	 if (text.length() == 0) 
		        		 sorter.setRowFilter(null);
		        	  else 
		        		 sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));               
			        }
				}
			});
	  	
		btnStart.setText("Start");
		panel_3.add(btnStart);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel_7.add(panel, "cell 0 7,grow");
		
		JButton btnTraegerAnl = CS_ButtonDesign.buttonAnlegen();
		panel_7.add(btnTraegerAnl, "cell 0 8");
		
		btnTraegerAnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_TraegerAnlegen traegeranlegen = new Dialog_TraegerAnlegen(parentFrame);
				traegeranlegen.setVisible(true);
				traegeranlegen.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		                tableBuild();
		            }
				 });
			}
		});
				
		JButton btnTraegerBearb = CS_ButtonDesign.buttonBearbeiten();
		panel_7.add(btnTraegerBearb, "cell 0 9");
		
		btnTraegerBearb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnTraegerLoeschen = CS_ButtonDesign.buttonLoeschen();
		panel_7.add(btnTraegerLoeschen, "cell 0 10");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_5, BorderLayout.SOUTH);		

	}
	
	private void tableBuild()
	{
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		table.setBorder(new LineBorder(new Color(169, 169, 169)));
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.traegersql(),false);
		model = new DefaultTableModel();
		model = CS_DataBaseConnect.getModel();
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.getTableHeader().setBackground(new Color(192, 192, 192));
		table.getColumnModel().getColumn(0).setHeaderValue("Tr‰ger");
		table.getColumnModel().getColumn(1).setHeaderValue("Kontaktperson");
		table.getColumnModel().getColumn(2).setHeaderValue("Telefonnummer");
		table.getColumnModel().getColumn(3).setHeaderValue("Handynummer");
		table.getColumnModel().getColumn(4).setHeaderValue("Straﬂe");
		table.getColumnModel().getColumn(5).setHeaderValue("Postleitzahl");
		table.getColumnModel().getColumn(6).setHeaderValue("Ort");
		table.getColumnModel().getColumn(7).setHeaderValue("EMail");
		table.getColumnModel().getColumn(8).setHeaderValue("Hinweis");
		table.removeColumn(table.getColumnModel().getColumn(9));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//Spaltenbreite an Spalteninhalt anpassen
		CS_SpaltenBreite.autoResizeTable(table, true,10, false);
	}
		
	public JPanel TraegerPanel()
	{
		return Traeger;
	}
	
	public void setFrame(JFrame Mainframe)
	{
		parentFrame = Mainframe;
	}

}
