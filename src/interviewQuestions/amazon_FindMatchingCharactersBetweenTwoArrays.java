package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class amazon_FindMatchingCharactersBetweenTwoArrays {

	private static final String List = null;

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Write a program to find the non matching characters between 2 arrays
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
		char[] c1 = {'a','b','d'};
		char[] c2 = {'e','f','z'};
		ArrayList<Character> lst = new ArrayList<>(Arrays.asList());
		findMatchingChars(c1,c2);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		char[] c1 = {'a','k','d'};
		char[] c2 = {'e','f','z','d','l'};
		ArrayList<Character> lst = new ArrayList<>(Arrays.asList('d'));
		findMatchingChars(c1,c2);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		char[] c1 = {'a','k','d','e','d'};
		char[] c2 = {'e','f','z','d','l'};
		ArrayList<Character> lst = new ArrayList<>(Arrays.asList('d','e'));
		findMatchingChars(c1,c2);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private ArrayList<Character> findMatchingChars(char[] c1, char[] c2) {
		Arrays.sort(c1);
		Arrays.sort(c2);
		int left=0,right=0;
		ArrayList<Character> lst = new ArrayList<>();
		
		while(left<c1.length && right<c2.length) {
			int leftval = (int) c1[left];
			int rightval = (int) c2[right];
			
			if(leftval < rightval) left++;
			else if (leftval > rightval) right++;
			else {
				if(!lst.contains(c1[left])) lst.add(c1[left]);	
				left++;
			}
		}
		System.out.println(lst);
		return lst;	
	}
}
