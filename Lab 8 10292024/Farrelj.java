public class Farrelj {
    public double x; // x position
    public double y; // y position
    public Farrelj(double x, double y){ // declare parameters for Farrelj
        this.x = x; // sets default value to input value
        this.y = y; // ditto
    }

    public void setLocation(double x, double y){
        this.x = x; // changes value to input value
        this.y = y; // ditto
    }

    public void react(){
        StdDraw.setPenRadius(0.05); // quintuples original pen radius
        StdDraw.setPenColor(StdDraw.BLUE); // changes border color
        StdDraw.circle(this.x, this.y, 30);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x, y, 10);
    }
    
    public void reset(){
        draw(); // gets rid of changes by react();
    }
    
    public void draw(){
        StdDraw.setPenRadius(0.01); // sets pen radius to 0.01
        StdDraw.setPenColor(StdDraw.BLACK); // sets border color to black
        StdDraw.circle(this.x, this.y, 30); // circle has a radius of 30 and is at position x, y
        StdDraw.setPenColor(StdDraw.RED); // sets pen color to red
        StdDraw.filledCircle(x, y, 10); // center circle is filled in with red
    }
}
