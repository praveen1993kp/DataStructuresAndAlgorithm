package hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P11_FirstUniqueCharacter {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 387
	 * 
	 * Given a string s, find the first non-repeating character in it and return its index.
	 * 
	 * If it does not exist, return -1;
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
		String s = "leetcode";
		int output = 0;
		Assert.assertEquals(output, findFirstUniqueIndex_ascii(s));
	}

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "loveleetcode";
		int output = 2;
		Assert.assertEquals(output, findFirstUniqueIndex_ascii(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "aabb";
		int output = -1;
		Assert.assertEquals(output, findFirstUniqueIndex_ascii(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * HashMap:
	 * 
	 * 1. Create hashMap
	 * 2. Push the characters and its occurrence count into hashMap
	 * 3. Traverse through each character in input string and if hMap value of that character ==1, return the index
	 * 
	 * Ascii:
	 * 1. Create int[] array of size 26
	 * 2. Traverse through input string and increment each character-'a'
	 * 3. Traverse through input string and if count of that character ==1 return the index
	 * 
	 */	
	
	private int findFirstUniqueIndex(String s) {
		HashMap<Character,Integer> hMap = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			hMap.put(s.charAt(i), hMap.getOrDefault(s.charAt(i), 0)+1);
		}
		
		for(int i=0;i<s.length();i++) {
			if(hMap.get(s.charAt(i))==1) return i;
		}
		
		return -1;	
	}
	
	private int findFirstUniqueIndex_ascii(String s) {
		int[] ascii = new int[26];
		
		for(int i=0;i<s.length();i++) {
			ascii[s.charAt(i)-'a']++;
		}
		
		for(int i=0;i<s.length();i++) {
			if(ascii[s.charAt(i)-'a']==1) return i;
		}
		
		return -1;	
	}
}
