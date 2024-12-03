/* Name       : Jo Farrell
 * Date       : 11/22/2024
 * Filename   : Lab12.java
 * Description: Given a list of names, count all of them with the word "lion" in them and print out only the ones with "lion" in them AND have more than ten count.
 * Answer     : The file is closed at the end of the try statement because the scanner cannot get another line.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab12 { // start lab12
    public static void main(String[] args) { // open main
        File f = new File("yob2023.txt"); // new File object f reading yob2023.txt
        try(Scanner fn = new Scanner(f)){ // open try-with-resources with resource Scanner fn checking File f 
            ArrayList<String> submitL = new ArrayList<String>(); // arraylist of names with lion
            ArrayList<String> submitG = new ArrayList<String>(); // arraylist of genders
            ArrayList<Integer> submitC = new ArrayList<Integer>(); // arraylist of counts
            int ct = 0;
            while(fn.hasNextLine()){ // open while
                String ln = fn.nextLine(); // ln = next line in f
                String[] spl = ln.split(","); // spl contains three segments of ln separated by commas
                if(spl[0].contains("lion") || (spl[0].length() > 3 && spl[0].substring(0, 4).equalsIgnoreCase("lion"))){ // open if
                    if(Integer.parseInt(spl[2]) >= 10){ // open if
                        submitL.add(spl[0]); // add the name to submitL if spl[0] contains "lion" and spl[2] is ten or more
                        submitG.add(spl[1]); // add the gender to submitG if spl[0] contains "lion" and spl[2] is ten or more
                        submitC.add(Integer.parseInt(spl[2])); // add the count to submitC if spl[0] contains "lion" and spl[2] is ten or more
                    } // close if
                    ct++;
                } // close if
            } // close while
            for(int i = 0; i < submitL.size(); i++){ // open for
                System.out.println(submitL.get(i) + " " + submitG.get(i) + " " + submitC.get(i));
            } // close for
            System.out.println(ct + " total lions");
        } catch(FileNotFoundException e){ // close try-with-resources & open catch(FileNotFoundException)
            System.out.println(f + " not found");
        } catch(Exception e){ // close catch(FileNotFoundException) & open catch(Exception)
            System.out.println(e);
        } // close catch(Exception)
    } // close main
} // end lab12
