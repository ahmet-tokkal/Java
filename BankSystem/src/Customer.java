import java.util.ArrayList;

public class Customer {
	public int customerID;
	public String customerName;
	public String phoneNumber;
	public String password;

	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public Customer(){
	};
	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}
}
