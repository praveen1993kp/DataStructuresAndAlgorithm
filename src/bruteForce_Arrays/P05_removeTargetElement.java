package bruteForce_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class P05_removeTargetElement {
	
	/*
	 * 
	 * LeetCode Problem No - 27
	 * 
	 * Given the integer array and the target, remove the matching target from the
	 * array
	 *
	 * 1. Did I understand the problem? yes or no If no ask the person to provide
	 * with more details with examples If yes go to the next step What is the
	 * input(s)? What is the expected output?  -- yes
	 * 
	 * Do I have any constraints to solve the
	 * problem? Do I have all the information to go to the next steps How big is
	 * your test data set will be? - As of now same int array
	 * 
	 * 2. Test data set Minimum 3 data set including positive, negative and edge
	 * Validate with the interviewer if the data set is fine by his/ her assumptions
	 * 
	 * 
	 * 3. Do I know to solve it? Yes- great is there an alternate ? No - can I break
	 * the problem into sub problems? - Yes
	 * 
	 * 
	 * 4. Ask for hint (if you dont know how to solve
	 * this 
	 * 
	 * 5. Do I know alternate solutions as well Yes- what are those? No- that
	 * is still fine, proceed to solve by what you know  - No 
	 * 
	 * 6. If you know the alternate
	 * solution find out the O-notations (performance) from Kishore to everyone in
	 * this session: 12:02 PM 
	 * 
	 * 
	 * 7. Then, explain either both are the best (depends on
	 * the time) Approach 1:- start with the worst-> improve (optimize) -> End up
	 * with the best Approach 2: Write down the options and benefits and code the
	 * best 
	 * 
	 * 8. Start always with the Pseudo code 
	 * 
	 * 9. Test against different test data
	 * 10. If it fails then debug to solve it
	 */

	@Test
	public void positive(){
		
		 int[] nums = { 4, 8, 11, 13, 11, 15 }; 
		 int target = 11; 
		 int[] output = {4, 8, 13, 15};
		 
		 Assert.assertTrue(Arrays.equals(removeElement(nums,target), output));
		
	}
	
	@Test
	public void edge(){
		 int[] nums = {1, 2, 2, 3, 4, 5, 2}; 
		 int target = 2; 
		 int[] output = {1, 3, 4, 5};
		 Assert.assertTrue(Arrays.equals(removeElement(nums,target), output));	}
	
	@Test
	public void negative() {
		 int[] nums = {}; 
		 int target = 6; 
		 int[] output = {};
		 //Assert.assertTrue(Arrays.equals(removeElement(nums,target), output));
		 Assert.assertTrue(Arrays.equals(removeElement(nums,target), output));	}
	
	/*
	 * ---  Pseudo code  ---
	 * 1. Create an ArrayList
	 * 2. Traverse through the nums array using for loop
	 * 	2a. If current element does not match with target, add it to arraylist
	 * 3. After for loop, convert ArrayList to  new Array
	 * 4. Return new array
	 * 
	 * 
	 */
	
	private int[] removeElement(int[] inputArray, int target) {
		
		if(inputArray.length == 0) return inputArray; 
		
		List<Integer> lst = new ArrayList<Integer>();
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] != target) lst.add(inputArray[i]);
		}
		
		int[] output = new int[lst.size()];
		for( int j=0; j<lst.size(); j++){
			output[j] = lst.get(j);
		}
		return output;
	}
	

	
	
}




