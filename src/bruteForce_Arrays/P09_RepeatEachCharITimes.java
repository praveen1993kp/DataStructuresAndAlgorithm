package bruteForce_Arrays;

import java.util.ArrayList;

import org.junit.Test;

public class P09_RepeatEachCharITimes {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Input = 1234;
	 * 
	 * output = {1234,11223344,111222333444,1111222233334444};
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
		int nums = 1234;
		repeatChars(nums);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Convert input nums into String
	 * 2. Convert into chararray
	 * 3. Create an arraylist for output
	 * 4. Create two loops - Outer loop for 4 times (Since max occ is 4)
	 * 5. Inner loop - length of ch.
	 * 6. Create a while loop to repeat inner loop character i times
	 * 7. Add into arraylist for output.
	 * 
	 */	
	
	private void repeatChars(int nums) {
		String input = String.valueOf(nums);
		char[] ch = input.toCharArray();
		String output = "";
		ArrayList<String> lst = new ArrayList<>();
		
		for(int i=0;i<4;i++) {
			output = "";
			for(int j=0;j<ch.length;j++) {
				int val = i;
				while(val>=0) {
					output += ch[j];
					val--;
				}
			}
			lst.add(output);
		}
		System.out.println(lst.toString());
	}
}
