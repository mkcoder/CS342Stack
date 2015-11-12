// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: This class represents the each individual nodes of a stack, Object to repsent 
// 		the current data, and a pointer to the next node in the stack

import java.util.Iterator;

public class StackNode
{
	// Data Dictionary
	protected Object data;				// the value the current node hold 
	protected StackNode next;			// pointer to a the next nodex
	
	public StackNode(Object data) 
	// PRE: data is of type object and is initialized
	// POST: creates a new StackNode with data set to data
	{
		this.data = data;
	}
	
	public StackNode(Object data, StackNode node) 
	// PRE: data,node is of initialized
	// POST: creates a new instance of a StackNode with 
	// data set to data and next StackNode set to node
	{
		this(data);
		this.next = node;
	}
}