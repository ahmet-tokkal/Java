import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccountDetails extends JFrame {

	private JPanel contentPane;
	private Database db = Login.getDb();
	private boolean state=true;
	public JTextField lblAdd,lblC,lblPC,lblCo,lblBN,lblBrN,lblBT,lblAS;
	public AccountDetails(IAccount account,Customer customer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 982, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblAccountStatus = new JLabel("Account Status:");
		lblAccountStatus.setBackground(Color.GREEN);
		lblAccountStatus.setOpaque(true);
		lblAccountStatus.setForeground(new Color(255, 255, 255));
		lblAccountStatus.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAccountStatus.setBounds(360, 567, 155, 27);
		contentPane.add(lblAccountStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setBounds(153, 76, 676, 151);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number :");
		lblAccountNumber.setOpaque(true);
		lblAccountNumber.setBackground(new Color(25, 25, 112));
		lblAccountNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountNumber.setBounds(12, 7, 180, 27);
		panel_1.add(lblAccountNumber);
		lblAccountNumber.setForeground(new Color(255, 255, 255));
		lblAccountNumber.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setOpaque(true);
		lblBalance.setBackground(new Color(25, 25, 112));
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBounds(12, 41, 180, 27);
		panel_1.add(lblBalance);
		lblBalance.setForeground(new Color(255, 255, 255));
		lblBalance.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblCreatedDate = new JLabel("Created Date:");
		lblCreatedDate.setOpaque(true);
		lblCreatedDate.setBackground(new Color(25, 25, 112));
		lblCreatedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreatedDate.setBounds(12, 75, 180, 27);
		panel_1.add(lblCreatedDate);
		lblCreatedDate.setForeground(new Color(255, 255, 255));
		lblCreatedDate.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JTextField lblBa = new JTextField("");
		lblBa.setEditable(false);
		lblBa.setOpaque(true);
		lblBa.setHorizontalAlignment(SwingConstants.LEFT);
		lblBa.setForeground(new Color(25, 25, 112));
		lblBa.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBa.setBackground(Color.WHITE);
		lblBa.setBounds(204, 41, 462, 27);
		lblBa.setText(Double.toString((double)account.getAccountData(1)));
		panel_1.add(lblBa);
		
		JTextField lblCD = new JTextField("");
		lblCD.setEditable(false);
		lblCD.setOpaque(true);
		lblCD.setHorizontalAlignment(SwingConstants.LEFT);
		lblCD.setForeground(new Color(25, 25, 112));
		lblCD.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCD.setBackground(Color.WHITE);
		lblCD.setBounds(204, 75, 462, 27);
		lblCD.setText((String)account.getAccountData(2));
		panel_1.add(lblCD);
		
		JTextField lblAN = new JTextField();
		lblAN.setEditable(false);
		lblAN.setOpaque(true);
		lblAN.setHorizontalAlignment(SwingConstants.LEFT);
		lblAN.setForeground(new Color(25, 25, 112));
		lblAN.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAN.setBackground(Color.WHITE);
		lblAN.setBounds(204, 7, 462, 27);
		lblAN.setText(Integer.toString((int)account.getAccountData(0)));
		panel_1.add(lblAN);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setOpaque(true);
		lblAccountType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountType.setForeground(Color.WHITE);
		lblAccountType.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAccountType.setBackground(new Color(25, 25, 112));
		lblAccountType.setBounds(12, 111, 180, 27);
		panel_1.add(lblAccountType);
		
		JTextField txFldAccountType = new JTextField();
		txFldAccountType.setText("0");
		txFldAccountType.setOpaque(true);
		txFldAccountType.setHorizontalAlignment(SwingConstants.LEFT);
		txFldAccountType.setForeground(new Color(25, 25, 112));
		txFldAccountType.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txFldAccountType.setEditable(false);
		txFldAccountType.setBackground(Color.WHITE);
		txFldAccountType.setBounds(204, 111, 462, 27);
		txFldAccountType.setText((String)account.getAccountData(5));
		panel_1.add(txFldAccountType);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(153, 265, 676, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setOpaque(true);
		lblAddress.setBackground(new Color(25, 25, 112));
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(12, 10, 180, 27);
		panel.add(lblAddress);
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setOpaque(true);
		lblCity.setBackground(new Color(25, 25, 112));
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(12, 47, 180, 27);
		panel.add(lblCity);
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setOpaque(true);
		lblPostalCode.setBackground(new Color(25, 25, 112));
		lblPostalCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostalCode.setBounds(12, 84, 180, 27);
		panel.add(lblPostalCode);
		lblPostalCode.setForeground(new Color(255, 255, 255));
		lblPostalCode.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setOpaque(true);
		lblCountry.setBackground(new Color(25, 25, 112));
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setBounds(12, 121, 180, 27);
		panel.add(lblCountry);
		lblCountry.setForeground(new Color(255, 255, 255));
		lblCountry.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		
		
		
		lblAdd = new JTextField("");
		lblAdd.setEditable(false);
		lblAdd.setOpaque(true);
		lblAdd.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdd.setForeground(new Color(25, 25, 112));
		lblAdd.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAdd.setBackground(Color.WHITE);
		lblAdd.setBounds(204, 10, 462, 27);
		panel.add(lblAdd);
		
		lblC = new JTextField("");
		lblC.setEditable(false);
		lblC.setOpaque(true);
		lblC.setHorizontalAlignment(SwingConstants.LEFT);
		lblC.setForeground(new Color(25, 25, 112));
		lblC.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblC.setBackground(Color.WHITE);
		lblC.setBounds(204, 47, 462, 27);
		panel.add(lblC);
		
		lblPC = new JTextField("");
		lblPC.setEditable(false);
		lblPC.setOpaque(true);
		lblPC.setHorizontalAlignment(SwingConstants.LEFT);
		lblPC.setForeground(new Color(25, 25, 112));
		lblPC.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblPC.setBackground(Color.WHITE);
		lblPC.setBounds(204, 84, 462, 27);
		panel.add(lblPC);
		
		lblCo = new JTextField("");
		lblCo.setEditable(false);
		lblCo.setOpaque(true);
		lblCo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCo.setForeground(new Color(25, 25, 112));
		lblCo.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCo.setBackground(Color.WHITE);
		lblCo.setBounds(204, 121, 462, 27);
		panel.add(lblCo);
		
		JLabel lblBankName = new JLabel("Bank Name:");
		lblBankName.setBounds(12, 158, 180, 27);
		panel.add(lblBankName);
		lblBankName.setOpaque(true);
		lblBankName.setBackground(new Color(25, 25, 112));
		lblBankName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBankName.setForeground(new Color(255, 255, 255));
		lblBankName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblBranchName = new JLabel("Branch Name:");
		lblBranchName.setBounds(12, 195, 180, 27);
		panel.add(lblBranchName);
		lblBranchName.setOpaque(true);
		lblBranchName.setBackground(new Color(25, 25, 112));
		lblBranchName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBranchName.setForeground(new Color(255, 255, 255));
		lblBranchName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		
		JLabel lblBranchType = new JLabel("Branch Type:");
		lblBranchType.setBounds(12, 232, 180, 27);
		panel.add(lblBranchType);
		lblBranchType.setOpaque(true);
		lblBranchType.setBackground(new Color(25, 25, 112));
		lblBranchType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBranchType.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBranchType.setForeground(new Color(255, 255, 255));
		
		lblBN = new JTextField("");
		lblBN.setBounds(204, 158, 462, 27);
		panel.add(lblBN);
		lblBN.setEditable(false);
		lblBN.setOpaque(true);
		lblBN.setHorizontalAlignment(SwingConstants.LEFT);
		lblBN.setForeground(new Color(25, 25, 112));
		lblBN.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBN.setBackground(Color.WHITE);
		
		lblBrN = new JTextField("");
		lblBrN.setBounds(204, 195, 462, 27);
		panel.add(lblBrN);
		lblBrN.setEditable(false);
		lblBrN.setOpaque(true);
		lblBrN.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrN.setForeground(new Color(25, 25, 112));
		lblBrN.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBrN.setBackground(Color.WHITE);
		
		lblBT = new JTextField("");
		lblBT.setBounds(204, 232, 462, 27);
		panel.add(lblBT);
		lblBT.setEditable(false);
		lblBT.setOpaque(true);
		lblBT.setHorizontalAlignment(SwingConstants.LEFT);
		lblBT.setForeground(new Color(25, 25, 112));
		lblBT.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBT.setBackground(Color.WHITE);
		
		lblAS = new JTextField("");
		lblAS.setEditable(false);
		lblAS.setOpaque(true);
		lblAS.setForeground(Color.GREEN);
		lblAS.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAS.setBackground(Color.WHITE);
		lblAS.setBounds(527, 567, 155, 27);
		contentPane.add(lblAS);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				dispose(); 
				Application frame = new Application(customer);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setFont(new Font("Roboto Slab", Font.BOLD, 30));
		btnNewButton_1.setBounds(839, 592, 131, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				CreateNewADM frame = new CreateNewADM(account,customer);
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNew.setForeground(new Color(255, 255, 255));
		btnNew.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnNew.setBackground(new Color(25, 25, 112));
		btnNew.setBounds(739, 230, 90, 35);
		contentPane.add(btnNew);
		JLabel label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\app-backg.png"));
		label.setBounds(0, 0, 982, 653);
		contentPane.add(label);
		
		FillData(account,0);
		AddButton(account);
	}
	public void FillData(IAccount account,int i)
	{
		lblAdd.setText(db.dbGetData("Addresses", "Address","[Address ID]", account.getADM(i).addressID));
		lblC.setText(db.dbGetData("Addresses", "City","[Address ID]",account.getADM(i).addressID));
		lblPC.setText(db.dbGetData("Addresses", "[Postal Code]","[Address ID]", account.getADM(i).addressID));
		lblCo.setText(db.dbGetData("Addresses", "Country","[Address ID]", account.getADM(i).addressID));
		lblBN.setText(db.dbGetData("Banks", "[Bank Name]","[Bank ID]", account.getADM(i).bankID));
		lblBrN.setText(db.dbGetData("Branches", "[Branch Name]","[Branch ID]", account.getADM(i).branchID));
		lblBT.setText(db.dbGetData("RefBranchTypes", "[Branch Type]","[Branch Type Code]", account.getADM(i).branchTypeCode));
		lblAS.setText(db.dbGetData("RefAccountStatus", "[Account Status]","[Account Status Code]", account.getADM(i).accountStatusCode));
		
	}
	public void AddButton(IAccount account) 
	{
		int x =153;
		int y=230;
		ArrayList<AccountDataMart> list =(ArrayList<AccountDataMart>) account.getAccountData(3);
		for(int i =0;i<list.size();i++)
		{
			int id=i;
			JButton btn= new JButton(Integer.toString(id+1));
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					FillData(account,id);
				};
			});
			btn.setBackground(new Color(255, 255, 255));
			btn.setForeground(new Color(25, 25, 112));
			btn.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			btn.setBounds(x, y, 53, 35);
			x+=53;
			contentPane.add(btn);
			contentPane.validate();
			contentPane.repaint();
		}
	    
	}
	
}
