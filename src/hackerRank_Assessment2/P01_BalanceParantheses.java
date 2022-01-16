package hackerRank_Assessment2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P01_BalanceParantheses {

	/*
	 * PROBLEM STATEMENT 
	 * 1. Balance Parantheses
	 * 
	 * A balanced sequence of parantheses is one in which every opening bracket has a corresponding closing
	 * bracket to it. More formally, a sequence of parantheses is considered balance if it can be
	 * represented in the form s1(s2) where both s1 and s2 are either empty or balanced strings.
	 * 
	 * Given a sequence of parantheses, find the minimum number of swaps needed to make the 
	 * sequence balanced. It is not necessary to swap adjacent characters only. 
	 * If it is impossible to balance the string, return -1.
	 * 
	 * Example:
	 * brackets = ")()(())("
	 * Swap the characters at the first and last index to get (()(())) which is balanced.
	 * The string can be balanced with 1 swap.
	 * 
	 * Output = 1;
	 * 
	 * Constraints:
	 * 
	 * 1<= length of the string brackets <= 10^5
	 * brackets consists of "(" and ")" only. 
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
		String brackets = "(()))(";
		int expectedOutput = 1;
		Assert.assertEquals(expectedOutput, balanceParantheses(brackets));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String brackets = "()()";
		int expectedOutput = -1;
		Assert.assertEquals(expectedOutput, balanceParantheses(brackets));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String brackets = "()())";
		int expectedOutput = -1;
		Assert.assertEquals(expectedOutput, balanceParantheses(brackets));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: Stack
	 * 
	 * 1. Crate Stack. 
	 * 2. Convert input string into charArray
	 * --Loop Begins--
	 * 3. Traverse till end of charArray
	 * 4. If stack is empty, push the value
	 * 5. If stack is not empty,
	 * 		5a. If current character is '(', push it
	 * 		5b. else if current character is ')' pop the value from stack
	 * --Loop Exit--
	 * 6. Get the count of swaps as size of stack/2
	 * 7. If the count of swaps is <1, return -1. Else return swaps
	 * 
	 */	
	
	private int balanceParantheses(String brackets) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<>();
		char[] ch = brackets.toCharArray();
		
		for(int i=0;i<ch.length;i++) {
			if(stack.isEmpty()) stack.push(ch[i]);
			else {
				if(ch[i]=='(') stack.push(ch[i]);
				else stack.pop();
			}
		}
		int swaps = (stack.size()/2);
		if(swaps<1) return -1;
		else return swaps;
	}
}
