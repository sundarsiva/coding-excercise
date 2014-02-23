/**
 * ----------------------------- ValueComparer.java ------------------
 * 
 * Created: Mar 13, 2010
 * 
 * ----------------------------- ***** -------------------------------
 */ 

package com.problems.contentanalysis;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Sundar
 *
 */
public class ValueComparer implements Comparator<String>{
	private Map<String, Integer>  _data = null;
	public ValueComparer (Map<String, Integer> data){
		super();
		_data = data;
	}

	public int compare(String key1, String key2) {
		Integer value1 = _data.get(key1);
		Integer value2 = _data.get(key2);
		int c = -value1.compareTo(value2);
		if (0 != c)
			return c;
		Integer h1 = key1.hashCode(), h2 = key2.hashCode();
		return h1.compareTo(h2);
	}
}
