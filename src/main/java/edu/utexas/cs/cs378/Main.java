package edu.utexas.cs.cs378;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;

public class Main {

	/**
	 * A main method to run examples.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {

		// pass the file name as the first argument. 
		// We can also accept a .bz2 file
		
		// This line is just for Kia :) 
		String file = "/Users/kiat/Downloads/WikipediaPagesOneDocPerLine.txt.bz2";
		
		if(args.length>1)
			file=args[0];
		
		int batchSize = 1000;
		
		if(args.length>2)
			batchSize = Integer.parseInt(args[1]);
		
		
		String outputTempFile = "temp.txt";
		
		try{
		   FileInputStream fin = new FileInputStream(file);
		   BufferedInputStream bis = new BufferedInputStream(fin);
		   
		   // Here we uncompress .bz2 file 
		   CompressorInputStream input = new CompressorStreamFactory().createCompressorInputStream(bis);
		   BufferedReader br = new BufferedReader(new InputStreamReader(input));
			    
		   // Initialize a bunch of variables
			String line="";
			
			StringBuilder batch = new StringBuilder("");

			Long lineCounter = 0l;
			Map<String, Long> results = new HashMap<String, Long>();
			Map<String, Long> wordCountTmp = new HashMap<String, Long>();

			
			
			
		
	        
	        
	        
			// Start reading the file line by line.
			while ((line = br.readLine()) != null) {

				lineCounter += 1;
				
				// add the current text line to the data batch that we want to process. 
				batch.append(line);

				if (lineCounter % batchSize == 0) {

					wordCountTmp = processLine(batch.toString());					
					
//					// Print out some results to keep track of the running process. 
//					System.out.println(lineCounter +  "  Pages processe! Count of \"the\" word is: "+ wordCountTmp.get("the"));
//					
//					// Merge the current result to the word count so far! 
//					wordCountTmp.forEach((k, v) -> results.merge(k, v, (v1, v2) -> v1 + v2));

					System.out.println(lineCounter +  "  Pages processe! ");
					appendToTempFile( wordCountTmp,  outputTempFile);
				}
			}
			
			
//
//			// LinkedHashMap preserve the ordering of elements in which they are inserted
//			LinkedHashMap<String, Long> resultsSorted = new LinkedHashMap<>();
//			
//			// Let us sort the final result and then print it out.
//			results.entrySet().stream().sorted(Map.Entry.comparingByValue())
//					.forEachOrdered(x -> resultsSorted.put(x.getKey(), x.getValue()));
//
//			System.out.println("Sorted Results : " + resultsSorted);
		
		
			
			fin.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompressorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	/**
	 * 
	 * @param input
	 * @return
	 */
	
	public static Map<String, Long> processLine(String input) {

		String[] lines = input.split("\\R");
		Pattern pattern = Pattern.compile("[^a-zA-Z]");

		Map<String, Long> wordCount = Arrays.stream(lines).flatMap(line -> Arrays.stream(line.trim().split(" "))) // split
																													// by
																													// space
				.filter(word -> ! pattern.matcher(word).find())  // 
				// .replaceAll("[^a-zA-Z]", "")
				.map(word -> word.toLowerCase().trim()) // Drop all words with special chars
																					// and convert it to lower case.
				.filter(word -> !word.isEmpty()) // Drop all empty words
				.map(word -> new SimpleEntry<>(word, 1))
				.collect(Collectors.groupingBy(SimpleEntry::getKey, Collectors.counting()));

		return wordCount;

	}
	
	
	
	public static void appendToTempFile(Map<String, Long> data, String outputFile) {
	
		// new file object
        File file = new File(outputFile);
        BufferedWriter bf = null;
        
        try {
        	  
            // create new BufferedWriter for the output file
        	// ture means append 
            bf = new BufferedWriter(new FileWriter(file, true));
  
            // iterate map entries
            for (Map.Entry<String, Long> entry : data.entrySet()) {
  
                // put key and value separated by a comma
            	// better use a string builder. 
            	// better use a data serializiation library
            	
                bf.write(entry.getKey() + "," + entry.getValue());
  
                // new line
                bf.newLine();
            }
  
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
	}
	
	
}