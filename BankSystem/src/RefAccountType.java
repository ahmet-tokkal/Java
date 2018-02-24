import java.util.ArrayList;

public class RefAccountType {
	public int accountTypeCode;
	public AccountTypes accountType;//checking, saving etc...

	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	ArrayList<TransactionDataMart> transactionsDMs= new ArrayList<TransactionDataMart>();
	
	public RefAccountType(){
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
