package twoPointer_String;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class S01_ReverseVowels {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode No - 345
	 * 
	 * Given a string s, reverse only all the vowels in the string and return it. The vowels are 'a','e','i','o','u'
	 * and they can appear in both cases
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
		String str = "AbraCadABRa";
		String reversedStr = "abrACadaBRA";
		Assert.assertEquals(reverseVowelsTwoPointer(str), reversedStr);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String str = "A man, a plan, a canal: Panama";
		String reversedStr = "a man, a plan, a canal: PanamA";
		Assert.assertEquals(reverseVowelsTwoPointer(str), reversedStr);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String str = "qwrty";
		String reversedStr = "qwrty";
		Assert.assertEquals(reverseVowelsTwoPointer(str), reversedStr);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a method if a given character is vowel or not
	 * 2. Convert given input to charArray
	 * 3. Traverse for length of charArray while left less than right
	 * 4. While left is not vowel, increment. Similarly while right is not vowel, decrement
	 * 5. If left is vowel and right is vowel, swap them and store in charArray
	 * 6. After exiting from while loop, add the character array elements into output string
	 * 
	 */	
	
	public boolean isVowel(char ch) {
		if((ch=='a')||(ch=='e')||(ch=='i')||(ch=='o')||(ch=='u')||
					(ch=='A')||(ch=='E')||(ch=='I')||(ch=='O')||ch=='U') return true;
		return false;
	}
	
	public String reverseVowelsTwoPointer(String s){
		int left=0,right=s.length()-1;
		char temp = 0 ;
		char[] inputAsArray = s.toCharArray();
		String output = "";

		while(left<right) {
			
			while(!isVowel(inputAsArray[left]) && left < right) left++;
			while(!isVowel(inputAsArray[right]) && left < right) right--;
			
			if(isVowel(inputAsArray[left]) && isVowel(inputAsArray[right])){
				temp = inputAsArray[left];
				inputAsArray[left++] = inputAsArray[right];
				inputAsArray[right--] = temp;	
			}
		}
		
		for(int i=0;i<inputAsArray.length;i++) {
			output += inputAsArray[i];
		}
		
		System.out.println(output);
		return output;
	}
}
