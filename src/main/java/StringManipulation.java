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
        if (string == null) {
            return 0;
        }
        String[] words = string.trim().split("\\s+");
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (string == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero");
        }
        if (n > string.length()) {
            throw new IndexOutOfBoundsException("n exceeds string length");
        }
        StringBuilder result = new StringBuilder();
        char[] chars = string.toCharArray();
        int count = 0;
        for (char c : string.toCharArray()) {
            count++;
            if (count % n != 0) {
                result.append(c);
            } else if (maintainSpacing) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (string == null) {
            return null;
        }
        String[] words = string.trim().split("\\s+");
        int numWords = words.length;

        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord values");
        }
        if (endWord > numWords) {
            throw new IndexOutOfBoundsException("The string has fewer than endWord words");
        }
        return java.util.Arrays.copyOfRange(words, startWord - 1, endWord);
    }

    @Override
    public String restoreString(int[] indices) {
        if (string == null || indices == null || string.length() != indices.length) {
            throw new IllegalArgumentException("Invalid arguments: string length must be equal to indices length");
        }
        char[] chars = string.toCharArray();
        char[] restoredChars = new char[chars.length];
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index < 0 || index >= chars.length) {
                throw new IndexOutOfBoundsException("Invalid index: indices[i] must be within the string length and unique");
            }
            restoredChars[i] = chars[index];
        }
        return new String(restoredChars);
    }

}
