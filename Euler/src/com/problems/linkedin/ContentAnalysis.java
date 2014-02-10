/**
 * ----------------------------- ContentAnalysis.java ------------------
 * 
 * Created: Mar 13, 2010
 * 
 * ----------------------------- ***** -------------------------------
 */ 
package com.problems.linkedin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class ContentAnalysis {
	static Logger log = Logger.getLogger(ContentAnalysis.class);
	static Pattern p_removePunct = Pattern.compile("([\\p{Cntrl}\\p{Punct}])+",Pattern.UNICODE_CASE|Pattern.CANON_EQ);
	static Pattern p_removeHTMLTags = Pattern.compile("(<)([^>])*(>)");
	//static Pattern p_removeUrls = Pattern.compile("(http).*(\\.).*[\\s$]");
	static Pattern p_removeNumbers = Pattern.compile("[0-9]+");

	public static String removeHTMLTags(String text){
		log.debug(">removeHTMLTags");
		//log.debug("text="+text);
		Matcher m = p_removeHTMLTags.matcher(text);
		log.debug("<removeHTMLTags");
		return m.replaceAll(" ");	
	}

	public static String getWords(String text){
		log.debug(">getWords");
		text = removeHTMLTags(text); //not necessary if we are not going to have html files 
		Matcher m = p_removeNumbers.matcher(text);
		text = m.replaceAll("");
		String[] words = text.split("[ .,?!]+");
		StringBuffer sb = new StringBuffer();
		for(String word : words){
			//at this point we can additionally also check if the words are stopwords : grammatical words 
			//looking at a dictionary of stopwords and ignoring them.
			//if(!isStopWord(word)) -pseudocode
			sb.append(word+" ");
		}
		m = p_removePunct.matcher(sb.toString());
		text = m.replaceAll("");
		text = text.replaceAll("[\\p{Blank}]+"," ");
		text = text.toLowerCase();
		log.debug("<getWords");
		return text;
	}

}
