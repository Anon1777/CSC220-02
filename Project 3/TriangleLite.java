import java.awt.Color;

public class TriangleLite extends Lite{
    private double halfSize;
    double[] xs;
    double[] ys;
    public TriangleLite(double x, double y, double halfSize, Color clr){
        super(x, y, clr);
        this.halfSize = halfSize;
        xs = new double[]{x - halfSize, x, x + halfSize};
        ys = new double[]{y - halfSize, y + halfSize, y - halfSize};
    }

    public void draw(){
        StdDraw.setPenRadius(0);
        StdDraw.setPenColor(clr);
        StdDraw.filledPolygon(xs, ys);
    }

    public boolean contains(double x, double y){
        if(
            (
                heron(
                    x, 
                    y, 
                    this.x - halfSize, 
                    this.y - halfSize, 
                    this.x + halfSize, 
                    this.y - halfSize
                ) + heron(
                    x,
                    y,
                    this.x - halfSize,
                    this.y - halfSize,
                    this.x,
                    this.y + halfSize
                ) + heron(
                    x, 
                    y,
                    this.x + halfSize, 
                    this.y - halfSize, 
                    this.x, 
                    this.y + halfSize
                )
            ) >= (int)(heron(
                this.x - halfSize,
                this.y - halfSize,
                this.x + halfSize,
                this.y - halfSize,
                this.x,
                this.y + halfSize)
            )
        ){
            return true;
        }
        return false;
    }
}
