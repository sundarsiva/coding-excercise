package com.sundarsiva.wordfrequency;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sundar on 2/23/14.
 */
public class SortByValueTest extends TestCase{

    Map<String, Integer> wordCountMap;

    @Override
    protected void setUp() throws Exception {
        wordCountMap = new HashMap<String, Integer>();
        wordCountMap.put("great", 2);
        wordCountMap.put("awesome", 4);
        wordCountMap.put("new", 1);
        wordCountMap.put("nice", 3);
        wordCountMap.put("good", 3);
        wordCountMap.put("fantastic", 5);
    }

    public void testGetSortedWords(){
        List<String> sortedWords = new SortByValue(wordCountMap).getSortedWords();
        assertNotNull(sortedWords);
        assertEquals(sortedWords.get(0), "fantastic");
        assertEquals(sortedWords.get(1), "awesome");
        assertEquals(sortedWords.get(2), "good");
        assertEquals(sortedWords.get(3), "nice");
        assertEquals(sortedWords.get(4), "great");
        assertEquals(sortedWords.get(5), "new");
    }
}
