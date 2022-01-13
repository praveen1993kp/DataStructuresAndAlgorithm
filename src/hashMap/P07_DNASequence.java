package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P07_DNASequence {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 187
	 * 
	 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
	 * 
	 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) 
	 * that occur more than once in a DNA molecule. 
	 * You may return the answer in any order.
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
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String[] output = {"AAAAACCCCC","CCCCCAAAAA"};
		findRepeatedDNASequence(s);
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "AAAAAAAAAAAAA";
		String[] output = {"AAAAAAAAAA"};
		findRepeatedDNASequence(s);

	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "AAACGTAAA";
		String[] output = {};
		findRepeatedDNASequence(s);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private ArrayList<String> findRepeatedDNASequence(String s) {
		ArrayList<String> al = new ArrayList<>();
		HashMap<String,Integer> hMap = new HashMap<>();
		int left=0,right=left+10;
		
		if(s.length()<10) return al;
		
		while(right<s.length()) {
			right=left+10;
			String currentSequence = "";
			for(int i=left;i<right;i++) currentSequence += s.charAt(i);
			hMap.put(currentSequence, hMap.getOrDefault(currentSequence, 0)+1);
			left++;	
		}
		
		for(Entry<String,Integer> entry : hMap.entrySet()) {
			if(entry.getValue()>1) al.add(entry.getKey());
		}
		
		System.out.println(hMap.toString());
		System.out.println(al.toString());
		return al;
	}
}
