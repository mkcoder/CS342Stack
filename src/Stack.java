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
