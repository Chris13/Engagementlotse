import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JList;


public class Dialog_AufgabezuProjekt extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String id;
	private JList listFaehigkeiten;
	private JButton btnX;
	private JComboBox cbFaehigkeiten;
	private DefaultListModel tmp;
	private DefaultTableModel model;
	private Map<String, Integer> dictionary;
	private DefaultListModel listModel;
	private DefaultListModel saveModel;
	private JPanel panel_1;

	/**
	 * Create the dialog.
	 */
	public Dialog_AufgabezuProjekt(JFrame parent,String hId, String hName) {
		super(parent,true);
		id = hId;
		setBounds(100, 100, 368, 307);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				JLabel lblZugeordneteFhigkeiten = new JLabel("<html><u>Zugeordnete Aufgaben:</u></html>");
				lblZugeordneteFhigkeiten.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel.add(lblZugeordneteFhigkeiten);
			}
		}
		{
			JPanel panel_3 = new JPanel();
			contentPanel.add(panel_3, BorderLayout.CENTER);
			panel_3.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(255, 215, 0));
				panel_3.add(panel_2, BorderLayout.NORTH);
				

			}

			{
				panel_1 = new JPanel();
				panel_3.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					Box verticalBox = Box.createVerticalBox();
					panel_1.add(verticalBox, BorderLayout.EAST);
					{
						cbFaehigkeiten = new JComboBox();
						
						JButton btnNewButton = new JButton("+");
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								tmp = (DefaultListModel) listFaehigkeiten.getModel();
			                    if(!tmp.contains(cbFaehigkeiten.getItemAt(cbFaehigkeiten.getSelectedIndex())))
			                    tmp.addElement(cbFaehigkeiten.getItemAt(cbFaehigkeiten.getSelectedIndex()));
			                    
			                    btnX.setEnabled(true);
							}
						});
						verticalBox.add(btnNewButton);
					}
					{
						Component verticalStrut = Box.createVerticalStrut(10);
						verticalBox.add(verticalStrut);
					}					   
			            
					{
						btnX = new JButton(" x");
						btnX.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
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
						btnX.setFont(new Font("Tahoma", Font.PLAIN, 13));
						verticalBox.add(btnX);
					}
				}		
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Speichern");
				saveButton.addActionListener(new ActionListener() {
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
						
						dispose();
					}
				});
				saveButton.setActionCommand("Speichern");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
				
				JButton okButton = new JButton("Cancel");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("Cancel");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		faehigkeitenLaden();
	}
	
	private void aenderungenSpeichern()
	{
		ArrayList<String> arraytmp = new ArrayList<String>();
		for(int i = 0; i < listFaehigkeiten.getModel().getSize(); i++)
		{
			if((dictionary.containsKey(listFaehigkeiten.getModel().getElementAt(i))))
			{
				arraytmp.add(dictionary.get(listFaehigkeiten.getModel().getElementAt(i)).toString());
			}			
		}
		
		if(!CS_SqlAbfragen.projekthasaufgabensql(arraytmp,id))
			JOptionPane.showMessageDialog(null,"Die Änderungen konnten nicht gespeichert werden!","Titel", JOptionPane.ERROR_MESSAGE);		
	}
	
	private void faehigkeitenLaden()
	{
		CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.aufgabenfuercomboboxsql(),false);
		model = CS_DataBaseConnect.getModel();
		dictionary = new HashMap<String, Integer>();
		for(int i = 0; i< model.getRowCount(); i++)
		{			
			cbFaehigkeiten.addItem(model.getValueAt(i, 0));
			int t = Integer.parseInt(model.getValueAt(i, 1).toString());
			dictionary.put(model.getValueAt(i, 0).toString(), t);
			
		}

		try
		{
			CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.aufgabenzuprojektsql(id),true);
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
			panel_1.add(scrollPane, BorderLayout.CENTER);
			{
				listFaehigkeiten = new JList(listModel);
				scrollPane.setViewportView(listFaehigkeiten);
				listFaehigkeiten.setFont(new Font("Tahoma", Font.PLAIN, 15));
				scrollPane.setColumnHeaderView(cbFaehigkeiten);
			}
			
			tmp = (DefaultListModel) listFaehigkeiten.getModel();

		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		

	}
	


}
