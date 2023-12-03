public class WarLib{

    final static String[] suits = {"spades","clubs", "hearts","diamonds"}; //ascending order of worst to best
    final static String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    public static boolean playerTurn = false;

    static String[] master_deck = new String[52];
    static{
        for(int i = 0; i < suits.length; i++){

            for(int j = 0; j < rank.length; j++){
                master_deck[i* rank.length + j] = rank[j]+"_of_"+suits[i];
            }
        }

    }
    public static int[] DeckPointer(){

        String[] cardDeck = new String[suits.length * rank.length];
        int[][] cardDeckValue = new int[cardDeck.length][2];
        int[] decks= new int[52];

        //accessing these specific indices to change
        int cardValueIndex = 0; int suitValueIndex = 1;

        for (int i = 0; i < suits.length; i++){
            String suit = suits[i];
            for (int j = 0; j < rank.length; j++){
                String cardString = rank[j];
                String card = cardString + " of " + suit;
                cardDeck[i * rank.length + j] = card;
                decks[i * rank.length + j] = (i * rank.length + j) +1; //adding 1 here to get cards above 0 for check
            }
        }
        return decks;
    }
    public static int getValue(int card){
        String cardAsString =master_deck[card-1];
        char cardValueAsChar = cardAsString.charAt(0);
        int cardValue;
        switch (cardValueAsChar){
            case 'J':
                cardValue = 11;
                break;
            case 'Q':
                cardValue = 12;
                break;
            case'K':
                cardValue = 13;
                break;
            case 'A':
                cardValue=14;
                break;
            default:
                cardValue=Integer.valueOf(cardValueAsChar);
        }

        return cardValue;
    }

    public static int getLength(int[] cardDeck){
        //Kyle helped me set up this to fix some errors I was getting with shuffling the deck
        int size= cardDeck.length;
        int indexOfFirstValue = 0;

        for(int i=0; i<size;i++){
            if(cardDeck[i]>0){
                indexOfFirstValue++;
            }
        }
        return indexOfFirstValue;
    }


    /*
    Description:

    This is the Fischer Yates Shuffle method. Itterates through deck in reverse order
    selecting random index between 0 and the current index value(inclusive). Swaps those
    values, modifying the original cardDeck in place.
     */
    public static void DeckShuffle(int[] cardDeck){
        int randomIndex, temp;
        int size= getLength(cardDeck) - 1;

        //This to to actually shuffle the 'cards'

        if(size >=1) {
            for (int i = size; i >= 0; i--) {
                randomIndex = (int) Math.floor((Math.random() * i)) + 1;
                temp = cardDeck[randomIndex];
                cardDeck[randomIndex] = cardDeck[i];
                cardDeck[i] = temp;
            }
        }
    }

    public static int pullCard(int[] cardDeck){
        //to pull the card and get the indice of it
        int indexOfFirstCard = getLength(cardDeck) -1;
        int card = cardDeck[indexOfFirstCard];
        cardDeck[indexOfFirstCard] = 0;
        DeckShuffle(cardDeck);
        return card;
    }

    public static void putCard(int[] cardDeck, int card){
        //to put the card back in the deck and
        int indexOfFirstCard = getLength(cardDeck);
        cardDeck[indexOfFirstCard] = card;
        DeckShuffle(cardDeck);
    }


    // True if player wins
    public static boolean compareCard(int playerCard, int cpuCard){

        int playerValue = getValue(playerCard);
        int cpuValue = getValue(cpuCard);

        boolean winner = playerValue > cpuValue;
        playerTurn = winner;
        return winner;
    }


/*    public static void returnCard(int[] testDeck,int playerDeck, int cpuDeck){
        putCard(testDeck, playerDeck);
        putCard(testDeck, cpuDeck);
    }*/

    public static void main(String[] args) {
        int[] testDeck= DeckPointer();
        DeckShuffle(testDeck);
        for(int i=0; i < testDeck.length; i++) {
            System.out.println(testDeck[i]);
        }


    }
}
