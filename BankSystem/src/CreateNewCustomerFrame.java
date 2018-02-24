import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateNewCustomerFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txfldCstmName;
	private JTextField txFldPhone;
	private JPasswordField pswdFldPass1;
	private JPasswordField pswdFldPass2;
	private Database db = Login.getDb();
	public CreateNewCustomerFrame(){
		setBackground(new Color(0, 255, 127));
		setBounds(100, 100, 670, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 255, 127));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setForeground(new Color(25, 25, 112));
		lblCustomerName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCustomerName.setBounds(29, 115, 166, 25);
		contentPanel.add(lblCustomerName);
		
		txfldCstmName = new JTextField();
		txfldCstmName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txfldCstmName.setColumns(10);
		txfldCstmName.setBounds(234, 112, 200, 30);
		contentPanel.add(txfldCstmName);
		
		JLabel lblCreateNewCustomer = new JLabel("Create New Customer");
		lblCreateNewCustomer.setForeground(Color.YELLOW);
		lblCreateNewCustomer.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCreateNewCustomer.setBounds(206, 13, 225, 25);
		contentPanel.add(lblCreateNewCustomer);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setForeground(new Color(25, 25, 112));
		lblPhoneNumber.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblPhoneNumber.setBounds(29, 185, 166, 25);
		contentPanel.add(lblPhoneNumber);
		
		txFldPhone = new JTextField();
		txFldPhone.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txFldPhone.setColumns(10);
		txFldPhone.setBounds(234, 182, 200, 30);
		contentPanel.add(txFldPhone);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(25, 25, 112));
		lblPassword.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblPassword.setBounds(29, 255, 166, 25);
		contentPanel.add(lblPassword);
		
		pswdFldPass1 = new JPasswordField();
		pswdFldPass1.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		pswdFldPass1.setBounds(234, 252, 200, 30);
		contentPanel.add(pswdFldPass1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\customers-icon.fw.png"));
		label.setBounds(469, 78, 150, 150);
		contentPanel.add(label);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setForeground(new Color(25, 25, 112));
		lblConfirmPassword.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblConfirmPassword.setBounds(29, 318, 193, 25);
		contentPanel.add(lblConfirmPassword);
		
		pswdFldPass2 = new JPasswordField();
		pswdFldPass2.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		pswdFldPass2.setBounds(234, 315, 200, 30);
		contentPanel.add(pswdFldPass2);
		
		JLabel lblCustomerNumber = new JLabel("Customer Number :");
		lblCustomerNumber.setForeground(new Color(255, 0, 0));
		lblCustomerNumber.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCustomerNumber.setBounds(29, 59, 193, 25);
		contentPanel.add(lblCustomerNumber);
		
		JLabel lblCstmNo = new JLabel("");
		lblCstmNo.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCstmNo.setBounds(232, 59, 202, 25);
		lblCstmNo.setText(Integer.toString(db.dbGetId("Customers")+1));
		contentPanel.add(lblCstmNo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 255, 127));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Create");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						if(Arrays.equals(pswdFldPass1.getPassword(), pswdFldPass2.getPassword()))
						{
							Customer customer = new Customer();
							customer.customerName=txfldCstmName.getText();
							customer.phoneNumber=txFldPhone.getText();
							String password = new String(pswdFldPass1.getPassword());
							customer.password=password;
							db.dbAddCustomer(customer);
							setVisible(false);
							dispose();
							Login.getInstance().customers = db.dbGetCustomers();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Passwords aren't matched !");
						}
					}
				});
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(0, 0, 128));
				okButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
						
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(0, 0, 128));
				cancelButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
