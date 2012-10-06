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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Dialog_TraegerAnlegen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtKontakt;
	private JTextField txtStrasse;
	private JTextField txtPLZ;
	private JTextField txtWohnort;
	private JTextField txtHandyNr;
	private JTextField txtEMail;
	private JTextField txtTelefonNr;
	private JTextField txtTraegerName;
	private JTextArea txtNotizen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_TraegerAnlegen dialog = new Dialog_TraegerAnlegen(new JFrame()); 
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
	public Dialog_TraegerAnlegen(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 479, 537);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
		}
		{
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		//getContentPane().add(contentPanel, BorderLayout.CENTER);
		//panel.add(contentPanel);
			
		contentPanel.setBackground(new Color(245, 245, 245));
		contentPanel.setBorder(null);
		contentPanel.setLayout(new MigLayout("", "[111.00,grow][126.00,grow][][126.00,grow][][-248.00][][grow]", "[][][][][][][][][][][][][][grow][][][29.00][93.00]"));
		
			{
				JLabel lblTitel = new JLabel("Tr\u00E4ger Name:");
				lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblTitel, "cell 0 0,growx");
			}
			{
				txtTraegerName = new JTextField();
				txtTraegerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtTraegerName, "cell 1 0 6 1,growx");
				txtTraegerName.setColumns(10);
			}
			{
				JLabel lblVorname = new JLabel("Kontaktperson:");
				lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblVorname, "cell 0 1,growx");
			}
			{
				txtKontakt = new JTextField();
				txtKontakt.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtKontakt, "cell 1 1 6 1,growx");
				txtKontakt.setColumns(10);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				contentPanel.add(verticalStrut, "cell 0 2");
			}
			{
				JLabel lblStrae = new JLabel("Stra\u00DFe:");
				lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblStrae, "cell 0 3,growx");
			}
			{
				txtStrasse = new JTextField();
				txtStrasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtStrasse, "cell 1 3 6 1,growx");
				txtStrasse.setColumns(10);
			}
			{
				JLabel lblPostleitzahl = new JLabel("PLZ:");
				lblPostleitzahl.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblPostleitzahl, "cell 0 4,growx");
			}
			{
				txtPLZ = new JTextField(5);
				txtPLZ.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtPLZ, "cell 1 4 6 1,growx");
				txtPLZ.setColumns(10);
			}
			{
				JLabel lblWohnort = new JLabel("Wohnort:");
				lblWohnort.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblWohnort, "cell 0 5,growx");
			}
			{
				txtWohnort = new JTextField();
				txtWohnort.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtWohnort, "cell 1 5 6 1,growx");
				txtWohnort.setColumns(10);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				contentPanel.add(verticalStrut, "cell 0 6");
			}
			{
				JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
				lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblTelefonnummer, "cell 0 7,growx");
			}
			{
				txtTelefonNr = new JTextField();
				txtTelefonNr.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtTelefonNr, "cell 1 7 6 1,growx");
				txtTelefonNr.setColumns(10);
			}
			{
				JLabel lblHandynummer = new JLabel("Handynummer:");
				lblHandynummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblHandynummer, "cell 0 8,growx");
			}
			{
				txtHandyNr = new JTextField();
				txtHandyNr.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtHandyNr, "flowy,cell 1 8 6 1,growx");
				txtHandyNr.setColumns(10);
			}
			{
				JLabel lblEmailAdresse = new JLabel("EMail Adresse:");
				lblEmailAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblEmailAdresse, "cell 0 9,growx");
			}
			{
				txtEMail = new JTextField();
				txtEMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(txtEMail, "flowy,cell 1 9 6 1,growx");
				txtEMail.setColumns(10);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				contentPanel.add(scrollPane, "cell 0 13 7 5,grow");
				{
					txtNotizen = new JTextArea();
					scrollPane.setViewportView(txtNotizen);
				}
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
					JLabel lblHelfer = new JLabel("<html><u>Tr\u00E4ger anlegen</u></html>");
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
		tmp.add("Traeger.name");
		tmp.add("'"+txtTraegerName.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("Traeger.kontaktperson");
		tmp.add("'"+txtKontakt.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		tmp = new ArrayList<String>();
		tmp.add("Traeger.beschreibung");
		tmp.add("'"+txtNotizen.getText()+"'");
		helferWerte.add(zaehler, tmp);
		zaehler++;
		
		if(CS_SqlAbfragen.traegeranlegensql(helferWerte))
			JOptionPane.showMessageDialog(null,"Träger wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Träger konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);
	}
	

}