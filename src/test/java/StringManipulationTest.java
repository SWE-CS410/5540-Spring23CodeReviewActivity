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
        manipulatedString.setString("I like video games");
        int length = manipulatedString.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount3() {
        manipulatedString.setString("What");
        int length = manipulatedString.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount4() {
        manipulatedString.setString("Why there are so many test cases to create");
        int length = manipulatedString.count();
        assertEquals(9, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedString.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedString.removeNthCharacter(3, true));
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedString.setString("Holy mama");
        assertEquals("Hl aa", manipulatedString.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedString.setString("Holy mama");
        assertEquals("H l   a a", manipulatedString.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedString.setString("Holy mama");
        assertEquals("Hol  ma a", manipulatedString.removeNthCharacter(4, true));
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedString.setString("Exception testing1");
        assertEquals("Don't mind this", manipulatedString.removeNthCharacter(0, true));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedString.setString("Exception testing2");
        assertEquals("Don't mind this", manipulatedString.removeNthCharacter(19, true));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedString.setString("This is my string");
        String [] sStings = manipulatedString.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedString.setString("This is my string");
        String [] sStings = manipulatedString.getSubStrings(1, 2);

        assertEquals(sStings[0], "This");
        assertEquals(sStings[1], "is");
    }
    @Test
    public void testGeSubStrings3() {
        manipulatedString.setString("Why there are so many test cases to create");
        String [] sStings = manipulatedString.getSubStrings(1, 2);

        assertEquals(sStings[0], "Why");
        assertEquals(sStings[1], "there");
    }
    @Test
    public void testGeSubStrings4() {
        manipulatedString.setString("Why there are so many test cases to create");
        String [] sStings = manipulatedString.getSubStrings(1, 3);

        assertEquals(sStings[0], "Why");
        assertEquals(sStings[1], "there");
        assertEquals(sStings[2], "are");
    }
    @Test
    public void testGeSubStrings5() {
        manipulatedString.setString("Why there are so many test cases to create");
        String [] sStings = manipulatedString.getSubStrings(0, 6);

        assertEquals(sStings[0], "many");
        assertEquals(sStings[1], "test");
        // Exception1
    }
    @Test
    public void testGeSubStrings6() {
        manipulatedString.setString("Why there are so many test cases to create");
        String [] sStings = manipulatedString.getSubStrings(5, 11);

        assertEquals(sStings[0], "many");
        assertEquals(sStings[1], "test");
        assertEquals(sStings[2], "cases");
        // Exception2
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedString.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedString.restoreString(array);
        assertEquals("rat", restoreString);
    }

    @Test
    public void testRestoreString2()
    {
        manipulatedString.setString("art");
        int [] array;
        array=new int[]{2,0,1};
        String restoreString = manipulatedString.restoreString(array);
        assertEquals("tar", restoreString);
    }

    @Test
    public void testRestoreString3()
    {
        manipulatedString.setString("art");
        int [] array;
        array=new int[]{2,1,0};
        String restoreString = manipulatedString.restoreString(array);
        assertEquals("tra", restoreString);

    }

    @Test
    public void testRestoreString4()
    {
        manipulatedString.setString("art");
        int [] array;
        array=new int[]{1,0,2,3};
        String restoreString = manipulatedString.restoreString(array);
        assertEquals("Exception1", restoreString);

    }

    @Test
    public void testRestoreString5()
    {
        manipulatedString.setString("art");
        int [] array;
        array=new int[]{1,5,2};
        String restoreString = manipulatedString.restoreString(array);
        assertEquals("Exception2", restoreString);

    }

}
