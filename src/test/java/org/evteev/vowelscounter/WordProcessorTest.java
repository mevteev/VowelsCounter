package org.evteev.vowelscounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class WordProcessorTest {
	
	WordProcessor wordProcessor;
	
	public WordProcessorTest() {
		wordProcessor = new WordProcessor();
	}
	
	@Test
	public void convertVowelsTest() {
		assertEquals(0, wordProcessor.convertVowelsToIndex(""));
		assertEquals(9, wordProcessor.convertVowelsToIndex("Platon"));
		assertEquals(3, wordProcessor.convertVowelsToIndex("made"));
		assertEquals(9, wordProcessor.convertVowelsToIndex("bamboo"));
		assertEquals(9, wordProcessor.convertVowelsToIndex("boats"));
		assertEquals(63, wordProcessor.convertVowelsToIndex("boatsuiaefcdaoiueyy"));
	}
	
	@Test
	public void convertByteTest() {
		assertTrue(Arrays.equals(wordProcessor.convertIntToVowels(0), new char[] {}));
		assertTrue(Arrays.equals(wordProcessor.convertIntToVowels(3), new char[] {'a', 'e'}));
		assertTrue(Arrays.equals(wordProcessor.convertIntToVowels(9), new char[] {'a', 'o'}));
		assertTrue(Arrays.equals(wordProcessor.convertIntToVowels(63), new char[] {'a','e','i','o','u','y'}));
	}
	
	@Test
	public void testVowelsCount() {
		assertEquals(2, wordProcessor.getVowelsCount("Platon"));
		assertEquals(3, wordProcessor.getVowelsCount("bamboo"));
	}
}
