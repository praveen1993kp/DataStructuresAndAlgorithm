package stack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P05_CrawlerLogFolder {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1598
	 * 
	 * Crawler Log Folder
	 * 
	 * ......
	 * 
	 * Return the minimum number of operations needed to go back to the main folder
	 * after the change folders operations.
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
		String[] logs = {"d1/","d2/","../","d21/","./"};
		int output = 2;
		Assert.assertEquals(output, findMinOperations(logs));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
		int output = 3	;
		Assert.assertEquals(output, findMinOperations(logs));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] logs = {"d1/","../","../","../"};
		int output = 0;
		Assert.assertEquals(output, findMinOperations(logs));
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: Stack
	 * 
	 * 1. Create a Stack
	 * --Loop Begins--
	 * 2. Traverse till length of input array logs
	 * 3. If logs[i] equals ../ 
	 * 		3a. If stack is not empty, do stack.pop
	 * 4. Else if logs[i] not equals ./, stack push current value
	 * --Loop Ends--
	 * 5. Return the size of stack
	 * 
	 */	
	
	private int findMinOperations(String[] logs) {
		Stack<String> stack = new Stack<>();
		
		for(int i=0;i<logs.length;i++) {
			if(logs[i].equals("../")) {
				if(!stack.isEmpty()) stack.pop();
			} else if(!logs[i].equals("./")) {
				stack.push(logs[i]);
			}
		}
		System.out.println(stack.size());
		return stack.size();
	}
}
