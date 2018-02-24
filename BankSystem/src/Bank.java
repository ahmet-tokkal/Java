import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bank extends DataTemplate{
	public int bankID;
	public String bankName;
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public Bank(){
	};
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}
	@Override
	int setID() {
		int id;
		if(Login.getDb().dbGetId("Banks")==0)
		{
			id=1;
		}
		else
		{
			id=Login.getDb().dbGetId("Banks")+1;
		}
		return id;
	}
	@Override
	String query(int id) 
	{
		String query="INSERT INTO Banks VALUES("+id+",'"+this.bankName+"')";
		return query;
	}
	@Override
	void showDialog() {
		JOptionPane.showMessageDialog(null, "Bank added successfully !");
		
	}
	@Override
	void setData(String bName) {
		this.bankName=bName;
	}
	
}
