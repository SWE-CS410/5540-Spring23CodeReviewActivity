import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedString;

    @BeforeEach
    public void setUp() {
        manipulatedString = new StringManipulation();
    }

    @AfterEach
    public void tearDown() {
        manipulatedString = null;
    }

    @Test
    public void testCount1() {
        manipulatedString.setString("This is my string");
        int length = manipulatedString.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount2() {
        manipulatedString.setString("One Two Three");
        int length = manipulatedString.count();
        assertEquals(3, length);
    }

    @Test
    public void testCount3() {
        manipulatedString.setString("");
        int length = manipulatedString.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount4() {
        manipulatedString.setString("SingleWord");
        int length = manipulatedString.count();
        assertEquals(1, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String result = manipulatedString.removeNthCharacter(3, false);
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", result);
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String result = manipulatedString.removeNthCharacter(3, true);
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", result);
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedString.setString("");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedString.removeNthCharacter(5, true);
        });
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedString.setString("12345");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedString.removeNthCharacter(6, false);
        });
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedString.setString("abcdefg");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedString.removeNthCharacter(0, true);
        });
    }
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedString.setString("abcdefg");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedString.removeNthCharacter(-5, true);
        });
    }
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedString.setString("abcdefg");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedString.removeNthCharacter(5000, true);
        });
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedString.setString("This is my string");
        String[] subStrings = manipulatedString.getSubStrings(3, 4);

        assertEquals("my", subStrings[0]);
        assertEquals("string", subStrings[1]);
    }

    @Test
    public void testGetSubStrings2() {
        manipulatedString.setString("This is a test");
        String[] subStrings = manipulatedString.getSubStrings(1, 3);

        assertEquals("This", subStrings[0]);
        assertEquals("is", subStrings[1]);
        assertEquals("a", subStrings[2]);
    }

    @Test
    public void testGetSubStrings3() {
        manipulatedString.setString("Just one word");
        String[] subStrings = manipulatedString.getSubStrings(1, 1);

        assertEquals("Just", subStrings[0]);
    }

    @Test
    public void testGetSubStrings4() {
        manipulatedString.setString("No Words");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedString.getSubStrings(2, 1);
        });
    }

    @Test
    public void testGetSubStrings5() {
        manipulatedString.setString("");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedString.getSubStrings(1, 3);
        });
    }

    @Test
    public void testGetSubStrings6() {
        manipulatedString.setString("Testing multiple words");
        String[] subStrings = manipulatedString.getSubStrings(1, 3);

        assertEquals("Testing", subStrings[0]);
        assertEquals("multiple", subStrings[1]);
        assertEquals("words", subStrings[2]);
    }



    @Test
    public void testRestoreString1() {
        manipulatedString.setString("art");
        int[] indices = new int[]{1, 0, 2};
        String restoredString = manipulatedString.restoreString(indices);
        assertEquals("rat", restoredString);
    }

    @Test
    public void testRestoreString2() {
        manipulatedString.setString("abcde");
        int[] indices = new int[]{4, 3, 2, 1, 0};
        String restoredString = manipulatedString.restoreString(indices);
        assertEquals("edcba", restoredString);
    }

    @Test
    public void testRestoreString3() {
        manipulatedString.setString("Hello");
        int[] indices = new int[]{0, 1, 2, 3, 4};
        String restoredString = manipulatedString.restoreString(indices);
        assertEquals("Hello", restoredString);
    }

    @Test
    public void testRestoreString4() {
        manipulatedString.setString("12345");
        int[] indices = new int[]{0, 4, 2, 1, 3};
        String restoredString = manipulatedString.restoreString(indices);
        assertEquals("14352", restoredString);
    }

    @Test
    public void testRestoreString5() {
        manipulatedString.setString("");
        int[] indices = new int[]{};
        String restoredString = manipulatedString.restoreString(indices);
        assertEquals("", restoredString);
    }

  
}
