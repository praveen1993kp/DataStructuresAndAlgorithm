package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import junit.framework.Assert;

public class P10_FirstMissingPositive {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 41
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
		int[] nums = {1,2,0};
		int output = 3;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
	}
	
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {7,8,9,11,12};
		int output = 1;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {3,4,-1,1};
		int output = 2;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {0};
		int output = 1;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		int[] nums = {1};
		int output = 2;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		int[] nums = {1,1};
		int output = 2;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example7() {
		//Negative Test Data
		int[] nums = {2,1};
		int output = 3;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example8() {
		//Negative Test Data
		int[] nums = {1,1000};
		int output = 2;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example9() {
		//Negative Test Data
		int[] nums = {0,2,2,1,1};
		int output = 3;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	@Test
	public void example10() {
		//Negative Test Data
		int[] nums = {1,2,3,2147483647,9};
		int output = 4;
		Assert.assertEquals(output,findFirstMissingPositive(nums));
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private int findFirstMissingPositive(int[] nums) {
		HashSet<Integer> hSet = new HashSet<>();
		long max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			hSet.add(nums[i]);
			if (nums[i] > max) max = nums[i];
			if (nums[i] < min) min = nums[i];
		}
		if(min !=1) return 1;	
		
		for(int i=1;i<=max+1;i++) {
			if(!hSet.contains(i)) return i;
		}
		return 0;
	}
	
	private int findFirstMissingPositive2(int[] nums) {
		int minNum = 0, maxNum = 0, minIndex = 1;
		int missing = 0;
		if(nums.length==1) {
			if(nums[0] == 1) missing = 2;
			else missing = 1;
            return missing;
		}
        
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) {
				minNum = nums[i];
				minIndex = i;
				break;
			}
		}
		maxNum = nums[nums.length-1];
        if(minNum == maxNum && minNum==1) return 2;
        if(minNum==0 && maxNum ==0) return 1; 
		if(minNum >1) return 1;
		else {
			int expected = minNum;
			for(int i=minIndex;i<nums.length;i++) {		
				if(nums[i] != expected) {
					return expected;
				}
				expected += 1;
				if(i==nums.length-1) return maxNum+1;
			}
			
		}
		System.out.println(missing);
		return missing;
	}
}
