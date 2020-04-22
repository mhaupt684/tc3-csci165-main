
public class Savings extends Account implements Comparable <Account>{
	double intRate = 0.0;
	double withDrawLimit = 0.0;
	double minBalance = 0.0;
	double penalty = 0.0;
	
	public Savings(Customer customer, int accountID, double balance, Date date, double interestRate, double withdrawalLimit, double minBalance) {
		super(customer, accountID, balance, date);
		this.setIntRate(interestRate);
		this.setWithDrawLimit(withdrawalLimit);
		this.setMinBalance(minBalance);
		this.setPenalty();
	}
	
	@Override
	public void withdraw(double wd) throws InvalidWithdrawalException{
		double balance = getBalance();
		if(wd > (balance-this.minBalance) || wd > this.withDrawLimit) throw new InvalidWithdrawalException();
		setBalance(balance-wd);
	}
	
	@Override
	public double penalty() {
		return this.penalty;
	}
	
	@Override
	public void deposit(double dep) {
		setBalance(getBalance()+dep);
	}

	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}

	public void setWithDrawLimit(double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public void setPenalty() {
		this.penalty = getBalance()*.01;
	}
	
	@Override
	public int compareTo(Account other) {
		if(this.getBalance() < other.getBalance()) return -1;
		if(this.getBalance() > other.getBalance()) return 1;
		return 0;
	}
	
	
	@Override
	public String toString() {
		String state = 
				super.toString() + "\n" +
				"Interest Rate: " + this.intRate +
				"\nWithdrawal Limit: " + this.withDrawLimit +
				"\nMinimum Balance: " + this.minBalance;
		
		return state;
	}
	
	
	
}
