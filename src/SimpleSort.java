public class SimpleSort{

    public static void printArray(int[] myArray){
        for (int i = 0; i < myArray.length; i++){
            StdOut.printf("%d\t", myArray[i]);
        }
        StdOut.println();
    }

    // Calculates lg(n).
    public static double log2(double N)
    {

        // calculate log2 N indirectly
        // using log() method
        double result = Math.log(N) / Math.log(2);

        return result;
    }
    public static void main(String[] args) {
        int[] myArray = {3, 1, 2, 4 };
        StdOut.println("Unsorted");
        printArray(myArray);
        simpleSort(myArray);
        StdOut.println("Sorted");
        printArray(myArray);

        int n = 256;
        double runtime = timeTrial(n);
        StdOut.printf("Took %f seconds to sort an array of size %d", runtime, n);
    }

    public static double timeTrial(int n){
        Stopwatch watch = new Stopwatch();
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++){
            randomArray[i] = StdRandom.uniformInt(-1000, 1001);
        }
        simpleSort(randomArray);

        return watch.elapsedTime();
    }
    public static void simpleSort(int[] myArray){
        int temp;
        for(int i = 0; i < myArray.length-1; i++){
            for(int j = i + 1; j < myArray.length; j++){
                if (myArray[i] > myArray[j]){
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }
}
