import java.awt.Color;

public class SquareLite extends Lite{
    private double halfLength;
    public SquareLite(double x, double y, double halfLength, Color clr){
        super(x, y, clr);
        this.halfLength = halfLength;
    }

    public void draw(){
        StdDraw.setPenRadius(0);
        StdDraw.setPenColor(clr);
        StdDraw.filledSquare(x, y, halfLength);
    }

    public boolean contains(double x, double y){
        if(
            (
                x >= this.x - halfLength 
                && 
                x <= this.x + halfLength
            ) && (
                y >= this.y - halfLength 
                && 
                y <= this.y + halfLength
            )
        ){
            return true;
        }
        return false;
    }
}