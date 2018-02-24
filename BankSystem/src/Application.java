import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Application extends JFrame {
	private JButton btnCloseAccount;
	private JButton btnAccountDetails ;
	private JPanel panelAccounts;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<IAccount> accounts;
	private Database db =Login.getDb();
	private JPasswordField pswFldConf;
	private JPasswordField pswFld;
	private JTextField txFldPhNbr;
	private JTextField txFldCusNm;
	JPanel panelSettings ;
	private boolean state=false;
	public Application(Customer customer) {
		accounts=db.dbGetAccounts();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome "+customer.customerName);
		lblWelcome.setOpaque(true);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBackground(new Color(25, 25, 112));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Roboto Slab", Font.BOLD, 25));
		lblWelcome.setBounds(27, 13, 912, 32);
		contentPane.add(lblWelcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(27, 89, 248, 551);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnMyAccounts = new JButton("My Accounts");
		btnMyAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelAccounts.setVisible(true);
				panelSettings.setVisible(false);
			}
		});
		btnMyAccounts.setBounds(24, 112, 200, 30);
		btnMyAccounts.setForeground(new Color(25, 25, 112));
		btnMyAccounts.setBackground(new Color(255, 255, 255));
		btnMyAccounts.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		panel_1.add(btnMyAccounts);
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panelAccounts.setVisible(false);
				panelSettings.setVisible(false);
			}
		});
		btnTransactions.setBounds(24, 242, 200, 30);
		btnTransactions.setForeground(new Color(25, 25, 112));
		btnTransactions.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnTransactions.setBackground(new Color(255, 255, 255));
		panel_1.add(btnTransactions);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panelSettings.setVisible(true);
				panelAccounts.setVisible(false);
			}
		});
		btnSettings.setForeground(new Color(25, 25, 112));
		btnSettings.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnSettings.setBackground(new Color(255, 255, 255));
		btnSettings.setBounds(24, 375, 200, 30);
		panel_1.add(btnSettings);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String ObjButtons[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Bank System",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            dispose();
		            Login.getInstance().frmBankSystem.setVisible(true);
		        }
			}
		});
		btnExit.setForeground(new Color(25, 25, 112));
		btnExit.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(24, 506, 200, 30);
		panel_1.add(btnExit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\ext.png"));
		label_1.setBounds(24, 404, 200, 104);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\stg.png"));
		label_2.setBounds(24, 271, 200, 104);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\tranaction.png"));
		label_3.setBounds(24, 140, 200, 104);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\acc.png"));
		label_4.setBounds(24, 13, 200, 104);
		panel_1.add(label_4);
		ResultSet rs = db.dbGetAccountByResultSet(customer.customerID);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(178, 34, 34));
		layeredPane.setBounds(307, 89, 644, 551);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		panelSettings = new JPanel();
		panelSettings.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panelSettings.setBackground(new Color(178, 34, 34));
		panelSettings.setBounds(0, 0, 644, 452);
		layeredPane.add(panelSettings);
		panelSettings.setLayout(null);
		panelSettings.setVisible(false);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setBounds(12, 13, 620, 39);
		lblSettings.setOpaque(true);
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setForeground(new Color(224, 255, 255));
		lblSettings.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblSettings.setBackground(new Color(25, 25, 112));
		panelSettings.add(lblSettings);
		
		JLabel label_5 = new JLabel("Customer Number :");
		label_5.setForeground(Color.ORANGE);
		label_5.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_5.setBounds(12, 78, 193, 25);
		panelSettings.add(label_5);
		
		JLabel label_6 = new JLabel("Customer Name :");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_6.setBounds(12, 134, 166, 25);
		panelSettings.add(label_6);
		
		JLabel label_7 = new JLabel("Phone Number :");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_7.setBounds(12, 204, 166, 25);
		panelSettings.add(label_7);
		
		JLabel label_8 = new JLabel("Password :");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_8.setBounds(12, 274, 166, 25);
		panelSettings.add(label_8);
		
		JLabel label_9 = new JLabel("Confirm Password :");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_9.setBounds(12, 337, 193, 25);
		panelSettings.add(label_9);
		
		pswFldConf = new JPasswordField();
		pswFldConf.setEditable(false);
		pswFldConf.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		pswFldConf.setBounds(217, 334, 200, 30);
		panelSettings.add(pswFldConf);
		
		pswFld = new JPasswordField();
		pswFld.setEditable(false);
		pswFld.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		pswFld.setBounds(217, 271, 200, 30);
		pswFld.setText(customer.password);
		panelSettings.add(pswFld);
		
		txFldPhNbr = new JTextField();
		txFldPhNbr.setEditable(false);
		txFldPhNbr.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txFldPhNbr.setColumns(10);
		txFldPhNbr.setBounds(217, 201, 200, 30);
		txFldPhNbr.setText(customer.phoneNumber);
		panelSettings.add(txFldPhNbr);
		
		txFldCusNm = new JTextField();
		txFldCusNm.setEditable(false);
		txFldCusNm.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txFldCusNm.setColumns(10);
		txFldCusNm.setBounds(217, 131, 200, 30);
		txFldCusNm.setText(customer.customerName);
		panelSettings.add(txFldCusNm);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\customers-icon.fw.png"));
		label_10.setBounds(452, 97, 150, 150);
		panelSettings.add(label_10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(25, 25, 112));
		btnEdit.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		btnEdit.setBounds(535, 400, 97, 39);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(state==false)
				{
					btnEdit.setText("Save");
					txFldCusNm.setEditable(true);
					txFldPhNbr.setEditable(true);
					pswFld.setEditable(true);
					pswFldConf.setEditable(true);
					state=true;
				}
				else 
				{
					btnEdit.setText("Edit");
					if(Arrays.equals(pswFld.getPassword(), pswFldConf.getPassword()))
					{
						customer.customerName=txFldCusNm.getText();
						customer.phoneNumber=txFldPhNbr.getText();
						String password = new String(pswFld.getPassword());
						customer.password=password;
						db.dbUpdateCustomer(customer);
						txFldCusNm.setEditable(false);
						txFldPhNbr.setEditable(false);
						pswFld.setEditable(false);
						pswFldConf.setEditable(false);
						state=false;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Passwords aren't matched !");
					}
				}
			}
		});
		
		panelSettings.add(btnEdit);
		
		JLabel label_11 = new JLabel("1");
		label_11.setForeground(new Color(255, 255, 255));
		label_11.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		label_11.setBounds(217, 78, 202, 25);
		label_11.setText(Integer.toString(customer.customerID));
		panelSettings.add(label_11);
		
		panelAccounts = new JPanel();
		panelAccounts.setBounds(0, 0, 632, 374);
		layeredPane.add(panelAccounts);
		panelAccounts.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panelAccounts.setBackground(new Color(178, 34, 34));
		panelAccounts.setLayout(null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setFont(new Font("Roboto Slab", Font.PLAIN, 18));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(178, 34, 34));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(1).setMinWidth(170);
		table.getColumnModel().getColumn(1).setMaxWidth(170);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(178);
		table.getColumnModel().getColumn(2).setMinWidth(178);
		table.getColumnModel().getColumn(2).setMaxWidth(178);
		table.setBounds(10, 94, 614, 218);
		panelAccounts.add(table);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				btnCloseAccount.setEnabled(true);
				btnAccountDetails.setEnabled(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 165, 0));
		separator.setForeground(new Color(255, 165, 0));
		separator.setBounds(10, 83, 614, 3);
		panelAccounts.add(separator);
		
		JLabel lblAccounNumber = new JLabel("Account Number");
		lblAccounNumber.setOpaque(true);
		lblAccounNumber.setForeground(new Color(255, 255, 255));
		lblAccounNumber.setBackground(new Color(0, 0, 0));
		lblAccounNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccounNumber.setFont(new Font("Roboto Slab", Font.BOLD, 16));
		lblAccounNumber.setBounds(10, 57, 204, 25);
		panelAccounts.add(lblAccounNumber);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setOpaque(true);
		lblBalance.setForeground(new Color(255, 255, 255));
		lblBalance.setBackground(new Color(0, 0, 0));
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setFont(new Font("Roboto Slab", Font.BOLD, 16));
		lblBalance.setBounds(214, 57, 204, 25);
		panelAccounts.add(lblBalance);
		
		JLabel lblCreatedDate = new JLabel("Created Date");
		lblCreatedDate.setOpaque(true);
		lblCreatedDate.setForeground(new Color(255, 255, 255));
		lblCreatedDate.setBackground(new Color(0, 0, 0));
		lblCreatedDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedDate.setFont(new Font("Roboto Slab", Font.BOLD, 16));
		lblCreatedDate.setBounds(418, 57, 206, 25);
		panelAccounts.add(lblCreatedDate);
		
		JButton btnCreateNewAccount = new JButton("New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				CreateAccountFrame frame = new CreateAccountFrame(customer);
				frame.setVisible(true);
				Application.this.setVisible(false);
				Application.this.dispose();
			}
		});
		btnCreateNewAccount.setFont(new Font("Roboto Slab", Font.BOLD, 16));
		btnCreateNewAccount.setForeground(new Color(255, 255, 255));
		btnCreateNewAccount.setBackground(new Color(0, 0, 128));
		btnCreateNewAccount.setBounds(35, 326, 165, 35);
		panelAccounts.add(btnCreateNewAccount);
		
		btnAccountDetails = new JButton("Account Details");
		btnAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AccountDetails frame = new AccountDetails(db.dbGetAccountById(table.getValueAt(table.getSelectedRow(), 0)),customer);
				frame.setVisible(true);
				Application.this.setVisible(false);
				Application.this.dispose();
			}
		});
		btnAccountDetails.setEnabled(false);
		btnAccountDetails.setForeground(Color.WHITE);
		btnAccountDetails.setFont(new Font("Roboto Slab", Font.BOLD, 16));
		btnAccountDetails.setBackground(new Color(0, 0, 128));
		btnAccountDetails.setBounds(235, 326, 165, 35);
		panelAccounts.add(btnAccountDetails);
		
		btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String ObjButtons[] = {"Yes","No"};
				int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete Account?","Bank System",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	db.dbDelById("Accounts", "[Account Number]", table.getValueAt(table.getSelectedRow(),0));
					ResultSet rs = db.dbGetAccountByResultSet(customer.customerID);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					btnAccountDetails.setEnabled(false);
					btnCloseAccount.setEnabled(false);
		        }
				
			}
		});
		btnCloseAccount.setEnabled(false);
		btnCloseAccount.setForeground(Color.WHITE);
		btnCloseAccount.setFont(new Font("Roboto Slab", Font.BOLD, 16));
		btnCloseAccount.setBackground(new Color(0, 0, 128));
		btnCloseAccount.setBounds(435, 326, 165, 35);
		panelAccounts.add(btnCloseAccount);
		
		JLabel lblAccounts = new JLabel("Accounts");
		lblAccounts.setOpaque(true);
		lblAccounts.setForeground(new Color(224, 255, 255));
		lblAccounts.setBackground(new Color(25, 25, 112));
		lblAccounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccounts.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblAccounts.setBounds(10, 13, 614, 48);
		panelAccounts.add(lblAccounts);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\Belgeler\\Eclipce WorkSpace\\BankSystem\\app-backg.png"));
		label.setBounds(0, 0, 982, 653);
		contentPane.add(label);
	}
}
