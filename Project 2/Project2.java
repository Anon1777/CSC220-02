/* Name       : Jo Farrell
 * Date       : 11/05/2024
 * Filename   : Project2.java
 * Description: Generate the probability of fixing more than 400 devices in 
 */
public class Project2 {
    public static void main(String[] args) {
        final int[] data = {23, 17, 20, 16, 27, 13, 12, 16, 18, 29, 41, 14, 21, 31, 11, 10, 57, 18, 39, 21, 13, 5, 10, 36, 14, 9, 10, 3, 61, 44, 15, 23, 8, 55, 15, 17, 6, 11, 23, 18, 14, 26, 20, 25, 25, 42, 16, 38, 6, 64, 17, 11, 35, 6, 14, 16, 10, 40, 36, 10};
        int ntrials = (int)Math.pow(2, 21) - 1;
        int[] histogram = new int[1000];
        int k = 0;
        for(int i = 0; i < ntrials; i++){
            for(int j = 0; j < 20; j++){
                k += data[(int)(Math.random()*60)];
            }
            histogram[k]++;
            k = 0;
        }
        double[] pdf = new double[1000];
        for(int i = 0; i < 1000; i++){
            pdf[i] = ((double)histogram[i] / ntrials);
        }
        double forty = 0;
        double fifty = 0;
        int five = 0;
        double fivesum = 0;
        for(int i = 399; i < 1000; i++){
            forty += pdf[i];
        }
        for(int i = 499; i < 1000; i++){
            fifty += pdf[i];
        }
        for(int i = 0; i < 1000; i++){
            fivesum += pdf[i];
            if(fivesum <= 0.5){
                five++;
            }
        }
        System.out.println("Probability of completing at least 400 repairs in the next 20 days: " + forty);
        System.out.println("Probability of completing at least 500 repairs in the next 20 days: " + fifty);
        System.out.println("Minimum number of repairs at less than 0.5 probability: " + five);
    }
}
