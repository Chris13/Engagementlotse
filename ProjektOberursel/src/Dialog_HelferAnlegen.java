import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JList;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import com.toedter.calendar.JDateChooser;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;


public class Dialog_HelferAnlegen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtVName;
	private JTextField txtNName;
	private JTextField txtStrasse;
	private JTextField txtPLZ;
	private JTextField txtWohnort;
	private JTextField txtHandyNr;
	private JTextField txtEMail;
	private JTextField txtTelefonNr;
	private JTextField txtTitel;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser2;
	private JComboBox cbFaehigkeiten;
	private JList listFaehigkeiten;
	private DefaultListModel tmp;
	private JButton btnX;
	private DefaultTableModel model;
	private Map<String, Integer> dictionary;
	private JCheckBox chckbxWeiblich;
	private JCheckBox chckbxMnnlich;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_HelferAnlegen dialog = new Dialog_HelferAnlegen(new JFrame()); 
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	  public void actionPerformed(ActionEvent e) {
		    setVisible(false); 
		    dispose(); 
		  }

	/**
	 * Create the dialog.
	 */
	public Dialog_HelferAnlegen(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 602, 700);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout(0, 0));
						{
							JScrollPane scrollPane = new JScrollPane();
							getContentPane().add(scrollPane, BorderLayout.CENTER);
							scrollPane.setViewportView(contentPanel);
						}
						//getContentPane().add(contentPanel, BorderLayout.CENTER);
						//panel.add(contentPanel);
							
						contentPanel.setBackground(new Color(245, 245, 245));
						contentPanel.setBorder(null);
						contentPanel.setLayout(new MigLayout("", "[111.00][126.00,grow][][126.00,grow][][-248.00][][grow]", "[][][][][][][][][][][][][][][][29.00][93.00]"));
					
						{
							JLabel lblTitel = new JLabel("Titel:");
							lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblTitel, "cell 0 0,growx");
						}
						{
							txtTitel = new JTextField();
							txtTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtTitel, "cell 1 0 3 1,growx");
							txtTitel.setColumns(10);
						}
						{
							JLabel lblVorname = new JLabel("Vorname:");
							lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblVorname, "cell 0 1,growx");
						}
						{
							txtVName = new JTextField();
							txtVName.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtVName, "cell 1 1 3 1,growx");
							txtVName.setColumns(10);
						}
						{
							JLabel lblNachname = new JLabel("Nachname:");
							lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblNachname, "cell 0 2,growx");
						}
						{
							txtNName = new JTextField();
							txtNName.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtNName, "cell 1 2 3 1,growx");
							txtNName.setColumns(10);
						}
						{
							JLabel lblGeburtsdatum = new JLabel("Geburtsdatum:");
							lblGeburtsdatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblGeburtsdatum, "cell 0 3,growx");
						}
						{
							dateChooser = new JDateChooser();
							dateChooser.setDateFormatString("yyyy-MM-dd");
							dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
							dateChooser.setBorder(null);
							contentPanel.add(dateChooser, "flowx,cell 1 3,grow");
						}
						{
							JLabel lblGeschlecht = new JLabel("Geschlecht:");
							lblGeschlecht.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblGeschlecht, "cell 0 4,growx");
						}
						chckbxWeiblich = new JCheckBox("weiblich");
						chckbxWeiblich.setBackground(new Color(245, 245, 245));
						chckbxWeiblich.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if(chckbxMnnlich.isSelected())
									chckbxMnnlich.setSelected(false);
							}
						});
						contentPanel.add(chckbxWeiblich, "cell 1 4");
						chckbxMnnlich = new JCheckBox("m\u00E4nnlich");
						chckbxMnnlich.setBackground(new Color(245, 245, 245));
						chckbxMnnlich.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if(chckbxWeiblich.isSelected())
									chckbxWeiblich.setSelected(false);
							}
						});
						contentPanel.add(chckbxMnnlich, "cell 2 4");
						{
							Component verticalStrut = Box.createVerticalStrut(20);
							contentPanel.add(verticalStrut, "cell 0 5");
						}
						{
							JLabel lblStrae = new JLabel("Stra\u00DFe:");
							lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblStrae, "cell 0 6,growx");
						}
						{
							txtStrasse = new JTextField();
							txtStrasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtStrasse, "cell 1 6 3 1,growx");
							txtStrasse.setColumns(10);
						}
						{
							JLabel lblPostleitzahl = new JLabel("PLZ:");
							lblPostleitzahl.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblPostleitzahl, "cell 0 7,growx");
						}
						{
							txtPLZ = new JTextField(5);
							txtPLZ.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtPLZ, "cell 1 7 3 1,growx");
							txtPLZ.setColumns(10);
						}
						{
							JLabel lblWohnort = new JLabel("Wohnort:");
							lblWohnort.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblWohnort, "cell 0 8,growx");
						}
						{
							txtWohnort = new JTextField();
							txtWohnort.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtWohnort, "cell 1 8 3 1,growx");
							txtWohnort.setColumns(10);
						}
						{
							Component verticalStrut = Box.createVerticalStrut(20);
							contentPanel.add(verticalStrut, "cell 0 9");
						}
						{
							JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
							lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblTelefonnummer, "cell 0 10,growx");
						}
						{
							txtTelefonNr = new JTextField();
							txtTelefonNr.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtTelefonNr, "cell 1 10 3 1,growx");
							txtTelefonNr.setColumns(10);
						}
						{
							JLabel lblHandynummer = new JLabel("Handynummer:");
							lblHandynummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblHandynummer, "cell 0 11,growx");
						}
						{
							txtHandyNr = new JTextField();
							txtHandyNr.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtHandyNr, "flowy,cell 1 11 3 1,growx");
							txtHandyNr.setColumns(10);
						}
						{
							JLabel lblEmailAdresse = new JLabel("EMail Adresse:");
							lblEmailAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblEmailAdresse, "cell 0 12,growx");
						}
						{
							txtEMail = new JTextField();
							txtEMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(txtEMail, "flowy,cell 1 12 3 1,growx");
							txtEMail.setColumns(10);
						}
						{
							JLabel lblNewLabel = new JLabel("Eintrittsdatum:");
							lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(lblNewLabel, "cell 0 13,growx");
						}
						{
							dateChooser2 = new JDateChooser();
							dateChooser2.setDateFormatString("yyyy-MM-dd");
							contentPanel.add(dateChooser2, "flowx,cell 1 13,growx");
							
						}
						{
							JLabel label = new JLabel("F\u00E4higkeiten:");
							label.setFont(new Font("Tahoma", Font.PLAIN, 15));
							contentPanel.add(label, "cell 0 15");
						}
						{
							cbFaehigkeiten = new JComboBox();
							cbFaehigkeiten.setFont(new Font("Tahoma", Font.PLAIN, 15));
							cbFaehigkeiten.setBackground(new Color(245, 245, 245));
							contentPanel.add(cbFaehigkeiten, "cell 1 15 3 1,growx,aligny center");
						}
						{
							JPanel panel_1 = new JPanel();
							contentPanel.add(panel_1, "cell 4 15,growx,aligny center");
							panel_1.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
							{
								JButton btnFaehigkeitAdd = new JButton("+");
								panel_1.add(btnFaehigkeitAdd);
								
								btnFaehigkeitAdd.addActionListener(new ActionListener() {
				                public void actionPerformed(ActionEvent arg0) {
				                	tmp = (DefaultListModel) listFaehigkeiten.getModel();
				                    if(!tmp.contains(cbFaehigkeiten.getItemAt(cbFaehigkeiten.getSelectedIndex())))
				                    tmp.addElement(cbFaehigkeiten.getItemAt(cbFaehigkeiten.getSelectedIndex()));
				                    
				                    btnX.setEnabled(true);                 
				                }
				            });
				        }
						}
						JScrollPane scrollPane_1 = new JScrollPane();
						contentPanel.add(scrollPane_1, "cell 1 16 3 22,grow");
						{
			            listFaehigkeiten = new JList();
			            scrollPane_1.setViewportView(listFaehigkeiten);
			            listFaehigkeiten.setModel(new DefaultListModel());
			            listFaehigkeiten.setFont(new Font("Tahoma", Font.PLAIN, 15));
			        }
						{
							JPanel panel_1 = new JPanel();
							contentPanel.add(panel_1, "cell 4 16,growx,aligny top");
							panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
							{
								btnX = new JButton("X");
								btnX.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try{
										  int index = listFaehigkeiten.getSelectedIndex();
										    tmp.remove(index);

										    int size = tmp.getSize();

										    if (size == 0) { //Nobody's left, disable firing.
										        btnX.setEnabled(false);

										    } else { //Select an index.
										        if (index == tmp.getSize()) {
										            //removed item in last position
										            index--;
										        }

										        listFaehigkeiten.setSelectedIndex(index);
										        listFaehigkeiten.ensureIndexIsVisible(index);
										    }
										}
										catch(Exception ex)
										{
											
										}
									}
									
									
								});
								panel_1.add(btnX);
							}
						}
		{
		}
		{
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(245, 245, 245));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton button = new JButton("Speichern");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int result;
						result = JOptionPane.showConfirmDialog(null,"Wollen Sie die Eingaben wirklich speichern?","Bestätigung notwendig",JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_NO_OPTION)
						{
							angabenUebergeben();
							dispose();
						}						
					}

				});
				button.setFont(new Font("Tahoma", Font.PLAIN, 15));
				buttonPane.add(button);
				button.setActionCommand("Speichern");
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setBackground(new Color(230, 230, 250));
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon("Images\\Blume_Logo_small2.gif"));
					panel_1.add(label);
				}
				{
					JLabel lblHelfer = new JLabel("<html><u>Helfer anlegen</u></html>");
					panel_1.add(lblHelfer);
					lblHelfer.setFont(new Font("Tahoma", Font.PLAIN, 25));
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(255, 215, 0));
				panel.add(panel_1, BorderLayout.SOUTH);
			}
		}
		
		faehigkeitenLaden();
	}
	
	private void faehigkeitenLaden()
	{
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.faehigkeitenfuercomboboxsql(),false);
		model = CS_DataBaseConnect.getModel();
		dictionary = new HashMap<String, Integer>();

		for(int i = 0; i< model.getRowCount(); i++)
		{			
			cbFaehigkeiten.addItem(model.getValueAt(i, 0));
			int t = Integer.parseInt(model.getValueAt(i, 1).toString());
			dictionary.put(model.getValueAt(i, 0).toString(), t);
			
		}
		
		

	}

	private void angabenUebergeben()
	{
		ArrayList<String> tmp = new ArrayList<String>();
		ArrayList<ArrayList<String>> helferWerte = new ArrayList<ArrayList<String>>();
		int zaehler = 0;
		
		tmp = new ArrayList<String>();
		tmp.add("telefonnr");
		tmp.add("'"+txtTelefonNr.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("strasse");
		tmp.add("'"+txtStrasse.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("handyNr");
		tmp.add("'"+txtHandyNr.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("eMailAdresse");
		tmp.add("'"+txtEMail.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("PLZ");
		tmp.add(txtPLZ.getText());
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("Ort");
		tmp.add("'"+txtWohnort.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("vname");
		tmp.add("'"+txtVName.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("natPerson.titel");
		tmp.add("'"+txtTitel.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("nachname");
		tmp.add("'"+txtNName.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("geburtsdatum");
		tmp.add("'"+((JTextField)dateChooser.getDateEditor().getUiComponent()).getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("geschlecht");
		if(chckbxWeiblich.isSelected() || chckbxMnnlich.isSelected())
		{
		if(chckbxWeiblich.isSelected())
			tmp.add("'w'");
		if(chckbxMnnlich.isSelected())
			tmp.add("'m'");
		}
		else
			tmp.add("''");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("eintrittsdatum");
		tmp.add("'"+((JTextField)dateChooser2.getDateEditor().getUiComponent()).getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		for(int i = 0; i < listFaehigkeiten.getModel().getSize(); i++)
		{
			if((dictionary.containsKey(listFaehigkeiten.getModel().getElementAt(i))))
			{
				tmp = new ArrayList<String>();
				tmp.add("helfer_faehigkeit_zuordnung.faehigkeit_id");
				tmp.add(dictionary.get(listFaehigkeiten.getModel().getElementAt(i)).toString());
				helferWerte.add(zaehler, tmp);
				zaehler++;
			}			
		}
	
		if(CS_SqlAbfragen.helferanlegensql(helferWerte))
			JOptionPane.showMessageDialog(null,"Helfer wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Helfer konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);
			
	}

}
