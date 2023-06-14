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
    //checks regular working test count
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    //tests trailing spaces
    public void testCount2() {
        manipulatedstring.setString("Hey there bud, I love ice cream!  ");
        int length = manipulatedstring.count();
        assertEquals(7, length);
    }

    @Test
    //tests empty value
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //tests large trailing space within words
    public void testCount4() {
        manipulatedstring.setString("wow!...              wow!");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    @Test
    //tests with removing every 3rd character without maintaining spacing
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    //tests with removing every 3rd character WITH maintaining spacing
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    //tests a different value for Nth character removed argument
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("I love chihuahuas!!!");
        assertEquals("Ilv hhaus!", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    //tests empty value
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("");
        assertEquals("", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    //tests removing 1 value
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("a");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    @Test
    //tests removing an Nth character that is never reached (stays the same)
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("The new Spiderverse was soooo good!");
        assertEquals("The new Spiderverse was soooo good!", manipulatedstring.removeNthCharacter(50, false));
    }

    @Test
    //tests with removing EVERY character while maintaining spacing, effectively replacing every char with " "
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("aaa");
        assertEquals("   ", manipulatedstring.removeNthCharacter(1, true));
    }

    @Test
    //tests regular substring get
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    //another substring get with different parameters and string value
    public void testGeSubStrings2() {
        manipulatedstring.setString("With great responsibility comes great power.");
        String [] sStings = manipulatedstring.getSubStrings(1, 3);

        assertEquals(sStings[1], "great");
        assertEquals(sStings[2], "responsibility");
    }
    @Test
    //tests substring get with a large string value
    public void testGeSubStrings3() {
        manipulatedstring.setString("Rap snitches, telling all their business, sit in the court, and be their own star witness");
        String [] sStings = manipulatedstring.getSubStrings(7, 16);

        assertEquals(sStings[0], "sit");
        assertEquals(sStings[6], "their");
        assertEquals(sStings[9], "witness");
    }
    @Test
    //tests substring get with an empty string value
    public void testGeSubStrings4() {
        manipulatedstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> { manipulatedstring.getSubStrings(5, 2); });
    }
    @Test
    //tests substring get with trailing spaces
    public void testGeSubStrings5() {
        manipulatedstring.setString("    a    ");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "a");
    }
    @Test
    //tests substring get with multiple trailing spaces between words
    public void testGeSubStrings6() {
        manipulatedstring.setString("    a    b     c     d          .e");
        String [] sStings = manipulatedstring.getSubStrings(3, 5);

        assertEquals(sStings[0], "c");
        assertEquals(sStings[2], ".e");
    }

    @Test
    //tests restore string expecting success
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    //tests restore string again with a different string input
    public void testRestoreString2()
    {
        manipulatedstring.setString("dormitory");
        int [] array;
        array=new int[]{0,4,2,5,8,7,6,1,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "dirtyroom");
    }

    @Test
    //tests swapping only one pair
    public void testRestoreString3()
    {
        manipulatedstring.setString("angel");
        int [] array;
        array=new int[]{0,1,2,4,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "angle");
    }

    @Test
    //tests out of right max bound
    public void testRestoreString4()
    {
        manipulatedstring.setString("bob");
        int [] array;
        array=new int[]{0,2,10};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> { manipulatedstring.restoreString(array); });
    }

    @Test
    //tests out of min left bound
    public void testRestoreString5()
    {
        manipulatedstring.setString("cat");
        int [] array;
        array=new int[]{2,1,-3};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> { manipulatedstring.restoreString(array); });
    }

}
