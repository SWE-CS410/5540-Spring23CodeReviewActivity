/*
    Jon Kaimmer
    CS410 Software Engineering
    Spring 2023
    Junit Testing Assignment

    Spring Manipulation Test
 */

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
    public void testCount1_NormalString() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount2_EmptyString() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount3_Null() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount4_TabSeperatedWords() {
        manipulatedstring.setString("This   is    my    string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testRemoveNthCharacter1_DontMaintainSpacing() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2_DoMaintainSpacing() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    public void testRemoveNthCharacter3_EmptyString_IndexOutOfBoundsException() {
        manipulatedstring.setString("");

        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    manipulatedstring.removeNthCharacter(1, false);
                });
    }

    @Test
    public void testRemoveNthCharacter4_NullString_ThrowNullPointerException() {
        manipulatedstring.setString(null);

        assertThrows(NullPointerException.class,
                ()-> {
                    manipulatedstring.removeNthCharacter(1, false);
                });
    }

    @Test
    public void testRemoveNthCharacter5_nEqualsZero_ThrowIllegalArgument() {
        manipulatedstring.setString("I am a String!");

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    manipulatedstring.removeNthCharacter(0, false);
                });
    }

    @Test
    public void testRemoveNthCharacter6_nLargerThanString_ThrowIndexOutOfBounds() {
        manipulatedstring.setString("I am a String!");

        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    manipulatedstring.removeNthCharacter(15, false);
                });
    }

    @Test
    public void testGetSubStrings1_TestWords() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGetSubStrings2_ThrowIllegalArgumentException_startWordLessThanZero() {
        manipulatedstring.setString("I am a String!");

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    String [] sStings = manipulatedstring.getSubStrings(-1, 4);
                });
    }
    @Test
    public void testGetSubStrings3_ThrowIllegalArgumentException_endWordLessThanZero() {
        manipulatedstring.setString("I am a String!");

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    String [] sStings = manipulatedstring.getSubStrings(1, -1);
                });
    }
    @Test
    public void testGetSubStrings4_ThrowIllegalArgumentException_endWordLessThanstartWord() {
        manipulatedstring.setString("I am a String!");

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    String [] sStings = manipulatedstring.getSubStrings(2, 1);
                });
    }
    @Test
    public void testGetSubStrings5_ThrowIndexOutOfBoundsException_endWordGreaterThanNumberOfWords() {
        manipulatedstring.setString("I am a String!");

        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    String [] sStings = manipulatedstring.getSubStrings(1, 5);
                });
    }
    @Test
    public void testGetSubStrings6_EmptyString() {
        manipulatedstring.setString("");

        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    String [] sStings = manipulatedstring.getSubStrings(1, 5);
                });
    }

    @Test
    public void testRestoreString1_3LetterWord()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    public void testRestoreString2_ThrowIllegalArgumentException()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0};

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    String restoreString = manipulatedstring.restoreString(array);
                });
    }

    @Test
    public void testRestoreString3_ThrowIndexOutOfBoundsException_GreaterThan()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,10};

        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    String restoreString = manipulatedstring.restoreString(array);
                });
    }

    @Test
    public void testRestoreString4_ThrowIndexOutOfBoundsException_LessThan()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,-10};

        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    String restoreString = manipulatedstring.restoreString(array);
                });
    }

}
