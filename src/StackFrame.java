// Programmers: Chris Griffith, Oliver San Juan, Muhammad K. Khan, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class which holds information about stack drawing

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class StackFrame
{	
	protected static final Color[]	COLORS = new Color[5]; // Holds the choices for random colors
	protected Object 		userdata;                      // Holds the user's data
	protected ScaledPoint 	stack;                         // Contains scaled coordinates for drawing
	protected Color       	color;                         // Default color of stack outline
    
    public StackFrame()
    //POST: creates a box object with starting location at (0.25, 0.20),
    //      width set to 0.40, height set to 0.75, color set to BLACK and
    //      COLORS set to chosen stack frame colors
    {
        this.stack = new ScaledPoint(0.25, 0.20, 0.40, 0.75);      
        color = Color.BLACK;
        COLORS[0] = new Color(0, 102, 255);
        COLORS[1] = new Color(128, 204, 255);
        COLORS[2] = new Color(9, 156, 255);
        COLORS[3] = new Color(255, 68, 68);
        COLORS[4] = new Color(51, 255, 51);
    }
   
    public StackFrame(Graphics g, Object userData, int appWidth, int appHeight, 
                      int currentStackFrameCount, int totalStackFrameSize, Color topColor)
    //PRE:  g, userdata, and topColor are initialized, appWidth, appHeight, 
    //      currentStackFrameCount, and totalStackFrameSize are > 0, 
    //POST: creates a box object and draws this box a with starting 
    //      location at (0.25, yLoc), width set to 0.40, height 
    //      set to 0.75/totalStackFrameSize, and COLORS set to randomly
    {    	
        double stackBottom = (0.95-(0.75/totalStackFrameSize));
		double stackFrameSize = ((0.75/totalStackFrameSize)*(currentStackFrameCount-1));
		double yLoc = stackBottom -	stackFrameSize ;
		
        this.stack = new ScaledPoint(0.25, yLoc , 0.40, 0.75/totalStackFrameSize);
        
        //Get a random color
        color = COLORS[(int)(Math.random()*COLORS.length)];
        
        //Ensures that every new stack frame's color is different from the top's
        while(color.equals(topColor))
        {
        	color = COLORS[(int)(Math.random()*COLORS.length)];
        }
        
        //set the height and widths and x and y coordinates to the
        //respective scaled values
        this.userdata = userData;
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);               
        g.fillRect(x, y, width, height);
    }
    

    public void redraw(Graphics g, int appWidth, int appHeight, boolean isTop)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: updates object and redraws with new coordinates based
    //      on new appWidth and appHeight
    {
        //set the height and widths and x and y coordinates to the
        //respective scaled values
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);
        
        //Set frame to a random color and output the data
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0,0,0));      
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString((String)userdata, x+width/2, y+height/2);
        
        if(isTop == true)	     //If the current object is the top of the stack, draw the label
        {
        	g.setColor(Color.BLACK);
            g.drawLine(x+width+10, y, x+width+150, y);
            g.drawString("Stack top",x+width+40, y);
        }
    }
    
    
    public void pause()
    //POST: puts the thread to sleep for 1/8 of a second
    {
        try
        {
            Thread.sleep(250);                  //Pause program for 1/8 of a second
        }catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt(); //Current thread was interrupted
        }
    }
    
    
    public void flash(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: flashes the top frame of the stack and returns the
    //      frame back to normal afterwards.
    {
        //set the height and widths and x and y coordinates to the
        //respective scaled values
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);
        
        
        for(int i=0; i<2; i++) //Repeat the flash twice
        {
            
            //Set frame to black and text to white, and draw
            g.setColor(Color.black);
            g.fillRect(x,y,width,height);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            g.drawString((String)userdata, x+width/2, y+height/2);
            
            //sleep for 1/8 of a second
            pause();
            
            //Set frame to white and text to black, and draw
            g.setColor(Color.white);
            g.fillRect(x,y,width,height);
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            g.drawString((String)userdata, x+width/2, y+height/2);
            
            //sleep for 1/8 of a second
            pause();
        }
        
        //Same as the redraw() method; set frame to a random color and output the data
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString((String)userdata, x+width/2, y+height/2);
    }
    
    public Color getColor()
    //POST: FCTVAL == protected class member color
    {
    	return this.color;
    }
}
