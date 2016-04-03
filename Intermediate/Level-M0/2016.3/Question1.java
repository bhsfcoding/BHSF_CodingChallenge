/*
@author: Mingxuan Zha
Question:
Implement a class for queue data structure using array. 
The class should at least have methods of enqueue() and dequeue().
Method calls:
enqueue(0);
dequeue();
*/

import java.util.*;

public class myQueue{
	public static int[] queue = new int[1];
	public static int size = 1;
	public static int beginIndex = 0;
	public static int endIndex = 0;

	/*
	This method adds an element into the queue at the tail.
	The array structure to store the queue is always with minimum length
	Efficiency: O(1)
	Memory: O(1)
	*/
	public void enqueue(int data){
		if(endIndex+1 == size){//endIndex at the end
			if(beginIndex == 0){//queue is full
				resize();
				enqueue(data);
			}
			else{//queue has space before beginIndex
				endIndex = 0;
				queue[endIndex] = data;
			}
		}
		else if(endIndex < beginIndex){//endIndex is before beginIndex
			if(endIndex +1 == beginIndex){//queue is full
				resize();
				enqueue(data);
			}
			else{
				endIndex = endIndex+1;
				queue[endIndex] = data;
			}
		}
		else{//general case, append at the end
			endIndex = endIndex+1;
			queue[endIndex] = data;
		}
	}

	/*
	This method removes and returns the head of the queue.
	The array structure to store the queue is always with minimum length
	Efficiency: O(1)
	Memory: O(1)
	*/
	public int dequeue(){
		int info = queue[beginIndex];
		beginIndex = beginIndex+1;
		if(beginIndex == size){//set 0 when new beginIndex exceeds queue size
			beginIndex = 0;
		}
		return info;
	}

	/*
	This method resizes the queue when the queue array is full, by generating a new queue
	by doubling the length and copying current data
	Efficiency: O(n)
	Memory: O(n)
	*/
	public void resize(){
		size *= 2; //update new array length
		int[] newqueue = new int[size]; //create new array with double length
		if(beginIndex<=endIndex){//only happens when beginIndex=0 and endIndex=queue.length
			for(int i=0; i<queue.length; i++){
				newqueue[i] = queue[i];
			}
	    }
	    else{//copy from beginIndex to the end, and then from start to endIndex
	    	int counter = 0;
	    	for(int i=beginIndex; i<queue.length; i++){
	    		newqueue[counter] = queue[i];
	    		counter++;
	    	}
	    	for(int j=0; j<=endIndex; j++){
	    		newqueue[counter] = queue[j];
	    		counter++;
	    	}
	    }
	    //update indices and queue contents
	    beginIndex = 0;
	    endIndex = queue.length-1;
		queue = newqueue;
	}
}