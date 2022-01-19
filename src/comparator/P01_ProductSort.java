package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P01_ProductSort {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Product Sort- Same as hackerRank_Assessment1_frequencySort
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
		int n=6;
		int[] items = {4,5,6,5,4,3};
		int[] output = {3,6,4,4,5,5};
		Assert.assertTrue(Arrays.equals(output, productsSort(items)));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[]items = { 4, 3, 1, 6 };
		int[] output = { 1, 3, 4, 6 };
		Assert.assertTrue(Arrays.equals(output, productsSort(items)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[]items = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
		int[] output = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		Assert.assertTrue(Arrays.equals(output, productsSort(items)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private int[] productsSort(int[] items) {
		HashMap<Integer,Integer> hMap = new HashMap<>();
		int[] output = new int[items.length];
		for(int i=0;i<items.length;i++) {
			hMap.put(items[i], hMap.getOrDefault(items[i], 0)+1);
		}
		System.out.println(hMap.toString());
		
		ArrayList<Entry<Integer,Integer>> lst = new ArrayList<> (hMap.entrySet());
		
		Collections.sort(lst,new Comparator<Entry<Integer,Integer>>(){
					@Override
					public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
						if(e1.getValue() > e2.getValue()) return 1;
						else if (e1.getValue() < e2.getValue()) return -1;
						else return 0;
					}
		});
		int freq = 0;
		int i=0;
		for (Entry<Integer, Integer> entry : lst) {
			freq = entry.getValue();
			while(freq>0) {
				System.out.println(entry.getKey());
				freq--;
				output[i++] = entry.getKey();
			}
		}
		
		return output;
	}
}
