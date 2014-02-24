package com.sundarsiva.wordfrequency;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Class that sorts a map based on values in the map
 */


public class SortByValue implements Comparator<String> {

    private static Logger log = Logger.getLogger(SortByValue.class);

    private Map<String, Integer> wordCount = null;

    /**
     * Constructs the sorter to sort the given {@link java.util.Map}
     * @param wordCount the {@link java.util.Map} to the sorted by values
     */

	public SortByValue(Map<String, Integer> wordCount) {
		this.wordCount = wordCount;
	}

    @Override
	public int compare(String key1, String key2) {
		Integer value1 = wordCount.get(key1);
		Integer value2 = wordCount.get(key2);
		int c = - value1.compareTo(value2);
		if (0 != c) {
			return c;
        }
        //if same value then compare the hashcode of key
		Integer h1 = key1.hashCode(), h2 = key2.hashCode();
		return h1.compareTo(h2);
	}

    /**
     * Returns a list of words in the descending order of occurence in the {@link java.util.Map}
     * @return {@link java.util.List} of words sorted by frequency. Empty list if map is null
     */

    public List<String> getSortedWords() {
        log.debug(">getSortedWords");
        if(wordCount == null) {
            return Collections.EMPTY_LIST;
        }
        List<String> words = new ArrayList<String>(wordCount.keySet());
        Collections.sort(words, this);
        log.debug("<getSortedWords");
        return words;
    }
}
