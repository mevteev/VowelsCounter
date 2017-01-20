package org.evteev.vowelscounter;

import java.util.Arrays;

/**
 * key of map
 * @author mike
 *
 */
public class VowelsKey {
	
	private int vowelIndex;	//vowel index
	private int count; 		//number of letters in word
	
	public int getVowelIndex() {
		return vowelIndex;
	}
	public void setVowelIndex(int vowelIndex) {
		this.vowelIndex = vowelIndex;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public VowelsKey(int index, int count) {
		this.vowelIndex = index;
		this.count = count;
	}
	
	public VowelsKey(String word) {
		this(new WordProcessor().convertVowelsToIndex(word), word.length());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + vowelIndex;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VowelsKey other = (VowelsKey) obj;
		if (count != other.count)
			return false;
		if (vowelIndex != other.vowelIndex)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "(" + Arrays.toString(new WordProcessor().convertIntToVowels(vowelIndex)).replace("[", "{").replace("]", "}")
			+ ", " + count + ")";
	}
	
	
}
