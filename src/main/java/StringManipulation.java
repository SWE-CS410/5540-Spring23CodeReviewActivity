public class StringManipulation implements StringManipulationInterface {
    private String myString;

    @Override
    public String getString() {
        return null;
    }

    @Override
    public void setString(String string) {
        this.myString = string;
    }

    @Override
    public int count() {
        if(myString == null){
            return 0;
        }

        int countWords = 0;
        if(myString.equals("")){
            return countWords;
        }

        String removeSpace = myString.trim();
        for(String word : removeSpace.split("\\s+")){
            if(removeSpace.equals(""))
                return 0;
            countWords++;
        }

        return countWords;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (myString.equals("")) {
            return myString;
        } else if(myString == null){
            throw new NullPointerException("String is null.");
        } else if(n <= 0){
            throw new IllegalArgumentException("n cannot be less than or equal to zero");
        } else if(n > myString.length()){
            throw new IndexOutOfBoundsException("n cannot be greater than string length");
        } else if(n == 1 && maintainSpacing){
            return myString;
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);

            if (maintainSpacing) {
                count++;

                if (count % n != 0) {
                    result.append(c);
                } else {
                    result.append(' ');
                }
            } else {
                count++;
                if (count % n != 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if(myString == null) {
            throw new NullPointerException("String is null.");
        } else if(startWord > endWord){
            throw new IllegalArgumentException("startWord cannot be greater than endWord.");
        } else if(startWord <= 0){
            throw new IllegalArgumentException("startWord cannot be less than or equal to 0.");
        } else if(endWord <= 0){
            throw new IllegalArgumentException("endWord cannot be less than or equal to 0.");
        }

        //handles exception for endWord># of words in string
        String[] words = myString.split("\\s+");
        if(endWord > words.length){
            throw new IndexOutOfBoundsException("endWord is greater than length of string.");
        }

        int size = endWord - startWord + 1;
        String[] result = new String[size];
        int index = 0;

        for (int i = startWord-1; i < endWord; i++) {
            result[index] = words[i];
            index++;
        }

        return result;
    }

    @Override
    public String restoreString(int[] indices){
        if(indices.length != myString.length()){
            throw new IllegalArgumentException("Indices length does not equal string's length");
        } else if(myString == null){
            throw new NullPointerException("String is null.");
        }

        StringBuilder result = new StringBuilder(myString.length());

        for(int index : indices){

            if(index < 0 || index > myString.length()){
                throw new IndexOutOfBoundsException("Indices length cannot be less than 0");
            } else if(myString.equals("")){
                return result.toString();
            } else {
                result.append(myString.charAt(index));
            }
        }

        return result.toString();
    }

}
