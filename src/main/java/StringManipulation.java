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
        wordListCache = internalString.split("[\\s^]"); // Splits the string by words.
    }                                                         // Matches any cluster of non-whitespace characters.
                                                              // Note that split() splits BY what the regex identifies,
                                                              // and does not return the output of the regex.
    

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
        return wordListCache.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        return null;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        return null;
    }

    @Override
    public String restoreString(int[] indices) {
        return null;
    }


}
