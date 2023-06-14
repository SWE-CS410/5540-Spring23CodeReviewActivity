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
    //This tests spaces AFTER ONLY and many spaces.
    @Test
    public void testCount2() {
        manipulatedstring.setString("T             ");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }
    //This tests count with many space before after and inbetween.
    @Test
    public void testCount3() {
        manipulatedstring.setString("      This  is  my         string      ");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }
    //This tests count with no string.
    @Test
    public void testCount4() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }
    //This tests count with spaces before ONLY.
    @Test
    public void testCount5() {
        manipulatedstring.setString("      This");
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

    //This tests n at 5 with an number of characters not evenly divisible by 5.
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("abcdefghijklmnopqrstuvwxyz");
        assertEquals("abcd fghi klmn pqrs uvwx z", manipulatedstring.removeNthCharacter(5, true));
    }

    //This tests the illegalArgument exception when n is inputted as a negative number.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("abcdefghijklmnopqrstuvwxyz");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(-5, true);
        });
    }

    //This tests the IndexOfOutBoundsExceptions when the Nth number is larger than characters in string
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("abcdef");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.removeNthCharacter(9, true);
        });
    }
    //This tests edge case when there are only spaces inputted into string with NO space inputted.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("  ");
        assertEquals(" ", manipulatedstring.removeNthCharacter(2, false));
    }
    //This tests edge case when there are only spaces inputted into string with YES space inputted.
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("  ");
        assertEquals("  ", manipulatedstring.removeNthCharacter(2, true));
    }

    //This method was given in the skeleton provided.
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
    //This method tests spaces before the string and after the string. And tests the first two words.
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString(" This is my string ");
        String [] sStings = manipulatedstring.getSubStrings(1, 2);

        assertEquals(sStings[0], "This");
        assertEquals(sStings[1], "is");
    }
    //This tests multiple spaces before and after and between.
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("     This     is    my    string     ");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);

        assertEquals(sStings[0], "This");
        assertEquals(sStings[1], "is");
        assertEquals(sStings[2], "my");
        assertEquals(sStings[3], "string");
    }
    //This tests the IllegalArgumentException when the startWord is greater than the endWord.
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("     This is my string     ");
        String [] sStings = manipulatedstring.getSubStrings(1, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(2,1);
        });
    }
    //This tests the IndexOutOfBoundsException class when the endWord is greater than the amount of words in the string.
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("     This is my string     ");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(2,5);
        });

    }
    //This tests single word containing multiple spaces.
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("      I  A C  ");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "I");
    }

    //This tests with the skeleton provided. Basic mixing of letters based on array.
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    //This tests IllegalArgumentException when there are 7 items in array and 8 letters in the string.
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2};
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

    //This tests IllegalArgumentException there are 9 numbers in the array and 8 letters in the string.
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2,3,8};
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }
    //This tests IndexOfOutBounds exception [THERE IS -1 in array] when the array contains a number less than 0 in the array.
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,-1,2,0,6,7,3};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

    //This tests IndexOfOutBounds exception [THERE IS 10 in array] when the array contains a number larger than message length!
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,10,2,0,6,7,3};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

}