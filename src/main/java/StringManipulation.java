/*
    Jon Kaimmer
    CS410 Software Engineering
    Spring 2023
    Junit Testing Assignment

    Spring Manipulation
 */

import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.util.*;


public class StringManipulation implements StringManipulationInterface {

    public String s;

    @Override
    public String getString() {
        return s;
    }

    @Override
    public void setString(String string) {
        s = string;
    }

    @Override
    public int count() {
        if (s == null || s.isEmpty()){
            return 0;
        }
        String[] words = s.split("\\s+");
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        if(s == null){
            throw new NullPointerException("string cannot be null");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero.");
        }
        if (n > s.length()){
            throw new IndexOutOfBoundsException("n is greater than the string length.");
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0 ; i < s.length() ; i++){
            if((i+1)%n == 0){
                if (maintainSpacing){
                    sb.append(' ');
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){

        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid input: startWord and endWord should be greater than 0, and startWord should not be greater than endWord.");
        }

        String[] words = s.split("\\s+"); // Split the string into words

        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("The string has less than " + endWord + " words in it.");
        }

        String[] subStrings = new String[endWord - startWord + 1];

        for (int i = startWord - 1; i < endWord; i++) { // Array indices start at 0, but word positions start at 1
            subStrings[i - startWord + 1] = words[i]; // Adjust indices for the same reason
        }

        return subStrings;
    }

    @Override
    public String restoreString(int[] indices){
        if (s.length() != indices.length) {
            throw new IllegalArgumentException("The length of the string and the indices array must be the same.");
        }

        char[] shuffled = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (indices[i] < 0 || indices[i] >= s.length()) {
                throw new IndexOutOfBoundsException("Index " + indices[i] + " is out of bounds.");
            }
            shuffled[indices[i]] = s.charAt(i);
        }

        return new String(shuffled);
    }


}
