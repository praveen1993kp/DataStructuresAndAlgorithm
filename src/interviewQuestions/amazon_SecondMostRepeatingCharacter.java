package interviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.junit.Test;

public class amazon_SecondMostRepeatingCharacter {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Find the second most repeating character in the given string
	 * 
	 * String s = "amazon development center"
	 * output n
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
		String s = "amazon development centre";
		findSecondMostCharacter(s);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a hashmap and add values into it
	 * 2. Get the values and store in an
	 * 
	 */	
	
	private void findSecondMostCharacter(String s) {
		Map<Character,Integer> hMap = new LinkedHashMap<>();
		
		for(char ch : s.toCharArray()) {
				hMap.put(ch, hMap.getOrDefault(ch, 0)+1);
		}
		ArrayList<Integer> lst = new ArrayList<>(hMap.values());
		System.out.println(lst);
		Collections.sort(lst);
		int secondMax = lst.get(lst.size()-2);
		
		for(Entry<Character,Integer> entry : hMap.entrySet()) {
			if(entry.getValue()==secondMax) System.out.println(entry.getKey());
		}
		
	}
}
