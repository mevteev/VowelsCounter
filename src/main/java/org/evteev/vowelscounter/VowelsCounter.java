package org.evteev.vowelscounter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class VowelsCounter 
{
	
	private Map<VowelsKey, LettersCounter> vowelsMap = new LinkedHashMap<>();
	private WordProcessor wordProcessor = new WordProcessor();
	
   
	public Map<VowelsKey, LettersCounter> getVowelsMap() {
		return vowelsMap;
	}

	/**
	 * Add new word to map
	 * @param word
	 */
	public void addWordToMap(String word) {
		int vowelIndex = wordProcessor.convertVowelsToIndex(word);
		VowelsKey key = new VowelsKey(vowelIndex, word.length());
		
		LettersCounter counter = vowelsMap.get(key);
		if (counter == null) {
			counter = new LettersCounter();
			vowelsMap.put(key, counter);
		}
		
		counter.addWord(wordProcessor.getVowelsCount(word));		
	}
	
	/**
	 * add several words to map
	 * @param text
	 */
	public void addText(String text) {
		Arrays.stream(text.split("[\\W]+")).forEach(this::addWordToMap);
	}
	
	/**
	 * get text representation of map entry
	 * @param key
	 * @param counter
	 * @return
	 */
	public String getEntryString(VowelsKey key, LettersCounter counter) {
		return key.toString() + " -> " + String.format(Locale.US, "%.2f", counter.getAverage());
	}
	
	public static void main(String[] args) {
		VowelsCounter vowelsCounter = new VowelsCounter();
		FileProcessor fileProcessor = new FileProcessor(vowelsCounter);
		
		fileProcessor.processFile();
		
		fileProcessor.writeFile();
		
	}


}
