abstract class Account {

	private Customer 	cust;
	private int 		acctNum;
	private double 		balance;
	private Date 		date;

	// Constructors

	public Account () {
		cust = new Customer();
	}

	public Account (Customer cust, int acctNum, double balance, Date date){
		this.cust = new Customer(cust);
		setAccountNumber(acctNum);
		this.balance = balance;
		this.date = new Date(date);
	}

	public Account (Account clone) {
		this.cust 		= new Customer(clone.cust);
		this.acctNum 	= clone.acctNum;
		this.balance 	= clone.balance;
		this.date 		= new Date(clone.date);
	}

	// Abstract methods
	public abstract void withdraw (double wd) throws InvalidWithdrawalException;

	public abstract void deposit (double dep) throws InvalidBalanceException;

	public abstract double penalty ();

	public Customer getCustomer () {
		return new Customer(cust);
	}

	public double getBalance () {
		return balance;
	}

	public void setBalance (double newBal) {
		balance = newBal;
	}

	//account number must be 5 digits
	public void setAccountNumber (int acctNum) throws InvalidAccountNumberException { 
		int length = String.valueOf(acctNum).length();
		if(length < 5) throw new InvalidAccountNumberException();
		this.acctNum = acctNum;
	}

	public int getAccountNumber () {
		return acctNum;
	}

	public String toString () {
		String classType = this.getClass().toString();
		String[] array = classType.split(" ");
		String printType = array[1].toUpperCase();
		String state =
			printType + " ACCOUNT\n" +	
			cust +
			"\nAccount Number: "+ acctNum +
			"\nBalance: " 		+ balance	+
			"\nDate Opened: " 	+ date;
		return state;
	}
}
