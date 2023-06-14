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
        manipulatedstring.setString("  ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("Im Anh");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("  Anh Duc Nguyen La ");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    public void testCount5() {
        manipulatedstring.setString("      YayaOhashi     ");
        int length = manipulatedstring.count();
        assertEquals(1, length);
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
        manipulatedstring.setString("Seattle");
        assertEquals("Se tt e", manipulatedstring.removeNthCharacter(3, true));
    }
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("United States Of America");
        assertEquals("Unitd Sttes f Amrica", manipulatedstring.removeNthCharacter(5, false));
    }

    @Test
    public void testRemoveNthCharacter5() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("CS");
            manipulatedstring.removeNthCharacter(5, true);
        });
    }
    @Test
    public void testRemoveNthCharacter6() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString(" ");
            manipulatedstring.removeNthCharacter(0, true);
        });
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
        manipulatedstring.setString("A B C D E F G");
        String[] sStings = manipulatedstring.getSubStrings(2, 5);
        assertEquals(sStings[0], "B");
        assertEquals(sStings[1], "C");
        assertEquals(sStings[2], "D");
        assertEquals(sStings[3], "E");
    }
    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("BEllevueCollege");
        String[] subStrings = manipulatedstring.getSubStrings(1, 1);
        assertEquals(subStrings[0],"BEllevueCollege");
    }
    @Test
    public void testGetSubStrings4() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("Because of that reason .");
            String[] subStrings = manipulatedstring.getSubStrings(4, 7);

            assertEquals("reason", subStrings[0]);
            assertEquals(".", subStrings[1]);
        });
    }
    @Test
    public void testGetSubString5() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("CS410CS401");
            String[] subStrings = manipulatedstring.getSubStrings(0, 0);
        });
    }
//
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
        manipulatedstring.setString("");
        int[] indices = {};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("", restoredString);
    }
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("SummerTime");
        int[] indices = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("SummerTime", restoredString);
    }


    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("aL hnA");
        int[] indices = {5, 4, 3, 2, 1, 0};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("Anh La", restoredString);
    }

    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("Monday");
        int[] indices = {0, 2, 1, 5, 4, 3};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("Mnoyad", restoredString);
    }

}
