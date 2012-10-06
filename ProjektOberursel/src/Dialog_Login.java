import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Dialog_Login extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField loginField;
	private JPasswordField passwordField;
	
	public Dialog_Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 343, 219);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(null);		
		loginField = new JTextField();
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginField.setBounds(93, 52, 129, 20);
		getContentPane().add(loginField);
		loginField.setColumns(10);
		
		JButton btnNewButton = new JButton("Anmelden");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anmelden();		
			}
		});
		btnNewButton.setBounds(103, 122, 108, 23);
		getContentPane().add(btnNewButton);		
		
		JLabel lblNewLabel = new JLabel("Login Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(93, 31, 129, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswort.setBounds(93, 77, 129, 20);
		getContentPane().add(lblPasswort);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
		        
		        if (key == KeyEvent.VK_ENTER)
		        	anmelden();
			}
		});
		passwordField.setBounds(93, 96, 129, 20);
		getContentPane().add(passwordField);
		
	}
	
	private void anmelden()
	{		
		String pw = "";
		String name = "";
  
		try {
			name = loginField.getText();
			if(name.matches(".*\\s+.*") && !name.matches(".*\\s+$.*"))
				{
				String[]splitName = name.split(" ");
			
				if(!CS_DataBaseConnect.dbQuery(CS_SqlAbfragen.passwortermittelnsql("'"+splitName[0]+"'","'"+splitName[1]+"'"),false))			
					JOptionPane.showMessageDialog(null,"Falsches Passwort oder Benutzername!","Titel", JOptionPane.ERROR_MESSAGE);
		
				DefaultTableModel model = CS_DataBaseConnect.getModel();
				if(model.getRowCount() > 0)
				{
					pw = md5(String.valueOf(passwordField.getPassword()));
					if(pw.equals(model.getValueAt(0, 0).toString()))
					{
						new MainFrame_Vorlage();
						dispose();
						return;
					}	
				}	
			}
			
			JOptionPane.showMessageDialog(null,"Falsches Passwort oder Benutzername!","Titel", JOptionPane.ERROR_MESSAGE);
			passwordField.setText("");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String getName()
	{
		return loginField.getText();
	}
	
	private String md5(String input) throws NoSuchAlgorithmException {
	    String result = input;
	    if(input != null) {
	        MessageDigest md = MessageDigest.getInstance("MD5"); //or "SHA-1"
	        md.update(input.getBytes());
	        BigInteger hash = new BigInteger(1, md.digest());
	        result = hash.toString(16);
	        while(result.length() < 32) {
	            result = "0" + result;
	        }
	    }
	    return result;
	}
}