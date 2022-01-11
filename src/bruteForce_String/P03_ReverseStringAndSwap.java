package bruteForce_String;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P03_ReverseStringAndSwap {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
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
		String str = "This is the String";
		String output = "String eht is sihT";
		Assert.assertEquals(output, reverseStringAndSwap(str));
	}
	


	@Test
	public void example2() {
		//Edge Case Test Data
		String str = "";
		String output = "";
		Assert.assertEquals(output, reverseStringAndSwap(str));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String str = "This This";
		String output = "This sihT";
		Assert.assertEquals(output, reverseStringAndSwap(str));
	}
	
	/*
	 * --- Pseudo Code ---
	 * Brute Force Approach:
	 * 
	 * 1. Split the words of string by " "
	 * 2. Assign right = s.length-1 and return the words of string first
	 * 3. Create a null string. When alternative elements are found, swap the characters of it and add to original array
	 * 4. If the current word is not alternative, then add the word to output string as it is.
	 * 5. As we need to include spaces, add them accordingly. Note that space should not be added before first element/after last string
	 */	
	
	private String reverseStringAndSwap(String str) {
		String[] strArray = str.split(" ");
		int left = 0,right = strArray.length-1;
		
		while(left<right) {
			String temp = strArray[left];
			strArray[left++] = strArray[right];
			strArray[right--] = temp;
		}
		
		String output = "";
		for(int i=0;i<strArray.length;i++) {
			int index = strArray[i].length()-1;
			if(i!=0) output += " ";
			if(i%2==1) {
				while(index>=0) output += strArray[i].charAt(index--);
				strArray[i] = output;
			} else output += strArray[i];
		}
		
		return output;
	}
}
