public class TrafficLight{
    private double x;
    private double y;
    private Light R;
    private Light Y;
    private Light G;

    public TrafficLight(double x, double y){
        this.x = x; // set center width to x var
        this.y = y; // set center height to y var
        R = new Light(x, (y + 75), StdDraw.RED); // create new light R with color red and height 75px above center
        Y = new Light(x, y, StdDraw.YELLOW); // create new light Y with color yellow and height at center
        G = new Light(x, (y - 75), StdDraw.GREEN); // create new light G with color green and height 75px below center
        // R.turnOn();
    }

    public void cycle(){
        if(R.isOn()){ // check if R is on
            R.turnOff(); // turn R off
            G.turnOn(); // turn G on
        } else if(G.isOn()){ // check if G is on
            G.turnOff(); // turn G off
            Y.turnOn(); // turn Y on
        } else { // check if Y is on
            Y.turnOff(); // turn Y off
            R.turnOn(); // turn R on
        }
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.BLACK); // set color to black
        StdDraw.rectangle(this.x, this.y, 45, 120); // draw rectangle with height 240 and width 90
        R.draw(); // draw R
        Y.draw(); // draw Y
        G.draw(); // draw G
    }
}