// Programmers: Chris Griffith, Oliver San Juan, Muhammad K. Khan, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: This class represents the each individual nodes of a stack, Object to represent 
// 				the current data, and a pointer to the next node in the stack

public class StackNode
{
	// Data Dictionary
	protected Object data;				// the value the current node holds 
	protected StackNode next;			// pointer to the next node
	
	public StackNode(Object data) 
	// PRE: data is of type Object and is initialized
	// POST: creates a new StackNode with data set to data
	{
		this.data = data;
	}
	
	public StackNode(Object data, StackNode node) 
	// PRE: data,node are initialized
	// POST: creates a new instance of a StackNode with 
	// data set to data and next StackNode set to node
	{
		this(data);
		this.next = node;
	}
}