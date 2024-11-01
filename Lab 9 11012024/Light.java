import java.awt.Color;

public class Light{
    private double x;
    private double y;
    private Color clr;
    private boolean status;

    public Light(double x, double y, Color clr){
        this.x = x; // set center width to x var
        this.y = y; // set center height to y var
        this.clr = clr; // set color to clr var
        status = false; // set status to off
    }

    public void turnOn(){
        this.status = true; // turn light on
    }

    public void turnOff(){
        this.status = false; // turn light off
    }

    public boolean isOn(){
        return this.status; // check status
    }

    public void draw(){
        if(this.isOn()){
            StdDraw.setPenColor(this.clr); // set color to clr var
        } else {
            StdDraw.setPenColor(StdDraw.DARK_GRAY); // set color to dark gray
        }
        StdDraw.filledCircle(this.x, this.y, 30); // create filled circle at (x, y) with radius 30
        StdDraw.setPenColor(StdDraw.BLACK); // set color to black
        StdDraw.circle(this.x, this.y, 30); // create circle at (x, y) with radius 30
    }
}