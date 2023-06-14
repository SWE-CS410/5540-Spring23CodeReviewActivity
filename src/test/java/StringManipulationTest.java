// Celine Chiou
// CS 410 JUnit Testing Assignment

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

    // This tests if the method will count a string of one word
    @Test
    public void testCount2() {
        manipulatedstring.setString("hello");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    // This tests if the method will count a string of words with leading spaces
    @Test
    public void testCount3() {
        manipulatedstring.setString("  should have 4 words");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // This tests if the method will count a string of words with lots of spaces between multiple words
    @Test
    public void testCount4() {
        manipulatedstring.setString("lots        of    spaces");
        int length = manipulatedstring.count();
        assertEquals(3,length);
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

    // This tests if the method will delete excess symbols at 3n and does not replace with spaces
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("My@ n@am@e @is@ C@el@in@e");
        assertEquals("My name is Celine", manipulatedstring.removeNthCharacter(3,false));
    }

    // This tests if the method will return index out of bounds exception where n is greater than the string size and maintaining spacing is true
    @Test
    public void testRemoveNthCharacter4() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("test");
            manipulatedstring.removeNthCharacter(10, true);
        });
    }

    // This tests if the method will return index out of bounds exception where n is greater than the string size and maintaining spacing is false
    @Test
    public void testRemoveNthCharacter5() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("test");
            manipulatedstring.removeNthCharacter(8, false);
        });
    }

    // This tests if the method will return illegal argument exception where n is 0 and maintaining spacing is true
    @Test
    public void testRemoveNthCharacter6() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("test");
            manipulatedstring.removeNthCharacter(0,true);
        });
    }

    // This tests if the method will return illegal argument exception where n is less than 0 and maintaining spacing is true
    @Test
    public void testRemoveNthCharacter7() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("test");
            manipulatedstring.removeNthCharacter(-5,true);
        });
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // This tests if the method will return many words from the middle of a longer sentence
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my test string sentence that should only return a few words");
        String [] sStings = manipulatedstring.getSubStrings(5, 9);
        String[] expected = { "string", "sentence", "that", "should", "only" };
        assertArrayEquals(expected, sStings);
    }

    // This tests if the method will return illegal argument exception where "startWord" > "endWord"
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is my test string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(2, 0);
        });
    }

    // This tests if the method will return illegal argument exception where "endWord" < 0
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is my test string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(1, -3);
        });
    }

    // This tests if the method will return illegal argument exception where "startWord" < 0
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This is my test string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(-1, 3);
        });
    }

    // This tests if the method will return index out of bounds exception where the string has less than "endWord" words in it
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is my test string");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(1, 6);
        });
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

    // This tests if the method will return illegal argument exception where lengths do not match (s.length == indices.length == n)
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("UnitTest");
        int[] indices = { 4, 5, 6, 7, 0, 2, 1 };
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(indices);
        });
    }

    // This tests if the method will return index out of bounds exception where indices[i]= string length
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("UnitTest");
        int[] indices = { 4, 5, 6, 7, 0, 2, 1, 8 };
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);
        });
    }

    // This tests if the method will return index out of bounds exception where indices[i]> string length
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("UnitTest");
        int[] indices = { 4, 5, 6, 7, 0, 2, 1, 9 };
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);
        });
    }

    // This tests if the method will return index out of bounds exception where indices[i]< 0
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("UnitTest");
        int[] indices = { 4, 5, 6, 7, 0, 2, 1, -1 };
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);
        });
    }
}