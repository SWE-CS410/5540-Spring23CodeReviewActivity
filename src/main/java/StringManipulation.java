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
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        if (n > string.length()) {
            throw new IndexOutOfBoundsException("n must be less than the length of the string");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if ((i + 1) % n != 0) {
                sb.append(string.charAt(i));
            } else if (maintainSpacing) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord <= 0 || endWord <= 0) {
            throw new IllegalArgumentException("startWord and endWord must be greater than 0");
        }

        if (startWord > endWord) {
            throw new IllegalArgumentException("startWord must be less than endWord");
        }

        if (string == null || string.isEmpty()) {
            return new String[0];
        }

        String[] words = string.split("\\s+");
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("endWord must be less than the number of words in the string");
        }

        String[] subStrings = new String[endWord - startWord + 1];

        for (int i = startWord - 1; i < endWord; i++) {
            subStrings[i - startWord + 1] = words[i];
        }

        return subStrings;
    }

    @Override
    public String restoreString(int[] indices){
        if (indices == null || indices.length == 0) {
            return string;
        }

        if (string == null || string.isEmpty()) {
            return string;
        }

        if (indices.length != string.length()) {
            throw new IllegalArgumentException("indices must be the same length as the string");
        }

        char[] chars = string.toCharArray();
        char[] restoredChars = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            restoredChars[indices[i]] = chars[i];
        }

        return new String(restoredChars);
    }


}
