// Celine Chiou
// CS 410 JUnit Testing Assignment

import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {
    private String currentString;
    private int count;

    @Override
    public String getString() {
        if (currentString == null) {
            return null;
        } else {
            return currentString;
        }
    }

    @Override
    public void setString(String string) {
        this.currentString = string;
    }

    @Override
    public int count() {
        // leading spaces and extra spaces are removed
        // words are placed into string array and number of words = count
        for (int i = 0; i < currentString.length(); i++) {
            String trimmedString = currentString.trim().replaceAll("\\s+", " ");
            String[] wordCount = trimmedString.split(" ");
            count = wordCount.length;
        }
        return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        StringBuilder finalString = new StringBuilder();

        // throws IndexOutOfBoundsException If n is greater than the string length.
        if (n > getString().length()) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds Exception: n is greater than the string length");
        }

        // throws IllegalArgumentException If "n" less than or equal to zero.
        if (n <= 0) {
            throw new IllegalArgumentException("Illegal Argument Exception: n is less than or equal to 0");
        }

        for (int i = 0; i < currentString.length(); i++) {
            if ((i + 1) % n != 0) {  // accounts for when i % n is not 0
                finalString.append(currentString.charAt(i));
            } else if (maintainSpacing) {
                    finalString.append(" ");
            }
        }
        return finalString.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        // throws IllegalArgumentException If either "startWord" or "endWord" are invalid (i.e.,
        //     "startWord" <= 0, "endWord" <= 0, or "startWord" > "endWord")
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Illegal Argument Exception: Invalid startWord or endWord");
        }

        // this portion will remove leading/extra spaces
        // words are added to array, split by spaces
        String trimmedString = currentString.trim().replaceAll("\\s+", " ");
        String[] wordArray = trimmedString.split(" ");

        // throws IndexOutOfBoundsException If the string has less than "endWord" words in it
        if (endWord > wordArray.length) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds Exception: String has fewer words than endWord");
        }
        return Arrays.copyOfRange(wordArray, startWord - 1,endWord);
    }

    @Override
    public String restoreString(int[] indices){
        char[] shuffledArray = new char[indices.length];

        // throws IllegalArgumentException if not s.length == indices.length == n
        if (indices.length != getString().length()) {
            throw new IllegalArgumentException("Illegal Argument Exception: Length of string and indices array do not match");
        }

        for (int i = 0; i < indices.length; i++) {
            // if statement that throws IndexOutOfBoundsException if indices[i]< 0  or  indices[i]>= string length
            if(indices[i] < 0 || indices[i] >= indices.length) {
                throw new IndexOutOfBoundsException("Index Out Of Bounds Exception: Invalid index");
            }
            shuffledArray[indices[i]] = getString().charAt(i);
        }
        return new String(shuffledArray);
    }
}
