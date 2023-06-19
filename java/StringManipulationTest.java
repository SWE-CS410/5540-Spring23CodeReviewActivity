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
        manipulatedstring.setString("bread is delicious");
        int length = manipulatedstring.count();
        assertEquals(3, length);


    }

    @Test
    public void testCount3() {

        manipulatedstring.setString("cats 3re delicious");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("birds          worms");
        int length = manipulatedstring.count();
        assertEquals(2, length);
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
        manipulatedstring.setString("I'm going want to eat bread");
        assertEquals("I'  g in  w nt to ea  b ea", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    public void testRemoveNthCharacter4() {

        manipulatedstring.setString("I'm    going     want  to eat bread");
        assertEquals("I'   gin    an  o atbrad",manipulatedstring.removeNthCharacter(3,false));

    }

    @Test
    public void testRemoveNthCharacter5() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("bread is always life");
            manipulatedstring.removeNthCharacter(-1,false);
        });
    }

    @Test
    public void testRemoveNthCharacter6() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("bread is always life");
            manipulatedstring.removeNthCharacter(-1,true);
        });
    }

    @Test
    public void testRemoveNthCharacter7() {
        assertThrows(IllegalArgumentException.class, ()->{
            manipulatedstring.setString("bread is always life");
            manipulatedstring.removeNthCharacter(-1, false);
        });
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2(){
        manipulatedstring.setString("this is another string");
        String [] sStrings = manipulatedstring.getSubStrings(1,2);
        assertEquals(sStrings[0], "this");
        assertEquals(sStrings[1], "is");
    }
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("this is another string");
        assertThrows(IllegalArgumentException.class, ()-> manipulatedstring.getSubStrings(0,3));

    }
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("this is another string");
        assertThrows(IndexOutOfBoundsException.class, ()-> manipulatedstring.getSubStrings(1,5));
    }
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("this is my string");
        String [] sString = manipulatedString.getSubStrings(4,4);
        String expected = "string";
        String actual = sString[0];
        assertEquals(expected, actual);
    }
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("this is another string");
        assertThrows(IndexOutofBoundsException.class, ()-> manipulatedstring.getSubStrings(0,3));
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
        manipulatedstring.setString("racecar");
        int [] array;
        array=new int[]{3,4,5,6,0,1,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "carrace");

    }

    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("art_");
        int [] array;
        array=new int[]{1,0,2,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat_");

    }

    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("readb");
        int[] indices = { 0,1,2,3,4,5,17 };
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);
        });

    }

    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("readb");
        int[] indices = { 0,1,2,3,4,5,-7 };
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);
        });

    }

}
