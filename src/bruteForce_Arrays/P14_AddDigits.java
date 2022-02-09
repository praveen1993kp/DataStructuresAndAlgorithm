package bruteForce_Arrays;

import org.junit.Test;

public class P14_AddDigits {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 258
	 * 
	 * Given an integer num, repeatedly add all its digits until the result has only one digit,
	 * and return it.
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
		int num = 38;
		int output = 2;
		addDigits(num);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int num = 0;
		int output = 0;
		addDigits(num);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse only if given number is greater than or equal to 10
	 * 2. Initialize variable temp to 0
	 * 3. Convert the given integer into string and traverse through each character
	 * 4. Add the numeric value into temp till the end of value
	 * 5. Assign num to temp value
	 * 6. Once the loop ends, return num
	 * 
	 */	
	
	private int addDigits(int num) {
        while(num>=10){
            int temp = 0;
            for(char ch : String.valueOf(num).toCharArray()){
                temp += Character.getNumericValue(ch); 
            }
            num = temp;
        }
        System.out.println(num);
        return num;
	}
}
