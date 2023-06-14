import java.util.ArrayList;
import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {
    String string = null;
    // Default constructor
    StringManipulation() {} 
 

    // Parameterized constructor
    StringManipulation(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return this.string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    // todo: raise nullPointer Exception if string is null
    @Override
    public int count() {
        int count = 0;
        String string = getString();
        char ch[]= new char[string.length()];     
        for(int i=0;i<string.length();i++)  
        {  
            ch[i]= string.charAt(i);  
            if(((i > 0) && (ch[i] != ' ') && (ch[i-1] == ' ')) || ((ch[0] != ' ') && (i == 0)))  
                count++;
        }
        return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        // throw IllegalArgument Exception if n <= 0
        if (n <= 0) {
            throw new IllegalArgumentException("n has to be at least 1");
        }

        String string = this.getString();
        if (n >= string.length()) {
            throw new IndexOutOfBoundsException("n cannot be greater than the length of a string");
        }

        String res = ""; // start with first substring from first char to the last char before nth char.
        String subString = "";
        int startSub = n; // index for beginning of substring
        int i = 2;

        if (maintainSpacing == false) {
            res = string.substring(0,n-1);
            // iterate while i*n is less than length. Increment by n
            while (startSub < string.length()) {
                if (string.length() % n != 0 && n*i > string.length()) { // add last substring if necessary
                    res += string.substring(startSub);
                    return res;
                }
                subString = string.substring(startSub, i*n-1);
                res += subString; // add substring excluding nth char until the i*nth char
                startSub = i*n;
                i++;
            }

        } else {
            char whiteSpace = ' ';
            res = string.substring(0,n-1) + whiteSpace;
            // iterate while i*n is less than length. Increment by n
            while (startSub < string.length()) {
                if (string.length() % n != 0 && n*i > string.length()) { // add last substring if necessary
                    res += string.substring(startSub);
                    return res;
                }
                subString = string.substring(startSub, i*n-1)+whiteSpace;
                res += subString; // add substring excluding nth char until the i*nth char
                startSub = i*n;
                i++;
            }
        }
        return res;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        String string = getString();
        int wordCount = count();
        if (endWord > wordCount) {
            throw new IndexOutOfBoundsException("String has less than endWord words in it.");
        } else if (endWord <= 0 || startWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord.");
        }

        String totalWords[] = string.split(" ");
        String words[] = new String[endWord-startWord+1];
        int index = 0;
        String subString = "";

        // for corner case when startWord is the same as endWord
        if (startWord == endWord) {
            words[index] = totalWords[startWord-1];
            return words;
        }
        // Add matching totalWords[startWord-1] to totalWords[endWord-1] to words
        for (int i = startWord-1; i<endWord; i++) {
            words[index] = totalWords[i];
            index++;
        }
        return words;
    }

    @Override
    public String restoreString(int[] indices){
        String string = getString();
        if (indices.length != string.length()) {
            throw new IllegalArgumentException("Indice array has to be the same length as string.");
        }

        String newString = "";
        for (int index: indices) {
            // get character from index of string
            char c = string.charAt(index);
            // append each character to newString
            newString += c;
        }
        return newString;
    }


}
