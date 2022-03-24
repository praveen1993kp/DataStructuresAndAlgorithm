package twoPointer_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P19_BoatsToSavePeople {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 881
	 * 
	 * You are given an array people where people[i] is the 
	 * weight of the ith person, and an infinite number of boats where 
	 * each boat can carry a maximum weight of limit. 
	 * 
	 * Each boat carries at most two people at the same time, 
	 * provided the sum of the weight of those people is at most limit.
	 * Return the minimum number of boats to carry every given person.
	 * 
	 * Leetcode daily challenge - 24/03/2022
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
		int[] people = {1,1,2,2,2,3,3,5,5};
		int limit = 6;
		int output = 5;
		findMinBoats(people,limit);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] people = {1,2};
		int limit = 3;
		int output = 1;
		findMinBoats(people,limit);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] people = {3,2,2,1};
		int limit = 3;
		int output = 3;
		findMinBoats(people,limit);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] people = {3,5,3,4};
		int limit = 5;
		int output = 4;
		findMinBoats(people,limit);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Logic : Trying to club heaviest and lightest person together will reduce no of boats
	 * 
	 * 1. Sort the given array
	 * 2. Create pointers left for lightest person and right for heaviest person. Create counter
	 * 3. Traverse while left<=right
	 * 4. Increment the counter
	 * 5. If sum of left and right <= limit, increment left and decrement right
	 * 6. Else
	 * 		6a. If left <= right, decrement right
	 * 		6b. Else increment left
	 * 7. Return counter
	 * 
	 * 
	 * 
	 * 
	 */	
	
	private int findMinBoats(int[] people, int limit) {
		Arrays.sort(people);
        int left=0,right=people.length-1,counter=0;
        while(left<=right){
            counter++;
            if((people[left] + people[right]) <= limit){
                left++;
                right--;
            } else {
                if(people[left] <= people[right]) right--;
                else left++;
            } 
        }
        return counter;
	}

}
