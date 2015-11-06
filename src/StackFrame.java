// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class which holds information about stack drawing

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class StackFrame
{
	protected Object 		userdata;			// 
	protected ScaledPoint stack;              	// Contains scaled coordinates for drawing
	protected Color       color;					// Default color of stack outline        
    
    public StackFrame()
    //POST: creates a box object with starting location at (0.25, 0.25),
    //      width set to 0.25, height set to 0.75, and color set to BLACK
    {
        this.stack = new ScaledPoint(0.10, 0.20, 0.40, 0.75);      
        color = Color.BLACK;
    }
   
    public StackFrame(Graphics g, Object userData, int appWidth, int appHeight, 
                      int currentStackFrameCount, int totalStackFrameSize)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: creates a box object and draws this box a with starting 
    //      location at (0.25, 0.25), width set to 0.25, height 
    //      set to 0.75, and color set to BLACK
    {    	
        this.stack = new ScaledPoint(0.10, 0.20+((0.75/totalStackFrameSize)*currentStackFrameCount), 0.40, 0.75/totalStackFrameSize);
        color = Color.ORANGE;
        this.userdata = userData;
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);
        g.setColor(color);        
        g.fillRect(x, y, width, height);
    }

    public void redraw(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: updates object and redraws with new coordinates based
    //      on new appWidth and appHeight
    {        
        color = Color.ORANGE;
        
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);

        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0,0,0));        
        g.drawString((String)userdata, x+width/2, y+height/2);
    }
}
