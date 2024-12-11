// World.java
// Modelled after https://juliadynamics.github.io/Agents.jl/stable/examples/predator_prey/

import java.util.Random;
import java.util.ArrayList;

public class World {
    // TODO: Declare instance variables

    public World(int nrows, int ncols, int gridsize, int nsheep, int nwolves) {
        // TODO: Constructor implementation
    }
    // Find a Sheep at position
    public Sheep sheepAt(int r, int c) {
        // TODO: Return true if there is a Sheep at r, c
    }
    public void remove(Sheep sh) {
        // TODO: Remove the Sheep sh from this World
    }
    public void remove(Wolf wo) {
        // TODO: Remove the Wolf wo from this World
    }
    // TODO: Implement oter methods, as needed
    
    // One step of simulation
    public void step() {
        // Step patch of grass
        // Step all Patch objects

        // Step sheep
        // TODO: Step all Sheep objects

        // Step wolves
        // TODO: Step all Wolf objects
    }
    // Redraw everything
    public void draw() {
        // Clear window
        StdDraw.clear(StdDraw.WHITE);

        // Draw everybody
        for (int r=0; r<nrows; r++) {
            for (int c=0; c<ncols; c++) {
                this.patches[r][c].draw();
            }
        }
        for (Sheep shp: sheep ) { shp.draw();  }
        for (Wolf wolf: wolves) { wolf.draw(); }

        // Transfer background buffer to window buffer
        StdDraw.show();
    }

    // Set up window
    public void setup() {
        int width  = this.ncols * this.gridsize;    // Window width
        int height = this.nrows * this.gridsize;    // Window height
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);                // Coordinate system
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();            // Double buffering
        StdDraw.setTitle("Wolves, Sheep and Grass");
    }

    public static void main(String[] args) {
        World w = new World(30, 30, 20, 50, 50);
        w.setup();              // Setup window
        
        // Run game loop
        while(true) {           // Advance when mouse is pressed
            if (StdDraw.isMousePressed()) {
                w.step();       // Step the model
            }
            w.draw();           // Draw update
            StdDraw.pause(100); // Pause for 100 milliseconds
        }
    }
}
