package twoPointer_String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P03_ReversePrefixOfWord {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2000
	 * 
	 * Given a 0-indexed string word and a character ch, reverse the segmene of word
	 * that starts at index 0 and ends at the index of the first occurrence of ch(inclusive).
	 * 
	 * If the character ch does not exist in word, do nothing.
	 * 
	 * Return the resulting string
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
		String word = "abcdefd";
		char ch = 'd';
		String output = "dcbaefd";
		Assert.assertEquals(output, reversePrefixWord(word,ch));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String word = "xyxy";
		char ch = 'a';
		String output = "xyxy";
		Assert.assertEquals(output, reversePrefixWord(word,ch));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String word = "aabbccdd";
		char ch = 'd';
		String output = "dccbbaad";
		Assert.assertEquals(output, reversePrefixWord(word,ch));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm : Two Pointer
	 * 
	 * 1. Initiate two pointers left and right
	 * 2. Convert the input word into charArray
	 * 3. Traverse till right < charArray length
	 * 4. If character at right equals given char, 
	 * 
	 */	
	
	private String reversePrefixWord(String word, char ch) {
		int left = 0,right = 0;     // Right is initialized to 0, since first element itself could be the char
		char[] chArray = word.toCharArray();
		
		while(right<chArray.length) {
			if(chArray[right]!=ch) right++;
			else {
				while(left<=right) {
					char temp = chArray[left];
					chArray[left++] = chArray[right];
					chArray[right--] = temp;
				}
				break;}
		}
		
		System.out.println(new String(chArray));
		return new String(chArray);
	}
}
