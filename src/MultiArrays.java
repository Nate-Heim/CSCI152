public class MultiArrays {

    public static void main(String[] args) {

        if (args.length == 2) {

            int rows = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);

            int[][] arrayA = new int[rows][cols];
            int[][] arrayB = new int[rows][cols];

            int[][] arraySum = new int[rows][cols];


            for( int i = 0; i <arrayA[i].length; i++){

                for( int j = 0;  j <arrayA[i].length; j++ ){
                    arrayA[i][j] = 1;
                    arrayB[i][j] = 3;


                }
                System.out.println();
            }

            for (int i = 0; i <arrayA.length; i++) {
                for (int j = 0; j <arrayA[i].length; j++){
                    arraySum[i][j] = arrayA[i][j] + arrayB[i][j];
                }
            }



            // [{[][]}][{[][]}]
        }
    }
}
