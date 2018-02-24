import java.util.ArrayList;
import java.util.Observable;

public class Address extends Observable
{
	public int addressID;
	public String address;
	public String city;
	public String postalCode;
	public String country;
	
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public Address(){
	};
	public void changeAddress(int addressID,String address,String city,String postalCode,String country)
	{
		this.addressID=addressID;
		this.address=address;
		this.city=city;
		this.postalCode=postalCode;
		this.country=country;
		addressChanged();
	}
	public void addressChanged()
	{
		setChanged();
		notifyObservers();
	}
	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}
}
