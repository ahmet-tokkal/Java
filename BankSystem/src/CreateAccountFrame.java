import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class CreateAccountFrame extends JFrame {

	private JPanel contentPane;
	private Database db = Login.getDb();
	private ArrayList<Address> addresses = db.dbGetAddresses();
	private JComboBox cmbBxAddress;
	private ArrayList<Bank> banks = db.dbGetBanks();
	private JComboBox cmbBxBanks;
	private ArrayList<Branch> branches = db.dbGetBranches();
	private JComboBox cmbBxBranches;
	public CreateAccountFrame(Customer customer) {
		setResizable(false);
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccNumber = new JLabel();
		lblAccNumber.setBackground(Color.ORANGE);
		lblAccNumber.setForeground(new Color(0, 0, 0));
		lblAccNumber.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAccNumber.setBounds(224, 48, 200, 25);
		lblAccNumber.setText(Integer.toString(db.dbGetId("Accounts")+1));
		contentPane.add(lblAccNumber);
		
		JLabel lblCustName = new JLabel(customer.customerName);
		lblCustName.setForeground(Color.BLACK);
		lblCustName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCustName.setBackground(Color.ORANGE);
		lblCustName.setBounds(224, 86, 200, 25);
		contentPane.add(lblCustName);
		
		JLabel lblAccountNumber = new JLabel("Account Number :");
		lblAccountNumber.setForeground(Color.ORANGE);
		lblAccountNumber.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAccountNumber.setBounds(12, 48, 200, 25);
		contentPane.add(lblAccountNumber);
		
		JLabel lblNewLabel = new JLabel("Customer Name :");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 86, 200, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(Color.ORANGE);
		lblAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAddress.setBounds(12, 168, 200, 25);
		contentPane.add(lblAddress);
		
		cmbBxAddress = new JComboBox();
		cmbBxAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxAddress.setBounds(224, 165, 518, 30);
		FillAddresses();
		contentPane.add(cmbBxAddress);
		
		JButton btnNewAddress = new JButton("New Address");
		btnNewAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NewAddressFrame frame = new NewAddressFrame(customer);
				frame.setVisible(true);
				CreateAccountFrame.this.setVisible(false);
				CreateAccountFrame.this.dispose();
			}
		});
		btnNewAddress.setBackground(new Color(0, 0, 128));
		btnNewAddress.setForeground(new Color(255, 255, 255));
		btnNewAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnNewAddress.setBounds(754, 163, 173, 30);
		contentPane.add(btnNewAddress);
		
		JLabel lblBank = new JLabel("Bank :");
		lblBank.setForeground(Color.ORANGE);
		lblBank.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBank.setBounds(12, 206, 200, 25);
		contentPane.add(lblBank);
		
		cmbBxBanks = new JComboBox();
		cmbBxBanks.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxBanks.setBounds(224, 203, 267, 30);
		FillBanks();
		contentPane.add(cmbBxBanks);
		
		JButton btnNewBank = new JButton("New Bank");
		btnNewBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NewBankFrame frame = new NewBankFrame(customer);
				frame.setVisible(true);
				CreateAccountFrame.this.setVisible(false);
				CreateAccountFrame.this.dispose();
			}
		});
		btnNewBank.setBackground(new Color(0, 0, 128));
		btnNewBank.setForeground(new Color(255, 255, 255));
		btnNewBank.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnNewBank.setBounds(754, 201, 173, 30);
		contentPane.add(btnNewBank);
		
		JLabel lblBranch = new JLabel("Branch :");
		lblBranch.setForeground(Color.ORANGE);
		lblBranch.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBranch.setBounds(12, 244, 200, 25);
		contentPane.add(lblBranch);
		
		cmbBxBranches = new JComboBox();
		cmbBxBranches.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxBranches.setBounds(224, 241, 267, 30);
		FillBranches();
		contentPane.add(cmbBxBranches);
		
		JButton btnNewBranches = new JButton("New Branch");
		btnNewBranches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NewBranchFrame frame = new NewBranchFrame(customer);
				frame.setVisible(true);
				CreateAccountFrame.this.setVisible(false);
				CreateAccountFrame.this.dispose();
			}
		});
		btnNewBranches.setBackground(new Color(0, 0, 128));
		btnNewBranches.setForeground(new Color(255, 255, 255));
		btnNewBranches.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnNewBranches.setBounds(754, 239, 173, 30);
		contentPane.add(btnNewBranches);
		
		JLabel lblMonthlyBalance = new JLabel("Monthly Balance :");
		lblMonthlyBalance.setForeground(Color.ORANGE);
		lblMonthlyBalance.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblMonthlyBalance.setBounds(12, 284, 200, 25);
		contentPane.add(lblMonthlyBalance);
		
		JComboBox cmbBxMontBalances = new JComboBox();
		cmbBxMontBalances.setModel(new DefaultComboBoxModel(new String[] {"500.00", "1000.00", "5000.00", "10000.00", "20000.00", "50000.00", "100000.00"}));
		cmbBxMontBalances.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxMontBalances.setBounds(224, 281, 267, 30);
		contentPane.add(cmbBxMontBalances);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setForeground(Color.ORANGE);
		lblAccountType.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAccountType.setBounds(12, 128, 200, 25);
		contentPane.add(lblAccountType);
		
		JComboBox cmbBxAccountType = new JComboBox();
		cmbBxAccountType.setModel(new DefaultComboBoxModel(new String[] {"Dated", "Undated"}));
		cmbBxAccountType.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxAccountType.setBounds(224, 125, 200, 30);
		contentPane.add(cmbBxAccountType);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AccountFactory accountFactory= new AccountFactory();
				IAccount account = accountFactory.getAccount(cmbBxAccountType.getSelectedItem().toString());
				
				ArrayList<AccountDataMart> adms = new ArrayList<AccountDataMart>();
				AccountDataMart adm = new AccountDataMart();
				adm.factID=db.dbGetId("[Accounts Data Mart]")+1;
				adms.add(adm);
				TransactionDataMart tdm=new TransactionDataMart();
				
				
				adm.AddAddress(addresses.get(cmbBxAddress.getSelectedIndex()));
				adm.AddBank(banks.get(cmbBxBanks.getSelectedIndex()));
				adm.AddBranch(branches.get(cmbBxBranches.getSelectedIndex()));
				
				MonthlyBalance mb=new MonthlyBalance();
				mb.monthlyBalanceID=db.dbGetId("MonthlyBalances")+1;
				mb.monthlyBalance=Double.parseDouble(cmbBxMontBalances.getSelectedItem().toString());
				db.dbAddMonthlyBalance(mb);
				adm.AddMBalance(mb);
				RefAccountStatus rAS=new RefAccountStatus();
				rAS.accountStatusCode=db.dbGetId("[RefAccountStatus]")+1;
				rAS.accountStatus=Status.ACTIVE;
				db.dbAddAccountStatus(rAS);
				adm.AddRefAccountSta(rAS);
				RefAccountType rAT= new RefAccountType();
				rAT.accountTypeCode=db.dbGetId("RefAccountTypes")+1;
				rAT.accountType=AccountTypes.Checking;
				db.dbAddAccountType(rAT);
				adm.AddRefAccountTypes(rAT);
				adm.AddCustomer(customer);
				RefBranchType rBT=new RefBranchType();
				rBT.branchTypeCode=db.dbGetId("RefBranchTypes")+1;
				rBT.branchType=BranchTypes.SMALL;
				db.dbAddRefBranchType(rBT);
				adm.AddRefBranchType(rBT);
				
				account.setAccountData(Integer.parseInt(lblAccNumber.getText()), 0.0, adms, tdm);
				adm.AddAccount(account);
				account.add();
				db.dbAddAccDataMart(adm);
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
				Application frame = new Application(customer);
				frame.setVisible(true);
			}
		});
		btnCreateAccount.setBackground(new Color(0, 0, 128));
		btnCreateAccount.setForeground(new Color(255, 255, 255));
		btnCreateAccount.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnCreateAccount.setBounds(350, 366, 190, 40);
		contentPane.add(btnCreateAccount);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				dispose(); 
				Application frame = new Application(customer);
				frame.setVisible(true);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnCancel.setBackground(new Color(0, 0, 128));
		btnCancel.setBounds(552, 366, 190, 40);
		contentPane.add(btnCancel);
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\bgAccount.png"));
		label_1.setBounds(0, 0, 994, 435);
		contentPane.add(label_1);
	}
	public void FillAddresses()
	{
		for(int i=0; i<this.addresses.size();i++)
		{
			String str = addresses.get(i).address+" - "+addresses.get(i).city+" - "+addresses.get(i).postalCode+" - "+addresses.get(i).country;
			cmbBxAddress.addItem(str);
		}
	}
	public void FillBanks()
	{
		for(int i=0; i<this.banks.size();i++)
		{
			String str = banks.get(i).bankName;
			cmbBxBanks.addItem(str);
		}
	}
	public void FillBranches()
	{
		for(int i=0; i<this.branches.size();i++)
		{
			String str = branches.get(i).branchName;
			cmbBxBranches.addItem(str);
		}
	}
}
