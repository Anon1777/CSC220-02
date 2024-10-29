/* Name       : Jo Farrell
 * Date       : 10/11/2024
 * Filename   : Lab06.java
 * Description: displays the product of two numbers, regardless of variable type
 */
// import java.util.*;
public class Lab06 {
    public static void main(String[] args) {
        // Scanner i = new Scanner(System.in);
        // System.out.println("Input x:");
        // String inxS = "";
        // String inyS = "";
        // int inxI = 0;
        // int inyI = 0;
        // double inxD = 0.0;
        // double inyD = 0.0;
        // boolean dbl = i.hasNextDouble();
        // boolean integer = false;
        // boolean inxSB = false;
        // boolean inxIB = false;
        // boolean inxDB = false;
        // boolean inySB = false;
        // boolean inyIB = false;
        // boolean inyDB = false;
        // if(!dbl){
        //     integer = i.hasNextInt();
        //     if(!integer){
        //         inxS = i.nextLine();
        //         inxSB = true;
        //     } else {
        //         inxI = i.nextInt();
        //         inxIB = true;
        //     }
        // } else {
        //     inxD = i.nextDouble();
        //     inxDB = true;
        // }
        // System.out.println("Input y, or type \"exit\" to submit");
        // dbl = i.hasNextDouble();
        // if(!(i.nextLine().equals("exit"))){
        //     if(!dbl){
        //         integer = i.hasNextInt();
        //         if(!integer){
        //             inyS = i.nextLine();
        //             inySB = true;
        //         } else {
        //             inyI = i.nextInt();
        //             inyIB = true;
        //         }
        //     } else {
        //         inyD = i.nextDouble();
        //         inyDB = true;
        //     }
        // } else {
        //     if(inxIB){
        //         display(inxI);
        //     } else if(inxSB){
        //         display(inxS);
        //     } else {
        //         display(inxD);
        //     }
        // }
        // if(inxIB){
        //     if(inyIB){
        //         display(inxI, inyI);
        //     } else if(inySB){
        //         display(inxI, inyS);
        //     } else {
        //         display(inxI, inyD);
        //     }
        // } else if(inxSB){
        //     if(inyIB){
        //         display(inxS, inyI);
        //     } else if(inySB){
        //         display(inxS, inyS);
        //     } else {
        //         display(inxS, inyD);
        //     }
        // } else {
        //     if(inyIB){
        //         display(inxD, inyI);
        //     } else if(inySB){
        //         display(inxD, inyS);
        //     } else {
        //         display(inxD, inyD);
        //     }
        // }
        // i.close();

        display(5, 5);
        display(5);
        display(5, "5");
        display(5, 5.5);
        display("5", "5");
        display("5");
        display("5", 5);
        display("5", 5.5);
        display(5.5, 5.5);
        display(5.5);
        display(5.5, 5);
        display(5.5, "5");
    }
    public static void display(int x, int y){ // two ints
        System.out.println(x * y);
    }
    public static void display(int x){ // one int * 2
        System.out.println(x * 2);
    }
    public static void display(int x, String y){ // one int one string
        int a = Integer.valueOf(y);
        System.out.println(x * a);
    }
    public static void display(int x, double y){ // one int one double
        int a = (int)Math.floor(y);
        System.out.println(x * a);
    }
    public static void display(String x, String y){ // two strings
        int a = Integer.valueOf(x);
        int b = Integer.valueOf(y);
        System.out.println(a * b);
    }
    public static void display(String x){ // one string * 2
        int a = Integer.valueOf(x);
        System.out.println(a * 2);
    }
    public static void display(String x, int y){ // one string one int
        int a = Integer.valueOf(x);
        System.out.println(a * y);
    }
    public static void display(String x, double y){ // one string one double
        int a = Integer.valueOf(x);
        int b = (int)Math.floor(y);
        System.out.println(a * b);
    }
    public static void display(double x, double y){ // two doubles
        int a = (int)Math.floor(x);
        int b = (int)Math.floor(y);
        System.out.println(a * b);
    }
    public static void display(double x){ // one double * 2
        int a = (int)Math.floor(x);
        System.out.println(a * 2);
    }
    public static void display(double x, int y){ // one double one int
        int a = (int)Math.floor(x);
        System.out.println(a * y);
    }
    public static void display(double x, String y){ // one double one string
        int a = (int)Math.floor(x);
        int b = Integer.valueOf(y);
        System.out.println(a * b);
    }
}
