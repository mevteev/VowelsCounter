package org.evteev.vowelscounter;

public class WordProcessor {
	
	/**
	 * convert vowels to sum of their binary representations
	 * @param word
	 * @return
	 */
	public int convertVowelsToIndex(String word) {
		return word.toLowerCase().chars()
				.map(this::mapCharToByte)
				.filter(i -> (i > 0))
				.distinct()
				.sorted()
				.sum();
	}
	
	/**
	 * convert binary representation to array of vowels
	 * @param value
	 * @return
	 */
	public char[] convertIntToVowels(int value) {
		StringBuffer strVowels = new StringBuffer();
		
		for (int i = 1; i < 33; i*=2) {
			if ((value & i) > 0)
				strVowels.append(mapByteToChar(i));
		}
		
		return strVowels.toString().toCharArray();
	}
	
	/**
	 * counts vowels in the word
	 * @param word
	 * @return
	 */
	public int getVowelsCount(String word) {
		return (int) word.chars().filter(this::isVowel).count();
	}
	
	/**
	 * map character to byte representation
	 * @param ch 
	 * @return 2^n for vowels, 0 otherwise
	 */
	private int mapCharToByte(int ch) {
		switch (ch) {
			case 'a' : return 1;
			case 'e' : return 2;
			case 'i' : return 4;
			case 'o' : return 8;
			case 'u' : return 16;
			case 'y' : return 32;
			default : return 0;
		}
	}
	
	/** convert byte representation to character
	 * 
	 * @param b
	 * @return
	 */
	private char mapByteToChar(int b) {
		switch (b) {
			case 1 : return 'a';
			case 2 : return 'e';
			case 4 : return 'i';
			case 8 : return 'o';
			case 16 : return 'u';
			case 32 : return 'y';
			default : return ' ';
		}
	}
	
	/**
	 * is character vowel
	 * @param ch
	 * @return
	 */
	private boolean isVowel(int ch) {
		return mapCharToByte(ch) > 0;
	}

}
