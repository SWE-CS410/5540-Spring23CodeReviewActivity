//Khalil Coats
//CS 410
//06/11/2023
//JUnit Testing, StringManipulation implementation class

public class StringManipulation implements StringManipulationInterface {
	
	private String objString;
    
	@Override
    public String getString() {
        return objString;
    }

    @Override
    public void setString(String string) {
    	objString = string;
    }
    
	@Override
    public int count() {
    	
    	String[] words = this.getString().split(" +");
    	int wordCount = words.length;
    	return wordCount;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) 
    {
    	if(n <= 0)
    	{
    		throw new IllegalArgumentException("n must be at least 1.");
    	}
    	else if(n > this.getString().length()-1)
    	{
    		throw new IndexOutOfBoundsException("index out of bounds");
    	}
    	else 
    	{
    		if(maintainSpacing)
    		{
    			char[] objChars = this.getString().toCharArray();
    			for(int i = n; i <= this.getString().length(); i+=n)
    			{
    				objChars[i-1] = ' ';
    			}
    			this.setString(String.valueOf(objChars));
    		}
    		else if(!maintainSpacing)
    		{
    			String newStr = "";
    			for(int i = n-1; i < this.getString().length(); i+=(n-1))
    			{
    				newStr = this.getString().substring(0, i) + this.getString().substring(i+1);
    				this.setString(newStr);
    			}
    		}
    	}
        return this.getString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord)
    {
    	String words[] = this.getString().split("\\W+");
    	String returnList[];
    	if(startWord <= 0 || endWord <= 0)
    	{
    		throw new IllegalArgumentException("Word position argument must be positive nonzero number.");
    	}
    	else if(startWord > endWord)
    	{
    		throw new IllegalArgumentException("upper bound greater than lower bound");
    	}
    	else if(endWord > this.count())
    	{
    		throw new IndexOutOfBoundsException("upper bound or lower is greater than word count");
    	}
    	else
    	{
    		returnList = new String[endWord-startWord+1];
    		int loopStart = startWord;
    		for(int i = 0; i < endWord- startWord+1; i++)
    		{
    			returnList[i] = words[loopStart - 1 + i];
    			System.out.println(returnList[i]);
    		}
    		
    	}
        return returnList;
    }

    @Override
    public String restoreString(int[] indices){
    	String restore = "";
    	for(int i = 0; i < indices.length; i++)
    	{
    		if(indices[i] < 0 || indices[i] >= this.getString().length())
    		{
    			throw new IndexOutOfBoundsException("one of the indices is out of array bounds");
    		}
    	}
    	
    	if(indices.length != this.getString().length())
    	{
    		throw new IllegalArgumentException("Illegal argument passed. Array argument length doesn't match string length");
    	}
    	else
    	{
    		char[] newChars = new char[this.getString().length()];
    		for(int i = 0; i <this.getString().length();i++)
    		{
    			newChars[i] = this.getString().charAt(indices[i]);
    		}
    		restore = (String.valueOf(newChars));
    	}
    	
        return restore;
    }


}
