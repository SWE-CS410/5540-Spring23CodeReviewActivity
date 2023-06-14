public class StringManipulation implements StringManipulationInterface {

    private String string;

    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int count() {
        if (string == null)
            return 0;
        if (string.length() == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < string.length() - 2; i++) {
            if (i == 0 && !isSpaceChar(string.charAt(i)))
                count++;
            else if (isSpaceChar(string.charAt(i)) && !isSpaceChar(string.charAt(i + 1)))
                count++;
        }

        return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0)
            throw new IllegalArgumentException();
        if (n > string.length())
            throw new IndexOutOfBoundsException();

        StringBuilder newStr = new StringBuilder();
        for (int i = 1; i < string.length() + 1; i++) {
            if (i % n == 0) {
                if (maintainSpacing)
                    newStr.append(' ');
            } else
                newStr.append(string.charAt(i - 1));
        }

        return newStr.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (count() < endWord)
            throw new IndexOutOfBoundsException();
        if (startWord <= 0 || endWord <= 0 || startWord > endWord)
            throw new IllegalArgumentException();

        String[] words = new String[(endWord - startWord) + 1];
        int wordIndex = 0;

        StringBuilder sb = new StringBuilder();
        int wordCount = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            // Case where first character is a word
            if (i == 0 && !isSpaceChar(string.charAt(i))) {
                wordCount++;
                if (wordCount == startWord)
                    sb.append(string.charAt(i));

                // Case where beginning of new word is found
            } else if (isSpaceChar(string.charAt(i)) && !isSpaceChar(string.charAt(i + 1))) {
                wordCount++;
                i++;
                if (wordCount >= startWord && wordCount <= endWord)
                    sb.append(string.charAt(i));

                // Case where end of word is found
            } else if (!isSpaceChar(string.charAt(i)) && isSpaceChar(string.charAt(i + 1))) {
                if (wordCount >= startWord && wordCount <= endWord) {
                    sb.append(string.charAt(i));
                    words[wordIndex++] = sb.toString();
                    sb = new StringBuilder();
                }

            } else if (!isSpaceChar(string.charAt(i)) && wordCount >= startWord && wordCount <= endWord) {
                sb.append(string.charAt(i));
            }
        }
        if (endWord == count()) {
            sb.append(string.charAt(string.length() - 1));
            words[wordIndex] = sb.toString();
        }

        return words;
    }

    @Override
    public String restoreString(int[] indices){
        if (indices.length != string.length())
            throw new IllegalArgumentException();

        boolean[] indexUsed = new boolean[indices.length];
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] > string.length())
                throw new IndexOutOfBoundsException();
            if (indexUsed[indices[i]])
                throw new IllegalArgumentException("Indices must be unique");

            chars[indices[i]] = string.charAt(i);
            indexUsed[indices[i]] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars)
            sb.append(c);

        return sb.toString();
    }


    private boolean isSpaceChar(char ch) {
        // Add any characters considered as a word delimiter
        char[] spaceChars = {' ', '_', '-', '\t', '\n'};

        for (char c : spaceChars) {
            if (c == ch)
                return true;
        }

        return false;
    }
}
