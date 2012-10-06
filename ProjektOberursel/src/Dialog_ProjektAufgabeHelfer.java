import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class Dialog_ProjektAufgabeHelfer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String projektName;
	private DefaultTableModel model;
	private String projektid;
	private JTable table;
	private JTable table2;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	
	public Dialog_ProjektAufgabeHelfer(JFrame parent,String projektId, String projektName) {
		super(parent,true);
		projektid = projektId;
		projektName = projektName;
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
				{
				JLabel lblNewLabel_1 = new JLabel(projektName);
				lblNewLabel_1.setBackground(SystemColor.activeCaption);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_5.add(lblNewLabel_1);
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
								JLabel lblAngelegteEinstze = new JLabel("Angelegte Eins\u00E4tze zum Projekt:");
								lblAngelegteEinstze.setFont(new Font("Tahoma", Font.PLAIN, 16));
								toolBar.add(lblAngelegteEinstze);
							}
							toolBar.add(Box.createHorizontalGlue());
							{
								JButton btnEinsatzLschen = new JButton("Einsatz l\u00F6schen");
								btnEinsatzLschen.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										//if(!einsatzloeschen());
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
								toolBar.add(Box.createHorizontalGlue());
								toolBar.setBackground(new Color(192, 192, 192));
								panel_3.add(toolBar);
	
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
	
	public String getAufgabeId()
	{
		return model.getValueAt(table2.getSelectedRow(), 2).toString();
	}
	
	public String getAufgabeName()
	{
		return table2.getValueAt(table2.getSelectedRow(), 0).toString();
	}
	
	public String getProjektId()
	{
		return projektid;
	}
	
	private boolean einsatzErstellen()
	{
		return true;
	}
	
	private void tableBuild()
	{		
		table2 = new JTable();
		if(CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.helferzuprojektaufgabensql(projektid),true))
		{
			model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
	
			table2.setModel(model);
			table2.setBorder(new LineBorder(new Color(169, 169, 169)));
			table2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table2.getTableHeader().setBackground(new Color(192, 192, 192));
			table2.getColumnModel().getColumn(0).setHeaderValue("Aufgaben");
			table2.getColumnModel().getColumn(1).setHeaderValue("Helfer filtern");
			table2.getColumnModel().getColumn(1).setCellRenderer(new CS_JTableHelferButtonRenderer());
			CS_JTableHelferButtonEditor editor = new CS_JTableHelferButtonEditor(new JCheckBox(), Dialog_ProjektAufgabeHelfer.this);
			editor.setDialog(Dialog_ProjektAufgabeHelfer.this);
			table2.getColumnModel().getColumn(1).setCellEditor(editor);
			
			table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//Spaltenbreite an Spalteninhalt anpassen
			CS_SpaltenBreite.autoResizeTable(table2, true,10,false);
			table2.getColumnModel().getColumn(0).setPreferredWidth(700);
			table2.removeColumn(table2.getColumnModel().getColumn(2));
			
		}
	}
}
