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

    // Test case when setting string to a non-empty string.
    @Test
    public void testSetString1() {
        String input = "abc";
        manipulatedstring.setString(input);
        String s = manipulatedstring.getString();
        assertEquals(s,input);
    }

    // Test case when string is set to null.
    @Test
    public void testSetString2() {
        manipulatedstring.setString(null);
        String s = manipulatedstring.getString();
        assertEquals(s,null);
    }

    // Test case for setting the string to empty.
    @Test
    public void testSetString3() {
        manipulatedstring.setString("");
        String s = manipulatedstring.getString();
        assertEquals(s,"");
    }

    // Test case when string is null.
    @Test
    public void testGetString1() {
        String s = manipulatedstring.getString();
        assertEquals(s,null);
    }

    // Test case when string is a non-empty string.
    @Test
    public void testGetString2() {
        manipulatedstring.setString("abc");
        String s = manipulatedstring.getString();
        assertEquals(s,"abc");
    }

    // Default test case.
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Test case when string is an empty string.
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // Test case when string starts with whitespace.
    @Test
    public void testCount3() {
        manipulatedstring.setString(" This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Throws NullPointerException if string is null.
    @Test
    public void testCount4() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.count();
        }, "string cannot be null");
    }

    // Test case when string ends with whitespace.
    @Test
    public void testCount5() {
        manipulatedstring.setString("This is my string ");
        assertEquals(4, manipulatedstring.count());
    }

    // Test case when string contains 2 whitespaces.
    @Test
    public void testCount6() {
        manipulatedstring.setString("This is my  string");
        assertEquals(4, manipulatedstring.count());
    }

    // Test case when string is surrounded by whitespace.
    @Test
    public void testCount7() {
        manipulatedstring.setString(" a ");
        assertEquals(1, manipulatedstring.count());
    }

    // Default test case.
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    // Default test case.
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    // Throw IndexOutOfBoundsException if n is greater than length of a string.
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("abc");
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.removeNthCharacter(10, false);
        }, "n cannot be greater than the length of a string");
    }

    // Throws IllegalArgumentException if n < 0.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("abc");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(0, false);
            }, "n has to be at least 1");
    }

    // Test case for when n is 1, meaning that all the characters in string will be removed without whitespace.
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("abc");
        assertEquals(manipulatedstring.removeNthCharacter(1, false), "");
    }

    // test case for when n is 1 so that all the characters in string will be replaced by whitespace.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("abc");
        assertEquals(manipulatedstring.removeNthCharacter(1, true), "   ");
    }

    // Throws NullPointerException if string is null.
    @Test
    public void testRemoveNthCharacter7() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.removeNthCharacter(1, false);
        }, "string cannot be null");
    }

    // Throws IllegalArgumentException, because startWord is <= 0.
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(0,2);
        }, "startWord has to be an integer greater than 0.");
    }

    // Throws IllegalArgumentException, because endWord <= 0.
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(1, -1);
        }, "endWord has to be an integer greater than 0.");
    }

    // Throws IndexOutOfBoundsException, because endWord is greater than the number of words in string.
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(1, 6);
        }, "String has less than endWord words in it.");
    }

    // Throws IllegalArgumentException, because startWord > endWord.
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(4, 1);
        }, "startWord cannot be greater than endWord.");
    }

    // Throws IndexOutOfBoundsException, because string has less words than endWord.
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(1, 5);
        }, "String does not have enough words");
    }


    // Test case for when startWord > 1.
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // Test for corner case when startWord == endWord.
    @Test
    public void testGeSubStrings7() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 3);

        assertEquals(sStings[0], "my");
    }

    // Default test case.
    @Test
    public void testGeSubStrings8() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);

        assertEquals(sStings[0], "This");
        assertEquals(sStings[1], "is");
        assertEquals(sStings[2], "my");
        assertEquals(sStings[3], "string");
    }

    // Throws IndexOutOfBoundsException, because one of the indices is greater than the length of string.
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,4};
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "Indices cannot be larger than the length of the string-1.");
    }

    // Throws IndexOutOfBoundsException, because one of the indices are negative.
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,-2};
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "Indices cannot be negative.");
    }

    // Throws IllegalArgumentException, because indices.length < string.length().
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "Indice array has to be the same length as string.");
    }

    // Test case when string is null. Throws NullPointerException.
    @Test
    public void testRestoreString7()
    {
        int [] array;
        array = new int[] {1,0,2};
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "String cannot be null");
    }

    // Default test case.
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // Test case when string is separated by whitespace.
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("abc def");
        int [] array;
        array=new int[]{6,5,4,3,0,1,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "fed abc");
    }

    // Corner case when string is an empty string and indices={0}. Throw IllegalArgumentException, because
    // indices.length > string.length().
    @Test
    public void testRestoreString6()
    {
        manipulatedstring.setString("");
        int [] array;
        array=new int[]{0};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "Indices cannot be greater than length of a string");
    }

    // Test for corner case when string contains only one character.
    @Test
    public void testRestoreString8()
    {
        manipulatedstring.setString("a");
        int [] array;
        array=new int[]{0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "a");
    }

    // Test corner case when one of the elements in indices is equal to the length of a string.
    @Test
    public void testRestoreString9()
    {
        manipulatedstring.setString("art");
        int [] array;
        array = new int[] {1,0,3};
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "Indices[i] has to be less than the length of a string.");
    }

    // Test corner case when one of the elements in indices is greater than the length of a string.
    @Test
    public void testRestoreString10()
    {
        manipulatedstring.setString("art");
        int [] array;
        array = new int[] {1,0,10};
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        }, "Indices[i] has to be less than the length of a string.");
    }
}
