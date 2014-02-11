package com.problems.jive;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class BetterProgrammerTask {
	

    public static int countWords(String s) {
    	if(s == null)
    		return 0;
		String[] words = s.trim().split(" ");
		return words.length;
    }
    
    public static void sortIgnoringSpaces(String[] a) {
        /*
          Please implement this method to
          sort a given array of Strngs in alphabetical order
          ignoring spaces (' ' symbols) within the strings.
         */
    	Set<String> words = new TreeSet<String>();
    	for(String s: a){
    		words.add(s);
    	}
    	int i = 0;
    	for(String w : words){
    		a[i] = w;
    		i++;
    	}
    	
    	for(String s: a){
    		System.out.println(s);
    	}
    }

    public static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
    	
    	boolean isPalindrome = false;
    	
    	if(s == null)
    		return isPalindrome;
    	
    	String reverse = new StringBuffer(s).reverse().toString();
    	
    	if(s.equals(reverse))
    		isPalindrome =  true;
    	
    	return isPalindrome;
    	

    }
    
    public static List<Integer> getPrimeNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all prime numbers in the given range (inclusively).
          A prime number is a natural number that has exactly two distinct natural number divisors, which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13
         */
    	List<Integer> primeNumbers = new ArrayList<Integer>();
    	
    	for(int i = from; i <= to; i++){
    		if(isPrime(i))
    			primeNumbers.add(i);
    	}
    	
    	return primeNumbers;
    	
    }
    
    public static boolean isPrime(int p){
    	if(p == 1)
    		return false;
    	for(int i = 2; i <= p/2; i++){
    		if(p % i == 0)
    			return false;
    	}
    	
    	return true;
    	
    }
    
    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }

    public static List<Node> traverseTreeInWidth(Node root) {
        /*
          Please implement this method to
          traverse the tree in width and return a list of all passed nodes.

          The list should start with the root node, next
          it should contain all second-level nodes, then third-level nodes etc.

          The method shall work optimally with large trees.
         */
    	
    	Node n = root;
    	List<Node> traversedList = new ArrayList<Node>();
    	
    	traversedList.add(root);
    	int i= 0;
    	while(i < traversedList.size()){
    		if(!isLeaf(n))
    			addNodestoList(traversedList, n.getChildren());
    		i++;
    		n = traversedList.get(i);
    	}
    	
    	return traversedList;
    	
    }

    public static void addNodestoList(List<Node> traversedList, List<Node> nodes){
    	for(Node n : nodes)
    		traversedList.add(n);
    }
    
    public static boolean isLeaf(Node n){
    	if(n.getChildren() == null){
    		return true;
    	}
    	return false;
    }
    
    public static int countWaysToProduceGivenAmountOfMoney(int cents) {
        /*
          Please implement this method to
          return the number of different combinations of US coins
          (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c)
          which may be used to produce a given amount of money.

          For example, 11 cents can be produced with
          one 10-cent coin and one 1-cent coin,
          two 5-cent coins and one 1-cent coin,
          one 5-cent coin and six 1-cent coins,
          or eleven 1-cent coins.
          So there are four unique ways to produce 11 cents.
          Assume that the cents parameter is always positive.
         */
    	
    	countWays(cents, findMaxDenom(cents));
    	
    	int ways = 1;
    	
    	
    			

    		
    	return 0;
    	    
    	
//        int[] ways = new int[cents+1];
//        ways[0] = 1;
//        int[] denoms = new int[] {1, 5, 10, 25, 50};
//        for (int i : denoms)
//            for (int j = 0; j+i <= cents; j++)
//                ways[j+i] += ways[j];
//        return ways[cents];
    }
    static int count = 0;
    public static void countWays(int cents, int maxDenom){
    	int c = cents - maxDenom;
    	++count;
    	countWays(cents, findMaxDenom(c));
    }
    
    static public int findMaxDenom(int cents){
    	int[] denoms = new int[] {50, 25, 10, 5, 1};
    	int maxDenom = 1;
    	for(int d : denoms){
    		if(d < cents)
    			maxDenom = d;
    	}
    	return maxDenom;
    }
    
//    public static int findMaxDenom(int n){
//    	
//    }
    
    public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */
    	int d = 0, q = 0, di = 0, n = 0, c = 0;
    	d = cents / 100;
    	q = (cents - d * 100)/25;
    	di = (cents - (d * 100 + q * 25))/10;
    	n = (cents - (d * 100 + q * 25 + di *10))/5;
    	c = cents - (d * 100 + q * 25 + di *10 + n * 5);
    	return new Change(d, q, di, n, c);
    	
    }


    // Please do not change this class
    static class Change {
        private final int _dollars;
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }

    public static double getAverage(Node root) {
        /*
          Please implement this method to
          return the average of all node values (Node.getValue()) in the tree.
         */
    	if(root == null)
    		return 0;
    		
    	List<Integer> values = new ArrayList<Integer>();
    	getNodeValues(root, values);
    	
    	double sum = 0;
    	
    	for(Integer i : values)
    		sum = sum + i;
    	
    	return sum/values.size();
    	
    }
    
    public static void getNodeValues(Node node, List<Integer> values){
    	values.add(node.getValue());
    	for(Node child : node.getChildren())
    		getNodeValues(child, values);
    }
    
    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */
    	Object[] reverse = new Object[a.length];
    	int i = reverse.length -1;
    	for(Object o : a){
    		reverse[i] = o;
    		i--;
    	}
    	return reverse;
    }
    
    public static String getBinaryRepresentation(int n) {
        /*
         Please implement this method to
         return a String with the binary representation of any number n, where n >= 0.
         Example: "101" is a binary representation of 5
        */
    	String bin = "";
    	
    	while(n >= 2){
    		int b = n % 2;
    		bin = b + bin;
    		n = n/2;
    		if(n == 1)
    			bin = 1 + bin;
    	}
    	return bin;
    }
    
    public static int binToDec(int bin){
    	int dec = 0;
    	int i = 0;
    	while(bin > 0){
    		int b = bin % 10;
    		dec += b * (Math.pow(2, i));
    		bin = bin/10;
    		i++;
    	}
    	
    	return dec;
    	
    }
    
    public static int countWaysToJump(int N) {
        /*
          A set of stairs has N steps.
          You can jump either 1 or 2 steps at a time.
          For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
          1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
          Please implement this method to
          return the count of the different ways to reach the end of the stairs with N steps.
         */
    	
        int[] res = new int[N+1];
        res[0] = 1;
        for (int i = 1; i <= N; ++i)
            res[i] = res[i-1]+(i-2 >= 0 ? res[i-2] : 0);
        return res[N];
    }
    
    public static List<Integer> getPerfectNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all perect numbers in the given range inclusively.
          A perfect number is defined as a positive integer which is the sum of its positive divisors not including the number itself.
          For example: 6 is a perfect number because 6 = 1 + 2 + 3 (1, 2, 3 are divisors of 6)
          28 is also a perfect number: 28 = 1 + 2 + 4 + 7 + 14
         */
    	List<Integer> perfectNumbers = new ArrayList<Integer>();
    	
    	for(int i = from; i <= to; i++){
    		int sum = 0;
    		for(int j = 1; j <= i/2; j++){
    			if(i % j == 0){
    				sum = sum + j;
    			}
    		}
    		if(sum == i){
    			perfectNumbers.add(i);
    		}
    	}
    	
    	return perfectNumbers;
    	
    }
    
    
    public static List<Integer> getReversalsToSort(int[] a) {
        /*
         You need to sort an array of integers by repeatedly reversing
         the order of the first several elements of it.

         For example, to sort [12,13,11,14], you need to  reverse the order of the first two (2)
         elements and get [13,12,11,14] and then reverse the order of the first three (3)
         elements and get [11,12,13,14]

         The method should return the shortest(!) possible list of integers corresponding to the required reversals.
         For the previous example, given an array [12,13,11,14]
         the method should return a list with Integers 2 and 3.
        */
    	List<Integer> r = new ArrayList<Integer>();
    	boolean isSorted = isSorted(a);
    	
    	while(!isSorted){
    		for(int i = 2; i <= a.length; i++){
    			int[] newArray = new int[i];
    			int temp = i-1;
    			for(int j = 0; j <= i-1; j++){
    				newArray[j] = a[temp];
    				temp--;
    			}
    			for(int w : newArray)
    				System.out.println("-"+w+"-");
    			System.out.println("---");
    			for(int k = 0; k < newArray.length; k++){
    				a[k] = newArray[k];
    			}
    			for(int s : a)
    				System.out.println("*"+s+"*");
    			System.out.println("***");
    			r.add(i);
    			isSorted = isSorted(a);
    			if(isSorted)
    				break;
    		}
    		//break;
    	}
    	return r;
    }
    
    public static boolean isSorted(int[] a){
    	int index = 1;
    	for(int i : a){
    		if(index == a.length)
    			break;
    		if( i > a[index])
    			return false;
    		index++;
    	}
    	return true;
    }
    
    public static int getCountOfOnes(int n) {
        /*
         Please implement this method to
         return the number of '1's in the binary representation of n
         for any integer n, where n > 0

         Example: for n=6 the binary representation is '110' and the number of '1's in that 
         representation is 2

        */
    	int count = 0;
    	while(n >= 2 ){
    		count = count + n % 2;
    		n = n/2;
    	}
    	count = count + 1;
    	return count;
    	
    }
    
    // Please do not change this interface
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }

    public static ListNode reverse(ListNode node) {
        /*
          Please implement this method to
          reverse a given linked list.
         */
    	ListNode temp = null, prev = null;
    	while(node != null){
    		temp = node.getNext();
    		node.setNext(prev);
    		prev = node;
    		node = temp;
    		
    	}
		return prev;
    }
    
    private static String a;
    private static void foo(String a){
       a = "second";
    }
    
   static String r = "";
    public static String reverseString(String s){
    	if(s.length() == 0)
    		return r;
    	r = r + s.substring(s.length()-1);
    	return reverseString(s.substring(0,s.length()-1));
    }
    
    
    
    public static void main(String[] argv){
    	System.out.println("binToDec: "+binToDec(101));
    }

}
