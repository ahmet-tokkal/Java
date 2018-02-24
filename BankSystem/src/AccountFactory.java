
public class AccountFactory 
{
	public IAccount getAccount(String accType)
	{
		if(accType==null)
		{
			return null;
		}
		if(accType.equalsIgnoreCase("Dated"))
		{
			
			return new DatedAccount(new Account());
		}
		else if(accType.equalsIgnoreCase("Undated"))
		{
			return new UndatedAccount(new Account());
		}

		return null;
	}

}
