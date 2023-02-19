package interviewQuestions;

import org.junit.Test;

public class furlenco_ReverseStringUsingRecursion {

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
		String s = "Hello";
		String output = "olleH";
		System.out.println(reverseString(s));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "a B # d";
		String output = "d # B a";
		System.out.println(reverseString(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "a";
		String output = "a";
		System.out.println(reverseString(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	public String reverseString(String s) {
		return new String(reverseStringUsingRecursion(s.toCharArray(),0,s.length()-1));
	}
	
	public char[] reverseStringUsingRecursion(char[] ch,int left,int right) {
		if(left==right) return ch;
		char temp = ch[left];
		ch[left++] = ch[right];
		ch[right--] = temp;
		return reverseStringUsingRecursion(ch,left,right);
	}
}
