package binarySearch_Arrays;

import org.junit.Test;

public class P04_SingleElementInASortedArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 540
	 * 
	 * You are given a sorted array consisting of only integers where
	 * every element appears exactly twice, except for one element which
	 * appears exactly once.
	 * 
	 * Return the single element that appears only once.
	 * 
	 * Your solution must run in (log n) runtime complexity.
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
		int[] nums = {1,1,2,3,3,4,4,8,8};
		int expected = 2;
		singleElement(nums);
	}

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {3,3,7,7,10,11,11};
		int expected = 2;
		singleElement(nums);
	}
	
	@Test
	public void example4() {
		//Edge Case Test Data
		int[] nums = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,25,25};
		int expected = 1;
		singleElement(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Pseudo Code						
	1. Since the elements occurs twice, it should be in the order odd,even,odd,even,…						
	2. When single element occurs, this pattern breaks. So after some point, it will be even,odd,even,odd..						
		3a. Current index = odd and repeating element = current+1, it means single element is available after this point						
		3b. Current index = odd and repeating element = current - 1, it means single element is available before this point						
		4a. Current index = even and repeating element = current-1, it means single element is available after this point						
		4b. Current index = even and repeating element = current + 1, it means single element is available before this point						
	5. If condition 'a' is true, then move left=mid+1. Else if condition b is true, then move right = mid-1						
	6. If both conditions are false, return the nums[mid] value. 						
	"Edge cases: 
		1) If length is 1, return that element. 
		2) If mid==0, return that element. 
		3) While checking odd/even, make sure that mid value is not nums.length-1"						

	 * 
	 */	
	
	private int singleElement(int[] nums) {
		int left = 0,right=nums.length-1,mid=0;
		if(nums.length==1) return nums[0];		
		while(left<=right) {
			boolean b1=false;
			boolean b2=false;
			mid=(left+right)/2;
			if(mid==0) {
				System.out.println(nums[mid]);
				return nums[mid];
			}
			if(mid%2==0&&mid!=nums.length-1) {
				b1= nums[mid]==nums[mid+1];
				b2= nums[mid]==nums[mid-1];
			} else if(mid%2==1&&mid!=nums.length-1){
				b1= nums[mid]==nums[mid-1];
				b2= nums[mid]==nums[mid+1];
			}
			if(b1) left=mid+1;
			else if (b2) right=mid-1;
			else {
				System.out.println(nums[mid]);
				return nums[mid];
			}
		}
		System.out.println(nums[mid]);
		return -1;
	}
}
