// Lab09.java
/* Name       : Jo Farrell
 * Date       : 11/01/2024
 * Filename   : Lab09.java
 * Description: creates a light
 */
import java.util.Scanner;

public class Lab09 {
    public static void main(String[] args) {

        // Setup the drawing window
        StdDraw.setCanvasSize(600, 600);        // Windows size
        StdDraw.setXscale(0, 600);              // Set coordinate system
        StdDraw.setYscale(0, 600);
        StdDraw.enableDoubleBuffering();        // Reduce flicker
        StdDraw.setTitle("Lab09");              // Window title

        // Create a TrafficLight object at the center of the window
        TrafficLight tlight = new TrafficLight(300, 300);

        // Enter a loop
        Scanner scn = new Scanner(System.in);
        while (true) {
            StdDraw.clear();                    // Clear display
            tlight.cycle();                     // Cycle TrafficLight to next color
            tlight.draw();                      // Draw Light on window
            StdDraw.show();                     // Show updated drawing

            System.out.print("Next? ");         // Query the user
            String cmd = scn.nextLine();        // Pause and wait for a response 
            if (cmd.equalsIgnoreCase("stop"))   
                break;
        }
        scn.close();
        StdDraw.close();
    }
}
