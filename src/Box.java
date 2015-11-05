// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class which holds information about stack drawing

import java.awt.Graphics;
import java.awt.Color;

public class Box
{	
    private ScaledPoint stack;              // Contains scaled coordinates for drawing
    private Color       color;              // Default color of stack outline
    private final int width;
    private final int height;
    
    public Box()
    //POST: creates a box object with starting location at (0.25, 0.25),
    //      width set to 0.25, height set to 0.75, and color set to BLACK
    {
        this.stack =  null;        
        color = Color.BLACK;
        width = 0;
        height = 0;
    }
   
    public Box(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: creates a box object and draws this box a with starting 
    //      location at (0.25, 0.25), width set to 0.25, height 
    //      set to 0.75, and color set to BLACK
    {
    	width = 300+150;
    	height = 30+500;
        this.stack = new ScaledPoint((appWidth/2-width), (appHeight/2-height), width, height);
        color = Color.BLACK;
        
        int x = stack.scaledX(appWidth);
        int y = stack.scaledY(appHeight);

        g.setColor(color);
        g.drawRect(0, 0, width, height); 
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
        g.drawRect(x, y, width, height); 
    }
}
