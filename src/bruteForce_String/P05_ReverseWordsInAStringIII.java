package bruteForce_String;

import org.junit.Test;

import junit.framework.Assert;

public class P05_ReverseWordsInAStringIII {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 557
	 * 
	 * Reverse Words In A String III
	 * 
	 * Given a string s, reverse the order of characters in each word within a sentence while still
	 * preserving whitespace and initial word order
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
		String s = "Let's take LeetCode contest";
		String output = "s'teL ekat edoCteeL tsetnoc";
		Assert.assertEquals(output, reverseWords(s));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "AaBbCC";
		String output = "CCbBaA";
		Assert.assertEquals(output, reverseWords(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "!@# $@!";
		String output = "#@! !@$";
		Assert.assertEquals(output, reverseWords(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Split strings by space
	 * 2. Create StringBuilder
	 * 3. Traverse through the array. If i>0, add space
	 * 4. For each word, start from end index and add to string builder
	 * 5. Return sb.toString(); 
	 * 
	 */	
	
	private String reverseWords(String s) {
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length;i++) {
			if(i>0) sb.append(" ");
			for(int j=str[i].length()-1; j>=0;j--) {
				sb.append(str[i].charAt(j));
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
}
