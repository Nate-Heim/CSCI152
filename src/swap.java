//Nate Heim


public class swap
{
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = a;
        a=b; b=c;
        System.out.println("A is: " + a);
        System.out.println("B is: " + b);

    }
}
