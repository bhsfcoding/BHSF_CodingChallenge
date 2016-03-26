/*
Question:
Given an unsorted array of integers "numArray" and an integer "target", return all pairs of numbers in the array if their sum equals to "target" in an arrraylist, with the smaller number coming first in each pair.
Inputs:
numArray: array of integers
target: integer
Output:
ArrayList<int[]>
*/

import java.util.*;

public ArrayList<int[]> Solution(int[] numArray, int target){
	Arrays.sort(numArray);
	ArrayList<int[]> result = new ArrayList<>();
	for(int i=0; i<numArray.length; i++){
		//TODO: do binary search
		System.out.println("test");
	}
	return result;
}

/*
Analysis:
Efficiency: O(n logn)
Memory: O(1)
*/