import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {
    private String value;

    @Override
    public String getString() {
        return value;
    }

    @Override
    public void setString(String string) {
        value = string;
    }

    @Override
    public int count() {
        if (value.trim() == "") return 0;
        return value.trim().split("\\s+").length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        char[] chars = value.toCharArray();
        String res = "";

        for (int i = 0; i < chars.length; i++) {

            if ( (i+1)%n != 0 ) res += chars[i];
            else if (maintainSpacing) res += " ";
        }
        return res;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        String[] words = value.trim().split("\\s+");
        if (value.trim() == "" || endWord < startWord || startWord > words.length) throw new IllegalArgumentException();
        return Arrays.copyOfRange(value.trim().split("\\s+"), startWord-1, endWord+1);
    }

    @Override
    public String restoreString(int[] indices) {
        if (value == null || indices.length != value.length()) throw new IllegalArgumentException();

        //output string
        String res = "";

        //string value to char array
        char[] chars = value.toCharArray();

        for (int index : indices) {
            if (index >= 0 && index < chars.length) res += chars[index];
            else throw new ArrayIndexOutOfBoundsException();
        }

        return res;
    }


}
