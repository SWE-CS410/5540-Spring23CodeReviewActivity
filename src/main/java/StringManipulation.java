import java.util.ArrayList;
import java.util.*;

public class StringManipulation implements StringManipulationInterface {
    
    public String stored;
    
    @Override
    public String getString() {
        return stored;
    }

    @Override
    public void setString(String string) {
        stored = string;
    }

    @Override
    public int count() {
        if(stored == null || stored.isEmpty()) {
            return 0;
        }
        String[] words = stored.split("\\s+");
        return words.length; 
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        //throw cases
        if(n > stored.length()) {
            throw new IndexOutOfBoundsException("IndexOB");
        } else if(n <= 0) {
            throw new IllegalArgumentException("IllegalArg");
        }        
        
        String result;
        
        char[] broken = stored.toCharArray();
        ArrayList<Character> letters = new ArrayList<Character>();
        for(char c : broken) {
            letters.add(c);
        }

        for(int i = n - 1; i < letters.size(); i += n) {
            if(maintainSpacing) {
                letters.set(i, ' ');
            } else {
                letters.remove(i);
                i -= 1; //to accomodate removing a letter
            }
        }
        
        broken = new char[letters.size()];
        for(int i = 0; i < letters.size(); i++) {
            broken[i] = letters.get(i);
        }
        result = new String(broken);
        return result;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        //throw cases
        if(startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IndexOutOfBoundsException("IndexOB");
        }
        
        String[] words = stored.split("\\s+");

        if(words.length < endWord) {
            throw new IllegalArgumentException("IllegalArg");
        }

        String[] searchedWords;
        boolean inSelection = false;
        ArrayList<String> returns = new ArrayList<String>();

         
        for(int i = 0; i < words.length; i++) {
            if(i == startWord - 1) {
                returns.add(words[i]);
                inSelection = true;
            } else if(i == endWord - 1) {
                returns.add(words[i]);
                inSelection = false;
            } else if(inSelection) {
                returns.add(words[i]);
            }
        }
        //searchedWords = returns.toArray(); //this probably dont work?
        searchedWords = new String[returns.size()];
        for(int i = 0; i < returns.size(); i++) {
            searchedWords[i] = returns.get(i);
        }

        return searchedWords;
    }

    @Override
    public String restoreString(int[] indices){
        
        //throw cases
        if(stored.length() != indices.length) {
            throw new IllegalArgumentException("IllegalArg");
        }
        
        //make a char array of the stored string 
        char[] newString = new char[indices.length];
        for(int i = 0; i < indices.length; i++) {
            if(indices[i] < 0 || indices[i] > stored.length()) {
                throw new IndexOutOfBoundsException("IndexOB");
            }
            newString[i] = stored.charAt(indices[i]);
        }
        
        //turn newString into an actual string
        String result = new String(newString);
        return result;
    }


}
