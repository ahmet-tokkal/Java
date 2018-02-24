import java.util.Observable;
import java.util.Observer;

public class AccountDataMart implements Observer{
	public int factID;
	public int accountNumber;
	public int accountStatusCode;
	public int accountTypeCode;
	public int addressID;
	public int bankID;
	public int branchID;
	public int branchTypeCode;
	public int customerID;
	public int monthlyBalanceID;
	
	//RefCalendar refCllndr=new RefCalendar();
	Address address= new  Address();
	Bank bank=new Bank();
	Branch branch=new Branch();
	Customer customer=new Customer();
	MonthlyBalance  mBalance= new MonthlyBalance();
	RefAccountStatus refAccountSta=new RefAccountStatus();
	RefBranchType refBranchType= new RefBranchType();
	IAccount account;
	RefAccountType refAccountType= new RefAccountType();
	
	public AccountDataMart()
	{


	}
	
	public void AddAccount(IAccount account)
	{
		this.account=account;
		this.accountNumber=(int)account.getAccountData(0);
	}
	
	public void AddAddress(Address address)
	{
		this.address=address;
		address.AddADM(this);
		this.addressID=address.addressID;
		
	}
	
	public void AddBank(Bank bank)
	{
		this.bank=bank;
		bank.AddADM(this);
		this.bankID=bank.bankID;	
	}
	
	public void AddBranch(Branch branch)
	{
		this.branch=branch;
		branch.AddADM(this);
		this.branchID=branch.branchID;
	}
	
	public void AddCustomer(Customer customer)
	{
		this.customer=customer;
		customer.AddADM(this);
		this.customerID=customer.customerID;
	}
	
	public void AddMBalance(MonthlyBalance mBalance)
	{
		this.mBalance=mBalance;
		mBalance.AddADM(this);
		this.monthlyBalanceID=mBalance.monthlyBalanceID;
		
	}
	
	public void AddRefAccountSta(RefAccountStatus refAccountSta)
	{
		this.refAccountSta=refAccountSta;
		refAccountSta.AddADM(this);
		this.accountStatusCode=refAccountSta.accountStatusCode;
	}
	
	public void AddRefBranchType(RefBranchType refBranchType)
	{
		this.refBranchType=refBranchType;
		refBranchType.AddADM(this);
		this.branchTypeCode=refBranchType.branchTypeCode;
	}
	
	public void AddRefAccountTypes(RefAccountType refAccountType)
	{
		this.refAccountType=refAccountType;
		refAccountType.AddADM(this);
		this.accountTypeCode=refAccountType.accountTypeCode;
	}

	@Override
	public void update(Observable arg0, Object arg1) 
	{
		if(arg0 instanceof Address)
		{
			this.address = (Address) arg0;
			System.out.println("address updated");
		}
		
	}	
}
