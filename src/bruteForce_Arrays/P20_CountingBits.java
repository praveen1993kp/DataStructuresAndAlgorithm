package bruteForce_Arrays;

import org.junit.Test;

public class P20_CountingBits {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 338
	 * 
	 * Given an integer n, return an array of length n+1 such that for each i,
	 * ans[i] is the number of 1's in the binary representation of i.
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
		int n=2;
		int[] output = {0,1,1};
		countBits(n);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int n=5;
		int[] output = {0,1,1,2,1,2};
		countBits(n);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int n=35;
		int[] output = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1,2,2,3};
		countBits(n);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create an output array of size n+1
	 * 2. Traverse from 0 till n
	 * 3. For each n value, calculate the reminder and if it is 1, increment the counter.
	 * 4. For each index, add the counter into ans[i]
	 * 
	 */	
	
	private int[] countBits(int n) {
		int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            int index=i,counter=0;
            while(index>0){
                if(index%2==1) counter++;
                index = index/2;    
            }
            ans[i] = counter;
        }
        return ans;	
	}
}
