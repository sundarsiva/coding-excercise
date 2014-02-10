package com.problems;

import org.apache.log4j.Logger;

public class Child extends Base{
	private static Logger log = Logger.getLogger(Child.class);

	int i = 3;
	int j = 4;
	
	Child(int i, int j) {
		super(i, j);
		i = i;
		j = j;
	}

	void m() {
		System.out.println(i + j);
	}

}
