
public class Checking extends Account implements Comparable <Account>{
	private double monthlyFee = 0.0;
	private double maxBalance = 0.0;
	private double penalty = 0.0;
	
	public Checking(Customer customer, int accountID, double balance, Date date, double monthFee, double maxBalance) {
		super(customer, accountID, balance, date);
		this.setMonthlyFee(monthFee);
		this.setMaxBalance(maxBalance);
		this.setPenalty();
	}
	
	@Override
	public void withdraw(double wd) throws InvalidWithdrawalException {
		double balance = getBalance();
		if(wd > balance) throw new InvalidWithdrawalException();
		setBalance(balance-wd);
	}
	
	@Override
	public double penalty() {
		return this.penalty;
	}
	
	@Override
	public void deposit(double dep) throws InvalidBalanceException {
		double balance = getBalance();
		if((balance+dep) > this.maxBalance) {
			throw new InvalidBalanceException();
		}
		setBalance(balance+dep);
		
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public void setMaxBalance(double maxBalance) {
		this.maxBalance = maxBalance;
	}

	public void setPenalty() {
		this.penalty = this.monthlyFee*2;
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
				"Monthly Fee: " + this.monthlyFee +
				"\nMax Balance: " + this.maxBalance;
		return state;
	}
	
	
}
