import java.util.Random;

public class ArrayHelper {

    private int[] myArray; //annoying errors if I don't make this here so its private ie stuck to this client.

    public int indexOf(int i) {
        for (int index = 0; index < myArray.length; index++) {
            if (myArray[index] == i) {
                return index;
            }
        }
        return -1;
    }
    public int[] concat(int[] arrayToConcatenate) {
        int[] result = new int[myArray.length + arrayToConcatenate.length];
        System.arraycopy(myArray, 0, result, 0, myArray.length);
        System.arraycopy(arrayToConcatenate, 0, result, myArray.length, arrayToConcatenate.length);
        return result;
    }

    public double avg() {
        int sum = 0;
        for (int value : myArray) {
            sum += value;
        }
        return (double) sum / myArray.length;
    }

    public int max() {
        int maxVal = Integer.MIN_VALUE; //setting the base case to the minimum value allowed for an integer here
        for (int value : myArray) {
            if (value > maxVal) {
                maxVal = value;
            }
        }
        return maxVal;
    }

    public int min() {
        int minVal = Integer.MAX_VALUE; //same as maxVal setting it to the very maximum allowed value
        for (int value : myArray) {
            if (value < minVal) {
                minVal = value;
            }
        }
        return minVal;
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = myArray.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = myArray[i];
            myArray[i] = myArray[j];
            myArray[j] = temp;
        }
    }

    public void print() {
        for (int i = 0; i < myArray.length; i++) {
            StdOut.print(myArray[i]);
            if (i < myArray.length - 1) {
                StdOut.print("\t");
            }
        }
        StdOut.println(); //wanted a clear space afterwards just to clean the code up.
    }

    public static int[] initialize(int n, int initialValue) {
        int[] result = new int[n];
        return result;
    }

    public static int[] flatten(int[][] my2DArray) {
        int totalLength = 0;
        for (int[] row : my2DArray) {
            totalLength += row.length;
        }

        int[] flattenedArray = new int[totalLength];
        int index = 0;
        for (int[] row : my2DArray) {
            System.arraycopy(row, 0, flattenedArray, index, row.length);
            index += row.length;
        }

        return flattenedArray;
    }

    public static void main(String[] args) {
        // Sample usage of the functions
        int[] arrayHelper = {1, 2, 3, 4, 5};


        System.out.println("Index of 3: " + arrayHelper.indexOf(3));
        System.out.println("Average: " + arrayHelper.avg());
        System.out.println("Max: " + arrayHelper.max());
        System.out.println("Min: " + arrayHelper.min());

        arrayHelper.shuffle();
        System.out.print("Shuffled array: ");
        arrayHelper.print();

        int[] arrayToConcatenate = {6, 7, 8};
        int[] concatenated = arrayHelper.concat(arrayToConcatenate);
        System.out.print("Concatenated array: ");
        for (int num : concatenated) {
            System.out.print(num + "\t");
        }
        System.out.println();

        int n = 5;
        int initialValue = 10;
        int[] initializedArray = initialize(n, initialValue);
        System.out.print("Initialized array: ");
        for (int num : initializedArray) {
            System.out.print(num + "\t");
        }
        System.out.println();

        int[][] my2DArray = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        int[] flattenedArray = flatten(my2DArray);
        System.out.print("Flattened array: ");
        for (int num : flattenedArray) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}
