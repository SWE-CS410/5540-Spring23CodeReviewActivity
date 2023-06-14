import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    @DisplayName("Test GetString with a new object")
    public void testGetString1() {
        // arrange
        manipulatedString = new StringManipulation();

        // act
        String result = manipulatedString.getString();

        // assert
        assertNull(result);
    }

    @Test
    @DisplayName("Test GetString with a basic string")
    public void testGetString2() {
        // arrange
        String expected = "string";
        manipulatedString.setString(expected);

        // act
        String actual = manipulatedString.getString();

        // assert
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Test Count with a new object")
    public void testCount1() {
        // arrange
        manipulatedString = new StringManipulation();

        // act
        int actual = manipulatedString.count();

        // assert
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("Test Count with an empty string")
    public void testCount2() {
        // arrange
        manipulatedString.setString("");

        // act
        int actual = manipulatedString.count();

        // assert
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("Test Count with a multi-word string")
    public void testCount3() {
        // arrange
        manipulatedString.setString("This is my string");
        int expected = 4;

        // act
        int actual = manipulatedString.count();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Count with trailing spaces on the string")
    public void testCount4() {
        // arrange
        manipulatedString.setString("Here are spaces    ");
        int expected = 3;

        // act
        int actual = manipulatedString.count();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Count with alternate spacing characters")
    public void testCount5() {
        // arrange
        manipulatedString.setString("I_am_spaced_with_underscores");
        int expected = 5;

        // act
        int actual = manipulatedString.count();

        // assert
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Test RemoveNthCharacter with a random string with no replacement")
    public void testRemoveNthCharacter1() {
        // arrange
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String expected = "I' bttr uts0e 16tsinths trn6 rgh?";

        // act
        String actual = manipulatedString.removeNthCharacter(3, false);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with a random string with replacement")
    public void testRemoveNthCharacter2() {
        // arrange
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String expected = "I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?";

        // act
        String actual = manipulatedString.removeNthCharacter(3, true);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with an index less than one")
    public void testRemoveNthCharacter3() {
        // arrange
        manipulatedString.setString("A string");

        // act/assert
        assertThrows(IllegalArgumentException.class, () -> manipulatedString.removeNthCharacter(0, true));
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with an index greater than string length")
    public void testRemoveNthCharacter4() {
        // arrange
        manipulatedString.setString("A string");

        // act/assert
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.removeNthCharacter(50, true));
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with an empty string with no replacement")
    public void testRemoveNthCharacter5() {
        // arrange
        manipulatedString.setString("A");
        String expected = "";

        // act
        String actual = manipulatedString.removeNthCharacter(1, false);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with an empty string with replacement")
    public void testRemoveNthCharacter6() {
        // arrange
        manipulatedString.setString("A");
        String expected = " ";

        // act
        String actual = manipulatedString.removeNthCharacter(1, true);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with removing all characters")
    public void testRemoveNthCharacter7() {
        // arrange
        manipulatedString.setString("This is a string");
        String expected = "";

        // act
        String actual = manipulatedString.removeNthCharacter(1, false);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test RemoveNthCharacter with replacing all characters")
    public void testRemoveNthCharacter8() {
        // arrange
        manipulatedString.setString("This is a string");
        String expected = "                ";

        // act
        String actual = manipulatedString.removeNthCharacter(1, true);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Test getSubStrings with a multi-word string")
    public void testGetSubStrings1() {
        // arrange
        manipulatedString.setString("This is my string");

        // act
        String [] sStings = manipulatedString.getSubStrings(3, 4);

        // assert
        assertEquals("my", sStings[0]);
        assertEquals("string", sStings[1]);
    }

    @Test
    @DisplayName("Test getSubStrings for exception throw where string has no words")
    public void testGetSubStrings2() {
        // arrange
        manipulatedString.setString("");

        // act/assert
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.getSubStrings(0, 1));
    }

    @Test
    @DisplayName("Test getSubStrings for exception throw when there are less words than endWord param")
    public void testGetSubStrings3() {
        // arrange
        manipulatedString.setString("This is four words");

        // act/assert
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.getSubStrings(1, 5));
    }

    @Test
    @DisplayName("Test getSubStrings for exception thrown when startWord is invalid")
    public void testGetSubStrings4() {
        // arrange
        manipulatedString.setString("I am a string");

        // act/assert
        assertThrows(IllegalArgumentException.class, () -> manipulatedString.getSubStrings(0, 2));
    }

    @Test
    @DisplayName("Test getSubStrings for exception thrown when endWord is invalid")
    public void testGetSubStrings5() {
        // arrange
        manipulatedString.setString("I am a string");

        // act/assert
        assertThrows(IllegalArgumentException.class, () -> manipulatedString.getSubStrings(1, 0));
    }

    @Test
    @DisplayName("Test getSubStrings getting from a single word string")
    public void testGetSubStrings6() {
        // arrange
        manipulatedString.setString("String");
        String[] expected = {"String"};

        // act
        String[] result = manipulatedString.getSubStrings(1, 1);

        // assert
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(result));
    }

    @Test
    @DisplayName("Test getSubStrings getting from a string with extra spaces")
    public void testGetSubStrings7() {
        // arrange
        manipulatedString.setString("  So   many   spaces  ");
        String[] expected = {"So", "many"};

        // act
        String[] result = manipulatedString.getSubStrings(1, 2);

        // assert
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(result));
    }


    @Test
    @DisplayName("Test restoreString with small sample string")
    public void testRestoreString1() {
        // arrange
        manipulatedString.setString("art");
        int [] array;
        array=new int[]{1,0,2};

        // act
        String restoreString = manipulatedString.restoreString(array);

        // assert
        assertEquals(restoreString, "rat");
    }

    @Test
    @DisplayName("Test restoreString for thrown exception when indices index of incorrect length given as param")
    public void testRestoreString2() {
        // arrange
        manipulatedString.setString("text");
        int[] array = new int[] {0, 1};

        // act/assert
        assertThrows(IllegalArgumentException.class, () -> manipulatedString.restoreString(array));
    }

    @Test
    @DisplayName("Test restoreString for thrown exception when there is a index less than 0 in indices param")
    public void testRestoreString3() {
        // arrange
        manipulatedString.setString("text");
        int[] array = new int[] {-1, 1, 3, 2};

        // act/assert
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.restoreString(array));
    }

    @Test
    @DisplayName("Test restoreString for thrown exception when there is a index greater than string length in indices param")
    public void testRestoreString4() {
        // arrange
        manipulatedString.setString("text");
        int[] array = new int[] {4, 3, 2, 6};

        // act/assert
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.restoreString(array));
    }

    @Test
    @DisplayName("Test restoreString for thrown exception when there is are duplicates in indices param")
    public void testRestoreString5() {
        // arrange
        manipulatedString.setString("text");
        int[] array = new int[] {1, 2, 1, 3};

        // act/assert
        assertThrows(IllegalArgumentException.class, () -> manipulatedString.restoreString(array));
    }

}
