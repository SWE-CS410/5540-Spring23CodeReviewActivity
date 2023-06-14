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
        if (string==null) {

            return 0;
        }
        String[] words = string.split("\\s+");
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ((i + 1) % n != 0) {
                if (maintainSpacing || !Character.isWhitespace(c)) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (string == null || string.isEmpty()) {
            return new String[0];
        }
        String[] words = string.trim().split("\\s+");
        if (startWord < 0 || startWord >= words.length || endWord < 0 || endWord >= words.length || startWord > endWord) {
            return new String[0];
        }
        int numSubstrings = endWord - startWord + 1;
        String[] substrings = new String[numSubstrings];
        int index = 0;
        for (int i = startWord; i <= endWord; i++) {
            substrings[index] = words[i];
            index++;
        }
        return substrings;
    }

    @Override
    public String restoreString(int[] indices) {
        if (string == null || string.isEmpty() || indices == null || indices.length != string.length()) {
            return "";
        }
        char[] chars = string.toCharArray();
        char[] restored = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            restored[indices[i]] = chars[i];
        }
        return new String(restored);
    }
}

