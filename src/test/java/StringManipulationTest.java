// Sean Michael CS410

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

    @Test // Tests a standard string with multiple tokens
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test // Tests an empty string
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test // Tests a string with only one token
    public void testCount3() {
        manipulatedstring.setString("This");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test // Tests a string with two tokens
    public void testCount4() {
        manipulatedstring.setString("1 2");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    @Test // Tests standard usage with every other character removed
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("123456789");
        assertEquals("13579", manipulatedstring.removeNthCharacter(2,false),manipulatedstring.getString());
    }

    @Test // Tests standard usage with every other character replaced with a space
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("123456789");
        assertEquals("1 3 5 7 9", manipulatedstring.removeNthCharacter(2,true),manipulatedstring.getString());
    }

    @Test // Tests removal from empty string
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("");
        assertEquals("", manipulatedstring.removeNthCharacter(0,false),manipulatedstring.getString());
    }

    @Test // Tests removing every 0th character
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("123456789");
        assertEquals("123456789", manipulatedstring.removeNthCharacter(0,false),manipulatedstring.getString());
    }

    @Test // Tests replacing every 0th character with a space
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("123456789");
        assertEquals("123456789", manipulatedstring.removeNthCharacter(0,true),manipulatedstring.getString());
    }

    @Test // Tests removing every character
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("123456789");
        assertEquals("", manipulatedstring.removeNthCharacter(1,false),manipulatedstring.getString());
    }

    @Test // Tests replacing every character with a space
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("123456789");
        assertEquals("         ", manipulatedstring.removeNthCharacter(1,true),manipulatedstring.getString());
    }

    @Test // Tests illegal argument exception
    public void testRemoveNthCharacter8() {
        manipulatedstring.setString("123456789");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-1,true),
                "Negative n did not throw exception");
    }

    @Test // Tests index out of bounds exception
    public void testRemoveNthCharacter9() {
        manipulatedstring.setString("123456789");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(40,true),
                "Excessive n did not throw out of bounds");
    }

    @Test // Tests standard usage of getting two strings from a 4 token string with varying spaces
    public void testGetSubStrings1() {
        manipulatedstring.setString("This   is  my   string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals("my", sStings[0]);
        assertEquals("string", sStings[1]);
    }

    @Test // Tests illegal argument exception with start word after end word
    public void testGetSubStrings2() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(4, 3),
                "start word allowed to be after end word");
    }
    @Test // Tests index out of bounds exception
    public void testGetSubStrings3() {
        manipulatedstring.setString("This is my string");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(3, 5),
                "end word exceeds number of words");
    }
    @Test // Tests illegal argument exception with word index too low
    public void testGetSubStrings4() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0, 3),
                "word index allowed to be negative or 0");
    }
    @Test // Tests getting only final substring
    public void testGetSubStrings5() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(4, 4);

        assertEquals("string", sStings[0]);
    }
    @Test // Tests getting only first substring
    public void testGetSubStrings6() {
        manipulatedstring.setString("This");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals("This", sStings[0]);
    }
    @Test // Tests getting all substrings
    public void testGetSubStrings7() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);

        assertEquals("This", sStings[0]);
        assertEquals("string", sStings[3]);
    }

    @Test // Tests standard usage of restore string
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        String restoreString = manipulatedstring.restoreString(new int[] {1, 0, 2});
        assertEquals("rat", restoreString);
    }

    @Test // Tests index out of bounds for invalid indices passed
    public void testRestoreString2()
    {
        manipulatedstring.setString("art");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(new int[] {4, 5, 6}));

    }

    @Test // Tests illegal argument exception for too many indices passed
    public void testRestoreString3()
    {
        manipulatedstring.setString("art");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(new int[] {1, 2, 3, 4}));

    }

    @Test // Tests empty string restoration
    public void testRestoreString4()
    {
        manipulatedstring.setString("");
        String restoreString = manipulatedstring.restoreString(new int[] {});
        assertEquals("", restoreString);

    }

    @Test // Tests single char string restoration
    public void testRestoreString5()
    {
        manipulatedstring.setString(" ");
        String restoreString = manipulatedstring.restoreString(new int[] {1});
        assertEquals(" ", restoreString);

    }

}
