
class StackNode <T>
{
	public StackNode(T data) 
	{
		this.data = data;
	}
	
	public StackNode(T data, StackNode<T> node) 
	{
		this(data);
		this.prev = node;
	}

	T data;
	StackNode<T> next;
	StackNode<T> prev;
}

public class Stack<T> 
{
	StackNode<T> head;
	StackNode<T> tail;
	
	public void push(T data)
	{
		StackNode<T> node = new StackNode<T>(data, tail);
		
		if ( head == null ) 
		{
			head = node;			
		}
		else
		{
			tail.next = node;
		}
		
		tail = node;
	}
	
	public StackNode<T> pop()
	{
		StackNode<T> returnNode = tail;		
		tail.prev.next = null;
		tail = returnNode.prev;
		return returnNode;
	}
}
