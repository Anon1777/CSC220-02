import java.util.*;

public class Demo {
    public static void main(String[] args){
        Scanner i = new Scanner(System.in);
        int height;
        double mph;
        System.out.println("Please insert your height:");
        height = i.nextInt();
        System.out.println("Your height is " + height + "\nPlease insert the speed limit:");
        mph = i.nextDouble();
        System.out.println("The speed limit is " + mph + " mph");
    }
}
