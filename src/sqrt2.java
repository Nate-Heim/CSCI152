//Nate Heim
//9-6-23

import java.util.Scanner;

public class sqrt2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //creating a scanner class to get user input
        System.out.print("Enter an integer: "); //gathering the user's integer here
        int a = scanner.nextInt();

        int c = a; //needed a second variable to properly output as I wanted to clean the code up
        double b = a; //sqrt is not a clean whole number thus changing to a double to get the precision down
        b = Math.sqrt(b);
        System.out.println("The square root of " + c + " is " + b);
    }
}
