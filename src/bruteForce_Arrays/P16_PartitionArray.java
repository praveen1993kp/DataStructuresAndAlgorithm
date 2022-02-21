package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P16_PartitionArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2161
	 * 
	 * Partition Array According to Given Pivot
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
		int[] nums = {9,12,5,10,14,3,12};
		int pivot = 10;
		partitionArray(nums,pivot);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {13,12,11,10,9,8,7,10};
		int pivot = 10;
		partitionArray(nums,pivot);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {13,12,11,10,9,8,7};
		int pivot = 13;
		partitionArray(nums,pivot);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {13,12,11,10,9,8,7};
		int pivot = 18;
		partitionArray(nums,pivot);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create an output array 
	 * 2. Find the number of elements less than pivot and number of elements equal to pivot
	 * 3. Update lessIndex = 0, equalIndex=lessIndex+lessCount, greaterIndex=equalIndex+equalElement
	 * 4. Traverse through the array again and insert elements at respective indices.
	 * 5. Return the output array
	 * 
	 */	
	
	private int[] partitionArray(int[] nums, int pivot) {
		int lessCount=0,equalCount=0;
        int[] output = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<pivot) lessCount++;
            else if (nums[i]==pivot) equalCount++;
        }
        int lessIndex=0;
        int equalIndex = lessIndex + lessCount;
        int greaterIndex = equalIndex + equalCount;
        for(int num : nums){
            if(num<pivot) output[lessIndex++] = num;
            else if (num==pivot) output[equalIndex++] = num;
            else output[greaterIndex++] = num;
        }
        System.out.println(Arrays.toString(output));
       return output; 
		
		
	}
}
