package com.problems;

import org.apache.log4j.Logger;

public class Base {
	private static Logger log = Logger.getLogger(Base.class);

	int i = 1;
	int j = 2;

	Base(int i, int j) {
		i = i;
		j = j;
	}

	void m() {
		System.out.println(i + j);
	}
}
