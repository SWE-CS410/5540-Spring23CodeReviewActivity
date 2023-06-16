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

    // empty string
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        assertEquals(0, manipulatedstring.count());
    }

    // only whitespace separates words
    @Test
    public void testCount3() {
        manipulatedstring.setString("This-is-another-string");
        assertEquals(1, manipulatedstring.count());
    }

    // test whitespace characters besides space
    @Test
    public void testCount4() {
        manipulatedstring.setString("a b\nc\td\re");
        assertEquals(5, manipulatedstring.count());
    }

    // test leading and trailing whitespace
    @Test
    public void testCount5() {
        manipulatedstring.setString(" a b c ");
        assertEquals(3, manipulatedstring.count());
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

    // test if proper exception is thrown for n > string length
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("0123");
        int n = manipulatedstring.getString().length() + 1;

        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class,
                manipulatedstring.removeNthCharacter(n, true));
        IndexOutOfBoundsException thrown2 = assertThrows(IndexOutOfBoundsException.class,
                manipulatedstring.removeNthCharacter(n + 1, false));
    }

    // tests for IllegalArgumentException if n is 0 or less
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("I'm a little teapot");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                manipulatedstring.removeNthCharacter(0, true));
        IllegalArgumentException thrown2 = assertThrows(IllegalArgumentException.class,
                manipulatedstring.removeNthCharacter(0, false));

        IllegalArgumentException thrown3 = assertThrows(IllegalArgumentException.class,
                manipulatedstring.removeNthCharacter(-10, true));
        IllegalArgumentException thrown4 = assertThrows(IllegalArgumentException.class,
                manipulatedstring.removeNthCharacter(-10, false));
    }

    // edge case: n = 1, don't maintain spacing
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("0123");
        assertEquals(manipulatedstring.removeNthCharacter(1, false), "");
    }

    // edge case: n = 1, maintain spacing
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("0123");
        assertEquals(manipulatedstring.removeNthCharacter(1, true), "    "); // four spaces
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("foo bar baz");

        String strTrue = manipulatedstring.removeNthCharacter(2, true);
        String strFalse = manipulatedstring.removeNthCharacter(2, false);
        assertNotEquals(strTrue, strFalse);
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // invalid argument exception tests
    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("one two three");

        int pos = 1; // any positive number
        assertTrue(pos > 0);

        // startWord <= 0
        assertThrows(manipulatedstring.getSubStrings(0, pos));
        assertThrows(manipulatedstring.getSubStrings(-pos, pos));

        // endWord <= 0
        assertThrows(manipulatedstring.getSubStrings(pos, 0));
        assertThrows(manipulatedstring.getSubStrings(pos, -pos));

        // startWord > endWord
        assertThrows(manipulatedstring.getSubStrings(pos + 1, pos));
    }

    // test for exception if the string has more than endWords chars in it
    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("one two three");
        IndexOutOfBoundsException thrown = assertThrows(manipulatedstring.getSubStrings(1, 4));
    }

    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("The quick brown fox jumped");
        String[] subStrings = getSubStrings(1, 5);
        assertEquals(5, subStrings.length);
        assertEquals(manipulatedstring.count(), subStrings.length);

        manipulatedstring.setString("Peter picked peppers");
        subStrings = getSubStrings(1, 3);
        assertEquals(3, subStrings.length);

        manipulatedstring.setString("The quick brown fox jumped over the lazy dog. Lorem Ipsum dolor sit amet. Ceteris paribus.");
        int strlen = manipulatedstring.count();
        subStrings = getSubStrings(1, strlen);
        assertEquals(strlen, subStrings.length);
    }

    @Test
    public void testGetSubStrings5() {
        manipulatedstring.setString("The quick brown fox jumped");

        String[] subStrings = getSubStrings(3, 5);
        assertEquals(3, subStrings.length);

        subStrings = getSubStrings(2, 4);
        assertEquals(3, subStrings.length);

        subStrings = getSubStrings(2, 3);
        assertEquals(2, subStrings.length);

        subStrings = getSubStrings(3, 3);
        assertEquals(1, subStrings.length);

        subStrings = getSubStrings(1, 1);
        assertEquals("The", subStrings[0]);
        assertEquals(1, subStrings.length);
    }

    @Test
    public void testGetSubStrings6() {
        manipulatedstring.setString("one two three four");

        String[] subStrings1 = getSubStrings(2, 3);
        assertEquals(2, subStrings1.length);

        manipulatedstring.setString("two three four five");

        String[] subStrings2 = getSubStrings(1, 2);
        assertEquals(2, subStrings2.length);

        assertEquals(subStrings1, subStrings2);
    }

    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // tests for illegal argument exception upon a string with non-letters in it
    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("+- @!");
        int[] indices = new int[]{0, 1, 2, 3, 4};
        IllegalArgumentException thrown = assertThrows(manipulatedstring.restoreString(indices));
    }

    // tests for bad index values exception
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("abcd");
        int[] indices = new int[]{-1, 1, 2, 3};
        IndexOutOfBoundsException thrown = assertThrows(manipulatedstring.restoreString(indices));

        indices = new int[]{40, 0, 1, 2};
        IndexOutOfBoundsException thrown1 = assertThrows(manipulatedstring.restoreString(indices));
    }

    // tests for exception when indices isn't a proper permutation of 0 ... n-1
    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("catdog");

        // case where values in indices aren't from 0 ... n-1
        int[] indices = new int[]{0, 1, 2, 3, 10, -1};
        IllegalArgumentException thrown = assertThrows(manipulatedstring.restoreString(indices));

        // case where values in indices aren't unique
        indices = new int[]{0, 1, 2, 3, 3, 3};
        IllegalArgumentException thrown1 = assertThrows(manipulatedstring.restoreString(indices));
    }

    // tests for exception when string and indices array have different lengths
    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("abc");

        // array shorter than string
        int[] indices = new int[]{0, 1};
        IllegalArgumentException thrown = assertThrows(manipulatedstring.restoreString(indices));

        // array longer than string
        indices = new int[]{0, 1, 2, 3, 4};
        IllegalArgumentException thrown1 = assertThrows(manipulatedstring.restoreString(indices));
    }
}
