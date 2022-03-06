package bruteForce_String;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P10_DefangingAnIPAddress {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1108
	 * 
	 * Defanging An IP Address
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
		String address = "1.1.1.1";
		String output = "1[.]1[.]1[.]1";
		Assert.assertEquals(output, defangingIPAddress_WithoutInbuiltMethod(address));
	}


	@Test
	public void example2() {
		//Edge Case Test Data
		String address = "242.2342.229.291";
		String output = "242[.]2342[.]229[.]291";
		Assert.assertEquals(output, defangingIPAddress_WithoutInbuiltMethod(address));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Using string replace function, replace . with [.] and store in a string
	 * 2. Return string
	 * 
	 * Without Inbuilt method:
	 * 
	 * 1. Create a stringBuilder
	 * 2. Traverse through each character
	 * 3. If character is . , append[.]
	 * 4. Else append the character as it is
	 * 5. Return sb.toString();
	 */	
	
	private String defangingIPAddress(String address) {
		String str = address.replace(".","[.]");
        return str;
	}
	
	private String defangingIPAddress_WithoutInbuiltMethod(String address) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<address.length();i++) {
			if(address.charAt(i)=='.') sb.append("[.]");
			else sb.append(address.charAt(i));
		}
        return sb.toString();
	}
}
