package com.problems;

import org.apache.log4j.Logger;

public class Problems {

	private static Logger log = Logger.getLogger(Problems.class);
	
	//Add all the natural numbers below one thousand that are multiples of 3 or 5.
	public static void multiples(){
		long sum3 = 0, sum5 = 0, sum = 0;
		int i = 0, limit = 1000;
		while(i <= limit ){
			if(i % 3 == 0 )
				sum3 = sum3 + i;
			i++;
		}
		System.out.println("sum3: "+sum3);
		i = 0;
		while(i <= limit ){
			if(i % 5 == 0)
				sum5 = sum5 + i;
			i++;
		}
		System.out.println("sum5: "+sum5);
		System.out.println("sum35: "+(sum3 + sum5));
		
		i = 0;
		while(i <= limit ){
			if(i % 3 == 0 || i % 5 == 0)
				sum = sum + i;
			if(i % 3 == 0 && i % 5 == 0)
				System.out.println(i);
			i++;
			
		}
		System.out.println("sum: "+sum);
		
		sum3 = ap(3, 333, 3);
		System.out.println("sum3: "+sum3);
		sum5 = ap(5, 200, 5);
		System.out.println("sum5: "+sum5);
		System.out.println("sum35: "+(sum3 + sum5));
		
		sum = ap(3, 333, 3) + ap(5, 200, 5);
		System.out.println("sum: "+sum);
	}
	
	private static long ap(int a1, float n, int d){
		long sum = (long) ((n/2)*(2*a1 + (n - 1)*d));
		//long sum = ((float)333/2) * (6 + 332 * 3);
		return sum;
	}
	
	public static void atoi(String ascii){
		char[] aArr = ascii.toCharArray();
		int sum = 0;
		for(char c : aArr){
			//System.out.println(c);
			sum = (sum * 10) + c - '0';
			System.out.println(sum);
		}
		System.out.println(sum);
	}

	static int[] arr = new int[]{0,1,3,4,5,6,7,8,9,10,11};
	public static void findInSortArray(int n, int begIndex, int endIndex){
		if(begIndex > endIndex || 0 > begIndex){
			System.out.println("not found");
			return;
		}
		int pivot = (begIndex + endIndex)/2;
		System.out.println(begIndex+" "+pivot+" "+endIndex);
		if(n == arr[pivot])
			System.out.println("Found: "+n);
		else if(n < arr[pivot])
			findInSortArray(n, begIndex, pivot-1);
		else if(n > arr[pivot])
			findInSortArray(n, pivot+1, endIndex);
		
	}
	
	static int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	static int gHeight = 2, gWidth = 2;
	public static void navigateGrid(){
		//for(int i = 0;i< 5, i++)
			atPoint(0, 0, 0);
	}
	
	private static int atPoint(int x, int y, int nrPaths){
		System.out.println(x+","+y);
		if(x == gWidth && gHeight == 5)
			return nrPaths+1;
		if (x < gWidth)
			   nrPaths = atPoint(x+1, y, nrPaths);
		if (y < gWidth)
			  nrPaths = atPoint(x, y+1, nrPaths);
		
		return nrPaths;
	}
	
	public static void evenFibonacci(){
		int first = 0, second = 1, fib = 0;
		while(fib < 4000000){
			fib = first + second;
			System.out.println(fib);
			first = second; second = fib;
		}
	}
	
	public static void divisibleBy3(int num){
		int n = num;
		while(n > 10){
			char[] ch = (""+n).toCharArray();
			n = 0;
			for(char c : ch){
				n = n + Integer.parseInt(""+c);
			}
		}
		log.debug(n);
		if(n == 0 || n == 3 || n == 6 || n==9 )
			log.debug(num +" is divisble by 3");
	}
	
	public static void main(String[] args) {
//		Base obj = new Child(10, 20); 
//		System.out.println(obj.i);
//		System.out.println (obj.j);
//		obj.m();
		//Problems.findInSortArray(2, 0, arr.length-1);
		//Problems.evenFibonacci();
		//divisibleBy3(132);
		evenFibonacci();
	}
	
	
}

