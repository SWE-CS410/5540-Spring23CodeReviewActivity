import java.util.*;
import java.lang.String;


public class StringManipulation implements StringManipulationInterface {

    private String manipulatedstring;
    @Override
    public String getString() {
        return manipulatedstring;
    }

    @Override
    public void setString(String string) { manipulatedstring = string;}


    @Override
    public int count() {
        int wordCount = 0;
        if (manipulatedstring == "") {
            return wordCount;
        }
        String trimmedString = manipulatedstring.trim();

        wordCount++;

        char[] charArray = trimmedString.toCharArray();
        for (char c : charArray) {
            if (c == ' ') {wordCount++;}
        }
        return wordCount;
    } // END public int count() -----------------------------------------------------------------------------------|

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        char[] charArray = manipulatedstring.toCharArray();
        char[] newCharArray = new char[charArray.length];

        if (n == 1 && maintainSpacing == false){return "";}

        int numRemovals = 1;

        for (int i = 1; i < charArray.length + 1; i++){
            if (i == (n*numRemovals)) {
                if (maintainSpacing == true){
                    charArray[i - 1] = ' ';
                    newCharArray[i - 1] = charArray[i - 1];
                } else{
                    newCharArray[i - numRemovals] = charArray[i];
                    i++;
                }
            numRemovals++;
            } else{
                if (maintainSpacing == true){
                    newCharArray[i-1] = charArray[i-1];
                } else{
                    newCharArray[i-numRemovals] = charArray[i-1];
                }
            }
        }
        String finalString = String.copyValueOf(newCharArray);
        if (maintainSpacing == true){
            return finalString;
        }else{
            return finalString.trim();
        }
    } // END public String removeNthCharacter(int n, boolean maintainSpacing) -------------------------------------|

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<Character> cl = new ArrayList<Character>();

        for (int i = 0; i <manipulatedstring.length(); i++){
            for (int x = i; x <manipulatedstring.length(); x++) {

                char c = manipulatedstring.charAt(x);
                if ((c == ' ') || (c == '.') || (c == ',') || (c == ':') || (c == ';') || (c == '"')) {
                    break;
                }
                cl.add(c);
            }
            if (cl.size() == 0){continue;}
            StringBuilder builder = new StringBuilder(cl.size());
            for (Character ch: cl){
                builder.append(ch);
            }

            al.add(builder.toString());
            i = i + cl.size();
            cl.clear();
        }
        String [] requestedWords = new String[endWord-startWord+1];
        for (int i = 0; i < requestedWords.length; i++){
            requestedWords[i] = al.get(startWord-1+i);
        }
        return requestedWords;
    } // END public String[] getSubStrings(int startWord, int endWord) --------------------------------------------|

    @Override
    public String restoreString(int[] indices){
        char[] initCharArray = manipulatedstring.toCharArray();
        char[] shuffledCharArray = new char[manipulatedstring.length()];

        for (int i = 0; i < indices.length; i++){
            shuffledCharArray[i] = initCharArray[indices[i]];
        }
        String shuffledString = String.copyValueOf(shuffledCharArray);
        return shuffledString;
    }

}
