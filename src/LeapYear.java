//Nate Heim

public class LeapYear {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        boolean isLeapYear;

        //making the yes or no statements here
        String affirmation = "Yes, " + year + " is a leap year.";
        String denial = "No, " + year + " is not a leap year";

        // Doing the first step here of being divisible by 4
        isLeapYear = (year % 4 == 0);

        // Another factor here making sure the year is divisible by 4 and not 100
        isLeapYear = isLeapYear && (year % 100 != 0);

        // Final check to check if the year is divisible by 4 and not 100. With the section unless divisible by 400
        isLeapYear = isLeapYear || (year % 400 == 0);

        //using a conditional here to output the correct choice

        if (isLeapYear) {
            System.out.println(affirmation);
        }
        else {
            System.out.println(denial);
        }

    }
}
