
public class TransactionDataMart {
	public int factID;
	public int accountNumber;
	public int accountTypeCode;
	public int carNumber;
	public int merchantID;
	public int paymentMethodTypeCode;
	//tipi kesin deðil
	public String reportingDateAndTime;
	public int transactionID;
	public int transactionTypeCode;
	public int transactionDate;
	public int transactionAmount;
	public int averageBalance;
	public int counts;
	public int totals;
	public int KPIs;
	public int Graphs;
	public int Trends;
	//other derived figures

	RefCalendar refClndr=new RefCalendar();
	Account account=new Account();
	RefAccountType refAccType=new RefAccountType();
	CustomersCard customerCard=new CustomersCard();
	Merchant merchant = new Merchant();
	RefPaymentMethodType refPayMethType =new RefPaymentMethodType();
	RefTransactionType refTranstType= new RefTransactionType();
	Transaction transaction= new Transaction();
	
	
}
