import java.util.ArrayList;

public  class AccountDecorator implements IAccount 
{
	protected Account account;
	
	public AccountDecorator(Account account)
	{
		this.account =account;
	}

	@Override
	public void add() {
		this.account.add();
		
	}

	@Override
	public void setAccountData(int accNumber, double balance, ArrayList<AccountDataMart> adm, TransactionDataMart tdm) {
		this.account.setAccountData(accNumber, balance, adm, tdm);
		
	}


	@Override
	public Object getAccountData(int index) {
		return this.account.getAccountData(index);
	}

	@Override
	public AccountDataMart getADM(int i) {
		return this.account.getADM(i);
	}

	@Override
	public void AddADM(AccountDataMart aDM) {
		this.account.AddADM(aDM);
		
	}

}
