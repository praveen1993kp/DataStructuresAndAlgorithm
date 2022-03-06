package twoPointer_String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P09_ReverseOnlyLetters {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 917
	 * 
	 * Reverse Only Letters
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
		String s = "ab-cd";
		String expected = "dc-ba";
		Assert.assertEquals(expected, reverseOnlyLetters(s));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s ="a-bC-dEf-ghIj";
		String expected = "j-Ih-gfE-dCba";
		Assert.assertEquals(expected, reverseOnlyLetters(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "Test1ng-Leet=code-Q!";
		String expected = "Qedo1ct-eeLg=ntse-T!";
		Assert.assertEquals(expected, reverseOnlyLetters(s));
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers left and right and point them to two extremes
	 * 2. Convert given string into charArray
	 * 3. Traverse till left less than right
	 * 4. If Character at left and right are letters, swap them and increment left and decrement right
	 * 5. Else
	 * 		5a. If character at left is not letter, increment left
	 * 		5b. If character at right is not letter, decrement right
	 * 6. Repeat steps 4-5 till condition 3 is met
	 * 7. Return String.valueOf(ch)
	 * 
	 */	
	
	private String reverseOnlyLetters(String s) {
		int left=0,right=s.length()-1;
        char[] ch = s.toCharArray();
        while(left<right){
            if(Character.isLetter(ch[left]) && Character.isLetter(ch[right])){
                char temp = ch[left];
                ch[left++] = ch[right];
                ch[right--] = temp;
            } else {
                if(!Character.isLetter(ch[left])) left++;
                if(!Character.isLetter(ch[right])) right--;
            }        
        }
        return String.valueOf(ch);
	}
}
