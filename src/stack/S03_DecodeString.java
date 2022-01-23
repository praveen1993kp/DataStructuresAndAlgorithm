package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S03_DecodeString {

	
	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode - 394
	 * 
	 * Given an encoded string, return its decoded string.

		The encoding rule is: k[encoded_string], where the encoded_string inside the square 
		brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

		You may assume that the input string is always valid; there are no extra white spaces, 
		square brackets are well-formed, etc.

		Furthermore, you may assume that the original data does not contain any digits and 
		that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
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
		String s = "2[a3[b]]";
		String output = "abbbabbb";
		decodeString(s);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "2[ab]";
		String output = "abab";
		decodeString(s);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "3[abc]";
		String output = "abcabcabc";
		decodeString(s);
	}
	
	@Test
	public void example4() {
		//Positive Test Data
		String s = "2[a3[bc]]";
		String output = "abcbcbcabcbcbc";
		decodeString(s);
	}
	
	@Test
	public void example5() {
		//Positive Test Data
		String s = "2[b3[c]]";
		String output = "bcccbccc";
		decodeString(s);
	}
	
	@Test
	public void example6() {
		//Positive Test Data
		String s = "10[a]";
		String output = "aaaaaaaaaa";
		decodeString(s);
	}
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1) Create Empty Stack
	 * 2) Convert String to char array
	 * 3) Loop each character (until it reaches the closing bracket)
	 * 		a) pop from the stack 
	 * 		b) Add to the ArrayList
	 * 		c) when you notice the opening bracket --> next char is freq 
	 * 		d) Check if it is a digit --> Append the same string to AL
	 * 		e) Reverse the string and push back to the stack
	 * 4) Repeat the step 3 until stack is empty !!
	 * 
	 */	
	
	private String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		
		String temp;
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i] != ']') stack.push(ch[i]);
			else {
				temp = "";
				while(stack.peek() != '[') {
					temp += stack.pop();
				}
				
				stack.pop();   // Removing [ character
				
				String freq = "";
				while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
					freq = stack.pop() + "" + freq;
				}
				
				int k = 0;
				
				if(freq !="") k = Integer.valueOf(freq);
				
				while(k>0) {
					for(int j=temp.length()-1;j>=0;j--) {
						stack.push(temp.charAt(j));
					}
					k--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse().toString());
		return s;
		
	}
}
