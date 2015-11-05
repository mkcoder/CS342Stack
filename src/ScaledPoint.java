// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class to facilitate re-sizing of an applet

public class ScaledPoint
{
    protected static int width;          // stores a scaled rectangle width
    protected static int height;         // stores a scaled rectangle height
    protected double x;              // stores a scaled x coordinate
    protected double y;              // stores a scaled y coordinate

    public ScaledPoint()
    //POST: creates an object with x, y, width, & height equal to zero
    {
        this(0.0, 0.0, 0, 0);
    }
    
    public ScaledPoint(double x, double y, int width, int height)
    //PRE:  x > 0.0, y > 0.0
    //POST: creates an object with coordinate (x,y), width set
    //      to width, and height set to height
    {
        this.x=x/width;
        this.y=y/height;
        this.width = width;
        this.height = height;
    }
    
    public int scaledX(int appletWidth)
    //PRE:  appletWidth > 0
    //POST: FCTVAL == the scaled x coordinate based on appletWidth
    {
        return (int)(appletWidth*x);
    }
    
    public int scaledY(int appletHeight)
    //PRE:  appletHeight > 0
    //POST: FCTVAL == the scaled y coordinate based on appletHeight
    {
        return (int)(appletHeight*y);
    }
}
