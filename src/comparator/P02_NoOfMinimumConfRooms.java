package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P02_NoOfMinimumConfRooms {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an String array A of size N denoting time intervals of different meetings.
	 * Find the minimum number of conference rooms required so that all meetings can be done.
	 * 
	 * Hint Comparator
	 * 
	 * 
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
		String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"}, {"10 40", "12 00"},{"11 00", "13 00"}, {"11 45", "14 00"},{"16 00", "17 00"}};
		int expectedOutput = 3;
		Assert.assertEquals(expectedOutput, minConfRooms2(meetingTimes));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String[][] meetingTimes = {{"09 00", "09 30"},{"09 00", "09 30"},{"10 30", "11 00"},{"10 40", "11 40"}};
		int expectedOutput = 2;
		Assert.assertEquals(expectedOutput, minConfRooms2(meetingTimes));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[][] meetingTimes = {{"09 00", "09 30"},{"12 00", "12 10"},{"13 30", "13 50"},{"10 40", "11 40"}};
		int expectedOutput = 1;
		Assert.assertEquals(expectedOutput, minConfRooms2(meetingTimes));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a 2D array.
	 * --Loop Begins--
	 * 2. Traverse till end of meetingTimes length
	 * 3. Replace the space with "" in each meeting time and convert it into int and store in new array
	 * --Loop Ends--
	 * 4. Use Arrays.sort(lst, ) and using lambda, create (a,b) ->
	 * 7. Inside comparator compare method,
	 * 		7a. If e1 value is not equal to e2 value, return e1 value - e2 value
	 * 		7b. Else return e1 key - e2 key
	 * 8. Initialize variables left=0 and right=1
	 * 9. Traverse till right is less that meeting times length
	 * 10. If e1 endtime <= e2 starttime, decrease the counter and increment right
	 * 11. Increase right by default for every loop
	 * 12. Return the counter
	 * 
	 */	
	
	public void minConfRooms(String[][] meetingTimes) {
		HashMap<Integer,Integer> hMap = new HashMap<>();
		int counter = meetingTimes.length;
		
		for(int i=0;i<meetingTimes.length;i++) {
			int currentKey = Integer.valueOf(meetingTimes[i][0].replace(" ", ""));
			int currentVal = Integer.valueOf(meetingTimes[i][1].replace(" ", ""));;
			
			hMap.put(currentKey, currentVal);
		}
		
		List<Entry<Integer,Integer>> lst = new ArrayList<> (hMap.entrySet());
		
		Collections.sort(lst, new Comparator<Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer,Integer> e1, Entry<Integer,Integer> e2) {
				if(e1.getValue() != e2.getValue()) return e1.getValue() - e2.getValue();
				else return e1.getKey() - e2.getKey();
				}		
		});
		
		int left = 0,right = 1;
		while(right < meetingTimes.length) {
			int endTime = lst.get(left).getValue();
			int startTime = lst.get(right).getKey();
			if(endTime <= startTime) {
				counter--;
				left++;
			}
			right++;
		}
		
		System.out.println(counter);
	
		
	}
	
	
	public int minConfRooms2(String[][] meetingTimes) {
		int counter = meetingTimes.length;
		int[][] integerTimes = new int[meetingTimes.length][2];

		for(int i=0;i<counter;i++){
			integerTimes[i][0] = Integer.valueOf(meetingTimes[i][0].replace(" ",""));
			integerTimes[i][1] = Integer.valueOf(meetingTimes[i][1].replace(" ",""));
		}

		Arrays.sort(integerTimes, (a,b) -> {
			if (a[1]!=b[1]) return a[1] - b[1];
			else return a[0] - b[0];
		});

		int left = 0,right = 1;

		while(right<meetingTimes.length){
			int prevEndTime = integerTimes[left][1];
			int currStrTime = integerTimes[right][0];
			if(prevEndTime <= currStrTime){
				counter--;
				left++;
			}
			right++;
		}
		
		System.out.println(counter);
		return counter;
		
	}
}
