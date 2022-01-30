package interviewQuestions;

import org.junit.Test;

public class amazon_ConvertStringIntoAnotherCase {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Write a program to convert given array into expected format
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
		String s = "aBcDE";
		convertString(s);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "";
		convertString(s);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "ABCDE";
		convertString(s);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create String Builder
	 * 2. Convert given string into charArray
	 * 3. For each character, 
	 * 		3a. Append given character into string builder
	 * 		3b. If current character is uppercase, append lower case character into sb
	 * 		3c. Else append upper case character into sb
	 * 4. Return string
	 * 
	 */	
	
	private void convertString(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(char ch : s.toCharArray()) {
			sb.append(ch);
			if(Character.isUpperCase(ch)) sb.append(Character.toLowerCase(ch));
			else sb.append(Character.toUpperCase(ch));
		}
		System.out.println(sb.toString());
		
	}
}
