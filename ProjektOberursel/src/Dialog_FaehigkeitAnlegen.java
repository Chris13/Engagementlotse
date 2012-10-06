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


public class Dialog_FaehigkeitAnlegen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFaehigkeitName;
	private JTextArea txtaBeschreibung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_FaehigkeitAnlegen dialog = new Dialog_FaehigkeitAnlegen(new JFrame());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_FaehigkeitAnlegen(JFrame parent) {
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
			
			JLabel lblHelfer = new JLabel("<html><u>F\u00E4higkeit anlegen</u></html>");
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
						JLabel lblNewLabel = new JLabel("F\u00E4higkeit Name:");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_2.add(lblNewLabel);
					}
					{
						txtFaehigkeitName = new JTextField();
						txtFaehigkeitName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						panel_2.add(txtFaehigkeitName);
						txtFaehigkeitName.setColumns(10);
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
						txtFaehigkeitName.getText();
						if(!txtFaehigkeitName.getText().equals(""))
						{
							faehigkeitwerte();
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
	
	private void faehigkeitwerte()
	{
		ArrayList<ArrayList<String>> uebergabeWerte = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp = new ArrayList<String>();								

		tmp.add("faehigkeit.bezeichnung");
		tmp.add("'"+txtFaehigkeitName.getText()+"'");
		uebergabeWerte.add(tmp);
		
		tmp = new ArrayList<String>();	
		tmp.add("faehigkeit.beschreibung");
		tmp.add("'"+txtaBeschreibung.getText()+"'");
		uebergabeWerte.add(tmp);
		
		if(CS_SqlAbfragen.faehigkeitenanlegensql(uebergabeWerte))
			JOptionPane.showMessageDialog(null,"Faehigkeit wurde angelegt!","Titel", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Faehigkeit konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);

	}

}
