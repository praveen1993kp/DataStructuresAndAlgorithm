package bruteForce_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class S02_LargeInteger {

	/*
	 * PROBLEM STATEMENT  
	 * 
	 * LeetCode Problem No- 66	
	 * 
	 * You are given a large integer represented as an integer array digits, 
	 * where each digits[i] is the ith digit of the integer. 
	 * The digits are ordered from most significant to least significant in left-to-right order. 
	 * The large integer does not contain any leading 0's.
	 * Increment the large integer by one and return the resulting array of digits.
	 * 
	 * Understanding:
	 * 1. Given - large integer represented as array digits
	 * 			  
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no 	-- YES
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
		int[] nums = {1,2,3};
		int[] expectedOutput = {1,2,4};
		Assert.assertTrue(Arrays.equals(expectedOutput, largeInteger(nums)));
		
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {9,9,9,9};
		int[] expectedOutput = {1,0,0,0,0};
		
		Assert.assertTrue(Arrays.equals(expectedOutput, largeInteger(nums)));
		
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		// 
		int[] nums = new int[1];
		int[] expectedOutput = {1};
		Assert.assertTrue(Arrays.equals(expectedOutput, largeInteger(nums)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Collate all the int array elements to form a largeNumber
	 * 2. Increment the largeNumber by one
	 * 3. Split the largeNumber again to form int array
	 * 
	 */	
		
		public int[] largeInteger(int[] digits) {
	        	String tempVariable = "";
	        	for(int j=0;j<digits.length;j++) {
	        	tempVariable += digits[j];
	        	}
	        	Integer tempNumber = Integer.valueOf(tempVariable);
	        	tempNumber = tempNumber + 1;
	        	List<Integer> lst = new ArrayList<Integer>();
	        	tempVariable = "";
        		tempVariable += tempNumber;
	        	for(int j=0;j<tempVariable.length();j++) {
		        	
		        	lst.add(Character.getNumericValue(tempVariable.charAt(j)));
		        	}
	        	int[] outputArray = new int[lst.size()];
	        	for(int k=0;k<lst.size();k++) {
	        		outputArray[k] = lst.get(k);
	        	}
	        	//System.out.println(Arrays.toString(outputArray));
	        	return outputArray;
	        	
	        }
	        
 	}
//}
