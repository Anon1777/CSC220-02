/* Name       : Jo Farrell
 * Date       : 11/15/2024
 * Filename   : Lab11.java
 * Description: creates a bunch of squares and circles with completely random colors and positions.
 */
import java.util.ArrayList;
import java.awt.Color;

public class Lab11 {

    // TODO 1: Declare and create an ArrayList of Lite objects named lites.
    static ArrayList<Lite> lites = new ArrayList<Lite>();

    // Colors
    private static Color[] colors = {StdDraw.RED, StdDraw.BLUE, StdDraw.GREEN, StdDraw.AQUA, StdDraw.FUSCIA, StdDraw.LIGHT_GRAY};

    public static void main(String[] args) {

        // TODO 2: Create 50 or more of CircleLite and 50 or more SquareLite objects 
        for(int i = 0; i < 50; i++){
            CircleLite temp = new CircleLite(
                Math.floor(Math.random() * 601), 
                Math.floor(Math.random() * 601), 
                10, 
                new Color(
                    (int)(Math.random() * 256), 
                    (int)(Math.random() * 256), 
                    (int)(Math.random() * 256)
                )
            );
            lites.add(temp);
        }
        for(int i = 0; i < 50; i++){
            SquareLite temp = new SquareLite(
                Math.floor(Math.random() * 601), 
                Math.floor(Math.random() * 601), 
                10, 
                new Color(
                    (int)(Math.random() * 256), 
                    (int)(Math.random() * 256), 
                    (int)(Math.random() * 256)
                )
            );
            lites.add(temp);
        }
        // positioned at random locations. Turn on each Lite object and add to lites ArrayList.

        setup(600, 600);    // Setup window
        draw(); 
                   // Draw all
    }
    // Set up window
    public static void setup(int width, int height) {
        StdDraw.setCanvasSize(width, height); // Windows size
        StdDraw.setXscale(0, width);          // Coordinate system
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setTitle("Lab11");
    }

    // Redraw everything
    public static void draw() {
        StdDraw.clear(StdDraw.BLACK);
        
        // TODO 3: Loop over all Lite objects in lites ArrayList and draw all.
        for(int i = 0; i < lites.size(); i++){
            lites.get(i).turnOn();
            lites.get(i).draw();
        }
        StdDraw.show();
    }

}
