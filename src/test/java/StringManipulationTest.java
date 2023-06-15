// Nick Cudd
// CS 410 Spring 2023
// JUnit Testing Assignment

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;


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

    // test to ensure that StringManipulation.count() returns 4 when input string contains 4 alphabetical tokens
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // test to ensure that StringManipulation.count() does not increase count when parsing non-alphabetical tokens
    // assumes that "words" are comprised of only alphabetic characters
    @Test
    public void testCount2() {
        manipulatedstring.setString("1-4/3* +1.,2 12']--3 word helo34");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    // test to ensure that StringManipulation.count() returns 0 when given empty string
    @Test
    public void testCount3() {
        manipulatedstring.setString("    ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // test to ensure that half-space character (U+2009) slices string correctly (avoid potential issue when copy-pasting strings)
    @Test
    public void testCount4() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // test to ensure that removeNthCharacter() concatenates string when spacing is to be ignored
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    // test to ensure that removeNthCharacter() preserves whitespace when spacing is to be maintained
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    // test to ensure removeNthCharacter() throws an IllegalArgumentException when passed n <= 0
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("test");
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(-3, true);
        });
        assertEquals("n is invalid: n > 0", testException.getMessage());
    }

    // test to ensure removeNthCharacter() throws an IndexOutOfBoundsException when passed n is greater than length of string
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("test");
        IndexOutOfBoundsException testException = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.removeNthCharacter(10, true);
        });
        assertEquals("n cannot exceed length of parameter String", testException.getMessage());
    }

    // test to ensure removeNthCharacter returns an empty string in the edge case of n = 1 when spacing is not maintained
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("test");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    /* test to ensure removeNthCharacter returns a string in the edge case of n = 1
    with exactly as the same count of whitespace as the count of original characters when spacing is maintained */
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("11111");
        assertEquals("     ".length(), manipulatedstring.removeNthCharacter(1, true).length());
    }

    // test to ensure removeNthCharacter can process a null string by throwing a NullPointerException
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString(null);
        NullPointerException testException = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.removeNthCharacter(3, true);
        });
        assertEquals("String has not been initialized yet, or is null", testException.getMessage());
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String[] sStrings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStrings[0], "my");
        assertEquals(sStrings[1], "string");
    }

    // test to ensure getSubStrings() throws an IllegalArgumentException when endWord or startWord indices <= 0
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("test string with spaces");
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(-3, 5);
        });
        assertEquals("startWord and endWord cannot be less than 1", testException.getMessage());
    }

    // test to ensure getSubStrings() throws an IndexOutOfBoundsException when startWord index > endWord index
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("test string with spaces");
        IndexOutOfBoundsException testException = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(13, 5);
        });
        assertEquals("index of endWord cannot be prior to index of startWord", testException.getMessage());
    }

    /* because getSubStrings() is inclusive,
       test to ensure that getSubStrings() returns a
       String array of a single word in unique case where startWord = endWord */
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is my string");
        String [] sStrings = manipulatedstring.getSubStrings(3, 3);
        assertEquals(sStrings[0], "my");
    }

    // test to ensure getSubString() can handle a null string by throwing a NullPointerException
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString(null);
        NullPointerException testException = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.getSubStrings(3, 4);
        });
        assertEquals("String has not been initialized yet, or is null", testException.getMessage());
    }

    /* test to ensure that getSubString() can handle half-space character (U+2009) and
       slices string correctly (avoids potential issue when copy-pasting strings) */
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is my string");
        String[] sStrings = manipulatedstring.getSubStrings(1, 3);
        assertEquals("This", sStrings[0]);
        assertEquals("my", sStrings[2]);
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int[] array;
        array = new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // test to ensure that restoreString() throws an IllegalArgumentException when passed index array length != string length
    @Test
    public void testRestoreString2() {
        int[] array = new int[]{1,0,2,3};
        manipulatedstring.setString("art");
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });
        assertEquals("passed index array must be same length as current String", testException.getMessage());
    }

    // test to ensure that restoreString() throws an IllegalArgumentException when passed index array contains duplicates
    @Test
    public void testRestoreString3() {
        int[] array = new int[]{1,1,2};
        manipulatedstring.setString("art");
        IllegalArgumentException testException = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });
        assertEquals("passed index array must contain unique integer values", testException.getMessage());
    }

    // test to ensure that restoreString() throws a NullPointerException when current string is null
    @Test
    public void testRestoreString4() {
        int[] array = new int[]{1,0,2};
        manipulatedstring.setString(null);
        NullPointerException testException = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.restoreString(array);
        });
        assertEquals("String has not been initialized yet, or is null", testException.getMessage());
    }

    // test to ensure that restoreString() throws an IndexOutOfBoundsException when passed index array contains integers beyond length of String
    @Test
    public void testRestoreString5() {
        int[] array = new int[]{1,2,7,4,5,3};
        manipulatedstring.setString("string");
        IndexOutOfBoundsException testException = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
        assertEquals("Array of indices cannot contain negative integers or integers greater than the length of the current String", testException.getMessage());
    }
}

