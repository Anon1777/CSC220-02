/* 
 * Name       : Joe Farrell
 * Filename   : Lab04.java
 * Date       : 09/24/2024
 * Description: Create a "strong" password that contains an uppercase character, lowercase character, number, and special character.
*/
public class Lab04 {
    public static void main(String[] args) {
        final String LETTERS = "abcdefghijklmnopqrstuvwxyz"; // letters
        final String NUMBERS = "0123456789"; // numbers
        final String SPECIAL = "`~!@#$%^&*()-_=+[]{}}|;:'\",.<>/?\\"; // special characters
        String pass = ""; // initial password declaration
        int length = (int)(Math.random()*17)+8; // random length of password between 8 and 24
        int type = Integer.MIN_VALUE; // type declaration at MIN_VALUE to prevent errors later
        for(int ind = 0; ind < length; ind++){
            type = (int)(Math.random()*4)+1;
            if(type == 1) {
                pass += LETTERS.charAt((int)(Math.random()*(LETTERS.length())));
            } else if(type == 2){
                pass += Character.toString(LETTERS.charAt((int)(Math.random()*(LETTERS.length())))).toUpperCase();
            } else if(type == 3){
                pass += NUMBERS.charAt((int)(Math.random()*(NUMBERS.length())));
            } else if(type == 4){
                pass += SPECIAL.charAt((int)(Math.random()*(SPECIAL.length())));
            } else {
                pass += "internal system error";
            }
        }
        System.out.println(pass);
    }
}
