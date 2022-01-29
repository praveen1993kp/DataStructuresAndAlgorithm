package queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class S02_FindMaxUniqueForKConsecElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * HackerRank problem
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
		int[] nums = {4,2,2,3,5,1};
		int k = 3;
		int output = 3;
		findMaxUnique_Queue(nums,k);
 	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {4,5,4,5,5,5};
		int k = 3;
		int output = 2;
		findMaxUnique(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {5,5,5,5,5,5};
		int k = 3;
		int output = 1;
		findMaxUnique(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1 - Using Sliding Window + HashSet
	 * 
	 * 1. Create a hashSet. Create a counter and two pointers - Pointer1 and pointer2 = 0
	 * 2. Add initial k elements into hSet and get the counter as size of hSet
	 * 3. Traverse through the input array till right<nums.length
	 * 4. Remove the left element and add the right element. Validate the counter with max Number
	 * 5. Return counter
	 * 
	 * Edge case: If k==counter, return counter
	 * 
	 *  Approach 2 - Using Queue
	 * 
	 * 
	 * 
	 * Edge case: If k==counter, return counter
	 * 
	 */	
	
	private int findMaxUnique(int[] nums, int k) {
		HashSet<Integer> hSet = new HashSet<>();
		int left=0,right=0,counter=0;
			
		for(right=0;right<k;right++) {
			hSet.add(nums[right]);
		}
		counter = hSet.size();
		while(right<nums.length) {
			hSet.remove(nums[left++]);
			hSet.add(nums[right++]);
			counter = Math.max(counter, hSet.size());	
			if(k==counter) return counter;
		}
		return counter;
	}
	
	
	private int findMaxUnique_Queue(int[] nums, int k) {
		int counter = 0;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0;i<nums.length;i++) {
			if(i<k) deque.offer(nums[i]);
			else deque.push(nums[i]);
		}
		System.out.println(deque);
		System.out.println(deque);
		return counter;
	}
}
