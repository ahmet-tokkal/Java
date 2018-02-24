import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class NewAddressFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txFldCity;
	private JTextField txFldPstCode;
	private JTextField txFldCountry;
	public NewAddressFrame(Customer customer) {
		setTitle("New Address");
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(46, 139, 87));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Address :");
			label.setForeground(new Color(0, 0, 139));
			label.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			label.setBounds(12, 54, 110, 25);
			contentPanel.add(label);
		}
		{
			JLabel lblCity = new JLabel("City \r\n:");
			lblCity.setForeground(new Color(0, 0, 139));
			lblCity.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			lblCity.setBounds(12, 202, 110, 25);
			contentPanel.add(lblCity);
		}
		{
			txFldCity = new JTextField();
			txFldCity.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			txFldCity.setColumns(10);
			txFldCity.setBounds(159, 197, 200, 30);
			contentPanel.add(txFldCity);
		}
		{
			JLabel lblPostalCode = new JLabel("Postal Code :");
			lblPostalCode.setForeground(new Color(0, 0, 139));
			lblPostalCode.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			lblPostalCode.setBounds(12, 243, 135, 25);
			contentPanel.add(lblPostalCode);
		}
		{
			txFldPstCode = new JTextField();
			txFldPstCode.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			txFldPstCode.setColumns(10);
			txFldPstCode.setBounds(159, 238, 200, 30);
			contentPanel.add(txFldPstCode);
		}
		{
			JLabel lblCountry = new JLabel("Country :");
			lblCountry.setForeground(new Color(0, 0, 139));
			lblCountry.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			lblCountry.setBounds(12, 284, 110, 25);
			contentPanel.add(lblCountry);
		}
		{
			txFldCountry = new JTextField();
			txFldCountry.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			txFldCountry.setColumns(10);
			txFldCountry.setBounds(159, 279, 200, 30);
			contentPanel.add(txFldCountry);
		}
		{
			JLabel lblCreateNewAddress = new JLabel("Create New Address");
			lblCreateNewAddress.setForeground(new Color(255, 255, 0));
			lblCreateNewAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			lblCreateNewAddress.setBounds(137, 13, 208, 23);
			contentPanel.add(lblCreateNewAddress);
		}
		
		JTextArea txAreaAddress = new JTextArea();
		txAreaAddress.setRows(5);
		txAreaAddress.setLineWrap(true);
		txAreaAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txAreaAddress.setBounds(159, 54, 200, 133);
		contentPanel.add(txAreaAddress);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(46, 139, 87));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						Address adrs=new Address();
						adrs.address=txAreaAddress.getText();
						adrs.city=txFldCity.getText();
						adrs.postalCode=txFldPstCode.getText();
						adrs.country=txFldCountry.getText();
						Database db =Login.getDb();
						db.dbAddAddress(adrs);
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
						CreateAccountFrame frame = new CreateAccountFrame(customer);
						frame.setVisible(true);
						
					}
				});
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(0, 0, 128));
				okButton.setFont(new Font("Roboto Slab", Font.BOLD, 16));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
						CreateAccountFrame frame = new CreateAccountFrame(customer);
						frame.setVisible(true);
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(0, 0, 128));
				cancelButton.setFont(new Font("Roboto Slab", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
