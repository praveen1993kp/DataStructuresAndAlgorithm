package binarySearch_String;

import org.junit.Test;

import junit.framework.Assert;

public class P01_SmallestLetter {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 744
	 * 
	 * Given a character array letters that is sorted in non-decreasing order
	 * and a target character target, return the smallest character in the array
	 * that is larger than target.
	 * 
	 * Note that letters wrap around
	 * 
	 * For example, if target == 'z' and letters ==['a','b'], the answer is 'a'.
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
		char[] letters = {'c','f','j'};
		char target = 'a';
		char expected = 'c';
		Assert.assertEquals(expected,smallestLetterLargerThanTarget(letters,target));
		 
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		char[] letters = {'c','f','j'};
		char target = 'c';
		char expected = 'f';
		Assert.assertEquals(expected,smallestLetterLargerThanTarget(letters,target));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		char[] letters = {'a','a','a','a','a','a','a','a','a','b','b','b','b','b','b','b','b','b','c','c','c','c','c','c','c','c','d','d','d','d','d','d','d','d'};
		char target = 'b';
		char expected = 'e';
		Assert.assertEquals(expected,smallestLetterLargerThanTarget(letters,target));
	}
	
	/*
	 * --- Edge Cases ---
	 * Data - 1
	 * char[] letters = {'c','f','j'};
	 * char target = 'j';
	 * char expected = 'f';
	 * 
	 * Data - 2
	 * char[] letters = {'e','e','e','e','e','n','n','n','n'};
	 * char target = 'd';
	 * char expected = 'e';
	 * 
	 */	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Binary Search Approach:
	 * 
	 * 1. Initiate variables left = 0, right = letters.length-1, mid = 0;
	 * 2. Traverse until left less than right
	 * 3. Calculate mid = (left+right)/2
	 * 4. Once mid is reached, subtract value of letters[mid] - target
	 * 5. Calculate the difference
	 * 		5a. When the diff is greater than 0, update right as right = mid-1
	 * 		5b. Else, update left as left = mid+1
	 * 		5d. Return letters[left] by default
	 * 
	 * 6. Handling Edge cases:
	 * 		6a. If left is greater than array length-1, return first index of array
	 * 		
	 */	
	
	private char smallestLetterLargerThanTarget(char[] letters, char target) {
		int left = 0, right = letters.length-1, mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			int diff = letters[mid] - target;
			if(diff>0) right = mid-1;
			else left = mid+1;
		}
		if(left>letters.length-1) {
			System.out.println(letters[0]);
			return letters[0];
		}
		System.out.println(letters[left]);
		return letters[left];
	}
}
