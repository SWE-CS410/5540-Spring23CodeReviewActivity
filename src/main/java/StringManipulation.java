// Nick Cudd
// CS 410 Spring 2023
// JUnit Testing Assignment

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class StringManipulation implements StringManipulationInterface {

    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public int count() {
        if (myString == null || myString.length() == 0) {
            return 0;
        }
        int wordCount = 0;
        // Use both whitespace and half thin-space characters to slice strings
        String[] tokens = myString.split(" | ");
        for (String i : tokens) {
            if (Pattern.matches("^[A-Za-z]+$", i)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is invalid: n > 0");
        } else if (myString == null) {
            throw new NullPointerException("String has not been initialized yet, or is null");
        } else if (n > myString.length()) {
            throw new IndexOutOfBoundsException("n cannot exceed length of parameter String");
        }

        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c : myString.toCharArray()) {
            characters.add(c);
        }

        for (int position = n, k = 2; position <= myString.length(); position = k * n, k++) {
            if (maintainSpacing) {
                characters.set((position - 1), ' ');
            } else
                characters.set((position - 1), null);
        }

        String newString = "";
        for (Character c: characters) {
            if (c != null) {
                newString += c;
            }
        }
        return newString;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (myString == null) {
            throw new NullPointerException("String has not been initialized yet, or is null");
        } else if (startWord <= 0 || endWord <= 0) {
            throw new IllegalArgumentException("startWord and endWord cannot be less than 1");
        } else if (endWord < startWord) {
            throw new IndexOutOfBoundsException("index of endWord cannot be prior to index of startWord");
        }

        int numberOfWords = (endWord - startWord) + 1;
        String[] words = myString.split(" | ");
        String[] subWords = new String[numberOfWords];
        for (int i = 0, j = startWord - 1; i < numberOfWords; i++, j++) {
            subWords[i] = words[j];
        }
        return subWords;
    }

    @Override
    public String restoreString(int[] indices) {
        if (myString == null) {
            throw new NullPointerException("String has not been initialized yet, or is null");
        }
        // Examine passed indices array for validity
        if (indices.length != myString.length()) {
            throw new IllegalArgumentException("passed index array must be same length as current String");
        }
        for (int i = 0; i < indices.length - 1; i++) {
            if (indices[i] < 0 || indices[i] > myString.length()) {
                throw new IndexOutOfBoundsException("Array of indices cannot contain negative integers or integers greater than the length of the current String");
            }
            // Check for duplicate integers
            for (int j = i + 1; j < indices.length; j++) {
                if (indices[i] == indices[j]) {
                    throw new IllegalArgumentException("passed index array must contain unique integer values");
                }
            }
        }
        char[] charString = myString.toCharArray();
        char[] referenceString = myString.toCharArray();
        for (int i = 0; i < charString.length; i++) {
            charString[i] = referenceString[indices[i]];
        }
        return new String(charString);
    }
}
