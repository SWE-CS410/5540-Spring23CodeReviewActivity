public class StringManipulation implements StringManipulationInterface {

    private String currString;
    private int stringLength;

    @Override
    public String getString() {
        return currString;
    }

    @Override
    public void setString(String string) {
        currString = string;
        stringLength = currString.length();
    }

    @Override
    public int count() {

if(currString.length()==0)//empty string has no words
    return 0;

        int wordCount = 0;
        // Count the number of spaces to determine the number of words
        for (int i = 0; i < stringLength; i++) {
            if (currString.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Add 1 to the word count to account for the last word
        return wordCount + 1;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is less than or equal to 0");
        }

        if (n > stringLength) {
            throw new IndexOutOfBoundsException("n is greater than the length of the string");
        }

        String newString = "";

        // Iterate through each character in the string
        for (int i = 1; i <= stringLength; i++) {
            // Check if the current position is a multiple of n
            if (i % n == 0) {
                // If maintainSpacing is true, add a space character
                if (maintainSpacing) {
                    newString += ' ';
                }
            } else {
                // Otherwise, add the character at the current position to the new string
                newString += currString.charAt(i - 1);
            }
        }

        return newString;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        if (count() < endWord) {
            throw new IndexOutOfBoundsException("endWord is greater than the total number of words in the string");
        }

        String[] subStrings = new String[endWord - startWord + 1];
        int k = 0;
        String currWord = "";
        int currWordIndex = 0;

        // Iterate through each character in the string
        for (int i = 0; i < stringLength; i++) {
            if (currString.charAt(i) == ' ') {
                currWordIndex++;

                // Check if the current word index is within the specified range
                if (currWordIndex >= startWord && currWordIndex <= endWord) {
                    subStrings[k++] = currWord;
                }

                currWord = "";
            } else {
                currWord += currString.charAt(i);
            }
        }

        currWordIndex++;

        // Check if the last word is within the specified range
        if (currWordIndex >= startWord && currWordIndex <= endWord) {
            subStrings[k++] = currWord;
        }

        return subStrings;
    }

    @Override
    public String restoreString(int[] indices) {
        if (stringLength != indices.length) {
            throw new IllegalArgumentException("Size of indices mismatches the size of the current string");
        }

        String shuffledString = new String(currString);
        char[] shuffledArray = shuffledString.toCharArray();

        // Iterate through each index in the indices array
        for (int i = 0; i < stringLength; i++) {
            // Check if the index is valid
            if (indices[i] < 0 || indices[i] >= stringLength) {
                throw new IndexOutOfBoundsException("Invalid index " + indices[i] + " in the indices array");
            }

            // Restore the character at the corresponding index
            shuffledArray[indices[i]] = currString.charAt(i);
        }

        shuffledString = new String(shuffledArray);

        return shuffledString;
    }
}
