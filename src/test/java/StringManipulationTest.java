//Khalil Coats
//CS 410
//06/11/2023
//JUnit Testing, StringManipulationTest class


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedstring;

    @BeforeEach
    public void setUp() {
        manipulatedstring = new StringManipulation();
    }

    @AfterEach
    public void tearDown() {
        manipulatedstring = null;
    }

    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount2() {
    	//checks whether amount of spaces affects word count
    	manipulatedstring.setString("differently spaced    words             check.");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount3() {
    	//checks whether spaced punctuation characters count as words
    	manipulatedstring.setString("hello !! world");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    @Test
    public void testCount4() {
    	//checks if you can link special characters into words
    	manipulatedstring.setString("the qu|ck brown fox jumps over +he l@zy d0g");
        int length = manipulatedstring.count();
        assertEquals(9, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    public void testRemoveNthCharacter3() {
    	//checks if IllegalArgumentException is thrown when n is less than zero
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
    		assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(-1, true));
    	  }, "n must be at least 1.");
        assertEquals("n must be at least 1.", thrown.getMessage());
    }

    @Test
    public void testRemoveNthCharacter4() {
    	//checks if indexoutofboundsexception is thrown when n is greater than string length
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
    		assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(50, true));
    	  }, "index out of bounds");
        assertEquals("index out of bounds", thrown.getMessage());
    }

    @Test
    public void testRemoveNthCharacter5() {
    	//checks if IllegalArgumentException is thrown when n is zero
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
    		assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(0, true));
    	  }, "n must be at least 1.");
    	assertEquals("n must be at least 1.", thrown.getMessage());
    }    

    @Test
    public void testRemoveNthCharacter6() {
    	//blanks out string, maintainSpacing=true
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
        assertEquals("                                           ", manipulatedstring.removeNthCharacter(1, true));
    }

    @Test
    public void testRemoveNthCharacter7() {
    	//blanks out string, maintainSpacing=false
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
    		 String [] sStings = manipulatedstring.getSubStrings(6, 4);
    		 assertEquals(sStings[0], "the");
             assertEquals(sStings[1], "quick");
             assertEquals(sStings[2], "brown");
             assertEquals(sStings[3], "fox");
             assertEquals(sStings[4], "jumps");
             assertEquals(sStings[5], "over");
             assertEquals(sStings[6], "the");
             assertEquals(sStings[7], "lazy");
             assertEquals(sStings[8], "dog");
   	  }, "upper bound greater than lower bound");
         assertEquals("upper bound greater than lower bound", thrown.getMessage());
    }
    
    @Test
    public void testGeSubStrings3() {
    	//tests if IllegalArgumentException is thrown when startWord is negative
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
    	String [] sStings = manipulatedstring.getSubStrings(-2, 1);
       	assertEquals(sStings[0], "the");
       	assertEquals(sStings[1], "quick");
       	assertEquals(sStings[2], "brown");
       	assertEquals(sStings[4], "fox");
       	assertEquals(sStings[5], "jumps");
       	assertEquals(sStings[6], "over");
       	assertEquals(sStings[7], "the");
       	assertEquals(sStings[8], "lazy");
       	assertEquals(sStings[3], "dog");
  	  }, "Word position argument must be positive nonzero number.");
    	
    	assertEquals("Word position argument must be positive nonzero number.", thrown.getMessage());
    }
    
    @Test
    public void testGeSubStrings4() {
    	//tests if IllegalArgumentException is thrown when startWord is zero
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
    	String [] sStings = manipulatedstring.getSubStrings(0, 4);
       	assertEquals(sStings[0], "the");
       	assertEquals(sStings[1], "quick");
       	assertEquals(sStings[2], "brown");
       	assertEquals(sStings[4], "fox");
       	assertEquals(sStings[5], "jumps");
       	assertEquals(sStings[6], "over");
       	assertEquals(sStings[7], "the");
       	assertEquals(sStings[8], "lazy");
       	assertEquals(sStings[3], "dog");
  	  }, "Word position argument must be positive nonzero number.");
    	
    	assertEquals("Word position argument must be positive nonzero number.", thrown.getMessage());
    }
    
    @Test
    public void testGeSubStrings5() 
    {
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
   	 	
    	////tests if IndexOutOfBoundsException is thrown when arguments are greater than strings size
    	IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
    	String [] sStings = manipulatedstring.getSubStrings(10, 11);
    	assertEquals(sStings[0], "the");
    	assertEquals(sStings[1], "quick");
    	assertEquals(sStings[2], "brown");
    	assertEquals(sStings[4], "fox");
    	assertEquals(sStings[5], "jumps");
    	assertEquals(sStings[6], "over");
    	assertEquals(sStings[7], "the");
    	assertEquals(sStings[8], "lazy");
    	assertEquals(sStings[3], "dog");
    	}, "upper bound or lower is greater than word count");
        	
        assertEquals("upper bound or lower is greater than word count", thrown.getMessage());
    }
    
    @Test
    public void testGeSubStrings6() {
    	//tests if IllegalArgumentException is thrown when endWord is negative
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
    		String [] sStings = manipulatedstring.getSubStrings(-3, -1);
   	 		assertEquals(sStings[0], "the");
   	 		assertEquals(sStings[1], "quick");
   	 		assertEquals(sStings[2], "brown");
   	 		assertEquals(sStings[4], "fox");
        	assertEquals(sStings[5], "jumps");
        	assertEquals(sStings[6], "over");
        	assertEquals(sStings[7], "the");
        	assertEquals(sStings[8], "lazy");
        	assertEquals(sStings[3], "dog");
        	}, "Word position argument must be positive nonzero number.");
            	
            assertEquals("Word position argument must be positive nonzero number.", thrown.getMessage());
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    public void testRestoreString2()
    {
    	//reverse string character order
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	int [] array;
        array=new int[]{42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
    	String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "god yzal eht revo spmuj xof nworb kciuq eht");

    }

    @Test
    public void testRestoreString3()
    {
    	//tests if IndexOutOfBoundsException is thrown when one of index elements is greater than size of string
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	int [] array;
    	array=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42, 43};
    	IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
        	String restoreString = manipulatedstring.restoreString(array);
        	assertEquals(restoreString, "the quick brown fox jumps over the lazy dog");
        	}, "one of the indices is out of array bounds");
            	
            assertEquals("one of the indices is out of array bounds", thrown.getMessage());
    }

    @Test
    public void testRestoreString4()
    {
    	//tests if IndexOutOfBoundsException is thrown when one of index elements is negative
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	int [] array;
    	array=new int[]{-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41};
    	IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
        	String restoreString = manipulatedstring.restoreString(array);
        	assertEquals(restoreString, "the quick brown fox jumps over the lazy dog");
        	}, "one of the indices is out of array bounds");
            	
            assertEquals("one of the indices is out of array bounds", thrown.getMessage());

    }

    @Test
    public void testRestoreString5()
    {
    	//tests if IllegalArgumentException is thrown when array length is less than string length
    	manipulatedstring.setString("the quick brown fox jumps over the lazy dog");
    	int [] array;
    	array=new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41};
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
        	String restoreString = manipulatedstring.restoreString(array);
        	assertEquals(restoreString, "the quick brown fox jumps over the lazy dog");
        	}, "Illegal argument passed. Array argument length doesn't match string length");
            	
            assertEquals("Illegal argument passed. Array argument length doesn't match string length", thrown.getMessage());

    }

}
