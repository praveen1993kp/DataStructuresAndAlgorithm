package twoPointer_Arrays;

import org.junit.Test;

public class S02_ArrayIntersection {

	/*
	 * Given 2 int sorted arrays, print the intersection elements 
	 * of two arrays 
	 * 
	 * int[] arr1 = {2,3,5,6,8,10};
	 * int[] arr2 = {2,4,5,7,8};
	 * 
	 * 2,5,8
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
		int[] arr1 = {2,3,5,6,8,10};
		int[] arr2 = {2,4,5,7,8};
		arrayIntersection(arr1,arr2);
	}

	
	/*
	 * --- Pseudo Code ---
	 * 1. Create temp variables left and right. left = 0 and right = 0;
	 * 2. Assign left to first array and right to second array 
	 * 3. Traverse through both arrays in unidirectional and return the matches
	 * 
	 * 
	 */	
	
	
	
	public void arrayIntersection(int[] arr1,int[] arr2) {
		int left = 0;
		int right = 0;
		while(left<arr1.length && right<arr2.length) {
			if(arr1[left]==arr2[right]) {
				System.out.println("Intersection value " + arr1[left]);
				left++;
				right++;
			} else if(arr1[left] < arr2[right]) {
				left++;
			} else {
				right++;
			}
		}
		
	}
}
