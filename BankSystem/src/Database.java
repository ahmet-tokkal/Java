
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Database 
{
	private String url="jdbc:sqlserver://SKYWOLF;databaseName=BankSystem;integratedSecurity=true";
	protected Connection conn;
	
	public Database()
	{
		
	}
	public void dbConnect()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
			System.out.println("Connected");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void dbAddAccDataMart(AccountDataMart aDM)
	{
		int id;
		if(dbGetId("[Accounts Data Mart]")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("[Accounts Data Mart]")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO [Accounts Data Mart] VALUES("+id+","+aDM.accountNumber+","+aDM.accountStatusCode+","+aDM.accountTypeCode+","+aDM.addressID+
					","+aDM.bankID+","+aDM.branchID+","+aDM.branchTypeCode+","+aDM.customerID+","+aDM.monthlyBalanceID+")";
			statement.executeUpdate(strSquery);
			System.out.println("Account Data Mart added successfully !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddAccount(Account account)
	{
		int id;
		if(dbGetId("Accounts")==0)
		{
			id=1001;
		}
		else
		{
			id=dbGetId("Accounts")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO Accounts VALUES("+id+","+account.balance+",'"+account.createdDate+"',"+account.accountDMs.get(0).factID+","+account.transactionsDMs.get(0).factID+")";
			statement.executeUpdate(strSquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddAccountStatus(RefAccountStatus rAS)
	{
		int id;
		if(dbGetId("RefAccountStatus")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("RefAccountStatus")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO RefAccountStatus VALUES("+id+",'"+rAS.accountStatus+"')";
			statement.executeUpdate(strSquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddAccountType(RefAccountType rAT)
	{
		int id;
		if(dbGetId("RefAccountTypes")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("RefAccountTypes")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO RefAccountTypes VALUES("+id+",'"+rAT.accountType+"')";
			statement.executeUpdate(strSquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddRefBranchType(RefBranchType rBT)
	{
		int id;
		if(dbGetId("RefBranchTypes")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("RefBranchTypes")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO RefBranchTypes VALUES("+id+",'"+rBT.branchType+"')";
			statement.executeUpdate(strSquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddMonthlyBalance(MonthlyBalance mB)
	{
		int id;
		if(dbGetId("MonthlyBalances")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("MonthlyBalances")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO MonthlyBalances VALUES("+id+",'"+mB.monthlyBalance+"')";
			statement.executeUpdate(strSquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddAddress(Address adrs)
	{
		int id;
		if(dbGetId("Addresses")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("Addresses")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO Addresses VALUES("+id+",'"+adrs.address+"','"+adrs.city+"',"+adrs.postalCode+",'"+adrs.country+"')";
			statement.executeUpdate(strSquery);
			JOptionPane.showMessageDialog(null, "Address added successfully !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbAddCustomer(Customer customer)
	{
		int id;
		if(dbGetId("Customers")==0)
		{
			id=1;
		}
		else
		{
			id=dbGetId("Customers")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO Customers VALUES("+id+",'"+customer.customerName+"','"+customer.phoneNumber+"','"+customer.password+"')";
			statement.executeUpdate(strSquery);
			JOptionPane.showMessageDialog(null, "Customer created successfully !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Customer> dbGetCustomers()
	{
		ArrayList<Customer> customers= new ArrayList<Customer>();
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from Customers";
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				Customer customer = new Customer();
				customer.customerID=rs.getInt(1);
				customer.customerName=rs.getString(2);
				customer.phoneNumber=rs.getString(3);
				customer.password=rs.getString(4);
				customers.add(customer);
			}
			
			System.out.println("Customers have been loaded.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}
	public ArrayList<Branch> dbGetBranches()
	{
		ArrayList<Branch> branches= new ArrayList<Branch>();
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from Branches";
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				Branch branch = new Branch();
				branch.branchID=rs.getInt(1);
				branch.branchName=rs.getString(2);
				
				branches.add(branch);
			}
			
			System.out.println("Branches have been loaded.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return branches;
	}
	public ArrayList<Bank> dbGetBanks()
	{
		ArrayList<Bank> banks= new ArrayList<Bank>();
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from Banks";
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				Bank bnk = new Bank();
				bnk.bankID=rs.getInt(1);
				bnk.bankName=rs.getString(2);
				
				banks.add(bnk);
			}
			
			System.out.println("Banks have been loaded.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return banks;
	}
	public ArrayList<Address> dbGetAddresses()
	{
		ArrayList<Address> addresses= new ArrayList<Address>();
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from Addresses";
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				Address adrs = new Address();
				adrs.addressID=rs.getInt(1);
				adrs.address=rs.getString(2);
				adrs.city=rs.getString(3);
				adrs.postalCode=rs.getString(4);
				adrs.country=rs.getString(5);
				
				addresses.add(adrs);
			}
			
			System.out.println("Addresses have been loaded.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addresses;
	}
	
	public ArrayList<IAccount> dbGetAccounts()
	{
		ArrayList<IAccount> accounts= new ArrayList<IAccount>();
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from Accounts";
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				AccountFactory accountFactory= new AccountFactory();
				String x= rs.getObject(6).toString().replaceAll("\\s+","");
				IAccount acc = accountFactory.getAccount(x);
				acc.setAccountData(rs.getInt(1), rs.getDouble(2), dbGetAccountDataMartsByAN(rs.getInt(1)), new TransactionDataMart());
				accounts.add(acc);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	public IAccount dbGetAccountById(Object acN)
	{
		IAccount acc = null;
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from Accounts Where [Account Number]="+acN;
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				AccountFactory accountFactory= new AccountFactory();
				String x= rs.getObject(6).toString().replaceAll("\\s+","");
				acc = accountFactory.getAccount(x);
				acc.setAccountData(rs.getInt(1), rs.getDouble(2), dbGetAccountDataMartsByAN(rs.getInt(1)), new TransactionDataMart());
				return acc;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
	}
	
	public ArrayList<AccountDataMart> dbGetAccountDataMartsByAN(int an)
	{
		
		ArrayList<AccountDataMart> accountDataMarts= new ArrayList<AccountDataMart>();
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from [Accounts Data Mart] WHERE [Account Number]="+an;
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				AccountDataMart adm = new AccountDataMart();
				adm.factID=rs.getInt(1);
				adm.accountNumber=rs.getInt(2);
				adm.accountStatusCode=rs.getInt(3);
				adm.accountTypeCode=rs.getInt(4);
				adm.addressID=rs.getInt(5);
				adm.bankID=rs.getInt(6);
				adm.branchID=rs.getInt(7);
				adm.branchTypeCode=rs.getInt(8);
				adm.customerID=rs.getInt(9);
				adm.monthlyBalanceID=rs.getInt(10);	
				accountDataMarts.add(adm);
			}
			System.out.println("Account Data mart have been added.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountDataMarts;
	}
	public ResultSet dbGetAccountByResultSet(int customerId)
	{
		ResultSet rs = null;
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT Distinct acc.[Account Number],Balance,[Created Date] "
							+"FROM Accounts As acc INNER JOIN [Accounts Data Mart] As adm on acc.[Account Number]=adm.[Account Number] " 
							+"INNER JOIN Customers As cstm ON adm.[Customer ID]=cstm.[Customer ID] "
							+"WHERE cstm.[Customer ID]="+customerId;
			rs = statement.executeQuery(strSquery);
			System.out.println("Accounts have been listed.");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return rs;
		}
	}
	public int dbGetId(String table)
	{
		int id=0;
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="SELECT * from "+table;
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				if(id<rs.getInt(1))
				{
					id=rs.getInt(1);
				}
			}
			if(id==0 && (table!="Accounts" && table!="Customers"))
			{
				id=0;
			}
			if(id==0 && table=="Accounts")
			{
				id=1000;
			}
			if(id==0 && table=="Customers")
			{
				id=5000;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public void dbDelById(String table, String column,Object id)
	{
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="DELETE FROM "+table+" WHERE "+column+"="+id;
			statement.executeUpdate(strSquery);
			System.out.println("Account Data Mart added successfully !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String dbGetData(String table,String column,String idname, Object id)
	{
		String s="";
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="Select "+column+" FROM "+table+" WHERE "+idname+"="+id;
			ResultSet rs = statement.executeQuery(strSquery);
			while(rs.next())
			{
				s=rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public void dbUpdateCustomer(Customer customer)
	{
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="Update Customers Set [Customer Name]='"+customer.customerName+"',[Phone Number]='"
							+customer.phoneNumber+"',Password='"+customer.password+"' Where [Customer ID]="+customer.customerID;
			statement.executeUpdate(strSquery);
			JOptionPane.showMessageDialog(null, "Customer updated successfully !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
