package binarySearch_Arrays;

import org.junit.Test;

public class P07_MedianOfSortedArrays {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 4
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
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		findMedian(nums1,nums2);				
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums1 = {1,3};
		int[] nums2 = {2,4};
		findMedian(nums1,nums2);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums1 = {1,3,5,6,7,8};
		int[] nums2 = {2,4};
		findMedian(nums1,nums2);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left=0 and right=0
	 * 2. Create output array of sum m+n
	 * 3. Merge both the sorted arrays together
	 * 4. Find the mid index
	 * 5. If the length of output array is odd number, return the mid value as double
	 * 6. Else find the median of mid and mid-1 and return as double
	 * 
	 */	
	
	private double findMedian(int[] nums1, int[] nums2) {
		int left=0,right=0;
        int m=nums1.length,n=nums2.length;
        int[] output = new int[m+n];
        int index=0;
        while(left<m || right<n){
            if(left>=m) output[index] = nums2[right++];
            else if (right>=n) output[index] = nums1[left++];
            else if(nums1[left]<nums2[right]) output[index] = nums1[left++];
            else output[index] = nums2[right++];
            index++;
        }
        int mid = output.length/2;
        if(output.length%2==1) return (double) output[mid];
        else return (double) (((double) output[mid]+ (double) output[mid-1])/2);	
	}
}
