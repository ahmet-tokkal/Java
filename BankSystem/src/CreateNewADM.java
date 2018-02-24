import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CreateNewADM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Database db = Login.getDb();
	private ArrayList<Address> addresses = db.dbGetAddresses();
	private ArrayList<Bank> banks = db.dbGetBanks();
	private ArrayList<Branch> branches = db.dbGetBranches();
	private JComboBox cmbBxAddress,cmbBxBanks,cmbBxBranches;
	public CreateNewADM(IAccount account,Customer customer) {
		setBounds(100, 100, 1000, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(220, 20, 60));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Address :");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label.setBounds(25, 67, 200, 25);
		contentPanel.add(label);
		
		cmbBxAddress = new JComboBox();
		cmbBxAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxAddress.setBounds(237, 64, 530, 30);
		FillAddresses();
		contentPanel.add(cmbBxAddress);
		
		JButton button = new JButton("New Address");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NewAddressFrame frame = new NewAddressFrame(customer);
				frame.setVisible(true);
				CreateNewADM.this.setVisible(false);
				CreateNewADM.this.dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(797, 64, 173, 30);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("New Bank");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NewBankFrame frame = new NewBankFrame(customer);
				frame.setVisible(true);
				CreateNewADM.this.setVisible(false);
				CreateNewADM.this.dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(797, 105, 173, 30);
		contentPanel.add(button_1);
		
		cmbBxBanks = new JComboBox();
		cmbBxBanks.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxBanks.setBounds(237, 102, 300, 30);
		FillBanks();
		contentPanel.add(cmbBxBanks);
		
		JLabel label_1 = new JLabel("Bank :");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_1.setBounds(25, 105, 200, 25);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Branch :");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_2.setBounds(25, 143, 200, 25);
		contentPanel.add(label_2);
		
		cmbBxBranches = new JComboBox();
		cmbBxBranches.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxBranches.setBounds(237, 140, 300, 30);
		FillBranches();
		contentPanel.add(cmbBxBranches);
		
		JButton button_2 = new JButton("New Branch");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NewBranchFrame frame = new NewBranchFrame(customer);
				frame.setVisible(true);
				CreateNewADM.this.setVisible(false);
				CreateNewADM.this.dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 0, 128));
		button_2.setBounds(797, 143, 173, 30);
		contentPanel.add(button_2);
		
		JComboBox cmbBxMBalances = new JComboBox();
		cmbBxMBalances.setModel(new DefaultComboBoxModel(new String[] {"500.00", "1000.00", "5000.00", "10000.00", "20000.00", "50000.00", "100000.00"}));
		cmbBxMBalances.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxMBalances.setBounds(237, 180, 300, 30);
		contentPanel.add(cmbBxMBalances);
		
		JLabel label_3 = new JLabel("Monthly Balance :");
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_3.setBounds(25, 183, 200, 25);
		contentPanel.add(label_3);
		
		JLabel lblBranchType = new JLabel("Branch Type :");
		lblBranchType.setForeground(Color.ORANGE);
		lblBranchType.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBranchType.setBounds(25, 228, 200, 25);
		contentPanel.add(lblBranchType);
		
		JComboBox cmbBxBrTypes = new JComboBox();
		cmbBxBrTypes.setModel(new DefaultComboBoxModel(BranchTypes.values()));
		cmbBxBrTypes.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		cmbBxBrTypes.setBounds(237, 225, 300, 30);
		contentPanel.add(cmbBxBrTypes);
		
		JLabel lblCreateNewData = new JLabel("Create New Data Mart");
		lblCreateNewData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewData.setBackground(new Color(25, 25, 112));
		lblCreateNewData.setForeground(new Color(255, 255, 255));
		lblCreateNewData.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCreateNewData.setBounds(358, 13, 232, 38);
		contentPanel.add(lblCreateNewData);
		{
			JButton okButton = new JButton("Add");
			okButton.setBounds(734, 298, 112, 35);
			contentPanel.add(okButton);
			okButton.setBackground(new Color(25, 25, 112));
			okButton.setForeground(Color.WHITE);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					AccountDataMart adm = new AccountDataMart();
					adm.factID=db.dbGetId("[Accounts Data Mart]")+1;
					adm.AddAccount(account);
					adm.AddAddress(addresses.get(cmbBxAddress.getSelectedIndex()));
					adm.AddBank(banks.get(cmbBxBanks.getSelectedIndex()));
					adm.AddBranch(branches.get(cmbBxBranches.getSelectedIndex()));
					MonthlyBalance mb=new MonthlyBalance();
					mb.monthlyBalanceID=db.dbGetId("MonthlyBalances")+1;
					mb.monthlyBalance=Double.parseDouble(cmbBxMBalances.getSelectedItem().toString());
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
					BranchTypes type = (BranchTypes)cmbBxBrTypes.getSelectedItem();
					rBT.branchType=type;
					db.dbAddRefBranchType(rBT);
					adm.AddRefBranchType(rBT);
					account.AddADM(adm);
					db.dbAddAccDataMart(adm);
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
					AccountDetails frame = new AccountDetails(account,customer);
					frame.setVisible(true);
				}
			});
			okButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(858, 298, 112, 35);
			contentPanel.add(cancelButton);
			cancelButton.setBackground(new Color(25, 25, 112));
			cancelButton.setForeground(Color.WHITE);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
					AccountDetails frame = new AccountDetails(account,customer);
					frame.setVisible(true);
				}
			});
			cancelButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\bgAccount.png"));
		label_4.setBounds(0, 0, 982, 345);
		contentPanel.add(label_4);
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
