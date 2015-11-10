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
	protected static final Color[]	colors = new Color[5];
	protected ScaledPoint 	stack;              	// Contains scaled coordinates for drawing
	protected Color       	color;					// Default color of stack outline        
    
    public StackFrame()
    //POST: creates a box object with starting location at (0.25, 0.25),
    //      width set to 0.25, height set to 0.75, and color set to BLACK
    {
        this.stack = new ScaledPoint(0.10, 0.20, 0.40, 0.75);      
        color = Color.BLACK;
        colors[0] = new Color(0, 102, 255);
        colors[1] = new Color(128, 204, 255);
        colors[2] = new Color(9, 156, 255);
        colors[3] = new Color(255, 68, 68);
        colors[4] = new Color(51, 255, 51);
    }
   
    public StackFrame(Graphics g, Object userData, int appWidth, int appHeight, 
                      int currentStackFrameCount, int totalStackFrameSize, Color topColor)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: creates a box object and draws this box a with starting 
    //      location at (0.25, 0.25), width set to 0.25, height 
    //      set to 0.75, and color set to BLACK
    {    	
        double stackBottom = (0.95-(0.75/totalStackFrameSize));
		double stackFrameSize = ((0.75/totalStackFrameSize)*(currentStackFrameCount-1));
		double yLoc = stackBottom -	stackFrameSize ;
		this.stack = new ScaledPoint(0.10, yLoc , 0.40, 0.75/totalStackFrameSize);
        
        color = colors[(int)(Math.random()*colors.length)];
        
        //Ensures that every new stack frame's color is different from the top's
        while(color.equals(topColor))
        {
        	color = colors[(int)(Math.random()*colors.length)];
        }
        
        this.userdata = userData;
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);               
        g.fillRect(x, y, width, height);
    }

    public void redraw(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: updates object and redraws with new coordinates based
    //      on new appWidth and appHeight
    {                
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);

        g.setColor(color);   
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0,0,0));      
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString((String)userdata, x+width/2, y+height/2);
    }
    
    
    public void pause()
    //PRE:  NONE
    //POST: puts the thread to sleep for 1/8 of a second
    {
        try
        {
            Thread.sleep(250);
        }catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    
    public void flash(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: updates object and redraws with new coordinates based
    //      on new appWidth and appHeight

    {
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);
        
        for(int i=0; i<2; i++){
            g.setColor(Color.black);
            g.fillRect(x,y,width,height);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            g.drawString((String)userdata, x+width/2, y+height/2);
            
            pause();
                    
            g.setColor(Color.white);
            g.fillRect(x,y,width,height);
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            g.drawString((String)userdata, x+width/2, y+height/2);
            
            pause();
        }
        
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
