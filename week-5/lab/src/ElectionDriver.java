import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

//Michael Haupt

public class ElectionDriver {
	
	//static class variables
	public static final int NUMOFCOUNTIES = 3140;												//number of counties
	
	//ArrayList of CountyResults2016 types
	public static ArrayList<CountyResults2016> results = new ArrayList<CountyResults2016>();	//arrayList of countyresult objects
	
	//List of all state abbreviations
	public static String stateList[] = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL",
			"GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS",
			"MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI",
			"SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};

	
	public static void main(String[] args) {
		ElectionDriver driver = new ElectionDriver();											//instance of ElectionDriver to use methods in this class
		String fileName = "2016_US_County_Level_Presidential_Results.csv";						//file that contains county data
		driver.fillList(fileName);																//fills the ArrayList
		
		//US Largest Margin of Victory
		System.out.println("Largest Margin of Victory in US\n");
		CountyResults2016 lNatMargin = driver.findLargestNationalMargin();
		System.out.println(lNatMargin.toString());
		
		//NY Largest Margin of Victory
		System.out.println("Largest Margin of Victory in NY\n");
		CountyResults2016 lStateMargin = driver.findLargestStateMargin("NY");
		System.out.println(lStateMargin.toString());
		
		//PA Largest Margin of Victory
		System.out.println("Largest Margin of Victory in PA\n");
		lStateMargin = driver.findLargestStateMargin("PA");
		System.out.println(lStateMargin.toString());
		
		//WA Largest Margin of Victory
		System.out.println("Largest Margin of Victory in WA\n");
		lStateMargin = driver.findLargestStateMargin("WA");
		System.out.println(lStateMargin.toString());
		
		//print out state totals for each state
		driver.getStateTotals();
	}
	
	
	//print of state totals for each state
	public void getStateTotals() {
		
		int stateNum = stateList.length;														//length of list of states													
		for(int i = 0; i < stateNum; i++) {														//loop through each state in list
			String stateAbbreviation = stateList[i];											//save abbreviation of the current state
			
			//variables to be printed
			double demTotalVotes = 0.0;
			double gopTotalVotes = 0.0;
			double totalVotes = 0.0;
			double percentDem = 0.0;
			double percentGOP = 0.0;
			double percentDifference = 0.0;
			String winner = "";
			
			CountyResults2016 stateTotals = new CountyResults2016();							//instance of CountyResults type used to access data
			
			for(int j = 0; j < NUMOFCOUNTIES; j++) {											//loop through every instance of CountyResults
				stateTotals = results.get(j);													//stateTotals = current CountyResults instance from ArrayList
				String stateAB = stateTotals.stateAbbreviation;									//get the abbreviation of the state from the instance
				if(stateAB.equals(stateAbbreviation)) {											//test if the abbr of the instance is the same as from list of states
					demTotalVotes += stateTotals.demVotes;										//if it is, add to the following variables
					gopTotalVotes += stateTotals.gopVotes;
					totalVotes += stateTotals.totalVotes;
				}
			}
			percentDem = demTotalVotes/totalVotes;												//calculate percent of votes for dems
			percentGOP = gopTotalVotes/totalVotes;												//calculate percent of votes for gop
			percentDifference = Math.abs(percentDem - percentGOP);								//calculate the percent difference
			if(demTotalVotes > gopTotalVotes) {													//determine the winner
				winner = "dems";
			} else {
				winner = "gop";
			}
			System.out.println(printStateTotals(stateAbbreviation, demTotalVotes, gopTotalVotes, percentDifference, winner));
		}
		
		
	}

	
	//prints totals for a given state
	public String printStateTotals(String state, double demVotes, double gopVotes, double mOV, String wp) {
		String totals = "";
        totals = String.format("%s %s%n%s %.0f%n%s %.0f%n%s %.2f%s%n%s %s%n",
        		"State:", state,
        		"Total Dem Votes:", demVotes,
        		"Total GOP Votes:", gopVotes,
        		"Margin of Victory:", mOV*100, "%",
        		"Winning Party:", wp
        		);
        return totals;
	}
	
	
	//finds the county with the largest margin of victory given a state
	public CountyResults2016 findLargestStateMargin(String state) {
		CountyResults2016 largestStateMargin = new CountyResults2016();							//instance to store the county with the largest margin of victory
		CountyResults2016 challenger = new CountyResults2016();									//instance to store the challenging county
		boolean challengerSet = false;															//tests if a value has been saved to largestStateMargin
		
		for(int i = 1; i < NUMOFCOUNTIES; i++) {												//loop through on county instances
			challenger = results.get(i);														//set challenger to the current instance
			String challengerState = challenger.stateAbbreviation;								//retrieve the state from the current instance
			if(challengerState.equals(state) && challengerSet == false) {						//if state equals given state and no value has been saved in lsm
				largestStateMargin = challenger;												//save this instance as the leader
				challengerSet = true;															//change lsm to be set
			} else if(challengerState.equals(state)) {											//if state equals given state
				if(challenger.percentDifference > largestStateMargin.percentDifference) {		//if current instance has greate margin of victory
					largestStateMargin = challenger;											//save the instance as the new leader
				}
			}
		}
		return largestStateMargin;
	}
	
	
	//finds the county with the largest margin of victory
	public CountyResults2016 findLargestNationalMargin() {										
		CountyResults2016 largestNationalMargin = results.get(0);								//set lnm to the first instance
		CountyResults2016 challenger = new CountyResults2016();									//create instance to represent challenger
		for(int i = 1; i < NUMOFCOUNTIES; i++) {												//loop through all of the counties
			challenger = results.get(i);														//set challenger to the current instance
			if(challenger.percentDifference > largestNationalMargin.percentDifference) {		//if challenger has larger margin of victory
				largestNationalMargin = challenger;												//challenger is the new leader
			}
		}
		return largestNationalMargin;
	}
	
	
	//fills the arrayList with data from csv file
	public void fillList(String fileName) {
		try {
			File file = new File(fileName); 													//open csv file
			FileReader fReader = new FileReader(file);											//read csv file
			BufferedReader bReader = new BufferedReader(fReader);								//buffer the reader
			
			bReader.readLine();																	//skip past the title row before entering the for loop
			
			for(int i = 0; i < NUMOFCOUNTIES; i++) {											//loop through all rows in the csv file
				String inputLine = bReader.readLine();											//read the next line of the csv file as one string
				String[] splitter = inputLine.split(",");										//split into an array of strings using comma delimter
				int splitterLength = splitter.length;											//get the length of the string array
				String finalSplit[] = new String[11];											//create an empty string array that will be used to create the instance
				
				//splitter length will either be 11,12,or 13 depending on how many commas "difference" column has
				if(splitterLength == 12) { // 1,000 < difference < 1,000,000
					for(int k = 0; k < splitterLength-1; k++) {									//loop through the array of strings
						if(k == 6) {															//combine splits 6 and 7 to reform difference column
							String firstHalf[] = splitter[6].split("\"");
							String secondHalf[] = splitter[7].split("\"");
							String putBackTogether = firstHalf[1] + secondHalf[0];
							finalSplit[k] = putBackTogether;
						} else if(k >= 7){														//offset by 1 for finalSplit String array when k >= 7
							finalSplit[k] = splitter[k+1];
						} else {																//columns 1-5 will always be the same
							finalSplit[k] = splitter[k];
						}
					}
				} else if(splitterLength == 13) {												//if difference is > 1,000,000
					for(int m = 0; m < splitterLength-2; m++) {
						if(m == 6) {
							String firstHalf[] = splitter[6].split("\"");						//combine 3 splits 6,7,8 to reform difference column
							String secondHalf = splitter[7];
							String thirdHalf[] = splitter[8].split("\"");
							String putBackTogether = firstHalf[1] + secondHalf + thirdHalf[0];
							finalSplit[m] = putBackTogether;
						} else if(m >= 7){
							finalSplit[m] = splitter[m+2];										//offset by 2 for finalSplite String array when k >=7
						} else {
							finalSplit[m] = splitter[m];										//columns 1-5 will always be the same
						}
					}
				} else {																		//else just copy splitter directly into finalSplit w/o modifications
					for(int p = 0; p < splitterLength; p++) {
							finalSplit[p] = splitter[p];
					}
				}
				
				//variables that will be used to create an instance of CountyResults2016
				double demVotes = 0.0;
				double gopVotes = 0.0;
				double totalVotes = 0.0;
				double percentDem = 0.0;
				double percentGOP = 0.0;
				double difference = 0.0;
				double percentDifference = 0.0;
				String stateAbbreviation = "";
				String county = "";
				int fips = 0;
				
				//this for loop and switch will save the correct values from the String array into variables used to create the instance
				for(int j = 0; j < splitterLength; j++) {
					switch (j) {
					case 0: 																	//skips column 1 in the csv file
						break;
					case 1: 
						demVotes = Double.parseDouble(finalSplit[1]);							//cases 1-6 convert string into double
						break;
					case 2:
						gopVotes = Double.parseDouble(finalSplit[2]);
						break;
					case 3:
						totalVotes = Double.parseDouble(finalSplit[3]);
						break;
					case 4:
						percentDem = Double.parseDouble(finalSplit[4]);
						break;
					case 5:
						percentGOP = Double.parseDouble(finalSplit[5]);
						break;
					case 6:
						difference = Double.parseDouble(finalSplit[6]);
						break;
					case 7:
						String cutPercentSign[] = finalSplit[7].split("%");						//remove the % sign					
						percentDifference = Double.parseDouble(cutPercentSign[0]);
						break;
					case 8:
						stateAbbreviation = finalSplit[8];
						break;
					case 9:
						county = finalSplit[9];
						break;
					case 10:
						fips = Integer.parseInt(finalSplit[10]);								//convert String to Integer
						break;
					}//end switch	
				}//end nested for loop for string array
				//create a new instance of County Results2016 and save it to the ArrayList
				CountyResults2016 cr = new CountyResults2016(demVotes, gopVotes, totalVotes, percentDem, 
							percentGOP, difference, percentDifference, stateAbbreviation, county, fips);
				results.add(cr);
			}//end for loop line reader
			
			//close up shop
			fReader.close();
			bReader.close();
			//end try	
			
		} catch(IOException ioe) {
			System.out.println("Could not read file, aborting...");
			System.exit(0);
		}
	}
}
