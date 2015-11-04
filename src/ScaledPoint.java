//
// Class to facilitate re-sizing of an applet
//

public class ScaledPoint
{
    private int x;              // stores a scaled x coordinate
    private int y;              // stores a scaled y coordinate
    
    public ScaledPoint()
    //POST: creates an object with coordinate (0,0)
    {
        this(0,0);
    }
    
    public ScaledPoint(int x, int y)
    //PRE:  x > 0, y > 0
    //POST: creates an object with coordinate (x,y)
    {
        this.x=x;
        this.y=y;
    }
    
    public static int scaledX(int currentX, double scaleFactor)
    //PRE:  currentX > 0, 0 < scaleFactor < 1
    //POST: FCTVAL == the scaled x coordinate based on scaleFactor
    {
        return (int)(scaleFactor*currentX);
    }
    
    public static int scaledY(int currentY, double scaleFactor)
    //PRE:  currentY > 0, 0 < scaleFactor < 1
    //POST: FCTVAL == the scaled y coordinate based on scaleFactor
    {
        return (int)(scaleFactor*currentY);
    }
}
