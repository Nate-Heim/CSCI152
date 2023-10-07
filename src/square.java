public class square {
    public static void main(String[] args) {


        //ascii art source: https://www.asciiart.eu/art-and-design/geometries
        String art = " ._____A_____,\n" +
                " |`          :\\\n" +
                " | `         : B\n" +
                " |  `        :  \\\n" +
                " C   +-----A-----+\n" +
                " |   :       :   :\n" +
                " |__ : _A____:   :\n" +
                " `   :        \\  :\n" +
                "  `  :         B :\n" +
                "   ` :          \\:\n" +
                "    `:_____A_____>";


        //creating ASCII text here
        String header = "     ___      .______       _______     ___           ______    _______         ___              _______.  ______      __    __       ___      .______       _______ \n" +
                "    /   \\     |   _  \\     |   ____|   /   \\         /  __  \\  |   ____|       /   \\            /       | /  __  \\    |  |  |  |     /   \\     |   _  \\     |   ____|\n" +
                "   /  ^  \\    |  |_)  |    |  |__     /  ^  \\       |  |  |  | |  |__         /  ^  \\          |   (----`|  |  |  |   |  |  |  |    /  ^  \\    |  |_)  |    |  |__   \n" +
                "  /  /_\\  \\   |      /     |   __|   /  /_\\  \\      |  |  |  | |   __|       /  /_\\  \\          \\   \\    |  |  |  |   |  |  |  |   /  /_\\  \\   |      /     |   __|  \n" +
                " /  _____  \\  |  |\\  \\----.|  |____ /  _____  \\     |  `--'  | |  |         /  _____  \\     .----)   |   |  `--'  '--.|  `--'  |  /  _____  \\  |  |\\  \\----.|  |____ \n" +
                "/__/     \\__\\ | _| `._____||_______/__/     \\__\\     \\______/  |__|        /__/     \\__\\    |_______/     \\_____\\_____\\\\______/  /__/     \\__\\ | _| `._____||_______|\n" +
                "                                                                                                                                                                    ";

        int sideOfSquare = Integer.parseInt(args[0]); //grabbing CMD line arg here and assigning it

        int areaOfSquare = (int) Math.pow(sideOfSquare, 2); //calculating area of a square using Math.pow


        System.out.println(art + "\n\n"); //printing out ascii art to give nice visual
        System.out.println(header); //printing out ascii header here

        System.out.println("\n\nThe area of the square is " + areaOfSquare + ".\n\n"); //printing area

        String graphic =""; //initializing the string here, has to have a value because errors are thrown otherwise

        for(int i =0; i < sideOfSquare; graphic += "* ") { //adding the * to graphic here using the sideOfSquare

            i ++;
        }
        for(int i2 = 0; i2 < sideOfSquare; i2++){
            System.out.println("\t" + graphic); //printing out the graphical representation of the area here

        }
        System.out.println("\n\n");
    }
}
