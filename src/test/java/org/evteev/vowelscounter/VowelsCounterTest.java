package org.evteev.vowelscounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class VowelsCounterTest {
	
	@Test
	public void checkAddWord() {
		VowelsCounter vowelsCounter = new VowelsCounter();
		vowelsCounter.addWordToMap("Platon");
		assertEquals(vowelsCounter.getVowelsMap().size(), 1);
		vowelsCounter.addWordToMap("Platon");
		assertEquals(vowelsCounter.getVowelsMap().size(), 1);
		
		LettersCounter counter = vowelsCounter.getVowelsMap().get(new VowelsKey("platon"));
		assertNotNull(counter);
		assertEquals(counter.getNumWords(), 2);
		assertEquals(counter.getNumVowels(), 4);
		
		vowelsCounter.addWordToMap("made");
		assertEquals(vowelsCounter.getVowelsMap().size(), 2);

		counter = vowelsCounter.getVowelsMap().get(new VowelsKey("made"));
		assertNotNull(counter);
		assertEquals(counter.getNumWords(), 1);
		assertEquals(counter.getNumVowels(), 2);
		
	}
	
	@Test 
	public void checkAddText() {
		VowelsCounter vowelsCounter = new VowelsCounter();
		vowelsCounter.addText("Platon: made, bamboo boats.");
		
		assertEquals(2.5, vowelsCounter.getVowelsMap().get(new VowelsKey("aoxxxx")).getAverage(), 0.001);
		assertEquals(2, vowelsCounter.getVowelsMap().get(new VowelsKey("aoxxx")).getAverage(), 0.001);
		assertEquals(2, vowelsCounter.getVowelsMap().get(new VowelsKey("aexx")).getAverage(), 0.001);
		
	}
	
	@Test
	public void checkAverage() {
		VowelsCounter vowelsCounter = new VowelsCounter();
		vowelsCounter.addWordToMap("Platon");
		vowelsCounter.addWordToMap("made");
		vowelsCounter.addWordToMap("bamboo");
		vowelsCounter.addWordToMap("boats");
		
		assertEquals(2.5, vowelsCounter.getVowelsMap().get(new VowelsKey("aoxxxx")).getAverage(), 0.001);
		assertEquals(2, vowelsCounter.getVowelsMap().get(new VowelsKey("aoxxx")).getAverage(), 0.001);
		assertEquals(2, vowelsCounter.getVowelsMap().get(new VowelsKey("aexx")).getAverage(), 0.001);
		
	}
	
	

}
