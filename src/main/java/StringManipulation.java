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
    	 if (n <= 0) {
             throw new IllegalArgumentException("Error: n is less than or equal to 0");
         } 
    	 else if (string == null) {
             throw new NullPointerException("Error: String has not been initialized");
         } 
    	 else if (n > string.length()) {
             throw new IndexOutOfBoundsException("Error: n exceeds string length");
         }
    	 
    	 
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
        if (string == null) {
        	throw new NullPointerException("Error: string is not yet initialized");
        }
        String[] words = string.trim().split("\\s+");
        if(startWord <= 0 || endWord <= 0) {
        	throw new IllegalArgumentException("Error: start index and end index is less than 1");
        }

        else if (startWord > endWord) {
            throw new IndexOutOfBoundsException("Error: start index is larger than end");
        }

        else if (endWord > words.length) {
            throw new IndexOutOfBoundsException("Error: end index is larger than the string length");
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
    	if (string == null) {
            throw new NullPointerException("Error: string is not yet initialized");
        }

        if (indices.length != string.length()) {
            throw new IllegalArgumentException("Error: string length is not equal to indices length");
        }
        for (int i = 0; i < indices.length - 1; i++) {     
            for (int j = i + 1; j < indices.length; j++) {
                if (indices[i] == indices[j]) {
                    throw new IllegalArgumentException("Error: some indexes are not unique");
                }
            }
        }
        
        char[] restored = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
        	
            restored[i] = string.charAt(indices[i]);
        }
        return new String(restored);
    }
}