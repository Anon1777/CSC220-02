public class Lab07 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59}; // highest index = 58
        int index = 0; // rndom index
        int replaceIndex = 0; // index of first 6
        System.out.print("LOTTO: ");
        for(int i = 0; i < 6; i++){
            index = (int)Math.floor(Math.random()  * (59 - i) + i);
            replaceIndex = array[i];
            array[i] = array[index];
            System.out.print(array[i] + " ");
            array[index] = replaceIndex;
        }
    }
}
