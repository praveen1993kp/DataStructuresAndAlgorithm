package twoPointer_Arrays;

import org.junit.Test;

public class P10_AddStrings {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 415
	 * 
	 * Given two non-negative integers, num1 and num2 represented as string, return the sum of 
	 * num1 and num2 as a string.
	 * 
	 * Solve this without using any built-in library for handling large integers.
	 * You must also not convert the inputs to integers directly
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no 
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output? 
	 * 
	 * 	Do I have any constraints to solve the
	 * 	problem? Do I have all the information to go to the next steps 
	 * 	How big is your test data set will be? 
	 * 
	 * 2. Test data set Minimum 3 data set including positive, negative and edge
	 * Validate with the interviewer if the data set is fine by his/ her assumptions
	 * 
	 * 
	 * 3. Do I know to solve it? 
	 * 	Yes- great is there an alternate ? 
	 * 	No - can I break the problem into sub problems?
	 * 
	 * 
	 * 4. Ask for hint (if you dont know how to solve
	 * this) 
	 * 
	 * 5. Do I know alternate solutions as well Yes- what are those? No- that
	 * is still fine, proceed to solve by what you know 
	 * 
	 * 6. If you know the alternate
	 * solution find out the O-notations (performance) 
	 * 
	 * 
	 * 7. Then, explain either both are the best (depends on
	 * the time) 
	 * 	Approach 1:- start with the worst-> improve (optimize) -> End up
	 * with the best 
	 * 	Approach 2: Write down the options and benefits and code the
	 * best 
	 * 
	 * 8. Start always with the Pseudo code 
	 * 
	 * 9. Test against different test data
	 * 
	 * 10. If it fails then debug to solve it
	 */
	
	@Test
	public void example1() {
		//Positive Test Data
		String num1 = "123";
		String num2 = "877";
		addStrings(num1,num2);
		
	}	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String num1 = "";
		String num2 = "877";
		addStrings(num1,num2);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String num1 = "0";
		String num2 = "0";
		addStrings(num1,num2);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String num1 = "11";
		String num2 = "123";
		addStrings(num1,num2);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers first and second. First = num1.length-1 and second = num2.length-1
	 * 2. Create a string builder
	 * 3. Loop till either first or second is greater than 0
	 * 4. If first >=0, add the digit to var1
	 * 5. If second>=0, add the digit to var2
	 * 6. In sb, at index 0, insert val + val1 + val2
	 * 7. Once the loop ends, if val!=0, insert it at index 0
	 * 8. Return the string sb
	 * 
	 */	
	
	private String addStrings(String num1, String num2) {
		int first = num1.length()-1;
        int second = num2.length()-1;
		if(num1.length()<1 || num1.charAt(0)=='0') return num2;
		if(num2.length()<1 || num2.charAt(0)=='0') return num1;
		int val=0;
		StringBuilder sb = new StringBuilder();
		while(first>=0 || second>=0) {
			int val1 = first>=0 ? num1.charAt(first--)-'0' : 0;
			int val2 = second>=0 ? num2.charAt(second--)-'0' : 0;
			val += val1+val2;
			sb.insert(0, val%10);
			val = val/10;
		}
		System.out.println(val);
        if(val!=0) sb.insert(0,val);
        System.out.println(sb.toString());
		return sb.toString();
	}
}
