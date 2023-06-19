public class StringManipulation implements StringManipulationInterface {

    private String myString;
    @Override
    public String getString() {
        if(myString==null) {
            return null;
        }

        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public int count() {

        if(myString==null || myString.isEmpty()){
            return 0;
        }

        String[] words = myString.split("\\s+");
        return words.length;
    }



    @Override
    public StringBuilder removeNthCharacter(int n, boolean maintainSpacing) {

        //special cases that for exceptions
        if (n > myString.length()) {
            throw new IndexOutOfBoundsException("Indexs Out of bounds");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("integer n cannot be lower than 0");
        }
        //build a string from characters
        StringBuilder newWord = new StringBuilder();
        //loop through my string and remove every multiple character of n
        for(int i=0; i < myString.length(); i++) {

            if ((i + 1) % n != 0){
                newWord.append(myString.charAt(i));

            }
            //add a space otherwise
            else if(maintainSpacing==true){
                newWord.append(" ");
            }
        }

        return new StringBuilder(newWord.toString());
    }    @Override
    public String[] getSubStrings(int startWord, int endWord){


        //special cases
        if(startWord <=0 || endWord <=0 || startWord > endWord){
            throw new IllegalArgumentException("invalid parameters");

        }
        if(myString.length() < endWord){
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        //create new array of just wanted words split by space
        String[] shortWord = myString.split("\\s");

        //condition to grab substring from begining start to end of wanted
        if(startWord >0 && startWord <= myString.length() && endWord >0 && endWord <=myString.length() && startWord <=endWord){
            //build new string
            StringBuilder extracted= new StringBuilder();

            for(int i=startWord-1; i < endWord;i++){
                extracted.append(shortWord[i]);
                if(i < endWord-1){
                    extracted.append(" ");
                }

            }
            return new String[]{extracted.toString()};
        }else{
            return null;
        }


    }


    @Override
    public String restoreString(int[] indices){

        //special cases to throw illegal arguments
        if(myString.length() != indices.length){
            throw new IllegalArgumentException("length of string and indices not the same");

        }

        for(int i = 0; i < indices.length;i++){
            if (indices[i] <0 || indices[i] > myString.length()){
                throw new IndexOutOfBoundsException("index out of bounds");
            }
        }

        //make a new array of words
        char[] restored = new char[myString.length()];
        //loop through to add to array in order
        for(int i =0; i < indices.length;i++){
            int index = indices[i];
            char value = myString.charAt(i);
            restored[index]= value;
        }
        //make new word
        StringBuilder sb = new StringBuilder();
        for(char c: restored){
            sb.append(c);
        }


        return sb.toString();
    }
}
