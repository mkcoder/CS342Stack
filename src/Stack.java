
class StackNode <T>
{
	public StackNode(T data) 
	{
		this.data = data;
	}
	
	T data;
	StackNode<T> next;
}

public class Stack<T> 
{
	StackNode<T> head;
	StackNode<T> tail;
	
	public void push(T data)
	{
		StackNode<T> node = new StackNode<T>(data);
		
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
		StackNode<T> _tail = tail;
		StackNode<T> temp = head;
		StackNode<T> prev = null;
		while ( temp != tail ) 
		{
			prev = temp;
			temp = temp.next;
		}
		tail = prev;
		return _tail;
	}
	
}
