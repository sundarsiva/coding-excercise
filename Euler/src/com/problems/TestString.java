package com.problems;

import org.apache.log4j.Logger;

public class TestString {
	private static Logger log = Logger.getLogger(TestString.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.debug(">main");
		String str1 = "computer";
		String str2 = "computer";
		String str3 = new String("computer");

		if(str1 == str2) {
			System.out.println("EQUAL A");
		}

		if(str1.equals(str2)) {
			System.out.println("EQUAL B");
		}

		if(str1 == str3) {
			System.out.println("EQUAL C");
		}

		if(str1.equals(str3)) {
			System.out.println("EQUAL D");
		}
		log.debug("<main");
	}

}
