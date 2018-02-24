import java.util.ArrayList;

public class RefBranchType {
	public int branchTypeCode;
	//large Urban Smal Rural
	public BranchTypes branchType;
	ArrayList<AccountDataMart> accountDMs = new ArrayList<AccountDataMart>();
	
	public RefBranchType(){
	};

	public void AddADM(AccountDataMart aDM)
	{
		accountDMs.add(aDM);
	}

}
