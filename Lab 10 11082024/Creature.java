// Creature.java
import java.util.Random;
import java.util.ArrayList;

public class Creature
{
    protected double x, y;              // Create location coordinates
    protected double targetX, targetY;  // Swim target coordinates
    protected int close = 50;           // Pixel distance within which two Creatures are considered "close"
    protected int resetTarget = 200;    // Pixel distance within which to reset swim target location
    private Random rnd = new Random();  // Helpful random number generator
    
    // Creature constructor
    public Creature(double x, double y) {
        this.x = x;                     // Save initial location
        this.y = y;
        setNewTarget();                 // Init first swim target
    }
    // Advance the creature animation
    public void advance(ArrayList<Creature> creatures ) {
        x += 0.01*(targetX - x);        // Move closer to target
        y += 0.01*(targetY - y);
        
        // If near target location, reset target
        if (targetDistance() < resetTarget) { setNewTarget(); }

        // Update all Creatures in the tank
        for (int i=0; i<creatures.size(); i++) {
            Creature other = creatures.get(i);
            double dist = creatureDistance(other);
            
            // If any other Creature is close, react and return immediately
            if (dist < close && other != this) {
                react();
                return;
            }

            // No close Creatures. Reset reaction.
            reset();
        }
    }
    // Update location of creature
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // Randomly choose a new swim target 
    private void setNewTarget()  {
        targetX = CreatureTank.WIDTH*rnd.nextDouble();
        targetY = CreatureTank.HEIGHT*rnd.nextDouble();
    }
    // Compute the distance to the swim target location
    private double targetDistance() {
        return Math.sqrt(Math.pow(targetX - x,2) + Math.pow(targetY - y,2));
    }
    // Compute the distance to another creature
    private double creatureDistance(Creature other) {
        return Math.sqrt(Math.pow(other.x - x,2) + Math.pow(other.y - y,2));
    }
    // Creature reaction behavior must be overridden in subclass.
    protected void react() {};
    protected void reset() {};
    protected void draw() {};
}
