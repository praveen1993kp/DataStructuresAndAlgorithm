package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P15_SubdomainVisitCount {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 811
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
		String[] cpdomains = {"9001 discuss.leetcode.com"};
		findCountPairedArrays(cpdomains);
	}

	@Test
	public void example2() {
		//Edge Case Test Data
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		findCountPairedArrays(cpdomains);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] cpdomains = {"900 google.mail.com"};
		findCountPairedArrays(cpdomains);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create hashMap
	 * 2. Traverse through given array
	 * 3. Split each string by " " to obtain the prefix number
	 * 4. Split the str[1] string by \\. to obtain distinct words
	 * 5. Create stringbuilder
	 * 6. Start from last index of str array and insert at 0 index into sb. Before exiting loop, add into hashmap
	 * 7. If the index is not last index of str, insert with .
	 * 8. Once all the words are added into hashMap, append the value and key with " " in between and stor in a list
	 * 9. Return the list
	 * 
	 * 
	 */	
	
	private List<String> findCountPairedArrays(String[] cpdomains) {
		HashMap<String,Integer> hMap = new HashMap<>();
        for(int i=0;i<cpdomains.length;i++){
            String[] number = cpdomains[i].split(" ");
            String[] str = number[1].split("\\.");
            StringBuilder sb1 = new StringBuilder();
            for(int j=str.length-1;j>=0;j--){
                sb1.insert(0,str[j] + (j < str.length-1 ? "." : ""));                         
                hMap.put(sb1.toString(),hMap.getOrDefault(sb1.toString(),0)+Integer.valueOf(number[0]));
            }
        }
        List<String> lst = new ArrayList<>();
        for(Entry<String, Integer> entry : hMap.entrySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            lst.add(sb.toString());
        }
        return lst;	
	}
}
