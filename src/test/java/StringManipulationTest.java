import jdk.jfr.StackTrace;
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
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount3() {
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("Spaces   between  words ");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    public void testCount5() {
        manipulatedstring.setString(" ABCDEFD ");
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
        //null
        assertThrows(NullPointerException.class,() ->{ 
        manipulatedstring.removeNthCharacter(3, true);    
        });
    }


    @Test
    public void testRemoveNthCharacter4(){
        assertThrows(IllegalArgumentException.class, () -> {  
        manipulatedstring.setString("BUBU");
        manipulatedstring.removeNthCharacter(-3, true);
        });
    }

    @Test
    public void testRemoveNthCharacter5(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("love");
            manipulatedstring.removeNthCharacter(7, true);
        });
    }

    @Test
    public void testRemoveNthCharacter6(){
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString(" "); 
            manipulatedstring.removeNthCharacter(0, true);
        });
    }

    @Test
    public void testRemoveNthCharacter7(){
        manipulatedstring.setString(""); //empty
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }


    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGetSubStrings2() {
        assertThrows(IllegalArgumentException.class, () -> {
        manipulatedstring.setString("OnlyOneWord");
        String[] subStrings = manipulatedstring.getSubStrings(1, -1);
        });
    }

    @Test
    public void testGetSubStrings3() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("One Two Three Four Five");
            String[] subStrings = manipulatedstring.getSubStrings(4, 6);

            assertEquals("Four", subStrings[0]);
            assertEquals("Five", subStrings[1]);
        });
    }

    @Test
    public void testGetSubStrings4() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("One Two Three Four Five");
            String[] subStrings = manipulatedstring.getSubStrings(50,1);
        });
    }

    @Test
    public void testGetSubString5() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("Programming");
            String[] subStrings = manipulatedstring.getSubStrings(0, 0);
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

    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("testing");
        int[] indices = {};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("", restoredString);
    }

    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("");
        int[] indices = {};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("", restoredString);
    }

   @Test
    public void testRestoreString4() {
        manipulatedstring.setString("hello");
        int[] indices = {4, 3, 2, 1, -1};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("", restoredString);
    }

    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("world");
        int[] indices = {0, 2, 1, 3, 5};
        String restoredString = manipulatedstring.restoreString(indices);
        assertEquals("", restoredString);
    }

}
