/*
@author: Mingxuan Zha
Question:
Given a long String and a pattern String, determine if the pattern exists in the long String
Inputs:
samp: String
pat: String
Output:
boolean
*/

import java.util.*;

public boolean Solution(String samp, String pat){
	int len = pat.length();
	for(int i=0; i<samp.length()-len; i++){
		//cut consecutive characters in the sample with same length as pattern and compares
		if(samp.substring(i, i+len).equals(pat)){
			return true;
		}
	}
	return false;
}

/*
Analysis:
Efficiency: O(n)
Memory: N/A
*/