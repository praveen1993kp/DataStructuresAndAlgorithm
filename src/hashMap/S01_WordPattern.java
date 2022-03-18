package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class S01_WordPattern {

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
		String[] str = {"abb","abc","aba","nmm"};
		String pattern = "mnn";
		getAllMatchingPatterns(str,pattern);
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
	 */	
	
	private boolean isMatchingPattern(String word, String pattern) {
		int len = word.length();
		if (pattern.length() != len) return false;
		int[] ch = new int[128];

		for(int i = 0; i < len; i++){
			if (ch[(int)pattern.charAt(i)] == 0) { // should check that value does not exist in the given char array
				for (int j = 0; j < ch.length; j++) {
					if(ch[j] ==  word.charAt(i)) return false;
				}
				ch[(int)pattern.charAt(i)] = word.charAt(i);
			}else if (ch[(int)pattern.charAt(i)] != word.charAt(i))
				return false;
		}
		return true;
	}


	// Time complexity: O[n*m*128]
	private List<String> getAllMatchingPatterns(String[] str, String pattern){
		List<String> lst = new ArrayList<String>();
		for(String word : str)
			if (isMatchingPattern(word, pattern)) lst.add(word);
		return lst;
		
	}
}
