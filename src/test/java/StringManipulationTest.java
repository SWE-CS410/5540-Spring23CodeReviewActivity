import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
    // test when no words are present
    public void testCount2() {
        manipulatedstring.setString("n0 w0rds");
        assertEquals(0, manipulatedstring.count());
    }

    @Test
    // test against numbers and symbols
    public void testCount3() {
        manipulatedstring.setString("h@v3 a couple w0rds");
        assertEquals(2,manipulatedstring.count());
    }

    @Test
    // test with >1 whitespace between words
    public void testCount4() {
        manipulatedstring.setString("   a  serie3s of w0rds & non w0rds    ");
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
    // test that IndexOutOfBoundsException is thrown when method with n > length of string
    public void testRemoveNthCharacter3() {
        int n = 14;
        manipulatedstring.setString("sample string");
        Exception e = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(n, true));
        String expected = "n may not be > length of current string";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    // throw IllegalArgumentException when n < 1
    public void testRemoveNthCharacter4() {
        int n = 0;
        manipulatedstring.setString("sample string");
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(n, true));
        String expected = "n cannot be less than/equal to 0";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    // remove only whitespace when maintainSpacing == false
    public void testRemoveNthCharacter5() {
        String s = "this does have only four char word";
        manipulatedstring.setString(s);
        assertEquals("thisdoeshaveonlyfourcharword", manipulatedstring.removeNthCharacter(5, false));
    }

    @Test
    // removal of chars and whitespace
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("this does have only four char word");
        assertEquals("this oes hve ony fou charword", manipulatedstring.removeNthCharacter(6,false));
    }

    @Test
    // remove all characters
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("sample string");
        assertEquals("", manipulatedstring.removeNthCharacter(1,false));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    // feed non-empty string and throw IndexOutOfBoundsException
    public void testGeSubStrings2() {
        manipulatedstring.setString("n0t a- str1ng w w0rds");
        Exception e = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1,4));

        String expected = "String has fewer than " + 4 + " words in it.";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }
    @Test
    // throw IllegalArgumentException when both params are invalid
    public void testGeSubStrings3() {
        manipulatedstring.setString("a bunch of words");
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0,5));

        String expected = "Index of first word cannot be <= 0. Index of last word cannot be > " + manipulatedstring.count() + ".";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }
    @Test
    // throw IllegalArgumentException when startWord > endWord
    public void testGeSubStrings4() {
        manipulatedstring.setString("a bunch of words");
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(4,3));

        String expected = "Index of first word may not be > index of last word.";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }
    @Test
    // set both params equal to same number
    public void testGeSubStrings5() {
        manipulatedstring.setString("a bunch of w0rds go here");
        String [] words = manipulatedstring.getSubStrings(5,5);
        assertEquals("go", words[0]);
    }
    @Test
    // string has multiple whitespaces in sequence, nonwords between words, single letter word
    public void testGeSubStrings6() {
        manipulatedstring.setString("     a    m1x o0ff   w00rds and gibberish");
        String [] words = manipulatedstring.getSubStrings(1,3);

        assertEquals("a", words[0]);
        assertEquals("and", words[1]);
        assertEquals("gibberish", words[2]);
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
    // throw IllegalArgumentException when array size is greater than string length
    public void testRestoreString2()
    {
        manipulatedstring.setString("hmmmmm");
        int arr[] = new int[]{0,1,2,3,4,5,6,7};
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(arr));

        String expected = "indices length (" + arr.length + ") may not exceed string length (" + manipulatedstring.getString().length() + ".";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    // throw IndexOutOfBoundsException when array contains indices not shared by string
    public void testRestoreString3()
    {
        manipulatedstring.setString("a simple string");
        int arr[] = new int[]{-1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Exception e = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(arr));

        String expected = "indices may not contain values that are not common to String[] indices.";
        String actual = e.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    // rearrange longer string
    public void testRestoreString4()
    {
        //                           0         1         2
        //                           012345678901234567890123
        manipulatedstring.setString(" am osst unlikely string");
        int arr[] = new int[]{1,0,5,7,20,12,10,23,18,3,2,4,6,19,8,9,22,11,21,13,14,15,16,17};
        assertEquals("a strings most unlikely ", manipulatedstring.restoreString(arr));
    }
    @Test
    // preserve location of one char
    public void testRestoreString5()
    {
        //                           012345678
        manipulatedstring.setString("nine char");
        int arr[] = new int[]{3,7,8,0,4,1,2,5,6};
        assertEquals("earn inch", manipulatedstring.restoreString(arr));
    }

}
