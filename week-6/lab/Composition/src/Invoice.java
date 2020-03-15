//Michael Haupt

import java.util.ArrayList;

public class Invoice {
	private String invoiceNumber;
	private Account account;
	private double amount = 0.0;
	private Date orderDate;
	private ArrayList<Product> products;
	private String linebreak = "----------------------------------------------------------------------------------------";

	
	//Constructors
	public Invoice() {
		super();
	}
	public Invoice(String invoiceNumber, Account account, ArrayList<Product> product, Date orderDate) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.account = account;
		this.setProducts(product);
		this.setTotalAmount();
		this.setOrderDate(orderDate);
	}

	
	//Getters
	public Account getAccount() {
		return account;
	}
	public double getAmount() {
		return amount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public double getAmountDue() {
		double amount = 0;
		return amount;
	}

	
	//Setters
	public void setTotalAmount() {
		double totalCost = 0.0;
		int length = products.size();
		for(int k = 0; k < length; k++) {
			Product productCost = products.get(k);
			totalCost += productCost.getPrice();
		}
		this.amount = totalCost;
	}
	public void setProducts(ArrayList<Product> product) {
		this.products = new ArrayList<Product>(product);
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = new Date(orderDate);
	}
	
	
	//Compare two Invoices
	public int compareTo(Invoice otherInvoice) {
		return 0;
	}
	
	@Override
	public String toString() {
		String state = "";
		state = String.format("%s\n%s %s\n%s\n\n%s %s%.2f\n",
				linebreak,
				"Invoice #",this.invoiceNumber,
				this.account,
				"Total Cost:","$", this.amount
				);

		return state;
	}
	
	
	
	
	
	
	
}
