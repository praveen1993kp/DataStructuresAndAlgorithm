package hashMap;

import java.util.HashMap;

import org.junit.Test;

public class P01_jewelsAndStones {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode - 771
	 * 
	 * You're given strings jewels representing the types of stones that are jewels, 
	 * and stones representing the stones you have. 
	 * Each character in stones is a type of stone you have. 
	 * You want to know how many of the stones you have are also jewels.
	 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  -- YES
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
		String jewels = "aA";
		String stones = "aAAabbbb";
		jewelsAndStonesHashMap(jewels,stones);
		
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String jewels = "z";
		String stones = "ZZ";
		jewelsAndStonesHashMap(jewels,stones);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String jewels = "zZa";
		String stones = "ZZaaS";
		jewelsAndStonesHashMap(jewels,stones);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force:
	 * 
	 * 1. Create two pointers left and right
	 * 2. Point left to jewels and second pointer to stones
	 * 3. If jewel.charat(left) matches stones.charAt(right), add to hashmap
	 * 4. While adding to hashmap, check if count already exists. If so, increment by one
	 * 5. Loop till end of jewels
	 * 
	 * HashMap:
	 * 
	 * 1. Create a hashmap and add jewels into hashmap
	 * 2. Traverse through the stones string
	 * 		2a. For each character in stones, if the character is available in hmap, increase counter
	 * 3. Return the counter
	 * 
	 * Ascii:
	 * 
	 * 1. Create a jewelsArray which can accomodate the ascii of jewel characters
	 * 2. Add all the jewel character ascii into array
	 * 3. Traverse through stones array. If the ascii entry of given character in array is greater than 0,
	 * 		then increment the count
	 * 4. Return the count.
	 * 
	 */	
	
	private int jewelsAndStones(String jewels, String stones) {
		// Brute Force Method
		int left = 0,right = 0,counter=0;
		//HashMap<Character,Integer> hMap = new HashMap<>();
		while (left<jewels.length()) {
			if (jewels.charAt(left)==stones.charAt(right)) {
				//hMap.put(jewels.charAt(left), hMap.getOrDefault(jewels.charAt(left), 0)+1);
				counter++;
			}
			right++;
			if(right==stones.length()) {
				left++;
				right=0;
			}	
		}
		System.out.println(counter);
		return counter;
	}
	
	private int jewelsAndStonesHashMap(String jewels, String stones) {
		int counter = 0;
		HashMap<Character,Integer> hMap = new HashMap<>();
		for(int i = 0;i<jewels.length();i++) hMap.put(jewels.charAt(i), 1);
		for(int j=0;j<stones.length();j++) if(hMap.containsKey(stones.charAt(j))) counter++;
		System.out.println(counter);
		return counter;
	}
	
	private int jewelsAndStonesAscii(String jewels, String stones) {
		int count=0;
        int[] jewelsArray = new int[128];
        for(int i=0;i<jewels.length();i++){
            jewelsArray[jewels.charAt(i)-'A']++;
        }
        
        for(int i=0;i<stones.length();i++){
            if(jewelsArray[stones.charAt(i)-'A']>0) count++;
        }
        return count;
	}
}
