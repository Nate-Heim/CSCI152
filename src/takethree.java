/*Nate Heim
Created on 9/6/23
 */

public class takethree {
    public static void main(String[] args) {
        int a, b, c;
        /*
        parsing the 3 command line integers here and assigning them to variables
         */
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        c = Integer.parseInt(args[2]);

        int d = a + b + c; //adding the ints into one here for a later step

        int min = Math.min(Math.min(a, b), c); //using min here to find the smallest number from the 3 entries
        int max = Math.max(Math.max(a, b), c); //using max here to find the biggest

        d = d - min - max; //calculating the remaining number here using basic math
        System.out.println("The smallest number is " + min + ", the middle number is " + d + ", and the biggest number is " + max + ".");
    }
}
