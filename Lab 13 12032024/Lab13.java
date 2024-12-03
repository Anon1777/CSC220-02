/* Name       : Jo Farrell
 * Date       : 12/03/2024
 * Filename   : Lab13.java
 * Description: Print a ladder, starting with a double step and then alternating between spaces and single steps until n = 0. */
public class Lab13 { // open Lab13
    static boolean m; // declare toggle boolean m
    public static String ladder(int n){ // open ladder with int parameter n
        Exception e = new Exception(); // declare Exception e to prevent duplication of double step
        e.fillInStackTrace(); // get stack trace of e
        if (e.getStackTrace().length == 2) { // open if e's stack trace is 2
            System.out.println("|==|"); // print double step
            m = true; // toggle m to true
        } // close once m is true and double step is printed
        while(n > 0){ // open while n is greater than 0
            if(m){ // open if m is true
                System.out.println("|  |"); // print empty space
            } else { // close once empty space is printed or open if m is false
                System.out.println("|--|"); // print single step
            } // close once single step is printed
            m = !m; // toggle m
            return ladder(n - 1); // repeat all steps prior but with a smaller n value
        } // close once n is 0
        return "end of ladder"; // return "end of ladder" if n is less than 1
    } // close ladder
    public static void main(String[] args){ // open main
        ladder(10); // call ladder with int parameter n
    } // close main
} // close Lab13