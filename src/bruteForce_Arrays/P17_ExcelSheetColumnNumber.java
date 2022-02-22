package bruteForce_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P17_ExcelSheetColumnNumber {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 171
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
		String columnTitle = "A";
		int expected = 1;
		Assert.assertEquals(expected, findColumnNumber(columnTitle));
	}


	@Test
	public void example2() {
		//Edge Case Test Data
		String columnTitle = "ZYXW";
		int expected = 474523;
		Assert.assertEquals(expected, findColumnNumber(columnTitle));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String columnTitle = "FXSHRXW";
		int expected = 2147483647;
		Assert.assertEquals(expected, findColumnNumber(columnTitle));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a num 0
	 * 2. Traverse through each character of columnTitle
	 * 3. For each character, multiply the sum by 26
	 * 4. Add the current character ascii value-'A' +1 to num
	 * 5. Repeat steps 3-4 till columnTitle length is crossed
	 * 6. Return num
	 * 
	 */	
	
	private int findColumnNumber(String columnTitle) {
		int num=0;
        for(int i=0;i<columnTitle.length();i++){
            num *= 26;
            num += columnTitle.charAt(i)-'A'+1;
        }
        return num;
		
	}
}
