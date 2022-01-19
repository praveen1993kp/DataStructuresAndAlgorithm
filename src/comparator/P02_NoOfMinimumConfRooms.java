package comparator;

import java.util.ArrayList;
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
		minConfRooms(meetingTimes);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String[][] meetingTimes = {{"09 00", "09 30"},{"11 00", "11 10"},{"10 30", "11 00"},{"10 40", "11 40"}};
		int expectedOutput = 2;
		minConfRooms(meetingTimes);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[][] meetingTimes = {{"09 00", "09 30"},{"12 00", "12 10"},{"13 30", "13 50"},{"10 40", "11 40"}};
		int expectedOutput = 1;
		minConfRooms(meetingTimes);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	public void minConfRooms(String[][] meetingTimes) {
		HashMap<String,String> hMap = new HashMap<>();
		
		for(int i=0;i<meetingTimes.length;i++) {
			String currentKey = meetingTimes[i][0];
			String currentVal = meetingTimes[i][1];
			
			hMap.put(currentKey, currentVal);
		}
		
		List<Entry<String,String>> lst = new ArrayList<> (hMap.entrySet());
		
		Collections.sort(lst, new Comparator<Entry<String,String>>() {

			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				int vals = e1.getValue().compareTo(e2.getValue());
				
				return vals;
				
				}
			
		});
		
		System.out.println(lst.toString());
		
		
		
		
	}
}
