/* 
 * Name       : Joe Farrell
 * Filename   : Lab02.java
 * Date       : 10/01/2024
 * Description: Determines the probability of rolling any number from 2 to 12 on 2d6.
*/
import java.util.Scanner;
public class Lab05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the target roll value:");
        int r = in.nextInt();
        double rc = 0.0;
        double s = 0.0;
        for(int d1 = 1; d1 < 7; d1++){
            for(int d2 = 1; d2 < 7; d2++){
                if(d1 + d2 == r){
                    s++;
                }
                rc++;
            }
        }
        System.out.println("Probability of rolling a " + r + " is " + (100*(s/rc)) + "%");
        in.close();
    }
}
