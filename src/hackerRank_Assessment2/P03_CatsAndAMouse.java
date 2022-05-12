package hackerRank_Assessment2;

import org.junit.Test;

public class P03_CatsAndAMouse {
	
	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Two cats and a mouse are at various positions on a line. You will be given their starting positions. Your task is to determine which cat will reach the mouse first, assuming the mouse does not move and the cats travel at equal speed. If the cats arrive at the same time, the mouse will be allowed to move and it will escape while they fight.

You are given  queries in the form of , , and  representing the respective positions for cats  and , and for mouse . Complete the function  to return the appropriate answer to each query, which will be printed on a new line.

If cat  catches the mouse first, print Cat A.
If cat  catches the mouse first, print Cat B.
If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
Example




The cats are at positions  (Cat A) and  (Cat B), and the mouse is at position . Cat B, at position  will arrive first since it is only  unit away while the other is  units away. Return 'Cat B'.
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
		int x = 1;
		int y = 2;
		int z = 3;
		System.out.println(catsAndMouse(x,y,z));		
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int x = 1;
		int y = 3;
		int z = 2;
		System.out.println(catsAndMouse(x,y,z));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Calculate the absolute difference between mouse and each cat
	 * 2. If cat A travel time is less than cat B travel time, return Cat A
	 * 3. Else if cat B travel time is less than cat A travel time, return Cat B
	 * 4. Else return Mouse C.
	 * 
	 */	
	
	public String catsAndMouse(int x,int y,int z) {
		int catATravelTime = Math.abs(z-x);
        int catBTravelTime = Math.abs(z-y);
        if(catATravelTime < catBTravelTime) return "Cat A";
        else if (catATravelTime > catBTravelTime) return "Cat B";
        else return "Mouse C";
	}
}
