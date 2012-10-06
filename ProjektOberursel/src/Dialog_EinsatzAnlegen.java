import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import com.toedter.calendar.JDateChooser;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JTextField;


public class Dialog_EinsatzAnlegen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_EinsatzAnlegen dialog = new Dialog_EinsatzAnlegen(new JFrame()); 
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
	public Dialog_EinsatzAnlegen(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 526, 462);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBounds(new Rectangle(30, 30, 30, 30));

		contentPanel.setBackground(new Color(245, 245, 245));
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPanel.setLayout(new MigLayout("", "[111.00][126.00,grow][][][190.00,grow][][-248.00][][grow]", "[][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][grow][][][][][][][][][][grow][grow][][][][grow]"));
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			contentPanel.add(verticalStrut, "cell 0 0");
		}
		{
			JLabel lblTitel = new JLabel("Projekt:");
			lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblTitel, "cell 0 2,growx");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "cell 1 2 7 1,growx");
		}
		{
			JLabel lblVorname = new JLabel("Aufgabe:");
			lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblVorname, "cell 0 3,growx");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "cell 1 3 7 1,growx");
		}
		{
			JLabel lblNachname = new JLabel("Tr\u00E4ger:");
			lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblNachname, "cell 0 4,growx");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "cell 1 4 7 1,growx");
		}
		{
			JLabel lblHelfer_1 = new JLabel("Helfer:");
			lblHelfer_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblHelfer_1, "cell 0 5,growx");
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(textField, "cell 1 5 7 1,growx");
			textField.setColumns(10);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			contentPanel.add(verticalStrut, "cell 0 6");
		}
		{
			JLabel lblGeburtsdatum = new JLabel("Beginndatum:");
			lblGeburtsdatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblGeburtsdatum, "cell 0 7,growx");
		}
		{
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("yyyy-MM-dd");
			dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 16));
			dateChooser.setBorder(null);
			contentPanel.add(dateChooser, "flowx,cell 1 7 2 1,grow");
		}
		{
			JLabel lblNewLabel = new JLabel("Enddatum:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblNewLabel, "cell 0 8,growx");
		}
		{
			JDateChooser dateChooser_1 = new JDateChooser();
			dateChooser_1.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 16));
			dateChooser_1.setDateFormatString("yyyy-MM-dd");
			dateChooser_1.setBorder(null);
			contentPanel.add(dateChooser_1, "cell 1 8 2 1,grow");
		}
		{
			JLabel lblTelefonnummer = new JLabel("Einsatzzeit:");
			lblTelefonnummer.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblTelefonnummer, "cell 0 9,growx");
		}
		{
			comboBox = new JComboBox();
	        comboBox.addItem("Einsatzzeit hinzufügen");
	        contentPanel.add(comboBox, "cell 1 9,growx");
	        comboBox.setPreferredSize(new Dimension(161, 20));
	        MetalComboBoxButton metalComboBoxButton = null;
	        for (Component comp : comboBox.getComponents()){
	            if (comp instanceof MetalComboBoxButton) {
	            	metalComboBoxButton = (MetalComboBoxButton) comp;
	            }
	        }
	        metalComboBoxButton.setComboIcon(new ImageIcon("Images\\Clock.jpg"));
	        metalComboBoxButton.setHorizontalTextPosition(JButton.CENTER);
	        metalComboBoxButton.setContentAreaFilled( false );  
	        metalComboBoxButton.setFocusPainted( false );
	        metalComboBoxButton.setBackground(new Color(255, 215, 0));
	        metalComboBoxButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
	        metalComboBoxButton.removeMouseListener(metalComboBoxButton.getMouseListeners()[1]);
	        metalComboBoxButton.addActionListener(new ActionListener() {                  
	            public void actionPerformed(ActionEvent e) {            	
	       		Dialog_Einsatzzeit einsatzzeit = new Dialog_Einsatzzeit(Dialog_EinsatzAnlegen.this, comboBox);
		        einsatzzeit.setVisible(true);         
	            }
	        }); 
		
		}
		{
		    JButton btnX = new JButton();
	        btnX.setPreferredSize(new Dimension(15,15));
	    	btnX.setIcon(new ImageIcon("Images\\muelleimer.jpg"));
	    	btnX.setRolloverIcon(new ImageIcon("Images\\muelleimer_scrollover.jpg"));
			btnX.setHorizontalTextPosition(JButton.CENTER);
			btnX.setContentAreaFilled( false );  
			btnX.setBorderPainted( false );
			btnX.setFocusPainted( false );
			btnX.setMargin(new java.awt.Insets(0, 0, 0, 0));
	        btnX.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		if(comboBox.getSelectedIndex()!=0){        			      
	        			comboBox.removeItem(comboBox.getSelectedItem());
	        		}	        		
	        	}
	        });
			contentPanel.add(btnX, "cell 2 9");
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			contentPanel.add(verticalStrut, "cell 0 10");
		}
		{
		}
		{
			{
				JLabel lblNotizHinzufgen = new JLabel("Notiz:");
				lblNotizHinzufgen.setFont(new Font("Tahoma", Font.PLAIN, 16));
				contentPanel.add(lblNotizHinzufgen, "cell 0 11,growx");
			}
		}
		JButton btnNotiz = new JButton();
		btnNotiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialog_EinsatzBeschreibung beschreibung = new Dialog_EinsatzBeschreibung(Dialog_EinsatzAnlegen.this);
				beschreibung.setVisible(true);
			}
		});
		btnNotiz.setIcon(new ImageIcon("Images\\Notiz.jpg"));
		btnNotiz.setMargin(new Insets(0, 0, 0, 0));
		btnNotiz.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPanel.add(btnNotiz, "cell 1 11");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(245, 245, 245));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton button = new JButton("Speichern");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
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
					JLabel lblHelfer = new JLabel("<html><u>Einsatz anlegen</u></html>");
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
	

}
