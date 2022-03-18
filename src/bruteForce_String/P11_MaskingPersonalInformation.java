package bruteForce_String;

import org.junit.Test;

public class P11_MaskingPersonalInformation {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 831
	 * 
	 * Masking Personal Information
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
		String s = "LeetCode@LeetCode.com";
		String output = "l*****e@leetcode.com";
		System.out.println(maskPersonalInfo(s));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "AB@qq.com";
		String output = "a*****b@qq.com";
		System.out.println(maskPersonalInfo(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "1(234)567-890";
		String output = "***-***-7890";
		System.out.println(maskPersonalInfo(s));
	}
	
	

	/*
	 * --- Pseudo Code ---	
	 * 
	 * 1. Create two methods 
	 * 		1a. For email masking
	 * 		1b. For phone number masking
	 * 2. If email, 
	 * 		2a. Create a stringbuilder
	 * 		2b. append the lowercase of email's first character in sb
	 * 		2c. Add 5 * after that
	 * 		2d. Append the lowercase value of character previous to @
	 * 		2e. Starting from @, append the lowercase values of each letter
	 * 3. If phone number,
	 * 		3a. Create a stringbuilder
	 * 		3b. Start from the last index, insert last 4 digits into sb
	 * 		3c. If the stringbuilder size crosses 4, for every 3 *, insert - at the prefix
	 * 		3d. At the end, if first character becomes -, remove it
	 * 		3e. If number of digits > 10, insert + at the beginning
	 * 4. Return email method or phone method based on the availability of character @
	 * 
	 */	
	
	private String maskPersonalInfo(String s) {
		return (s.contains("@")) ? maskEmail(s) : maskPhoneNumber(s);	
	}
	public String maskEmail(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(s.charAt(0)));
        for(int i=0;i<5;i++){
            sb.append("*");
        }
        int i = s.indexOf('@');
        sb.append(Character.toLowerCase(s.charAt(i-1)));
        while(i<s.length()){
            if(Character.isUpperCase(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
    public String maskPhoneNumber(String s){
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        int counter = 0,numeric=0;
        while(i>=0){
            if(Character.isDigit(s.charAt(i))){
                if(sb.toString().length()<4){
                    sb.insert(0,s.charAt(i));
                } else {
                    if(sb.toString().length()==4) sb.insert(0,"-");
                    sb.insert(0,"*");
                    counter++;
                    if(counter==3){
                        sb.insert(0,"-");
                        counter=0;
                    }
                }
                numeric++;
            } 
               i--;
        }
        if(sb.toString().charAt(0)=='-') sb.deleteCharAt(0);
        if(numeric>10) sb.insert(0,'+');
        return sb.toString();
    }
}
