package twoPointer_Arrays;

import org.junit.Test;

public class P07_RichestCustomerWealth {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1672
	 * 
	 * You are given an m x n integer grid accounts where accounts[i][j] 
	 * is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. 
	 * Return the wealth that the richest customer has.
	 * 
	 * A customer's wealth is the amount of money they have in all their bank accounts. 
	 * The richest customer is the customer that has the maximum wealth.
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
		int[][] accounts = {{1,2,3},{3,2,1}};
		int output = 6;
		findRichestWealth(accounts);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[][] accounts = {{1,5},{7,3},{3,5}};
		int output = 10;
		findRichestWealth(accounts);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
		int output = 17;
		findRichestWealth(accounts);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm : Two Pointer
	 * 
	 * 1. Create max to store maximum value
	 * 2. Iterate over the length of accounts
	 * 3. For each element in accounts[i], traverse through each element
	 * 4. Create pointers left and right and sum
	 * 5. Add elements of inner array and store them in variable sum
	 * 6. Find the max between sum and max
	 * 7. Return max at the end
	 * 
	 */	
	
	private int findRichestWealth(int[][] accounts) {
		int max=0;
		for(int i=0;i<accounts.length;i++) {
			int left = 0,right=accounts[i].length-1,sum=0;
			while(left<=right) {
                if(left<right) sum += accounts[i][right--];
                sum += accounts[i][left++];		
			}
			max = Math.max(sum, max);						
		}
		//System.out.println(max); 
		return max; 
	}
}
