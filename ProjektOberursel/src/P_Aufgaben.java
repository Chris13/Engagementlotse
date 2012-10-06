import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.miginfocom.swing.MigLayout;
/*
 * Das Panel Aufgaben beeinhaltet die relevanten Informationen zu den Aufgaben. Der Anwender kann Aufgaben hinzufügen, bearbeiten und löschen.
 * Desweiteren besteht die Möglichkeit den Aufgaben Fähigkeiten zuzuordnen oder zu entfernen
 */


public class P_Aufgaben extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel aufgaben;
	private JTable table;
	private JTextField textField;
	private JFrame parentFrame;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public P_Aufgaben() {
		setLayout(new BorderLayout(0, 0));
		
		aufgaben = new JPanel();
		add(aufgaben, BorderLayout.CENTER);
		aufgaben.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		aufgaben.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(3);
		panel_1.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images\\Aufgaben.jpg"));
		panel_1.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_1.add(horizontalStrut);
		
		JLabel lblHelfer = new JLabel("<html><u>Aufgaben</u></html>");
		lblHelfer.setHorizontalTextPosition(JLabel.CENTER);
		lblHelfer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblHelfer);
		
		JPanel panel_2 = new JPanel();
		aufgaben.add(panel_2, BorderLayout.CENTER);
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

		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(245, 245, 245));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		tableBuild();
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new MigLayout("", "[grow]", "[][][][][][][][grow][][][]"));
		
		//Suche innerhalb der Tabelle
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
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
		
		Component verticalStrut = Box.createVerticalStrut(50);
		panel_3.add(verticalStrut);
		
		//Aufruf des Dialogfensters zum Hinzufügen von Fähigkeiten zur gewählten Aufgabe
		JButton btnFaehigkeitzuAufgabe = CS_ButtonDesign.buttonAufgabenAnz();
		btnFaehigkeitzuAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Dialog_FaehigkeitzuAufgabe faehigkeitzuaufgabe = new Dialog_FaehigkeitzuAufgabe(parentFrame,model.getValueAt(table.getSelectedRow(), 2).toString(),table.getValueAt(table.getSelectedRow(), 0).toString());
					faehigkeitzuaufgabe.setVisible(true);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Bitte eine Aufgabe aus der Tabelle auswählen!","Titel", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		panel_7.add(btnFaehigkeitzuAufgabe, "cell 0 0,growx");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel_7.add(panel, "cell 0 7,grow");
		
		JButton btnAufgabeAnl = CS_ButtonDesign.buttonAnlegen();
		panel_7.add(btnAufgabeAnl, "cell 0 8");
		
		//Button für Aufgabe anlegen
		btnAufgabeAnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_AufgabeAnlegen aufgabeanlegen = new Dialog_AufgabeAnlegen(parentFrame);
				aufgabeanlegen.setVisible(true);
				aufgabeanlegen.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosed(WindowEvent e) {
		                tableBuild();
		            }
		        });
			}
		});
		
		//Button für Aufgabe bearbeiten
		JButton btnBearbeiten = CS_ButtonDesign.buttonBearbeiten();
		panel_7.add(btnBearbeiten, "cell 0 9");
		
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//Button für Aufgabe löschen
		JButton btnNewButton = CS_ButtonDesign.buttonLoeschen();
		panel_7.add(btnNewButton, "cell 0 10");

		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_5, BorderLayout.SOUTH);
	
		

	}
	
	//Erstellt die Tabelle mit den relevanten Aufgabedaten
	private void tableBuild()
	{
		table = new JTable();
		//Erstellung des SQL und Durchführung der Datenbankanweisungen
		if(CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.aufgabensql(),false))
		{
			model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
			table.setModel(model);
			scrollPane.setViewportView(table);
			table.setBorder(new LineBorder(new Color(169, 169, 169)));
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.getTableHeader().setBackground(new Color(192, 192, 192));
			table.getColumnModel().getColumn(0).setHeaderValue("Aufgabe");
			table.getColumnModel().getColumn(1).setHeaderValue("Beschreibung");
			table.removeColumn(table.getColumnModel().getColumn(2));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//Spaltenbreite an Spalteninhalt anpassen
			CS_SpaltenBreite.autoResizeTable(table, true,10, false);
		}
		else
			JOptionPane.showMessageDialog(null,"Datenbankverbindung konnte nicht hergestellt werden!","Titel", JOptionPane.ERROR_MESSAGE);
	}
	
	//Liefert das Panel an den Mainframe
	public JPanel AufgabenPanel()
	{
		return aufgaben;
	}
	
	//liefert das ParentFrame zur Übergabe des Mainframe an ein Dialogfenster (wegen modal setzen)
	public void setFrame(JFrame Mainframe)
	{
		parentFrame = Mainframe;
	}


}
