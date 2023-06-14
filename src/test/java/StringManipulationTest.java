/* Nadav Horowitz 6/3/2023 StringManipulationTest.java
 * This file contains JUnit tests for the StringManipulation class.
 * Tested methods include count, removeNthCharacter, getSubStrings, and restoreString.
 * Tests either check for correct output or check that correct Exception is thrown.
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedstring;

    @BeforeEach
    //setUp method initializes StringManipulation object with null String field before each test.
    public void setUp() {
        manipulatedstring = new StringManipulation();
    }

    @AfterEach
    //tearDown method ensures garbage collection of StringManipulation object after each test.
    public void tearDown() {
        manipulatedstring = null;
    }

    @Test
    //testCount1 calls count() with a standard 4 word test String and ensures the method returns 4 as the number of words.
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    //testCount2 calls count() with a null test String and ensures the method returns 0 as the number of words.
    public void testCount2() {
    	manipulatedstring.setString(null);
    	int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //testCount3 calls count() with an empty test String and ensures the method returns 0 as the number of words.
    public void testCount3() {
    	manipulatedstring.setString("");
    	int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //testCount3 calls count() with a test String containing lots of whitespace
    //and ensures the method returns 5 as the number of words.
    public void testCount4() {
    	manipulatedstring.setString("  a   lot   of white    space    ");
    	int length = manipulatedstring.count();
        assertEquals(5, length);
    }

    @Test
    //testRemoveNthCharacter1 calls removeNthCharacter() with standard parameters and ensures the method
    //removes the desired characters. 
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String NthCharRemoved = manipulatedstring.removeNthCharacter(3, false);
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", NthCharRemoved);
    }

    @Test
    //testRemoveNthCharacter2 calls removeNthCharacter() with standard parameters and ensures the method
    //removes the desired characters and replaces them with spaces.
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String NthCharRemoved = manipulatedstring.removeNthCharacter(3, true);
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", NthCharRemoved);
    }

    @Test
    //testRemoveNthCharacter3 calls removeNthCharacter() with a standard String parameter
	//and parameter n = 1 and ensures the method returns an empty String.
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("This is a nice sentence.");
        String NthCharRemoved = manipulatedstring.removeNthCharacter(1, false);
        assertEquals("", NthCharRemoved);
    }

    @Test
    //testRemoveNthCharacter4 calls removeNthCharacter with a standard String parameter
    //and parameter n = stringLength and ensures the method removes only the last character.
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Remove the last character only");
        int stringLength = manipulatedstring.getString().length();
        String NthCharRemoved = manipulatedstring.removeNthCharacter(stringLength, false);
        assertEquals("Remove the last character onl", NthCharRemoved);
    }

    @Test
    //testRemoveNthCharacter5 calls removeNthCharacter with a standard String parameter
    //and parameter n = 2 and ensures the method removes and replaces every other character with a space.
    public void testRemoveNthCharacter5() {
    	manipulatedstring.setString("This is a nice sentence.");
    	String NthCharRemoved = manipulatedstring.removeNthCharacter(2, true);
    	assertEquals("T i   s a n c   e t n e ", NthCharRemoved);
    }
    
    @Test
    //testRemoveNthCharacter6 calls removeNthCharacter with n <= 0 and ensures the method throws an IllegalArgumentException
    public void testRemoveNthCharacter6() {
    	assertThrows(IllegalArgumentException.class,
                ()->{
                	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
                	manipulatedstring.removeNthCharacter(-99, false);
                });
    }

    @Test
    //testRemoveCharacter7 calls removeNthCharacter with n > stringLength and ensures the method
    //throws an IndexOutOfBoundsException
    public void testRemoveNthCharacter7() {
    	assertThrows(IndexOutOfBoundsException.class,
                ()->{
                	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
                	manipulatedstring.removeNthCharacter(99, true);
                });
    }

    @Test
    //testGeSubStrings1 calls testGeSubStrings with a standard String parameter and ensures the method
    //returns the correct output
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    //testGeSubStrings2 calls testGeSubStrings with a String parameter containing lots of whitespace 
    //and ensures the method returns the correct output
    public void testGeSubStrings2() {
        manipulatedstring.setString("This        is my                            string");
        String [] sStings = manipulatedstring.getSubStrings(1, 3);
        assertEquals(sStings[0], "This");
        assertEquals(sStings[1], "is");
        assertEquals(sStings[2], "my");
    }
    
    @Test
    //testGeSubStrings3 calls testGeSubStrings with a standard String parameter and an invalid startWord = 0 parameter
    //and ensures the method throws an IllegalArgumentException
    public void testGeSubStrings3() {
    	assertThrows(IllegalArgumentException.class,
                ()->{
                	manipulatedstring.setString("This is my string");
                	manipulatedstring.getSubStrings(0, 1);
                });
    }
    
    @Test
    //testGeSubStrings4 calls testGeSubStrings with a standard String parameter and invalid endword = 0 parameter
    //and ensures the method throws an IllegalArgumentException
    public void testGeSubStrings4() {
    	assertThrows(IllegalArgumentException.class,
                ()->{
                	manipulatedstring.setString("This is my string");
                	manipulatedstring.getSubStrings(3, 0);
                });
    }
    
    @Test
    //testGeSubStrings5 calls testGeSubStrings with a standard String parameter and invalid startWord > endWord parameters
    //and ensures the method throws an IllegalArgumentException
    public void testGeSubStrings5() {
    	assertThrows(IllegalArgumentException.class,
                ()->{
                	manipulatedstring.setString("This is my string");
                	manipulatedstring.getSubStrings(4, 1);
                });
    }
    
    @Test
    //testGeSubStrings6 calls testGeSubStrings with a standard String parameter and endWord > stringLength parameter
    //and ensures the method throws an IndexOutOfBoundsException
    public void testGeSubStrings6() {
    	assertThrows(IndexOutOfBoundsException.class,
                ()->{
                	manipulatedstring.setString("This is my string");
                	manipulatedstring.getSubStrings(1, 10);
                });
    }
    
    @Test
    //testRestoreString1 calls testRestoreString with standard paramaters and ensures the method returns the correct output
    public void testRestoreString1(){
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    //testRestoreString2 calls testRestoreString with an array of lesser length than the current String
    //and ensures the method throws an IllegalArgumentException
    public void testRestoreString2(){
        manipulatedstring.setString("0123456789");
        int [] array;
        array=new int[] {5};
    	assertThrows(IllegalArgumentException.class,
                ()->{
                	manipulatedstring.restoreString(array);
                });
    }
    
    @Test
    //testRestoreString3 calls testRestoreString with an array of greater length than the current String
    //and ensures the method throws an IllegalArgumentException
    public void testRestoreString3(){
    	manipulatedstring.setString("fart");
        int [] array;
        array=new int[]{1,0,2};
    	assertThrows(IllegalArgumentException.class,
                ()->{
                	manipulatedstring.restoreString(array);
                });
    }

    @Test
    //testRestoreString4 calls testRestoreString with indices array containing an element < 0
    //and ensures the method throws an IndexOutOfBoundsException
    public void testRestoreString4(){
    	manipulatedstring.setString("art");
        int [] array;
        array=new int[]{-1,0,2};
    	assertThrows(IndexOutOfBoundsException.class,
                ()->{
                	manipulatedstring.restoreString(array);
                });
    }

    @Test
    //testRestoreString5 calls testRestoreString with indices array containing an element > stringLength
    //and ensures the method throws an IndexOutOfBoundsException
    public void testRestoreString5(){
    	manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,20};
    	assertThrows(IndexOutOfBoundsException.class,
                ()->{
                	manipulatedstring.restoreString(array);
                });
    }
}