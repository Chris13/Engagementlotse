import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JScrollPane;

public class Frame_Vorlage extends JFrame{


	private CardLayout cards;
	private JPanel masterPanel;
	private JButton btnTraeger;
	private JButton btnHelfer;
	private JButton btnAufgabe;
	private JButton btnEinsatz;
	private JButton btnFaehigkeiten;
	private JButton btnStartseite;
	private JButton btnLoginAnlegen;
	private JButton btnAbmelden;
	private static Dialog_Login dialog;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Frame_Vorlage();
					//dialog = new Dialog_Login();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame_Vorlage() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {		
		setBounds(100, 100, 1000, 700);
		setExtendedState(MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		//Start Einstellungen der ToolBar
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setBackground(new Color(255, 215, 0));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JLabel lblLogoSmall = new JLabel("");
		lblLogoSmall.setIcon(new ImageIcon("Images\\Blume_Logo_small2.gif"));
		toolBar.add(lblLogoSmall);
		
		JLabel lblEngagementlotsentoolDesNetzwerk = new JLabel("  Engagementlotsen-Tool");
		lblEngagementlotsentoolDesNetzwerk.setBackground(new Color(220, 220, 220));
		lblEngagementlotsentoolDesNetzwerk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblEngagementlotsentoolDesNetzwerk);
		
		//Macht die ToolBar rechtsbündig
		toolBar.add(Box.createHorizontalGlue());
		
		//Achtung!!!!Wenn PW Abfrage wieder an, den Teil wieder aktivieren!!!
		//JLabel lblMaximeMusterfrau = new JLabel(dialog.getName());
		//lblMaximeMusterfrau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//toolBar.add(lblMaximeMusterfrau);
		
		toolBar.addSeparator();
		
		btnAbmelden = new JButton("");
		btnAbmelden.setToolTipText("Abmelden");
		btnAbmelden.setIcon(new ImageIcon("Images\\Logout.gif"));
		btnAbmelden.setBackground(new Color(255, 215, 0));
		toolBar.add(btnAbmelden);
		
		btnAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
                new Dialog_Login();
                dispose();
            }
		});
		//Ende Einstellungen der ToolBar
		
		//Start Einstellungen des MainMenü
		//Panel mit den Buttons des Mainmenüs
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[1px,grow]", "[][][1px][][][][][][][][][grow][][][][][grow][][][][][][][][][][][-85.00][-105.00][][][][][-67.00][][][]"));
		
		//Designklasse für die Buttons
		
		//Buttons des Mainmenüs
		//btnStartseite = CS_ButtonDesign.buttonLarge();
		btnStartseite = new JButton();
		btnStartseite.setIcon(new ImageIcon("Images\\test_yellow.jpg"));
		btnStartseite.setDisabledIcon(new ImageIcon("Images\\test_yellow_back.jpg"));
		btnStartseite.setRolloverIcon(new ImageIcon("Images\\test_yellow_scrollover.jpg"));
		btnStartseite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStartseite.setHorizontalTextPosition(JButton.CENTER);
		btnStartseite.setContentAreaFilled( false );  
		btnStartseite.setBorderPainted( false );
		btnStartseite.setFocusPainted( false );
		btnStartseite.setMargin(new java.awt.Insets(0, 0, 0, 0));
		
		btnStartseite.setText("Startseite");
		panel.add(btnStartseite, "cell 0 1,alignx center");
				
		btnStartseite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartseiteLaden();
			}
		});
		
		
		btnHelfer = CS_ButtonDesign.buttonLarge();
		btnHelfer.setText("Helfer");
		panel.add(btnHelfer, "cell 0 2 1 2,growx");
				
		btnHelfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelferseiteLaden();
			}
		});
		
		btnTraeger = CS_ButtonDesign.buttonLarge();
		btnTraeger.setText("Träger");
		panel.add(btnTraeger, "cell 0 4,growx");
		
		btnTraeger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TraegerSeiteLaden();
			}
		});
		
		
		btnAufgabe = CS_ButtonDesign.buttonLarge();
		btnAufgabe.setText("Aufgaben");
		panel.add(btnAufgabe, "cell 0 5,growx");
		
		btnAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
                AufgabenSeiteLaden();
            }
		});
		
		btnEinsatz = CS_ButtonDesign.buttonLarge();
		btnEinsatz.setText("Einsatz");
		panel.add(btnEinsatz, "cell 0 6,growx");
		
		btnEinsatz.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				EinsatzSeiteLaden();
            }
		});
		
		
		btnFaehigkeiten = CS_ButtonDesign.buttonLarge();
		btnFaehigkeiten.setText("Fähigkeiten");
		panel.add(btnFaehigkeiten, "cell 0 7,growx");
		
		btnFaehigkeiten.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				FaehigkeitenSeiteLaden();
            }
		});
		
		Component verticalStrut = Box.createVerticalStrut(38);
		panel.add(verticalStrut, "cell 0 0,alignx center");
		
		btnLoginAnlegen = CS_ButtonDesign.buttonLarge();
		btnLoginAnlegen.setText("Login anlegen");
		panel.add(btnLoginAnlegen, "cell 0 10");
		
		btnLoginAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				LoginSeiteLaden();
            }
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images\\Blume_Logo.gif"));
		panel.add(lblNewLabel, "cell 0 32,alignx center,aligny bottom");
		//Ende Einstellungen Mainmenü
		
		//Einstellungen für Copyright
		JPanel cpyPanel = new JPanel();
		cpyPanel.setBackground(new Color(245, 245, 245));
		getContentPane().add(cpyPanel, BorderLayout.SOUTH);
		cpyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHochtaunusschuleOberursel = new JLabel("\u00A9Hochtaunusschule Oberursel - 12BI1");
		lblHochtaunusschuleOberursel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cpyPanel.add(lblHochtaunusschuleOberursel);
		
		//MASTERPANEL!!!!Hier werden alle anderen Panel reingeladen
		masterPanel = new JPanel();
		getContentPane().add(masterPanel, BorderLayout.CENTER);
		cards = new CardLayout(0, 0);
		masterPanel.setLayout(cards);
		//Ende Einstellungen Copyright
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		StartseiteLaden();
		
		setVisible(true);		

	}
	

	
	private void StartseiteLaden()
	{
		AllButtonsEnable();
		P_Startseite startseite = new P_Startseite();
		masterPanel.add(startseite.StartPanel(),"start");
		cards.show(masterPanel, "start");
		btnStartseite.setEnabled(false);
		
	}
	
	private void HelferseiteLaden()
	{
		AllButtonsEnable();
		P_Helfer helferseite = new P_Helfer();
		helferseite.setFrame(Frame_Vorlage.this);
		masterPanel.add(helferseite.HelferPanel(),"helfer");
		cards.show(masterPanel, "helfer");
		btnHelfer.setEnabled(false);		
	}
	
	private void TraegerSeiteLaden()
	{
		AllButtonsEnable();
		P_Traeger traegerseite = new P_Traeger();
		masterPanel.add(traegerseite.TraegerPanel(),"traeger");
		cards.show(masterPanel, "traeger");
		btnTraeger.setEnabled(false);
	}
	
	private void AufgabenSeiteLaden()
	{
		AllButtonsEnable();
		P_Aufgaben aufgabenseite = new P_Aufgaben();
		aufgabenseite.setFrame(Frame_Vorlage.this);
		masterPanel.add(aufgabenseite.AufgabenPanel(),"aufgaben");
		cards.show(masterPanel, "aufgaben");
		btnAufgabe.setEnabled(false);	
	}
	
	private void EinsatzSeiteLaden()
	{
		AllButtonsEnable();
		P_Einsatz einsatzseite = new P_Einsatz();
		masterPanel.add(einsatzseite.EinsatzPanel(),"einsatz");
		cards.show(masterPanel, "einsatz");
		btnEinsatz.setEnabled(false);	
	}
	
	private void FaehigkeitenSeiteLaden()
	{
		AllButtonsEnable();
		P_Faehigkeiten faehigkeitenseite = new P_Faehigkeiten();
		masterPanel.add(faehigkeitenseite.FaehigkeitenPanel(),"faehigkeiten");
		cards.show(masterPanel, "faehigkeiten");
		btnFaehigkeiten.setEnabled(false);	
	}
	
	private void LoginSeiteLaden()
	{
		AllButtonsEnable();
		P_Login loginseite = new P_Login();
		masterPanel.add(loginseite.LoginPanel(),"login");
		cards.show(masterPanel, "login");
		btnLoginAnlegen.setEnabled(false);	
	}
	
	private void AllButtonsEnable()
	{
		btnTraeger.setEnabled(true);
		btnHelfer.setEnabled(true);
		btnAufgabe.setEnabled(true);
		btnEinsatz.setEnabled(true);
		btnFaehigkeiten.setEnabled(true);
		btnStartseite.setEnabled(true);		
		btnLoginAnlegen.setEnabled(true);
	}
	
}
