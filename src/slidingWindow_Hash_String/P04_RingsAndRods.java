package slidingWindow_Hash_String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class P04_RingsAndRods {

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
		//Positive Test Data
		String s = "B0B6G0R6R0R6G9";
		ringsAndRods(s);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "B0B1B2B3B4B5B6B7B8B9R0R1R6R7R8R9G0G1G2G3G4G5G6";
		ringsAndRods(s);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "B1G2R3";
		ringsAndRods(s);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm: Two Pointer + HashMap
	 * 
	 * 1. Create variables left=0, right=1 and counter=0;
	 * 2. Create a HashMap to accomodate Keys and Values as Strings
	 * 3. Traverse till right less than s.length()
	 * 4. Add rods as key and colours as value
	 * 5. If the key is not available, add keys and values
	 * 6. If the key is already available, append the values
	 * 7. For each key, iterate and check if the value contains B,G and R and increase the counter accordingly
	 * 
	 */	
	
	private int ringsAndRods(String s) {
		int left = 0, right = 1, counter = 0;
		HashMap<String,String> hMap = new HashMap<>();
		while(right<s.length()) {
			String currentKey = Character.toString(s.charAt(right));
			String currentValue = Character.toString(s.charAt(left));
			if (!hMap.containsKey(currentKey)) hMap.put(currentKey, currentValue);
			else hMap.put(currentKey,hMap.getOrDefault(currentKey, "")+currentValue);
			left=left+2;
			right=right+2;
		}
		Object[] it = hMap.keySet().toArray();
		for(int i=0;i<it.length;i++) {
			if(hMap.get(it[i]).contains("B")&&hMap.get(it[i]).contains("R")&&hMap.get(it[i]).contains("G")) counter += 1;
		}
		System.out.println(counter);
		return counter;
	}
}
