/* Name       : Jo Farrell
 * Date       : 12/10/2024
 * File Name  : Wolf.java
 * Description: This program creates randomly moving wolves for the World class to spawn
*/
import java.util.Random; // import random object
public class Wolf extends Animal { // open Wolf
    private Color fill = Color.BLACK; // fill = black

    public Wolf(int row, int col, int size, World world) { // open Wolf constructor
        super(row,col,size,world); // extend row, col, size, and world from Animal
        this.prob = 0.05;
        this.delta_energy = 20;
        Random rand = new Random();
        this.energy = rand.nextInt((2*delta_energy)); // energy is a random Integer from 0 inclusive to 20 exclusive
    } // close Wolf constructor

    public void draw() { // open draw method
        int x = row * world.getGridSize();
        int y = col * world.getGridSize();
        StdDraw.setPenColor(fill);
        StdDraw.filledSquare(x, y, size/2); // cut in half because its half size and pdf says size is the full width
    } // close draw method

    public void reproduce() { // open reproduce method
        if (Math.random() < prob) { // open if
            energy/=2.0;
            world.add(new Wolf(row,col,size,world)); // add new Wolf to world ArrayList
        } // close if
    } // close reproduce method

    public boolean eat() { // open eat method
        Sheep food = world.sheepAt(row, col);
        if (food != null) { // open if
            food.die(); // if food exists at the same place as wolf, kill it
            energy+=delta_energy; // add energy
            return true;
        } // close if
        return false;
    } // close eat method

    public void die() { // open die method
        if (energy < 0) { // open if
            world.remove(this); // kill wolf if energy is depleted
        } // close if
    } // close die method
} // close Wolf
