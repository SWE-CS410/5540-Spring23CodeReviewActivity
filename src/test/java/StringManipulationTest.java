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

    // Test that unset strings throw NullPointerException.
    @Test
    public void testCount2() {
        assertThrows(NullPointerException.class, () -> {manipulatedstring.count();});
    }

    // Test that empty strings have a word count of 0.
    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // Test that a string of 1 single word but a trailing space has a word count of 1.
    @Test
    public void testCount4() {
        manipulatedstring.setString("superfragilisticalidocious ");
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

    // Test that removal counts greater than the length of the string throw IndexOutOfBoundsException.
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("only");
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.removeNthCharacter(5, false);});
    }

    // Test that removal counts smaller than 1 throw IllegalArgumentException.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Haha");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.removeNthCharacter(0, false);});
    }

    // Test that removal removes all characters, including whitespace characters.
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("    \n\t");
        assertEquals("   \n", manipulatedstring.removeNthCharacter(3, false));
    }

    // Test that removal counts of 0 on strings with lengths of 0 still throw IllegalArgumentException.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.removeNthCharacter(0, false);});
    }

    // Test that removal on unset strings throw NullPointerException.
    @Test
    public void testRemoveNthCharacter7() {
        assertThrows(NullPointerException.class, () -> {manipulatedstring.removeNthCharacter(2, false);});
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // Test that endWord indexes greater than the length of the string throw IndexOutOfBoundsException.
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("You");
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.getSubStrings(1, 5);});
    }

    // Test that startWord indexes less than 1 throw IllegalArgumentException.
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("You");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(0, 3);});
    }

    // Test that endWord indexes less than 1 throw IllegalArgumentException.
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("You");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(-3, -1);});
    }

    // Test that endWord indexes less than the startWord indexes throw IllegalArgumentException.
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("You");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(2, 1);});
    }

    // Test that substring grabs on unset strings throw NullPointerException.
    @Test
    public void testGeSubStrings6() {
        assertThrows(NullPointerException.class, () -> {manipulatedstring.getSubStrings(1, 5);});
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

    // Test that restore arrays less than the length of the string throw IllegalArgumentException.
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("That");
        int[] array = {1, 0, 2};
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.restoreString(array);});
    }

    // Test that restore arrays with indexes less than 0 throw IndexOutOfBoundsException.
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("That");
        int[] array = {1, 0, 2, -1};
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.restoreString(array);});
    }

    // Test that arrays with indexes greater than or equal to the length of the string throw IndexOutOfBoundsException.
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("That");
        int[] array = {1, 0, 2, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.restoreString(array);});
    }

    // Test that restoration on unset strings throw NullPointerException.
    @Test
    public void testRestoreString5()
    {
        int[] array = {1, 0, 2, 3};
        assertThrows(NullPointerException.class, () -> {manipulatedstring.restoreString(array);});
    }

}
