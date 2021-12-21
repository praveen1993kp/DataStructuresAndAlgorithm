package slidingWindow_String;

import org.junit.Test;

import junit.framework.Assert;

public class Template {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 1876
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
		String s = "aababcabc";
		int counter = 4;
		Assert.assertEquals(counter, maxUniqueSubstring(s));
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "abracadabra";
		int counter = 7;
		Assert.assertEquals(counter, maxUniqueSubstring(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "aabbcc";
		int counter = 0;
		Assert.assertEquals(counter, maxUniqueSubstring(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private int maxUniqueSubstring(String s) {
		int left = 0, right = 3, counter = 0;		//O[1]
		while(right<=s.length()) {					//O[n]
			String str = "";						//O[1]
			for(int i=left;i<right;i++) {			//O[3]
				str += s.charAt(i);
			}
			char s1 = str.charAt(0);				//O[1]
			char s2 = str.charAt(1);				//O[1]
			char s3 = str.charAt(2);				//O[1]
				if(s1!=s2 && s2!=s3 && s1!=s3) counter++;	//O[1]
				left++;
				right++;
				}
		System.out.println(counter);
		return counter;
	}
}
