import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class diceRolls {

    public static void main(String[] args) {
        int cpuDiceRoll, userDiceRoll;

        String header = "______ _           ______      _ _     \n" +
                "|  _  (_)          | ___ \\    | | |    \n" +
                "| | | |_  ___ ___  | |_/ /___ | | |___ \n" +
                "| | | | |/ __/ _ \\ |    // _ \\| | / __|\n" +
                "| |/ /| | (_|  __/ | |\\ \\ (_) | | \\__ \\\n" +
                "|___/ |_|\\___\\___| \\_| \\_\\___/|_|_|___/\n" +
                "                                       \n" +
                "                                      ";

        //Art by R. Shawn Butler https://www.asciiart.eu/miscellaneous/dice
        String art = "   _______\n" +
                "  /\\ o o o\\\n" +
                " /o \\ o o o\\_______\n" +
                "<    >------>   o /|\n" +
                " \\ o/  o   /_____/o|\n" +
                "  \\/______/     |oo|\n" +
                "        |   o   |o/\n" +
                "        |_______|/";


        Random rand = new Random();

        Scanner myScanner = new Scanner(System.in);
        System.out.println(art);
        System.out.println(header);

        System.out.println("How many times do you want to win before you stop playing this time?");
        int winCap = myScanner.nextInt();
        if (winCap <=0){

            boolean notCorrectNum = true;
            while(winCap <=0) {
                System.out.println("That is an incorrect number, please enter a positive whole integer.");

                winCap = myScanner.nextInt();
            }

        }
        int winTotal = 0;
        int timesPlayed = 0; //setting a counter for amount played

        double winPercentage = 0.00d;

        int playerTotal = 0; //setting the player total number here
        int computerTotal = 0; //setting the cpu's total



        boolean isPlaying = true;
        while (isPlaying){

            int userAmt = 0; //setting a counter for the die amount
            int cpuAmt = 0; //setting the computers counter here



            for(int die = 0; die <2; die++) {
                userDiceRoll = rand.nextInt(5); //getting a random number here between 0-5
                userDiceRoll += 1; //adding one to keep in range of an actual die
                //System.out.println(userDiceRoll); //testing purposes
                userAmt += userDiceRoll;
            }
            for(int die = 0; die <2; die++) {

                cpuDiceRoll = rand.nextInt(5); //getting a random number here between 0-5
                cpuDiceRoll += 1; //adding one to keep in range of an actual die

                cpuAmt += cpuDiceRoll;

            }
            System.out.println("* * * * * * * * * * * * *\n");
            System.out.println("You rolled a " + userAmt + ".");
            System.out.println("\n* * * * * * * * * * * * * \n");
            System.out.println("The computer rolled a " + cpuAmt + ".");
            System.out.println("\n* * * * * * * * * * * * * \n");
            timesPlayed ++;
            playerTotal += userAmt; //calculating total for games
            computerTotal += cpuAmt; //calculating total for games

            if (userAmt > cpuAmt) {
                winTotal ++;
                if (winTotal == winCap) {

                    System.out.println("\nDo You want to play again? (y/n)");
                    String userAnswer = myScanner.next();
                    //checking the continue playing example
                    if (Objects.equals(userAnswer, "n")) {
                        isPlaying = false;
                        System.out.println("\t-----------------------\t");
                        System.out.println("\t  Thanks for playing.");
                        System.out.println("\t-----------------------\t");
                        System.out.println("\t  You played " + timesPlayed + " rounds.");
                        System.out.println("\t-----------------------\t");
                        winPercentage = (double) winTotal / timesPlayed;
                        float pAmt = (float) (winPercentage * 100.0f); //just to give numbers to make it look better

                        System.out.println("You won " + pAmt + "% of the time.");
                        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                        System.out.println("\t Your total roll amount over all your games was " + playerTotal + ".");
                        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                        System.out.println("The computers total was " + computerTotal + ".");
                        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                        if(playerTotal > computerTotal){
                            playerTotal -= computerTotal;
                            System.out.println("You won and rolled more then the computer by " + playerTotal + "!");
                        }
                        else{
                            computerTotal -= playerTotal;
                            System.out.println("Overall the computer rolled more then you by " + computerTotal + ".\nBetter luck next time.");
                        }

                        break;

                    }
                    else {
                        System.out.println("How many times do you want to win before you stop playing this time?");
                        winCap = myScanner.nextInt();
                        continue;
                    }
                }
            }


        }
    }
}