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

        String trimmedString = string.trim();
        if (trimmedString.isEmpty()) {
            return 0;
        }

        // Split the string by whitespace to get individual words
        String[] words = trimmedString.split("\\s+");

        return words.length;
    }



    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
    	StringBuilder result = new StringBuilder();
        int count = 0;  
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            count++;
                if (count % n == 0 && maintainSpacing) {
                result.append(' ');
            }    
            if (count % n != 0) {
                result.append(currentChar);
            }


        }
        
        return result.toString();
        }





    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (string == null || startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException();
        }

        String[] words = string.trim().split("\\s+");

        if (endWord > words.length) {
            throw new IndexOutOfBoundsException();
        }

        int substringsCount = endWord - startWord + 1;
        String[] substrings = new String[substringsCount];

        int index = 0;
        for (int i = startWord - 1; i < endWord; i++) {
            substrings[index++] = words[i];
        }

        return substrings;
    }

    @Override
    public String restoreString(int[] indices) {
        char[] restored = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            restored[i] = string.charAt(indices[i]);
        }
        return new String(restored);
    }
}