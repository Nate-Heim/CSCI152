public class RaggedArrays {

    public static void main(String[] args) {

        int numberOfRows = Integer.parseInt(args[0]);


        //1D array
        int[] regularArray = new int[numberOfRows];

        //2D array
        int[][] regularArray2d = new int[numberOfRows][numberOfRows];

        int[][] raggedArrays = new int[numberOfRows][];

        for (int i = 0; i <raggedArrays.length; i ++){
            double r = Math.random();
            int n = 11;
            int randomSize = (int) (n*r) + 1;

            raggedArrays[i] = new int[randomSize];
        }

        for (int i = 0; i < raggedArrays.length; i++) {
            int[] column = raggedArrays[i];

            System.out.println(column);
        }


    }
}
