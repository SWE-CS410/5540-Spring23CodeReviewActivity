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
        String[] newString = string.split("\\s+");
        int length = 0;
        for (String index : newString) {
            if (!index.isEmpty()) {
                length++;
            }
        }
        return length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        int length = string.length();
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        } else if (n > length) {
            throw new IndexOutOfBoundsException("Out Of Bound");
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int cpm = i + 1;
            if (cpm % n != 0) {
                newString.append(string.charAt(i));
            } else if (maintainSpacing) {
                newString.append(' ');
            }
        }
        return newString.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (startWord > endWord || startWord <= 0 || endWord <= 0) {
            throw new IllegalArgumentException("Invalid index");
        }

        String[] s = string.split(" ");

        if (endWord > s.length) {
            throw new IndexOutOfBoundsException("Out Of Bound");
        }

        String[] newString = new String[endWord - startWord + 1];
        int index = 0;

        for (int i = startWord - 1; i < endWord; i++) {
            newString[index] = s[i];
            index++;
        }

        return newString;
    }


    @Override
    public String restoreString(int[] indices) {
        int length = indices.length;
        if (indices == null || length != string.length() || string == null || string.isEmpty()) {
            return "";
        }
        char[] temp = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            temp[i] = string.charAt(i);
        }
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[indices[i]] = temp[i];
        }
        String newString = new String(result);
        return newString;
    }

}

