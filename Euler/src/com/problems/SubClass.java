package com.problems;


public class SubClass extends SuperClass{

	SubClass(){
		System.out.println("do nothing");
	}
	
	public void foo(){
		System.out.println("Sub");
	}
	
	public static void main(String[] args) {
		SubClass sub = new SubClass();
	}
}
