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
    //this test checks whether method count throws an IllegalArgumentException if count is not 4

    @Test
    public void testCount2() {
        manipulatedstring.setString("hi");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }
  //this test checks whether method count throws an IllegalArgumentException if count is not 1

    @Test
    public void testCount3() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }
  //this test checks whether method count throws an IllegalArgumentException if count is not 0

    @Test
    public void testCount4() {
        manipulatedstring.setString("  Spaces  between   words ");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }
  //this test checks whether method count throws an IllegalArgumentException if count is not 3
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }
  // this test checks whether method count throws an IllegalArgumentException if the new string is not "I' bttr uts0e 16tsinths trn6 rgh?"
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new string is not "I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?"


    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Hello");
        assertEquals("He lo", manipulatedstring.removeNthCharacter(3, true));
    }
 // this test checks whether method count throws an IllegalArgumentException if the new string is not "He lo"

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Testing123");
        assertEquals("Tetig13", manipulatedstring.removeNthCharacter(3, false));
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new string is not "Tetig13"

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Welcome to the jungle");
        assertEquals("W l o e t   h   u g e", manipulatedstring.removeNthCharacter(2, true));
    }
    
    // this test checks whether method count throws an IllegalArgumentException if the new string is not "W l o e t   h   u g e"

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I am loving it!");
        assertEquals("               ", manipulatedstring.removeNthCharacter(1, true));
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new string is not "               "

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("Testing the removal");
        assertEquals("Tetig hereovl", manipulatedstring.removeNthCharacter(3, false));
    }
 // this test checks whether method count throws an IllegalArgumentException if the new string is not "Tetig hereovl"

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
 // this test checks whether method count throws an IllegalArgumentException if the new sub string does not contain "my" and "string"

    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("This is a test string");
        String[] sStings = manipulatedstring.getSubStrings(2, 4);
        
        assertEquals(sStings[0], "is");
        assertEquals(sStings[1], "a");
        assertEquals(sStings[2], "test");
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new sub string does not contain "is", "a", and "test"

    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("Hello World! How are you?");
        String[] sStings = manipulatedstring.getSubStrings(1, 3);
        
        assertEquals(sStings[0], "Hello");
        assertEquals(sStings[1] ,"World!");
        assertEquals(sStings[2], "How") ;
    }
 // this test checks whether method count throws an IllegalArgumentException if the new sub string does not contain "Hello","World", and "How"

    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("Java is a popular programming language");
        String[] sStings = manipulatedstring.getSubStrings(4, 6);
        
        assertEquals(sStings[0], "popular");
        assertEquals(sStings[1], "programming");
        assertEquals(sStings[2], "language") ;
    }
 // this test checks whether method count throws an IllegalArgumentException if the new sub string does not contain "popular", "programming", and "language"

    @Test
    public void testGetSubStrings5() {
        manipulatedstring.setString("The quick brown fox jumps over the lazy dog");
        String[] sStings = manipulatedstring.getSubStrings(4, 6);
        
        assertEquals(sStings[0], "fox");
        assertEquals(sStings[1], "jumps");
        assertEquals(sStings[2] ,"over");
    }
 // this test checks whether method count throws an IllegalArgumentException if the new sub string does not contain "fox", "jumps", and "over"
    
    @Test
    public void testGetSubStrings6() {
        manipulatedstring.setString("I love coding in Java");
        String[] sStings = manipulatedstring.getSubStrings(2, 5);
        
        assertEquals( sStings[0], "love");
        assertEquals(sStings[1], "coding");
        assertEquals(sStings[2], "in");
        assertEquals( sStings[3], "Java");
    }
 // this test checks whether method count throws an IllegalArgumentException if the new sub string does not contain "love", "coding", "in", and "Java"
    
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new restored string is not "rat"

    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("saturday");
        int [] array;
        array = new int[]{0,6,5,3,4,2,1,7};
        String restoreString = manipulatedstring.restoreString(array);
        System.out.println(restoreString);
        assertEquals(restoreString, "sadurtay");
    }
    
    // this test checks whether method count throws an IllegalArgumentException if the new restored string is not "sarudtay"
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("abcd");
        int [] array;
        array = new int[]{3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "dcba");
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new restored string is not "dcba"

    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("Hello, World!");
        int [] array;
        array=new int[]{8, 6, 7, 9, 4, 5, 3, 2, 1, 0, 12, 11, 10};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "o Wro,lleH!dl");
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new restored string is not "o Wro,lleH!dl"

    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("Programming is fun!");
        int [] array;
        array=new int[]{3, 14, 9, 13, 6, 2, 1, 12, 4, 11, 7, 18, 8, 17, 16, 15, 10, 0, 5};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "g nsmorir m!inufgPa");
    }
    
 // this test checks whether method count throws an IllegalArgumentException if the new restored string is not "g nsmorir m!inufgPa"

}
