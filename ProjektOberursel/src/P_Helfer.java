import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;


public class P_Helfer extends JPanel {
	private JPanel Helfer;
	protected JTable table;
	private JTextField textField;
	private JPanel panel_2;
	private DefaultTableModel model;
	private JFrame parentFrame;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public P_Helfer() {
		setLayout(new BorderLayout(0, 0));
		
		Helfer = new JPanel();
		add(Helfer, BorderLayout.CENTER);
		Helfer.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		Helfer.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(3);
		panel_1.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images\\Helfer.jpg"));
		panel_1.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_1.add(horizontalStrut);
		
		JLabel lblHelfer = new JLabel("<html><u>Helfer</u></html>");
		lblHelfer.setHorizontalTextPosition(JLabel.CENTER);
		lblHelfer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblHelfer);
		
		panel_2 = new JPanel();
		Helfer.add(panel_2, BorderLayout.CENTER);
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
		Dimension groesse = new Dimension(150, 23);

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
		
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        
        JButton btnStart = CS_ButtonDesign.buttonMedium();
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {                
                String text = textField.getText();
                if (text.length() == 0) {
                  sorter.setRowFilter(null);
                } else {
                  sorter.setRowFilter(RowFilter.regexFilter(text));
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
	        		 sorter.setRowFilter(RowFilter.regexFilter(text));               
		        }
			}
		});
		btnStart.setText("Start");
		panel_3.add(btnStart);
		
		JButton btnHelferAnz = CS_ButtonDesign.buttonHelferAnz();
		panel_7.add(btnHelferAnz, "cell 0 0,growx");
		
		btnHelferAnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				helferDetailsAnzeigen();
			}
		});
		
		JButton btnAufgabeAnz = CS_ButtonDesign.buttonAufgabenAnz();
		panel_7.add(btnAufgabeAnz, "cell 0 1");
		
		btnAufgabeAnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				aufgabenAnzeigen();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel_7.add(panel, "cell 0 7,grow");
		
		JButton btnHelferAnl = CS_ButtonDesign.buttonAnlegen();
		panel_7.add(btnHelferAnl, "cell 0 8");
		
		btnHelferAnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_HelferAnlegen helferanlegen = new Dialog_HelferAnlegen(parentFrame);
				helferanlegen.setVisible(true);
				helferanlegen.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		                tableBuild();
		            }
		        });
			}
		});
		
		JButton btnBearbeiten = CS_ButtonDesign.buttonBearbeiten();
		panel_7.add(btnBearbeiten, "cell 0 9");
		
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_HelferBearbeiten helferbearbeiten = new Dialog_HelferBearbeiten(parentFrame);
				helferbearbeiten.setVisible(true);
			}
		});
		
		JButton btnNewButton = CS_ButtonDesign.buttonLoeschen();
		panel_7.add(btnNewButton, "cell 0 10");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_5, BorderLayout.SOUTH);
	
		

	}
	
	public void tableBuild()
	{
		
		
		table = new JTable();
		
		if(CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.helfersql()))
		{
			model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
			table.setModel(model);
			scrollPane.setViewportView(table);
			table.setBorder(new LineBorder(new Color(169, 169, 169)));
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.getTableHeader().setBackground(new Color(192, 192, 192));
			table.getColumnModel().getColumn(0).setHeaderValue("Helfer ID");
			table.getColumnModel().getColumn(1).setHeaderValue("Eintrittsdatum");
			table.getColumnModel().getColumn(2).setHeaderValue("Vorname");
			table.getColumnModel().getColumn(3).setHeaderValue("Nachname");
			table.getColumnModel().getColumn(4).setHeaderValue("Geschlecht");
			table.getColumnModel().getColumn(5).setHeaderValue("Straﬂe");
			table.getColumnModel().getColumn(6).setHeaderValue("Postleitzahl");
			table.getColumnModel().getColumn(7).setHeaderValue("Wohnort");
			table.getColumnModel().getColumn(8).setHeaderValue("Geburtsdatum");
			table.getColumnModel().getColumn(9).setHeaderValue("Telefonnummer");
			table.getColumnModel().getColumn(10).setHeaderValue("Handynummer");
			table.getColumnModel().getColumn(11).setHeaderValue("EMail");
			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			//Spaltenbreite an Spalteninhalt anpassen
			CS_SpaltenBreite.autoResizeTable(table, true,10);
		}
		else
			JOptionPane.showMessageDialog(null,"Datenbankverbindung konnte nicht hergestellt werden!","Titel", JOptionPane.ERROR_MESSAGE);

	}
	private void helferDetailsAnzeigen()
	{
		try
		{
			String id = "";
			id = table.getValueAt(table.getSelectedRow(),0).toString();
			Dialog_HelferAnzeigen helferanzeigen = new Dialog_HelferAnzeigen(parentFrame,id);
			helferanzeigen.setVisible(true);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Bitte einen Helfer aus der Tabelle ausw‰hlen!","Titel", JOptionPane.INFORMATION_MESSAGE);
		}
		
	
	}
	
	private void aufgabenAnzeigen()
	{
		try
		{
			String name = "";
			name = (String)table.getValueAt(table.getSelectedRow(),2);
			name += " "+(String)table.getValueAt(table.getSelectedRow(),3);
			String id = table.getValueAt(table.getSelectedRow(),0).toString();
			Dialog_AufgabeHelfer aufgabenAnzeigen = new Dialog_AufgabeHelfer(parentFrame,id, name);
			aufgabenAnzeigen.setVisible(true);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Bitte einen Helfer aus der Tabelle ausw‰hlen!","Titel", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public JPanel HelferPanel()
	{
		return Helfer;
	}
	
	public void setFrame(JFrame Mainframe)
	{
		parentFrame = Mainframe;
	}
	

}
