package bruteForce_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class P01_ReverseVowels {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode No - 345
	 * 
	 * Given a string s, reverse only all the vowels in the string and return it. The vowels are 'a','e','i','o','u'
	 * and they can appear in both cases
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
		String str = "AbraCadABRa";
		String reversedStr = "abrACadaBRA";
		Assert.assertEquals(reverseVowels(str), reversedStr);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String str = "A man, a plan, a canal: Panama";
		String reversedStr = "a man, a plan, a canal: PanamA";
		Assert.assertEquals(reverseVowels(str), reversedStr);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String str = "qwrty";
		String reversedStr = "qwrty";
		Assert.assertEquals(reverseVowels(str), reversedStr);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse through the inputString and if there are any vowels, add the index and character to map
	 * 2. Get the keyset() from map and store it in array
	 * 3. Create variable k and assign it with arraylength-1;
	 * 4. Iterate through the array elements and for each index, get the key and values
	 * 5. Swap key and values for the selected two keys
	 * 6. Traverse through the array and form 
	 * 
	 */	
	
	public String reverseVowels(String s){
		Map<Integer,Character> tmap = new TreeMap(); //O[1];
		char[] vowels = {'a','A','e','E','i','I','o','O','u','U'};
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i)=='a')||(s.charAt(i)=='e')||(s.charAt(i)=='i')||(s.charAt(i)=='o')||(s.charAt(i)=='u')||
					(s.charAt(i)=='A')||(s.charAt(i)=='E')||(s.charAt(i)=='I')||(s.charAt(i)=='O')||(s.charAt(i)=='U')){
									tmap.put(i,s.charAt(i));
			}
		}
		Set<Integer> keys = tmap.keySet();
		Object[] keysArray = keys.toArray();
		int j = keys.size()-1;
		char temp;
		for(int k=0;k<keys.size()/2;k++) {
			int key1 = (int) keysArray[k];
			int key2 = (int) keysArray[j];
			char value1 = tmap.get(key1);
			char value2 = tmap.get(key2);
			temp = value1;
			value1 = value2;
			value2 = temp;
			tmap.put(key1, value1);
			tmap.put(key2, value2);
			j--;
		}
		String outputString = "";
		for(int y=0;y<s.length();y++) {
			if(keys.contains(y)) {
				outputString = outputString + tmap.get(y);	
			}
			else {
				outputString = outputString + s.charAt(y);
			}
		}
		System.out.println(outputString);
		return outputString;
	}
	
	

		
}		

	
	
		
		


