// CreatureTank.java
import java.util.ArrayList;
import java.util.Random;

public class CreatureTank {

    // Creature Tank dimensions. 
    // Constants, so okay to be public.
    public static final int WIDTH  = 800;
    public static final int HEIGHT = 800;

    // ArrayList to hold all creatures
    private ArrayList<Creature> creatures = new ArrayList<>();
    
    // CreatureTank constructor
    public CreatureTank() {

        // Create creatures and add to ArrayList
        Random rnd = new Random();
        for (int i=0; i<25; i++) {
            Creature crt = new Farrelj(rnd.nextInt(CreatureTank.WIDTH), rnd.nextInt(CreatureTank.HEIGHT));
            creatures.add( crt );
        }
        // Setup window and begin animation
        setup();
        loop();
    }
    // Setup window
    public void setup() {                                       // Windows size
        StdDraw.setCanvasSize(CreatureTank.WIDTH, CreatureTank.HEIGHT);
        StdDraw.setXscale(0, CreatureTank.WIDTH);               // Set coordinate system
        StdDraw.setYscale(0, CreatureTank.HEIGHT);
        StdDraw.enableDoubleBuffering();                        // Reduce flicker
        StdDraw.setTitle("Creature Tank");                      // Window title
    }
    // Loop forever
    public void loop() {
        while(true) {
            draw();             // Update drawing
            StdDraw.pause(50);  // Sleep to allow animation to catch up
        }
    }
    // Draw advance and draw all Creatures
    public void draw() {
        StdDraw.clear();
        for (int i=0; i<creatures.size(); i++) {
            Creature crt = creatures.get(i);
            crt.advance(creatures);
            crt.draw();
        }
        StdDraw.show();
    }
    
    // Main method to start the program
    public static void main(String[] args) {
        new CreatureTank();
    }
}
