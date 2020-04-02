import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Book_Info_Tests {
	
	Audio a1 = new Audio("Dune","Frank Herbert","Macmillan Audio","December 31, 2006","English",21);
	Audio a2 = new Audio("Dune","Frank Herbert","Macmillan Audio","December 31, 2006","English",21);
	
	Audio a3 = new Audio("Dune1","Frank Herbert","Macmillan Audio","December 31, 2006","English",21);
	Audio a4 = new Audio("Dune","Frank Herbert1","Macmillan Audio","December 31, 2006","English",21);
	Audio a5 = new Audio("Dune","Frank Herbert","Macmillan Audio1","December 31, 2006","English",21);
	Audio a6 = new Audio("Dune","Frank Herbert","Macmillan Audio","December 311, 2006","English",21);
	Audio a7 = new Audio("Dune","Frank Herbert","Macmillan Audio","December 31, 2006","English1",21);
	Audio a8 = new Audio("Dune","Frank Herbert","Macmillan Audio","December 31, 2006","English",211);
	
	
	Encyclopedia e1 = new Encyclopedia("The Illustrated Encyclopedia of the Universe","James W. Guthrie", "Watson-Guptill","2001","2nd",1);
	Encyclopedia e2 = new Encyclopedia("The Illustrated Encyclopedia of the Universe","James W. Guthrie", "Watson-Guptill","2001","2nd",1);
	
	Encyclopedia e3 = new Encyclopedia("The Illustrated Encyclopedia of the Universe1","James W. Guthrie", "Watson-Guptill","2001","2nd",1);
	Encyclopedia e4 = new Encyclopedia("The Illustrated Encyclopedia of the Universe","James W. Guthrie1", "Watson-Guptill","2001","2nd",1);
	Encyclopedia e5 = new Encyclopedia("The Illustrated Encyclopedia of the Universe","James W. Guthrie", "Watson-Guptill1","20011","2nd",1);
	Encyclopedia e6 = new Encyclopedia("The Illustrated Encyclopedia of the Universe","James W. Guthrie", "Watson-Guptill","2001","2nd1",1);
	Encyclopedia e7 = new Encyclopedia("The Illustrated Encyclopedia of the Universe","James W. Guthrie", "Watson-Guptill","2001","2nd",11);
	
	
	@Test
	void testAudioEquals() {
		assertTrue(a1.equals(a2));
		assertTrue(a2.equals(a1));	
	}
	
	@Test
	void testAudioEquals1() {
		assertFalse(a1.equals(a3));
		assertFalse(a3.equals(a1));
	}

	@Test
	void testAudioEquals2() {
		assertFalse(a1.equals(a4));
		assertFalse(a4.equals(a1));
	}
	
	@Test
	void testAudioEquals3() {
		assertFalse(a1.equals(a5));
		assertFalse(a5.equals(a1));
	}
	
	@Test
	void testAudioEquals4() {
		assertFalse(a1.equals(a6));
		assertFalse(a6.equals(a1));
	}
	
	@Test
	void testAudioEquals5() {
		assertFalse(a1.equals(a7));
		assertFalse(a7.equals(a1));
	}
	
	@Test
	void testAudioEquals6() {
		assertFalse(a1.equals(a8));
		assertFalse(a8.equals(a1));
	}
	
	////////////////////////////////
	
	@Test
	void testEncyclopediaEquals1() {
		assertTrue(e1.equals(e2));
		assertTrue(e2.equals(e1));
	}
	
	@Test
	void testEncyclopediaEquals2() {
		assertFalse(e1.equals(e3));
		assertFalse(e3.equals(e1));
	}
	
	@Test
	void testEncyclopediaEquals3() {
		assertFalse(e1.equals(e4));
		assertFalse(e4.equals(e1));
	}
	
	@Test
	void testEncyclopediaEquals4() {
		assertFalse(e1.equals(e5));
		assertFalse(e5.equals(e1));
	}
	
	@Test
	void testEncyclopediaEquals5() {
		assertFalse(e1.equals(e6));
		assertFalse(e6.equals(e1));
	}
	
	@Test
	void testEncyclopediaEquals6() {
		assertFalse(e1.equals(e7));
		assertFalse(e7.equals(e1));
	}
	
	
	
	
	
	
}
