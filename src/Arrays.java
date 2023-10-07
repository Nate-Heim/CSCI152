public class Arrays {

    public static void main(String[] args) {
    /*
        int length = Integer.parseInt(args[0]);

        //3 steps to an array

        //declaration
        int[] myArray;

        // Assignment statement
        myArray = new int[length];


        //Array value initialization
        for (int i =0; i < myArray.length; i++) {

            //[0] [0] [0] [0] [0]
            myArray[i] =1;


            System.out.println(myArray[i]);
        }
        */

        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] cardValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};


        int cardDeckSize = suits.length * cardValues.length;

        String[] cardDeck = new String[cardDeckSize];



        for (int i =0; i < suits.length; i ++) {

            String suit = suits[i]; //grabbing the suit here

            for (int j = 0; j < cardValues.length; j++) {
               //i =0
               //j ->0 ->12
                String cardValue = cardValues[j];
                String card = cardValue + " of " + suit;

                cardDeck[(cardValues.length * i + j)] = card;
            }
        }


        for (int i = 0; i < cardDeck.length; i++) {
            System.out.println(cardDeck[i]);
        }
    }
}
