import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Michael Haupt

//test results
//largest nation margin is 50.69% Huntingdon
//largest state margin by state 
//PA Huntingdon 50.69
//NY 42.14
//WA 50.43
//IL 3.04

class ElectionTest {
	
	CountyResults2016 test1 = new CountyResults2016(13093,37224,52029,0.251648119318,0.715447154472,24131,46.38,"PA","Blair County",42013);
	CountyResults2016 test2 = new CountyResults2016(4487,14369,19496,0.230149774313,0.737022979073,9882,50.69,"PA","Huntingdon County",42061);
	CountyResults2016 test3 = new CountyResults2016(20348,19051,42605,0.477596526229,0.447154089896,1297,3.04,"IL","DeKalb County",17037);
	CountyResults2016 test4 = new CountyResults2016(657149,197781,910823,0.721489246539,0.217145372921,459368,50.43,"WA","King County",53033);
	CountyResults2016 test5 = new CountyResults2016(25555,9647,37747,0.6770074443,0.255569979071,15908,42.14,"NY","Tompkins County",36109);
	CountyResults2016 test6 = new CountyResults2016(36555,35099,75394,0.484852906067,0.465541024485,1456,1.93,"PA","Centre County",42027);
	
	ElectionDriver testDriver = new ElectionDriver();
	
	
	@Test
	void testFindLargestMargin() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testFindLargestMarginState() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testGetStateTotals() {
		fail("Not yet implemented");
	}

}
