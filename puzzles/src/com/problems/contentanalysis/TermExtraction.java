/** ----------------------------- TermExtraction.java ------------------ 
 *  
 *  Created: Mar 13, 2010
 *  
 *  ----------------------------- ***** ------------------------------- */ 
package com.problems.contentanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * @author Sundar
 *
 */
public class TermExtraction {
	private static Logger log = Logger.getLogger(TermExtraction.class);

	public String parseFile(String filePath) throws IOException {
		log.debug(">parseFile");
		StringBuilder text = new StringBuilder();
		try {
			File tFile = new File(filePath);
			BufferedReader input =  new BufferedReader(new FileReader(tFile));
			try {
				String line = null;
				while (( line = input.readLine()) != null){
					text.append(line).append(" ");
				}
			} finally {
				input.close();
			}
		} catch(IOException e){
			log.error("IOException occurred while reading file: ", e);
			throw e;
		}
		log.debug("<parseFile");
		return text.toString();
	}
	
	public Map<String, Integer> getWordCount(String text){
		log.debug(">getWordCount");
		text = ContentAnalysis.getWords(text);
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for(String word : text.split(" ")){
			int count = 0;
			try{ 
				count = wordCount.get(word); 
			} catch(NullPointerException npe){
				//do nothing
			}
			wordCount.put(word, ++count);
		}
		log.debug("<getWordCount");
		return wordCount;
	}
	
	public Set<String> performTermExtraction(TreeMap<String, Integer> wordCount){
		log.debug(">performTermExtraction");
		
		int nbWords = wordCount.size(), topCount = wordCount.firstEntry().getValue(), leastCount = wordCount.lastEntry().getValue();
		
		Collection<Integer> values = wordCount.values();
		int totalCount = 0;
		for(Integer v : values)
			totalCount +=  v;
		log.debug("nbWords: "+nbWords+" topCount: "+topCount+" leastCount: "+leastCount+" totalCount: "+totalCount);
		
		int frequent = 0, infrequent = 0;
		if(nbWords < 150){
			frequent = 1;
			infrequent = 2;
		} else if(nbWords < 300){
			frequent = 1;
			infrequent = 5;
		}
		log.debug("Elimination ratio - Frequent : Infrequent - "+frequent+" : "+infrequent);
		
		while(wordCount.size() > 8)
			eliminationRatio(frequent, infrequent, wordCount);
		
		log.debug("<performTermExtraction");
		return wordCount.keySet();
	}
	
	private void eliminationRatio(int frequent, int infrequent, TreeMap<String, Integer> wordCount){
		while(frequent != 0){
			wordCount.remove(wordCount.firstKey());
			frequent--;
		}
		while(infrequent != 0){
			wordCount.remove(wordCount.lastKey());
			infrequent --;
		}
	}
	
	public void problemSolve(String filePath){
		log.debug(">problemSolve");
		try {
			String text = parseFile(filePath);
			Map<String, Integer> wordCount = getWordCount(text);
			
			//Sort the map based on the values. put it in descending order
			TreeMap<String, Integer> sortedWordCount = new TreeMap<String, Integer>(new ValueComparer(wordCount));
			sortedWordCount.putAll(wordCount);
			
			log.info("Frequency Map - Word : Frequency");
			for(String word : sortedWordCount.keySet())
				log.info(word + " : " + sortedWordCount.get(word));
			
			Set<String> words = performTermExtraction(sortedWordCount);
			log.info("Extracted Words: "+words);
		} catch (IOException e) {
			log.error("Cannot proceed without reading the file: ",e);
		} catch (Exception e){
			log.error("Unknown Error: StackTrace: ",e);
		}
		log.debug("<problemSolve");
	}
}
