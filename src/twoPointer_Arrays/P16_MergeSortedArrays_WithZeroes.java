package twoPointer_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P16_MergeSortedArrays_WithZeroes {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode - 88 
	 * 
	 * Merge Sorted Array - Contains zero
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
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m=3,n=3;
		int[] expectedOutput = {1,2,2,3,5,6};
		mergeSortedArray_WithoutExtraSpace(nums1,nums2,m,n);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers p1=m-1 and p2=n-1 and index to last element of nums1
	 * 2. Traverse through given array till p2>=0
	 * 3. Add higher value to index and decrement accordingly
	 * 4. If equal, add either of values and decrement accordingly
	 * 5. Return nums1
	 * 
	 */	
	
	public int[] mergeSortedArray(int[] nums1, int[] nums2, int m, int n) {
		//practice_soln
		int left=0,right=0;
		while(left<m && right<nums2.length)
		{   
			int temp=0;	
			if(nums1[left] < nums2[right] && nums1[left]!=0) 
			{		
				while(right<n) {
				    if(nums2[right]>nums2[right++]) {
					    nums2[temp]=nums2[right];
					    nums2[right]=nums2[right++];
					    nums2[right++]=nums2[temp];				
				    }
				}
				System.out.println(nums2);				
			}	
			
			else if (nums1[left] >nums2[right])	{
				temp=0;
				nums1[temp]= nums1[left];
				nums1[left++]=nums2[right];
				nums2[right]=nums1[temp];
				//System.out.println(Arrays.toString(nums1));	
			} else if (nums1[left] == nums2[right])	{	
				nums1[temp]=nums1[left+1];
				nums1[left++]=nums2[right];
				nums2[right]=nums1[temp];
				left++;
				System.out.println(left);
				//System.out.println(left);
				System.out.println(nums2[right]);
				System.out.println(nums1[left]);
				//System.out.println(Arrays.toString(nums1));	
			} else if(nums1[left] == 0 && nums2[right]!= 0)	{	
				while(right<n) {
				    if(nums2[right]>nums2[right++]) {
					    nums2[temp]=nums2[right];
					    nums2[right]=nums2[right++];
					    nums2[right++]=nums2[temp];				
				    }
				nums1[left++]=nums2[right++];	
			    }
			}
		}	
		System.out.println(Arrays.toString(nums1));
        return nums1;
	}
	
	public int[] mergeSortedArray_WithoutExtraSpace(int[] nums1, int[] nums2, int m, int n) {
		int p1 = m-1, p2 = n-1,index=nums1.length-1;
		while(p2>=0) {
			if(p1>=0 && nums1[p1]>nums2[p2]) 
				nums1[index--] = nums1[p1--];
			else 
				nums1[index--] = nums2[p2--];		
		}
        return nums1;
	}
}
