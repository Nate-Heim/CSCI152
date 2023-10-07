public class binary {
    public static void main(String[] args) {
        //explicit casting
        int number = Integer.parseInt(args[0]);

        int originalNumber = number;


        int numberOfPositionsNeeded = 0;
        while (number > 0) {
            numberOfPositionsNeeded ++;
            number /=2;

        }

        System.out.println("Number of positions needed: " + numberOfPositionsNeeded);

    }
}
