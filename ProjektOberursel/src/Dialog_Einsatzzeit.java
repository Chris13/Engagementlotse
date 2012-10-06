import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.ArrayList;


public class Dialog_Einsatzzeit extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * @wbp.parser.constructor
	 */
	public Dialog_Einsatzzeit(final JDialog parent, final CS_JComboButtonCellEditor cellParent) {		
		super(parent,true);
		setBounds(100, 100, 388, 182);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(getParent());
		setResizable(false);
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBitteEinenZeitraum = new JLabel("Bitte einen Zeitraum angeben:");
		lblBitteEinenZeitraum.setBackground(new Color(230, 230, 250));
		lblBitteEinenZeitraum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBitteEinenZeitraum.setBounds(10, 0, 213, 20);
		contentPanel.add(lblBitteEinenZeitraum);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(10, 52, 364, 36);
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		final JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		comboBox.setBackground(new Color(230, 230, 250));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"**","Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"}));
		
		JLabel lblVon = new JLabel("von");
		lblVon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblVon);
		
		textField = new JTextField();
		textField.setDocument(new LimitedInteger(2));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(textField);
		textField.setColumns(2);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setDocument(new LimitedInteger(2));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(2);
		panel.add(textField_1);
		
		JLabel lblBis = new JLabel("bis");
		lblBis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblBis);
		
		textField_2 = new JTextField();
		textField_2.setDocument(new LimitedInteger(2));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(2);
		panel.add(textField_2);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setDocument(new LimitedInteger(2));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(2);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(0, 21, 411, 10);
		contentPanel.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 0, 382, 20);
		contentPanel.add(panel_3);
		
		JLabel lbloptional = new JLabel("(optional)");
		lbloptional.setBounds(10, 31, 67, 25);
		contentPanel.add(lbloptional);
		
		final JComboBox cellParentComboBox = cellParent.getComboButton().getComboBox();
		if(cellParentComboBox.getSelectedIndex() != 0){	
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("**")) comboBox.setSelectedIndex(0);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Mo")) comboBox.setSelectedIndex(1);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Di")) comboBox.setSelectedIndex(2);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Mi")) comboBox.setSelectedIndex(3);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Do")) comboBox.setSelectedIndex(4);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Fr")) comboBox.setSelectedIndex(5);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Sa")) comboBox.setSelectedIndex(6);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("So")) comboBox.setSelectedIndex(7);
            textField.setText(cellParentComboBox.getSelectedItem().toString().substring(4, 6));
			textField_1.setText(cellParentComboBox.getSelectedItem().toString().substring(7, 9));
			textField_2.setText(cellParentComboBox.getSelectedItem().toString().substring(12, 14));
			textField_3.setText(cellParentComboBox.getSelectedItem().toString().substring(15, 17));
		};
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(230, 230, 250));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!textField.getText().equals("") || !textField_1.getText().equals("") || !textField_2.getText().equals("") || !textField_3.getText().equals(""))
						{
							String tmp = comboBox.getSelectedItem().toString().substring(0,2) +", "+ textField.getText()+":"+textField_1.getText()+" - "+textField_2.getText()+":"+textField_3.getText();
							ArrayList<String> tmp1 = ((Dialog_AufgabefuerHelfer) parent).getmglEinsatzzeit().get(((Dialog_AufgabefuerHelfer) parent).getmglEinsatz().getSelectedRow());
							if(cellParentComboBox.getSelectedIndex() != 0){
								tmp1.remove(cellParentComboBox.getSelectedIndex()-1);
								cellParentComboBox.removeItemAt(cellParentComboBox.getSelectedIndex());																
							}
							tmp1.add(tmp);
							cellParentComboBox.addItem(tmp);
							
							System.out.println(tmp1);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null,"Bitte vollständige Angaben machen!","Titel", JOptionPane.ERROR_MESSAGE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(230, 230, 250));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Dialog_Einsatzzeit(final JDialog parent, final JComboBox parentComboBox) {		
		super(parent,true);
		setBounds(100, 100, 388, 182);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(getParent());
		setResizable(false);
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBitteEinenZeitraum = new JLabel("Bitte einen Zeitraum angeben:");
		lblBitteEinenZeitraum.setBackground(new Color(230, 230, 250));
		lblBitteEinenZeitraum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBitteEinenZeitraum.setBounds(10, 0, 213, 20);
		contentPanel.add(lblBitteEinenZeitraum);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(10, 52, 364, 36);
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		final JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		comboBox.setBackground(new Color(230, 230, 250));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"**","Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"}));
		
		JLabel lblVon = new JLabel("von");
		lblVon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblVon);
		
		textField = new JTextField();
		textField.setDocument(new LimitedInteger(2));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(textField);
		textField.setColumns(2);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setDocument(new LimitedInteger(2));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(2);
		panel.add(textField_1);
		
		JLabel lblBis = new JLabel("bis");
		lblBis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblBis);
		
		textField_2 = new JTextField();
		textField_2.setDocument(new LimitedInteger(2));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(2);
		panel.add(textField_2);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setDocument(new LimitedInteger(2));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(2);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(0, 21, 411, 10);
		contentPanel.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 0, 382, 20);
		contentPanel.add(panel_3);
		
		JLabel lbloptional = new JLabel("(optional)");
		lbloptional.setBounds(10, 31, 67, 25);
		contentPanel.add(lbloptional);
		
		final JComboBox cellParentComboBox = parentComboBox;
		if(cellParentComboBox.getSelectedIndex() != 0){		
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("**")) comboBox.setSelectedIndex(0);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Mo")) comboBox.setSelectedIndex(1);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Di")) comboBox.setSelectedIndex(2);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Mi")) comboBox.setSelectedIndex(3);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Do")) comboBox.setSelectedIndex(4);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Fr")) comboBox.setSelectedIndex(5);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("Sa")) comboBox.setSelectedIndex(6);
			if(cellParentComboBox.getSelectedItem().toString().substring(0, 2).equals("So")) comboBox.setSelectedIndex(7);
            textField.setText(cellParentComboBox.getSelectedItem().toString().substring(4, 6));
			textField_1.setText(cellParentComboBox.getSelectedItem().toString().substring(7, 9));
			textField_2.setText(cellParentComboBox.getSelectedItem().toString().substring(12, 14));
			textField_3.setText(cellParentComboBox.getSelectedItem().toString().substring(15, 17));
		};
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(230, 230, 250));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String tmp = comboBox.getSelectedItem().toString().substring(0,2) +", "+ textField.getText()+":"+textField_1.getText()+" - "+textField_2.getText()+":"+textField_3.getText();
						
						if(cellParentComboBox.getSelectedIndex() != 0){
							cellParentComboBox.removeItemAt(cellParentComboBox.getSelectedIndex());																
						}
						cellParentComboBox.addItem(tmp);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(230, 230, 250));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	public void setDialog(JDialog dialogparent)
	{
	}
}

class LimitedInteger extends PlainDocument {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxCharacters;
    public LimitedInteger(int maxChars) {maxCharacters = maxChars;}
    public void insertString(int offs, String str, AttributeSet a)
    throws BadLocationException {
        int len = getLength() + str.length();
        if(len <= maxCharacters && str.matches("[\\d]*"))
            super.insertString(offs, str, a);
        else Toolkit.getDefaultToolkit().beep();
    }
}
