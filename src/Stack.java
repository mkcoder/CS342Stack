
class StackNode
{
	public StackNode(Object data) 
	{
		this.data = data;
	}
	
	public StackNode(Object data, StackNode node) 
	{
		this(data);
		this.next = node;
	}

	Object data;
	StackNode next;
}

public class Stack
{
	StackNode head;
	
	public void push(Object data)
	{
		head = new StackNode(data, head);
	}
	
	public StackNode pop()
	{
		StackNode returnNode = head;		
		head = head.next;
		return returnNode;
	}
}
