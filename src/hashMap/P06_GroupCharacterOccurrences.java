package hashMap;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.junit.Test;

import junit.framework.Assert;

public class P06_GroupCharacterOccurrences {

	
	
	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Group all the character sequences
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
		char[] ch = {'a','b','a','d','c','d','c','d'};
		String output = "a2b1c2d3";  // If output is required to be in ascending order of keys, use TreeMap
		String output1 = "a2b1d3c2";  // If output is required to be in insertion order of keys, use LinkedHashMap
		Assert.assertEquals(output1,groupOccurrences(ch));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		char[] ch = {'a','a','A','B','a'};
		String output1 = "a3A1B1";  // If output is required to be in insertion order of keys, use LinkedHashMap
		Assert.assertEquals(output1,groupOccurrences(ch));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		char[] ch = {};
		String output1 = "";  // If output is required to be in insertion order of keys, use LinkedHashMap
		Assert.assertEquals(output1,groupOccurrences(ch));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Add Values into hashMap/TreeMap
	 * 2. If the value is already found, increment the value
	 * 3. Using entry, print all the keys and values
	 * 
	 */	
	
	private String groupOccurrences(char[] ch) {
		LinkedHashMap<Character,Integer> hMap = new LinkedHashMap<>();
		String output = "";
		if(ch.length==0) return output;
		
		for(int i=0;i<ch.length;i++) {
			hMap.put(ch[i], hMap.getOrDefault(ch[i], 0)+1);
		}
		//System.out.println(hMap);
		
		for(Entry<Character,Integer> entry : hMap.entrySet()) {
			output += entry.getKey() + ""+ entry.getValue();
		}
		
		System.out.println(output);
		return output;
	}
}
