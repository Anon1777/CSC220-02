/* Name       : Jo Farrell
 * Date       : 12/10/2024
 * File Name  : World.java
 * Description: Creates a world of wolves
*/

import java.util.Random;
import java.util.ArrayList;

public class World {
    // TODO: Declare instance variables
    private int nrows;
    private int ncols;
    private int gridsize;
    private ArrayList<Wolf> wolves = new ArrayList<Wolf>();

    public World(int nrows, int ncols, int gridsize, int nsheep, int nwolves) {
        // TODO: Constructor implementation
        this.nrows = nrows;
        this.ncols = ncols;
        this.gridsize = gridsize;
        //add wolves
        for (int i = 0; i < nwolves; i++) {
            Random rand = new Random();
            int x = rand.nextInt(nrows);
            int y = rand.nextInt(ncols);
            wolves.add(new Wolf(x,y,gridsize,this));
        }
    }
    public void remove(Wolf wo) {
        // TODO: Remove the Wolf wo from this World
        wolves.remove(wo);
    }

    //methods to add wolves/sheep
    public void add(Wolf w) {
        wolves.add(w);
    }

    public int getRows() {
        return nrows;
    }
    public int getCols() {
        return ncols;
    }
    public int getGridSize() {
        return gridsize;
    }
    public ArrayList<Wolf> getWolves() {
        return wolves;
    }

    // One step of simulation
    public void step() {
        // Step wolves
        // TODO: Step all Wolf objects
        for (int i = wolves.size() - 1; i >= 0; i--) {
            wolves.get(i).step();
        }
    }
    // Redraw everything
    public void draw() {
        // Clear window
        StdDraw.clear(StdDraw.WHITE);

        // Draw everybody
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
        StdDraw.setTitle("Wolves");
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