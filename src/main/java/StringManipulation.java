public class StringManipulation implements StringManipulationInterface {
	@Override
	public String getString() {
		if (this.string != null) {
			return this.string;
		}

		return null;
	}

	@Override
	public void setString(String string) {
		this.string = string;
	}

	@Override
	public int count() {
		String words = this.string.trim();
		if (!words.isEmpty()) {
			return words.split("\\s+").length;
		}
		return 0;
	}

	@Override
	public String removeNthCharacter(int n, boolean maintainSpacing) {
		char letter = this.string.charAt(n);
		if (maintainSpacing)
		{
			this.string = this.string.replace(letter, " ");
			return this.string;
		}
		else
		{
			this.string = this.string.replace(letter, "");
			return this.string;
		}
		return null;
	}

	@Override
	public String[] getSubStrings(int startWord, int endWord) {
	    String[] words = this.string.split(" ");

	    if (startWord <= 0 || endWord <= 0 || startWord > endWord) 
	    {
	        throw new IllegalArgumentException("Invalid startWord or endWord.");
	    }

	    if (endWord > words.length) 
	    {
	        throw new IndexOutOfBoundsException("The string has less than endWord words.");
	    }

	    int numSubStrings = endWord - startWord + 1;
	    String[] subStrings = new String[numSubStrings];

	    for (int i = startWord - 1; i <= endWord - 1; i++) 
	    {
	        subStrings[i - startWord + 1] = words[i];
	    }

	    return subStrings;
	}

	@Override
	public String restoreString(int[] indices) {
	    if (this.string.length != indices.length) 
	    {
	        throw new IllegalArgumentException("Indices lengths do not match");
	    }

	    char[] shuffledWords = new char[indices.length];

	    for (int i = 0; i < indices.length; i++) 
	    {
	        int index = indices[i];
	        if (index < 0 || index >= indices.length) 
	        {
	            throw new IndexOutOfBoundsException("Invalid index: " + index);
	        }
	        shuffledWords[index] = s.charAt(i);
	    }

	    return new String(shuffledWords);
	}

}
