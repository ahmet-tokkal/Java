import java.util.ArrayList;

public class RefCalendar {
	//tip kesin deðil
	public String dayDateAndTime;
	
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	ArrayList<TransactionDataMart> transactionsDMs= new ArrayList<TransactionDataMart>();
	
	public RefCalendar(){}
	public RefCalendar(String dayDateAndTime)
	{
		this.dayDateAndTime=dayDateAndTime;
	}
	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	} 
	public void AddTDM(TransactionDataMart tDM)
	{
		transactionsDMs.add(tDM);
	}
}
