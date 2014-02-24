package com.sundarsiva.wordfrequency;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sundar on 2/22/14.
 */
public class WordFrequency {

    private static Logger log = Logger.getLogger(WordFrequency.class);

    public List<String> getTopWords(String text, int topCount){
        log.debug(">getTopWords");

        if(text == null || topCount < 1){
            log.debug("<getTopWords");
            return null;
        }

        int textLength = text.length();
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        StringBuilder sbWord = new StringBuilder();
        for(int charIndex = 0; charIndex < textLength; charIndex++){
            //convert to lowercase to make word comparison case insensitive
            char currentChar = Character.toLowerCase(text.charAt(charIndex));
            if(!isEndOfWord(currentChar) && charIndex != textLength-1){ //end of a word
                sbWord.append(currentChar);
            } else {
                //don't include or consider blank space as a word
                String word = sbWord.toString().trim();
                if(word.length() > 0){
                    log.debug("word: "+word);
                    addToWordCountMap(wordCountMap, word);
                }
                sbWord.setLength(0);//clear the string builder for the next word
            }
        }

        List<String> topWords = new SortByValue(wordCountMap).getSortedWords();
        if(topCount < topWords.size()){
            topWords = topWords.subList(0, topCount);
        }

        log.debug("<getTopWords");
        return topWords;
    }

    public void addToWordCountMap(Map<String, Integer> wordCount, String word){
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
    }

    private final static char SPACE = ' ', COMMA = ',', SEMI_COLON = ';', PERIOD = '.', EXCLAMATION = '!';

    public boolean isEndOfWord(char c) {
        //can improve this further by detecting more word seperation characters.
        if(c == SPACE || c == COMMA || c == SEMI_COLON || c == PERIOD || c == EXCLAMATION){
            return true;
        } else {
            return false;
        }
    }

}
