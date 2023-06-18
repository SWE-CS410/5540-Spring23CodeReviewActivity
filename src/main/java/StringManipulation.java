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

        if (this.string == null){
            throw new NullPointerException("NullPointerException");
        }

        if (this.string.isEmpty()){
            return 0;
        }

        String[] result = this.string.split("\s+");
        int word = 0;
        for (String current : result) {
            if (!current.isEmpty()) {
                word++;
            }
        }
        return word;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        if (this.string == null || this.string.isEmpty()){
            throw new NullPointerException("NullPointerException");
        }
        int length = string.length();

        if (n > string.length()) {
            throw new IndexOutOfBoundsException("Out Of Bound");
//            System.out.println("Out Of Bound");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid");
        }

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < length; index++) {
            int compare = index + 1;

            if (compare % n != 0) {
                result.append(string.charAt(index));

            } else if (maintainSpacing == true) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord");
        }
        //String sentence = "This is an example sentence";
        String[] words = this.string.split(" ");

        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("Not enough words in the sentence");
        }

        String[] subStrings = new String[endWord - startWord + 1];
        int index = 0;

        for (int i = startWord - 1; i < endWord; i++) {
            subStrings[index] = words[i];
            index++;
        }

        return subStrings;
    }


    @Override
    public String restoreString(int[] indices) {
        if (this.string.isEmpty()){
            return "";
        }

        if ( indices.length != string.length()) {
            throw new IllegalArgumentException("Invalid");
        }

        if (string == null || indices == null) {
            throw new NullPointerException("NullPointerException");
        }

        char[] restoredChars = new char[string.length()];

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index < 0 || index >= string.length()) {
                throw new IndexOutOfBoundsException("Not enough words in the sentence");
            }
            restoredChars[index] = string.charAt(i);
        }

        return new String(restoredChars);
    }

}

