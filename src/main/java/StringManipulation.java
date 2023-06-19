import java.util.Arrays;

//Author: Jonathan Jarman
//Date: 6/11/2023
//File: String Manipulation
/*The StringManipulation class provides a set of methods for manipulating strings,
such as counting the number of words, removing characters at specific positions,
extracting substrings, and restoring shuffled strings. It implements the StringManipulationInterface,
which defines the contract for these operations.
* */
public class StringManipulation implements StringManipulationInterface {

   private String string; // holding string input

    @Override
    public String getString() { // method to return string
        return string;
    }

    @Override
    public void setString(String string) { // method to set the string
        this.string = string;
    }

    // this method will count the # of words in the string
    @Override
    public int count() {
        // throw null pointer exception if string is null
        if (string == null) {
            throw new NullPointerException("String is null");
        }
        // if string is empty throw an exception
        if (string.isEmpty()) {
            return 0;
        }
        // creating an array for the string
        String[] words = string.trim().split("\\W+");
        // returning length of words(string count)
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        // if n < 0, throw an error
        if (n <= 0) {
            throw new IllegalArgumentException("'n' must be greater than zero.");
        }
        // if n > length, throw an error
        if (n > string.length()) {
            throw new IndexOutOfBoundsException("'n' is greater than the string length.");
        }
        // catching null errors
        if (string == null) {
            throw new NullPointerException("String is null!");
        }
        // string builder to manipulate
        StringBuilder result = new StringBuilder();
        // setting count to 1
        int count = 1;
        // looping through the string
        for (int i = 0; i < string.length(); i++) {
            if (count % n != 0) {
                result.append(string.charAt(i));// append char to the result string
            } else if (maintainSpacing) {
                result.append(' ');// append a space to maintain spacing
            }
            count++;// increment count
        }

        return result.toString();// return modified string
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        // Checking for null string
        if (string == null) {
            throw new NullPointerException("String cannot be null!");
        }

        String[] words = string.trim().split("\\s+"); // Splitting the string into words

        // Checking for invalid values of startWord and endWord
        if (startWord <= 0 || startWord > endWord || endWord > words.length) {
            throw new IllegalArgumentException("Invalid values for startWord and endWord");
        }

        int length = endWord - startWord + 1;
        String[] subStrings = Arrays.copyOfRange(words, startWord - 1, endWord); // Copying words into the subStrings array

        return subStrings; // Returning the selected substrings
    }

    @Override
    public String restoreString(int[] indices) {

        if (string == null) {
            throw new NullPointerException("string is null!");
        }

        int length = string.length();

        if (indices.length != length) {
            throw new IllegalArgumentException("Invalid length of indices array");
        }

        char[] shuffled = new char[length]; // Create a new character array for the shuffled string

        for (int i = 0; i < length; i++) { // Iterate over the indices array and restore the shuffled string
            int index = indices[i];

            if (index < 0 || index >= length) { // Check if the index is out of bounds
                throw new IndexOutOfBoundsException("Invalid index in indices array");
            }

            shuffled[index] = string.charAt(i); // Assign the character directly from the original string
        }

        return new String(shuffled); // Convert the shuffled character array back to a string
    }
}
