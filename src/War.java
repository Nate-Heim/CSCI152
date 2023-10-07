//Nate Heim
import java.util.Objects;
import java.util.Scanner;
public class War {
    public static void main(String[] args) {
            // art from https://www.asciiart.eu/computers
        String art = "                                     )\n" +
                "                            )      ((     (\n" +
                "                           (        ))     )\n" +
                "                    )       )      //     (\n" +
                "               _   (        __    (     ~->>\n" +
                "        ,-----' |__,_~~___<'__`)-~__--__-~->> <\n" +
                "        | //  : | -__   ~__ o)____)),__ - '> >-  >\n" +
                "        | //  : |- \\_ \\ -\\_\\ -\\ \\ \\ ~\\_  \\ ->> - ,  >>\n" +
                "        | //  : |_~_\\ -\\__\\ \\~'\\ \\ \\, \\__ . -<-  >>\n" +
                "        `-----._| `  -__`-- - ~~ -- ` --~> >\n" +
                "         _/___\\_    //)_`//  | ||]\n" +
                "   _____[_______]_[~~-_ (.L_/  ||\n" +
                "  [____________________]' `\\_,/'/\n" +
                "    ||| /          |||  ,___,'./\n" +
                "    ||| \\          |||,'______|\n" +
                "    ||| /          /|| I==||\n" +
                "    ||| \\       __/_||  __||__\n" +
                "-----||-/------`-._/||-o--o---o---\n" +
                "  ~~~~~'";

        String header = "      ::::::::      :::       :::   :::   ::::::::::           ::::::::  ::::::::::         :::       :::     :::     :::::::::            ::::::::       ::::::: \n" +
                "    :+:    :+:   :+: :+:    :+:+: :+:+:  :+:                 :+:    :+: :+:                :+:       :+:   :+: :+:   :+:    :+:          :+:    :+:     :+:   :+: \n" +
                "   +:+         +:+   +:+  +:+ +:+:+ +:+ +:+                 +:+    +:+ +:+                +:+       +:+  +:+   +:+  +:+    +:+                +:+      +:+   +:+  \n" +
                "  :#:        +#++:++#++: +#+  +:+  +#+ +#++:++#            +#+    +:+ :#::+::#           +#+  +:+  +#+ +#++:++#++: +#++:++#:               +#+        +#+   +:+   \n" +
                " +#+   +#+# +#+     +#+ +#+       +#+ +#+                 +#+    +#+ +#+                +#+ +#+#+ +#+ +#+     +#+ +#+    +#+            +#+          +#+   +#+    \n" +
                "#+#    #+# #+#     #+# #+#       #+# #+#                 #+#    #+# #+#                 #+#+# #+#+#  #+#     #+# #+#    #+#           #+#       #+# #+#   #+#     \n" +
                "########  ###     ### ###       ### ##########           ########  ###                  ###   ###   ###     ### ###    ###          ########## ###  #######      ";

        System.out.println(header);
        System.out.println("\n\n");
        System.out.println(art);

        //grabbing CMD arg and setting the scanner up here
        int numberofGames = Integer.parseInt(args[0]);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("You have challenged the worlds evilest computer to a Game of War (Hint: Its Skynet).\nAre you ready? (y/n)");
        String startInput = myScanner.next(); //honestly this isn't necessary but I want it there
        while(!Objects.equals(startInput, "y")){
            System.out.println("\nToo Bad. You have challenged them, its too late.");
            System.out.println("\nAre you ready now?");
            startInput = myScanner.next();
        }

        //initial values for suits and ranks
        String[] suits = {"Spades","Clubs", "Hearts","Diamonds"}; //ascending order of worst to best
        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        String[] cardDeck = new String[suits.length * rank.length];
        int[][] cardDeckValue = new int[cardDeck.length][2];

        //accessing these specific indices to change
        int cardValueIndex = 0; int suitValueIndex = 1;

        for (int i = 0; i < suits.length; i++){
            String suit = suits[i];
            for (int j = 0; j < rank.length; j++){
                String cardString = rank[j];
                String card = cardString + " of " + suit;
                cardDeck[i * rank.length + j] = card;
                int[] decks = cardDeckValue[i * rank.length + j];
                decks[cardValueIndex] = j;
                decks[suitValueIndex] = i;
            }
        }

        int playerWins = 0; int cpuWins = 0; //win counter

        for (int gameNumber = 0; gameNumber < numberofGames; gameNumber++){
            int[] playerDeck = new int[cardDeck.length];
            int[] cpuDeck = new int[cardDeck.length];

            for (int i = 0; i < cardDeck.length; i++){
                //this is from class and actually really helped Fisher-Yates Shuffle method to swap indices around
                double r = Math.random();
                int n = cardDeck.length;
                int randomIndex = (int)(r * n);
                String tempCard = cardDeck[randomIndex];
                int[] tempCardValue = cardDeckValue[randomIndex];
                cardDeck[randomIndex] = cardDeck[i];
                cardDeckValue[randomIndex] = cardDeckValue[i];
                cardDeck[i] = tempCard;
                cardDeckValue[i] = tempCardValue;
            }

            boolean playerPlaysFirst = (int)(Math.random() * 2) == 1;

            int cardNumber = 0;
            for (int i = 0; i < cardDeck.length; i+=2){

                int playerCard = playerPlaysFirst ? 0 : 1; //ternary op to see if player goes first
                int cpuCard = playerPlaysFirst ? 1 : 0; // ^^ ^^ ^^ if false cpu goes
                playerDeck[cardNumber] = i + playerCard;
                cpuDeck[cardNumber] = i + cpuCard;
                cardNumber += 1;
            }
            //2 players thus dividing by 2
            int playerCards = cardDeck.length / 2;
            int cpuCards = cardDeck.length / 2;
            int turnCounter = 0;
            //setting player card/value variables
            int playerCard;
            int playerValue;
            //setting cpus card/value
            int cpuCard;
            int cpuValue;
            do{
                //initial card and deck going to the indicies
                playerCard = playerDeck[0];
                cpuCard = cpuDeck[0];
                playerValue = cardDeckValue[playerCard][0];
                cpuValue = cardDeckValue[cpuCard][0];

                //bread and butter of the whole game here, this is to determine the winner
                boolean isPlayerWinner = playerValue > cpuValue;
                boolean isCpuWinner = playerValue < cpuValue;

                //movement of cards to proper indices
                for (int i = 1; i < playerCards; i++){
                    playerDeck[i-1] = playerDeck[i];
                }
                for (int i = 1; i < cpuCards; i++){
                    cpuDeck[i-1] = cpuDeck[i];
                }

                //sorting the cards here
                if (isPlayerWinner){
                    //when the player wins
                    playerDeck[playerCards-1] = playerCard; //taking the card out
                    playerDeck[playerCards++] = cpuCard;    //adding in the cpu's card to deck
                    cpuDeck[--cpuCards] = 0;
                }
                else if (isCpuWinner){
                    //When the computer wins
                    cpuDeck[cpuCards-1] = cpuCard; //taking the card out
                    cpuDeck[cpuCards++] = playerCard; //adding the players card to deck
                    playerDeck[--playerCards] = 0;
                }
                else{
                    //Tiebreaker
                    playerValue = cardDeckValue[playerCard][suitValueIndex];
                    cpuValue = cardDeckValue[cpuCard][suitValueIndex];

                    if (playerValue > cpuValue){
                        playerDeck[playerCards-1] = playerCard;
                        playerDeck[playerCards++] = cpuCard;

                        cpuDeck[--cpuCards] = 0;
                    }
                    else if(playerValue < cpuValue){
                        cpuDeck[cpuCards-1] = cpuCard;
                        cpuDeck[cpuCards++] = playerCard;

                        playerDeck[--playerCards] = 0;
                    }
                }

                turnCounter += 1;
            }
            while ((playerCards != 0) && (playerCards != cardDeck.length) && (cpuCards != 0) && cpuCards != cardDeck.length);

            playerWins += playerCards > cpuCards ? 1 : 0;
            cpuWins += cpuCards > playerCards ? 1 : 0;

            System.out.println("\nGame " + (gameNumber + 1) + " took " + turnCounter + " turns.\n");
            String result = playerCards > cpuCards ? "won" : "lost";
            System.out.println("You " + result + " this game.\n");

            if (numberofGames-1 != gameNumber){
                System.out.println("\nPlay again? (y/n)");
                String userInput = myScanner.next();
                if (userInput.equals("n")){
                    break;
                }
            }
        }

        System.out.println("You've played the Game of War\n");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("Final Total: \nPlayer Win Total: " + playerWins + "\nCpu Win Total: " + cpuWins);
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        if ( playerWins > cpuWins){
            System.out.println("You have defeated the computer, good going.....again watch out for Arnold"); //this is for amusement purposes
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
        else{
            System.out.println("You played terribly and lost horrifically! Good job dooming Humanity....John Conner is disappointed in you"); //still amusement
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        }
    }
}