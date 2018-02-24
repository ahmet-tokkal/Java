import java.util.ArrayList;

public class UndatedAccount extends AccountDecorator{

	public UndatedAccount(Account account) {
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
		this.account.accountType="Undated";
		super.setAccountData(accNumber, balance, adm, tdm);
		
	}

}
