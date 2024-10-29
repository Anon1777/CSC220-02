/* Name       : Jo Farrell
 * Date       : 10/29/2024
 * Filename   : Tank.java
 * Description: creates a creature and has it react randomly
 */
public class Tank {
    public static Farrelj[] creatures;           // Creature array variable

    // Setup Creature Tank
    public static void setup() {
        StdDraw.setCanvasSize(600, 600);        // Windows size
        StdDraw.setXscale(0, 600);              // Set coordinate system
        StdDraw.setYscale(0, 600);
        StdDraw.enableDoubleBuffering();        // Reduce flicker
        StdDraw.setTitle("Creatures");          // Window title

        creatures = new Farrelj[3];              // Creature array
        for (int i=0; i<creatures.length; i++) {
            double x = Math.random()*570;       // Choose random location
            double y = Math.random()*570;
            creatures[i] = new Farrelj(x, y);    // Create creature objects
        }
    }

    // Run tank simulation
    public static void loop() {
        while (true) {
            StdDraw.clear();                    // Clear drawing
            for (int i=0; i<creatures.length; i++) {
                if (Math.random() < 0.5) {      // Each creature reacts at random
                    creatures[i].react();       // React
                } else {
                    creatures[i].reset();       // Reset
                }
                creatures[i].draw();            // Redraw creature
            }
            StdDraw.show();                     // Swap screen buffer
            StdDraw.pause(50);                  // A pause for the cause
        }
    }
    public static void main(String[] args) {
        setup();
        loop();
    }
}
