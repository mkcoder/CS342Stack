// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: This class is the GUI interface for visualizing 
//              the stack data structure. 

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.*;
import java.lang.Object;
import javax.swing.JOptionPane;

public class StackGUI extends JApplet implements ActionListener
{
    // Declarations of class-wide variables
    private JFrame       frame;                  // Used for pop up windows
    private Stack		 stackFrames;            // Stack backend object
    private Box          stack;                  // Graphics outline for the stack
    private StackFrame   currentFrame;           // Stack frame to be pushed/popped
    private JLabel       pushLabel;              // Label for push textbox
    private JTextField   pushText;               // Field to input push choice from user
    private JButton      pushButton;             // Button to push value on to stack
    private JButton      popButton;              // Button to pop value off of stack
    private JButton	     topButton;				 //	Button to display the top of the stack
    private JButton      createStack;            // Button to draw the stack
    private JButton      reset;                  // Button to reset stack
    private Color        colorSelected;          // Color of the drawings
    private String       message;                // Input to be pushed onto stack
	private int          currentFrameCount;	     // Frame count
    private int          appletWidth;            // Applet pixel width
    private int          appletHeight;           // Applet pixel Height
    private int          stackSize;              // Size of stack entered by user
    //private int          xLoc;                   // X coordinate
    //private int          yLoc;                   // Y coordinate
    private boolean      isCreate;               // Create button selected
	private boolean      pushButtonClicked;      // Push button selected
	private boolean      popButtonClicked;       // Pop button selected
    private boolean      topButtonClicked;       // Top button selected

    
    // Initializing all elements of the GUI
    @Override
    public void init()
    {
        this.setupGUI();                       // Setup the gui
        
        // Initialize data dictionary variables
        message = "";                          // Default message
        //xLoc = 0;                              // Default location values
        //yLoc = 0;                              //   and location values
        isCreate = false;                      // Create button starts unselected
        stackFrames = new Stack();
        pushButtonClicked = false;			   // Push button is false as default
        popButtonClicked = false;			   // Pop button is false as default
        topButtonClicked = false;			   // Top button is false as default
        currentFrameCount = 0;                 // Number of frames on stack
        
    }

    private void setupGUI()
    // POST: a gui interface is created
    {
        JPanel panel;                          // Main panel
        JPanel topRow;                         // Top row GUI components panel
        GridLayout layout;                     // Border layout 

        colorSelected = new Color(0, 0, 0);    // Drawing color starts as black until changed
        
        // Create gui components
        panel = new JPanel();
        topRow = new JPanel();
        layout = new GridLayout(2, 1);
        pushLabel = new JLabel("Input to push onto stack:");
        pushText = new JTextField(10);
        pushButton = new JButton("Push");
        popButton = new JButton("Pop");
        topButton = new JButton("Top");
        createStack = new JButton("Create Stack");
        reset = new JButton("Reset");

        panel.setLayout(new BorderLayout());

        // background color for north panel
        topRow.setBackground(new Color(220, 255, 193));

        // set panel size
        topRow.setSize(appletHeight / 4, appletWidth);

        topRow.setLayout(layout);

        layout.setHgap(10);
        layout.setVgap(10);

        // disable the buttons
        pushButton.setEnabled(false);
        popButton.setEnabled(false);
        topButton.setEnabled(false);
        
        // Add action listener to text field and buttons
        pushText.addActionListener(this);
        pushButton.addActionListener(this);
        popButton.addActionListener(this);
        createStack.addActionListener(this);
        reset.addActionListener(this);
        topButton.addActionListener(this);

        // Add components to the panel
        topRow.add(createStack);
        topRow.add(pushButton);
        topRow.add(popButton);
        topRow.add(pushLabel);
        topRow.add(pushText);
        topRow.add(topButton);
        //topRow.add(reset);
 
        // Add panel to GUI
        add(panel);
        panel.add(topRow, BorderLayout.NORTH);
    }

    // Display results
    @Override
    public void paint(Graphics g)
    {
    	//Data Dictionary
    	Color topColor;						 // Top frame's color
        boolean temp;                        // Temporary flag variable
        StackFrame topFrame;                 // Points to top frame in stack

        super.paint(g);
        
        appletHeight = getHeight();          // Height of applet in pixels
        appletWidth = getWidth();            // Width of applet in pixels
        temp = true;                         // Flag is set to true by default

        if(isCreate)                         // Draw stack since user clicked create stack button
        {
            // enable the buttons
            pushButton.setEnabled(true);
            popButton.setEnabled(true);
            topButton.setEnabled(true);
           
            // update stack drawing
            stack.redraw(g, appletWidth, appletHeight);                        
        }
 
        if((currentFrameCount+1 > stackSize) && pushButtonClicked)      // Draw stack frames 
        {
        	temp = true;
        	
            // Display error if stack is full
        	JOptionPane.showMessageDialog(null, "segfault stackoverflow.");

            // Redraw each frame pushed onto stack
        	for ( StackNode f : stackFrames ) 
        	{
           		if(temp == true)						//If top of stack, draw the label
        		{
        			((StackFrame)f.data).redraw(g, appletWidth, appletHeight, true);
        			temp = false;
        		}
        		
        		else								//Otherwise, don't draw the "stack top" label
        		{
            		//System.out.println(((StackFrame)f.data).userdata);
            		((StackFrame)f.data).redraw(g, appletWidth, appletHeight, false);
        		}
        	}
        	

            // Reset push button
        	pushButtonClicked = false;
        	return;
        }
        
        if((currentFrameCount <= 0) && 
           (popButtonClicked || topButtonClicked)) // Redraw stack frames after selecting pop or top 
        {
        	// Display error if stack is empty
            JOptionPane.showMessageDialog(null, "there is nothing to pop/top.");

            // Redraw each frame if pop or top button is selected
        	for ( StackNode f : stackFrames ) 
        	{
        		//System.out.println(((StackFrame)f.data).userdata);
        		((StackFrame)f.data).redraw(g, appletWidth, appletHeight, false);
        	}

            // Reset pop and top buttons
        	popButtonClicked = false;
        	topButtonClicked = false;
        	return;
        }
        
        if(isCreate && pushButtonClicked && 
           currentFrameCount < stackSize)         // 
        {
        	
            temp = true;
            topFrame = new StackFrame();          // Create new Stack Frame

            // Search for top frame on stack
            for ( StackNode f : stackFrames )
            {
                if(temp)                           
                {
                    topFrame=((StackFrame)f.data);
                    temp=false;
                }
            }
            
            topColor = topFrame.getColor();
            currentFrameCount++;
            currentFrame = new StackFrame(g, message, appletWidth, 
            		appletHeight, currentFrameCount, stackSize, topColor);
            stackFrames.push(currentFrame);
            System.out.println("---------");
            
            temp = true;
            
        	for ( StackNode f : stackFrames ) 
        	{
        		if(temp == true)						//If top of stack, draw the label
        		{
        			((StackFrame)f.data).redraw(g, appletWidth, appletHeight, true);
        			temp = false;
        		}
        		
        		else									//Otherwise, don't draw the "stack top" label
        		{
            		//System.out.println(((StackFrame)f.data).userdata);
            		((StackFrame)f.data).redraw(g, appletWidth, appletHeight, false);
        		}
        	}
        	System.out.println("---------");
            System.out.println("Frame count is "+currentFrameCount);

        	//currentFrameCount++;
        	pushButtonClicked = false;
        }

        else if ( isCreate && popButtonClicked &&
             currentFrameCount > 0)
        {
        	stackFrames.pop();
        	currentFrameCount--;
            System.out.println("Frame count is "+currentFrameCount);
        	
        	for ( StackNode f : stackFrames ) 
        	{
           		if(temp == true)						//If top of stack, draw the label
        		{
        			((StackFrame)f.data).redraw(g, appletWidth, appletHeight, true);
        			temp = false;
        		}
        		
        		else								//Otherwise, don't draw the "stack top" label
        		{
            		//System.out.println(((StackFrame)f.data).userdata);
            		((StackFrame)f.data).redraw(g, appletWidth, appletHeight, false);
        		}
        	}
        	popButtonClicked = false;
        	
        }
        else if(topButtonClicked)
        {
            temp = true;
            topFrame = new StackFrame();
            for ( StackNode f : stackFrames )
            {
                if(temp)
                {
                    topFrame=((StackFrame)f.data);
                    ((StackFrame)f.data).redraw(g, appletWidth, appletHeight, true);
                    temp = false;
                }
                else
                {
                    System.out.println(((StackFrame)f.data).userdata);
                    ((StackFrame)f.data).redraw(g, appletWidth, appletHeight, false);
                }

            }
            
            if(currentFrameCount>0)
            {
                topFrame.flash(g,appletWidth,appletHeight);
            }
            topButtonClicked=false;
        }
        else
        {
        	System.out.println("---------");
        	for ( StackNode f : stackFrames ) 
        	{
        		System.out.println(((StackFrame)f.data).userdata);
        		((StackFrame)f.data).redraw(g, appletWidth, appletHeight, false);
        	}
        	System.out.println("---------");
        }
        
    }

    // Process user actions
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == createStack)         // User clicked create stack button
        {
            try
            {
            	String input = JOptionPane.showInputDialog("Please enter a stack size"
                        + " greater than 0 and less than or equal to 25");
            	System.out.println(input);
                stackSize = new Integer(input);
                
                while ( stackSize <= 0 || stackSize > 25 ) 
                {
                	JOptionPane.showMessageDialog(null, "Please enter something between 0 - 25");
                	stackSize = Integer.parseInt(JOptionPane.showInputDialog("Please enter a stack size"
                            + " greater than 0 and less than or equal to 25"));                	
                }
                
                stack = new Box();
                isCreate = true;
                createStack.setEnabled(false);    //Deactivate because user can create stack once

            }
            catch(NullPointerException npe)
            {
                stackSize = 0;
            }
        }
    
        if(e.getSource() == pushButton)          // User clicked push button
        {
            try
            {
                message = pushText.getText();
            }
            catch(NullPointerException npe)
            {
                message = "";
            }

            currentFrame = new StackFrame();
            pushButtonClicked = true;
        }

        if(e.getSource() == popButton)
        {
        	popButtonClicked = true;
        }
        
        if(e.getSource() == topButton)
        {
            topButtonClicked=true;
        }

        repaint();
    }
}
