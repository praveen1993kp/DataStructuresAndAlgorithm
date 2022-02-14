package hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P14_ShortestCompletingWord {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 748
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
		String licensePlate = "1s3 PSt";
		String[] words = {"step","steps","stripe","stepple"};
		findShortestCompletingWord(licensePlate,words);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String licensePlate = "1s3 456";
		String[] words = {"looks","pest","stew","show"};
		findShortestCompletingWord(licensePlate,words);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create int arrays in and out of size 26
	 * 2. Create flag, currWord and currWordLength
	 * 3. Add alphabets from the licenseplate in array.
	 * 4. Traverse through the words array
	 * 5. Initialize out array and flag
	 * 6. Add each word characters into out array
	 * 7. Traverse through each character in licenseplate allowable characters and check the count btwn in and out
	 * 8. If the count is greater in in, mark flag as false and move to next word
	 * 9. If all the characters count in out is equal to or greater, check the word size and store minimum
	 * 10. return the min word
	 * 
	 */	
	
	private String findShortestCompletingWord(String licensePlate, String[] words) {
		
		StringBuilder sb = new StringBuilder();
		int[] in = new int[26];
		int[] out = new int[26];
		boolean flag = true;
		String currWord = "";
		int minStringSize = Integer.MAX_VALUE;
        
		for(int i=0;i<licensePlate.length();i++) {
			char ch = licensePlate.charAt(i);
			if(Character.isAlphabetic(ch)) {
				if(Character.isUpperCase(ch)) ch = Character.toLowerCase(ch);
				in[ch-'a']++;	
				sb.append(Character.toLowerCase(ch));
			}
		}
		
		for(String word : words) {
			out = new int[26];
			flag = true;
            
			for(char ch: word.toCharArray())
				out[ch-'a']++;
			
			for(int i=0;i<sb.toString().length();i++) {
				char ch = sb.toString().charAt(i);
				if(in[ch-'a'] > out[ch-'a']) {
					flag = false;
                    break;
				}
			}
            
			if(flag && word.length() < minStringSize) {
					minStringSize = word.length();
					currWord = word;			
			}
		}   		
		return currWord;
	}
}
