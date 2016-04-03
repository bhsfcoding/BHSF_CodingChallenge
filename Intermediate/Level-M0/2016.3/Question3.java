/*
@author: Mingxuan Zha
Question:
Given two sorted single linkedLists, merge then into a new sorted single linkedList.
Do not create new Node and minimize the lines of code that you wrote
Inputs:
list1: Node
list2: Node
Output:
Node
*/

import java.util.*;

/*
Here is the definition of Node
*/
public class Node{
	int val;
	Node next;
}

/*
Write your solution here
*/
public Node Solution(Node list1, Node list2){
	//for each number in array, generate the addend to target
	Node head; //initialize head
	if(list1.val<list2.val){
		head = list1;
		list1 = list1.next;
	}
	else{
		head = list2;
		list2 = list2.next;
	}
	Node tail = head;
	while(list1!=null && list2!=null){//merge two lists
		if(list1==null){//list1 is null, always append from list2
			tail.next = list2.val;
			list2 = list2.next;
		}
		else if(list2==null){//list2 is null, always append from list1
			tail.next = list1.next;
			list1 = list1.next;
		}
		else{//neither is null, append from the smaller one
			if(list1.val<list2.val){
				tail.next = list1;
				list1 = list1.next;
			}
			else{
				tail.next = list2;
				list2 = list2.next;
			}
		}
		tail = tail.next;
	}
	return head;
}

/*
Analysis:
Efficiency: O(n+m)
Memory: O(1), in place
*/