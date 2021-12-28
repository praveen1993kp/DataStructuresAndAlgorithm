package hashMap;

import org.junit.Test;

import junit.framework.Assert;

public class P03_GrumpyBookstoreOwner {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode - 1052
	 * 
	 * int[] customers = {1,0,1,2,1,1,7,5};
	 * int[] grumpy = {0,1,0,1,0,1,0,1};
	 * int minutes = 3;
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
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy =    {0,1,0,1,0,1,0,1};
		int minutes = 3;
		int expected = 16;
		Assert.assertEquals(expected, grumpyBookStore(customers,grumpy,minutes));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] customers = {1,2,3,4,-5};
		int[] grumpy =    {0,1,0,1,0};
		int minutes = 2;
		int expected = 3;
		Assert.assertEquals(expected, grumpyBookStore(customers,grumpy,minutes));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] customers = {4,10,10};
		int[] grumpy =    {1,1,0};
		int minutes = 2;
		int expected = 24;
		Assert.assertEquals(expected, grumpyBookStore(customers,grumpy,minutes));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm: Two Pointer
	 * 
	 * 1. Create variables left, right, satisfied, notsatisfied and additional and initiate all to 0
	 * 2. For the length of customers, add all the non-zero entry minutes
	 * 3. For the first "minutes", add the values of customers when grumpy ==1
	 * 4. Slide through each value and remove if the customer contains grumpy value 1
	 * 5. Sum satisfied and additional
	 */	
	
	private int grumpyBookStore(int[] customers, int[] grumpy, int minutes) {
		int left = 0,right = 0,satisfied = 0,notSatisfied = 0,additional = 0;
		for(int i=0;i<customers.length;i++) if(grumpy[i]!=1) satisfied += customers[i];
		for(right = 0;right<minutes;right++) if(grumpy[right]==1) notSatisfied += customers[right];
		additional = notSatisfied;
		while(right<customers.length) {
			if(grumpy[right]==1) notSatisfied += customers[right];
			if(grumpy[left]==1) notSatisfied -= customers[left];
			additional = Math.max(notSatisfied, additional);
			left++;
			right++;
		}
		System.out.println(satisfied+additional);
		return satisfied+additional;
	}
	
	
}

