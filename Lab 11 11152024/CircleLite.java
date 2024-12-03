import java.awt.Color;

public class CircleLite extends Lite {
    private double radius;
    public CircleLite(double x, double y, double radius, Color clr){
        super(x, y, clr);
        this.radius = radius;
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0); // THIS was the issue the pen radius was too big
        StdDraw.circle(x, y, radius);
        StdDraw.setPenColor(clr);
        StdDraw.filledCircle(x, y, radius);
    }
}
