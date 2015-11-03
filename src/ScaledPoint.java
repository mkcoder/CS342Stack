public class ScaledPoint
{
    private int x;
    private int y;
    
    public ScaledPoint()
    {
        this(0,0);
    }
    
    public ScaledPoint(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public static int scaledX(int currentX, double scaleFactor)
    {
        return (int)(scaleFactor*currentX);
    }
    
    public static int scaledY(int currentY, double scaleFactor)
    {
        return (int)(scaleFactor*currentY);
    }
}
