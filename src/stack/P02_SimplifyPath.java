package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P02_SimplifyPath {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 71
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
		String path = "/home/";
		simplifyPath_BetterSoln(path);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String path = "/home//foo/";
		simplifyPath_BetterSoln(path);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String path = "/../";
		String expected = "/";
		Assert.assertEquals(expected, simplifyPath_BetterSoln(path));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String path = "/a/./b/../../c/";
		String expected = "/c";
		Assert.assertEquals(expected, simplifyPath_BetterSoln(path));
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		String path = "/a/../../b/../c//.//";
		String expected = "/c";
		Assert.assertEquals(expected, simplifyPath_BetterSoln(path));
	}
	
	
	
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a stack
	 * 2. Split the input path using "/"
	 * 3. Traverse through the length of array
	 * 4. When current string is .. and stack is not empty, stack.pop
	 * 5. When current string is not . or str not empty, add to stack
	 * ----Loop ends--
	 * 6. When stack is empty, add / at 0 index of sb
	 * 7. While stack is not empty, add elements at 0 index followed by / at 0 index
	 * 
	 */	
	
	
	private String simplifyPath_BetterSoln(String path) {
		Stack<String> stack = new Stack<>();
		String[] str = path.split("/");
		//System.out.println(Arrays.toString(str));
		for(int i=0;i<str.length;i++) {
			if(str[i].equals("..")) {
				if(!stack.isEmpty()) stack.pop();
			} else if (!str[i].equals(".") && !str[i].isEmpty()) stack.push(str[i]);
			
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) sb.insert(0, "/");
		while(!stack.isEmpty()) {
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
