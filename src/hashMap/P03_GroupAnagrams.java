package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.Test;

public class P03_GroupAnagrams {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode No - 49 
	 * 
	 * Group Anagrams
	 * 
	 * Given an array of string strs, group the anagrams together.
	 * 
	 * You can return the anagram in any order
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
		String[] strs = {"eat","tan","tea","ate","nat","bat"};
		groupAnagramsUsingAscii_Approach2(strs);
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
	 * Using Ascii:
	 * 1. Create a hashMap with <String,List<String>> as generics
	 * 2. Iterate through each element in input array
	 * 3. For each element, create a new ascii array
	 * 4. Add the characters into ascii array
	 * 5. Convert ascii array into string
	 * 6. If hMap does not contain that string, add string as key and new arraylist as value
	 * 7. Add current string to respective string position
	 * 
	 * 
	 * Using HashMap as Key:
	 * 
	 * 1. Create a hashMap with <HashMap<Character,Integer>,List<String>> as generics
	 * 2. Iterate through each element in input array
	 * 3. For each element, create a new hashmap with generics as <Character,Integer>
	 * 4. Add the characters into character hashmap
	 * 5. If hMap does not contain that character hashmap, add character hashmap as key and new arraylist as value
	 * 7. Add current string to respective character hashmap position
	 */	
	
	
	private List<String> groupAnagramsUsingAscii(String[] strs) {
		if(strs.length==0) return Arrays.asList(strs);
		HashMap<String,List<String>> hMap = new HashMap<>();
		for (String str : strs) {
			char[] ascii = new char[26];
			for(int i=0;i<str.length();i++) {
				ascii[str.charAt(i)-'a']++;
			}
			String s = str.valueOf(ascii);
			System.out.println(s);
			//if(!hMap.containsKey(s))
				//hMap.put(s, new ArrayList<>());
			hMap.putIfAbsent(s, new ArrayList<>());
			hMap.get(s).add(str);
		}
		System.out.println(hMap.values());
		return new ArrayList (hMap.values());
	}
	
	private List<String> groupAnagramsUsingAscii_Approach2(String[] strs) {
		if(strs.length==0) return Arrays.asList(strs);
		HashMap<String,List<String>> hMap = new HashMap<>();
		for (String str : strs) {
			char[] ascii = new char[26];
			for(int i=0;i<str.length();i++) {
				ascii[str.charAt(i)-'a']++;
			}
			hMap.putIfAbsent(Arrays.toString(ascii), new ArrayList<>());
			hMap.get(Arrays.toString(ascii)).add(str);
		}
		System.out.println(hMap.values());
		return new ArrayList (hMap.values());
	}
	
	private List<String> groupAnagramsApproach3(String[] strs) {
		if(strs.length==0) return Arrays.asList(strs);
		HashMap<HashMap<Character,Integer>,ArrayList<String>> hMap =
				new HashMap<>();
		for(String str : strs) {
			HashMap<Character,Integer> chMap = new HashMap<>();
			for(int i=0;i<str.length();i++) {
				chMap.put(str.charAt(i), chMap.getOrDefault(str.charAt(i), 0)+1);
			}
			//if(!hMap.containsKey(chMap))
				//hMap.put(chMap, new ArrayList<>());
			hMap.putIfAbsent(chMap, new ArrayList<>());
			hMap.get(chMap).add(str);
		}
		System.out.println(hMap.values());
		return new ArrayList (hMap.values());
	}
		
}
	

