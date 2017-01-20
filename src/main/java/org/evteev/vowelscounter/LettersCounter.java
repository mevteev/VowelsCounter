package org.evteev.vowelscounter;

/**
 * counter of vowels and words
 * used as Map value 
 * @author mike
 *
 */
public class LettersCounter {
	
	private int numVowels; //number of vowels
	private int numWords;  //number of words
	
	public int getNumVowels() {
		return numVowels;
	}
	public void setNumVowels(int numVowels) {
		this.numVowels = numVowels;
	}
	
	public int getNumWords() {
		return numWords;
	}
	public void setNumWords(int numWords) {
		this.numWords = numWords;
	}
	
	/**
	 * add new word to counter
	 * @param value num vowels
	 */
	public void addWord(int value) {
		numVowels += value;
		numWords++;
	}
	
	/**
	 * get average number of vowels in map entry
	 * @return
	 */
	public double getAverage() {
		if (numWords == 0)
			return 0;
		return numVowels / (double)numWords;
	}
}
