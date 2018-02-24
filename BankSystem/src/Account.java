import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account  extends Database implements IAccount{
	public int accountNumber;
	public double balance;
	public String createdDate;
	public String accountType;
	
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	ArrayList<TransactionDataMart> transactionsDMs= new ArrayList<TransactionDataMart>();
	
	public Account()
	{
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.createdDate=sdf.format(date);
	};
	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}
	
	public void AddTDM(TransactionDataMart tDM)
	{
		transactionsDMs.add(tDM);
	}
	@Override
	public void add() 
	{
		dbConnect();
		if(dbGetId("Accounts")==0)
		{
			this.accountNumber=1001;
		}
		else
		{
			//this.accountNumber=dbGetId("Accounts")+1;
		}
		try 
		{
			Statement statement;
			statement = conn.createStatement();
			String strSquery="INSERT INTO Accounts VALUES("+this.accountNumber+","+this.balance+",'"+this.createdDate+"',"+this.accountDMs.get(0).factID+","+this.transactionsDMs.get(0).factID+",'"+this.accountType+"')";
			statement.executeUpdate(strSquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void setAccountData(int accNumber,double balance, ArrayList<AccountDataMart> adm, TransactionDataMart tdm) {
		this.accountNumber=accNumber;
		this.balance=balance;
		this.accountDMs=adm;
		AddTDM(tdm);
		
	}


	@Override
	public Object getAccountData(int index) {
		switch (index) {
		case 0:
			return this.accountNumber;
		case 1:
			return this.balance;
		case 2:
			return this.createdDate;
			
		case 3:
			return this.accountDMs;
		case 4:
			return this.transactionsDMs;
		case 5:
			return this.accountType;
		default:
			return null;
		}
		
	}

	@Override
	public AccountDataMart getADM(int i) 
	{
		return this.accountDMs.get(i);
	}

	
}

