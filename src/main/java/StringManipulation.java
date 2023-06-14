public class StringManipulation implements StringManipulationInterface {
    private String internalString;

    // This implementation uses a cache which maintains a list of all words in the string.
    // This cache is invalid at any time that the internal string is modified.
    // Since right now we will have no subclasses, whether or not the cache is valid is easily
    // maintained.
    // In a more professional enviroment, maintaining cache validation would be mandatory.
    private String[] wordListCache;

    /**
     * Generates or regenerated the internal cache of words in the string.
     * You must call this method every time the internal string is modified!
     */
    private void genWordListCache() {
        // Splits the string by words.
        // Matches any cluster of non-whitespace characters.
        // Note that split() splits BY what the regex identifies, and does not return the output of the regex.
        // Alert! This returns the original string if there is no delimiter!
        wordListCache = internalString.split("\\s"); 

        // Because split returns the original string on no delimiter, it incorrectly counts empty strings.
        // Detect this by checking for a single-string array containing only a empty string.
        if (wordListCache[0].matches("") && wordListCache.length == 1) {
            wordListCache = new String[0];
        }
    }
    
    @Override
    public String getString() {
        return internalString;
    }

    @Override
    public void setString(String string) {
        internalString = string;
        genWordListCache();
    }

    @Override
    public int count() {
        if (wordListCache == null) {
            throw new NullPointerException("No word list cache is available or string was not set!");
        }
        return wordListCache.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (internalString == null) {
            throw new NullPointerException("String was not set!");
        }
        else if (n > internalString.length()) {
            throw new IndexOutOfBoundsException("Removal count is greater than the length of the string (%s).".formatted(internalString.length()));
        }
        else if (n < 1) {
            throw new IllegalArgumentException("Removal count is less than 1.");
        }

        StringBuilder builder;
        // If we maintain spacing, we can copy the string to the builder and replace.
        if (maintainSpacing) {
            builder  = new StringBuilder(internalString);
            for(int i = 1; i * n - 1 <= builder.length(); i++) {
                builder.setCharAt(i * n - 1, ' ');
            }
        }
        // Otherwise, we need to copy bit by bit from the original in order to not lose our step.
        // If we tried the same trick as with maintained spacing, we'd lose our place rapidly.
        else {
            builder = new StringBuilder();
            for (int i = 0; i <= internalString.length(); i++) {
                if (i % n != 0) {
                    builder.append(internalString.charAt(i - 1));
                }
            }
        }

        return builder.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (wordListCache == null) {
            throw new NullPointerException("No word list cache is available or string was not set!");
        }
        else if (endWord < startWord) {
            throw new IllegalArgumentException("endWord cannot be less than startWord.");
            
        }
        else if (startWord < 1) {
            throw new IllegalArgumentException("startWord cannot be less than 1.");
            
        }
        else if (endWord < 1) {
            throw new IllegalArgumentException("endWord cannot be less than 1.");
            
        }
        else if (endWord < count()) {
            throw new IndexOutOfBoundsException("endWord is greater than the number of words in the string (%s).".formatted(count()));
        }

        String[] result = new String[endWord - startWord + 1];

        for (int i = 0; i <= endWord - startWord; i++) {
            result[i] = wordListCache[startWord - 1 + i];
        }
        
        return result;
    }

    @Override
    public String restoreString(int[] indices){
         if (internalString == null) {
            throw new NullPointerException("String was not set!");
        }
        else if (indices.length != internalString.length()) {
            throw new IllegalArgumentException("Indices array must be exactly as long as the string (%s).".formatted(internalString.length()));
        }

        // Defer index checks until we're trying to build the string.
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0) {
                throw new IndexOutOfBoundsException("Index at %s is less than 0.".formatted(i));
            }
            else if (indices[i] > internalString.length()){
                throw new IndexOutOfBoundsException("Index at %s is greater than the length of the string (%s).".formatted(i, internalString.length()));
            }

            builder.append(internalString.charAt(indices[i]));
        }
        return builder.toString();
    }


}
