// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class which holds information about stack drawing

import java.awt.Graphics;
import java.awt.Color;

public class Box
{
    protected ScaledPoint stack;              // Contains scaled coordinates for drawing
    protected Color       color;              // Default color of stack outline

    public Box()
    //POST: creates a box object with starting location at (0.25, 0.25),
    //      width set to 0.25, height set to 0.75, and color set to BLACK
    {
        this.stack = new ScaledPoint(0.10, 0.20, 0.40, 0.75);
        
        color = Color.BLACK;
    }
   
    public Box(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: creates a box object and draws this box a with starting 
    //      location at (0.25, 0.25), width set to 0.25, height 
    //      set to 0.75, and color set to BLACK
    {
    	// TODO: adding bottom arrow with label
    	// you have the bottom of the stack which would be
    	// X=0.10, y=0.20, W=0.40, H=0.75
    	// 
    	//	(X,Y)
    	//  [     W      ]  <- <= (1,1+W+PADDING_TO_THE_RIGHT_OF_THE_STACK) 
    	//
    	//
    	//		  H       
    	//
    	//
    	//  [     W      ]  <- <= (1,Y+W+PADDING_TO_THE_RIGHT_OF_THE_STACK)    	
    	//                   
        this.stack = new ScaledPoint(0.10, 0.20, 0.40, 0.75);        
        color = Color.BLACK;

        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);
        g.setColor(color);
        g.drawRect(x, y, width, height);
        
        
    }

    public void redraw(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: updates object and redraws with new coordinates based
    //      on new appWidth and appHeight
    {
        color = Color.BLACK;

        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);
        int width = stack.scaledWidth(appWidth);
        int height = stack.scaledHeight(appHeight);

        g.setColor(color);
        System.out.println("I WAS CALLED");
        
        //Draw line showing the bottom of the stack
        g.drawLine(x+width+10, y+height, x+width+150, y+height);
        g.drawString("Stack Bottom",x+width+40, y+height);
        
        g.drawRect(x, y, width, height); 
    }
}