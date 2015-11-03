
class StackNode
{
	// Data Dictionary
	protected Object data;				// the value the current node hold 
	protected StackNode next;			// pointer to a the next node
	
	
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

public class Stack
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
}
