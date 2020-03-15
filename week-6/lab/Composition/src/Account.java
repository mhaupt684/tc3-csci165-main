//Michael Haupt
public class Account {
	private String accountID;
	private Customer customer;
	private double balance = 0.0;
	private double creditLimit = 0.0;
	private double discountLevel = 0.0;
	private Date dateCreated;
	private Date today = new Date(12,31,2020);
	private final int limitMultiplier = 2;
	
	//Constructors
	public Account() {}
	public Account(String accountID, Customer customer) {
		super();
		this.accountID = accountID;
		this.customer = customer;
	}
	public Account(String accountID, Customer customer, Date date, double balance, double creditLimit, double discountLevel) {
		super();
		this.accountID = accountID;
		this.customer = customer;
		this.setDate(date);
		this.setBalance(balance);
		this.setCreditLimit(creditLimit);
		this.setDiscountLevel(discountLevel);
	}
	
	//getters
	public Customer getCustomer() {
		return customer;
	}
	public double getBalance() {
		return balance;
	}
	public double getCreditLimit() {
		return creditLimit;
	}

	public Date getDate() {
		return new Date(dateCreated);
	}

	//setters
	public void setDate(Date date) {
		this.dateCreated = new Date(date);
	}
	public void setBalance(double balance) {
		if(balance < 0) {
			this.balance = 0.0;
		} else {
			this.balance = balance;
		}
	}
	public void setCreditLimit(double creditLimit) {
		if(creditLimit > (this.balance*limitMultiplier)) {
			this.creditLimit = this.balance*limitMultiplier;
		} else if(creditLimit <= 0) {
			this.creditLimit = 0.0;
		} else {
			this.creditLimit = creditLimit;
		}
	}
	public void setDiscountLevel(double discount) {
		double discounter = .02;
		if(discount < 0.0) {
			this.discountLevel = 0.0;
		} else {
			this.discountLevel = (today.getYear() - dateCreated.getYear())*discounter;
		}
	}

	
	
	public boolean equals(Account otherAccount) {
		return 	this.accountID == otherAccount.accountID &&
				this.customer.equals(otherAccount.customer) &&
				this.balance == otherAccount.balance &&
				this.creditLimit == otherAccount.creditLimit &&
				this.discountLevel == otherAccount.discountLevel &&
				this.dateCreated.equals(otherAccount.dateCreated)				
				;
	}
	
	public int compareTo(Account otherAccount) {
		if(this.balance > otherAccount.balance) {
			return 1;
		} else if(this.balance < otherAccount.balance) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		String state = "";
		state = String.format("%s %-25s%s %s%-11.2f %s %s%-11.2f %s %.0f%s"
				+ "\n%s",
				"AccountID:", this.accountID,"Balance:","$",this.balance,"Credit Limit:","$",this.creditLimit,"Discount Level:",(this.discountLevel*100),"%",
				this.customer
				
				);
				
		return state;
	}
	
	
	
}
