package hackerRank_Assessment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
public class frequencySort {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
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
	   int[] data = {3,4,6,2,4,2};
	   frequencySortUsingComparator(data);
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
	 */	
	
	private void frequencySort(int[] nums) {
        	Map<Integer,Integer> tMap = new TreeMap<>();
        	for(int i=0;i<nums.length;i++) {
        		int currentKey = nums[i];
        		tMap.put(currentKey, tMap.getOrDefault(currentKey, 0)+1);
        	}
        	ArrayList<Integer> tMapValues = new ArrayList<Integer>(tMap.values());
        	Collections.sort(tMapValues);
        	Iterator<Integer> it = tMapValues.iterator();
        	Map<Integer,Integer> tMap2 = new TreeMap<>();
        	int i=0, k=0;
        	for (Entry<Integer,Integer> entry : tMap.entrySet()) {
				if(entry.getValue()==tMapValues.get(i)) {
					k=entry.getValue();
					while(k>0) {
					System.out.println(entry.getKey());
					k--;
					}
					tMap.put(entry.getKey(), 0);
					i++;
				}
			}
      

	       System.out.println(tMap2.toString());
	    }
	
	private void frequencySort_UsingBuiltIn(int[] nums) {
    	Map<Integer,Integer> tMap = new TreeMap<>();
    	for(int i=0;i<nums.length;i++) {
    		int currentKey = nums[i];
    		tMap.put(currentKey, tMap.getOrDefault(currentKey, 0)+1);
    	}
    	//ArrayList<Integer> tMapValues = new ArrayList<Integer>(tMap.values());
  

       System.out.println(tMap.toString());
    }
	
	private void frequencySortUsingComparator(int[] nums) {
    	HashMap<Integer,Integer> tMap = new HashMap<>();
    	for(int i=0;i<nums.length;i++) {
    		int currentKey = nums[i];
    		tMap.put(currentKey, tMap.getOrDefault(currentKey, 0)+1);
    	}
    	List<Entry<Integer,Integer>> lst = new ArrayList<>(tMap.entrySet());
    	Collections.sort(lst, new Comparator<Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
				if(e1.getValue() > e2.getValue()) return 1;
				else if (e2.getValue() > e1.getValue()) return -1;
				return 0;
			}
		});
    	
    	for (Entry<Integer, Integer> entry : lst) {
			Integer freq = entry.getValue();
			while(freq > 0) {
				System.out.println(entry.getKey());
				freq--;
			}
		}
      // System.out.println(tMap.toString());
    }
}
