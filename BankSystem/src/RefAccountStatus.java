import java.util.ArrayList;

public class RefAccountStatus {
	private static int count=0;
	public int accountStatusCode;
	//active or closed
	public Status accountStatus;
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public RefAccountStatus(){
		this.accountStatusCode=++count;
	};	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}
}
