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
	Arrays.sort(numArray);
	ArrayList<int[]> result = new ArrayList<>();
	for(int i=0; i<numArray.length; i++){
		//do binary search to find the other addition component
		int start = 0;
		int end = numArray.length;
		int comp = target - numArray[i];
		while(start < end){
			int index = start+(end-start)/2; //calculate middle index without overflow
			if(numArray[index] == comp && index != i){//found the correct value, store the pair
				int[] pair = new int[2];
				pair[0] = Math.min(numArray[i],comp);
				pair[1] = Math.max(numArray[i],comp);
				result.add(pair);
			}
			else if(numArray[index] > comp){
				end = index;
			}
			else{
				start = index;
			}
		}
	}
	return result;
}

/*
Analysis:
Efficiency: O(n logn)
Memory: O(1)
*/