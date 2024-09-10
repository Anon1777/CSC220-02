/* 
 * Name       : Joe Farrell
 * Filename   : Lab02.java
 * Date       : 09/10/2024
 * Description: Create and measure a triangle. Create the vertices; Find the length of each side; Find the perimeter; Find the area; Find the centroid.
*/
import java.util.*;
public class Lab02 {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        System.out.println("Type in six numbers to be used in coordinate pairs (x1, y1, x2, y2, x3, y3 respectively):");
        double x1 = i.nextDouble(); // get coordinate x1
        double y1 = i.nextDouble(); // get coordinate y1
        double x2 = i.nextDouble(); // get coordinate x2
        double y2 = i.nextDouble(); // get coordinate y2
        double x3 = i.nextDouble(); // get coordinate x3
        double y3 = i.nextDouble(); // get coordinate y3
        double s1 = Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2)); // side 1 length
        double s2 = Math.sqrt(Math.pow((x3-x1), 2)+Math.pow((y3-y1), 2)); // side 2 length
        double s3 = Math.sqrt(Math.pow((x3-x2), 2)+Math.pow((y3-y2), 2)); // side 3 length
        double p = s1+s2+s3; // perimeter
        double s = p/2; // half-perimeter
        double a = Math.sqrt(s*(s-s1)*(s-s2)*(s-s3)); // area
        double xc = (x1+x2+x3)/3; // horizontal centroid
        double yc = (y1+y2+y3)/3; // vertical centroid
        System.out.println(x1 + "\n" + y1 + "\n" + x2 + "\n" + y2 + "\n" + x3 + "\n" + y3 + "\n" + s1 + "\n" + s2 + "\n" + s3 + "\n" + p + "\n" + s + "\n" + a + "\n" + xc + "\n" + yc);
        i.close(); // close Scanner
    }  // close main
} // close Lab02
