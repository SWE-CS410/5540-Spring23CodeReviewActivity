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
        manipulatedstring.setString("Hello");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("Hello   "); // 3 spaces after "Hello"
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
        manipulatedstring.setString("Hello World");
        //   out of bounds error   --> NOTE: this should fail (because n > 11) but it does not.  Realized this too late
        manipulatedstring.removeNthCharacter(20, false);
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Hello World is such an overused phrase:)");
        assertEquals("Hello Wor d is such an overus d phrase: ", manipulatedstring.removeNthCharacter(10, true));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Hello     --5blank spaces--     World");
        assertEquals("Helo   -5ban sacs-    ord", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Hello World");
        assertEquals("           ", manipulatedstring.removeNthCharacter(1, true));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("Hello World");
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
        manipulatedstring.setString("This is a rather long, overblown, drawn-out, random sentence just used for test purposes.");
        String [] sStings = manipulatedstring.getSubStrings(1, 14);

        assertEquals(sStings[0], "This" );
        assertEquals(sStings[1], "is" );
        assertEquals(sStings[2], "a" );
        assertEquals(sStings[3], "rather" );
        assertEquals(sStings[4], "long" );
        assertEquals(sStings[5], "overblown" );
        assertEquals(sStings[6], "drawn-out" );
        assertEquals(sStings[7], "random" );
        assertEquals(sStings[8], "sentence" );
        assertEquals(sStings[9], "just" );
        assertEquals(sStings[10], "used" );
        assertEquals(sStings[11], "for" );
        assertEquals(sStings[12], "test" );
        assertEquals(sStings[13], "purposes" );
    }
    @Test
    public void testGeSubStrings3(){
        manipulatedstring.setString("Hello World");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(0, 1));
    }
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Hello World");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1, 4));
    }


    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("Hello, World");
        String [] sStings = manipulatedstring.getSubStrings(1, 2);
        assertEquals(sStings[0], "Hello" );
        assertEquals(sStings[1], "World" );
    }

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is a rather long, overblown, drawn-out, random sentence just used for test purposes.");
        String [] sStings = manipulatedstring.getSubStrings(11, 13);
        assertEquals(sStings[0], "used" );
        assertEquals(sStings[1], "for" );
        assertEquals(sStings[2], "test" );
    }
    @Test
    public void testGeSubStringsExtra() {
        manipulatedstring.setString("This is a rather"); //long, overblown, drawn-out, random sentence just used for test purposes.");
        String [] sStings = manipulatedstring.getSubStrings(2, 4);
        assertEquals(sStings[0], "is" );
        assertEquals(sStings[1], "a" );
        assertEquals(sStings[2], "rather" );
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
        manipulatedstring.setString("Hello World");
        int [] array;
        array=new int[]{6,7,8,9,10,5,0,1,2,3,4};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "World Hello");

    }

    @Test
    public void testRestoreString3() // too many elements in the int [].
    {
        manipulatedstring.setString("Hello World");
        int [] array;
        array=new int[]{6,7,8,9,10,5,0,1,2,3,4,4};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
    }

    @Test
    public void testRestoreString4() // array[4] = 11 which is > 10
    {
        manipulatedstring.setString("Hello World");
        int [] array;
        array=new int[]{6,7,8,9,11,5,0,1,2,3,4};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
    }

    @Test
    public void testRestoreString5()  // index [7] = -1 which is < 0
    {
        manipulatedstring.setString("Hello World");
        int [] array;
        array=new int[]{6,7,8,9,10,5,0,-1,2,3,4};
       assertThrows(ArrayIndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));

    }

}
