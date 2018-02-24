import java.util.ArrayList;

public class DatedAccount extends AccountDecorator{

	public DatedAccount(Account account) 
	{
		super(account);
	}
	@Override
	public void add()
	{
		super.add();
		
	}
	@Override
	public void setAccountData(int accNumber, double balance, ArrayList<AccountDataMart> adm, TransactionDataMart tdm)
	{
		this.account.accountType="Dated";
		super.setAccountData(accNumber, balance, adm, tdm);
		
	}
	

}
