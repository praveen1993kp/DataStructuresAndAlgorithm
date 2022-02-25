package bruteForce_Arrays;

import org.junit.Test;

public class P19_CompareVersionNumbers {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 165
	 * 
	 * Compare Version Numbers
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
		String version1 = "1.01";
		String version2 = "1.001";
		compareVersions(version1,version2);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String version1 = "1.0";
		String version2 = "1.0.0";
		compareVersions(version1,version2);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String version1 = "0.1";
		String version2 = "1.1";
		compareVersions(version1,version2);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Split both versions by "\\."
	 * 2. Find the maximum length among split arrays
	 * 3. Traverse till max
	 * 4. If the i value is less than corresponding array index, assign the numeric value. Else assign 0
	 * 5. Compare the values and return accordingly.
	 * 
	 */	
	
	private int compareVersions(String version1, String version2) {
		String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int max = Math.max(s1.length,s2.length);
        for(int i=0;i<max;i++){
            int num1 = i<s1.length ? Integer.valueOf(s1[i]) : 0;
            int num2 = i<s2.length ? Integer.valueOf(s2[i]) : 0;
            if(num1 < num2) return -1;
            else if(num1 > num2) return 1;
        }
        return 0;
	}

}
