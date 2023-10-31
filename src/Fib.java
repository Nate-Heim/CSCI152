public class Fib{


    public static long FibiBottomUp(int n){ // Bottom up dynamic programming.
        long[] answers = new long[n+1]; // n+1 to account for 0th fib.
        answers[0] = 0;
        answers[1] = 1;

        for(int i = 2; i <= n; i++){
            answers[i] = answers[i - 1] + answers[i - 2];
        }

        return answers[n];
    }

    public static long Fibi(long n){
        // Base case(s).
        if (n == 0) return 0;

        if (n == 1) return 1;
        // Reduction Step.

        return Fibi(n-1) + Fibi(n-2);
        // Fibi(n) = Fibi(n-1) + Fibi(n-2)
    }
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(Fibi(n));
    }
}
