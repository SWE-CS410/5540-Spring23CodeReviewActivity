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
        manipulatedstring.setString("Work test string");
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
    	manipulatedstring.setString("Testing");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount4() {
    	manipulatedstring.setString("Method is tested for longer text now");
        int length = manipulatedstring.count();
        assertEquals(7, length);
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
    	manipulatedstring.setString("Removing every multiple of four's position");
        assertEquals("Remvin evry ultpleof ours psiton", manipulatedstring.removeNthCharacter(4, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
    	manipulatedstring.setString("Removing every multiple of four's position");
        assertEquals("Rem vin ev ry  ult ple of  our s p sit on", manipulatedstring.removeNthCharacter(4, true));
    }

    @Test
    public void testRemoveNthCharacter5() {
    	manipulatedstring.setString("a simpler phrase for a simple test");
        assertEquals("a simpler phrase for a simple tes ", manipulatedstring.removeNthCharacter(34, true));
    }

    @Test
    public void testRemoveNthCharacter6() {
    	manipulatedstring.setString("a simpler phrase for a simple test");
        assertEquals("a simpler phrase for a simple tes", manipulatedstring.removeNthCharacter(34, false));
    }

    @Test
    public void testRemoveNthCharacter7() {
    	manipulatedstring.setString("Arkansas is a big state perhaps");
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
    public void testGeSubStrings2() {
    	manipulatedstring.setString("A blanket statement has been made");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);

        assertEquals(sStings[0], "A");
        assertEquals(sStings[1], "has");
    }
    @Test
    public void testGeSubStrings3() {
    	manipulatedstring.setString("there are a few words here");
        String [] sStings = manipulatedstring.getSubStrings(1, 2);

        assertEquals(sStings[0], "there");
        assertEquals(sStings[1], "are");
    }
    @Test
    public void testGeSubStrings4() {
    	manipulatedstring.setString("batmanium is no real element");
        String [] sStings = manipulatedstring.getSubStrings(3, 5);

        assertEquals(sStings[0], "no");
        assertEquals(sStings[1], "element");
    }
    @Test
    public void testGeSubStrings5() {
    	manipulatedstring.setString("no one should smoke, as smoking is bad");
        String [] sStings = manipulatedstring.getSubStrings(1, 6);

        assertEquals(sStings[0], "no");
        assertEquals(sStings[1], "smoking");
    }
    @Test
    public void testGeSubStrings6() {
    	manipulatedstring.setString("Extract the main idea from this sentence");
        String [] sStings = manipulatedstring.getSubStrings(1, 7);

        assertEquals(sStings[0], "Extract");
        assertEquals(sStings[1], "sentence");
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
    	manipulatedstring.setString("Neil Armstrong");
        int [] array;
        array=new int[]{13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "gnortsmrA lieN");
    }

    @Test
    public void testRestoreString3()
    {
    	manipulatedstring.setString("desperation");
        int [] array;
        array=new int[]{6,5,9,3,1,4,10,0,2,8,7};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "aropeendsit");
    }

    @Test
    public void testRestoreString4()
    {
    	manipulatedstring.setString("contradiction");
        int [] array;
        array=new int[]{5,0,8,1,4,6,2,11,9,10,12,7,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "accordnotinit");
    }

    @Test
    public void testRestoreString5()
    {
    	manipulatedstring.setString("easy");
        int [] array;
        array=new int[]{3,0,1,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "yeas");
    }

}
