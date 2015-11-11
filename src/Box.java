// Programmers: Chris Griffith, Oliver San Juan, Muhammad K. Khan, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class which holds information about stack drawing

import java.awt.Graphics;
import java.awt.Color;

public class Box
{
    private static final int XOFFSET = 40;      // X coordinate offset for stack labels
    private static final int YOFFSET = 150;     // Y coordinate offset for stack labels
    private static final int TWENTYFIVE = 25;   // Arrow head ratio
    
    protected ScaledPoint stack;                // Contains scaled coordinates for drawing
    protected Color       color;                // Default color of stack outline

    public Box()
    //POST: creates a box object with starting location at (0.10, 0.20),
    //      width set to 0.40, height set to 0.75, and color set to BLACK
    {
        this.stack = new ScaledPoint(0.10, 0.20, 0.40, 0.75);
        
        color = Color.BLACK;
    }
   
    public Box(Graphics g, int appWidth, int appHeight)
    //PRE:  g is initialized, appWidth > 0, and appHeight > 0
    //POST: creates a box object and draws this box a with starting 
    //      location at (0.10, 0.20), width set to 0.40, height 
    //      set to 0.75, and color set to BLACK
    {
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

        //Draw label and arrow to show how the stack grows
        g.drawString("Stack Grows", x+width+XOFFSET, (y+(height/2))+10);
        g.drawLine(x+width+TWENTYFIVE, (y+(height/2))+TWENTYFIVE, 
                   x+width+TWENTYFIVE, (y+(height/2)-TWENTYFIVE));

        //Draw arrow head
        g.drawLine(x+width+TWENTYFIVE, (y+(height/2))-TWENTYFIVE, x+width+15, (y+(height/2)));
        g.drawLine(x+width+TWENTYFIVE, (y+(height/2))-TWENTYFIVE, x+width+35, (y+(height/2)));

        //Draw line showing the bottom of the stack
        g.drawLine(x+width+10, y+height, x+width+YOFFSET, y+height);
        g.drawString("Stack Bottom",x+width+XOFFSET, y+height);

        //Draw line showing the bottom of the stack
        g.drawLine(x+width+10, y+height, x+width+150, y+height);
        g.drawString("Stack Bottom",x+width+40, y+height);

        //Draw stack outline
        g.drawRect(x, y, width, height); 
    }
}
