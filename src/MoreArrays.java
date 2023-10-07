public class MoreArrays {
    public static void main(String[] args) {

      /*  int n;

        n = args.length == 1 ? Integer.parseInt(args[0]) : 5;


        //declaration
        int[] myArray;

        myArray = new int[n]; //makes arrays size the size of n

        for ( int i = 0; i <myArray.length; i++) {

            myArray[i] = 1; // assigning a value to the index value of i, which in this case is just 1

            //printing out the value of i
            System.out.println(myArray[i]);
        }

        // int[] array = new int[n];

       */

        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] cardDeck = new String[suits.length + values.length];

        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for (int j = 0; j <values.length; j++){

                String value = values[j];
                String card = value + " of " + suit;

                cardDeck[i * values.length + j] = card;


            }


        }
        for ( int i = 0; i < cardDeck.length; i ++) {
            System.out.println(cardDeck[i]);
        }

    }
}
