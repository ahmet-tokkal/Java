import java.util.ArrayList;

public class MonthlyBalance {
	public int monthlyBalanceID;
	public double monthlyBalance;

	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public MonthlyBalance(){
	};
	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}
}
