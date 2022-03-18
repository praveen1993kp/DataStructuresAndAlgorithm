package hashMap;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class P08_ValidAnagram {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 242 
	 * 
	 * Valid Anagram
	 * 
	 * An anagram is a word or phrase formed by rearranging the letters of a different word or
	 * phrase, typically using all the original letters exactly once.
	 * 
	 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
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
		String s = "anagram";
		String t = "nagaram";
		boolean expected = true;
		Assert.assertEquals(expected, isValidAnagram(s,t));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "car";
		String t = "rat";
		boolean expected = false;
		Assert.assertEquals(expected, isValidAnagram_UsingHashMap(s,t));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "car";
		String t = "rate";
		boolean expected = false;
		Assert.assertEquals(expected, isValidAnagram_UsingHashMap(s,t));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Using Ascii:
	 * 
	 * 1. Create two ascii arrays of size 26
	 * 2. Loop till length of one of the input arrays
	 * 3. When an element is found in String s, make an entry in ascii position of that character
	 * 4. When an element is found in String t, make an entry in ascii position of that character
	 * 5. If both the arrays are equal, return true
	 * Edge Case: 6. If the length of s and t are not equal, return false
	 * 
	 * 
	 * Using HashMap:
	 * 
	 * 1. Create two hashmaps
	 * 2. Loop till length of one of the input arrays
	 * 3. Add the characters of array into respective hashmap
	 * 4. If both the hashmaps are equal, return true
	 * 	 
	 * 
	 * */	
	
	private boolean isValidAnagram_UsingHashMap(String s, String t) {
		if(s.length()!=t.length()) return false;
		HashMap<Character,Integer> sMap = new HashMap<>();
		HashMap<Character,Integer> tMap = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
		}
		if(sMap.equals(tMap)) return true;
		return false;
	}
	
	private boolean isValidAnagram(String s, String t) {
		if(s.length()!=t.length()) return false;
		int[] sAscii =  new int[26];
		int[] tAscii =  new int[26];
		for(int i=0;i<s.length();i++) {
			sAscii[s.charAt(i)-'a']++;
			tAscii[t.charAt(i)-'a']++;
		}
		if(Arrays.toString(sAscii).equals(Arrays.toString(tAscii))) return true;
		return false;
	}
	
	
}
