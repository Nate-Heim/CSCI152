//Nate Heim

import java.util.Random;
import java.util.Scanner;

public class GameOfWar {


    public static void main(String[] args) {

        Scanner myScanner= new Scanner(System.in);

        //header and art designed on https://www.asciiart.eu/text-to-ascii-art

        String art = "////////////////////////////////////////////////////////////////////////////////////\n" +
                "// _______ _______ _______ _______    _______ _______            _______ _______  //\n" +
                "//(  ____ (  ___  (       (  ____ \\  (  ___  (  ____ \\  |\\     /(  ___  (  ____ ) //\n" +
                "//| (    \\| (   ) | () () | (    \\/  | (   ) | (    \\/  | )   ( | (   ) | (    )| //\n" +
                "//| |     | (___) | || || | (__      | |   | | (__      | | _ | | (___) | (____)| //\n" +
                "//| | ____|  ___  | |(_)| |  __)     | |   | |  __)     | |( )| |  ___  |     __) //\n" +
                "//| | \\_  | (   ) | |   | | (        | |   | | (        | || || | (   ) | (\\ (    //\n" +
                "//| (___) | )   ( | )   ( | (____/\\  | (___) | )        | () () | )   ( | ) \\ \\__ //\n" +
                "//(_______|/     \\|/     \\(_______/  (_______|/         (_______|/     \\|/   \\__/ //\n" +
                "////////////////////////////////////////////////////////////////////////////////////";

        String header = "\n\n.------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------.\n" +
                "|db    db  .d88b.  db    db      db   db  .d8b.  db    db d88888b       .o88b. db   db  .d8b.  db      db      d88888b d8b   db  d888b  d88888b d8888b.                                    |\n" +
                "|`8b  d8' .8P  Y8. 88    88      88   88 d8' `8b 88    88 88'          d8P  Y8 88   88 d8' `8b 88      88      88'     888o  88 88' Y8b 88'     88  `8D                                    |\n" +
                "| `8bd8'  88    88 88    88      88ooo88 88ooo88 Y8    8P 88ooooo      8P      88ooo88 88ooo88 88      88      88ooooo 88V8o 88 88      88ooooo 88   88                                    |\n" +
                "|   88    88    88 88    88      88~~~88 88~~~88 `8b  d8' 88~~~~~      8b      88~~~88 88~~~88 88      88      88~~~~~ 88 V8o88 88  ooo 88~~~~~ 88   88                                    |\n" +
                "|   88    `8b  d8' 88b  d88      88   88 88   88  `8bd8'  88.          Y8b  d8 88   88 88   88 88booo. 88booo. 88.     88  V888 88. ~8~ 88.     88  .8D                                    |\n" +
                "|   YP     `Y88P'  ~Y8888P'      YP   YP YP   YP    YP    Y88888P       `Y88P' YP   YP YP   YP Y88888P Y88888P Y88888P VP   V8P  Y888P  Y88888P Y8888D'                                    |\n" +
                "|                                                                                                                                                                                          |\n" +
                "|                                                                                                                                                                                          |\n" +
                "|.d8888. db   dD db    db d8b   db d88888b d888888b      d888888b  .d88b.        .d8b.        d888b   .d8b.  .88b  d88. d88888b       .d88b.  d88888b      db   d8b   db  .d8b.  d8888b. db|\n" +
                "|88'  YP 88 ,8P' `8b  d8' 888o  88 88'     `~~88~~'      `~~88~~' .8P  Y8.      d8' `8b      88' Y8b d8' `8b 88'YbdP`88 88'          .8P  Y8. 88'          88   I8I   88 d8' `8b 88  `8D 88|\n" +
                "|`8bo.   88,8P    `8bd8'  88V8o 88 88ooooo    88            88    88    88      88ooo88      88      88ooo88 88  88  88 88ooooo      88    88 88ooo        88   I8I   88 88ooo88 88oobY' YP|\n" +
                "|  `Y8b. 88`8b      88    88 V8o88 88~~~~~    88            88    88    88      88~~~88      88  ooo 88~~~88 88  88  88 88~~~~~      88    88 88~~~        Y8   I8I   88 88~~~88 88`8b     |\n" +
                "|db   8D 88 `88.    88    88  V888 88.        88            88    `8b  d8'      88   88      88. ~8~ 88   88 88  88  88 88.          `8b  d8' 88           `8b d8'8b d8' 88   88 88 `88. db|\n" +
                "|`8888Y' YP   YD    YP    VP   V8P Y88888P    YP            YP     `Y88P'       YP   YP       Y888P  YP   YP YP  YP  YP Y88888P       `Y88P'  YP            `8b8' `8d8'  YP   YP 88   YD YP|\n" +
                "|                                                                                                                                                                                          |\n" +
                "|                                                                                                                                                                                          |\n" +
                "|db   d8b   db db   db  .d88b.       .d8888. db   db  .d8b.  db      db           d8888b. d88888b      d888888b db   db d88888b      d88888b d888888b d8b   db  .d8b.  db                  |\n" +
                "|88   I8I   88 88   88 .8P  Y8.      88'  YP 88   88 d8' `8b 88      88           88  `8D 88'          `~~88~~' 88   88 88'          88'       `88'   888o  88 d8' `8b 88                  |\n" +
                "|88   I8I   88 88ooo88 88    88      `8bo.   88ooo88 88ooo88 88      88           88oooY' 88ooooo         88    88ooo88 88ooooo      88ooo      88    88V8o 88 88ooo88 88                  |\n" +
                "|Y8   I8I   88 88~~~88 88    88        `Y8b. 88~~~88 88~~~88 88      88           88~~~b. 88~~~~~         88    88~~~88 88~~~~~      88~~~      88    88 V8o88 88~~~88 88                  |\n" +
                "|`8b d8'8b d8' 88   88 `8b  d8'      db   8D 88   88 88   88 88booo. 88booo.      88   8D 88.             88    88   88 88.          88        .88.   88  V888 88   88 88booo.             |\n" +
                "| `8b8' `8d8'  YP   YP  `Y88P'       `8888Y' YP   YP YP   YP Y88888P Y88888P      Y8888P' Y88888P         YP    YP   YP Y88888P      YP      Y888888P VP   V8P YP   YP Y88888P             |\n" +
                "|                                                                                                                                                                                          |\n" +
                "|                                                                                                                                                                                          |\n" +
                "|db    db d888888b  .o88b. d888888b  .d88b.  d8888b. .d888b.                                                                                                                               |\n" +
                "|88    88   `88'   d8P  Y8 `~~88~~' .8P  Y8. 88  `8D VP  `8D                                                                                                                               |\n" +
                "|Y8    8P    88    8P         88    88    88 88oobY'    odD'                                                                                                                               |\n" +
                "|`8b  d8'    88    8b         88    88    88 88`8b     8P'                                                                                                                                 |\n" +
                "| `8bd8'    .88.   Y8b  d8    88    `8b  d8' 88 `88.   oo                                                                                                                                  |\n" +
                "|   YP    Y888888P  `Y88P'    YP     `Y88P'  88   YD   VP                                                                                                                                  |\n" +
                "'------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'";

        /* just to make the game more interesting looking */
        System.out.println(art);

        System.out.println(header);

        while (true) {
            System.out.print("Are you ready: ");
            String userInput = myScanner.nextLine();

            if (!userInput.isEmpty()) {
                // User entered something, break out of the loop
                System.out.println("You entered: " + userInput);
                break;
            }

            System.out.println("You didn't enter anything. Please try again.");
        }

        // Close the scanner when done
        myScanner.close();





        Random random = new Random(); //setting random variable here
        /*
        Setting both the pc's cards and user's cards amount to 26 here
         */
        int playerCard = 26;
        int skynetCard = 26;

        int turns = 0; //counter for turns

        do {
            //values to be inclusive from 1-13 instead of 0-12 with the +1,
            int playersCardValue = random.nextInt(13) + 1;
            int skynetCardValue = random.nextInt(13) + 1;

           // System.out.println("Turn " + (turns + 1) + ": You have " + playersCardValue + ", Skynet has " + skynetCardValue); //more test purposes comment out

            if (playersCardValue > skynetCardValue) {
                playerCard++; //adding to the value because otherwise this can cause an error with both running out of
                // cards if no ties occur
                skynetCard--; //see above comment
                //System.out.println("You won this round."); //its a game so it looks ugly with no prints
            } else if (skynetCardValue > playersCardValue) {
                skynetCard++;
                playerCard--;
               // System.out.println("Skynet won this round."); //round winner testing purposes
            } else { //case for tiebreaker
                int playerSum = 0;
                int skynetSum = 0;
                for (int i = 0; i < 3; i++) {
                    playerSum += random.nextInt(13) + 1;
                    skynetSum += random.nextInt(13) + 1;
                }

               // System.out.println("You tied with Skynet. Its time for a Tie-breaking round!"); test purposes to check if there was an actual tie breaker
               // System.out.println("Tiebreaker - Your sum is : " + playerSum + ", Skynet's sum is: " + skynetSum);

                if (playerSum > skynetSum) {
                    playerCard += 3;
                    skynetCard -= 3;
                   // System.out.println("You won the tiebreaker.");
                } else if (skynetSum > playerSum) {
                    skynetCard += 3;
                    playerCard -= 3;
                   // System.out.println("Skynet won the tiebreaker.");
                } else {
                   // System.out.println("You tied again with Skynet. :("); //variable on the off chance you tie yet again
                }
            }

            turns++; //counter update
        }
        while (playerCard > 0 && skynetCard > 0); //loop conditional for game

        // Determine the winner using a switch statement. PPS I HATE THIS SWITCH CASE FOR USING THIS since it can only
        //run with one variable type ie string int float etc. I had to think on this for a long time
        String winner = switch (Integer.compare(playerCard, skynetCard)) {
            case -1 -> "Skynet";
            case 1 -> "You";
            default -> "It's a tie, thus no wins";
        };

        if (winner.equals("Skynet")){
            System.out.println(winner + " have won this game in " + turns + " turns. Humanity is doomed, good job.");
        }
        else if (winner.equals("You")) {
            System.out.println(winner + " have won this game in " + turns + " turns. You have saved Humanity, congrats" +
                    ". You should watch out for Arnold coming for you. :P");
        }
        else{
            System.out.println("No one won this game. Mayhap humanity shall forever be stuck in this eternal loop for " +
                    "supremecy. ");
        }

    }
}


