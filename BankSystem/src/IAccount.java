import java.util.ArrayList;

public interface IAccount 
{
	void add();
	void setAccountData(int accNumber,double balance,ArrayList<AccountDataMart> adm, TransactionDataMart tdm);
	Object getAccountData(int index);
	AccountDataMart getADM(int i);
	void AddADM(AccountDataMart aDM);
	
}

