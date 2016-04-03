/*
@author: Mingxuan Zha
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
	HashSet<Integer> set = new HashSet<>();
	ArrayList<int[]> result = new ArrayList<>();
	//for each number in array, generate the addend to target
	for(int i=0; i<numArray.length; i++){
		if(!set.contains(target-numArray[i])){
			set.add(target-numArray[i]);
		}
	}
	//check for pairs and add to the result
	for(int j=0; j<numArray.length; j++){
		if(set.contains(numArray[j])){
			int[] pair = new int[2];
			pair[0] = Math.min(numArray[j],target-numArray[j]);
			pair[1] = Math.max(numArray[j],target-numArray[j]);
			result.add(pair);
		}
	}
	return result;
}

/*
Analysis:
Efficiency: O(n)
Memory: O(n)
*/