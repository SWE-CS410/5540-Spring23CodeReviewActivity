import java.util.Arrays;

// Description: This class implements various methods that manipulates strings.
public class StringManipulation implements StringManipulationInterface {

    private String str = null;
    @Override
    public String getString() {
        return this.str;
    }

    @Override
    public void setString(String string) {
        this.str = string;
    }

    @Override
    public int count() {
        if(this.str == null || this.str.isEmpty()){
            return 0;
        }

        String[] words = this.str.split("\\s+");

        int wordCount = 0;
        for (String word : words) {
            // Count words and numerical values as a word.
            // Ignore punctuation.
            if (word.matches(".*[a-zA-Z0-9].*")) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n > str.length()) {
            throw new IndexOutOfBoundsException("The argument is out of bound.");
        } else if (n <= 0) {
            throw new IllegalArgumentException("n index cannot be less than or equal to 0.");
        }

        StringBuilder stringBuilder = new StringBuilder(str);

        // Loop through multiples of n
        for (int i = 1; n * i <= str.length(); i++) {
            int index = n * i - 1;
            if (maintainSpacing) {
                stringBuilder.setCharAt(index, ' ');
            } else {
                // Decrease index by i to account for previously deleted characters
                stringBuilder.deleteCharAt(index - (i - 1));
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        // Validate the inputs
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("StartWord must be greater than 0 and less than or equal to EndWord.");
        }

        // Split the string into words
        String[] words = this.str.trim().split("\\s");

        // Validate that endWord does not exceed the number of words
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("The positions must be within the bounds");
        }

        // Return the subarray of words
        return Arrays.copyOfRange(words, startWord - 1, endWord);
    }

    @Override
    public String restoreString(int[] indices) {
        // Check if the length of the string and indices array are the same
        if (str.length() != indices.length) {
            throw new IllegalArgumentException("Length of string and indices array must be equal.");
        }

        // Array of characters to rebuild the string.
        char[] shuffledString = new char[str.length()];
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            // Check if the given indice is within the bounds of the string
            if (index < 0 || index >= str.length()) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
            }
            // Assign the character to the char array at the index position
            shuffledString[index] = str.charAt(i);
        }
        return new String(shuffledString);
    }
}
