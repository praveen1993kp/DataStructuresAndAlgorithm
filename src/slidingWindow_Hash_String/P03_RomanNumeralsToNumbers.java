package slidingWindow_Hash_String;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P03_RomanNumeralsToNumbers {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 13. Roman to Integer
	 * 
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		
		
			For example, 2 is written as II in Roman numeral, just two one's added together. 
			12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
			
			Roman numerals are usually written largest to smallest from left to right. 
			However, the numeral for four is not IIII. 
			Instead, the number four is written as IV. 
			Because the one is before the five we subtract it making four. 
			The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
			
			I can be placed before V (5) and X (10) to make 4 and 9. 
			X can be placed before L (50) and C (100) to make 40 and 90. 
			C can be placed before D (500) and M (1000) to make 400 and 900.
			Given a roman numeral, convert it to an integer.
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
		String s = "XXV";
		int output = 25;
		Assert.assertEquals(output,romanToNumeralSlidingWindow(s));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "LVIII";
		int output = 58;
		Assert.assertEquals(output,romanToNumeralSlidingWindow(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "MMMMCMXCVIII";
		int output = 4998;
		Assert.assertEquals(output,romanToNumeralSlidingWindow(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force :
	 * 1. Create a hashMap with Character as key and number as value						
		2. Add all the roman representations to the hashmap						
		3. For each element in the string, get the value from hashmap and sum everything						
		3. Add the subtraction values into another hashmap						
		4. If the string contains values from that hashmap, get the respective value and reduce the respective values						

	 * Sliding Window using HashMap:
	 * 
	 * 1. Create HashMap and all the values into hashmap (Including subtract values)
	 * 2. Create variables left=0,right=1, val = 0 and currentval = 0;   (We can skip currentVal too)
	 * 2. Loop till left is less than string length 
	 * 3. Get the Keys at s.charAt(left) and s.charAt(right) and combine into string
	 * 4. When the combined string is available as a key in hashmap, get the value
	 * 5. else, get the value of left alone
	 * 6. Add the currentValue to previously got value.
	 * 7. Edge case: When left reaches the last character of string, skip the combined loop and get the value directly.
	 */	
	
	private int romanToNumeral(String s) {
		HashMap<String,Integer> hMap = new HashMap<>();
		int val = 0;
		hMap.put("I", 1);
		hMap.put("V", 5);
		hMap.put("X", 10);
		hMap.put("L", 50);
		hMap.put("C", 100);
		hMap.put("D", 500);
		hMap.put("M", 1000);
		hMap.put("IV",4);
		hMap.put("IX",9);
		hMap.put("XL",40);
		hMap.put("XC",90);
		hMap.put("CD",400);
		hMap.put("CM",900);
		for(int i=0;i<s.length();i++) {
			if(i!=s.length()-1) {
				if(s.charAt(i)=='I'||s.charAt(i)=='X'||s.charAt(i)=='C')
				{
					String temp = "" + s.charAt(i) + s.charAt(i+1);
					if(hMap.containsKey(temp)) {
						val += hMap.get(temp);
						i++;
					} else val += hMap.get(Character.toString(s.charAt(i)));
				} 
				else val += hMap.get(Character.toString(s.charAt(i)));
			} else val += hMap.get(Character.toString(s.charAt(i)));			
		}
		System.out.println(val);
		return val;
	}
	
	private int romanToNumeralSlidingWindow(String s) {
		HashMap<String,Integer> hMap = new HashMap<>();
		int left = 0, right = 1, val = 0, currentVal = 0;
		hMap.put("I", 1);
		hMap.put("V", 5);
		hMap.put("X", 10);
		hMap.put("L", 50);
		hMap.put("C", 100);
		hMap.put("D", 500);
		hMap.put("M", 1000);
		hMap.put("IV",4);
		hMap.put("IX",9);
		hMap.put("XL",40);
		hMap.put("XC",90);
		hMap.put("CD",400);
		hMap.put("CM",900);
		while(left<s.length()) {   // We are using left to calculate left most character and right to calculate next character. hence iterating over left
			char chLeft = s.charAt(left);
			String strleft = Character.toString(chLeft);
			if(left!=s.length()-1) {
				char chRight = s.charAt(right);
				String strleftAndRight = Character.toString(chLeft) + Character.toString(chRight);
				if(hMap.get(strleftAndRight)!=null) {
					currentVal = hMap.get(strleftAndRight);
					left++;
				} else currentVal = hMap.get(strleft);	
			} else currentVal = hMap.get(strleft);
			val += currentVal;
			left++;
			right = left + 1;
		}
		System.out.println(val);
		return val;
	}
	
	
	
}
