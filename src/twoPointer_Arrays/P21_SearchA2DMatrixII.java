package twoPointer_Arrays;

import org.junit.Test;

public class P21_SearchA2DMatrixII {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 240
	 * 
	 * Search a 2D matrix II
	 * 
	 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
	 * 
	 * This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right.
	 * Integers in each column are sorted in ascending from top to bottom.
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
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 3;
		search2DMatrixII_bruteForce(matrix,target);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 35;	
		search2DMatrixII_bruteForce(matrix,target);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[][] matrix = {{1},{2},{3}};
		int target = 3;
		search2DMatrixII_bruteForce(matrix,target);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1 : Brute Force:
	 * 
	 * 1. Traverse through outer array
	 * 2. Traverse through inner array for each element in outer array
	 * 3. If the value matches, return true
	 * 4. Return false by default
	 * 
	 * Approach 2 : Binary Search and for loop
	 * 
	 * 1. Traverse through outer array
	 * 2. Create pointers left,right and mid
	 * 3. For each inner element, calculate mid and check if the value matches with target
	 * 4. If the value does not match, update left/right accordingly
	 * 5. When target is found, return true
	 * 6. Return false by default
	 * 
	 */	
	
	private boolean search2DMatrixII_bruteForce(int[][] matrix, int target) {
		int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target) return true;
            }
        }
        return false;	
	}
	
	private boolean search2DMatrixII_binarySearch(int[][] matrix, int target) {
		int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            int left=0,right=n-1,mid=0;
            while(left<=right){
                mid = (right+left)/2;
                if(matrix[i][mid]==target) return true;
                else if (matrix[i][mid]>target) right = mid-1;
                else left = mid+1;
            }
        }
        return false;	
	}

}
