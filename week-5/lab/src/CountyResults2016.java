//Michael Haupt

public class CountyResults2016 {
	
	//instance variables
	double demVotes;
	double gopVotes;
	double totalVotes;
	double percentDem;
	double percentGOP;
	double difference;
	double percentDifference;
	String stateAbbreviation;
	String county;
	int fips;
	
	
	//constructors
	public CountyResults2016(){} //no argument constructor
	public CountyResults2016(double dVotes, double gVotes, double tVotes, double pDems, double pGOP, double diff, double pDiff, String stateAbr, String sCounty, int fipsNum) {
		this.demVotes = dVotes;
		this.gopVotes = gVotes;
		this.totalVotes = tVotes;
		this.percentDem = pDems;
		this.percentGOP = pGOP;
		this.difference = diff;
		this.percentDifference = pDiff;
		this.stateAbbreviation = stateAbr;
		this.county = sCounty;
		this.fips = fipsNum;
		
	}

	
	//getters
	public double getDemVotes() {
		return demVotes;
	}
	public double getGopVotes() {
		return gopVotes;
	}
	public double getTotalVotes() {
		return totalVotes;
	}
	public double getPercentDem() {
		return percentDem;
	}
	public double getPercentGOP() {
		return percentGOP;
	}
	public double getDifference() {
		return difference;
	}
	public double getPercentDifference() {
		return percentDifference;
	}
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}
	public String getCounty() {
		return county;
	}
	public int getFips() {
		return fips;
	}
	
	@Override
    public String toString(){
        String state = "";
        state = String.format("%s %.0f%n%s %.0f%n%s %.0f%n%s %.2f%s%n%s %.2f%s%n%s %.0f%n%s %s%s%n%s %s%n%s%n%s %s%n",
        		"Dem Votes:", this.demVotes,
        		"GOP Votes:", this.gopVotes,
        		"Total Votes:", this.totalVotes,
        		"Percent Dems:", this.percentDem*100, "%",
        		"Percent GOP:", this.percentGOP*100, "%",
        		"Difference:", this.difference,
        		"Percent Difference:", this.percentDifference, "%",
        		"State Abbreviation:", this.stateAbbreviation,
        		this.county,
        		"fips No:", this.fips
        		);
        return state;
    }
	
	
	
	
	
}
