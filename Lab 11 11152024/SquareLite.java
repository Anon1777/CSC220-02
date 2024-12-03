import java.awt.Color;

public class SquareLite extends Lite{
    private double halfLength;
    public SquareLite(double x, double y, double halfLength, Color clr){
        super(x, y, clr);
        this.halfLength = halfLength;
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.setPenRadius(0);
        StdDraw.square(x, y, halfLength);
        StdDraw.setPenColor(clr);
        StdDraw.filledSquare(x, y, halfLength);
    }
}
