package interviewQuestions;

import org.junit.Assert;
import org.junit.Test;

public class ZetWerk_StringChallenge_SimilarToAnagram {

	/*
	 * PROBLEM STATEMENT 
	 * 
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
		String input = "rbqodlw";
		String str2 = "world";
		Assert.assertTrue(compareStrings(input,str2));
	}
	
	
	@Test
	public void example4() {
		//Positive Test Data
		String input = "battt";
		String str2 = "batttt";
		Assert.assertFalse(compareStrings(input,str2));
	}
	
	
	@Test
	public void example5() {
		//Positive Test Data
		String input = "battt";
		String str2 = "bat";
		Assert.assertTrue(compareStrings(input,str2));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String input = "cdore";
		String str2 = "coder";
		Assert.assertTrue(compareStrings(input,str2));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String input = "h3llko";
		String str2 = "hello";
		Assert.assertFalse(compareStrings(input,str2));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	public boolean compareStrings2(String str1,String str2)
	{
		
		int[] asci1= new int[128];
		int[] asci2= new int[128];
		
		for(int i=0;i<str1.length();i++)
			asci1[str1.charAt(i)]++;
		
		for(int j=0;j<str2.length();j++)
			asci2[str2.charAt(j)]++;
		
		for(char ch : str2.toCharArray()) {
			if(asci2[ch] < asci1[ch]) 
				return false;
		}
		
		return true;
	
		
	}
	
	public boolean compareStrings(String str1,String str2)
	{
		int[] asci1= new int[128];
		
		for(int i=0;i<str1.length();i++)
			asci1[str1.charAt(i)]++;
		
		for(int j=0;j<str2.length();j++) {	
			if(asci1[str2.charAt(j)] <= 0) return false;
			asci1[str2.charAt(j)]--;	
		}
		return true;
	
		
	}
}
