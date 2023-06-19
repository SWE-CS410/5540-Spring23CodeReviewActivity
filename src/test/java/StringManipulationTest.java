//Author: Jonathan Jarman (worked on some of the test cases)
//Date: 6/11/2023
//File: String Manipulation Test File

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

    // DO NOT EDIT
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Test case for an empty string
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0,length);
    }

    // Test case for a null string
    @Test
    public void testCount3() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, () -> manipulatedstring.count());
    }

    // Test case to verify counting words in a string with punctuation
    @Test
    public void testCount4() {
        manipulatedstring.setString("Hello, World!");
        int count = manipulatedstring.count();
        assertEquals(2, count);
    }

    @Test
    public void testCount5() {
        manipulatedstring.setString(" Hello World ");
        int count = manipulatedstring.count();
        assertEquals(2, count);
    }

    @Test
    public void testCount6() {
        manipulatedstring.setString("    There       are words         here !! ");
        int count = manipulatedstring.count();
        assertEquals(4, count);
    }

    // DO NOT EDIT
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    // DO NOT EDIT
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?",
                manipulatedstring.removeNthCharacter(3, true));
    }

    // Test case to verify removing nth character in a different string
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("I'm learning to code!");
        assertEquals("I'm lea nin  to cod !", manipulatedstring.removeNthCharacter(4, true));
    }

    // Test case for removing nth character with an out-of-bounds value of n
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Test string");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(13, true));
    }

    // Test case to verify removing nth character without maintaining spacing in a
    // different string
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("This is a test.");
        assertEquals("Ths s  tst", manipulatedstring.removeNthCharacter(3, false));
    }

    // Test case for removing nth character with an invalid value of n
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Test string");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, true));
    }

    // Test case to verify removing nth character in a long string
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("I am testing the removeNthCharacter method");
        assertEquals("I a   e t n   h   e o e t C a a t r m t o ", manipulatedstring.removeNthCharacter(2, true));
    }

    // Test case for removing nth character from a null string
    @Test
    public void testRemoveNthCharacter8() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, () -> manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter9() {
        manipulatedstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(2, true));
    }

    // DO NOT EDIT
    @Test
    public void testGeSubStrings1() {
        // Set up the initial string
        manipulatedstring.setString("This is my string");
        String[] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // Test case to verify extracting multiple substrings from a string
    @Test
    public void testGeSubStrings2() {
        // Set up the initial string
        manipulatedstring.setString("This is my string");
        String[] subStrings = manipulatedstring.getSubStrings(1, 4);
        assertEquals(subStrings.length, 4);
        assertEquals(subStrings[0], "This");
        assertEquals(subStrings[1], "is");
        assertEquals(subStrings[2], "my");
        assertEquals(subStrings[3], "string");
    }

    // Test case for extracting substrings with out-of-bounds indices
    @Test
    public void testGeSubStrings3() {
        // Set up the initial string
        manipulatedstring.setString("This is my string");
        // Call the getSubStrings method with out of bounds indices
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(2, 6));
    }

    // Test case for extracting substrings from a null string
    @Test
    public void testGeSubStrings4() {
        // Set up the initial string to null
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, () -> manipulatedstring.getSubStrings(2, 5));
    }

    // Test case for extracting substrings with invalid startWord and endWord values
    @Test
    public void testGeSubStrings5() {
        // Set up the initial string
        manipulatedstring.setString("Hello!");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(-1, 0));
    }

    // Test case to verify extracting a single substring
    @Test
    public void testGeSubStrings6() {
        // Set up the initial string
        manipulatedstring.setString("0 1");
        String[] sString = manipulatedstring.getSubStrings(1, 2);
        assertEquals(sString[0], "0");
    }

    // DO NOT EDIT
    @Test
    public void testRestoreString1() {
        // Set up the initial string
        manipulatedstring.setString("art");
        int[] array;
        array = new int[] { 1, 0, 2 };
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // Test case for restoring an empty string
    @Test
    public void testRestoreString2() {
        // Set up the initial string
        manipulatedstring.setString("");
        int[] indices = {};
        String result = manipulatedstring.restoreString(indices);
        assertEquals("", result);
    }

    // Test case for restoring a string with an out-of-bounds index in the indices
    // array
    @Test
    public void testRestoreString3() {
        // Set up the initial string
        manipulatedstring.setString("abc");
        // setting up indices for shuffling, this one goes out of bounds
        int[] indices = { 1, 2, 4 };
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(indices));
    }

    // Test case for restoring a null string
    @Test
    public void testRestoreString4() {
        // setting up null string
        manipulatedstring.setString(null);
        // setting indicies
        int[] indices = { 0, 1, 2 };
        // throwing an exception for null string
        assertThrows(NullPointerException.class, () -> manipulatedstring.restoreString(indices));
    }

    // Test case to verify restoring a shuffled string with multiple indices
    @Test
    public void testRestoreString5() {
        // setting up string
        manipulatedstring.setString("abcdefg");
        // setting indicies
        int[] indices = { 3, 5, 2, 0, 6, 1, 4 };
        // shuffling string
        String result = manipulatedstring.restoreString(indices);
        // testing result
        assertEquals("dfcagbe", result);
    }

    // Test case for restoring a string with duplicate indices in the indices array
    @Test
    public void testRestoreString6() {
        // Set up the initial string
        manipulatedstring.setString("example");

        // Set up indices with duplicate values
        int[] indices = { 2, 0, 1, 0, 3, 4, 5 };

        // Expecting an IllegalArgumentException due to duplicate indices
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(indices));
    }

}
