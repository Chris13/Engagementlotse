import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JScrollPane;


public class P_Startseite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel startseite;
	/**
	 * Create the panel.
	 */
	public P_Startseite() {
		setLayout(new BorderLayout(0, 0));
		
		startseite = new JPanel();
		add(startseite, BorderLayout.CENTER);
		startseite.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		startseite.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel_1.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Willkommen ");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 70));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 245, 245));
		panel_1.add(panel_2, BorderLayout.WEST);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 245, 245));
		panel_1.add(panel_3, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 245, 245));
		panel_1.add(panel_4, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 245, 245));
		panel_5.add(panel_7, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 245, 245));
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new MigLayout("", "[][grow][grow][grow][grow][][grow][][][][][][][][][][][][][][grow][grow][][grow][][-26.00]", "[][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][grow][][grow][grow][grow][][grow][grow][][][][grow][][][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon i = new ImageIcon("Images\\Logo_Oberursel.jpg");
		Image img = i.getImage();
		Image newImg = img.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lblNewLabel.setIcon(newIcon);
		panel_6.add(lblNewLabel, "cell 6 2,alignx center,aligny center");
								
										
										JLabel lblImEngagementlotsentoolDes = new JLabel("im Engagementlotsen-Tool des Netzwerk B\u00FCrgerengagement der Stadt Oberursel  ");
										panel_6.add(lblImEngagementlotsentoolDes, "cell 6 4,alignx center,aligny center");
										lblImEngagementlotsentoolDes.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(245, 245, 245));
		startseite.add(panel_8, BorderLayout.NORTH);
		
		Component verticalStrut_2 = Box.createVerticalStrut(35);
		panel_8.add(verticalStrut_2);

	}
	
	public JPanel StartPanel()
	{
		return startseite;
	}
}
