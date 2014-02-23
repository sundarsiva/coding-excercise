package com.sundarsiva.wordfrequency;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sundar on 2/22/14.
 */
public class WordFrequencyTest extends TestCase{

    WordFrequency wf;

    @Override
    protected void setUp() throws Exception {
        wf = new WordFrequency();
    }

    public void testGetTopWords(){
        String text = null;
        int topCount = 0;

        List<String> topWords = wf.getTopWords(text, topCount);

        assertNull(topWords);

        text = "fantastic awesome fantastic new good awesome fantastic awesome fantastic nice good ";

        List<String> sortedWords = wf.getTopWords(text, 3);
        assertEquals(sortedWords.get(0), "fantastic");
        assertEquals(sortedWords.get(1), "awesome");
        assertEquals(sortedWords.get(2), "good");
    }

    public void testAddToWordCountMap(){
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        wordCount.put("great", 2);
        wordCount.put("awesome", 5);

        Map<String, Integer> updateWordCount = wf.addToWordCountMap(wordCount, "great");
        Integer count = updateWordCount.get("great");
        assertEquals(count.intValue(), 3);

        updateWordCount = wf.addToWordCountMap(wordCount, "awesome");
        count = updateWordCount.get("awesome");
        assertEquals(count.intValue(), 6);

        updateWordCount = wf.addToWordCountMap(wordCount, "new");
        count = updateWordCount.get("new");
        assertEquals(count.intValue(), 1);

    }

}
