/* Name       : Jo Farrell
 * Date       : 12/10/2024
 * File Name  : World.java
 * Description: Creates a world of wolves, sheep, and patches of grass using StdDraw.java
*/
// Modelled after https://juliadynamics.github.io/Agents.jl/stable/examples/predator_prey/

import java.util.Random;
import java.util.ArrayList;

public class World {
    // TODO: Declare instance variables
    private int nrows;
    private int ncols;
    private int gridsize;
    private ArrayList<Sheep> sheep = new ArrayList<Sheep>();
    private Patch[][] patches;
    private ArrayList<Wolf> wolves = new ArrayList<Wolf>();

    public World(int nrows, int ncols, int gridsize, int nsheep, int nwolves) {
        // TODO: Constructor implementation
        this.nrows = nrows;
        this.ncols = ncols;
        this.gridsize = gridsize;
        patches = new Patch[nrows][ncols];
        //add wolves
        for (int i = 0; i < nwolves; i++) {
            Random rand = new Random();
            int x = rand.nextInt(nrows);
            int y = rand.nextInt(ncols);
            wolves.add(new Wolf(x,y,gridsize,this));
        }
        //add sheep
        for (int i = 0; i < nsheep; i++) {
            Random rand = new Random();
            int x = rand.nextInt(nrows);
            int y = rand.nextInt(ncols);
            sheep.add(new Sheep(x,y,gridsize,this));
        }
        //add patches
        for (int i = 0; i < nrows; i++) {
            for (int x = 0; x < ncols; x++) {
                patches[i][x] = new Patch(i,x,gridsize,this);
            }
        }
    }
    // Find a Sheep at position
    public Sheep sheepAt(int r, int c) {
        // TODO: Return true if there is a Sheep at r, c
        //loop backwards
        for (int i = sheep.size() - 1; i >= 0; i--) {
            if (sheep.get(i).getRow() == r && sheep.get(i).getCol() == c) {
                return sheep.get(i); //returning the sheep not a boolean because its more useful and initial return type was set to Sheep
            }
        }
        return null;
    }
    public void remove(Sheep sh) {
        // TODO: Remove the Sheep sh from this World
        sheep.remove(sh);
    }
    public void remove(Wolf wo) {
        // TODO: Remove the Wolf wo from this World
        wolves.remove(wo);
    }
    // TODO: Implement oter methods, as needed

    public Patch patchAt(int r, int c) {
        return patches[r][c];
    }

    //methods to add wolves/sheep
    public void add(Wolf w) {
        wolves.add(w);
    }
    
    public void add(Sheep s) {
        sheep.add(s);
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
    public ArrayList<Sheep> getSheep() {
        return sheep;
    }
    public Patch[][] getPatches() {
        return patches;
    }

    // One step of simulation
    public void step() {
        // Step patch of grass
        // Step all Patch objects
        for (int i = 0; i < nrows; i++) {
            for (int x = 0; x < ncols; x++) {
                patches[i][x].step();
            }
        }

        // Step sheep
        // TODO: Step all Sheep objects
        for (int i = sheep.size() - 1; i >= 0; i--) {
            sheep.get(i).step();
        }

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
