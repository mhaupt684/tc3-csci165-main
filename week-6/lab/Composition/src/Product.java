//Michael Haupt

public class Product {
	private String name;
	private String description;
	private double price;
	private String sku;
	
	
	//Constructors
	public Product() {
		super();
	}
	public Product(String sku) {
		super();
		this.sku = sku;
	}
	public Product(String name, String description, double price, String sku) {
		super();
		this.name = name;
		this.description = description;
		this.setPrice(price);
		this.setSku(sku);
	}
	
	
	//Getters
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getSku() {
		return sku;
	}
	
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		if(price <= 0) {
			this.price = 0.0;
		} else {
			this.price = price;
		}
		
	}
	//sets sku to have 10 characters by adding 0's to the end
	//tests if the sku is valid by how it begins
	public void setSku(String sku) {										
		String sku10 = String.format("%-10s", sku).replace(' ', '0');
		String beginning = sku10.substring(0,3);
		if(beginning.equals("001") ||
		   beginning.equals("002") ||
		   beginning.equals("003") ||
		   beginning.contentEquals("004") ||
		   beginning.equals("110")) {
			
			this.sku = sku10;
		} else {
			this.sku = "no valid sku";
		}
		
				
	}
	
	public boolean equals(Product otherProduct) {
		return this.name.equals(otherProduct.name) &&
			   this.description.equals(otherProduct.description) &&
			   this.price == otherProduct.price &&
			   this.sku.equals(otherProduct.sku);
	}
	
	
	@Override
	public String toString() {
		return "Product " + name + " Price= " + price + " Sku= " + sku;
	}
	
	
	
	
	
	
	
}
