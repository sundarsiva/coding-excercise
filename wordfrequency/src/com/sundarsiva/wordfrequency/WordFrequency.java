package com.sundarsiva.wordfrequency;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that generates a list of words based on frequency
 */

public class WordFrequency {

    private static Logger log = Logger.getLogger(WordFrequency.class);

    /***
     * Constructs a {@link java.util.List} of string representing most frequent words in a given text document
     * @param text Input text from which the most frequent words needs to be determined
     * @param topCount Number of most frequent words to be returned
     * @return List of string containing the topCount number of words. {@literal null} if text is {@literal null} or topCount is less than 0.
     */

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

    /**
     * Adds a string word to the given map. If the words is already present, increments the value count by 1
     * @param wordCount the map to which the word needs to added or the count needs to be incremented
     * @param word the word that needs to be added to the map
     */

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

    /**
     * Utility method to tell if the given character is a end-of-word character.
     * End of word characters is one of - , ; . ! blankspace
     *
     * @param c the character to be tested if it is a end-of-word character
     * @return true if the character is end-of-word character. Else returns false
     */

    public boolean isEndOfWord(char c) {
        //can improve this further by detecting more word seperation characters.
        if(c == SPACE || c == COMMA || c == SEMI_COLON || c == PERIOD || c == EXCLAMATION){
            return true;
        } else {
            return false;
        }
    }

}
