package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P16_TopKFrequentElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 347
	 * 
	 * Top K Frequent Elements
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
		int[] nums = {1,1,1,2,2,3};
		int k=3;
		findTopKFrequencyElements(nums,k);
		
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1};
		int k=1;
		findTopKFrequencyElements(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int k=2;
		findTopKFrequencyElements(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create hashmap and add elements and its occurrence into hashmap
	 * 2. Using comparator sort the values
	 * 3. Create an array for output. Size should be "k"
	 * 4. Iterate over elements using an entryset
	 * 5. If k value greater than 0, assign values into array and decrement k
	 * 6. Else break
	 * 7. Return output array
	 * 
	 * 
	 */	
	
	private int[] findTopKFrequencyElements(int[] nums, int k) {
		HashMap<Integer,Integer> hMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			hMap.put(nums[i],hMap.getOrDefault(nums[i], 0)+1);
		}
		
		ArrayList<Entry<Integer,Integer>> lst = new ArrayList<>(hMap.entrySet());
		
		Collections.sort(lst,new Comparator<Entry<Integer,Integer>>(){
			@Override
			public int compare(Entry<Integer,Integer> e1, Entry<Integer,Integer> e2) {
				if(e1.getValue() < e2.getValue()) return -1;
				else if (e1.getValue() > e2.getValue()) return 1;
				else return 0;
			}
		});
		
		int[] output = new int[k];
        int i=0;
        for(Entry<Integer,Integer> entry : lst){
            if(k>0){
                output[i++] = entry.getKey();
                k--;
            } else break;
        }
        System.out.println(Arrays.toString(output));
        return output;
	}


}
