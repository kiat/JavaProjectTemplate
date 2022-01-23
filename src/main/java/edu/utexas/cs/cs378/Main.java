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
		
		if(args.length>0)
			file=args[0];
		
		int batchSize = 4000;
		
		if(args.length>1)
			batchSize = Integer.parseInt(args[1]);
		
		String outputTempFile  = "temp.txt";
		
		
		MappToFile.mapIt(file, batchSize, outputTempFile);
		

	}

	
	
	
	

	
	
}