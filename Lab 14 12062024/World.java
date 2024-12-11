// World.java
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class World {
    // TODO: Declare instance variables including an ArrayList of Wolf objects
    private int nrows,ncols,gridsize,nwolves;
    public ArrayList<Wolf> wolves = new ArrayList<Wolf>(nwolves);
    public Random random=new Random();
    public World(int nrows, int ncols, int gridsize, int nwolves) {
        // TODO: Initialize instance variables
        this.nrows=nrows;
        this.ncols=ncols;
        this.gridsize=gridsize;
        this.nwolves=nwolves;

        // TODO: Fill ArrayList<Wolf> with nwolves Wolf objects
        for(int i = 0; i < wolves.size(); i++){
            wolves.add(new Wolf(ncols, nrows, 1, Color.getColor("Black"), this));
        }
    }
    // One step of simulation
    public void step() {
        // TODO: Tell each Wolf object to walk once
        for (Wolf wolf: wolves) { wolf.walk(); }
    }
    // TODO: Implement accessor and mutator methods, as needed
    public int getNcols(){
        return ncols;
    }
    public int getNrows(){
        return nrows;
    }
    // Redraw everything
    public void draw() {
        // Clear window
        StdDraw.clear(StdDraw.WHITE);

        // Draw all Wolf objects in wolves ArrayList<>
        for (Wolf wolf: wolves) { wolf.draw(); }
        
        // Transfer background buffer to window buffer.
        StdDraw.show();
    }

    // Set up window
    public void setup() {
        int width  = this.ncols * this.gridsize;    // Window width
        int height = this.nrows * this.gridsize;    // Window height
        StdDraw.setCanvasSize(width, height);       // Windows size
        StdDraw.setXscale(0, width);                // Coordinate system
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setTitle("Roaming Wolves");
    }

    public static void main(String[] args) {
        World w = new World(30, 30, 20, 1); //50);
        w.setup();              // Setup window
        
        // Run game loop
        while(true) {           // Advance when mouse is pressed
            if (StdDraw.isMousePressed()) {
                w.step();       // Step the world
            }
            w.draw();           // Draw update
            StdDraw.pause(100); // Pause for 100 milliseconds
        }
    }
}