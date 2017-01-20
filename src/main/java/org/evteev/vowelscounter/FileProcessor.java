package org.evteev.vowelscounter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * class for processing input file and save result to output file
 * @author mike
 *
 */
public class FileProcessor {
	
	private static String IN_FILE = "INPUT.TXT"; 
	private static String OUT_FILE = "OUTPUT.TXT"; 
	
	private VowelsCounter vowelsCounter;
	
	public FileProcessor(VowelsCounter vowelsCounter) {
		this.vowelsCounter = vowelsCounter;
	}
	
	/**
	 * read and process file with text
	 * @param fileName
	 */
	public void processFile(String fileName) {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(vowelsCounter::addText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void processFile() {
		processFile(IN_FILE);
	}
	
	/**
	 * save result to output file
	 * @param fileName
	 */
	public void writeFile(String fileName) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
			vowelsCounter.getVowelsMap().forEach((key, value) -> {
				try {
					writer.write(vowelsCounter.getEntryString(key, value) + "\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile() {
		writeFile(OUT_FILE);
	}
}
