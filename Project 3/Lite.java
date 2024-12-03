// Lite.java
import java.awt.Color;

public abstract class Lite {
    // Private instance variables
    protected double x, y;
    protected Color clr;
    private boolean isOn = false;

    // Constructor
    public Lite(double x, double y, Color clr) {
        this.x = x;         // Coordinates
        this.y = y;
        this.clr = clr;     // Fill color
        this.isOn = false;  // State
    }
    // Get lite location
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    // Get lite color
    public Color getColor() {
        return this.clr;
    }
    // Check if lite is on
    public boolean isOn() {
        return this.isOn;
    }
    // Turn on and off
    public void turnOn() {
        this.isOn = true;
    }
    public void turnOff() {
        this.isOn = false;
    }
    public void setFillColor(Color clr) {
        this.clr = clr;
    }
    // Helper methods that may be used by sublcasses
    // Distance between two points
    protected double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2 - y1, 2));
    }
    // Heron's formula for computing the area of an arbitrary triangle
    protected double heron(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = distance(x1, y1, x2, y2);
        double b = distance(x2, y2, x3, y3);
        double c = distance(x3, y3, x1, y1);
        double s = 0.5*(a + b + c);
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    // Abstract methods that must be implemented by subclasses
    // Draw light at location.
    public abstract void draw();

    // Test if given coordinates are in shape
    public abstract boolean contains(double x, double y);
}