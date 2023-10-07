public class test {

    public static void main(String[] args) {

        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suit = {"\u2663", "\u2666", "\u2665", "\u2660"};
        String[] deck = new String[52];

        for (int j= 0; j <suit.length; j++) {

            for(int i =0;  i < rank.length; i++){
                deck[i + 13 * j] = rank[i] + " of " + suit[j];
            }


        }

        for (int t = 0; t < deck.length; t++) {
            System.out.println(deck[t]);
        }
    }
}
