package bruteForce_Arrays;

import org.junit.Test;

public class P06_GasStation {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 134 - Gas Station
	 * 
	 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
	 * to its next (i+1) th station. You begin the journey with an empty tank at one of the gas 
	 * stations.
	 * 
	 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel
	 * around the circuit once in the clockwise direction, otherwise return -1.
	 * 
	 * If there exists a solution, it is guaranteed to be unique.
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
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int expectedOutput = 3;
		findStartingGasStation(gas,cost);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		int expectedOutput = -1;
		findStartingGasStation(gas,cost);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] gas = {5,8,2,8};
		int[] cost = {6,5,6,6};
		int expectedOutput = 3;
		findStartingGasStation(gas,cost);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] gas = {5,1,2,3,4};
		int[] cost = {4,4,1,5,1};
		int expectedOutput = 4;
		findStartingGasStation(gas,cost);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Since the amt cost should be more than gas, if gasSum < costSum then return -1
	 * 2. Else, Traverse till length of either of the arrays
	 * 3. Add the previous efficiency value with next gas cost - travel cost
	 * 4. If the efficiency value is < 0, reset the index as current +1 and efficiency as 0
	 * 5. Return the start index finally
	 * 
	 */	
	
	private int findStartingGasStation(int[] gas, int[] cost) {
		int efficiency = 0,startIndex = 0;
		
		int gasSum = 0,costSum = 0;
		for(int i=0;i<gas.length;i++) {
			gasSum += gas[i];
			costSum += cost[i];
		}
		if(gasSum < costSum) return -1;
		else {
			for(int i=0;i<gas.length;i++) {
				efficiency += gas[i] - cost[i];
				if(efficiency < 0) {
					startIndex = i+1;
					efficiency = 0;
				}			
			}	
		}
		System.out.println(startIndex);
		return startIndex;

	}
}
