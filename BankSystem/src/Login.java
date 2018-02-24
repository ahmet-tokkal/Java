import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.WindowFocusListener;

public class Login {

	public JFrame frmBankSystem;
	private JTextField textField;
	private JPasswordField passwordField;
	private  static Database db = null;
	public ArrayList<Customer> customers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login.getInstance().frmBankSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	
	private static Login  login = null;
	private Login(){};
	public static Login  getInstance()
	{
		if(login==null)
		{
			
			login = new Login();
			login.initialize();
		}
		return login;
	}
	public static Database getDb()
	{

		if(db==null)
		{
			
			db = new Database();
			db.dbConnect();
		}
		return db;
	}
	
	private void initialize() {
		customers = getDb().dbGetCustomers();
		frmBankSystem = new JFrame();
		frmBankSystem.setResizable(false);
		frmBankSystem.setTitle("Bank System");
		frmBankSystem.addWindowListener(new WindowAdapter() {
		});
		frmBankSystem.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		frmBankSystem.setBounds(100, 100, 1000, 700);
		frmBankSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankSystem.getContentPane().setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Customer Number :");
		lblAccountNumber.setForeground(new Color(255, 255, 0));
		lblAccountNumber.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		lblAccountNumber.setBounds(222, 218, 226, 27);
		frmBankSystem.getContentPane().add(lblAccountNumber);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		passwordField.setBounds(460, 265, 235, 41);
		frmBankSystem.getContentPane().add(passwordField);
		
		textField = new JTextField();
		lblAccountNumber.setLabelFor(textField);
		textField.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		textField.setBounds(460, 211, 235, 41);
		frmBankSystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean login = false;
				String password = new String(passwordField.getPassword());
				if(textField.getText().isEmpty()|| password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please insert Customer Number and Password !");
				}
				else
				{
					for(int i=0; i<customers.size();i++)
					{
						if(customers.get(i).customerID == Integer.parseInt(textField.getText()) && customers.get(i).password.equals(password))
						{
							login=true;
							Application frame = new Application(customers.get(i));
							frame.setVisible(true);
							Login.this.frmBankSystem.setVisible(false);
							break;
						}
					}
					if(login==false)
					{
						JOptionPane.showMessageDialog(null, "Customer Number not founded!");
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		btnNewButton.setBounds(460, 330, 114, 41);
		frmBankSystem.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(46, 139, 87));
		btnReset.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		btnReset.setBounds(581, 330, 114, 41);
		frmBankSystem.getContentPane().add(btnReset);
		
		JButton btnCreateAccount = new JButton("Create Customer");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				CreateNewCustomerFrame frame = new CreateNewCustomerFrame();
				frame.setVisible(true);
			}
		});
		btnCreateAccount.setForeground(new Color(255, 255, 255));
		btnCreateAccount.setBackground(new Color(46, 139, 87));
		btnCreateAccount.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		btnCreateAccount.setBounds(460, 385, 235, 41);
		frmBankSystem.getContentPane().add(btnCreateAccount);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setLabelFor(passwordField);
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setFont(new Font("Roboto Slab", Font.BOLD, 24));
		lblPassword.setBounds(324, 272, 125, 27);
		frmBankSystem.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Bank System");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(46, 139, 87));
		lblNewLabel_1.setFont(new Font("Roboto Slab", Font.BOLD, 40));
		lblNewLabel_1.setBounds(250, 61, 500, 53);
		frmBankSystem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\background.jpg"));
		lblNewLabel.setBounds(0, 0, 982, 653);
		frmBankSystem.getContentPane().add(lblNewLabel);
	}
}
