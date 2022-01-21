package comparator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P03_MinimumNoOfPlatformsReqd {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Minimum Number of platforms required for a railway/Bus station
	 * 
	 * Give the arrival and departure times of all the trains that reach a railway station,
	 * the task is to find the minimum number of platforms required for the railway
	 * station so that no train waits.
	 * 
	 * We are given two arrays that represent the arrival and departure times of trains at that stop.
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
		String[] arr = {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"};
		String[] dep = {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};
		calculateMinNoPlatforms(arr,dep);
	}
	
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String[] arr = {"9:00", "9:40"};
		String[] dep = {"9:10", "12:00"};
		calculateMinNoPlatforms(arr,dep);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] arr = {"9:00", "9:10","9:13","9:50"};
		String[] dep = {"9:10", "9:12","9:50","10:00"};
		calculateMinNoPlatforms(arr,dep);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create trainTimings array with arr and dep timings
	 * 2. Traverse till length of either of the arrays and add replace : with "". Add to new array
	 * 3. Use Arrays.sort to sort the arrays
	 * 4. Compare previous departure time and current arr time to decrease the platforms count
	 * 
	 * 
	 */	
	
	private int calculateMinNoPlatforms(String[] arr, String[] dep) {
		int[][] trainTimings = new int[arr.length][2];
		int platforms = arr.length;
		for(int i=0;i<platforms;i++) {
			trainTimings[i][0] = Integer.valueOf(arr[i].replace(":", ""));
			trainTimings[i][1] = Integer.valueOf(dep[i].replace(":", ""));
		}
		
		Arrays.sort(trainTimings, (a,b) -> {
			if(a[1] != b[1]) return a[1] - b[1];
			else return a[0] - b[0];
		});
		
		int left=0,right=1;
		while(right<arr.length) {
			int prevDepTime = trainTimings[left][1];
			int currArrTime = trainTimings[right][0];
			if(prevDepTime <= currArrTime) {
				platforms--;
				left++;
			}
			right++;
		}
		System.out.println(platforms);
		return platforms;
	}

}
