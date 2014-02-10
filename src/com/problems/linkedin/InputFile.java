/** ----------------------------- InputFile.java ------------------ 
 *  
 *  Created: Mar 13, 2010
 *  
 *  ----------------------------- ***** ------------------------------- */ 
package com.problems.linkedin;

import org.apache.log4j.Logger;

/**
 * @author Sundar
 *
 */
public class InputFile {
	private static Logger log = Logger.getLogger(InputFile.class);
	
	public static void main(String[] args) {
		log.debug(">main");
		new TermExtraction().problemSolve(args[0]);
		log.debug("<main");
	}

}
