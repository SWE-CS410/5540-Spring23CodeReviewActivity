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

    //basic test of length
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    //nothing stored
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //only numbers
    @Test
    public void testCount3() {
        manipulatedstring.setString("56 78 9");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    //large amounts of spaces
    @Test
    public void testCount4() {
        manipulatedstring.setString("this   and   that    ");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    //test of false bool
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    //test of true bool
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    //test of making the string empty
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("n");
        int length = manipulatedstring.count();
        assertEquals(1, length);

        manipulatedstring.setString(manipulatedstring.removeNthCharacter(1, false));
        length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //test of removal making more words
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("anger");
        int length = manipulatedstring.count();
        assertEquals(1, length);

        manipulatedstring.setString(manipulatedstring.removeNthCharacter(3, true));
        length = manipulatedstring.count();
        assertEquals(2, length);
    }

    //removal of space, merging two words
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("an er");
        int length = manipulatedstring.count();
        assertEquals(2, length);

        manipulatedstring.setString(manipulatedstring.removeNthCharacter(3, false));
        length = manipulatedstring.count();
        assertEquals(1, length);
    }

    //IndexOB test
    @Test
    public void testRemoveNthCharacter6() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("anger");
            manipulatedstring.removeNthCharacter(6, false);
        });   
    }

    //IllegalArg test 
    @Test
    public void testRemoveNthCharacter7() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("anger");
            manipulatedstring.removeNthCharacter(0, false);
        });
        
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    //test for single string selection
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("Success");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "Success");
    }

    //test for many strings
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is my string and I hope that if I make it a lot longer everything will work out");
        String [] sStings = manipulatedstring.getSubStrings(3, 10);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
        assertEquals(sStings[2], "and");
        assertEquals(sStings[3], "I");
        assertEquals(sStings[4], "hope");
        assertEquals(sStings[5], "that");
        assertEquals(sStings[6], "if");
        assertEquals(sStings[7], "I");
    }

    //test for punctuation
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Success!");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "Success!");
    }
    
    //IndexOB test
    @Test
    public void testGeSubStrings5() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("bad test!");
            String [] sStings = manipulatedstring.getSubStrings(2, 5);
        });
    }

    //IllegalArg test
    @Test
    public void testGeSubStrings6() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("bad test!");
            String [] sStings = manipulatedstring.getSubStrings(0, 0);
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

    //maintains capitalization test
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("Art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rAt");

    }

    //maintains spaces test
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("r u");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, " ru");

    }

    //IllegalArg test
    @Test
    public void testRestoreString4()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("r u");
            int [] array;
            array=new int[]{1,0,2,2,1,0};
            String restoreString = manipulatedstring.restoreString(array);
        });
    }

    //IndexOB test
    @Test
    public void testRestoreString5()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("r u");
            int [] array;
            array=new int[]{1,0,6};
            String restoreString = manipulatedstring.restoreString(array);
        });

    }

}
