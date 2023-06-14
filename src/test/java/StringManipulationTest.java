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
    public void testgetString(){
        manipulatedstring.setString("Hello!");
        String expected = "Hello!";
        String actual = manipulatedstring.getString();
        assertEquals(expected, actual);
    }
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Test when string has multiple punctuations.
    @Test
    public void testCount2() {
        manipulatedstring.setString("This isn't my string!");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Test when string is empty.
    // Expected return is 0
    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // Test when string is null
    // Expected return is 0
    @Test
    public void testCount4() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // Test when string has only empty space character.
    // Expected return is 0
    @Test
    public void testCount5() {
        manipulatedstring.setString("     ");
        int length = manipulatedstring.count();
        assertEquals(0, length);    }

    // Test if the method removes the right characters without maintaining spacing
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String expected = "I' bttr uts0e 16tsinths trn6 rgh?";
        String actual = manipulatedstring.removeNthCharacter(3, false);
        assertEquals(expected, actual);
    }

    // Test if the method removes the right characters while maintaining spacing
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String expected = "I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?";
        String actual = manipulatedstring.removeNthCharacter(3, true);
        assertEquals(expected, actual);
    }

    // Throw IllegalArgumentException if the given index is less than or equal to 0
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("This is 28 character string.");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.removeNthCharacter(29, true);});
    }

    // Throw IndexOutOfBoundException if the given index is exceeds the size of the string
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("This is 28 character string.");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(0, true);});
    }

    // Deleting all characters without maintaining spacing.
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("This is 28 character string.");
        String expected = "";
        String actual = manipulatedstring.removeNthCharacter(1, false);
        assertEquals(expected, actual);
    }

    // Deleting each character while maintaining spacing.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("This is 28 character string.");
        String expected = "                            ";
        String actual = manipulatedstring.removeNthCharacter(1, true);
        assertEquals(expected, actual);
    }

    // Deleting only the last character without adding a space.
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("This is 28 character string.");
        String expected = "This is 28 character string";
        String actual = manipulatedstring.removeNthCharacter(28, false);
        assertEquals(expected, actual);
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // Test when the startWord index is less than or equal to 0
    // Throws IllegalArgumentException
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(0, 2);});
    }

    // Test when the endWord index is less than or equal to 0
    // Throws IllegalArgumentException
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(1, 0);});
    }

    // Test when the startWord index is greater than endWord index
    // Throws IllegalArgumentException
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(2, 1);});
    }

    // Test when the endWord index is greater than the word count of string
    // Throws IndexOutOfBoundException
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This is my string");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(2, 5);});
    }

    // Test when the startWord and endWord are equal
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(4, 4);
        String expected = "string";
        String actual = sStings[0];

        assertEquals(expected, actual);
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array = new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // Throw IllegalArgumentException if the indices length is greater than the string length. {5,6,7,8,9,10,11,0,1,2,3,4,12};
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("JUnitTesting!");
        int[] indices = {5,6,7,8,9,10,11};
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(indices);});
    }

    // Throw IndexOutOfBoundsException if any indice is less than 0.
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("JUnitTesting!");
        int[] indices = {5,6,7,8,9,10,11,0,1,2,3,4,-8};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);});
    }

    // Throw IndexOutOfBoundsException if any indice is greater than the string length
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("JUnitTesting!");
        int[] indices = {5,6,7,8,9,10,11,0,1,2,3,4,13};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);});
    }

    // Test when each character is the same in the string
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("aaa");
        int [] indices = {1,0,2};
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals(restoreString, "aaa");
    }

}
