public class DoWhile{

    public static void main(String[] args) {

        double r = Math.random();
        int n = 11;
        int offset = 1;
        int randomNumber = (int)(r * n) + offset;
        /*

        int milesRun = 0;
        double runningThreshold = 26.2;
        do{ // explain how this statement executes i.e. the control flow of a do while loop.
            milesRun += randomNumber;
            System.out.println("Running " + randomNumber + " today.");
        }
        while(milesRun <= runningThreshold);

        //Extend DoWhile.java (from class today) to print out the number entered into the command line as
        // 2^x + r where x is the number of powers of 2 in the number and r is the remainder.

        System.out.println("I ran " + milesRun);
        */


        //honestly the whole program was not built for this so I had to write everything here
        int entryNumber = Integer.parseInt(args[0]);

        double remainder = (double) entryNumber % 2;

        double equation = Math.pow(2, (entryNumber + remainder));

        System.out.println(equation);
    }
}

