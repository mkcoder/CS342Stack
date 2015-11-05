// Programmers: Chris Griffith, Oliver San Juan, Muhammad, Ken Devane
// Assignment:  Project 3, Data Structure Visualization
// Date:        November 4, 2015
// Description: Class to facilitate re-sizing of an applet

public class ScaledPoint
{
    private double x;              // stores a scaled x coordinate
    private double y;              // stores a scaled y coordinate
    private double width;          // stores a scaled rectangle width
    private double height;         // stores a scaled rectangle height

    public ScaledPoint()
    //POST: creates an object with x, y, width, & height equal to zero
    {
        this(0.0,0.0, 0.0, 0.0);
    }
    
    public ScaledPoint(double x, double y, double width, double height)
    //PRE:  x > 0.0, y > 0.0
    //POST: creates an object with coordinate (x,y), width set
    //      to width, and height set to height
    {
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
    }
    
    public int scaledX(int appletWidth)
    //PRE:  appletWidth > 0
    //POST: FCTVAL == the scaled x coordinate based on appletWidth
    {
        return (int)(appletWidth*this.x);
    }
    
    public int scaledY(int appletHeight)
    //PRE:  appletHeight > 0
    //POST: FCTVAL == the scaled y coordinate based on appletHeight
    {
        return (int)(appletHeight*this.y);
    }

    public int scaledWidth(int appletWidth)
    //PRE:  appletWidth > 0
    //POST: FCTVAL == the scaled width of rectangle based on appletWidth
    {
        return (int)(appletWidth*this.width);
    }

    public int scaledHeight(int appletHeight)
    //PRE:  appletHeight > 0
    //POST: FCTVAL == the scaled height of rectangle based on appletHeight
    {
        return (int)(appletHeight*this.height);
    }
}
