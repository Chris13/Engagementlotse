import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;


public class Dialog_AufgabefuerHelfer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String helferName;
	private DefaultTableModel mglEinsatzModel;
	private DefaultTableModel erstEinsatzModel;
	private String id;
	private JTable erstEinsatz;
	private JTable mglEinsatz;
	private JScrollPane scrollPane;
	private ArrayList<ArrayList<String>> mglEinsatzzeit = new  ArrayList<ArrayList<String>>();
	private ArrayList<String> notizen = new  ArrayList<String>();
	private CS_JTableNotizButtonEditor editor;
	private DefaultTableModel model;
	private Map<String, Integer> dictionary;
	private JComboBox cbFaehigkeiten;
	
	public ArrayList<ArrayList<String>> getmglEinsatzzeit(){
		return mglEinsatzzeit;
	}	

	public JTable getmglEinsatz() {
		return mglEinsatz;
	}
	
	public ArrayList<String> getnotizen(){
		return notizen;
	}	
	
	public String getErstEinsatzRow()
	{
		return erstEinsatzModel.getValueAt(erstEinsatz.getSelectedRow(), 7).toString();
	}
	
	public Dialog_AufgabefuerHelfer(JFrame parent,String hId, String hName) {
		super(parent,true);
		id = hId;
		helferName = hName;
		setBounds(100, 100, 1160, 600);
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
										int result = JOptionPane.showConfirmDialog(null,"Wollen Sie den Einsatz wirklich löschen?","Bestätigung notwendig",JOptionPane.YES_NO_OPTION);
										if(result == JOptionPane.YES_NO_OPTION)
										{
											if(!einsatzloeschen())
												JOptionPane.showMessageDialog(null,"Einsatz konnte nicht gelöscht werden!","Titel", JOptionPane.ERROR_MESSAGE);
											else
												JOptionPane.showMessageDialog(null,"Einsatz wurde gelöscht!","Titel", JOptionPane.INFORMATION_MESSAGE);
										}
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
									btnSpeichern = CS_ButtonDesign.buttonLarge();
									btnSpeichern.setText("Einsatz sichern"); 
									btnSpeichern.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											if(!einsatzErstellen())
												JOptionPane.showMessageDialog(null,"Mindestens ein Einsatz konnte nicht erstellt werden, bitte prüfen Sie ihre Angaben!","Titel", JOptionPane.ERROR_MESSAGE);
											else
											{
												JOptionPane.showMessageDialog(null,"Einsatz wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
												einsaetzeAnzeigen();	
											}
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
								mglEinsatz = new JTable();
								tableBuild();
								scrollPane.setViewportView(mglEinsatz);
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
		if(CS_SqlAbfragen.einsatzfuerhelferdeletesql(erstEinsatzModel.getValueAt(erstEinsatz.getSelectedRow(), 7).toString()))
		{
			einsaetzeAnzeigen();
			return true;
		}
		else
			return false;
	}
	
	private void einsaetzeAnzeigen()
	{
		erstEinsatz = new JTable();
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.einsatzfuerhelferanzeigensql(id),true);
		erstEinsatzModel = new DefaultTableModel();
		erstEinsatzModel = CS_DataBaseConnect.getModel();	
		erstEinsatz.setModel(erstEinsatzModel);	
		scrollPane.setViewportView(erstEinsatz);
		erstEinsatz.getTableHeader().setBackground(new Color(192, 192, 192));
		erstEinsatz.getColumnModel().getColumn(0).setHeaderValue("Projekt");
		erstEinsatz.getColumnModel().getColumn(1).setHeaderValue("Aufgabe");
		erstEinsatz.getColumnModel().getColumn(2).setHeaderValue("Träger");
		erstEinsatz.getColumnModel().getColumn(3).setHeaderValue("EinsatzBeginn");
		erstEinsatz.getColumnModel().getColumn(4).setHeaderValue("EinsatzEnde");	
		erstEinsatz.getColumnModel().getColumn(5).setHeaderValue("Uhrzeit");
		erstEinsatz.getColumnModel().getColumn(5).setCellRenderer(new CS_JTableUhrzeitButtonRenderer());
		CS_JTableUhrzeitButtonEditor editor = new CS_JTableUhrzeitButtonEditor(new JCheckBox(), Dialog_AufgabefuerHelfer.this);
		editor.setDialog(Dialog_AufgabefuerHelfer.this);
		erstEinsatz.getColumnModel().getColumn(5).setCellEditor(editor);
		erstEinsatz.getColumnModel().getColumn(6).setHeaderValue("Notiz");
		erstEinsatz.removeColumn(erstEinsatz.getColumnModel().getColumn(7));
		
		erstEinsatz.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		//Spaltenbreite an Spalteninhalt anpassen
		CS_SpaltenBreite.autoResizeTable(erstEinsatz, true, 5, false, true);	

	}
	
	private boolean einsatzErstellen()
	{	
			ArrayList<ArrayList<String>> uebergabeWerte = new ArrayList<ArrayList<String>>();
			boolean anlegenOK = true;
			for(int i = 0; i < mglEinsatzModel.getRowCount(); i++)
			{
				try
				{
					if(mglEinsatzModel.getValueAt(i, 7) != null)
					{
						if((Boolean) mglEinsatzModel.getValueAt(i, 7))
						{	
				
							ArrayList<String> tmp = new ArrayList<String>();
							uebergabeWerte = new ArrayList<ArrayList<String>>();

							tmp.add("aufgabe.Aufgabe_id");
							tmp.add(mglEinsatzModel.getValueAt(i, 9).toString());
							uebergabeWerte.add(tmp);
							
							tmp = new ArrayList<String>();	
							tmp.add("Projekt.idProjekt");
							tmp.add(mglEinsatzModel.getValueAt(i, 8).toString());
							uebergabeWerte.add(tmp);
							
							tmp = new ArrayList<String>();
							tmp.add("Helfer_natPerson_Person_person_id");
							tmp.add(id);
							uebergabeWerte.add(tmp);
										
							tmp = new ArrayList<String>();
							tmp.add("EinsatzBeginn");
							if((String) mglEinsatzModel.getValueAt(i, 3) == null)
								tmp.add("''");
							else
								tmp.add("'"+(String) mglEinsatzModel.getValueAt(i, 3)+"'");
							uebergabeWerte.add(tmp);
							
							tmp = new ArrayList<String>();
							tmp.add("EinsatzEnde");
							if((String) mglEinsatzModel.getValueAt(i, 4) == null)
								tmp.add("''");
							else	
								tmp.add("'"+(String) mglEinsatzModel.getValueAt(i, 4)+"'");
							uebergabeWerte.add(tmp);
							
							tmp = new ArrayList<String>();
							tmp.add("Einsatz.Traeger_Person_person_id");
							
							if((dictionary.containsKey(mglEinsatzModel.getValueAt(i, 2))))
							{
								tmp.add(dictionary.get(mglEinsatzModel.getValueAt(i, 2)).toString());
							}
							uebergabeWerte.add(tmp);

							if(CS_SqlAbfragen.einsatzanlegensql(uebergabeWerte))
							{	
								if (CS_DataBaseConnect.dbQuery("SELECT max(Einsatz_id) FROM Einsatz",false))
								{
									DefaultTableModel mdlEinsatzID = new DefaultTableModel();
									mdlEinsatzID = CS_DataBaseConnect.getModel();
									uebergabeWerte = new ArrayList<ArrayList<String>>();
									tmp = new ArrayList<String>();
									tmp = mglEinsatzzeit.get(i);
									uebergabeWerte.add(tmp);
									CS_SqlAbfragen.einsatzzeitanlegensql(uebergabeWerte,mdlEinsatzID.getValueAt(0, 0).toString());
													
								}
								else 
									JOptionPane.showMessageDialog(null,"Einsatzzeit konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);
							}
							else
								anlegenOK = false;	
						}
					}	
				}
				catch(Exception ex){
					System.out.println(ex.toString());
				}					
			}			
			return anlegenOK;
			
	}
	
	private void traegerermitteln()
	{

		if(CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.traegerfuercomboboxnsql(),false))
		{
			cbFaehigkeiten = new JComboBox();
			cbFaehigkeiten.addItem("");
			model = CS_DataBaseConnect.getModel();
			dictionary = new HashMap<String, Integer>();
			for(int i = 0; i< model.getRowCount(); i++)
			{			
				cbFaehigkeiten.addItem(model.getValueAt(i, 0));
				int t = Integer.parseInt(model.getValueAt(i, 1).toString());
				dictionary.put(model.getValueAt(i, 0).toString(), t);
				
			}
		}	
	}
	
	private void tableBuild()
	{		
		traegerermitteln();
		mglEinsatz = new JTable();
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.aufgabenHelfersql(id),true);
		mglEinsatzModel = new DefaultTableModel();
	
		mglEinsatzModel = CS_DataBaseConnect.getModel();
		mglEinsatz.setModel(mglEinsatzModel);
		mglEinsatz.setBorder(new LineBorder(new Color(169, 169, 169)));
		mglEinsatz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mglEinsatz.getTableHeader().setBackground(new Color(192, 192, 192));		
		mglEinsatz.getColumnModel().getColumn(0).setHeaderValue("Projekt");				
		mglEinsatz.getColumnModel().getColumn(1).setHeaderValue("Aufgabe");
		mglEinsatz.getColumnModel().getColumn(2).setHeaderValue("Träger");
		mglEinsatz.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cbFaehigkeiten));
		mglEinsatz.getColumnModel().getColumn(3).setHeaderValue("Beginn Datum");
		mglEinsatz.getColumnModel().getColumn(4).setHeaderValue("Ende Datum");
		mglEinsatz.getColumnModel().getColumn(5).setHeaderValue("Einsatzzeit");
		mglEinsatz.getColumnModel().getColumn(5).setCellEditor(new CS_JComboButtonCellEditor(Dialog_AufgabefuerHelfer.this));
		mglEinsatz.getColumnModel().getColumn(6).setHeaderValue("Notiz");
		mglEinsatz.getColumnModel().getColumn(6).setCellRenderer(new CS_JTableNotizButtonRenderer());
		editor = new CS_JTableNotizButtonEditor(new JCheckBox());
		editor.setDialog(Dialog_AufgabefuerHelfer.this);
		mglEinsatz.getColumnModel().getColumn(6).setCellEditor(editor);
		mglEinsatz.getColumnModel().getColumn(7).setHeaderValue("Anlegen");
		mglEinsatz.getColumnModel().getColumn(3).setCellEditor(new CS_JDateChooserCellEditor());
		mglEinsatz.getColumnModel().getColumn(4).setCellEditor(new CS_JDateChooserCellEditor());
		mglEinsatz.getColumnModel().getColumn(7).setCellRenderer(mglEinsatz.getDefaultRenderer(Boolean.class));
		mglEinsatz.getColumnModel().getColumn(7).setCellEditor(mglEinsatz.getDefaultEditor(Boolean.class));   
		mglEinsatz.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		//Spaltenbreite an Spalteninhalt anpassen
		CS_SpaltenBreite.autoResizeTable(mglEinsatz, true,10,false);	


		mglEinsatz.getColumnModel().getColumn(5).setPreferredWidth(180);
		mglEinsatz.getColumnModel().getColumn(2).setPreferredWidth(180);
		
		for(int i=0;i<mglEinsatz.getRowCount();i++){		
			mglEinsatzzeit.add(new ArrayList<String>());
		}
		
		
		mglEinsatz.removeColumn(mglEinsatz.getColumnModel().getColumn(9));
		mglEinsatz.removeColumn(mglEinsatz.getColumnModel().getColumn(8));

		
		
	}
	

}
