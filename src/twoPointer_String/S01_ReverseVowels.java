package twoPointer_String;

import java.util.Arrays;

import org.junit.Test;

public class S01_ReverseVowels {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * * Leetcode No - 345
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
		String s = "aeiou";
		String output = "uoiea";
		reverseVowels_TwoPointer(s);
	}
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create temp variables left and right. left = 0 and right = string.length()-1;
	 * 2. Start with left and traverse 
	 * 3. When vowel is found in left and right, swap values
	 * 	3a. When vowel is not found in right, decrease right by 1
	 *  3b. When vowel is not found in left, increase by 1
	 * 
	 */	
	
private void reverseVowels_TwoPointer(String s) {
		
		int left = 0;
		int right = s.length()-1;
		char[] ch = s.toCharArray();
		while(left<right) {
			if(isVowel(ch[left])&&isVowel(ch[right])){
				char temp = ch[left];
				ch[left] = ch[right];
				ch[right] = temp;
				left++;
				right--;
			}else if(isVowel(ch[left])) {
				right--;
			}
			else {
				left++;
			}
		System.out.println(Arrays.toString(ch));
		}
		
		}
	private boolean isVowel(char c) {
		boolean result = false;
		if((c == 'a')||(c == 'A')||(c == 'e')||(c == 'E')||(c == 'i')||(c == 'I')||(c == 'o')||(c == 'u')||(c == 'U'));
			return true;
	}
}
