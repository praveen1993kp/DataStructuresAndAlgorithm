package twoPointer_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P06_ImplementstrStr {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 28
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
		String haystack = "hello";
		String needle = "ll";
		Assert.assertEquals(2, implementStr(haystack,needle));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String haystack = "mississippi";
		String needle = "pi";
		Assert.assertEquals(9, implementStr(haystack,needle));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String haystack = "aaaaa";
		String needle = "bba";
		Assert.assertEquals(-1, implementStr(haystack,needle));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String haystack = "babbbbbabb";
		String needle = "bbab";
		Assert.assertEquals(-1, implementStr(haystack,needle));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two ascii arrays
	 * 2. Create a stringbuilder
	 * 3. Traverse right for the length of needle and add update respective ascii values
	 * 4. If arrays are equal,
	 * 		4a. Check if the sequence is same as that of original
	 * 		4b. If equal, return true
	 * 5. Start from right and traverse till length of haystack
	 * 6. Decrement left value ascii and increment right value ascii
	 * 7. Repeat step 4
	 * 8. Return -1 if none of the conditions matches
	 * 
	 */	
	
	private int implementStr(String haystack, String needle) {
		if(needle=="") return 0;
        if(needle.length() > haystack.length()) return -1;
        
        int[] haystackAscii = new int[26];
        int[] needleAscii = new int[26];
        StringBuilder sb;
        
        int left=0,right=0;
        while(right<needle.length()){
            haystackAscii[haystack.charAt(right)-'a']++;
            needleAscii[needle.charAt(right++)-'a']++;
        }
        
        if(Arrays.equals(haystackAscii,needleAscii)) {
        	sb = new StringBuilder();
            for(int temp=left;temp<right;temp++){
                sb.append(haystack.charAt(temp));                    
            }
            if(sb.toString().equals(needle)) return left;   
        }
        
        while(right<haystack.length()){ 
            haystackAscii[haystack.charAt(left++)-'a']--;
            haystackAscii[haystack.charAt(right++)-'a']++;
            if(Arrays.equals(haystackAscii,needleAscii)) {
                sb = new StringBuilder();
                for(int temp=left;temp<right;temp++){
                    sb.append(haystack.charAt(temp));                    
                }
                if(sb.toString().equals(needle)) return left;    
            }
        }
        return -1;
	}
}
