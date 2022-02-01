package twoPointer_Arrays;

import org.junit.Test;

public class P08_BestTimeToBuyAndSellStock {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Problem - 121
	 * 
	 * Best Time To Buy and Sell Stock
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
		int[] prices = {7,1,5,3,6,4};
		int output = 5;
		findBestTimeToBuyAndTellStock(prices);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] prices = {7,6,5,4,3,2,1};
		int output = 5;
		findBestTimeToBuyAndTellStock(prices);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create Variables amtAtMin and assign it to Integer.Max value and maxProfit,currentProfit
	 * 2. Traverse through the given array
	 * 3. If prices[i] less than amtAtMin, assign the value to amtAtMin
	 * 4. Else, calculate difference between prices[i] and amtAtMin 
	 * 5. If the difference is greater than maxProfit, assign currentprofit to maxProfit				
	 * 
	 */	
	
	private int findBestTimeToBuyAndTellStock(int[] prices) {
		int amtAtMin = Integer.MAX_VALUE, maxProfit = 0,currentProfit = 0;
		for(int i=0;i<prices.length;i++) {
			if(prices[i] < amtAtMin) amtAtMin = prices[i];
			else {
				currentProfit = prices[i] - amtAtMin;
				if(currentProfit > maxProfit) maxProfit = currentProfit;
			}
		}
		System.out.println(maxProfit);
		return maxProfit;
	}
	
}
