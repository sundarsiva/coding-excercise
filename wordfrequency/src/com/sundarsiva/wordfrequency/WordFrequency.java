package com.sundarsiva.wordfrequency;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Sundar on 2/22/14.
 */
public class WordFrequency {

    private static Logger log = Logger.getLogger(WordFrequency.class);

    public List<String> getTopWords(String text, int topCount){
        log.debug(">getTopWords");
        List<String> topWords = null;

        if(text == null || topCount < 1){
            log.debug("<getTopWords");
            return topWords;
        }

        int textLength = text.length();
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        StringBuffer sbWord = new StringBuffer();
        for(int i = 0; i < textLength; i++){
            char c = text.charAt(i);
            if(c != ' '){ //end of a word
                sbWord.append(c);
            } else {
                addToWordCountMap(wordCountMap, sbWord.toString());
                sbWord.delete(0,sbWord.length());
            }
        }

        topWords = new SortByValue(wordCountMap).getSortedWords();

        log.debug("<getTopWords");
        return topWords.subList(0, topCount);
    }

    public Map<String, Integer> addToWordCountMap(Map<String, Integer> wordCount, String word){
        log.debug(">addToWordCountMap");

        int count = 0;
        try{
            count = wordCount.get(word);
        } catch(NullPointerException npe){
            //do nothing
            log.debug(word+" - not present in the map yet");
        }

        wordCount.put(word, ++count);
        log.debug("<addToWordCountMap");
        return wordCount;
    }


}
