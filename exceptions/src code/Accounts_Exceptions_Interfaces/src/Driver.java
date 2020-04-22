import java.util.Arrays;

public class Driver {

	public static void main(String[] args){

		Account[] accounts = new Account[10];
		Customer c1 = new Customer ("Tom", "Roberts", new Date(1,1,1990), "T123");
		Customer c2 = new Customer ("Robby", "Roberts", new Date(1,2,1992), "T124");
		Customer c3 = new Customer ("Jebidiah", "Roberts", new Date(2,1,1991), "J123");

      
      // Savings constructor: Customer, AccountID, Balance, Date, Interest Rate, Withdrawal Limit, Min Blance)
		Account a1 = new Savings(c1, 12345, 340, new Date(2,3,2010), 4.2, 200, 5);
		Account a2 = new Savings(c1, 12344, 550, new Date(2,3,2010), 4.2, 200, 5);
		Account a3 = new Savings(c2, 45432, 120, new Date(2,3,2010), 4.2, 200, 5);
		Account a4 = new Savings(c2, 53234, 670, new Date(2,3,2010), 4.2, 200, 5);
		Account a5 = new Savings(c3, 13245, 9980, new Date(2,3,2010), 4.2, 200, 5);
		
		// Checking Constructor: Customer, AccountID, Balance, Date, Monthly Fee, Max Balance
		Account a6 = new Checking(c1, 89583,240, new Date(2,3,2010), 2, 1000 );
		Account a7 = new Checking(c1, 23904, 640, new Date(2,3,2010), 2, 1000  );
		Account a8 = new Checking(c2, 39402, 760, new Date(2,3,2010), 2, 1000  );
		Account a9 = new Checking(c2, 49302, 340, new Date(2,3,2010), 2, 1000  );
		Account a10 = new Checking(c3, 99890, 450, new Date(2,3,2010), 2, 1000  );

		accounts[0] = a1;
		accounts[1] = a2;
		accounts[2] = a3;
		accounts[3] = a4;
		accounts[4] = a5;
		accounts[5] = a6;
		accounts[6] = a7;
		accounts[7] = a8;
		accounts[8] = a9;
		accounts[9] = a10;

		Arrays.sort(accounts);
	    for (Account a : accounts){
			System.out.println(a + "\n");
		}
		
    }

}
