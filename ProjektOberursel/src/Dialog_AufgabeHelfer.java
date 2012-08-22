import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Console;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JList;
import com.toedter.calendar.JDateChooser;
import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;


public class Dialog_AufgabeHelfer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String helferName;
	private DefaultTableModel model;
	private String id;
	private JTable table;
	private JTable table2;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_AufgabeHelfer dialog = new Dialog_AufgabeHelfer(new JFrame(), "id","Name");
			dialog.setModal(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public Dialog_AufgabeHelfer(JFrame parent,String hId, String hName) {
		super(parent,true);
		id = hId;
		helferName = hName;
		setBounds(100, 100, 850, 600);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 224));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("Images\\Blume_Logo_small2.gif"));
				panel.add(label);
			}
			{
				JLabel lblNewLabel = new JLabel("<html><u>Aufgabenliste</u></html>");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_5 = new JPanel();
				panel_5.setBackground(new Color(255, 215, 0));
				panel.add(panel_5, BorderLayout.NORTH);
				panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Jenny\\Desktop\\Blume_Logo_small2.gif"));
					panel_5.add(lblNewLabel_2);
				}
			
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JSplitPane splitPane = new JSplitPane();
					splitPane.setDividerLocation(250);
					splitPane.setEnabled(true);
					splitPane.setMinimumSize(new Dimension(300,300));
					splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
					
					panel_1.add(splitPane);
					{
						JPanel panel_2 = new JPanel();
						splitPane.setRightComponent(panel_2);
						panel_2.setLayout(new BorderLayout(0, 0));
						{
							JToolBar toolBar = new JToolBar();
							toolBar.setBackground(new Color(245, 245, 245));
							panel_2.add(toolBar, BorderLayout.NORTH);
							{
								JLabel lblAngelegteEinstze = new JLabel("Angelegte Eins\u00E4tze:");
								lblAngelegteEinstze.setFont(new Font("Tahoma", Font.PLAIN, 16));
								toolBar.add(lblAngelegteEinstze);
							}
							toolBar.add(Box.createHorizontalGlue());
							{
								JButton btnEinsatzLschen = new JButton("Einsatz l\u00F6schen");
								btnEinsatzLschen.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if(!einsatzloeschen());
									}
								});
								btnEinsatzLschen.setFont(new Font("Tahoma", Font.PLAIN, 16));
								toolBar.add(btnEinsatzLschen);
							}
						}
						{
							scrollPane = new JScrollPane();
							panel_2.add(scrollPane, BorderLayout.CENTER);
							{
													
								einsaetzeAnzeigen();
							}
						}
					}
					{
						JPanel panel_2 = new JPanel();
						splitPane.setLeftComponent(panel_2);
						panel_2.setLayout(new BorderLayout(0, 0));
						{
							JPanel panel_3 = new JPanel();
							panel_3.setBackground(new Color(192, 192, 192));
							panel_2.add(panel_3, BorderLayout.NORTH);
							panel_3.setLayout(new BorderLayout(0, 0));
							{
								JToolBar toolBar = new JToolBar();
								{
								JLabel lblNewLabel_1 = new JLabel(helferName);
								toolBar.add(lblNewLabel_1);
								lblNewLabel_1.setBackground(SystemColor.activeCaption);
								lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
								}
								toolBar.add(Box.createHorizontalGlue());
								toolBar.setBackground(new Color(192, 192, 192));
								panel_3.add(toolBar);
								{
									JButton btnSpeichern = new JButton();
									btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 16));
									btnSpeichern.setBorder(null);
									//btnSpeichern.setBackground(new Color(255, 215, 0));
									btnSpeichern = CS_ButtonDesign.buttonLarge();
									btnSpeichern.setText("Einsatz sichern");
									//btnSpeichern.setContentAreaFilled( true );  
									btnSpeichern.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											if(!einsatzErstellen())
												JOptionPane.showMessageDialog(null,"Mindestens ein Einsatz konnte nicht erstellt werden, bitte prüfen Sie ihre Datumseingabe!","Titel", JOptionPane.ERROR_MESSAGE);
										}
									});
									toolBar.add(btnSpeichern);
								}
							}
						}
						{
							JScrollPane scrollPane = new JScrollPane();
							panel_2.add(scrollPane, BorderLayout.CENTER);
							{
								table2 = new JTable();
								tableBuild();
								scrollPane.setViewportView(table2);
								scrollPane.getViewport().setBackground(new Color(245, 245, 245));
							}
						}
					}
				}
			}
		
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(245, 245, 245));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton cancelButton = new JButton("OK");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							dispose();					
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	
	private boolean einsatzloeschen()
	{
		CS_SqlAbfragen.einsatzfuerhelferdeletesql();
		return true;
	}
	
	private void einsaetzeAnzeigen()
	{
		table = new JTable();
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.einsatzfuerhelferanzeigensql(id));
		model = new DefaultTableModel();
		model = CS_DataBaseConnect.getModel();	
		table.setModel(model);	
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setHeaderValue("Beginn");
		table.getColumnModel().getColumn(1).setHeaderValue("Ende");
		table.getColumnModel().getColumn(2).setHeaderValue("Aufgabe");
		table.getColumnModel().getColumn(3).setHeaderValue("Fähigkeit");
		table.getColumnModel().getColumn(4).setHeaderValue("ID");
		table.getColumnModel().getColumn(4).setMaxWidth(30);
		table.getColumnModel().getColumn(5).setHeaderValue("Träger");
		
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(true);
		table.setShowGrid(false);
	}
	
	private boolean einsatzErstellen()
	{	
			ArrayList<String> uebergabeWerte = new ArrayList<String>();
			boolean anlegenOK = true;
			for(int i = 0; i < table2.getRowCount(); i++)
			{
				try
				{
					if(table2.getValueAt(i, 6) != null)
					{
						if((Boolean) table2.getValueAt(i, 6))
						{
							if(table2.getValueAt(i, 4)!=null || table2.getValueAt(i, 5)!=null)
							{
								uebergabeWerte = new ArrayList<String>();
								uebergabeWerte.add(table2.getValueAt(i, 0).toString());
								uebergabeWerte.add("'"+table2.getValueAt(i, 4).toString()+"'");
								uebergabeWerte.add("'"+table2.getValueAt(i, 5).toString()+"'");
								uebergabeWerte.add(id);
								if(CS_SqlAbfragen.einsatzanlegensql(uebergabeWerte))
								{
									JOptionPane.showMessageDialog(null,"Einsatz wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
									einsaetzeAnzeigen();
								}
								else
								{	
									anlegenOK = false;
								}
							}
							else
							{
								anlegenOK = false;
							}
						}
					}
	
					
				}
				catch(Exception ex){}					
			}
			
			return anlegenOK;
			
	}
	
	
	private void tableBuild()
	{		
		table2 = new JTable();
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.aufgabenHelfersql(id));
		model = new DefaultTableModel();
		model = CS_DataBaseConnect.getModel();

		table2.setModel(model);
		table2.setBorder(new LineBorder(new Color(169, 169, 169)));
		table2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table2.getTableHeader().setBackground(new Color(192, 192, 192));
		table2.getColumnModel().getColumn(0).setHeaderValue("Aufgaben ID");
		table2.getColumnModel().getColumn(1).setHeaderValue("Aufgaben Name");
		table2.getColumnModel().getColumn(2).setHeaderValue("Beschreibung");
		table2.getColumnModel().getColumn(3).setHeaderValue("Träger");
		table2.getColumnModel().getColumn(4).setHeaderValue("Beginn Datum");
		table2.getColumnModel().getColumn(5).setHeaderValue("Ende Datum");
		table2.getColumnModel().getColumn(6).setHeaderValue("Einsatz anlegen");
		table2.getColumnModel().getColumn(4).setCellEditor(new CS_JDateChooserCellEditor());
		table2.getColumnModel().getColumn(5).setCellEditor(new CS_JDateChooserCellEditor());
		table2.getColumnModel().getColumn(6).setCellRenderer(table2.getDefaultRenderer(Boolean.class));
		table2.getColumnModel().getColumn(6).setCellEditor(table2.getDefaultEditor(Boolean.class));   

		table2.setAutoResizeMode(table2.AUTO_RESIZE_OFF);
		//Spaltenbreite an Spalteninhalt anpassen
		CS_SpaltenBreite.autoResizeTable(table2, true,10);

		

	


		
	}

}
