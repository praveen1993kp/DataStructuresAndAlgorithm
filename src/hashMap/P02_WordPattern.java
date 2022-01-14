package hashMap;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P02_WordPattern {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode No - 290
	 * 
	 * Given a pattern and a String s, find if s follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
	 * 
	 * Key takeaway -- Values in both strings should be unique
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  - Yes
	 * 	yes or no 
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output? 
	 * 
	 * 	Do I have any constraints to solve the -- Only lowercase letters in both strings
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
		String pattern = "abba";
		String s = "dog dog dog dog";
		wordPatternOptimized(pattern,s);
		Assert.assertEquals(false, wordPatternOptimized(pattern,s));
	}

	@Test
	public void example2() {
		//Edge Case Test Data
		String pattern = "abba";
		String s = "dog cat cat dog";
		Assert.assertEquals(false, wordPatternOptimized(pattern,s));
		/*
		 * String pattern = "aba"; 
		 * String s = "dog cat cat"; 
		 * Assert.assertEquals(false,wordPatternOptimized(pattern,s));
		 */
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String pattern = "aaaa";
		String s = "dog cat cat fish";
		Assert.assertEquals(false, wordPatternOptimized(pattern,s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two hashmaps
	 * 2. Split the string array by using space
	 * 3. For hashmap1, pattern character is the key and for hashmap2, string[i] is the key
	 * 3. Since there should not be duplicates in pattern as well as string, 
	 * 		3a. Whenever an entry is not available in both hashmaps, add the respective keys and values
	 * 4. Do assertion by validating the values from both hashmaps
	 */	
	
	private boolean wordPattern(String pattern, String s) {
		HashMap<Character,String> pMap = new HashMap<>();
		boolean result = true;
		String[] stArray = s.split(" ");
		
		for(int i=0;i<pattern.length();i++) {
			if(!pMap.containsKey(pattern.charAt(i))) pMap.put(pattern.charAt(i), stArray[i]);
		}
		for(int j=0;j<pattern.length();j++) {
			char ch = pattern.charAt(j);
			String str = stArray[j];
			if(!pMap.get(ch).equals(str)) result = false;
		}
		System.out.println(result);
		return result;
		
	}
	// above approach will fail if duplicates in string s
	// pattern = "abba" s = "dog dog dog dog" -- Understand both should be unique
	
	private boolean wordPatternOptimized(String pattern, String s) {
		boolean result = true;
		HashMap<Character,String> pMap = new HashMap<>();
		HashMap<String,Character> sMap = new HashMap<>();
		String[] stArray = s.split(" ");
		for(int i=0;i<pattern.length();i++) {
			if(pattern.length()!=stArray.length) return false;
			if(!pMap.containsKey(pattern.charAt(i)) && !sMap.containsKey(stArray[i])) {
				pMap.put(pattern.charAt(i), stArray[i]);
				sMap.put(stArray[i], pattern.charAt(i));
			}
			if(!pMap.containsKey(pattern.charAt(i)) || !sMap.containsKey(stArray[i])) return false;
			else if(!pMap.get(pattern.charAt(i)).equals(stArray[i]) || !sMap.get(stArray[i]).equals(pattern.charAt(i))) return false;
		}
		System.out.println(result);
		System.out.println(pMap.toString());
		System.out.println(sMap.toString());
		return result;
	}
}
