package bruteForce_String;

import org.junit.Test;

public class P09_MaximumNumberOfWordsFoundInSentences {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2114
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
		String[] sentences = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
		System.out.println(findMaxLengthString(sentences));
	}	

	@Test
	public void example2() {
		//Edge Case Test Data
		String[] sentences = {"please wait","continue to fight","continue to win"};
		System.out.println(findMaxLengthString(sentences));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] sentences = {"","",""};
		System.out.println(findMaxLengthString(sentences));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Initialize variable maxLength
	 * 2. Traverse through the sentences array
	 * 3. For each string, split it using " ".
	 * 4. Find the max between maxLength and current string array length
	 * 5. Return maxLength
	 * 
	 */	
	
	private int findMaxLengthString(String[] sentences) {
		// TODO Auto-generated method stub
		int maxLength=0;
        for(int i=0;i<sentences.length;i++){
            String s = sentences[i];
            String[] arr = s.split(" ");
            maxLength = Math.max(maxLength,arr.length);
        }
        return maxLength;
	}
}