/**
* Name: Ashley Hanson
* ClassID: 306
* Assignment 2
* Description: 
*	This assignment is designed to give you practice with using a version control system. 
*	You can use any control, github is recommended but many students prefer bitbucket. 
*	You must allow access to your repository to the TA and the grader for grading.
*	Make the following changes to current list:
*		- Add(int): Add the parameter to the beginning of the list (index = 0). 
*		Move all the other integers over so there is room. If the list was initially full, then 
*		increase the size by 50%. Increment the count.
*		- Remove(int): If the parameter is in the list, remove it. The other values in the list 
*		may need to be moved down. Adjust the count as needed. If the list has more than 
*		25% empty places, decrease the size of the list. The list cannot be reduced to less than 1 entry.
*		- Append(int): Append the parameter to the end of the list. If the list was full, then 
*		increase the size by 50% so there will be room. Increment the count.
*		- First(): int Return the first element in the list. If there are no elements, return -1.
*		- Last(:) int Return the last element in the list. If there are no elements, return -1.
*		- Size(): int Return the current number of possible locations in the list.
*/
package cse360assign2;

import java.util.*;

public class SimpleList {
	
	private int [] list;
	private int count;
	
	/** Create an array to hold 10 integers
	 *  Set count to zero
	 */
	public SimpleList() {

		this.list = new int[10];
		this.count = 0;
		}	
	
	/**	Add the parameter to the list at the beginning (index = 0). Move all the integers over 
	 * 	to make room. If list is full, increase the size by 50%.
	 *	Increment count.
	 *	@param x
	 */
	public void add(int x) {
		if (count == list.length) {		//If the list is full					
			int half = count / 2;		//Increase the size of the list	by half	
			newLength(count + half);
		}
		for(int i = count; i > 0; i--) {
			list[i] = list[i - 1];
		}
			list[0] = x;				//Position 0 = x
			count ++;					//Increment count
			//System.out.println("Number Added: " + x);
		}
	
	/**
	 * Change the length of the old array to the size of the new array.
	 * @param length2
	 */
	public void newLength(int length2) {
		int arr[] = new int[length2];
		for(int i = 0; i < length2 && i < count; i++) {
			arr[i] = list[i];
		}
		list = arr;
		if(length2 < count) {
			count = length2;
		}
	}
	
	/**	The list was full, then the last element "falls off" the list.
	 *	If the number is not on the list, then number not found. If the list
	 *	has more than 25% empty places, decrease the size. The list cannot
	 *	be reduced to less than 1 entry.
	 *	@param x 	
	 */
	public void remove(int x) {
		int index = search(x);
		if (index != -1) {				//Remove element
			for(int i = index; i < count-1; i++) {
				list[i] = list[i+1];	//Shift the elements
			}
			//list[list.length - 1] = 0;
			count --;
			//System.out.println("Removed Number: " + x);
		}
		else {
			//System.out.println("Number not found: " + x);
		}
		//Decrease the size of the list
		int num = 3 * list.length / 4;
		if (count < num) {
			newLength(count);
		}
	}
	/**
	 *  Append the parameter to the end of the list. If the list
	 *  is full, increase the size by 50%. Increment count.
	 *  @param x
	 */
	public void append(int x) {
		if(count == list.length) {		//If list is full increase size by half
			int half = count / 2;
			newLength(count + half);
		}
		list[count] = x;
		count ++;						//Increment count
	}
	/**
	 *  Return the first element in the list. If there are no 
	 *  elements, return -1.
	 *  @return
	 */
	public int first() {
		if(count == 0) {
			return -1;
		}
		return list[0];					//Return first element
	}
	/**
	 *  Return the last element in the list. If there are no 
	 *  elements, return -1.
	 *  @return
	 */
	public int last() {
		if(count == 0) {
			return -1;
		}
		return list[list.length - 1];	//Return last element
	}
	
	/**
	 * Return the current number of possible locations in the list.
	 * @return
	 */
	public int size() {
		return list.length;
	}
	
	/**	Return the list as a String. The elements must be separated by a space.
	 *	This means there is not space after the last integer.
	 *	@return str
	 */
	public String toString() {
		String str = "";
		for(int i = 0; i < count; i++) {
			str += list[i];
			if (i != count-1) {
				str += " ";
			}
		}
		//System.out.println(str);
		return str;
	}
	
	/**	Return the number of elements stored in the list.
	 * 	@return index
	 */
	public int count() {
		//System.out.println("count: " + count);
		return count;
	}
	
	/** Return the last location of the parameter in the list
	 * @param  x
	 * @return index
	 */
	public int search(int x) {
		int index = -1;
		for(int i = count - 1; i >= 0; i--) {
			if(list[i] == x) {
				index = i;
				return index;
			}
		}
		//System.out.println("Index: " + index);
		return index;	//Return -1 if x != i
	}


}
