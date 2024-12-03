import java.awt.Color;
public class Farrelj extends Creature {
    private Color color;
    public Farrelj(double x, double y){ // declare parameters for Farrelj
        super(x, y); // gets x and y from Creature
        color = StdDraw.RED;
    }
    
    @Override
    public void reset(){
        color = StdDraw.RED;
    }

    @Override
    public void react(){ // circle has a radius of 30 and is at position x, y
        color = StdDraw.CYAN;
    }

    @Override
    public void draw(){
        StdDraw.setPenRadius(0.01); // sets pen radius to 0.01
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, 10); // center circle is filled in with red
        StdDraw.setPenColor(StdDraw.BLACK); // sets border color to black
        StdDraw.circle(super.x, super.y, 25); // circle has a radius of 30 and is at position x, y
    }
}


