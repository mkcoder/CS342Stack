public class StackNode
{
	// Data Dictionary
	protected Object data;				// the value the current node hold 
	protected StackNode next;			// pointer to a the next node
	protected ScaledPoint location;		// the current location of the stack frame
	
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
	
	public StackNode(Object data, StackNode node, ScaledPoint location)
	{
		this(data, node);
		this.location = location;
	}

	public ScaledPoint getLocation() {
		return location;
	}

	public void setLocation(ScaledPoint location) {
		this.location = location;
	}
}