import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int N = userNum; // Number of Fibonacci terms to compute
        int num1 = 0;
        int num2 = 1;

        Scanner in = new Scanner(System.in);

        System.out.println("input number: ");
        userNum = in.nextInt();

        System.out.println("Fibonacci series up to " + N + ": ");
        for (int i = 0; i < N; i++) {
            System.out.print(num1 + " ");
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }
}
