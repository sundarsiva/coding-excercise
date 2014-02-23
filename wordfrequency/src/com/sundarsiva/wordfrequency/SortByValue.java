package com.sundarsiva.wordfrequency;

import java.util.*;

/**
 * Created by Sundar on 2/22/14.
 */

public class SortByValue implements Comparator<String>{

    private Map<String, Integer> wordCount = null;

	public SortByValue(Map<String, Integer> wordCount){
		this.wordCount = wordCount;
	}

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

    public List<String> getSortedWords(){
        List<String> words = new ArrayList<String>(wordCount.keySet());
        Collections.sort(words, this);
        return words;
    }
}
