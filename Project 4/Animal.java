/* Name       : Jo Farrell
 * Date       : 12/10/2024
 * File Name  : Animal.java
 * Description: Creates an animal of to-be-determined subclass with randomly moving behavior and base methods
*/
import java.awt.Color;
import java.util.Random;
public abstract class Animal {
    protected int row;
    protected int col;
    protected int size;
    protected World world;
    protected Color fill;
    protected double prob;
    protected int delta_energy;
    protected int energy;

    public int getRow() {
        return row;
    }
    
    public int getCol() { 
        return col;
    }

    public Animal(int row, int col, int size, World world) {
        this.row = row;
        this.col = col;
        this.size = size;
        this.world = world;
    }

    public void walk() {
        Random rand = new Random();
        int x = rand.nextInt(3) - 1;
        int y = rand.nextInt(3) - 1;
        row += x;
        col += y;
        if (row > world.getRows()-1) {
            row = 0;
        } else if (row <= 0) {
            row = world.getRows()-1;
        }
        if (col > world.getCols()-1) {
            col = 0;
        } else if (col <= 0) {
            col = world.getCols()-1;
        }
        energy-=1;
    }
    
    protected abstract void draw();
    protected abstract boolean eat();
    protected abstract void reproduce(); //would be automatable if they didn't remove .newInstance() :(, now we can only do no arg constructors with .getClass()
    
    public abstract void die(); //even though this seems like it should work from superclass, it cant world.remove it because it sends it as a Animal and cant figure out which list to remove it from

    public void step() {
        eat();
        reproduce();
        walk();
        die();
    }
}
