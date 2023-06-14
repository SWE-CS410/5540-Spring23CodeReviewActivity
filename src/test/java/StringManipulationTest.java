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
        manipulatedstring.setString("Mystring has total of 6 words!");
        int length2 = manipulatedstring.count();
        assertEquals(6, length2);
    }

    @Test
    public void testCount3() {
        assertFalse(manipulatedstring.toString() == null, "String is null");
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("This is Adrian's assertTrue condition");
        assertTrue(manipulatedstring.count() == 5);
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
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveNthCharacter4() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveNthCharacter5() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveNthCharacter6() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveNthCharacter7() {
        fail("Not yet implemented");
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
        assertFalse(manipulatedstring.toString() == null, "String is null");
    }
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString(" This is a space string");
        String [] sStr = manipulatedstring.getSubStrings(4,5);
        assertEquals(sStr[0], "space");
        assertEquals(sStr[1], "string");
    }
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This");
        String [] sStr = manipulatedstring.getSubStrings(0,1);
        assertFalse(manipulatedstring.toString().length()==1, "String is too small");
    }
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This is a long 3tring with more words!");
        String [] sStr = manipulatedstring.getSubStrings(2, 6);

        assertEquals(sStr[2], "3tring");
        assertTrue(sStr[3] == "with");
    }
    @Test
    public void testGeSubStrings6() {
        fail("Not yet implemented");
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
    public void testRestoreString2()
    {
        manipulatedstring.setString("Tes2t");
        int [] array;
        array=new int[]{0,1,2,4,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "Test2");

    }

    @Test
    public void testRestoreString3()
    {
        assertFalse(manipulatedstring.toString() == "", "String is null");

    }

    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("longword");
        int [] array2;
        array2 = new int[]{0,1,2};
        String restoreString2 = manipulatedstring.restoreString(array2);
        assertEquals(restoreString2,"longword");

    }

    @Test
    public void testRestoreString5()
    {
        assertNotNull(manipulatedstring);

    }

}
