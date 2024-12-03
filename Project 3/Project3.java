// Project3.java
// Lite-Bright Game
import java.awt.Color;

public class Project3 {

    // Enum defining the current function of the mouse
    private static enum MODE {
        NOOP,   // mouse is doing nothing
        ON,     // mouse is turning Lite objects on
        OFF     // mouse is turning Lite objects off
    }
    private static MODE mode = MODE.NOOP;

    // A sample Colors array. You may choose to use as is, expand, or not use at all.
    private static Color[] colors = {StdDraw.AQUA, StdDraw.FUSCIA, StdDraw.LIME, StdDraw.WHITE};

    public static final int NROWS = 30;   // number of rows in lites array
    public static final int NCOLS = 30;   // number of columns in Lite array
    public static final int HSIZE = 10;   // half characteristic Lite shape size

    // TODO 1: Declare a variable named lites of type 2D array of Lite objects with size NROWSxNCOLS
    static Lite[][] lites = new Lite[NROWS][NCOLS];

    public static void main(String[] args) {
        int rnd = 0;
        // TODO 2: Fill lites array with a mixture of new CircleLite, SquareLite, and TriangleLite objects
        for(int r = 0; r < lites.length; r++){
            for(int c = 0; c < lites[r].length; c++){
                rnd = (int)(Math.random() * 3);
                if(rnd == 0){
                    lites[r][c] = new CircleLite(
                        (r+1) * 2 * HSIZE, 
                        (c+1) * 2 * HSIZE, 
                        HSIZE, 
                        new Color(
                            (int)(Math.random() * 256), 
                            (int)(Math.random() * 256), 
                            (int)(Math.random() * 256)
                        )
                    );
                } else if(rnd == 1){
                    lites[r][c] = new SquareLite(
                        (r+1) * 2 * HSIZE, 
                        (c+1) * 2 * HSIZE, 
                        HSIZE, 
                        new Color(
                            (int)(Math.random() * 256), 
                            (int)(Math.random() * 256), 
                            (int)(Math.random() * 256)
                        )
                    );
                } else {
                    lites[r][c] = new TriangleLite(
                        (r+1) * 2 * HSIZE, 
                        (c+1) * 2 * HSIZE, 
                        HSIZE, 
                        new Color(
                            (int)(Math.random() * 256), 
                            (int)(Math.random() * 256), 
                            (int)(Math.random() * 256)
                        )
                    );
                }
            }
        }
        // Lite objects should be created in a rectangular grid arrangement covering the window.
        // Init each Lite object with a color of your choice.

        setup(600, 600);    // Setup window
        draw();             // Draw once to show initial state
        loop();             // Run game loop
    }

    // Set up window
    public static void setup(int width, int height) {
        StdDraw.setCanvasSize(width, height); // Windows size
        StdDraw.setXscale(0, width);          // Coordinate system
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setTitle("Lite-Bright");
    }

    // Run program, looking for and processing mouse events
    public static void loop() {
        while(true) {
            processEvents();    // Process any mouse events
            StdDraw.pause(40);  // Pause for 50 milliseconds
        }
    }

    // Look for mouse events and process.
    // Leave unchanged.
    public static void processEvents() {
        double x = StdDraw.mouseX();    // Get coordinates
        double y = StdDraw.mouseY();

        // Get pressed Lite, if there is one
        Lite lite = null;
        for (int r=0; r<NROWS; r++) {
            for (int c=0; c<NCOLS; c++) {
                if (lites[r][c].contains(x, y)) {
                    lite = lites[r][c];
                    break;
                }
            }
        }
        if (lite == null) return;   // Nothing pressed. Nothing to do.

        // Change color of Lite, depending upon mouse and game state.
        if (!StdDraw.isMousePressed()) {    // If mouse is not pressed
            mode = MODE.NOOP;               // reset game state to no operation
        } else if (mode == MODE.NOOP && StdDraw.isMousePressed()) {
            if (lite.isOn()) {              // If NOOP and pressed on a Lite that is ON, 
                mode = MODE.OFF;            // set mode to OFF
            } else if (!lite.isOn()) {      // If NOOP and pressed on a Lite that is OFF, 
                mode = MODE.ON;             // set mode to ON
            }
        } else if (mode == MODE.ON) {       // If mode is ON already,
            lite.turnOn();                  // turn light on
        } else if (mode == MODE.OFF) {      // If mode is OFF already,
            lite.turnOff();                 // turn light off
        }
        draw();                             // Redraw everything
    }

    // Redraw everything
    public static void draw() {
        StdDraw.clear(StdDraw.BLACK);

        // TODO 3: Loop over 2D array and draw all Lite objects.
        for(int r = 0; r < lites.length; r++){
            for(int c = 0; c < lites[0].length; c++){
                lites[r][c].draw();
            }
        }
        StdDraw.show();
    }
}
