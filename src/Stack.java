// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
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
	// POST: fctval == return the current value on top of the stack 
	{
		return head.data;
	}
	
	public Object pop()
	// POST: pushes the top of the stack and returns it
	// fctval == return the value at the top of the stack
	{
		StackNode returnNode = head;		
		head = head.next;
		return returnNode.data;
	}

	@Override
	public Iterator<StackNode> iterator() {
		// TODO Auto-generated method stub		
		return new Iterator<StackNode>() {
			StackNode temp = head;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return temp != null;
			}

			@Override
			public StackNode next() {
				// TODO Auto-generated method stub
				StackNode r = temp;
				temp = temp.next;
				return r;
			}
			
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}		
		};
	}
}
