// Programmers: Chris Griffith, Oliver San Juan, Muhammad K. Khan, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: This class represents the stack and it holds the head of the stack.

import java.util.Iterator;

public class Stack implements Iterable<StackNode>
{
	StackNode head;						// pointer to the top of the stack
	
	public void push(Object data)
	// PRE: data is initialized and is of type Object
	// POST: pushes a node to top of the stack
	{
		head = new StackNode(data, head);
	}
	
	public Object top()
	// POST: FCTVAL == the current value on top of the stack 
	{
		return head.data;
	}
	
	public Object pop()
	// POST: pops the top off of the stack and returns the new head
	// FCTVAL == return the new value at the top of the stack
	{
		StackNode returnNode = head;		
		head = head.next;
		return returnNode.data;
	}

	@Override
	public Iterator<StackNode> iterator() {	
		return new Iterator<StackNode>() {
			StackNode temp = head;
			@Override
			public boolean hasNext() {
				return temp != null;
			}

			@Override
			public StackNode next() {
				StackNode r = temp;
				temp = temp.next;
				return r;
			}
			
			@Override
			public void remove() {

				throw new UnsupportedOperationException();
			}		
		};
	}
}
