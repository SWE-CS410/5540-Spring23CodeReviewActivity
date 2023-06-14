import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation implements StringManipulationInterface {
    protected String current = "";
    @Override
    public String getString() {
        return Objects.equals(current, "") ? null:current;
    }

    @Override
    public void setString(String string) {
        current = string;
    }

    @Override
    public int count() {
        int words = 0;
        Pattern p = Pattern.compile("([\\w-]{2,}|[aA])");
        Matcher m = p.matcher(getString());

        while (m.find()){
            System.out.println(m.group(1));
            if(m.group(1).chars().allMatch(Character::isAlphabetic)) {
                words++;
            }
        }
        System.out.println(words);
        return words;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if(n > getString().length()){
            throw new IndexOutOfBoundsException("n may not be > length of current string");
        } else if (n < 1) {
            throw new IllegalArgumentException("n cannot be less than/equal to 0");
        }
        String str = getString();


        if(!maintainSpacing) {
            int j = 0;
            char arr[] = new char[getString().length() - (getString().length() / n)];
            for (int i = 1; i <= getString().length(); i++) {
                if ((i % n) != 0) {
                    arr[j] = str.charAt(i - 1);
                    j++;
                }
            }
            return String.copyValueOf(arr);
        } else {
            char arr[] = new char[getString().length()];
            int j = 0;
            for(int i = 1; i <= getString().length(); i++){
                if((i % n) == 0){
                    arr[i-1] = ' ';
                } else {
                    arr[i-1] = str.charAt(i-1);
                }
            }
            return String.copyValueOf(arr);
        }
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord < 1 && endWord > count()){
            throw new IllegalArgumentException("Index of first word cannot be <= 0. Index of last word cannot be > " + count() + ".");
        } else if (startWord > endWord) {
            throw new IllegalArgumentException("Index of first word may not be > index of last word.");
        } else if (count() < endWord) {
            throw new IndexOutOfBoundsException("String has fewer than " + endWord + " words in it.");
        }
        int words = 1;
        Pattern p = Pattern.compile("([\\w-]{2,}|[aA])");
        Matcher m = p.matcher(getString());
        String arr[] = new String[endWord - startWord + 1];

        int match = 0;
        while (m.find() && words <= getString().length() && match < arr.length){
            if(m.group(1).chars().allMatch(Character::isAlphabetic) && words >= startWord) {
                arr[match] = m.group(1);
                match++;
            }
            words++;
        }
        return arr;
    }
    @Override
    public String restoreString(int[] indices){
        if(getString().length() != indices.length){
            throw new IllegalArgumentException("indices length (" + indices.length + ") may not exceed string length (" + getString().length() + ".");
        } else {
            for(int i = 0; i < indices.length; i++){
                if((indices[i] < 0) || (indices[i] > getString().length())){
                    throw new IndexOutOfBoundsException("indices may not contain values that are not common to String[] indices.");
                }
            }
        }
        char arr[] = new char[getString().length()];
        for (int i = 0; i < getString().length(); i++){
            arr[i] = getString().charAt(indices[i]);
        }
        return String.copyValueOf(arr);
    }


}
