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

    // check to see that a null string will return a word count of 0.
    @Test
    public void testCount2() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // tests if numbers or special characters will mess with the word count
    @Test
    public void testCount3() {
        manipulatedstring.setString("This is a string that the number $40.00 in the string");
        int length = manipulatedstring.count();
        assertEquals(11, length);
    }

    // another test, but this time we add quotation marks to see if it messes with
    // word count
    @Test
    public void testCount4() {
        manipulatedstring.setString("This a string that can't fail just because \"can't\" is in the string");
        int length = manipulatedstring.count();
        assertEquals(13, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?",
                manipulatedstring.removeNthCharacter(3, true));
    }

    // like the tests above, but we test it with a different value for n.
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'd 3tt3 puts0med161s inthis5tr16, rght?",
                manipulatedstring.removeNthCharacter(5, false));
    }

    // we test for a smaller n.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("let's try a smaller string");
        assertEquals("ltstyasalrsrn",
                manipulatedstring.removeNthCharacter(2, false));
    }

    // we test for a smaller n while maintaning the spacing in the string
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("let's try a smaller string");
        assertEquals("l t s t y a s a l r s r n ",
                manipulatedstring.removeNthCharacter(2, true));
    }

    // test to make sure it throws a IndexOutOfBoundsException when n > string
    // length
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("This Test should throw IndexOutOfBoundsException for n > string length");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(100, false));
    }

    // test to make sure it throws a IllegalArgumentException when n < 0
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("This Test should throw IllegalArgumentException for n < 0");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-1, false));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String[] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // test to make sure that it can scale to more substrings
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is a very long string that seems to go on and on and on");
        String[] sStings = manipulatedstring.getSubStrings(2, 7);

        assertEquals(sStings[0], "is");
        assertEquals(sStings[1], "a");
        assertEquals(sStings[2], "very");
        assertEquals(sStings[3], "long");
        assertEquals(sStings[4], "string");
        assertEquals(sStings[5], "that");
    }

    // tests thats startWord cannot be <= 0 and should throw a
    // IllegalArgumentException
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This Test should throw IllegalArgumentException for startWord <= 0");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0, 5));
    }

    // tests thats endWord cannot be <= 0 and should throw a
    // IllegalArgumentException
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This Test should throw IllegalArgumentException for endWord <= 0");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0, 0));
    }

    // tests thats startWord < endWord and should throw a IllegalArgumentException
    // if it isn't
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This Test should throw IllegalArgumentException for startWord > endWord");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(5, 1));
    }

    // tests the case where string length is shorter than endWord and throws a
    // IndexOutOfBoundsException if it is
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This Test should throw IndexOutOfBoundsException for endWord > string length");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1, 100));
    }

    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int[] array;
        array = new int[] { 1, 0, 2 };
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // another test like above to check string length doesn't matter
    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("CatDog");
        int[] array;
        array = new int[] { 3, 4, 5, 0, 1, 2 };
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "DogCat");
    }

    // another test like above to check string length doesn't matter, even two of
    // the same characters
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("backwards");
        int[] array;
        array = new int[] { 4, 2, 6, 7, 3, 5, 1, 0, 8 };
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "drawbacks");
    }

    // tests the case where input array contains an invalid string index and throws
    // a IndexOutOfBoundsException
    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("wrote");
        int[] array;
        array = new int[] { -1, 0, 1, 2, 3 };
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
    }

    // tests the case where input array is not the same length as the string and
    // throws a IllegalArgumentException
    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("left");
        int[] array;
        array = new int[] { 0, 1, 2, 3, 4, 5 };
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(array));
    }

}
