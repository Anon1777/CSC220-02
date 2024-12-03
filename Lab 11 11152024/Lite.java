// Lite.java
import java.awt.Color;

public abstract class Lite {
    // Instance variables
    protected double x, y;
    protected Color clr;
    private boolean isOn;

    // Constructor
    public Lite(double x, double y, Color clr) {
        this.x    = x;      // Coordinates
        this.y    = y;
        this.clr  = clr;    // Fill color
        this.isOn = false;  // State
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
    // Change fill color
    public void setFillColor(Color clr) {
        this.clr = clr;
    }
    // Draw light.
    public abstract void draw();
}