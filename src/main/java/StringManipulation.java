import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringManipulation implements StringManipulationInterface {

    String s;
    @Override
    public String getString() {
        return s;
    }

    @Override
    public void setString(String string) {
        s = string;
    }

    @Override
    public int count() {
        if (s == null || s.isEmpty())
            return 0;
        return s.split("\\s+").length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n > s.length()) {
            throw new IndexOutOfBoundsException();
        }
        StringBuilder result = new StringBuilder();
        if(maintainSpacing){
            result.append(s);
            for (int i = n - 1; i < s.length(); i += n) {
                result.setCharAt(i, ' ');
            }
        } else {
            int prev = 0;
            for (int i = n - 1; i < s.length(); i += n) {
                result.append(s, prev, i);
                prev = i + 1;
            }
            result.append(s, prev, s.length());
        }
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if(startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException();
        }
        String[] words = s.split("\\s+");
        if(words.length < endWord) {
            throw new IndexOutOfBoundsException();
        }
        return Arrays.copyOfRange(words, startWord - 1, endWord);
    }

    @Override
    public String restoreString(int[] indices){
        if(indices.length != s.length() || duplicates(indices)){
            throw new IllegalArgumentException();
        }
        char[] ch = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return String.valueOf(ch);
    }

    private boolean duplicates(int[] ints)
    {
        Set<Integer> DT = new HashSet<>();
        for (int i : ints)
        {
            if (DT.contains(i))
                return true;
            DT.add(i);
        }
        return false;
    }

}
