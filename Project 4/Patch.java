/* Name       : Jo Farrell
 * Date       : 12/10/2024
 * File Name  : Patch.java
 * Description: Creates regrowing patches of grass for Sheep to eat 
*/
import java.awt.Color;
import java.util.Random;
public class Patch {
    private int length;
    private final int MAX_LENGTH = 30;
    private int row;
    private int col;
    private int size;
    private World world; // i know it doesn't say to give it world but it needs world to know where it is

    public Patch(int row, int col, int size, World world) {
        this.row = row;
        this.col = col;
        this.size = size;
        this.world = world;
        Random rand = new Random();
        if (rand.nextDouble() < 0.5) {
            length = MAX_LENGTH;
        }
        else {
            length = rand.nextInt(MAX_LENGTH);
        }
    }

    //get color between two colors
    public static Color interpolateColor(Color color1, Color color2, double ratio) {
        float r = (float) ratio;
        float ir = (float) 1.0 - r;

        float red = color1.getRed() * ir + color2.getRed() * r;
        float green = color1.getGreen() * ir + color2.getGreen() * r;
        float blue = color1.getBlue() * ir + color2.getBlue() * r;

        return new Color(red / 255, green / 255, blue / 255);
    }

    public void draw() {
        int x = row * world.getGridSize();
        int y = col * world.getGridSize();
        StdDraw.setPenColor(interpolateColor(new Color(209,219,183), StdDraw.GREEN, ((double)length) / MAX_LENGTH));
        StdDraw.filledSquare(x, y, size/2);
    }

    public void step() {
        if (length < MAX_LENGTH) {
            length += 1;
        }
    }

    public boolean beEaten() {
        if (length >= MAX_LENGTH) {
            length = 0;
            return true;
        }
        return false;
    }
}