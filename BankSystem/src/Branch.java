import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Branch extends DataTemplate {
	public int branchID;
	public String branchName;
	
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public Branch(){
	};
	
	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}

	@Override
	void setData(String bName) {
		this.branchName=bName;
		
	}

	@Override
	int setID() {
		int id;
		if(Login.getDb().dbGetId("Branches")==0)
		{
			id=1;
		}
		else
		{
			id=Login.getDb().dbGetId("Branches")+1;
		}
		return id;
	}

	@Override
	String query(int id) {
		String query="INSERT INTO Branches VALUES("+id+",'"+this.branchName+"')";
		return query;
	}

	@Override
	void showDialog() {
		JOptionPane.showMessageDialog(null, "Branch added successfully !");
		
	}
}
