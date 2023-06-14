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

    //This test to check abnormal use of spaces when parsing for words.
    @Test
    public void testCount2() {
        manipulatedstring.setString("       ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //This test to check abnormal use of spaces when parsing for words.
    @Test
    public void testCount3() {
        manipulatedstring.setString("JustOneWord");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    //This test handles a protential null argument.
    @Test
    public void testCount4() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
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

    //This test checks n = 1 case maintains spacing.
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("                                                 ", manipulatedstring.removeNthCharacter(1, true));
    }

    //This test checks n = 1 case removes all spacing.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    //This test check that an Indexoutofbounds exception is thrown appropriately.
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(50, false));
    }

    //This test check that an IllegalArgumentException exception is thrown appropriately.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, false));
    }

    //This test check that an IllegalArgumentException exception is thrown appropriately.
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-1, false));
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStrings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStrings[0], "my");
        assertEquals(sStrings[1], "string");
    }

    //This test handles larger given strings
    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("The Greatest String In The Universe");
        String [] sStrings = manipulatedstring.getSubStrings(3, 6);

        assertEquals(sStrings[0], "String");
        assertEquals(sStrings[1], "In");
        assertEquals(sStrings[2], "The");
        assertEquals(sStrings[3], "Universe");
    }

    //This test handles IllegalArgumentException for improper start and end values
    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(3, 2));
    }

    //This test handles IllegalArgumentException for improper start and end values
    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(2, 0));
    }

    //This test handles IllegalArgumentException for improper start and end values
    @Test
    public void testGetSubStrings5() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0, 3));
    }

    //This test handles IndexOutOfBoundsException for end values
    @Test
    public void testGetSubStrings6() {
        manipulatedstring.setString("This is my string");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(3, 5));
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

    //This test handles empty input values
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("");
        int [] array;
        array=new int[]{};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "");
    }

    //This test handles duplicate values in a given index
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("arty");
        int [] array;
        array=new int[]{1,0,1,2};
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(array));
    }

    //This test handles illegal values in the given index
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("arty");
        int [] array;
        array=new int[]{-1,0,1,2};
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
    }

    //This test handles cases where s.length != indices.length
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2,3};
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(array));
    }

}
