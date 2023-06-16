import java.util.*;

public class StringManipulation implements StringManipulationInterface {
    private String manipulatedstring = null;

    @Override
    public String getString() {
        return manipulatedstring;
    }

    @Override
    public void setString(String string) {
        manipulatedstring = string;
    }

    @Override
    public int count() {
        Scanner Scan = new Scanner(manipulatedstring);
        int count = 0;

        while (Scan.hasNext()) {
            Scan.next();
            count++;
        }

        Scan.close();
        return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (n > manipulatedstring.length())
            throw new IndexOutOfBoundsException("n is larger than string length");
        if (n <= 0)
            throw new IllegalArgumentException("n is less than or equal to 0");

        String editedstring = "";
        int i = 0;

        while (i < (manipulatedstring.length() / n)) {
            // for n, the starting character is defined as position 1
            // so removing the n'th character is really removing the character at position n + 1
            editedstring = editedstring + manipulatedstring.substring(i * n, (i + 1) * n - 1);
            // everything up to next char to remove

            if (maintainSpacing) {
                editedstring = editedstring + " ";
            } // else don't append anything

            i++;
        }

        editedstring = editedstring + manipulatedstring.substring(i * n);

        return editedstring;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord)
            throw new IllegalArgumentException();
        if (count() < endWord)
            throw new IndexOutOfBoundsException("endWord is greater than the number of words in the string");

        String[] words = new String[endWord - startWord];
        Scanner Scan = new Scanner(manipulatedstring);

        // consume all words until but not including startWord
        for (int i = 1; i < startWord; i++) {
            Scan.next();
        }

        // the scanner now points to startWord
        for (int i = 0; i <= endWord - startWord; i++) {
            words[i] = Scan.next();
        }

        Scan.close();
        return words;
    }

    @Override
    public String restoreString(int[] indices){
        char[] originalStr = manipulatedstring.toCharArray();

        for (int i = 0; i < originalStr.length; i++)
            if (!Character.isLetter(originalStr[i]))
                throw new IllegalArgumentException("String must only be letters (upper- or lower-case)");

        for (int i = 0; i < indices.length; i++)
            if (indices[i] < 0 || indices[i] >= manipulatedstring.length())
                throw new IndexOutOfBoundsException("indices elements must be valid string indices (0 <= index < length of the string)");

        if (!isPermutation(indices, 0, indices.length - 1))
            throw new IllegalArgumentException("indices isn't a permutation of 0 to (length of indices - 1)");

        if (indices.length != manipulatedstring.length())
            throw new IllegalArgumentException("indices and string are different lengths");


        char[] shuffledStr = new char[originalStr.length];

        for (int i = 0; i < indices.length; i++)
            shuffledStr[indices[i]] = originalStr[i];

        return shuffledStr.toString();
    }

    // returns true iff the passed array contains a permutation of the integers from start to end
    private boolean isPermutation(int[] arr, int start, int end) {
        // first check that all integers from start to end are in arr
        for (int i = start; i <= end; i++) {
            if (!arrayContains(arr, i))
                return false;
        }

        // then check that values in arr are unique
        List<Integer> uniques = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (uniques.contains(arr[i]))
                return false;
            uniques.add(arr[i]);
        }

        return true;
    }

    // returns true iff arr contains val
    private boolean arrayContains(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == val)
                return true;

        return false;
    }
}
