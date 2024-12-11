/* Name       : Jo Farrell
 * Date       : 12/10/2024
 * File Name  : Sheep.java
 * Description: Creates sheep for the Wolves to eat
*/
import java.awt.Color;
import java.util.Random;
public class Sheep extends Animal {
    private Color fill = Color.WHITE;

    public Sheep(int row, int col, int size, World world) {
        super(row,col,size,world);
        this.prob = 0.04;
        this.delta_energy = 4;
        Random rand = new Random();
        this.energy = rand.nextInt((2*delta_energy));
    }

    public void draw() {
        int x = row * world.getGridSize();
        int y = col * world.getGridSize();
        StdDraw.setPenColor(fill);
        StdDraw.filledCircle(x, y, size/2); //cut in half because its half size and pdf says size is the full width
    }

    public void reproduce() {
        if (Math.random() < prob) {
            energy/=2.0;
            world.add(new Sheep(row,col,size,world));
        }
    }

    public boolean eat() {
        Patch food = world.patchAt(row, col);
        if (food.beEaten()) {
            energy+=delta_energy;
            return true;
        }
        return false;
    }

    public void die() {
        if (energy < 0) {
            world.remove(this);
        }
    }
}