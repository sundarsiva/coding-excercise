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
        //if input text is null expect null
        List<String> topWords = wf.getTopWords(null, 2);
        assertNull(topWords);

        //if count is less than 1 expect null
        topWords = wf.getTopWords("a lot of words", 0);
        assertNull(topWords);

        //fantastic - 4, awesome - 3, good 2
        String text = "Fantastic awesome fantastic. New good,. awesome fantastic; awesome! Fantastic, nice good.";
        List<String> sortedWords = wf.getTopWords(text, 3);
        assertEquals(sortedWords.size(), 3);
        assertEquals(sortedWords.get(0), "fantastic");
        assertEquals(sortedWords.get(1), "awesome");
        assertEquals(sortedWords.get(2), "good");

        //asking for more words than present
        text = "Fantastic. ";
        sortedWords = wf.getTopWords(text, 3);
        assertEquals(sortedWords.size(), 1);
        assertEquals(sortedWords.get(0), "fantastic");

        //same word - different case, different word seperators
        text = "same. same same! Same same same, same same; same same same same. Same same same same same.";
        sortedWords = wf.getTopWords(text, 3);
        assertEquals(sortedWords.size(), 1);
        assertEquals(sortedWords.get(0), "same");

        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vestibulum fringilla urna eu ipsum pulvinar luctus. Vivamus lacus ligula, " +
                "sagittis ut neque ac, condimentum elementum risus. Aliquam dapibus turpis magna, " +
                "at placerat elit dapibus et. Pellentesque scelerisque auctor aliquet. Cras sed risus urna. " +
                "Phasellus laoreet dignissim lectus, nec mattis arcu ullamcorper id. Cras mi justo, accumsan " +
                "non bibendum sed, venenatis ornare lorem. Phasellus iaculis convallis porttitor. Integer quis " +
                "urna quis arcu luctus feugiat non in ipsum. Vestibulum porttitor tortor non luctus cursus. " +
                "Integer facilisis quis lorem vitae tempus. Donec urna dolor, laoreet venenatis sem vitae, " +
                "pulvinar pulvinar metus. Ut nec magna ornare, pellentesque nibh nec, fermentum est. " +
                "Nulla turpis magna, ornare et pharetra feugiat, congue a felis. Donec nisi leo, eleifend in " +
                "erat sed, mollis placerat tellus. Aenean malesuada feugiat dolor non rutrum";

        sortedWords = wf.getTopWords(text, 5);
        assertEquals(sortedWords.size(), 5);

        System.out.println(sortedWords.toString());
    }

    public void testAddToWordCountMap(){
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        wordCount.put("great", 2);
        wordCount.put("awesome", 5);

        //adding existing words to the map - count increments
        Map<String, Integer> updateWordCount = wf.addToWordCountMap(wordCount, "great");
        Integer count = updateWordCount.get("great");
        assertEquals(count.intValue(), 3);

        //adding existing words to the map - count increments
        updateWordCount = wf.addToWordCountMap(wordCount, "awesome");
        count = updateWordCount.get("awesome");
        assertEquals(count.intValue(), 6);

        //adding new word to the map - count is 1
        updateWordCount = wf.addToWordCountMap(wordCount, "new");
        count = updateWordCount.get("new");
        assertEquals(count.intValue(), 1);
    }

    public void testIsEndOfWord(){
        //word seperation characters
        boolean isEndOfWord = wf.isEndOfWord(' ');
        assertTrue(isEndOfWord);
        isEndOfWord = wf.isEndOfWord(',');
        assertTrue(isEndOfWord);
        isEndOfWord = wf.isEndOfWord(';');
        assertTrue(isEndOfWord);
        isEndOfWord = wf.isEndOfWord('!');
        assertTrue(isEndOfWord);
        isEndOfWord = wf.isEndOfWord('.');
        assertTrue(isEndOfWord);

        //non-word seperation characters
        isEndOfWord = wf.isEndOfWord('a');
        assertFalse(isEndOfWord);
        isEndOfWord = wf.isEndOfWord('#');
        assertFalse(isEndOfWord);
        isEndOfWord = wf.isEndOfWord('1');
        assertFalse(isEndOfWord);
        isEndOfWord = wf.isEndOfWord('b');
        assertFalse(isEndOfWord);
    }

}
