/*
@author: Mingxuan Zha
Question:
There is a huge matrix(grid) of integers, about millions by millions (N*M). Each cell contains either 1 or 0.
Given a subgrid(indices of four corner of this subgrid), return the number of 1s in it. This method will be called frequently.
Hint: since the method is frequently called, try to process the huge matrix first, and lower the complexity for each method call.
Inputs:
grid: int[N][M] (global variable)
corners: int[4][2] ([row, column] pairs for upper left, upper right, lower left and lower right)
Output:
integer
*/

import java.util.*;


public static int[][] dataGrid;
public static long N;
public static long M;
//the above values have already been imported

public static int[][] onesGrid = new int[N][M];

//Using dynamic programming to get number of 1s on the right and lower part of the grid from current cell
public void processGrid(){
	onesGrid[N][M] = dataGrid[N][M];

}

/*
Analysis:
Efficiency: O(N*M)
Memory: O(N*M)
*/

public int Solution(int[][] corners){
	int upperleft = onesGrid[corners[0][0]][corners[0][1]];
	int upperright = onesGrid[corners[1][0]][corners[1][1]];
	int lowerleft = onesGrid[corners[2][0]][corners[2][1]];
	int lowerright = onesGrid[corners[3][0]][corners[3][1]];
	return upperleft-upperright-lowerleft+lowerright;
}

/*
Analysis:
Efficiency: O(1)
Memory: O(1)
*/