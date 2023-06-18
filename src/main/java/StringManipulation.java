import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringManipulation implements StringManipulationInterface {
    private String message;

    @Override
    public String getString() {
        return message;
    }

    @Override
    public void setString(String string) {
        message = string;
    }

    @Override
    public int count() {
        int counting = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                if (counting == 0) {
                    if (i > 0 && message.charAt(i - 1) != ' ') {
                        counting = 1;
                    }
                }
                if (i + 1 < message.length() && message.charAt(i + 1) != ' ') {
                    counting++;
                }
            }
        }
        return counting;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        if (n > message.length()) {
            throw new IndexOutOfBoundsException("N is greater than string length!");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("N is less than or equal to 0");
        }

        List<String> array = new ArrayList<>(message.length() + n - 1);

        for (int start = 0; start < message.length(); start += n) {
            array.add(message.substring(start, Math.min(message.length(), start + n)));
        }

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).length() == n) {
                String temp = array.get(i);
                temp = temp.substring(0, n - 1);
                if (maintainSpacing) {
                    temp = temp + " ";
                }
                array.set(i, temp);
            }
        }
        String a = "";
        for (int i = 0; i < array.size(); i++) {
            a = a + array.get(i);
        }
        return a;
    }


    @Override
    public String[] getSubStrings(int startWord, int endWord) {

        if (startWord <= 0 ||endWord <= 0 || startWord >endWord) {
            throw new IllegalArgumentException("Invalid endWord/startWord");
        }

        if (count() < endWord) {
            throw new IndexOutOfBoundsException("String has less words than endWords amount in it!");
        }

        String after = message.trim().replaceAll(" +", " ");

        List<String> wordArrayList = new ArrayList<String>();
        for (String word : after.split(" ")) {
            wordArrayList.add(word);
        }
        int test = wordArrayList.size();
        String[] tempStringArray = new String[test];

        for (int i = 0; i < test; i++) {
            tempStringArray[i] = wordArrayList.get(i);
        }
        String[] finalStringArray = new String[endWord - startWord + 1];
        int count = 0;
        for (int i = startWord - 1; i < endWord; i++) {
            finalStringArray[count++] = tempStringArray[i];
        }
        return finalStringArray;
    }

    @Override
    public String restoreString(int[] indices) {

        if (message.length()!=indices.length){
            throw new IllegalArgumentException("Cannot have indices array of different length than message size!");
        }

        //This turns message into a character array piece by piece.
        char [] charArray = message.toCharArray();

        //HashMap contains index in key, and associated value from message.
        HashMap<Integer, Character> map = new HashMap<>();

        for (int i = 0; i<message.length(); i++) {
            map.put(i, charArray[i]);
        }
        String finalString = "";
        for (int i = 0; i<message.length(); i++){
            if (indices[i]<0 || indices[i]>=message.length()){
                throw new IndexOutOfBoundsException("Cannot have negative index values for indices array");
            }
            finalString = finalString + map.get(indices[i]);
        }
        return finalString;
    }
}