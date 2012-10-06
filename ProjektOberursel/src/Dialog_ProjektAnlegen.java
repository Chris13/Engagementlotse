import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class Dialog_ProjektAnlegen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtProjektName;
	private JTextArea txtaBeschreibung;

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

	/**
	 * Create the dialog.
	 */
	public Dialog_ProjektAnlegen(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 493, 379);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			
			JLabel lblHelfer = new JLabel("<html><u>Projekt anlegen</u></html>");
			panel.add(lblHelfer);
			lblHelfer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(255, 215, 0));
				panel.add(panel_1, BorderLayout.NORTH);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.NORTH);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					{
						JLabel lblNewLabel = new JLabel("Projekt Name:");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_2.add(lblNewLabel);
					}
					{
						txtProjektName = new JTextField();
						txtProjektName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_2.add(txtProjektName);
						txtProjektName.setColumns(10);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.CENTER);
					panel_2.setLayout(new BorderLayout(0, 0));
					{
						JPanel panel_3 = new JPanel();
						panel_2.add(panel_3, BorderLayout.NORTH);
						panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
						{
							JLabel lblBeschreibung = new JLabel("Beschreibung:");
							lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 16));
							panel_3.add(lblBeschreibung);
						}
					}
					{
						JScrollPane scrollPane = new JScrollPane();
						panel_2.add(scrollPane, BorderLayout.CENTER);
						{
							txtaBeschreibung = new JTextArea();
							txtaBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 16));
							scrollPane.setViewportView(txtaBeschreibung);
						}
					}
				}
			}
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Anlegen");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!txtProjektName.getText().equals(""))
						{
							projektwerte();
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null,"Bitte einen Namen angeben!","Titel", JOptionPane.INFORMATION_MESSAGE);
							
					}
				});
				okButton.setActionCommand("Anlegen");
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
	
	private void projektwerte()
	{
		ArrayList<ArrayList<String>> uebergabeWerte = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp = new ArrayList<String>();								

		tmp.add("Projekt.projektname");
		tmp.add("'"+txtProjektName.getText()+"'");
		uebergabeWerte.add(tmp);
		
		tmp = new ArrayList<String>();	
		tmp.add("Projekt.beschreibung");
		tmp.add("'"+txtaBeschreibung.getText()+"'");
		uebergabeWerte.add(tmp);
		
		if(CS_SqlAbfragen.projektanlegensql(uebergabeWerte))
			JOptionPane.showMessageDialog(null,"Projekt wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Projekt konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);

	}

}
