import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JScrollPane;


public class Dialog_HelferAnzeigen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtVName;
	private JTextField txtNName;
	private JTextField txtStrasse;
	private JTextField txtPlz;
	private JTextField txtOrt;
	private JTextField txtTelNr;
	private JTextField txtHandyNr;
	private JTextField txtEMail;
	private String id;
	private JComboBox cbFaehigkeiten;
	private JList list;
	private DefaultListModel tmp;
	private JPanel panel_1;
	private JButton btnX;
	private JTextArea textArea;
	private Map<String, Integer> dictionary;
	private DefaultListModel listModel;
	private DefaultListModel saveModel;
	private JTextArea compareTextArea;

     /*
	 * Create the dialog.
	 */
	public Dialog_HelferAnzeigen(JFrame parent, String hId)
	{
		super(parent, true);
		id = hId;
		setBounds(100, 100, 814, 572);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JSplitPane splitPane = new JSplitPane();
				splitPane.setDividerLocation(400);
				splitPane.setMinimumSize(new Dimension(300,300));
				splitPane.setEnabled(true);
				panel.add(splitPane, BorderLayout.CENTER);
				{
					JPanel panel_1 = new JPanel();
					splitPane.setRightComponent(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel_1.add(scrollPane, BorderLayout.CENTER);
						{
							textArea = new JTextArea();
							textArea.setLineWrap(true);
							textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
							scrollPane.setViewportView(textArea);
						}
					}
				}
				{
					panel_1 = new JPanel();
					panel_1.setBackground(new Color(245, 245, 245));
					splitPane.setLeftComponent(panel_1);
					panel_1.setLayout(new MigLayout("", "[grow][][grow]", "[][][][][][][][][][][][grow]"));
					{
						JLabel lblNewLabel_1 = new JLabel("Vorname:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_1, "cell 0 0,growx");
					}
					{
						txtVName = new JTextField();
						txtVName.setEditable(false);
						txtVName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtVName, "cell 2 0,growx");
						txtVName.setColumns(10);
					}
					{
						JLabel lblNewLabel_2 = new JLabel("Nachname:");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_2, "cell 0 1,growx");
					}
					{
						txtNName = new JTextField();
						txtNName.setEditable(false);
						txtNName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtNName, "cell 2 1,growx");
						txtNName.setColumns(10);
					}
					{
						JLabel lblNewLabel_3 = new JLabel("Stra\u00DFe:");
						lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_3, "cell 0 2,growx");
					}
					{
						txtStrasse = new JTextField();
						txtStrasse.setEditable(false);
						txtStrasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtStrasse, "cell 2 2,growx");
						txtStrasse.setColumns(10);
					}
					{
						JLabel lblNewLabel_4 = new JLabel("Posteitzahl:");
						lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_4, "cell 0 3,growx");
					}
					{
						txtPlz = new JTextField();
						txtPlz.setEditable(false);
						txtPlz.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtPlz, "cell 2 3,growx");
						txtPlz.setColumns(10);
					}
					{
						JLabel lblNewLabel_5 = new JLabel("Wohnort:");
						lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_5, "cell 0 4,growx");
					}
					{
						txtOrt = new JTextField();
						txtOrt.setEditable(false);
						txtOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtOrt, "cell 2 4,growx");
						txtOrt.setColumns(10);
					}
					{
						Component verticalStrut = Box.createVerticalStrut(20);
						panel_1.add(verticalStrut, "cell 0 5");
					}
					{
						JLabel lblNewLabel_6 = new JLabel("Telefonnummer:");
						lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_6, "cell 0 6,growx");
					}
					{
						txtTelNr = new JTextField();
						txtTelNr.setEditable(false);
						txtTelNr.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtTelNr, "cell 2 6,growx");
						txtTelNr.setColumns(10);
					}
					{
						JLabel lblNewLabel_7 = new JLabel("Handynummer:");
						lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_7, "cell 0 7,growx");
					}
					{
						txtHandyNr = new JTextField();
						txtHandyNr.setEditable(false);
						txtHandyNr.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtHandyNr, "cell 2 7,growx");
						txtHandyNr.setColumns(10);
					}
					{
						JLabel lblNewLabel_8 = new JLabel("EMail:");
						lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(lblNewLabel_8, "cell 0 8,growx");
					}
					{
						txtEMail = new JTextField();
						txtEMail.setEditable(false);
						txtEMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_1.add(txtEMail, "flowx,cell 2 8,growx");
						txtEMail.setColumns(10);
					}
						helferLaden();
					{
						Component verticalStrut = Box.createVerticalStrut(20);
						panel_1.add(verticalStrut, "cell 0 9");
					}
					{
						cbFaehigkeiten = new JComboBox();
						faehigkeitenLaden();
						panel_1.add(cbFaehigkeiten, "cell 0 10 3 1,growx");
					}
			
					{
						JButton btnAdd = new JButton("+");
						btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnAdd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							   	tmp = (DefaultListModel) list.getModel();
			                    if(!tmp.contains(cbFaehigkeiten.getItemAt(cbFaehigkeiten.getSelectedIndex())))
			                    tmp.addElement(cbFaehigkeiten.getItemAt(cbFaehigkeiten.getSelectedIndex()));
			                    
			                    btnX.setEnabled(true);       
							}
						});
						panel_1.add(btnAdd, "cell 3 10,alignx center");
					}
					{
						JButton btnEmailSenden = new JButton("send");
						panel_1.add(btnEmailSenden, "cell 2 8");
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2, "cell 3 11,grow");
						panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						{
							btnX = new JButton("X");
							btnX.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try{
										  int index = list.getSelectedIndex();
										    tmp.remove(index);

										    int size = tmp.getSize();

										    if (size == 0) { //Nobody's left, disable firing.
										        btnX.setEnabled(false);

										    } else { //Select an index.
										        if (index == tmp.getSize()) {
										            //removed item in last position
										            index--;
										        }

										        list.setSelectedIndex(index);
										        list.ensureIndexIsVisible(index);
										    }
										}
										catch(Exception ex)
										{
											
										}
									
								}
							});
							panel_2.add(btnX);
						}
						
						btnEmailSenden.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							  eMailErstellen();
							}
						});
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setBackground(new Color(230, 230, 250));
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon("Images\\Blume_Logo_small2.gif"));
					panel_1.add(label);
				}
				{
					JLabel lblNewLabel = new JLabel("<html><u>Helfer</u></html>");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
					panel_1.add(lblNewLabel);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(255, 215, 0));
				panel.add(panel_1, BorderLayout.SOUTH);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(230, 230, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int l = saveModel.size();
						int t = tmp.size();
						int result;
						
						if(l == t)
						{
							for(int i = 0; i < l; i++)
							{
								if(!saveModel.getElementAt(i).equals(tmp.getElementAt(i)))
								{
									result = JOptionPane.showConfirmDialog(null,"Wollen Sie die Änderungen wirklich speichern?","Bestätigung notwendig",JOptionPane.YES_NO_OPTION);
									if(result == JOptionPane.YES_NO_OPTION)
										aenderungenSpeichern();
									break;
								}
							}
							
						}
						else
						{
							result = JOptionPane.showConfirmDialog(null,"Wollen Sie die Änderungen der Fähigkeiten wirklich speichern?","Bestätigung notwendig",JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.YES_NO_OPTION)
								aenderungenSpeichern();
						}
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						if(!textArea.getText().equals(compareTextArea.getText()))
						{
							if(!CS_SqlAbfragen.updatenotizensql(textArea.getText()+"\n("+df.format(new Date())+")",id))
								JOptionPane.showMessageDialog(null,"Fehler beim speichern der Notizen!","Titel", JOptionPane.ERROR_MESSAGE);
						}
						
						dispose();
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}		
	}
	
	private void aenderungenSpeichern()
	{
		ArrayList<String> arraytmp = new ArrayList<String>();
		for(int i = 0; i < list.getModel().getSize(); i++)
		{
			if((dictionary.containsKey(list.getModel().getElementAt(i))))
			{
				arraytmp.add(dictionary.get(list.getModel().getElementAt(i)).toString());
			}			
		}
		
		if(!CS_SqlAbfragen.faehigkeitenupdatesql(arraytmp,id))
			JOptionPane.showMessageDialog(null,"Die Änderungen konnten nicht gespeichert werden!","Titel", JOptionPane.ERROR_MESSAGE);
			
	}
	
	private void eMailErstellen()
	{
		  try 
		    {
		    	Desktop.getDesktop().mail(new URI("mailto:"+txtEMail.getText()+"?subject=Netzwerk_Bürgerengagement_Stadt_Oberursel&body=someBodyText"));  
		    } 
		    catch (Exception  e) 
		    {
		    	e.printStackTrace();
		    }
	}
	
	private void helferLaden()
	{
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.helferdetailssql(id),true);
		DefaultTableModel helfermodel = CS_DataBaseConnect.getModel();
		compareTextArea = new JTextArea();

		try{
			if(helfermodel.getValueAt(0, 0) != null)
				txtVName.setText(helfermodel.getValueAt(0, 0).toString());
			if(helfermodel.getValueAt(0, 1) != null)
				txtNName.setText(helfermodel.getValueAt(0, 1).toString());
			if(helfermodel.getValueAt(0, 2) != null)
				txtStrasse.setText(helfermodel.getValueAt(0, 2).toString());
			if(helfermodel.getValueAt(0, 3) != null)
				txtPlz.setText(helfermodel.getValueAt(0, 3).toString());
			if(helfermodel.getValueAt(0, 4) != null)
				txtOrt.setText(helfermodel.getValueAt(0, 4).toString());
			if(helfermodel.getValueAt(0, 5) != null)
				txtTelNr.setText(helfermodel.getValueAt(0, 5).toString());
			if(helfermodel.getValueAt(0, 6) != null)
				txtHandyNr.setText(helfermodel.getValueAt(0, 6).toString());
			if(helfermodel.getValueAt(0, 7) != null)
				txtEMail.setText(helfermodel.getValueAt(0, 7).toString());
			if(helfermodel.getValueAt(0, 8) != null)
			{
				textArea.setText(helfermodel.getValueAt(0, 8).toString());
				compareTextArea.setText(helfermodel.getValueAt(0, 8).toString());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	private void faehigkeitenLaden()
	{
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.faehigkeitenfuercomboboxsql(),true);
		DefaultTableModel model = CS_DataBaseConnect.getModel();
		dictionary = new HashMap<String, Integer>();

		for(int i = 0; i< model.getRowCount(); i++)
		{			
			cbFaehigkeiten.addItem(model.getValueAt(i, 0));
			int t = Integer.parseInt(model.getValueAt(i, 1).toString());
			dictionary.put(model.getValueAt(i, 0).toString(), t);
			
		}
		try
		{
			CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.faehigkeitenhelfersql(id),true);
			model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
			
			saveModel = new DefaultListModel();
			listModel = new DefaultListModel();
	        
			for(int i = 0; i< model.getRowCount(); i++)
			{	
				listModel.addElement(model.getValueAt(i, 0).toString());
				saveModel.addElement(model.getValueAt(i, 0).toString());
			}
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, "flowy,cell 0 11 3 1,growx");
			{
				list = new JList(listModel);
				scrollPane.setViewportView(list);
				list.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			
			tmp = (DefaultListModel) list.getModel();

		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		
	}

	
}
