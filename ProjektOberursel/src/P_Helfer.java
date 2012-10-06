import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

/*	Das Panel Helfer gibt dem Anwender die relevanten Helferdaten aus, lässt ihn einen neuen Helfer anlegen, bearbeiten und löschen
 *  und gibt ihm die Möglichkeit Helferdetails in einem separatem Dialogfenster einzusehen und Notizen hinzuzufügen. Desweiteren
 *  steht die Funktion "Mögliche Projekte für einen bestimmten Helfer suchen" zur Verfügung, die alle Projekte, die der Helfer auf Basis seiner 
 *  Fähigkeiten machen kann, herausfiltert und ihn einen Einsatz für den Helfer erzeugen lässt und die erstellten Einsätze anzeigt
 */

public class P_Helfer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		//Suche der Tabelle
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model) {
			//Überschreibt die Methode zur Sortierung der Spalten, da die Zeilen in der Table dann nicht mehr mit den Zeilen des Tablemodel übereinstimmen
			//Das Model enthält Zusatzinformationen zu Ids etc, die dann nicht mehr zur Zeile des Tables passen
			  @Override
			  public void toggleSortOrder(int column) {}};
	
        table.setRowSorter(sorter);
        
        JTableHeader hdr = (JTableHeader)table.getTableHeader();
        hdr.addMouseListener(new MouseAdapter() {
        public void mouseClicked (MouseEvent event) {

        }        
        });
        
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
		
		//Button zur Anzeige der Helferdetails im separatem Dialogfenster
		JButton btnHelferAnz = CS_ButtonDesign.buttonHelferAnz();
		panel_7.add(btnHelferAnz, "cell 0 0,growx");
		
		btnHelferAnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				helferDetailsAnzeigen();
			}
		});
		
		//Button zur Anzeige der möglichen Aufgaben für einen ausgewählten Helfer und zur direkten Erstellung eines Einsatzes
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
		
		//Button um einen neuen Helfer anzulegen
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
		
		//Button um einen Helfer zu bearbeiten
		JButton btnBearbeiten = CS_ButtonDesign.buttonBearbeiten();
		panel_7.add(btnBearbeiten, "cell 0 9");
		
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_HelferBearbeiten helferbearbeiten = new Dialog_HelferBearbeiten(parentFrame);
				helferbearbeiten.setVisible(true);
			}
		});
		
		//Button um einen Helfer zu löschen
		JButton btnNewButton = CS_ButtonDesign.buttonLoeschen();
		panel_7.add(btnNewButton, "cell 0 10");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_5, BorderLayout.SOUTH);
	
		

	}
	
	//Erstellt die Tabelle mit den relevanten Helferdaten
	public void tableBuild()
	{				
		table = new JTable();	
		//Erstellung des SQL und Durchführung der Datenbankanweisungen
		if(CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.helfersql(),false))
		{
			model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
			table.setModel(model);
			scrollPane.setViewportView(table);
			table.setBorder(new LineBorder(new Color(169, 169, 169)));
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.getTableHeader().setBackground(new Color(192, 192, 192));
			table.getColumnModel().getColumn(0).setHeaderValue("Eintrittsdatum");
			table.getColumnModel().getColumn(1).setHeaderValue("Anrede/Titel");
			table.getColumnModel().getColumn(2).setHeaderValue("Vorname");
			table.getColumnModel().getColumn(3).setHeaderValue("Nachname");
			table.getColumnModel().getColumn(4).setHeaderValue("Geschlecht");
			table.getColumnModel().getColumn(5).setHeaderValue("Straße");
			table.getColumnModel().getColumn(6).setHeaderValue("Postleitzahl");
			table.getColumnModel().getColumn(7).setHeaderValue("Wohnort");
			table.getColumnModel().getColumn(8).setHeaderValue("Geburtsdatum");
			table.getColumnModel().getColumn(9).setHeaderValue("Telefonnummer");
			table.getColumnModel().getColumn(10).setHeaderValue("Handynummer");
			table.getColumnModel().getColumn(11).setHeaderValue("EMail");
			//Macht die Spalte ID in der Table unsichtbar, im Model ist sie noch verfügbar!
			table.removeColumn(table.getColumnModel().getColumn(12));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//Spaltenbreite an Spalteninhalt anpassen
			CS_SpaltenBreite.autoResizeTable(table, true,10, false);
		}
		else
			JOptionPane.showMessageDialog(null,"Datenbankverbindung konnte nicht hergestellt werden!","Titel", JOptionPane.ERROR_MESSAGE);

	}
	
	//Übergibt die HelferID und das Parentframe an den aufzurufenden Dialog, der die Helferdetails anzeigt und die Angabe von Notizen ermöglicht 
	private void helferDetailsAnzeigen()
	{
		try
		{
			String id = "";	
			id = model.getValueAt(table.getSelectedRow(), 12).toString();
			//ParentFrame wird übergeben um Dialog modal zu setzen
			Dialog_HelferAnzeigen helferanzeigen = new Dialog_HelferAnzeigen(parentFrame,id);
			helferanzeigen.setVisible(true);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Bitte einen Helfer aus der Tabelle auswählen!","Titel", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	//Übergibt die HelferID und den Namen an das Dialogfenster zur Filterung der möglichen Aufgaben und zur Erstellung neuer Einsätze für den Helfer
	private void aufgabenAnzeigen()
	{
		try
		{
			String name = "";
			name = (String)table.getValueAt(table.getSelectedRow(),2);
			name += " "+(String)table.getValueAt(table.getSelectedRow(),3);
			String id = model.getValueAt(table.getSelectedRow(), 12).toString();
			Dialog_AufgabefuerHelfer aufgabenAnzeigen = new Dialog_AufgabefuerHelfer(parentFrame,id, name);
			aufgabenAnzeigen.setVisible(true);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Bitte einen Helfer aus der Tabelle auswählen!","Titel", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//liefert das erstelle Panel an das Mainframe, geht vermutlich schöner
	public JPanel HelferPanel()
	{
		return Helfer;
	}
	
	//liefert das ParentFrame zur Übergabe des Mainframe an ein Dialogfenster (wegen modal setzen)
	public void setFrame(JFrame Mainframe)
	{
		parentFrame = Mainframe;
	}
	

}
