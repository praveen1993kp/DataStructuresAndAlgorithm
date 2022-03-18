package binarySearch_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class P01_findKthMissingElement {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1539
	 * 
	 * Find Kth missing positive Integer
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
		int[] nums = {2,3,4,7,11};
		int k = 5;
		findMissingElementWithBetterSpaceComplexity(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4};
		int k = 3;
		findMissingElementWithBetterSpaceComplexity(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,4,5,7};
		int k = 2;
		findMissingElementWithBetterSpaceComplexity(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force: 
	 * 1. Create two Arraylists. Add
	 * 
	 */	
	
	private void findMissingElement(int[] nums,int k) {
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		
		System.out.println(al2.toString());
		int i=1;
		while(al.size()<k+1) {
			if(i < nums.length) {
				if(!al2.contains(i)) al.add(i);
			} else al.add(i);
			i++;
		}
		al.get(al.size()-1);
	}
	
	private int findMissingElementWithBetterSpaceComplexity(int[] nums,int k) {
		int left = 0, right = nums.length-1; 
		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid] - mid > k ) right=mid-1;   // Finding how current value deviates from index
			else left = mid+1;
		}
		System.out.println(left+k);
		return left + k; 
	}
}
