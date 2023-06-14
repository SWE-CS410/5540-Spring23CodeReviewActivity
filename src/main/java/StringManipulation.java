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

        /*
        String str=myString.toString();
        String resultStr="";
        //loop execute till the length of the string
        for (int i=0;i<str.length();i++)
        {

            if (str.charAt(i)>64 && str.charAt(i)<=122)
            {

                resultStr=resultStr+str.charAt(i);
            }
        }
        return resultStr;
        */
        return null;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
      /* String [] words = myString.split("\\s+");
        String [] words = myString.split(" ");
        for(String word : words) {
            System.out.println(word);
        } */

       return null;
    }

    @Override
    public String restoreString(int[] indices){
        StringBuilder res = new StringBuilder(myString);
        for(int i =0; i < indices.length; ++i)
            res.setCharAt(indices[i],myString.charAt(i));
        return res.toString();
    }


}
