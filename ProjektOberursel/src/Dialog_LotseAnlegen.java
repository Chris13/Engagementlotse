import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.Box;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Dialog_LotseAnlegen extends JDialog {

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
	private JCheckBox chckbxWeiblich;
	private JCheckBox chckbxMnnlich;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_LotseAnlegen dialog = new Dialog_LotseAnlegen(new JFrame()); 
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
	public Dialog_LotseAnlegen(JFrame parent) {
		super(parent, true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
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
						contentPanel.setLayout(new MigLayout("", "[111.00,grow][126.00,grow][][126.00,grow][][-248.00][][grow]", "[][][][][][][][][][][][][][][][grow][29.00][][grow][][93.00]"));
					
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
							Component verticalStrut = Box.createVerticalStrut(20);
							contentPanel.add(verticalStrut, "cell 0 14");
						}
						{
							JPanel panel = new JPanel();
							panel.setBackground(new Color(169, 169, 169));
							contentPanel.add(panel, "cell 0 15 8 1,grow");
						}
						{
							JLabel lblIstHelfer = new JLabel("Helfer:");
							lblIstHelfer.setFont(new Font("Tahoma", Font.PLAIN, 16));
							contentPanel.add(lblIstHelfer, "cell 0 16");
						}
						{
							JCheckBox checkBox = new JCheckBox("");
							contentPanel.add(checkBox, "cell 1 16");
						}
						{
							JLabel lblAdmin = new JLabel("Admin:");
							lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
							contentPanel.add(lblAdmin, "cell 0 17");
						}
						{
							JCheckBox chckbxNewCheckBox = new JCheckBox("");
							contentPanel.add(chckbxNewCheckBox, "cell 1 17");
						}
						{
							JPanel panel = new JPanel();
							panel.setBackground(new Color(169, 169, 169));
							contentPanel.add(panel, "cell 0 18 8 1,grow");
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
					JLabel lblHelfer = new JLabel("<html><u>Lotse anlegen</u></html>");
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
	
	
		if(CS_SqlAbfragen.helferanlegensql(helferWerte))
			JOptionPane.showMessageDialog(null,"Helfer wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Helfer konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);
			
	}

}
