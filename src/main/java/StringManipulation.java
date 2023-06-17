/* Nadav Horowitz 6/3/2023 StringManipulation.java
 * This file contains various methods for manipulation of a String object.
 * The methods implemented include count, removeNthCharacter, getSubStrings, and restoreString.
 */
import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {
	
	public String string;
	
	
    @Override
    //Getter method for String field
    public String getString() {
        return this.string;
    }

    
    @Override
    //Setter method for String field
    public void setString(String string) {
    	this.string = string;
    }

    
    @Override
    //Returns number of words present in String object
    public int count() {
    	//null case and empty case
    	if (string == null || string.length() == 0)
    		return 0;
    	//trim leading and ending whitespace
    	String copy = this.getString();
    	copy = copy.trim();
    	//Regex for matching words
    	String[] words = copy.split(" +");
    	return words.length;
    }

    
    @Override
    //Returns a string that consists of all characters in the original string except for the characters
    //in positions n, 2n, 3n, and so on, either deleting those or replacing them with a white space. 
    //Throws IllegalArgumentException for n <= 0, throws IndexOutOfBoundsException for n > string length.
    public String removeNthCharacter(int n, boolean maintainSpacing) {
    	if(n <= 0)
    		throw new IllegalArgumentException();
    	if(n > string.length())
    		throw new IndexOutOfBoundsException();
    	
    	String replacement = "";
        if(maintainSpacing)
            replacement += " ";

        String newString = "";
        for(int i = 1; i <= string.length(); i++){
            char next = string.charAt(i-1);
            if(i % n == 0)
                newString += replacement;
            else 
                newString += next;
        }
        return newString;       
    }

    
    @Override
    //Returns String[] containing words from position "startWord" to position "endWord" in String object, 
    //with 1 being the first Word in the String.
    //Throws IllegalArgumentException If either "startWord" or "endWord" are invalid.
    //Throws IndexOutOfBoundsException If the string has less than "endWord" words in it.
    public String[] getSubStrings(int startWord, int endWord){
    	if(startWord <= 0 || endWord <= 0 || startWord > endWord)
    		throw new IllegalArgumentException();
    	
    	//trim leading and ending whitespace
    	String copy = this.getString();
    	copy = copy.trim();
    	
    	//Regex for matching words
    	String[] words = copy.split(" +");
    	
    	if(endWord > words.length)
    		throw new IndexOutOfBoundsException();
    	
    	words = Arrays.copyOfRange(words,startWord - 1, endWord);
        return words;
    }

    
    @Override
    //Given current String object and integer array "indices" of the same length, String will be shuffled such that
    //the character at the ith position moves to indices[i] in the shuffled string. Returns the shuffled string.
    //Throws IllegalArgumentException if string.length != indices.length
    //Throws IndexOutOfBoundsException if indices[i]< 0 or indices[i]> string length.
    public String restoreString(int[] indices){
    	String copy = this.getString();
    	
    	if(copy.length() != indices.length)
    		throw new IllegalArgumentException();
    	
    	String newString = "";
    	for(int i = 0; i < indices.length; i++) {
    		int stringIndex = indices[i];
    		
    		if(stringIndex < 0 || stringIndex > indices.length)
    			throw new IndexOutOfBoundsException();
    		
    		newString += copy.charAt(stringIndex);		
    	}		
        return newString;
    }
}