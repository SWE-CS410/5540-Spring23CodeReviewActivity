import java.io.*;
import java.util.StringTokenizer;


public class StringManipulation implements StringManipulationInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public int count() {
        if(myString == null){
            return 0;
        } else {
            StringTokenizer tokens = new StringTokenizer(myString);
            return tokens.countTokens();
        }
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        if(n > getString().length()){
            throw new IndexOutOfBoundsException("n cannot have greater length than the current string");
        } else if (n < 1) {
            throw new IllegalArgumentException("n can't be <= 0");
        }
        String strng = getString();


        if(!maintainSpacing) {
            int j = 0;
            char arr[] = new char[getString().length() - (getString().length() / n)];
            for (int i = 1; i <= getString().length(); i++) {
                if ((i % n) != 0) {
                    arr[j] = strng.charAt(i - 1);
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
                    arr[i-1] = strng.charAt(i-1);
                }
            }
            return String.copyValueOf(arr);
        }
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if(myString == null) {
            throw new NullPointerException("String is null.");
        } else if(startWord > endWord){
            throw new IllegalArgumentException("startWord can't be > endWord.");
        } else if(startWord <= 0){
            throw new IllegalArgumentException("startWord cannot <= 0");
        } else if(endWord <= 0){
            throw new IllegalArgumentException("endWord cannot be <= to 0.");
        }

        //here we are handling the exception for endWord># of words in string
        String[] words = myString.split("\\s+");
        if(endWord > words.length){
            throw new IndexOutOfBoundsException("endWord is greater than the length of string.");
        }

        int s = endWord - startWord + 1;
        String[] result = new String[s];
        int index = 0;

        for (int i = startWord-1; i < endWord; i++) {
            result[index] = words[i];
            index++;
        }

        return result;
    }

    @Override
    public String restoreString(int[] indices){
        StringBuilder res = new StringBuilder(myString);
        for(int i =0; i < indices.length; ++i)
            res.setCharAt(indices[i],myString.charAt(i));
        return res.toString();
    }


}
