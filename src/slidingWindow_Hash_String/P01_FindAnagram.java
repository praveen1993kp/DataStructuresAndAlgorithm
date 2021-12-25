package slidingWindow_Hash_String;

import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class P01_FindAnagram {

	/*
	 * PROBLEM STATEMENT 
	 * 
        Given two strings s and p, return an array of all the indices of p's anagrams in s.
        You may return the answer in any order.
        
        An anagram is a word or phrase formed by rearranging the letters of a different word
        or phrase, typically using all the original letters exactly one.
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
		String s = "cbaebabacd";
        String p = "abc";
		getAnagram(s,p);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "abab";
		String p = "ab";
		getAnagram(s,p);
		//Assert.assertEquals(counter, maxUniqueSubstring(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "aabbcc";
		String p = "xy";
		getAnagram(s,p);
		//Assert.assertEquals(counter, maxUniqueSubstring(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach: Sliding Window + Hash
	 * 
	 * 1. Get the length of both strings. Create left and right and initiate to 0
	 * 2. Create two hashmaps
	 * 3. Traverse through the p string and add all the elements into hashmap
	 * 4. Traverse through s and add elements to another hashmap
	 * 5. When the number of elements in new hashmap equals 3, compare it with smap and return results
	 * 6. Till the end of string s, follow the same steps.
	 * 
	 * 
	 */	
	
	private void getAnagram(String s, String p) {
		int slength = s.length(), plength = p.length();
		int left=0,right=0;
		HashMap<Character,Integer> sMap = new HashMap<>();
		HashMap<Character,Integer> pMap = new HashMap<>();
		if(slength < plength) System.out.println("No matches");
		for(int i=0;i<plength;i++) {
			pMap.put(p.charAt(i), sMap.getOrDefault(p.charAt(i), 0)+1);
		}
		while(right<slength) {
			sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0)+1);
			if(right-left==plength-1) {
				if (sMap.equals(pMap)) System.out.println(left);
				if(sMap.get(s.charAt(left)) == 1) sMap.remove(s.charAt(left));
				else sMap.put(s.charAt(left), sMap.get(s.charAt(left))-1);
				left++;
			}
			right++;
		}
		
		//System.out.println(sMap.toString());
		
	}
}
