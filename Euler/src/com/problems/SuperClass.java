package com.problems;

//LetÕs say D is a subclass of class B.  What happens when you call method foo() from the 
//constructor of B?  (if youÕre creating a new D, it calls D.foo() instead of B.foo().
//However, D will not be fully-constructed at this point).

public class SuperClass {
	SuperClass(){
		System.out.println(">SuperConstructor");
		foo();
		System.out.println("<SuperConstructor");
	}
	
	public void foo(){
		System.out.println("Super");
	}
}
