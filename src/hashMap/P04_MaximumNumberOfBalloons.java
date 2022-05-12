package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P04_MaximumNumberOfBalloons {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1189
	 * 
	 * Given a string text, you want to use the characters of text to form as many
	 * instances of the word "balloon" as possible.
	 * 
	 * You can use each character in text at most once. Return the maximum number of
	 * instances that can be formed.
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
		String text = "loonbalxballpoon";
		int output = 2;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String text = "nlaebolko";
		int output = 1;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String text = "leetcode";
		int output = 0;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
		
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String text = "baonxxoll";
		int output = 1;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
		
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		String text = "baoollnnololgbax";
		int output = 2;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
		
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		String text = "balllllllllllloooooooooon";
		int output = 1;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
		
	}
	
	@Test
	public void example7() {
		//Negative Test Data
		String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
		int output = 10;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
		
	}
	
	@Test
	public void example8() {
		//Negative Test Data
		String text = "mbetypbpefxvviadqaodrbjeoacfomepmzymiudltgnvnpbowwmjgpzzhtiismearuwocsgbiimiqqzaozgeizikrlxmupfzjzmlfttqqbpfblqfkecsdfbsceqjhubfxksivrfwvukapxmuciybfhzlmpeamdxziptxregymqtmgcsujmugissgnlbhxbcxxeoumcqyulvahuianbaaxgzrtmshjguqdaxvxndzoqvwmcjfhpevavnrciqbymnlylbrfkkiceienoarfrzzxtuaqapaeqeqolozadmtgjyhfqzpuaskjuawxqkdqyjqcmbxtvshzrquvegcuyuckznspmrxvqdassidcmrajedsnuuumfwqzvasljlyvfefktiqgvzvdzojtjegsyhbepdkuwvgrfscezvswywmdavpxlekbrlkfnbyvlobazmvgulxrfdranuhomkrlpbfeagfxxxuhjuqhbkhznixquxrxngwimdxdhqbdaouitsvcdmbwxbbaomkgxsqwnexbjjyhtxvkjfqkrrxjghvzqsattubphryqxxdyjkihfnzvjhohnhdlfwoqiwtmwzfgcyhyqtcketvgnbchcxvnhcsoosirfqgdgcsitegzlxdfijzmxnvhrulmgvoqfpzesootscnxenokmmozmoxpaverydbsnimwacjqhrtxkqtvghjyushoctxphxzztukgmnoeycqaeukymvwxcsyvvctflqjhtcvjtxncuvhkptkjnzaetwbzkwnseovewuhpkaxiphdicgacszzdturzgjkzwgkmzzavykancvvzaafgzjhcyicorrblmhsnnkhfkujttbkuuedhwguuaapojmnjdfytdhrepjwcddzsoeutlbbljlikghxefgbqenwamanikmynjcupqpdjnhldaixwygcvsgdkzszmsptqqnroflgozblygtiyaxudwmooiviqcosjfksnevultrf";
		int output = 14;
		Assert.assertEquals(output, findMaximumNumberOfBalloons2(text));
		
	}
	
	
	
	
	
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * HashMap:
	 * 
	 * 1. Create a hashmap and insert the balloon values in it
	 * 2. Iterate through the given string text and if the characters are already available in hmap,
	 * 		add them to the same hashmap
	 * 3. After all the elements are added, reduce the count of b,a,n by 1 and l,o by 2
	 * 4. Find the minimum count among all the characters and that forms the maximum balloons
	 * 
	 * Ascii:
	 * 
	 * 1. Add the given string characters into a char array (using their ascii)
	 * 2. Get the minimum count of b,a,n and l/2 and o/2.
	 * 3. That gives maximum number of balloons can be formed from input text.
	 */	
	
	
	private int findMaximumNumberOfBalloons(String text) {
		int currentElement=0,counter=Integer.MAX_VALUE,diff=Integer.MAX_VALUE,diff2=Integer.MAX_VALUE;
		String balloon = "balloon";
		HashMap<Character,Integer> balloonMap = new HashMap<>();
		for(int i=0;i<balloon.length();i++) {
			balloonMap.put(balloon.charAt(i), balloonMap.getOrDefault(balloon.charAt(i), 0)+1);
		}
		while(currentElement<text.length()) {
			boolean b1 = false;
			char currentVal = text.charAt(currentElement++);
				b1 = balloonMap.containsKey(currentVal);
				if(b1) balloonMap.put(currentVal, balloonMap.get(currentVal)+1);	
			}
		Iterator<Character> keys = balloonMap.keySet().iterator();
		while(keys.hasNext()) {
			char ch = keys.next();
			if(ch != 'l' && ch != 'o') diff = balloonMap.get(ch)-1;
			else diff2 = (balloonMap.get(ch)-2)/2;
			counter = Math.min(counter, Math.min(diff, diff2));
		}
		return counter;
	}
	
	private int findMaximumNumberOfBalloons_UsingEntrySet(String text) {
		HashMap<Character,Integer> hMap = new HashMap<>();
        String target = "balloon";
        int count = 0;
        for(int i=0;i<text.length();i++){
           char ch = text.charAt(i);
           if(ch=='b' || ch=='a' || ch== 'l' || ch== 'o' || ch=='n'){
               hMap.put(ch,hMap.getOrDefault(ch,0)+1);
               count++;
           }          
        }
        if(count < target.length()) return 0;
        System.out.println(hMap.toString());
        int maxBalloons = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> entry: hMap.entrySet()){
            if(entry.getKey() == 'l' || entry.getKey() == 'o')
                maxBalloons = Math.min(maxBalloons,entry.getValue()/2);
            else
                maxBalloons = Math.min(maxBalloons,entry.getValue());
        }
        return maxBalloons;
	}
	
	private int findMaximumNumberOfBalloons2(String text) {
		int counter=Integer.MAX_VALUE;
		int[] ascii = new int[26];
		char[] carray = text.toCharArray();
		for(char ch : carray) {
			ascii[ch-'a']++;
		}
		counter = Math.min(counter, ascii['b'-'a']);
		counter = Math.min(counter, ascii['a'-'a']);
		counter = Math.min(counter, ascii['l'-'a']/2);
		counter = Math.min(counter, ascii['o'-'a']/2);
		counter = Math.min(counter, ascii['n'-'a']);
		return counter;
	}
		
}

