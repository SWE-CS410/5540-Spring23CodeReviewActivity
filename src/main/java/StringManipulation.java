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
        if (string == null || string.isEmpty()) {
            return 0;
        }

        String[] words = string.split("\\s+");
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (string == null || string.isEmpty()) {
            return string;
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        if (n > string.length()) {
            throw new IndexOutOfBoundsException();
        }

        String result = "";
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if ((i + 1) % n != 0) {
                result += c;
            } else {
                if (maintainSpacing) {
                    result += " ";
                }
            }

        }
        return result;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException();
        }

        String[] words = string.split("\\s+");
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException();
        }

        int substringCount = endWord - startWord + 1;
        String[] substrings = new String[substringCount];

        for (int i = startWord - 1; i <= endWord - 1; i++) {
            substrings[i - startWord + 1] = words[i];
        }

        return substrings;
    }

    @Override
    public String restoreString(int[] indices) {
        int n = indices.length;
        char[] shuffledChars = new char[n];

        if (!(string.length() == indices.length && indices.length == n)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < n; i++) {
            if (indices[i] < 0 || indices[i] >= n) {
                throw new IndexOutOfBoundsException();
            }
            shuffledChars[indices[i]] = string.charAt(i);
        }

        return new String(shuffledChars);
    }
}