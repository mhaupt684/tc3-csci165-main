import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//Michael Haupt
public class Composition_Driver {
	
	//address array
	public static final int ARRAYSIZEADDRESS = 42632;
	public static final int ADDRESSDATAPOINTS = 3;
	public static String[][] addressArray;														//array that hold addresses
	public static String addressFile = "zip_code_database.csv";									//name of the address file
	
	//customers array
	public static final int ARRAYSIZECUSTOMERS = 1000;
	public static ArrayList<Customer> customers = new ArrayList<Customer>();					//array that holds Customers
	public static String customerFile = "customers.txt";										//name of the customer file
	
	//products array
	public static final int ARRAYSIZEPRODUCTS = 1000;
	public static ArrayList<Product> products = new ArrayList<Product>();						//array that holds Products
	public static String productsFile = "products.txt";											//name of the products file
	
	//accounts array 
	public static final int ARRAYSIZEACCOUNTS = 1000;
	public static ArrayList<Account> accounts = new ArrayList<Account>();						//array that holds Accounts
	
	//invoice array
	public static final int ARRAYSIZEINVOICES = 1000;
	public static ArrayList<Invoice> invoices = new ArrayList<Invoice>();						//array that holds Invoices
	
	
	
	public static void main(String[] args) {
		Composition_Driver driver = new Composition_Driver();
		
		//fill arrays
		addressArray = driver.fillAddressArray();
		driver.fillCustomerArray();
		driver.fillProductArray();
		driver.fillAccountArray();
		driver.fillInvoiceArray();
		driver.sortInvoiceArray();
		
		System.out.println("Press enter to move to the next invoice\n");
		
		for(int i = 0; i<ARRAYSIZEINVOICES; i++) {
			Invoice printInv = invoices.get(i);
			System.out.print(printInv);
			Scanner enterButton = new Scanner(System.in);
			enterButton.nextLine();
		}
		
	}
	
	//sorts invoices from the highest to the lowest
	public void sortInvoiceArray() {
		for(int i = 0; i < ARRAYSIZEINVOICES-1; i++) {
			Invoice highestInv = invoices.get(i);
			int jIndex = 1;
			
			for(int j = i+1; j < ARRAYSIZEINVOICES; j++) {
				Invoice invoiceJ = invoices.get(j);
				double jInvTotal = invoiceJ.getAmount();
				double hInvTotal = highestInv.getAmount();
				if(jInvTotal > hInvTotal) {
					highestInv = invoices.get(j);
					jIndex = j;
				}
			}
			
			Invoice holder = invoices.get(i);
			invoices.set(i,highestInv);
			invoices.set(jIndex, holder);
		}
	}
	
	//prints the invoice
	public void printInvoince(Invoice invoice) {
		System.out.println(invoice.toString());
	}
	
	
	//fills the invoice array
	public void fillInvoiceArray() {
		for(int i = 0; i < ARRAYSIZEINVOICES; i++) {
			String invoiceNum = String.format("%03d", i);
			Account account = accounts.get(i);
			Date orderDate = new Date(randomDate());
			boolean validDate = false;
			
			while(validDate == false) {
				Date accountCreated = new Date(account.getDate());
				int comparison = accountCreated.compareTo(orderDate);
				if(comparison == -1 || comparison == 0) {
					validDate = true;
				} else {
					orderDate = new Date(randomDate());
				}
			}
			
			
			ArrayList<Product> invProduct = new ArrayList<Product>();
			int productNum = (int) Math.ceil(Math.random()*20);
			int seed = (int) Math.ceil(Math.random()*(ARRAYSIZEPRODUCTS-21));
			for(int j = seed; j < productNum + seed; j++) {
				invProduct.add(products.get(seed));
			}
			
			Invoice invoice = new Invoice(invoiceNum, account, invProduct, orderDate);
			invoices.add(invoice);
		}
	}
	
	
	
	//fills account array with 1000 accounts
	public void fillAccountArray() {
		for(int i = 0; i < ARRAYSIZECUSTOMERS;i++) {											//loop until the Accounts array is filled, there is the same number of Customers
			Customer customer = customers.get(i);												//get a customer from the Customer array
			
			//create accountID process
			String fullName = customer.getName();												
			fullName = fullName.toUpperCase();													//convert the string to all upper case
			String[] nameArray = fullName.split("[AEIOUY]");									//split at vowels
			String consonants = Arrays.toString(nameArray);										//merge back into a single string
			Pattern namePattern = Pattern.compile("[A-Z]{1}");									//match capitol letters in consonants
			Matcher nameMatcher = namePattern.matcher(consonants);								
			StringBuilder strBuilder = new StringBuilder();										//build a string with the matches
			int checkDigitTotal = 0;															//keep track of the total for the check digit
			
			while(nameMatcher.find()) {															//find a match
				strBuilder.append(nameMatcher.group(0));										//append the match to the string builder
				String asciiStr = nameMatcher.group(0);											//save the match to a string
				char asciiChar = asciiStr.charAt(0);											//convert to a character
				int asciiInt = (int) asciiChar;													//find the ascii value		
				checkDigitTotal += asciiInt;													//add to the ascii total
			}
			
			int strBuilderLen = strBuilder.length();											//find the total number of matches
			int checkDigit = checkDigitTotal%strBuilderLen;										// point total%num of matches to get remainder
			
			Date last15Yrs = new Date(randomDate());											//date instance for date created
			String cusDate = last15Yrs.toString();												
			String[] dateArray = cusDate.split("/");											//split the date into month,day,year
			int month = 0;
			int day = 1;
			int year = 2;
			String accountID = strBuilder.toString() + dateArray[month] + dateArray[day] + dateArray[year] + checkDigit; 	//build the accountID
			
			//other Account inputs
			double startingBalance = randomBalance();											//create random balance
			double startingCreditLimit = 0.1 * startingBalance;									
			double startingDiscount = 0.0;
			Account account = new Account(accountID, customer, last15Yrs, startingBalance, startingCreditLimit, startingDiscount);  //create instance of Customer
			accounts.add(account); 																//add to the Account array												
			
		}
		
		
	}
	
	
	//generates and returns a random date
	public static Date randomDate() {
		int month = (int) Math.ceil(Math.random()*12);											//create random month
		int day = (int) Math.ceil(Math.random()*31);											//create random day
		int randomYear = (int) Math.ceil(Math.random()*15);									
		int year = 2005 + randomYear;															//create random year in the last 15 years
		Date date = new Date(month,day,year);													//create date instance
		return date;
	}
	
	//generates and returns a random balance
	public static double randomBalance() {
		double balance = Math.random()*999999.99;												//create random balance
		return balance;
	}
	
	
	
	//fills the product array with 100 products
	public void fillProductArray() {
		try {
			File pFile = new File(productsFile);
			FileReader fReader = new FileReader(pFile);
			BufferedReader bReader = new BufferedReader(fReader);
			
			for(int i = 0; i < ARRAYSIZEPRODUCTS; i++) {										//loop the amount of times == num of products
				String inputLine = bReader.readLine();											//input the next line
				String[] array = inputLine.split("\t");											//split the line by tabs
				double price = Double.parseDouble(array[2]);
				Product product = new Product(array[0],array[1],price,array[3]);										
				products.add(product);
																		
			}
			
		}catch(IOException ioe) {
			System.out.println("Cannot open products.txt");
		}
	}
	
	
	//fills the arraylist of 1000 customers
	public void fillCustomerArray() {
		try {
			File cFile = new File(customerFile);												//File instance for customer.txt
			FileReader fReader = new FileReader(cFile);	
			BufferedReader bReader = new BufferedReader(fReader);
			
			//array[0] = fName, [1] = lName, [2] = email, [3-5] street address, [6] zip code
			for(int i = 0; i < ARRAYSIZECUSTOMERS; i++) {										//loop the amount of times == num of customers
				String inputLine = bReader.readLine();											//input the next line
				String[] array = inputLine.split("\t");											//split the line by tabs
				int zipLoc = array.length -1;													//location of the zip code in the array
				String zipCode = array[zipLoc];
				int col0 = 0;
				int col1 = 1;
				int col2 = 2;
				String customerCity = "No city on record";										//if no zip code is found, then no city is the default
				String customerState = "No State on record";
				int loopCounter = 0;
				
				while(customerCity.equals("No city on record") && loopCounter < ARRAYSIZEADDRESS) {		//loops until it finds the city and the String is changed or if it reaches the end of the address array
					if(zipCode.equals(addressArray[loopCounter][col0])) {							
						customerCity = addressArray[loopCounter][col1];
						customerState = addressArray[loopCounter][col2];
					}
					loopCounter ++;
				}
				
				
				String street = String.format("%s %s %s",array[3],array[4],array[5]);			//compose String street
				Address address = new Address(street,customerCity,customerState,array[6]);		//create instance of the address object
				Customer customer = new Customer(array[0],array[1],array[2],address);			//create instance of customer object
				customers.add(customer);														//add that customer object to the Customer array
			}
			
			
		}catch(IOException ioe) {
			System.out.println("Cannot open customers.txt");
		}
	}
	
	
	//fills the address array with zip code , city name , and state abbreviation
 	public String[][] fillAddressArray() {
		String[][] matrix = new String[ARRAYSIZEADDRESS][ADDRESSDATAPOINTS];
		try {
			
			File aFile = new File(addressFile);
			FileReader fReader = new FileReader(aFile);
			BufferedReader bReader = new BufferedReader(fReader);
			
			//  ,(0|1),([\w]+|"[\w]+\s[\w]+"|"[\w]+\s[\w]+\s[\w]+"),
			//original ,(0|1),([\\w]+|\"[\\w]+\\s[\\w]+\"),  
			
			Pattern zipCodeP = Pattern.compile("^\\d{5}");										//regex for zipcode
			Pattern primaryCityP = Pattern.compile(
				",(0|1),([\\w]+|\"[\\w]+\\s[\\w]+\"|\"[\\w]+\\s[\\w]+\\s[\\w]+\"|\"[\\w]+\\s[\\w]+\\s[\\w]+\\s[\\w]+\"),");				//regex for primary city, contains some extra characters
			Pattern primaryCityP2 = Pattern.compile(
				"[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+");		//regex for stripping extra characters, leaving only the primary city
			Pattern stateAB = Pattern.compile(",[A-Z]{2},");									//regex to get the state Abbreviation
			Pattern stateAB2 = Pattern.compile("[A-Z]{2}");										//regex to remove commas from state abbreviation
			
			int column0 = 0;																	//column numbers
			int column1 = 1;
			int column2 = 2;
			
			String inputLine = bReader.readLine();												//read the title line
			
			for(int i = 0; i < ARRAYSIZEADDRESS; i++) {											//i set to -1 to offset first line - title line
				inputLine = bReader.readLine();													//read next line
				
				Matcher zipCodeM = zipCodeP.matcher(inputLine);									//matcher instance to pull zipcode
				if(zipCodeM.find()) {															//if zipcode match is made
					matrix[i][column0] = zipCodeM.group(0);										//save zipcode to the matrix
				}
				
				Matcher primaryCityM = primaryCityP.matcher(inputLine);							//match the primary city from of the inputline
				if(primaryCityM.find()) {
					String extractCity = primaryCityM.group(0);									//save the result to a String
					Matcher primaryCityM2 = primaryCityP2.matcher(extractCity);					//use matcher to remove extra characters
					primaryCityM2.find();
					matrix[i][column1] = primaryCityM2.group(0);								//save it to the matrix
					
				}
				
				Matcher state = stateAB.matcher(inputLine);										//match the state abbreviation from inputline									
				if(state.find()) {
					String stateAbrev = state.group(0);											//save the result to a string
					Matcher state2 = stateAB2.matcher(stateAbrev);								//use matcher to remove extra characters
					state2.find();
					matrix[i][column2] = state2.group(0);										//save it to the matrix
				}	
			}//end for
		} catch(IOException ioe) {
			System.out.println("Could not read address file");
		}
		
		return matrix;
	}

}
