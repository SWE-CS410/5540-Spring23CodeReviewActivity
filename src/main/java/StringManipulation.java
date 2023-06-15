// Sean Michael CS410

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringManipulation implements StringManipulationInterface {
    String string;
    @Override
    public String getString() {
        return null;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int count() {
        StringTokenizer st = new StringTokenizer(string, " ");
        return st.countTokens();
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        // if n < 0, throw illegal argument exception
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");
        // if n > string.length(), throw out of bounds exception
        else if (n > string.length()) throw new IndexOutOfBoundsException("n cannot exceed string length");
        // if n == 0 the string is unchanged
        else if (n == 0) return string;
        // if every 1 char is being removed, all should be removed and either replaced with space or not
        else if (n == 1) {
            if (maintainSpacing) {
                return " ".repeat(string.length());
            }
            else return "";
        }
        // otherwise, remove every nth character
        else {
            StringBuilder sb = new StringBuilder(string);
            // start at end of string minus the remainder of the string divided by n, the "last" char to be removed
            for (int i = string.length() - string.length() % n - 1; i >= 0; i -= n) {
                if (maintainSpacing) {
                    sb.replace(i,i+1," ");
                }
                else sb.deleteCharAt(i);
            }
            return sb.toString();
        }

    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        // if startword is after endword or either is less than or equal to 0, throw illegalargexcept
        if (startWord > endWord || startWord <= 0)
            throw new IllegalArgumentException("startword: " + startWord + " endword: " + endWord);
        // convert string to stringtokenizer for easy counting and tokenizing
        StringTokenizer st = new StringTokenizer(string, " ");
        // if there are more words requested than present, throw indexoutofbounds
        if (startWord > st.countTokens() || endWord > st.countTokens())
            throw new IndexOutOfBoundsException("not enough words");
        // convert tokenizer into String array
        String[] substrings = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            substrings[i++] = st.nextToken();
        }
        // return copy of array with only requested words
        return Arrays.copyOfRange(substrings,startWord - 1,endWord);
    }

    @Override
    public String restoreString(int[] indices){
        // throw illegalargexcept if indices len does not match string len
        if (indices.length != string.length()) throw new IllegalArgumentException("incorrect number of indices passed");
        // if indices len is 1 or less return the unmodified string
        else if (indices.length <= 1) return string;
        // generate stringbuilder and pass to recursive helper method
        StringBuilder sb = new StringBuilder(string);
        return restoreStringHelper(sb, indices, 0).toString();
    }
    //recursive helper for restoreString
    private StringBuilder restoreStringHelper(StringBuilder sb, int[] indices, int index) {
        // base case, if index matches stringbuilder length
        if (index == sb.length() - 1) return sb;
        // if indices contains an invalid index, throw indexoutofbnds
        else if (indices[index] > sb.length()) throw new IndexOutOfBoundsException("index given is too large");
        // recursive case, recurses and then replaces the given index with the current index's value
        else {
            // gets replacement char (as string) from current index value
            String replacement = string.substring(index, index + 1);
            // recurses and then replaces the given index with the replacement value
            return restoreStringHelper(sb, indices, index + 1).replace(indices[index], indices[index] + 1, replacement);
        }
    }


}
