import java.awt.*;

public class WarUI {

    static{
        StdDraw.setScale(-1,1);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(Color.GREEN);
    }


    static int[] playerDeck = new int[52];
    static int[] cpuDeck = new int[52];
    static int[] initalDeck = WarLib.DeckPointer();
    static String victor= "";

//Clubs, diamonds, hearts, spades ascending order
    public static void drawCard(int card, int otherCard){
        String cardPath = "./war-assets/"+WarLib.master_deck[card-1]+".png";
        String otherCardPath = "./war-assets/"+WarLib.master_deck[otherCard-1]+".png";

        StdDraw.picture(.25,.7,cardPath, .35, .5);
        StdDraw.picture(.75,.7,otherCardPath, .35, .5);


        animate();
    }

    public static void drawBacks(int playerDeckSize, int cpuDeckSize){


        String mDeck= "./war-assets/mDeck.png";
        StdDraw.picture(-.5,.5,mDeck, .35,.5);
        StdDraw.picture(-.5,0,mDeck, .35,.5);
        StdDraw.text(-.5,.5,String.valueOf(cpuDeckSize));
        StdDraw.text(-.5,.8,"Cpu Deck");
        StdDraw.text(-.5,0,String.valueOf(playerDeckSize));
        StdDraw.text(-.5,-.7, "Player Deck");
        animate();
    }

    public static void drawWinner(String winner){
        String winnerText = winner + " Wins!";
        StdDraw.text(0,0,winnerText);
        animate();
    }

    public static void animate(){
        StdDraw.pause(1);
        StdDraw.show();

    }




    public static void main(String[] args) {

        String winner;

        WarLib.DeckShuffle(initalDeck);
        // inital deal
        for(int i = 0; i < 52; i++){
            if(i%2==0)WarLib.putCard(playerDeck, WarLib.pullCard(initalDeck));
            else WarLib.putCard(cpuDeck,WarLib.pullCard(initalDeck));
        }
        while(true){
            int playerHand = WarLib.pullCard(playerDeck);
            int cpuHand = WarLib.pullCard(cpuDeck);

            int playerLength = WarLib.getLength(playerDeck);
            int cpuLength = WarLib.getLength(cpuDeck);



            if (cpuLength == 0){
                winner = "Player";
                break;
            }
            if(playerLength == 0){
                winner = "CPU";

                break;

            }

            drawCard(playerHand,cpuHand);
            drawBacks(playerLength,cpuLength);


            if(WarLib.compareCard(playerHand,cpuHand)){
                WarLib.putCard(playerDeck,playerHand);
                WarLib.putCard(playerDeck,cpuHand);
            }else{
                WarLib.putCard(cpuDeck,playerHand);
                WarLib.putCard(cpuDeck,cpuHand);
            }
        }
        drawBacks(0,52);
        drawWinner(winner);



    }
}
