package bruteForce_Arrays;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P24_KidsWithTheGreatestNumberOfCandies {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1431
	 * 
	 * Kids With the Greatest Number Of Candies
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
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		System.out.println(findResultList(candies,extraCandies));
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] candies = {1,1,1,1};
		int extraCandies = 0;
		System.out.println(findResultList(candies,extraCandies));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] candies = {1};
		int extraCandies = 2;
		System.out.println(findResultList(candies,extraCandies));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create maxVariable
	 * 2. Find the maxNumber
	 * 3. Traverse through candies array again
	 * 4. If candies + extraCandies >= maxNumber, add true to list. else add false
	 * 5. Repeat step 4 till array length is crossed in step 3
	 * 6. Return the list
	 * 
	 * 
	 */	
	
	private List<Boolean> findResultList(int[] candies, int extraCandies) {
		int max = Integer.MIN_VALUE;
        List<Boolean> lst = new ArrayList<>();
        for(int candy : candies)
            max = Math.max(max,candy);
        
        for(int candy : candies)
            lst.add(candy + extraCandies >= max);
        return lst;
	}
}
