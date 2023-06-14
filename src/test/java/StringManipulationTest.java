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
    //first test
    public void count_CountingLength_ReturnCorrectLength() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    //second test
    public void count_EmptyString_return0() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //third test
    public void count_nullString_return0() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //fourth test
    public void count_noWords_return0() {
        manipulatedstring.setString(" ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //fifth test
    public void count_trailingSpace_returnsCorrectCount(){
        manipulatedstring.setString("Hello World! ");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    @Test
    //sixth test
    public void count_leadingSpace_returnsCorrectCount(){
        manipulatedstring.setString(" Hello World!");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    @Test
    //seventh test
    public void removeNthCharacter_maintainSpacingFalse_returnsStringWithoutSpaces() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    //eighth test
    public void removeNthCharacter_maintainSpacingTrue_returnsStringWithSpaces() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    //ninth test
    public void removeNthCharacter_nLessThanOrEqual0_throwIllegalArgumentException() {
        manipulatedstring.setString("Hello there");

        assertThrows(IllegalArgumentException.class, ()->
                manipulatedstring.removeNthCharacter(0, false));
    }

    @Test
    //tenth test
    public void removeNthCharacter_nGreaterThanStringLength_throwIndexOutOfBoundsException() {
        manipulatedstring.setString("Hello there");

        assertThrows(IndexOutOfBoundsException.class, ()->
                manipulatedstring.removeNthCharacter(13, false));
    }

    @Test
    //eleventh test
    public void removeNthCharacter_emptyString_returnsEmptyString() {
        manipulatedstring.setString("");
        String actual = manipulatedstring.removeNthCharacter(2, false);
        assertEquals("", actual);
    }

    @Test
    //twelfth test
    public void removeNthCharacter_nullString_returnNullPointerException() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, ()->
                manipulatedstring.removeNthCharacter(4, false));
    }

    @Test
    //thirteenth test
    public void removeNthCharacter_noCharactersRemoved_returnSameInputString() {
        manipulatedstring.setString("Same as input string");
        String actual = manipulatedstring.removeNthCharacter(1, true);
        assertEquals("Same as input string", actual);
    }

    @Test
    //fourteenth test
    public void getSubStrings_rangeOfWords_returnsCorrectExpectedToActual() {
        manipulatedstring.setString("This is my string");
        String[] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    //fifteenth test
    public void getSubStrings_nullString_returnsNullPointerException() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, ()->
                manipulatedstring.getSubStrings(3,5));
    }

    @Test
    //sixteenth test, endWord <=0
    public void getSubStrings_startWordGreaterThanEndWord_returnsIllegalArgumentException() {
        manipulatedstring.setString("I enjoy sunny days");
        assertThrows(IllegalArgumentException.class, ()->
                manipulatedstring.getSubStrings(3,1));
    }

    @Test
    //seventeenth test
    public void getSubStrings_startWordLessThanEqualTo0_returnsIllegalArgumentException() {
        manipulatedstring.setString("Summer is here");
        assertThrows(IllegalArgumentException.class, ()->
                manipulatedstring.getSubStrings(0,2));
    }

    @Test
    //eighteenth test
    public void getSubStrings_endWordLessThanEqualTo0_returnsIllegalArgumentException() {
        manipulatedstring.setString("Summertime is sunny");
        assertThrows(IllegalArgumentException.class, ()->
                manipulatedstring.getSubStrings(1,0));
    }

    @Test
    //nineteenth test
    public void getSubStrings_endWordGreaterThanString_returnsIndexOutOfBoundsException() {
        manipulatedstring.setString("Hello there");

        assertThrows(IndexOutOfBoundsException.class, ()->
                manipulatedstring.getSubStrings(1,3));
    }

    @Test
    //twentieth test
    public void getSubStrings_oneWordString_returnsInputString() {
        manipulatedstring.setString("Hello");
        String[] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "Hello");
    }

    @Test
    //twenty-first test
    public void getSubStrings_startWordEqualsEndWord_returnsOneWord() {
        manipulatedstring.setString("JUnit testing is beneficial");
        String[] sStings = manipulatedstring.getSubStrings(4, 4);

        assertEquals(sStings[0], "beneficial");
    }

    @Test
    //twenty-second test case
    public void restoreString_lowerCaseLetters_returnsRestoredString()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    //twenty-third test case
    public void restoreString_stringAndIndicesLengthDoNotEqual_returnsIllegalArgumentException()
    {
        manipulatedstring.setString("artistic");
        int [] array = new int[]{1,0,2,3};
        assertThrows(IllegalArgumentException.class, ()->
                manipulatedstring.restoreString(array));

    }

    @Test
    //twenty-fourth test case
    public void restoreString_indicesLessThan0_returnsIndexOutOfBoundsException()
    {
        manipulatedstring.setString("art");
        int [] array = new int[]{2,-1,0};
        assertThrows(IndexOutOfBoundsException.class, ()->
                manipulatedstring.restoreString(array));
    }

    @Test
    //twenty-fifth test case
    public void restoreString_indicesGreaterThanStringLength_returnsIndexOutOfBoundsException()
    {
        manipulatedstring.setString("art");
        int [] array = new int[]{1,0,4};
        assertThrows(IndexOutOfBoundsException.class, ()->
                manipulatedstring.restoreString(array));
    }

    @Test
    //twenty-sixth test case
    public void restoreString_nullString_returnNullPointerException()
    {
        manipulatedstring.setString(null);
        int [] array = new int[]{};
        assertThrows(NullPointerException.class, ()->
                manipulatedstring.restoreString(array));
    }

    @Test
    //twenty-seventh test case
    public void restoreString_emptyString_returnsEmptyString()
    {
        manipulatedstring.setString("");
        int [] array;
        array=new int[]{};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "");
    }

    @Test
    //twenty-eighth test case
    public void restoreString_upperCaseLetters_returnsRestoredString()
    {
        manipulatedstring.setString("ART");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "RAT");
    }

    @Test
    //twenty-ninth test case
    public void restoreString_upperCaseAndLowerCaseLetters_returnsRestoredString()
    {
        manipulatedstring.setString("aRT");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "RaT");
    }

    @Test
    //thirtieth test case
    public void restoreString_repeatedLetters_returnsRestoredString()
    {
        manipulatedstring.setString("stressed");
        int [] array;
        array=new int[]{7,6,0,4,3,2,1,5};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "desserts");
    }

}
