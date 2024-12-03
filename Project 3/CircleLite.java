import java.awt.Color;

public class CircleLite extends Lite{
    private double radius;
    public CircleLite(double x, double y, double radius, Color clr){
        super(x, y, clr);
        this.radius = radius;
    }

    public void draw(){
        StdDraw.setPenRadius(0);
        StdDraw.setPenColor(clr);
        StdDraw.filledCircle(x, y, radius);
    }

    public boolean contains(double x, double y){
        if(
            distance(x, y, this.x, this.y) <= radius){
            return true;
        }
        return false;
    }
}
