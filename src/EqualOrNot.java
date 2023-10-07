import java.util.Objects;
import java.util.Scanner;

public class EqualOrNot {

    public static void main(String[] args) {

        //Write a program that accepts two strings as input, and prints out if the strings are equal
        // or not i.e. "Equal" or "Not Equal". (use the ternary operator in your program as well as a for loop).

        Scanner myScanner = new Scanner(System.in);

        System.out.println("What is your first word?");
        String wordOne = myScanner.next();

        System.out.println("\nWhat is your second word input?");
        String wordTwo = myScanner.next();

        String equals= (Objects.equals(wordOne, wordTwo) ? "The words are Equal": "The Words are Not Equal");

        System.out.println(equals);
    }
}
