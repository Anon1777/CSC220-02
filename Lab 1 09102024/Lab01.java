/* 
 * Name       : Joe Farrell
 * Filename   : Lab01.java
 * Date       : 09/10/2024
 * Description: This lab will answer five questions: Find the discriminant of a quadratic function; Use limited options to create the string "007"; Evaluate the exact time in minutes and seconds of a large number; Explain how int division works; Display the average acceleration with given values. 
*/
public class Lab01{
    public static void main(String[] args){
        //1
        System.out.println("ax^2 + bx + c = 0"); // ax^2 + bx + c = 0
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0"); // 3.0x^2 + 4.0x + 5.0 = 0
        double disc = Math.pow(b, 2) - 4 * a * c; // Guess: 4^2 - 4(3*5) = 16 - 60 = -44.0
        System.out.println("The discriminant of " + a + "x^2 + " + b + "x + " + c + " = 01 is " + disc); // displays discriminant, should be -44.0
        
        System.out.println("\n ************************* \n"); // line break
        //2
        int x = 5;
        int y = 1;
        String nada = "";
        int z = x - y - y - y - y - y; // 0
        int w = x + y + y; // 7
        nada += z; // 0
        nada += z; // 00
        nada += w; // 007
        System.out.println(nada);

        System.out.println("\n ************************* \n"); // line break
        //3
        final int SPM = 60;
        int total = 234; // Guess: 234/60 = 3 & 54/60
        int minute = total / SPM; // 3
        int second = total % SPM; // 54
        System.out.println(total + " seconds is equivalent to " + minute + " minutes and " + second + " seconds"); // prints sentence. should read "234 seconds is equivalent to 3 minutes and 54 seconds"

        System.out.println("\n ************************* \n"); // line break
        //4
        System.out.println("6 + 4 / 2 - 1 = " + (6 + 4 / 2 - 1)); // The printed value is 7 and not 4 because of the order of operations, PEMDAS. MD, or Multiplication and Division, come before AS, or Addition and Subtraction. Therefore, 4 / 2 is evaluated first. 4 / 2 = 2. After this, then the addition and subtraction are evaluated. 6 + 2 = 8, and 8 - 1 = 7.
        
        System.out.println("\n ************************* \n"); // line break
        //5
        double v0 = 5.6;
        double v1 = 10.5;
        double t = 0.5;
        double aa = (v1 - v0) / t; // Guess: (10.5 - 5.6) / 0.5 = 2(9.9) = 19.8 
        System.out.println("The average acceleration is " + aa + " m/s"); // prints the average acceleration. should be 19.8

    } // close main
} // close Lab01