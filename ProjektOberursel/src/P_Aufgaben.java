import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;


public class P_Aufgaben extends JPanel {
	private JPanel aufgaben;
	private JTable table;
	private JTextField textField;
	private JFrame parentFrame;
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

		JButton btnStart =CS_ButtonDesign.buttonMedium();
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setText("Start");
		panel_3.add(btnStart);
		
		Component verticalStrut = Box.createVerticalStrut(50);
		panel_3.add(verticalStrut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(245, 245, 245));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.aufgabensql());
		DefaultTableModel model = CS_DataBaseConnect.getModel();
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(169, 169, 169)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.getTableHeader().setBackground(new Color(192, 192, 192));
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		//Spaltenbreite an Spalteninhalt anpassen
		CS_SpaltenBreite.autoResizeTable(table, true,10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 224));
		panel_2.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new MigLayout("", "[grow]", "[][][][][][][][grow][][][]"));
		
		JButton btnAufgabeAnz = CS_ButtonDesign.buttonAufgabenAnz();
		btnAufgabeAnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_HelferAufgabe helferfueraufgabe = new Dialog_HelferAufgabe(parentFrame,"nochnichts","nochnichts");
				helferfueraufgabe.setVisible(true);
			}
		});
		panel_7.add(btnAufgabeAnz, "cell 0 0,growx");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel_7.add(panel, "cell 0 7,grow");
		
		JButton btnAufgabeAnl = CS_ButtonDesign.buttonAnlegen();
		panel_7.add(btnAufgabeAnl, "cell 0 8");
		
		btnAufgabeAnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton btnBearbeiten = CS_ButtonDesign.buttonBearbeiten();
		panel_7.add(btnBearbeiten, "cell 0 9");
		
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
	public JPanel AufgabenPanel()
	{
		return aufgaben;
	}
	
	public void setFrame(JFrame Mainframe)
	{
		parentFrame = Mainframe;
	}


}
