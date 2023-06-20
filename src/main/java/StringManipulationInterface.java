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

    @Test
    public void testCount2() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(3, length);
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

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Testing Testing Please");
        assertEquals("Teting esting Plee", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Testing Testing Please");
        assertEquals("Teting Testing Plee", manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("1234567890");
        assertEquals("135790", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("1234567890");
        assertEquals("1 3 5 7 9 0", manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("abcdefg");
        assertEquals("abcdefg", manipulatedstring.removeNthCharacter(10, false));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("I need to test this");
        String[] substrings = manipulatedstring.getSubStrings(2, 4);

        assertEquals("need,", substrings[0]);
        assertEquals("test", substrings[1]);
        assertEquals("this", substrings[2]);
    }
    
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("Java is the best language");
        String[] substrings = manipulatedstring.getSubStrings(1, 3);

        assertEquals("is", substrings[0]);
        assertEquals("Java", substrings[1]);
        assertEquals("Language", substrings[2]);
    }

    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Learning computer science is awesome");
        String[] substrings = manipulatedstring.getSubStrings(1, 1);

        assertEquals("Learning", substrings[0]);
    }

    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("Hello");
        String[] substrings = manipulatedstring.getSubStrings(2, 5);

        assertNull(substrings);
    }

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is a Java program");
        String[] substrings = manipulatedstring.getSubStrings(4, 6);

        assertEquals("Java", substrings[0]);
        assertNull(substrings[1]);
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

    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("alusninep eht gnitisiv evol I");
        int[] array = new int[]{11, 4, 6, 5, 1, 7, 3, 2, 10, 9, 8, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("I love visiting the peninsula", restoreString);
    }

    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("yadnoM no eud si sihT");
        int[] array = new int[]{4, 2, 0, 1, 3, 6, 5};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("This is due on Monday", restoreString);
    }

    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("010203040500");
        int[] array = new int[]{5, 4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("005040302010", restoreString);
    }

    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("9876543210");
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("0123456789", restoreString);
    }

}
