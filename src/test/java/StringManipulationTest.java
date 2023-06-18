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
    //this test checks whether method count throws an IllegalArgumentException if count is not 4

    @Test
    public void testCount2() {
        manipulatedstring.setString("hi");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }
  //this test checks whether method count throws an IllegalArgumentException if count is not 1

    @Test
    public void testCount3() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }
  //this test checks whether method count throws an IllegalArgumentException if count is not 0

    @Test
    public void testCount4() {
        manipulatedstring.setString("  Spaces  between   words ");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }
  //this test checks whether method count throws an IllegalArgumentException if count is not 3
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }
  // this test checks whether method removeNthCharacter prints out the right string, which is "I' bttr uts0e 16tsinths trn6 rgh?"
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }
    
 // this test checks whether method removeNthCharacter prints out the right string, which is "I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?"


    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Hello");
        IndexOutOfBoundsException testException = assertThrows(IndexOutOfBoundsException.class, () -> {
        	manipulatedstring.removeNthCharacter(10, true);
        });
        assertEquals("Error: n exceeds string length", testException.getMessage());
    }
 // this test checks whether method removeNthCharacter throws an IndexOutOfBoundsException if n exceeds string length

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Testing123");
        assertEquals("Tetig13", manipulatedstring.removeNthCharacter(3, false));
    }
    
 // this test checks whether method removeNthCharacter prints out the right string, which is "Tetig13"

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Welcome to the jungle");
        assertEquals("W l o e t   h   u g e", manipulatedstring.removeNthCharacter(2, true));
    }
    
    //this test checks whether method removeNthCharacter prints out the right string, which is "W l o e t   h   u g e"

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I am loving it!");
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
        	manipulatedstring.removeNthCharacter(-54, true);
        });
        assertEquals("Error: n is less than or equal to 0", testException.getMessage());
    }
    
 // this test checks whether method removeNthCharacter throws an IllegalArgumentException if n is less than or equal to 0

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString(null);
        NullPointerException testException = assertThrows(NullPointerException.class, () -> {
        	manipulatedstring.removeNthCharacter(5, true);
        });
        assertEquals("Error: String has not been initialized", testException.getMessage());
    }
 // this test checks whether method removeNthCharacter throws an NullPointerException if string is null

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
 // this test checks whether method getSubStrings returns the right substring, which is "my" and "string"

    @Test
    public void testGetSubStrings2() {
    	manipulatedstring.setString(null);
        NullPointerException testException = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.getSubStrings(3, 4);
        });
        assertEquals("Error: string is not yet initialized", testException.getMessage());
    }
    
 // this test checks whether method getSubStrings throws an NullPointerException if the new sub string is null

    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("Hello World! How are you?");
        IndexOutOfBoundsException testException = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(4, 72);
        });
        assertEquals("Error: end index is larger than the string length", testException.getMessage());
    }
 // this test checks whether method getSubStrings throws an IndexOutOfBoundsException if the end index is larger than the string length

    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("Java is a popular programming language");
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(4, -51);
        });
        assertEquals("Error: start index and end index is less than 1", testException.getMessage());
    }
 // this test checks whether method getSubStrings throws an IllegalArgumentException if start index and end index is less than 1

    @Test
    public void testGetSubStrings5() {
        manipulatedstring.setString("The quick brown fox jumps over the lazy dog");
        IndexOutOfBoundsException testException = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(23, 2);
        });
        assertEquals("Error: start index is larger than end", testException.getMessage());
    
    }
 // this test checks whether method getSubStrings throws an IllegalArgumentException if the new sub string does not contain "fox", "jumps", and "over"
    
    @Test
    public void testGetSubStrings6() {
        manipulatedstring.setString("I love coding in Java");
        String[] sStings = manipulatedstring.getSubStrings(2, 5);
        
        assertEquals( sStings[0], "love");
        assertEquals(sStings[1], "coding");
        assertEquals(sStings[2], "in");
        assertEquals( sStings[3], "Java");
    }
 //  this test checks whether method getSubStrings returns the right substring, which is "love", "coding", "in", and "Java"
    
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }
    
 // this test checks whether method restoreString returns the right restored string, which is "rat"

    @Test
    public void testRestoreString2() {
        int[] array = new int[]{2,0,3,1,4};
        manipulatedstring.setString(null);
        NullPointerException testException = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.restoreString(array);
        });
        assertEquals("Error: string is not yet initialized", testException.getMessage());
    }
    
    // this test checks whether method count throws an IllegalArgumentException if the new restored string is not "sarudtay"
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("abcd");
        int [] array;
        array = new int[]{3, 2, 1, 3};
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });
        assertEquals("Error: some indexes are not unique", testException.getMessage());
    }
    
 // this test checks whether method restoreString throws an IllegalArgumentException if the indexes are not unique

    @Test
    public void testRestoreString4() {
    	 int[] array = new int[]{2,1,3,0};
         manipulatedstring.setString("ih");
         IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
             manipulatedstring.restoreString(array);
         });
         assertEquals("Error: string length is not equal to indices length", testException.getMessage());
    }
    
 // this test checks whether method restoreString throws an IllegalArgumentException if string length is not equal to indices length

    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("Programming is fun!");
        int [] array;
        array=new int[]{3, 14, 9, 13, 6, 2, 1, 12, 4, 11, 7, 18, 8, 17, 16, 15, 10, 0, 5};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "g nsmorir m!inufgPa");
    }
    
 // this test checks whether method restoreString returns the right restored string, which is "g nsmorir m!inufgPa"

}
